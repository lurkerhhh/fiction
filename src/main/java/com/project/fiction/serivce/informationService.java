package com.project.fiction.serivce;

import com.project.fiction.pojo.bookinformation;
import com.project.fiction.pojo.bookuser;

import java.util.List;

public interface informationService {
    /**
     * 随机抽取九本书
     * @return
     */
    public List<bookinformation> getbookByRandom();

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public bookuser login(String username, String password);

    /**
     * 获取用户角色集合
     * @return
     */
    public List<bookuser> getUserRole(String username);
}
