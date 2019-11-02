package com.changgou.pay.service;

import java.util.Map;

/*****
 * @Author: www.itheima.com
 * @Description: com.changgou.pay.service
 ****/
public interface WeixinPayService {

    /***
     * 查询微信支付状态
     */
    Map queryStatus(String outtradeno);

    /***
     * 创建二维码操作
     */
    Map createnative(Map<String,String> parameterMap);


}
