package com.example.controller;


import com.example.common.Result;
import com.example.entity.Equipment;
import com.example.entity.EquipmentReservation;
import com.example.service.EquipmentReservationService;
import com.example.service.EquipmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/equipmentReservation")
public class EquipmentReservationController {

    @Resource
    private EquipmentReservationService equipmentReservationService;



}
