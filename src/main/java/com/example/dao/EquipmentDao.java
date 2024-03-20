package com.example.dao;

import com.example.entity.Equipment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface EquipmentDao extends Mapper<Equipment> {


    @Select("select * from equipment where name like concat('%' , #{name} , '%')")
    List<Equipment> selectByName(@Param("name") String name);

    @Select("select * from equipment where name = #{name}")
    Equipment selectByName2(@Param("name") String name);
}
