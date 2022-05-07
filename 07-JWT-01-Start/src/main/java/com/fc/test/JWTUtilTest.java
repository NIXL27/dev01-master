package com.fc.test;

import com.auth0.jwt.interfaces.Claim;
import com.fc.util.JwtUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JWTUtilTest {
    @Test
    public void testCreate() {
        Map<String, Object> claim = new HashMap<>();

        claim.put("id", 1);
        claim.put("username", "马卡巴卡");

        String token = JwtUtil.createToken(claim, System.currentTimeMillis() + 1000 * 30);

        System.out.println(token);
    }

    @Test
    public void testParse() {
        Map<String, Object> claim = JwtUtil.getClaim("eyJ0eXAiOiJKV1QiLCJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJjbGFpbSI6eyJpZCI6MSwidXNlcm5hbWUiOiLpqazljaHlt7TljaEifSwiZXhwIjoxNjQ5MTIxNDk2fQ.piS_bowZzZrMwBnMF-07AtB8jGOwXggqUXQ7vizf1wU");

        Set<Map.Entry<String, Object>> entries = claim.entrySet();

        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
