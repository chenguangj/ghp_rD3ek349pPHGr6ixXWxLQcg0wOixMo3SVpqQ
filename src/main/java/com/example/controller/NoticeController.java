package com.example.controller;

//这个是公用类，公用的功能实现都写在这里，如登录的校验操作，这不管是管理员还是普通的用户都是要进行的，所以写在这里

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Notice;
import com.example.service.NoticeService;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    private NoticeService noticeService;

    @GetMapping("/playGround/{id}")
    public Result getPlayGroundNotice(@PathVariable Long id){
        Notice notice = noticeService.getNotice(id);
        return Result.success(notice);
    }

    @GetMapping("/equipment/{id}")
    public Result getEquipmentNotice(@PathVariable Long id){
        Notice notice = noticeService.getNotice(id);
        return Result.success(notice);
    }

    @GetMapping("/game/{id}")
    public Result getGameNotice(@PathVariable Long id){
        Notice notice = noticeService.getNotice(id);
        return Result.success(notice);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Notice notice){
        noticeService.update(notice);
        return Result.success();
    }

}
