package com.changgou.canal;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.*;

/*****
 * @Author: www.itheima.com
 * @Description: com.changgou.canal
 * 实现MySQL数据监听
 ****/
@CanalEventListener
public class CanalDataEventListener {

    /****
     * @InsertListenPoint:增加监听   只有增加后的数据:
     * rowData.getAfterColumnsList():增加、修改
     * rowData.getBeforeColumnsList()：删除、修改
     * @param eventType : 当前操作的类型  增加数据
     * @param rowData ： 发生变更的一行数据
     */
    @InsertListenPoint
    public void onEventInsert(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            System.out.println("列名：" + column.getName() + "--------变更的数据:" + column.getValue());
        }
    }


    /****
     * @InsertListenPoint:修改数据监听
     * rowData.getAfterColumnsList():增加、修改
     * rowData.getBeforeColumnsList()：删除、修改
     * @param eventType : 当前操作的类型  增加数据
     * @param rowData ： 发生变更的一行数据
     */
    @UpdateListenPoint
    public void onEventUpdate(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
        for (CanalEntry.Column column : rowData.getBeforeColumnsList()) {
            System.out.println("修改前：列名：" + column.getName() + "--------变更的数据:" + column.getValue());
        }

        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            System.out.println("修改后：列名：" + column.getName() + "--------变更的数据:" + column.getValue());
        }
    }




    /****
     * @DeleteListenPoint:删除监听   只有增加后的数据:
     * rowData.getAfterColumnsList():增加、修改
     * rowData.getBeforeColumnsList()：删除、修改
     * @param eventType : 当前操作的类型  增加数据
     * @param rowData ： 发生变更的一行数据
     */
    @DeleteListenPoint
    public void onEventDelete(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
        for (CanalEntry.Column column : rowData.getBeforeColumnsList()) {
            System.out.println("删除前列名：" + column.getName() + "--------变更的数据:" + column.getValue());
        }
    }




    /****
     * 自定义监听
     * rowData.getAfterColumnsList():增加、修改
     * rowData.getBeforeColumnsList()：删除、修改
     * @param eventType : 当前操作的类型  增加数据
     * @param rowData ： 发生变更的一行数据
     */
    @ListenPoint(
            eventType= {CanalEntry.EventType.DELETE,CanalEntry.EventType.UPDATE},    //监听类型
            schema = {"changgou_content"},   //指定监听的数据
            table = {"tb_content"},         //指定监控的表
            destination="example"           //指定实例的地址
    )
    public void onEventCustomUpdate(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
        for (CanalEntry.Column column : rowData.getBeforeColumnsList()) {
            System.out.println("===自定义操作前：列名：" + column.getName() + "--------变更的数据:" + column.getValue());
        }

        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            System.out.println("===自定义操作后：列名：" + column.getName() + "--------变更的数据:" + column.getValue());
        }

        //调用  /update_content?id=1   RestTempalte

    }

}
