package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.dao.EquipmentDao;
import com.example.dao.EquipmentReservationDao;
import com.example.dao.StudentInfoDao;
import com.example.entity.Equipment;
import com.example.entity.EquipmentReservation;
import com.example.entity.StudentInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {
    @Resource
    private EquipmentDao equipmentDao;

    @Resource
    private EquipmentReservationDao equipmentReservationDao;

    @Resource
    private StudentInfoDao studentInfoDao;


    public void update(Equipment equipment) {
        equipmentDao.updateByPrimaryKeySelective(equipment);
    }

    public void add(Equipment equipment) {
        if (equipment.getCapacity() < 1) {
            throw new CustomException("-1" , "容量不能为0或负数");
        }
        equipmentDao.insertSelective(equipment);
    }

    public PageInfo<Equipment> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<Equipment> equipment = equipmentDao.selectAll();
        return PageInfo.of(equipment);
    }

    public void delete(Long id) {
        equipmentDao.deleteByPrimaryKey(id);
    }

    public PageInfo<Equipment> findPageByName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum , pageSize);
        List<Equipment> equipment = equipmentDao.selectByName(name);
        return PageInfo.of(equipment);
    }

    public void reservation(Long id, Long reservationRo , Equipment entity , Long mouth , Long day , Long initTime , Long destroyTime) {
        if (entity.getCapacity() < reservationRo) {
            throw new CustomException("-1" , "你所需的数量太多，不够获取");
        }
        if (reservationRo == 0) {
            throw new CustomException("-1" , "不能借0个东西，没有意义");
        }
        if (initTime >= destroyTime) {
            throw new CustomException("-1" , "你设置的开始时间和结束时间不合理");
        }
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(id);
        entity.setCapacity(entity.getCapacity() - reservationRo);
        entity.setStudentId(entity.getStudentId() + "&" + id + "&" + reservationRo);
        equipmentDao.updateByPrimaryKeySelective(entity);
        EquipmentReservation entityReservation = new EquipmentReservation();
        entityReservation.setMouth(mouth);
        entityReservation.setDay(day);
        entityReservation.setInitTime(initTime);
        entityReservation.setDestroyTime(destroyTime);
        entityReservation.setCapacity(reservationRo);
        entityReservation.setName(entity.getName());
        equipmentReservationDao.insertSelective(entityReservation);
        studentInfo.setEquipmentRe(studentInfo.getEquipmentRe() + "&" + entityReservation.getId());
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
    }

    public PageInfo<EquipmentReservation> getReservation(Integer pageNum, Integer pageSize, Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String equipmentRe = studentInfo.getEquipmentRe();
        String[] split = equipmentRe.split("&");
        List<Long> equipmentId = new ArrayList<>();
        for (String s : split) {
            if (ObjectUtil.isEmpty(s)) {
                continue;
            }
            equipmentId.add(Long.valueOf(s));
        }
        List<EquipmentReservation> equipment = new ArrayList<>();
        for (Long aLong : equipmentId) {
            EquipmentReservation equipment1 = equipmentReservationDao.selectByPrimaryKey(aLong);
            equipment.add(equipment1);
        }
        return PageInfo.of(equipment);
    }

    public PageInfo<EquipmentReservation> getReservationByName(Integer pageNum, Integer pageSize, Long userId, String name) {
        PageHelper.startPage(pageNum , pageSize);
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String equipmentRe = studentInfo.getEquipmentRe();
        String[] split = equipmentRe.split("&");
        List<Long> equipmentId = new ArrayList<>();
        for (String s : split) {
            if (ObjectUtil.isEmpty(s)) {
                continue;
            }
            equipmentId.add(Long.valueOf(s));
        }
        List<EquipmentReservation> equipment = new ArrayList<>();
        for (Long aLong : equipmentId) {
            EquipmentReservation equipment1 = equipmentReservationDao.selectByPrimaryKey(aLong);
            if (equipment1.getName().equals(name)) {
                equipment.add(equipment1);
            }
        }
        return PageInfo.of(equipment);
    }

    public void tuiding(Long id , Long userId , Long baofei) {
        EquipmentReservation equipmentReservation = equipmentReservationDao.selectByPrimaryKey(id);
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String equipmentRe = studentInfo.getEquipmentRe();
        String[] split = equipmentRe.split("&");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            if (ObjectUtil.isEmpty(s) || "null".equals(s) || Long.valueOf(s) == id) {
                continue;
            }
            list.add(s);
        }
        studentInfo.setEquipmentRe("");
        for (String s : list) {
            studentInfo.setEquipmentRe(studentInfo.getEquipmentRe() + "&" + s);
        }
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
        Equipment equipment = equipmentDao.selectByName2(equipmentReservation.getName());
        String studentId = equipment.getStudentId();
        String[] split1 = studentId.split("&");
        Long a = 0l , b = 0l;
        List<String> studentList = new ArrayList<>();
        for (String s : split1) {
            if (ObjectUtil.isEmpty(s) || "null".equals(s)) {
                continue;
            }
            if (studentInfo.getId() == Long.valueOf(s) && a == 0) {
                a++;
                continue;
            }
            if (a == 1) {
                b = Long.valueOf(s);
                a++;
                continue;
            }
            studentList.add(s);
        }
        equipment.setDestroyNum(equipment.getDestroyNum() + baofei);
        equipment.setCapacity(equipment.getCapacity() + b - baofei);
        equipment.setStudentId("");
        for (String s : studentList) {
            equipment.setStudentId(equipment.getStudentId() + "&" + s);
        }
        equipmentDao.updateByPrimaryKeySelective(equipment);
        equipmentReservationDao.deleteByPrimaryKey(id);
    }
}
