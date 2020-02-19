package cn.edu.hxu.majiangdemo.controller;

import cn.edu.hxu.majiangdemo.mapper.UserMapper;
import cn.edu.hxu.majiangdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findUserByToken(token);
                if(user != null){
                    request.getSession().setAttribute("user",user);
                }
            }
            break;
        }
        return "index";
    }
}
