package com.example.adminsystem.mapper;

import com.example.adminsystem.pojo.Admin;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper//这个注解表示这个是mybaits的mapper类：Dao
@Repository
public interface AdminMapper {
    /**
     * 登录
     *
     * @param admin
     * @return
     */
    Admin findAdminLogin(Admin admin);
}
