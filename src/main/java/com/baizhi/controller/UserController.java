package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("user")
@SessionAttributes({"code","message","uname","login"})
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(User user, ModelMap map,String vCode){
        try {
            userService.login(user,map,vCode);
            User login = userService.queryByUsername(user);
            return "redirect:/document/queryAll?userId="+login.getId();
        } catch (Exception e) {
            String message = e.getMessage();
            if(message!=null) {
                map.addAttribute("message", message);
            }
            return "login";
        }
    }

    //注册验证码方法
    @RequestMapping("/getImage")
    public void getImage(ModelMap map, HttpServletResponse response) throws IOException {
        //1.生成字符
        String code= VerifyCodeUtils.generateVerifyCode(4);
        //2.放入session
        map.addAttribute("code",code);
        //3.生成图片
        BufferedImage image = VerifyCodeUtils.getImage(100, 50, code);
        //4.响应图片，获取响应流
        response.setContentType("image/png;charset=UTF-8");
        ServletOutputStream os = response.getOutputStream();
        //5.输出图片
        ImageIO.write(image,"png",os);
        os.close();
    }
}
