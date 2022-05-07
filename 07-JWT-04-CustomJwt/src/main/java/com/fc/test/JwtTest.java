package com.fc.test;

import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JwtTest {
    @Test
    public void testGetToken() {
        HashMap<String, Object> claim = new HashMap<>();

        claim.put("username", "易烊千玺");

        String token = JwtUtil.getToken(claim, "yyqx");

        System.out.println(token);
    }

    @Test
    public void testVerifyToken() {
        Map<String, Object> result = JwtUtil.verify("eyJhbGciOiAiSFMyNTYifQ==.eyJleHAiOjE2NDkyOTE2NDM3MjgsImlhdCI6MTY0OTI5MTYyMzcyOCwidXNlcm5hbWUiOiLmmJPng4rljYPnjroifQ==.5202b1516770d7d4290b222ac8981cc4", "yyqx");

        Set<Map.Entry<String, Object>> entries = result.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
