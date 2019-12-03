package com.ljq.demo.util;

import com.auth0.jwt.exceptions.JWTCreationException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class JwtUtilTest {

    @Test
    public void encode() throws JWTCreationException  {
        String secret = RandomStringUtils.randomAlphanumeric(32).toUpperCase();
        String key = "phone";
        String value = "18666666666";
        long expTime = 1000 * 60 * 1;

        System.out.println("secret: " + secret);

        String token1 = JwtUtil.encode(key, value);
        System.out.println("token1: " + token1);

        String token2 = JwtUtil.encode(key, value, expTime);
        System.out.println("token2: " + token2);

        String token3 = JwtUtil.encode(secret,key,value,expTime);
        System.out.println("Token3: " + token3);
    }

    @Test
    public void decode() throws JWTCreationException {
        String secret = "ERNAMQPTNYRSKD5WY7L9VKZVNM6RUQ1L";
        String key = "phone";
        String token1 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE4NjY2NjY2NjY2IiwiaXNzIjoiYXV0aDAifQ.IXebib54PeHHoSR6Lglu5uKz9Rr2M_BI02aAZ_PjxnM";
        String token2 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE4NjY2NjY2NjY2IiwiaXNzIjoiYXV0aDAiLCJleHAiOjE1NzUzNTM2NTV9.UygiHKlIZfiPnE-Jp-Nm-5WWMThSCgetkTyEg_E3fW0";
        String token3 = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwaG9uZSI6IjE4NjY2NjY2NjY2IiwiaXNzIjoiYXV0aDAiLCJleHAiOjE1NzUzNTM2NTV9.catoS5PSNTrUURef4iJdlxmOvkcTOECwQ5PRTElfY6k";

        String value1 = JwtUtil.decode(key,token1);
        System.out.println("value1: " + value1);

        String value2 = JwtUtil.decode(key,token2);
        System.out.println("value2: " + value2);

        String value3 = JwtUtil.decode(secret,key,token3);
        System.out.println("value3: " + value3);

    }

}