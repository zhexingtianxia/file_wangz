package com.baizhi.service;

import com.baizhi.entity.User;
import org.springframework.ui.ModelMap;

public interface UserService {
    void login(User user, ModelMap map,String vCode);
    User queryByUsername(User user);
}
