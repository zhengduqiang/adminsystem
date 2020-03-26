package com.example.adminsystem.mapper;

import com.example.adminsystem.pojo.Bonusandfine;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解表示这个是mybaits的mapper类：Dao
@Repository
public interface BonusandfineMapper {
    /**
     * 同步：查询罚款奖金表的所有数据按照条件查询
     *
     * @param bonusandfine
     * @return
     */
    List<Bonusandfine> findBonusandfineAll(Bonusandfine bonusandfine);

    /**
     * 异步：根据ID查询奖罚信息
     *
     * @param bId
     * @return
     */
    Bonusandfine findBonusandfine(int bId);

    /**
     * 异步：根据ID修改奖罚信息
     *
     * @param bonusandfine
     * @return
     */
    int updateBonusandfine(Bonusandfine bonusandfine);

    /**
     * 异步：删除奖罚信息
     *
     * @param bId
     * @return
     */
    int deleteBonusandfinebId(int bId);

    /**
     * 异步：添加奖罚信息
     *
     * @param bonusandfine
     * @return
     */
    int addBonusandfine(Bonusandfine bonusandfine);


}
