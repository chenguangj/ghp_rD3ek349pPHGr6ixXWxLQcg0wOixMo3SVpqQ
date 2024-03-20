package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.entity.StudentInfo;
import com.example.service.StudentInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//这里是专门给学生使用的，所以一些公用的操作，不要在这里写

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {
    @Resource
    private StudentInfoService studentInfoService;

    @PutMapping
    public Result update(@RequestBody StudentInfo studentInfo){
        studentInfoService.update(studentInfo);
        return Result.success();
    }


    @PostMapping
    public Result add(@RequestBody StudentInfo studentInfo) {
        studentInfoService.add(studentInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<StudentInfo> list = studentInfoService.findAll();
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){
        studentInfoService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum ,@RequestParam Integer pageSize) {
        PageInfo<StudentInfo> info = studentInfoService.findPage(pageNum , pageSize);
        return Result.success(info);
    }

    @GetMapping("/page/{name}")
    public Result findPage(@RequestParam Integer pageNum ,@RequestParam Integer pageSize , @PathVariable String name) {
        PageInfo<StudentInfo> info = studentInfoService.findPageName(pageNum , pageSize , name);
        return Result.success(info);
    }

    @PutMapping("/setmailbox/{mailbox}")
    public Result setMailBox(@RequestBody StudentInfo studentInfo , @PathVariable String mailbox){
        studentInfoService.setMailBox(studentInfo , mailbox);
        return Result.success();
    }

    @PutMapping("/agree")
    public Result agree(@RequestBody StudentInfo studentInfo){
        studentInfoService.agree(studentInfo);
        return Result.success();
    }

    @PutMapping("/disagree/{id}")
    public Result disagree(@PathVariable Long id){
        studentInfoService.disagree(id);
        return Result.success();
    }


}
