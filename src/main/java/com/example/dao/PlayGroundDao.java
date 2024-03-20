package com.example.dao;

import com.example.entity.PlayGround;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PlayGroundDao extends Mapper<PlayGround> {


    @Select("select * from playground where name = #{name}")
    List<PlayGround> findByName(@Param("name") String name);

    @Select("select * from playground where name like concat('%' , #{name} , '%')")
    List<PlayGround> findPageName(@Param("name") String name);

    @Select("select * from playground where type like concat('%' , #{type} , '%')")
    List<PlayGround> findPageType(@Param("type") String type);

    @Select("select * from playground where mouth like concat('%' , #{mouth} , '%')")
    List<PlayGround> findPageMouth(@Param("mouth") Integer mouth);

    @Select("select * from playground where day like concat('%' , #{day} , '%')")
    List<PlayGround> findPageDay(@Param("day") Integer day);

    @Select("select * from playground where name like concat('%' , #{name} , '%') and type like concat('%' , #{type} , '%')")
    List<PlayGround> findPageNameAndType(@Param("name") String name, @Param("type") String type);

    @Select("select * from playground where name like concat('%' , #{name} , '%') and mouth like concat('%' , #{mouth} , '%')")
    List<PlayGround> findPageNameAndMouth(@Param("name") String name, @Param("mouth") Integer mouth);

    @Select("select * from playground where name like concat('%' , #{name} , '%') and day like concat('%' , #{day} , '%')")
    List<PlayGround> findPageNameAndDay(@Param("name") String name, @Param("day") Integer day);

    @Select("select * from playground where type like concat('%' , #{type} , '%') and mouth like concat('%' , #{mouth} , '%')")
    List<PlayGround> findPageTypeAndMouth(@Param("type") String type, @Param("mouth") Integer mouth);

    @Select("select * from playground where type like concat('%' , #{type} , '%') and day like concat('%' , #{day} , '%')")
    List<PlayGround> findPageTypeAndDay(@Param("type") String type, @Param("day") Integer day);

    @Select("select * from playground where mouth like concat('%' , #{mouth} , '%') and day like concat('%' , #{day} , '%')")
    List<PlayGround> findPageMouthAndDay(@Param("mouth") Integer mouth, @Param("day") Integer day);

    @Select("select * from playground where name like concat('%' , #{name} , '%') and type like concat('%' , #{type} , '%') and mouth like concat('%' , #{mouth} , '%')")
    List<PlayGround> findPageNameAndTypeAndMouth(@Param("name") String name, @Param("type") String type, @Param("mouth") Integer mouth);

    @Select("select * from playground where name like concat('%' , #{name} , '%') and type like concat('%' , #{type} , '%') and day like concat('%' , #{day} , '%')")
    List<PlayGround> findPageNameAndTypeAndDay(@Param("name") String name, @Param("type") String type, @Param("day") Integer day);

    @Select("select * from playground where name like concat('%' , #{name} , '%') and mouth like concat('%' , #{mouth} , '%') and day like concat('%' , #{day} , '%')")
    List<PlayGround> findPageNameAndMouthAndDay(@Param("name") String name, @Param("mouth") Integer mouth, @Param("day") Integer day);

    @Select("select * from playground where type like concat('%' , #{type} , '%') and mouth like concat('%' , #{mouth} , '%') and day like concat('%' , #{day} , '%')")
    List<PlayGround> findPageTypeAndMouthAndDay(@Param("type") String type, @Param("mouth") Integer mouth, @Param("day") Integer day);


    @Select("select * from playground where type like concat('%' , #{type} , '%') and mouth like concat('%' , #{mouth} , '%') and day like concat('%' , #{day} , '%') and name like concat('%' , #{name} , '%')")
    List<PlayGround> findPage(@Param("name") String name, @Param("type") String type, @Param("mouth") Integer mouth, @Param("day") Integer day);


}
