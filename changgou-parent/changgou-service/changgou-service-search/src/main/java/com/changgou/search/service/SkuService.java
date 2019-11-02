package com.changgou.search.service;

import java.util.Map;

/*****
 * @Author: www.itheima.com
 * @Description: com.changgou.search.service
 ****/
public interface SkuService {

    /***
     * 条件搜索
     * @param searchMap
     * @return Map
     */
    Map<String,Object> search(Map<String,String> searchMap) throws Exception;

    /***
     * 导入数据到索引库中
     */
    void importData();
}
