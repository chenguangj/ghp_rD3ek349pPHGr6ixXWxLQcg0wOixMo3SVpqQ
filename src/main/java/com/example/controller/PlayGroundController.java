package com.example.controller;


import com.example.common.Result;
import com.example.entity.PlayGround;
import com.example.entity.StudentInfo;
import com.example.service.PlayGroundService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/playGround")
public class PlayGroundController {

    @Resource
    private PlayGroundService playGroundService;

    @PostMapping
    public Result add(@RequestBody PlayGround playGround){
        playGroundService.add(playGround);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody PlayGround playGround){
        playGroundService.update(playGround);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        playGroundService.delete(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum , @RequestParam Integer pageSize) {
        PageInfo<PlayGround> pageInfo = playGroundService.findPage(pageNum , pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/reservation/page")
    public Result reservationfindPage(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @RequestParam Long userId) {
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPage(pageNum , pageSize , userId);
        return Result.success(pageInfo);
    }

    @GetMapping("/page1/{name}/{type}")
    public Result findPageByNameAndTypeAndMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type , @RequestParam Integer mouth , @RequestParam Integer day){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByNameAndTypeAndMouthAndDay(pageNum , pageSize , name , type , mouth , day);
        return Result.success(pageInfo);
    }

    @GetMapping("/reservation/page1/{name}/{type}")
    public Result reservationfindPageByNameAndTypeAndMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type , @RequestParam Integer mouth , @RequestParam Integer day , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByNameAndTypeAndMouthAndDay(pageNum , pageSize , name , type , mouth , day , userId);
        return Result.success(pageInfo);
    }

    @GetMapping("/page2/{name}/{type}")
    public Result findPageByNameAndTypeAndMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type , @RequestParam Integer mouth){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByNameAndTypeAndMouth(pageNum , pageSize , name , type , mouth);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page2/{name}/{type}")
    public Result reservationfindPageByNameAndTypeAndMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type , @RequestParam Integer mouth , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByNameAndTypeAndMouth(pageNum , pageSize , name , type , mouth ,userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page3/{name}/{type}")
    public Result findPageByNameAndTypeAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type , @RequestParam Integer day){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByNameAndTypeAndDay(pageNum , pageSize , name , type , day);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page3/{name}/{type}")
    public Result findPageByNameAndTypeAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type , @RequestParam Integer day , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByNameAndTypeAndDay(pageNum , pageSize , name , type , day , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page4/{name}")
    public Result findPageByNameAndMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @RequestParam Integer day , @RequestParam Integer mouth){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByNameAndMouthAndDay(pageNum , pageSize , name , mouth , day);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page4/{name}")
    public Result reservationvfindPageByNameAndMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @RequestParam Integer day , @RequestParam Integer mouth , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByNameAndMouthAndDay(pageNum , pageSize , name , mouth , day , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page5/{type}")
    public Result findPageByTypeAndMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type , @RequestParam Integer day , @RequestParam Integer mouth){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByTypeAndMouthAndDay(pageNum , pageSize , type , mouth , day);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page5/{type}")
    public Result reservationfindPageByTypeAndMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type , @RequestParam Integer day , @RequestParam Integer mouth , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByTypeAndMouthAndDay(pageNum , pageSize , type , mouth , day , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page7/{name}")
    public Result findPageByNameAndMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @RequestParam Integer mouth){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByNameAndMouth(pageNum , pageSize , name , mouth);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page7/{name}")
    public Result reservationfindPageByNameAndMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @RequestParam Integer mouth , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByNameAndMouth(pageNum , pageSize , name , mouth , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page6/{name}/{type}")
    public Result findPageByNameAndType(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByNameAndType(pageNum , pageSize , name , type);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page6/{name}/{type}")
    public Result reservationfindPageByNameAndType(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @PathVariable String type , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByNameAndType(pageNum , pageSize , name , type , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page8/{name}")
    public Result findPageByNameAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @RequestParam Integer day){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByNameAndDay(pageNum , pageSize , name , day);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page8/{name}")
    public Result reservationfindPageByNameAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @RequestParam Integer day , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByNameAndDay(pageNum , pageSize , name , day , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page9/{type}")
    public Result findPageByTypeAndMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type , @RequestParam Integer mouth){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByTypeAndMouth(pageNum , pageSize , type , mouth);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page9/{type}")
    public Result reservationfindPageByTypeAndMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type , @RequestParam Integer mouth , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByTypeAndMouth(pageNum , pageSize , type , mouth , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page10/{type}")
    public Result findPageByTypeAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type , @RequestParam Integer day){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByTypeAndDay(pageNum , pageSize , type , day);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page10/{type}")
    public Result reservationfindPageByTypeAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type , @RequestParam Integer day , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByTypeAndDay(pageNum , pageSize , type , day , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page11")
    public Result findPageByMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize ,@RequestParam Integer mouth , @RequestParam Integer day){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByMouthAndDay(pageNum , pageSize , mouth , day);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page11")
    public Result reservationfindPageByMouthAndDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize ,@RequestParam Integer mouth , @RequestParam Integer day , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByMouthAndDay(pageNum , pageSize , mouth , day , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page12/{name}")
    public Result findPageByName(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByName(pageNum , pageSize , name);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page12/{name}")
    public Result reservationfindPageByName(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByName(pageNum , pageSize , name , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page13/{type}")
    public Result findPageByType(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByType(pageNum , pageSize , type);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page13/{type}")
    public Result reservationfindPageByType(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String type , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByType(pageNum , pageSize , type , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page14")
    public Result findPageByMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize ,@RequestParam Integer mouth){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByMouth(pageNum , pageSize , mouth);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page14")
    public Result reservationfindPageByMouth(@RequestParam Integer pageNum , @RequestParam Integer pageSize ,@RequestParam Integer mouth , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByMouth(pageNum , pageSize , mouth , userId);
        return Result.success(pageInfo);
    }
    @GetMapping("/page15")
    public Result findPageByDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize ,@RequestParam Integer day){
        PageInfo<PlayGround> pageInfo = playGroundService.findPageByDay(pageNum , pageSize , day);
        return Result.success(pageInfo);
    }
    @GetMapping("/reservation/page15")
    public Result reservationfindPageByDay(@RequestParam Integer pageNum , @RequestParam Integer pageSize ,@RequestParam Integer day , @RequestParam Long userId){
        PageInfo<PlayGround> pageInfo = playGroundService.reservationfindPageByDay(pageNum , pageSize , day , userId);
        return Result.success(pageInfo);
    }



    @DeleteMapping("/reservation/{id}/{userId}")
    public Result reservation(@PathVariable Long id , @PathVariable Long userId){
        playGroundService.reservation(id , userId);
        return Result.success();
    }

    @DeleteMapping("/reservation/tuiding/{id}/{userId}")
    public Result reservationTuiding(@PathVariable Long id , @PathVariable Long userId){
        playGroundService.reservationTuiding(id , userId);
        return Result.success();
    }



}
