package com.itheima.weixin;

import com.github.wxpay.sdk.WXPayUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*****
 * @Author: www.itheima.com
 * @Description: com.itheima.weixin
 * 微信SDK相关测试
 ****/
public class WeixinUtilTest {


    /***
     * 1.生成随机字符
     * 2.将Map转成XML字符串
     * 3.将Map转成XML字符串，并且生成签名
     * 4.将XML字符串转成Map
     */
    @Test
    public void testDemo() throws Exception {
        //随机字符串
        String str = WXPayUtil.generateNonceStr();
        System.out.println("随机字符串："+str);

        //将Map转成XML字符串
        Map<String,String> dataMap = new HashMap<String,String>();
        dataMap.put("id","No.001");
        dataMap.put("title","畅购商城杯具支付");
        dataMap.put("money","998");
        String xmlstr = WXPayUtil.mapToXml(dataMap);
        System.out.println("XML字符串：\n"+xmlstr);

        //将Map转成XML字符串，并且生成签名
        String signerxmlStr = WXPayUtil.generateSignedXml(dataMap, "itcast");
        System.out.println("XML字符串带有签名：\n"+signerxmlStr);

        //将XML字符串转成Map
        Map<String, String> mapResult = WXPayUtil.xmlToMap(signerxmlStr);
        System.out.println("XML转成Map:\n"+mapResult);
    }
}
