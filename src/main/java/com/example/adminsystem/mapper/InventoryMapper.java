package com.example.adminsystem.mapper;

import com.example.adminsystem.pojo.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解表示这个是mybaits的mapper类：Dao
@Repository
public interface InventoryMapper {
    /**
     * 同步：查询所有库存信息数据和条件查询加分页
     *
     * @param inventory
     * @return
     */
    List<Inventory> findInventoryAll(Inventory inventory);

    /**
     * 异步：根据Id查询库存信息
     *
     * @param iId
     * @return
     */
    Inventory findInventoryiId(int iId);

    /**
     * 异步：根据Id修改库存信息
     *
     * @param inventory
     * @return
     */
    int updateInventoryiId(Inventory inventory);

    /**
     * 异步：根据ID删除库存信息
     *
     * @param iId
     * @return
     */
    int deleteInventoryiId(int iId);

    /**
     * 异步：添加库存信息
     * @param inventory
     * @return
     */
    int addInventoryAll(Inventory inventory);
}
