package com.example.controller;


import com.example.common.Result;
import com.example.entity.Equipment;
import com.example.entity.EquipmentReservation;
import com.example.entity.StudentInfo;
import com.example.service.EquipmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Resource
    private EquipmentService equipmentService;

    @PutMapping
    public Result update(@RequestBody Equipment equipment){
        equipmentService.update(equipment);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Equipment equipment){
        equipmentService.add(equipment);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum , @RequestParam Integer pageSize) {
        PageInfo<Equipment> pageInfo = equipmentService.findPage(pageNum , pageSize);
        return Result.success(pageInfo);
    }

    @GetMapping("/page/{name}")
    public Result findPageByName(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @PathVariable String name) {
        PageInfo<Equipment> pageInfo = equipmentService.findPageByName(pageNum , pageSize , name);
        return Result.success(pageInfo);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        equipmentService.delete(id);
        return Result.success();
    }


    @PutMapping("/reservation/{id}")
    public Result reservation(@PathVariable Long id , @RequestParam Long reservationRo , @RequestBody Equipment entity , @RequestParam Long mouth , @RequestParam Long day , @RequestParam Long initTime , @RequestParam Long destroyTime){
        equipmentService.reservation(id , reservationRo , entity , mouth , day , initTime , destroyTime);
        return Result.success();
    }

//    注意下面是预约的部分，所以返回值的类型是 EquipmentReservation 不是equipment
    @GetMapping("/reservation")
    public Result getReservation(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @RequestParam Long userId){
        PageInfo<EquipmentReservation> pageInfo = equipmentService.getReservation(pageNum , pageSize , userId);
        return Result.success(pageInfo);
    }

    @GetMapping("/reservation/{name}")
    public Result getReservationByName(@RequestParam Integer pageNum , @RequestParam Integer pageSize , @RequestParam Long userId , @PathVariable String name){
        PageInfo<EquipmentReservation> pageInfo = equipmentService.getReservationByName(pageNum , pageSize , userId , name);
        return Result.success(pageInfo);
    }

    @DeleteMapping("/tuiding/{id}/{baofei}/{userId}")
    public Result tuiding(@PathVariable Long id , @PathVariable Long baofei , @PathVariable Long userId) {
        equipmentService.tuiding(id , userId , baofei);
        return Result.success();
    }


}
