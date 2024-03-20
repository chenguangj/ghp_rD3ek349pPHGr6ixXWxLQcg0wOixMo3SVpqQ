package com.example.controller;

//这个是公用类，公用的功能实现都写在这里，如登录的校验操作，这不管是管理员还是普通的用户都是要进行的，所以写在这里

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.StudentInfo;
import com.example.entity.TeacherInfo;
import com.example.exception.CustomException;
import com.example.service.AdminInfoService;
import com.example.service.StudentInfoService;
import com.example.service.TeacherInfoService;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class AccountController {

    @Resource
    private AdminInfoService adminInfoService;

    @Resource
    private TeacherInfoService teacherInfoService;

    @Resource
    private StudentInfoService studentInfoService;


    @PostMapping("/login")
    public Result login(@RequestBody Account user , HttpServletRequest request){


        if (!CaptchaUtil.ver(user.getVerCode(), request)) {
            CaptchaUtil.clear(request);
            return Result.error("1001" , "验证码不正确");
        }


        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1" , "请将要求输入的信息输入完毕");
        }
        Integer level = user.getLevel();
        Account loginUser = new Account();
        if (1 == level) {
            loginUser = adminInfoService.login(user.getName() , user.getPassword());
        } else if (2 == level) {
            loginUser = teacherInfoService.login(user.getName() , user.getPassword());
        } else {
            loginUser = studentInfoService.login(user.getName() , user.getPassword());
        }
        if (ObjectUtil.isEmpty(loginUser)) {
            return Result.error("-1" , "用户名，密码或身份错误");
        }
        request.getSession().setAttribute("user" , loginUser);
        return Result.success(loginUser);
    }


    @GetMapping("/getUser")
    public Result getUser(HttpServletRequest request){
        Account user = (Account) request.getSession().getAttribute("user");
        Integer level = user.getLevel();
        if (1 == level) {
            AdminInfo adminInfo = adminInfoService.findById(user.getId());
            return Result.success(adminInfo);
        } else if (2 == level) {
            TeacherInfo teacherInfo = teacherInfoService.findById(user.getId());
            return Result.success(teacherInfo);
        } else if (3 == level){
            StudentInfo studentInfo = studentInfoService.findById(user.getId());
            return Result.success(studentInfo);
        }
        return Result.success(new Account());
    }


    @PostMapping("/register")
    public Result register(@RequestBody Account user , HttpServletRequest request){
        if (ObjectUtil.isEmpty(user.getName()) || ObjectUtil.isEmpty(user.getPassword()) || ObjectUtil.isEmpty(user.getLevel())) {
            return Result.error("-1" , "请将要求输入的信息输入完毕");
        }
        Integer level = user.getLevel();
        if (2 == level) {
            TeacherInfo teacherInfo = new TeacherInfo();
            BeanUtils.copyProperties(user , teacherInfo);
            teacherInfoService.register(teacherInfo);
        }
        if (3 == level) {
            StudentInfo studentInfo = new StudentInfo();
            BeanUtils.copyProperties(user , studentInfo);
            studentInfoService.register(studentInfo);
        }

        return Result.success();
    }


    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){
        request.getSession().setAttribute("user" , null);
        return Result.success();
    }


    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request , HttpServletResponse response) throws Exception{

        ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(135, 33);
        arithmeticCaptcha.setLen(3);//设置是几位数的运算，默认是2位数的运算
        arithmeticCaptcha.getArithmeticString();//获得运算公式  3+2=?
        arithmeticCaptcha.text();//获得运算结果，来进行验证
        CaptchaUtil.out(arithmeticCaptcha , request , response);
    }


}
