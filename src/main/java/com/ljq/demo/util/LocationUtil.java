package com.ljq.demo.util;

import cn.hutool.core.io.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalCoordinates;
import org.lionsoul.ip2region.*;

import java.io.IOException;

/**
 * @Description: 位置定位工具类
 * @Author: junqiang.lu
 * @Date: 2021/9/18
 */
@Slf4j
public class LocationUtil {

    private static final String dbRelativePath = "/ip2region.db";

    private static byte[] dbData = null;

    static {
        dbData = IoUtil.readBytes(LocationUtil.class.getResourceAsStream(dbRelativePath));
    }

    /**
     * 通过经纬度计算两点之间距离
     *
     * @param lng1 点 1 经度
     * @param lat1 点 1 纬度
     * @param lng2 点 2 经度
     * @param lat2 点 2 纬度
     * @return
     */
    public static int getDistance(String lng1, String lat1, String lng2, String lat2) {
        GlobalCoordinates point1 = new GlobalCoordinates(Double.parseDouble(lat1), Double.parseDouble(lng1));
        GlobalCoordinates point2 = new GlobalCoordinates(Double.parseDouble(lat2), Double.parseDouble(lng2));
        return (int) (new GeodeticCalculator().calculateGeodeticCurve(Ellipsoid.WGS84, point1, point2)
                .getEllipsoidalDistance());
    }

    /**
     * 根据 ip 获取地里位置
     * @param ip
     * @return
     * @throws DbMakerConfigException
     * @throws IOException
     */
    public static String getRegionFromIp(String ip) throws DbMakerConfigException, IOException {
        DbSearcher searcher = new DbSearcher(new DbConfig(), dbData);
        String region = null;
        if (Util.isIpAddress(ip)) {
            DataBlock dataBlock = searcher.memorySearch(ip);
            region = dataBlock.getRegion();
            return region;
        }
        return null;
    }



}
