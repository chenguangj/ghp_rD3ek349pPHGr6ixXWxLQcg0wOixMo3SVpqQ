package com.example.service;

import com.example.dao.EquipmentReservationDao;
import com.example.entity.EquipmentReservation;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EquipmentReservationService {
    @Resource
    private EquipmentReservationDao equipmentReservationDao;



}
