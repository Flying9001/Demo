package com.ljq.demo.util;

import org.junit.Test;

public class SqlCheckUtilTest {

    @Test
    public void getSafeSQL() throws Exception {

        String[] sqls = {"update_time", "insert_user", "update t_user set id = 0","select * from t_user", "aa'bb",""};
        for (int i = 0; i < sqls.length; i++) {
            System.out.println("sql-" + i + ": " + SqlCheckUtil.getSafeSQL(sqls[i]));
        }
        StringBuilder sql = new StringBuilder();
        int length = 1024 * 1025;
        for (int j = 0; j < length; j++) {
            sql.append("a");
        }
        System.out.println("result: " + SqlCheckUtil.getSafeSQL(sql.toString()));


    }
}