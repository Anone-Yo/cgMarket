package com.changgou.goods.feign;

import com.changgou.goods.pojo.Sku;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/*****
 * @Author: www.itheima.com
 * @Description: com.changgou.goods.feign
 ****/
@FeignClient(value = "goods")
@RequestMapping("/sku")
public interface SkuFeign {

    /****
     * 商品信息递减
     * Map<key,value>  key:要递减的商品ID
     *                 value:要递减的数量
     * @return
     */
    @GetMapping(value = "/decr/count")
    Result decrCount(@RequestParam Map<String,Integer> decrmap);

    /***
     * 根据ID查询Sku数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Sku> findById(@PathVariable Long id);

    /***
     * 查询Sku全部数据
     * @return
     */
    @GetMapping
    Result<List<Sku>> findAll();
}
