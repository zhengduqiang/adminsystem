package com.example.adminsystem.mapper;

import com.example.adminsystem.pojo.Comeenterrecord;
import com.example.adminsystem.pojo.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解表示这个是mybaits的mapper类：Dao
@Repository
public interface ComeenterrecordMapper {
    /**
     * 查询所有出入库记录表信息包括条件和分页
     *
     * @param comeenterrecord
     * @return
     */
    List<Comeenterrecord> findComeenterrecordAll(Comeenterrecord comeenterrecord);

    /**
     * 异步：根据ID删除出入库记录
     *
     * @param cId
     * @return
     */
    int deleteComeenterrecord(int cId);

    /**
     * 异步：添加一条记录到出入库记录表里面
     *
     * @param comeenterrecord
     * @return
     */
    int addComeenterrecord(Comeenterrecord comeenterrecord);


    /**
     * 异步：出入库修改商品数量
     *
     * @param inventory
     * @return
     */
    int updateInventory(Inventory inventory);
}
