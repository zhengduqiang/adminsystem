package com.example.adminsystem.mapper;

import com.example.adminsystem.pojo.Financing;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解表示这个是mybaits的mapper类：Dao
@Repository
public interface FinancingMapper {
    /**
     * 按条件查询数据和分页
     *
     * @param financing
     * @return
     */
    List<Financing> findFinancingAll(Financing financing);

    /**
     * 异步：根据id查询账本信息
     *
     * @param fId
     * @return
     */
    Financing findFinancingId(int fId);

    /**
     * 异步：修改账本信息
     *
     * @param financing
     * @return
     */
    int updateFinancingId(Financing financing);

    /**
     * 异步：添加账本信息
     *
     * @param financing
     * @return
     */
    int addFinancingAll(Financing financing);


}
