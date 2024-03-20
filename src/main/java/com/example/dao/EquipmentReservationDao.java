package com.example.dao;

import com.example.entity.Equipment;
import com.example.entity.EquipmentReservation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface EquipmentReservationDao extends Mapper<EquipmentReservation> {


}
