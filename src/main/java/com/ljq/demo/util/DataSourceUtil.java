package com.ljq.demo.util;

import java.sql.*;

/**
 * @Description: 数据库连接工具
 * @Author: junqiang.lu
 * @Date: 2019/11/26
 */
public class DataSourceUtil {

    /**
     * 数据库驱动类
     */
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    /**
     * 数据库连接地址
     */
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:13306/demo?useUnicode=true&" +
            "characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" +
            "serverTimezone=GMT%2B8&useSSL=true&allowMultiQueries=true&autoReconnect=true";
    /**
     * 数据库连接用户名
     */
    private static final String DB_USER_NAME = "root";
    /**
     * 数据库连接密码
     */
    private static final String DB_PASSWORD = "root";
    /**
     * 数据库连接
     */
    private static volatile Connection connection;

    private DataSourceUtil(){
    }


    /**
     * 插入(可批量)
     *
     * @param sql
     * @return
     * @throws SQLException
     */
    public static int insert(String sql) throws SQLException, ClassNotFoundException {
        init();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeUpdate();
    }

    /**
     * 初始化数据库连接
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static Connection init() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            synchronized (DataSourceUtil.class) {
                if (connection == null) {
                    Class.forName(DRIVER_CLASS);
                    connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
                }
            }
        }
        return connection;
    }

}
