package com.lessons.service.impl;

import com.lessons.controller.LoginController;
import com.lessons.dao.LoginDao;
import com.lessons.pojo.User;
import com.lessons.service.LoginService;
import com.lessons.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginDao loginDao;

    public User getUserByName(String username) {
        return loginDao.getUserByName(username);
    }

    @Override
    public Integer getIdByName(String username) {
        return loginDao.getIdByName(username);
    }


}
