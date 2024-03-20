package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.entity.StudentInfo;
import com.example.entity.TeacherInfo;
import com.example.service.AdminInfoService;
import com.example.service.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//这里是专门给教师使用的，所以一些公用的操作，不要在这里写

@RestController
@RequestMapping("/teacherInfo")
public class TeacherInfoController {
    @Resource
    private TeacherInfoService teacherInfoService;

    @PutMapping
    public Result update(@RequestBody TeacherInfo teacherInfo){
        teacherInfoService.update(teacherInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<TeacherInfo> list = teacherInfoService.findAll();
        return Result.success(list);
    }

    @PostMapping
    public Result add(@RequestBody TeacherInfo teacherInfo){
        teacherInfoService.add(teacherInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){
        teacherInfoService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum , @RequestParam Integer pageSize){
        PageInfo<TeacherInfo> pageInfo = teacherInfoService.findPage(pageNum , pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/page/{search}")
    public Result findPage(@PathVariable String search , @RequestParam Integer pageNum ,@RequestParam Integer pageSize) {
        PageInfo<TeacherInfo> info = teacherInfoService.findPageSearch(search , pageNum , pageSize);
        return Result.success(info);
    }

    @PutMapping("/setmailbox/{mailbox}")
    public Result setMailBox(@RequestBody TeacherInfo teacherInfo , @PathVariable String mailbox){
        teacherInfoService.setMailBox(teacherInfo , mailbox);
        return Result.success();
    }



}
