package com.project.fiction.controller;


import com.project.fiction.pojo.bookinformation;
import com.project.fiction.pojo.bookuser;
import com.project.fiction.serviceimpl.informationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;
import java.util.List;

@RequestMapping(value = "/fiction")
@Controller
public class fictionController {
    @Autowired
    informationServiceImpl informationService;
    @RequestMapping(value = "/dohtml")
    public String do_html(){
        return "test001";
    }
    @RequestMapping(value = "/doindex")
    public String do_index(Model model, HttpSession session){
        List<bookinformation> informationList = informationService.getbookByRandom();
        for(bookinformation bookinformation : informationList){
            System.out.println("书名:" + bookinformation.getBookname());
        }
        if (session.getAttribute("bookuser")!=null) {
            model.addAttribute("bookuser",session.getAttribute("bookuser"));
        }
        model.addAttribute("bookinformation", informationList);
        return  "html/index";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "username", required = false) String username
            , @RequestParam(value = "password", required = false)String password, HttpSession session){
        System.out.println("进入login................");
        bookuser bookuser = informationService.login(username, password);
        if (bookuser == null) {
            session.setAttribute("msg", "用户名或者密码错误!");
            System.out.println("登录失败，返回登录页面");
            loginError();
            return null;
        }else {
            if (bookuser.getUserrole() == 4) {
                session.setAttribute("userRole","admin");
                return "redirect:/fiction/Admin/he";
            }else if (bookuser.getUserrole() == 3) {
                session.setAttribute("userRole","authod");
                return "redirect:/fiction/Authod/he";
            }
            session.setAttribute("bookuser", bookuser);
            System.out.println("用户名:" + bookuser.getUsername());
            System.out.println("登录成功，重定向至首页");
            return "redirect:/fiction/doindex";
        }
    }
    @RequestMapping("/loginResult")
    @ResponseBody
    public Object loginError(){
        return "false";
    }
    @RequestMapping(value = "/dologin")
    public String dologin(){
        return "html/login";
    }

    /**
     * 作者页面
     * @return
     */
    @RequestMapping(value = "/Authod/he")
    public String doindex(){
        return "html/Authod/test01";
    }

    /**
     * 管理员页面
     * @return
     */
    @RequestMapping(value = "/Admin/he")
    public String doAdmin(){
        return "html/Administrator/test02";
    }

}
