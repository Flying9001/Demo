package com.ljq.demo.util;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.sql.SQLException;

public class DataSourceUtilTest {

    /**
     * 测试批量插入大量文章
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    public void insertArticle() throws SQLException, ClassNotFoundException {
        /**
         * 计划插入数据条数为 1 000 010 条
         * 实际插入条数为 1 000 000 条
         * 这一程序主要用于快速插入巨量数据,至于没有精确计算零头,
         * 主要是为了方便理解程序
         */

        // 需要插入数据的总条数
        int countTotal = 1000010;
        // 每次插入数据的条数
        int countLimit = 5000;
        // 插入数据的次数
        int countPage = countTotal / countLimit;
        String title = "将进酒";
        String content = "君不见黄河之水天上来，奔流到海不复回。" +
                "君不见高堂明镜悲白发，朝如青丝暮成雪。" +
                "人生得意须尽欢，莫使金樽空对月。" +
                "天生我材必有用，千金散尽还复来。" +
                "烹羊宰牛且为乐，会须一饮三百杯。" +
                "岑夫子，丹丘生，将进酒，杯莫停。" +
                "与君歌一曲，请君为我侧耳听。" +
                "钟鼓馔玉不足贵，但愿长醉不复醒。" +
                "古来圣贤皆寂寞，惟有饮者留其名。" +
                "陈王昔时宴平乐，斗酒十千恣欢谑。" +
                "主人何为言少钱，径须沽取对君酌。" +
                "五花马，千金裘，" +
                "呼儿将出换美酒，与尔同销万古愁。";
        for (int j = 0; j < countPage; j++) {
            StringBuilder builder = new StringBuilder();
            builder.append("INSERT INTO `article`(`title`, `content`) VALUES");
            for (int i = 0; i < countLimit - 1; i++) {
                builder.append("('" + title + "','" + content + "'),");
            }
            builder.append("('" + title + "','" + content + "');");
            DataSourceUtil.insert(builder.toString());
            System.out.println("累计插入条数: " + countLimit * (j + 1));
        }
    }

    /**
     * 测试批量插入文章-标签关联信息
     */
    @Test
    public void insertArticleToTag() throws SQLException, ClassNotFoundException {
        /**
         * 计划插入数据条数为 1 155 013 条
         * 实际插入数据条数为 1 155 013 条
         * 该程序为精确插入数据条数,将零头也计算在内
         */

        // 数据总条数
        int countTotal = 1155013;
        // 每次插入条数
        int countLimit = 5000;
        // 数据插入次数
        int countPage = countTotal / countLimit;
        for (int i = 0; i < countPage; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("INSERT INTO `article_to_tag`(`article_id`, `tag_id`) VALUES");
            for (int j = 0; j < countLimit - 1; j++) {
                int articleId = countLimit * i + j + 1;
                builder.append("(" + articleId + "," + RandomUtils.nextInt(1,8) + "),");
            }
            builder.append("(" + countLimit * (i + 1) + "," + RandomUtils.nextInt(1,8) + ")");
            DataSourceUtil.insert(builder.toString());
            System.out.println("累计插入条数: " + countLimit * (i + 1));
        }
        int remainder = countTotal % countLimit;
        if (remainder < 1) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO `article_to_tag`(`article_id`, `tag_id`) VALUES");
        for (int i = 0; i < remainder - 1; i++) {
            int articleId = countLimit * countPage + i + 1;
            builder.append("(" + articleId + "," + RandomUtils.nextInt(1, 8) + "),");
        }
        builder.append("(" + countTotal + "," + RandomUtils.nextInt(1, 8) + ");");
        DataSourceUtil.insert(builder.toString());
        System.out.println("累计插入条数: " + countTotal);

    }


    /**
     * 测试随机数
     */
    @Test
    public void randomTest(){
        /**
         * RandomUtils.nextInt(1,8) 方法
         * 输出的值是  1 <= X < 8
         * 注意: 不包括 8
         */

        int count = 50;
        for (int i = 0; i < count; i++) {
            System.out.println(RandomUtils.nextInt(1,8));
        }

    }
}