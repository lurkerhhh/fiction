package com.project.fiction.dao;

import com.project.fiction.pojo.bookinformation;
import com.project.fiction.pojo.bookuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface bookinformationMapper {
    /**
     * 随机抽取一本书
     * @param id
     * @return
     */
    public bookinformation selectbookByRandom(@Param(value = "id") Integer id);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public bookuser selectUserByUsernameAndpwd(@Param(value = "username") String username, @Param(value = "password") String password);

    /**
     * 根据用户名查询用户
     * @return
     */
    public bookuser selectUserByLoginName(@Param(value = "username")String username);

    /**
     *  查询用户角色
     * @return
     */
    public List<bookuser> selectUserRole(@Param(value = "username") String username);

    /**
     *  添加用户
     * @return
     */
    public int addUser();
}
