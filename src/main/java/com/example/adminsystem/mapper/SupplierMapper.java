package com.example.adminsystem.mapper;

import com.example.adminsystem.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解表示这个是mybaits的mapper类：Dao
@Repository
public interface SupplierMapper {
    /**
     * 同步：查询所有供应商信息和按照条件查询
     *
     * @param supplier
     * @return
     */
    List<Supplier> findSupplierAll(Supplier supplier);

    /**
     * 异步：根据ID查询供应商信息
     *
     * @param nId
     * @return
     */
    Supplier findSuppliernId(int nId);

    /**
     * 异步：根据nId修改供应商信息
     *
     * @param supplier
     * @return
     */
    int updateSuppliernId(Supplier supplier);

    /**
     * 异步：删除供应商信息
     *
     * @param nId
     * @return
     */
    int deleteSuppliernId(int nId);

    /**
     * 异步：添加供应商信息
     *
     * @param supplier
     * @return
     */
    int addSupplier(Supplier supplier);

}
