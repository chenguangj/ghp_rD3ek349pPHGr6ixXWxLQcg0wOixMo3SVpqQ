package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.service.AdminInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {
    @Resource
    private AdminInfoService adminInfoService;


    @PutMapping
    public Result update(@RequestBody AdminInfo adminInfo){
        adminInfoService.update(adminInfo);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody AdminInfo adminInfo) {
        adminInfoService.add(adminInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<AdminInfo> list = adminInfoService.findAll();
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){
        adminInfoService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/page")
//    下面的pageNum表示第几页，而pageSize表示每页有多少个，由于是get请求的，所以在spring之中可以通过在网址上填上对应的数值来传给网址对应的方法
    public Result findPage(@RequestParam Integer pageNum ,@RequestParam Integer pageSize) {
        PageInfo<AdminInfo> info = adminInfoService.findPage(pageNum , pageSize);
        return Result.success(info);
    }

    @GetMapping("/page/{name}")
//    下面的pageNum表示第几页，而pageSize表示每页有多少个，由于是get请求的，所以在spring之中可以通过在网址上填上对应的数值来传给网址对应的方法
    public Result findPage(@RequestParam Integer pageNum ,@RequestParam Integer pageSize , @PathVariable String name) {
        PageInfo<AdminInfo> info = adminInfoService.findPageName(pageNum , pageSize , name);
        return Result.success(info);
    }

}
