package com.ljq.demo.util;

import org.junit.Test;
import org.lionsoul.ip2region.DbMakerConfigException;

import java.io.IOException;

public class LocationUtilTest {

    @Test
    public void getDistance() {
        String lng1 = "23.123834";
        String lat1 = "113.25752";
        String lng2 = "22.492707";
        String lat2 = "113.906514";

        int distance = LocationUtil.getDistance(lng1, lat1, lng2, lat2);
        System.out.println("距离: " + distance);

    }

    @Test
    public void getRegionFromIp() throws IOException, DbMakerConfigException {
        String[] ipArr = {"58.250.250.254", "204.124.181.253", "192.168.11.12", "127.0.0.1"};
        for (int i = 0; i < ipArr.length; i++) {
            System.out.println("------------------" + ipArr[i] + "----------------------------");
            System.out.println(LocationUtil.getRegionFromIp(ipArr[i]));
        }
        int count = 100000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            LocationUtil.getRegionFromIp(ipArr[1]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时: " + (endTime - startTime) + " ms");

    }

    @Test
    public void generateRandomIp() throws IOException, DbMakerConfigException {
        int count = 10;
        for (int i = 0; i < count; i++) {
            String ip = IpUtil.generateRandomIp();
            String region = LocationUtil.getRegionFromIp(ip);
            System.out.println("ip: " + ip + ", region: " + region);
        }

    }
}