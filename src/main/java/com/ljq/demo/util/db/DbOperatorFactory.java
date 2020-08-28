package com.ljq.demo.util.db;

import com.ljq.demo.constant.DbTypeConst;
import com.ljq.demo.util.SpringBeanUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.sql.SQLException;

/**
 * @Description: 数据库操作器工厂类
 * @Author: junqiang.lu
 * @Date: 2020/7/30
 */
public class DbOperatorFactory {

    private DbOperatorFactory() {}

    /**
     * 创建数据库操作类
     *
     * @param dbType 数据库类型
     * @param jdbcTemplate jdbc 实例
     * @return
     */
    public static AbstractDbOperator create(String dbType, JdbcTemplate jdbcTemplate) {
        if (StringUtils.isEmpty(dbType)) {
            return null;
        }
       switch (dbType.toLowerCase()) {
           case DbTypeConst.MYSQL:
               return new MySqlOperator(jdbcTemplate);
           case DbTypeConst.ORACLE:
               return new OracleOperator(jdbcTemplate);
           case DbTypeConst.SQL_SERVER:
               return new SqlServerOperator(jdbcTemplate);
           default:
               break;
       }
        return null;
    }

    /**
     * 创建数据库操作类,依据本地数据源
     *
     * @return
     */
    public static AbstractDbOperator createByLocal() {
        JdbcTemplate jdbcTemplate = SpringBeanUtil.getBean(JdbcTemplate.class);
        try {
            String dbTypeName = jdbcTemplate.getDataSource().getConnection().getMetaData().getDatabaseProductName();
            switch (dbTypeName) {
                case DbTypeConst.MYSQL:
                    return new MySqlOperator(jdbcTemplate);
                case DbTypeConst.ORACLE:
                    return new OracleOperator(jdbcTemplate);
                case DbTypeConst.SQL_SERVER:
                    return new SqlServerOperator(jdbcTemplate);
                default:
                    return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }



}
