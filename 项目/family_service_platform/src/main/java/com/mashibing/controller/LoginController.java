package com.mashibing.controller;

import com.mashibing.bean.TblUserRecord;
import com.mashibing.json.Common;
import com.mashibing.json.Permission;
import com.mashibing.json.Permissions;
import com.mashibing.json.UserInfo;
import com.mashibing.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/auth/2step-code")
    public Boolean test(){
        System.out.println("前端框架自带的一个验证规则，写不写无所谓");
        return true;
    }

    /**
     *  处理登录业务
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/auth/login")
    public Common login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session){
        System.out.println("login");
        TblUserRecord tblUserRecord = loginService.login(username,password);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        // 将用户信息写入session
        session.setAttribute("userRecord",tblUserRecord);
        Common result = new Common("OK",200,tblUserRecord);
        System.out.println(result);
        return result;
    }

    /**
     * 获取用户信息
     * @param session
     * @return
     */
    @RequestMapping("/user/info")
    public Common getInfo(HttpSession session){
        // 获取用户信息
       TblUserRecord tblUserRecord = (TblUserRecord)session.getAttribute("userRecord");
       // 获取对应用户的功能模块
        String[] rolePrivileges =  tblUserRecord.getTblRole().getRolePrivileges().split("-");
        // 拼接需要返回的数据对象格式
        List<Permission> permissionList = new ArrayList<>();
        Permissions permissions = new Permissions();
        for (String s:rolePrivileges) {
            permissionList.add(new Permission(s));
        }
        permissions.setPermissions(permissionList);

        UserInfo userInfo = new UserInfo(tblUserRecord.getUserName(),permissions);
        return new Common(userInfo);
    }

    /**
     * 处理登出业务
     * @param session
     */
    @RequestMapping("/auth/logout")
    public void logout(HttpSession session){
        System.out.println("logout");
        // 将session设置为失效
        session.invalidate();
    }

//    @RequestMapping("/auth/login")
//    @CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
    public String test1(){
        System.out.println("收到前端请求：");
        return "测试连接";
    }
}
