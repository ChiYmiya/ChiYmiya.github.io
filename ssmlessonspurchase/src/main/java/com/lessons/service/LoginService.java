package com.lessons.service;

import com.lessons.pojo.User;
import com.lessons.util.R;

public interface LoginService {

    User getUserByName(String username);

    Integer getIdByName(String username);
}
