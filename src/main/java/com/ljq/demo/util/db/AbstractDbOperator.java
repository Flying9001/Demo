package com.ljq.demo.util.db;

import com.ljq.demo.bean.Column;
import com.ljq.demo.bean.Table;
import com.ljq.demo.constant.DbTypeConst;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description: 数据库操作工具类
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
public abstract class AbstractDbOperator {

    protected JdbcTemplate jdbcTemplate;


    private AbstractDbOperator(){}

    public AbstractDbOperator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 获取数据库类型
     *
     * @return
     */
    public String getDbType() throws SQLException {
        String dbTypeName = this.jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName();
        switch (dbTypeName) {
            case DbTypeConst.MYSQL:
                return DbTypeConst.MYSQL;
            case DbTypeConst.ORACLE:
                return DbTypeConst.ORACLE;
            case DbTypeConst.SQL_SERVER:
                return DbTypeConst.SQL_SERVER;
            default:
                return DbTypeConst.UNKNOWN;
        }
    }

    /**
     * 查询数据库表名,模糊查询
     *
     * @param tableName 数据库表名
     * @return
     */
    public abstract Map<String, String> getTableNames(String tableName);

    /**
     * 获取数据库视图名称,模糊查询
     *
     * @param viewName 视图名称
     * @return
     */
    public abstract List<String> getViewNames(String viewName);

    /**
     * 获取视图信息
     *
     * @param viewName 视图名称
     * @return
     * @throws Exception
     */
    public abstract Table<Column> getView(String viewName) throws Exception;

    /**
     * 获取数据库表信息
     *
     * @param tableName 表名
     * @return
     * @throws Exception
     */
    public abstract Table<Column> getTable(String tableName) throws Exception;

    /**
     * 判断表是否支持分区
     *
     * @param tableName
     * @return
     */
    public abstract boolean supportPartition(String tableName);

    /**
     * 判断是否存在分区
     *
     * @param tableName
     * @param partName
     * @return
     */
    public abstract boolean isExistPartition(String tableName, String partName);

    /**
     * 创建分区
     *
     * @param tableName
     * @param partName
     */
    public abstract void createPartition(String tableName, String partName);











}
