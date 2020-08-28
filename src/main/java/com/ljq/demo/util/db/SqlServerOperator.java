package com.ljq.demo.util.db;

import com.ljq.demo.bean.Column;
import com.ljq.demo.bean.Table;
import com.ljq.demo.constant.DbTypeConst;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description: Sql Server 操作类
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
public class SqlServerOperator extends AbstractDbOperator{

    // TODO 具体实现

    public SqlServerOperator(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public String getDbType() throws SQLException {
        return DbTypeConst.SQL_SERVER;
    }

    @Override
    public Map<String, String> getTableNames(String tableName) {
        return null;
    }

    @Override
    public List<String> getViewNames(String viewName) {
        return null;
    }

    @Override
    public Table<Column> getView(String viewName) throws Exception{
        return null;
    }

    @Override
    public Table<Column> getTable(String tableName) throws Exception{
        return null;
    }

    @Override
    public boolean supportPartition(String tableName) {
        return false;
    }

    @Override
    public boolean isExistPartition(String tableName, String partName) {
        return false;
    }

    @Override
    public void createPartition(String tableName, String partName) {

    }
}
