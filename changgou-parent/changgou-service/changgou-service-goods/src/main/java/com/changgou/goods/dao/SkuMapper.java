package com.changgou.goods.dao;
import com.changgou.goods.pojo.Sku;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:www.itheima.com
 * @Description:Sku的Dao
 * @Date www.itheima.com 0:12
 *****/
public interface SkuMapper extends Mapper<Sku> {

    /***
     * 库存递减
     * @param id
     * @param num
     * @return
     */
    @Update("update tb_sku set num=num-#{num} where id=#{id} and num>=#{num}")
    int decrCount(@Param(value = "id") Long id, @Param("num") Integer num);
    //                                   arg0                   arg1
}
