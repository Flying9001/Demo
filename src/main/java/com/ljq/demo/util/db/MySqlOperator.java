package com.ljq.demo.util.db;

import com.ljq.demo.bean.Column;
import com.ljq.demo.bean.Table;
import com.ljq.demo.constant.DbTypeConst;
import com.ljq.demo.enums.ColumnType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: MySQL数据库操作类
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
public class MySqlOperator extends AbstractDbOperator {


    public MySqlOperator(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    /**
     * 获取数据库类型
     *
     * @return
     */
    @Override
    public String getDbType() throws SQLException {
        return DbTypeConst.MYSQL;
    }

    /**
     * 查询数据库表名,模糊查询
     *
     * @param tableName 数据库表名
     * @return
     */
    @Override
    public Map<String, String> getTableNames(String tableName) {
        String sql = "select table_name,table_comment from information_schema.tables t where t.table_type='BASE TABLE' AND t.table_schema=DATABASE()";
        List<Map<String, Object>> list;
        if (StringUtils.isNotEmpty(tableName)) {
            sql += " AND TABLE_NAME LIKE ?";
            list = jdbcTemplate.queryForList(sql, "%" + tableName + "%");
        } else {
            list = jdbcTemplate.queryForList(sql);
        }
        Map<String, String> map = new LinkedHashMap<>();
        for (Map<String, Object> m : list) {
            map.put(m.get("table_name").toString(), m.getOrDefault("table_comment", "").toString());
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
        String sql = "show table status where comment='view'";
        if (StringUtils.isNotEmpty(viewName)) {
            sql += " AND NAME LIKE ?";
        }
        List<String> list = new ArrayList<>();
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql, "%" + viewName + "%");
        for (Map<String, Object> line : results) {
            list.add(line.get("Name").toString());
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
    public Table<Column> getView(String viewName) throws Exception {
        Table<Column> table = new Table<>();
        List<String> viewNames = getViewNames(viewName);
        if (viewNames.isEmpty()) {
            return null;
        }
        table.setName(viewName);
        table.setComment(viewName);
        table.setColumnList(getColumns(viewName));
        return table;
    }

    /**
     * 获取数据库表信息
     *
     * @param tableName 表名
     * @return
     */
    @Override
    public Table<Column> getTable(String tableName) throws Exception{
        Table<Column> table = new Table<>();
        Map<String, String> tableNames = getTableNames(tableName);
        if (tableNames.isEmpty()) {
            return null;
        }
        table.setName(tableName);
        table.setComment(tableNames.get(tableName));
        table.setColumnList(getColumns(tableName));
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
        String sql = "select count(*) from information_schema.partitions where table_name=?;";
        Integer rtn = jdbcTemplate.queryForObject(sql, Integer.class, tableName);
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
        String sql = "select count(*) from information_schema.partitions where table_name=? and partition_name =?;";
        String[] args = new String[2];
        args[0] = tableName;
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
        String sql = "alter table " + tableName + " add partition (partition P_" + partName.toUpperCase() + " values in ('" + partName + "')) ";
        jdbcTemplate.execute(sql);
    }

    /**
     * 根据数据库表读取字段列表
     *
     * @param tableName
     * @return
     */
    private List<Column> getColumns(String tableName) throws Exception {
        String sql = "SELECT * FROM  INFORMATION_SCHEMA.COLUMNS  WHERE TABLE_SCHEMA=DATABASE() AND TABLE_NAME=?";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, tableName);
        List<Column> columns = new ArrayList<>();
        for (Map<String, Object> map : list) {
            Column column = new Column();
            column.setComment(map.getOrDefault("COLUMN_COMMENT", "").toString());
            column.setDefaultValue(map.get("COLUMN_DEFAULT") == null ? null : map.get("COLUMN_DEFAULT").toString());
            column.setName(map.getOrDefault("COLUMN_NAME", "").toString());
            column.setPrimary("PRI".equals(map.getOrDefault("COLUMN_KEY", "")));
            column.setRequired("NO".equals(map.getOrDefault("IS_NULLABLE", "")));
            column.setType(ColumnType.getByDbDataType(map.get("DATA_TYPE").toString(),column.getName()).getKey());
            if (ColumnType.VARCHAR.getKey().equals(column.getType())) {
                column.setLength(Integer.parseInt(map.getOrDefault("CHARACTER_MAXIMUM_LENGTH", "0").toString()));
            }
            if (ColumnType.NUMBER.getKey().equals(column.getType())) {
                column.setLength(Integer.parseInt(map.getOrDefault("NUMERIC_PRECISION", "0").toString()));
                column.setDecimal(Integer.parseInt(map.getOrDefault("NUMERIC_SCALE", "0").toString()));
            }
            columns.add(column);
        }
        return columns;
    }


}
