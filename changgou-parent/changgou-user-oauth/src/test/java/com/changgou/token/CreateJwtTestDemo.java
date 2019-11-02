package com.changgou.token;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/*****
 * @Author: www.itheima.com
 * @Description: com.changgou.token
 * 令牌的创建和解析
 ****/
public class CreateJwtTestDemo {

    /***
     * 创建令牌
     */
    @Test
    public void testCreateToken(){
        //加载证书  读取类路径中的文件
        ClassPathResource resource = new ClassPathResource("changgou68.jks");

        //读取证书数据,加载读取证书数据
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource,"changgou68".toCharArray());

        //获取证书中的一对秘钥
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("changgou68","changgou68".toCharArray());

        //获取私钥->RSA算法
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        //创建令牌，需要私钥加盐[RSA算法]
        Map<String,Object> payload = new HashMap<String,Object>();
        payload.put("nikename","tomcat");
        payload.put("address","sz");
        payload.put("authorities",new String[]{"admin","oauth"});

        Jwt jwt = JwtHelper.encode(JSON.toJSONString(payload), new RsaSigner(privateKey));

        //获取令牌数据
        String token = jwt.getEncoded();
        System.out.println(token);
    }

    /***
     * 解析令牌
     */
    @Test
    public void testParseToken(){
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZGRyZXNzIjoic3oiLCJuaWtlbmFtZSI6InRvbWNhdCIsImF1dGhvcml0aWVzIjpbImFkbWluIiwib2F1dGgiXX0.LmnE-lx2QENT7XlyYPCBMPR02qFNlumj1ln65vVZ66PX8RPuvEvVrl0gL3iwMmtfwtDxLAo7Ambfw9r9UlJKFlb3-mS7O0A9ikgf4A6iwFJmPxX3uwQEPrcwFs5IbQGfFw4bWoe2Sa6iGEQ-iP32RuJxdLVg65dXnoqlgao9zZ_x3YSXR9aOZL1aeeQHibsSEgLxIzi1fgovqakqNQ5groRwcS3wm7LSaRO121gT6FmXhV9lIqAQdvksDIEPSDylzyEIH-CuRyFaAp89l46YNT7V985D6-l6MTfi4E78KfxGY9LeZhnRKRpvWvpU5fMgKOB6HGkhxmFh2xdYkjnJ_w";
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlAeFAVHFcQbJVyJWVIPP1MvQxDfbwFeO4HZFzYWi/k7AhSYGADWc5kdphrWlquHxV98K+W4uXPOcy/d+eUrcGci5LgDFQZHVAACDA5NBdv0kP3z3p825jT9fc/+XUhWAsE/vmCvk+igs+xm0pVh7oEuj4v9yTY5SLIBypIh3NvUr+E8AXNGhl3FGVq/R2wTAgveXa0VArmQ/MlwLkI4OJ0BFGe5o/aQycW3L4oIb3jHt0aAYMEL0E8RPmiW7T6eP5J5/pJFxjcERD1m1qQ2tvwk5B/5YyKDO+T+VN5LGO6Kgs1Mu0kGTua+zIBw3xAWi83Sx6sD19WsIvIXuOzZH0wIDAQAB-----END PUBLIC KEY-----";
        Jwt jwt = JwtHelper.decodeAndVerify(token,
                new RsaVerifier(publickey)
        );
        String claims = jwt.getClaims();
        System.out.println(claims);

    }
}
