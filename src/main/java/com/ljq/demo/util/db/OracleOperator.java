package com.ljq.demo.util.db;

import com.ljq.demo.bean.Column;
import com.ljq.demo.bean.Table;
import com.ljq.demo.constant.DbTypeConst;
import com.ljq.demo.enums.ColumnType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.*;

/**
 * @Description: Oracle 数据库操作类
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
public class OracleOperator extends AbstractDbOperator {

    public OracleOperator(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * 获取数据库类型
     *
     * @return
     */
    @Override
    public String getDbType() throws SQLException {
        return DbTypeConst.ORACLE;
    }

    /**
     * 查询数据库表名,模糊查询
     *
     * @param tableName 数据库表名
     * @return
     */
    @Override
    public Map<String, String> getTableNames(String tableName) {
        String sql = "select t.table_name,f.comments from user_tables t inner join user_tab_comments f on t.table_name = f.table_name";
        List<Map<String, Object>> list;
        if (StringUtils.isNotEmpty(tableName)) {
            sql += " AND t.table_name LIKE ?";
            list = jdbcTemplate.queryForList(sql, "%" + tableName.toUpperCase() + "%");
        } else {
            list = jdbcTemplate.queryForList(sql);
        }
        Map<String, String> map = new LinkedHashMap<>();
        for (Map<String, Object> m : list) {
            map.put(m.get("table_name").toString(), m.getOrDefault("comments", "").toString());
        }

        return map;
    }

    /**
     * 获取数据库视图名称,模糊查询
     *
     * @param viewName 视图名称
     * @return
     */
    @Override
    public List<String> getViewNames(String viewName) {
        String sql = "SELECT * FROM USER_VIEWS ";
        if (StringUtils.isNotEmpty(viewName)) {
            sql += " WHERE VIEW_NAME LIKE ?";
        }
        List<String> list = new ArrayList<>();
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, "%" + viewName.toUpperCase() + "%");
        for (Map<String, Object> line : results) {
            list.add(line.get("VIEW_NAME").toString());
        }
        return list;
    }

    /**
     * 获取视图信息
     *
     * @param viewName 视图名称
     * @return
     * @throws Exception
     */
    @Override
    public Table<Column> getView(String viewName) throws Exception{
        Table<Column> table = new Table<>();
        List<String> viewNames = getViewNames(viewName);
        if (viewNames.isEmpty()) {
            return null;
        }
        table.setName(viewName.toUpperCase());
        table.setComment(viewName.toUpperCase());
        table.setColumnList(getColumns(viewName.toUpperCase()));
        return table;
    }

    /**
     * 获取数据库表信息
     *
     * @param tableName 表名
     * @return
     * @throws Exception
     */
    @Override
    public Table<Column> getTable(String tableName) throws Exception{
        Table<Column> table = new Table<>();
        Map<String, String> tableNames = getTableNames(tableName.toUpperCase());
        if (tableNames.isEmpty()) {
            return null;
        }
        table.setName(tableName.toUpperCase());
        table.setComment(tableNames.get(tableName.toUpperCase()));
        table.setColumnList(getColumns(tableName.toUpperCase()));

        return table;
    }

    /**
     * 判断表是否支持分区
     *
     * @param tableName
     * @return
     */
    @Override
    public boolean supportPartition(String tableName) {
        String sql = "select count(*) from user_tab_partitions where table_name = ?";
        Integer rtn = jdbcTemplate.queryForObject(sql, Integer.class, tableName.toUpperCase());
        return rtn > 0;
    }

    /**
     * 判断是否存在分区
     *
     * @param tableName
     * @param partName
     * @return
     */
    @Override
    public boolean isExistPartition(String tableName, String partName) {
        String sql = "select count(*) from user_tab_partitions where table_name = ? and partition_name = ?";
        String[] args = new String[2];
        args[0] = tableName.toUpperCase();
        args[1] = "P_" + partName.toUpperCase();
        Integer rtn = jdbcTemplate.queryForObject(sql, args, Integer.class);
        return rtn > 0;
    }

    /**
     * 创建分区
     *
     * @param tableName
     * @param partName
     */
    @Override
    public void createPartition(String tableName, String partName) {
        String sql = "ALTER TABLE " + tableName.toUpperCase() + " ADD PARTITION P_" + partName.toUpperCase() + " VALUES ( '" + partName + "') NOCOMPRESS ";
        jdbcTemplate.update(sql);
    }

    /**
     * 根据数据库表读取字段列表
     *
     * @param tableName
     * @return
     */
    private List<Column> getColumns(String tableName) throws Exception {
        // 先找到主键
        String sqlT = "select col.column_name from user_constraints con,user_cons_columns col where " +
                "con.constraint_name=col.constraint_name and con.constraint_type='P' and col.table_name= ?";
        List<Map<String, Object>> listT = jdbcTemplate.queryForList(sqlT, tableName.toUpperCase());
        Set<String> pkNames = new HashSet<>();
        for (Map<String, Object> map : listT) {
            pkNames.add(map.getOrDefault("COLUMN_NAME", "").toString());
        }
        // 开始解析字段信息
        String sql = "select a.*,b.comments from user_tab_columns a inner join user_col_comments b " +
                "on a.table_name = b.table_name and a.column_name = b.column_name and a.table_name = ? ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, tableName.toUpperCase());
        List<Column> columns = new ArrayList<>();
        for (Map<String, Object> map : list) {
            Column column = new Column();
            column.setComment(map.getOrDefault("COMMENTS", "").toString());
            Object defVal = map.get("DATA_DEFAULT");
            if (defVal != null && !defVal.toString().trim().equals("NULL")) {
                column.setDefaultValue(map.get("DATA_DEFAULT").toString());
            }
            column.setName(map.getOrDefault("COLUMN_NAME", "").toString());
            column.setPrimary(pkNames.contains(column.getName().toUpperCase()));
            column.setRequired("N".equals(map.getOrDefault("NULLABLE", "Y")));
            column.setType(ColumnType.getByDbDataType(map.get("DATA_TYPE").toString(), column.getComment()).getKey());

            if (ColumnType.VARCHAR.getKey().equals(column.getType())) {
                column.setLength(Integer.parseInt(map.getOrDefault("DATA_LENGTH", "0").toString()));
            }
            if (ColumnType.NUMBER.getKey().equals(column.getType())) {
                column.setLength(Integer.parseInt(map.getOrDefault("DATA_PRECISION", "0").toString()));
                column.setDecimal(Integer.parseInt(map.getOrDefault("DATA_SCALE", "0").toString()));
            }
            columns.add(column);
        }
        return columns;
    }

}
