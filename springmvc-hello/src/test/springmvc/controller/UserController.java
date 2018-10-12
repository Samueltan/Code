package test.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import test.springmvc.entity.User;

@Controller
public class UserController {

    /**
     * RequestMapping 用来映射一个请求和请求的方法
     * value="/register" 表示请求由 register 方法进行处理
     */
    @RequestMapping(value="/register")
    public String Register(@ModelAttribute("form") User user, Model model) {
        // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        // 在 model 中添加一个名为 "user" 的 user 对象
        model.addAttribute("user", user);
        // 返回一个字符串 " success" 作为视图名称
        return "success";
    }

    @RequestMapping(value="/test/{username}/{age}")
    public String test(@PathVariable String username, @PathVariable int age, Model model) {
        // user:视图层传给控制层的表单对象；model：控制层返回给视图层的对象
        // 在 model 中添加一个名为 "user" 的 user 对象
        model.addAttribute("user", username + " : " + age);
        // 返回一个字符串 " success" 作为视图名称
        return "success";
    }

    @RequestMapping("/api/hello")
    public String hello() {

        return "success";
    }
}