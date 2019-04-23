package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.SessionAttributes;


@Service
@Transactional
@SessionAttributes({"login","code"})
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public void login(User user, ModelMap map,String vCode) {
        User login = userDAO.login(user.getUsername());
        String code = (String) map.get("code");
        if (code.equalsIgnoreCase(vCode)) {
            if(login==null){
                throw new RuntimeException("用户名错误！~");
            }else{
                if(login.getPassword().equals(user.getPassword())){
                    map.addAttribute("login",login);
                }else {
                    throw new RuntimeException("密码错误！~");
                }
            }
        } else {
            throw new RuntimeException("验证码错误~");
        }
    }

    @Override
    public User queryByUsername(User user) {
        User login = userDAO.login(user.getUsername());
        return login;
    }
}
