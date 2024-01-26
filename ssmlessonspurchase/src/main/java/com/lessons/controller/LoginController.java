package com.lessons.controller;

import com.lessons.pojo.Book;
import com.lessons.pojo.User;
import com.lessons.service.LoginService;
import com.lessons.util.R;
import com.lessons.util.code;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @GetMapping
    public R login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
//        System.out.println(username);
//        System.out.println(password);

        User userByName = loginService.getUserByName(username);
        if (userByName!=null&&userByName.getPassword().equals(password)){
            Integer idByName = loginService.getIdByName(username);

            return  new R(idByName,code.LOGIN_OK,"登陆成功");
        }else {
            return new R(code.LOGIN_ERR,"登录失败");
        }
//        User user = loginService.getUserByName(username);
//        if (user != null && user.getPassword().equals(password)) {
//            session.setAttribute("user", user);
//            return "redirect:/index";
//        } else {
//            model.addAttribute("msg", "用户名或密码错误");
//            return "login";
//        }
    }

}
