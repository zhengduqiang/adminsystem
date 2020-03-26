package com.example.adminsystem.mapper;

import com.example.adminsystem.pojo.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解表示这个是mybaits的mapper类：Dao
@Repository
public interface SalaryMapper {
    /**
     * 同步：查询所有员工工资和按条件查询
     *
     * @param salary
     * @return
     */
    List<Salary> findSalaryAll(Salary salary);

    /**
     * 异步：根据ID查询员工工资
     *
     * @param sId
     * @return
     */
    Salary findSalarysId(int sId);

    /**
     * 异步：根据ID修改员工工资
     *
     * @param salary
     * @return
     */
    int updateSalarysId(Salary salary);

    /**
     * 异步：添加员工工资信息
     *
     * @param salary
     * @return
     */
    int addSalaryAll(Salary salary);


}
