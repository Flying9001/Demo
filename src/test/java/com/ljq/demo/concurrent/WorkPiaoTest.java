package com.ljq.demo.concurrent;

import org.junit.Test;

public class WorkPiaoTest {

    @Test
    public void piaoTest() {
        int countPiao = 200;
        WorkPiao workPiao = new WorkPiao(countPiao);
        for (int i = 0; i < 5; i++) {
            new Thread(workPiao, "同步窗口" + (i + 1)).start();
        }
    }

}