package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.PlayGroundDao;
import com.example.dao.StudentInfoDao;
import com.example.entity.PlayGround;
import com.example.entity.StudentInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayGroundService {
    @Resource
    private PlayGroundDao playGroundDao;

    @Resource
    private StudentInfoDao studentInfoDao;


    public void add(PlayGround playGround) {
        if (playGround.getInitTime() >= playGround.getDestroyTime()) {
            throw new CustomException("-1" , "你设置的开始时间比结束时间要晚，错误，请重新设置");
        }
        List<PlayGround> list = playGroundDao.findByName(playGround.getName());
        for (PlayGround ground : list) {
            if (ground.getMouth() == playGround.getMouth() && ground.getDay() == playGround.getDay()) {
                if (playGround.getInitTime() < ground.getDestroyTime()) {
                    throw new CustomException(ResultCode.Time_ERROR);
                }
            }
        }
        playGroundDao.insertSelective(playGround);
    }

    public void update(PlayGround playGround) {
        if (playGround.getInitTime() >= playGround.getDestroyTime()) {
            throw new CustomException("-1" , "你设置的开始时间比结束时间要晚，错误，请重新设置");
        }
        List<PlayGround> list = playGroundDao.findByName(playGround.getName());
        for (PlayGround ground : list) {
            if (ground.getMouth() == playGround.getMouth() && ground.getDay() == playGround.getDay()) {
                if (playGround.getInitTime() < ground.getDestroyTime()) {
                    throw new CustomException(ResultCode.Time_ERROR);
                }
            }
        }
        playGroundDao.updateByPrimaryKeySelective(playGround);
    }

    public void delete(Long id) {
        playGroundDao.deleteByPrimaryKey(id);
    }


    private List<PlayGround> findAll() {
        List<PlayGround> list = playGroundDao.selectAll();
        return list;
    }


    public PageInfo<PlayGround> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = findAll();
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByNameAndTypeAndMouthAndDay(Integer pageNum, Integer pageSize, String name, String type, Integer mouth, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPage(name , type , mouth , day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageName(name);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByNameAndType(Integer pageNum, Integer pageSize, String name, String type) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndType(name , type);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByNameAndTypeAndMouth(Integer pageNum, Integer pageSize, String name, String type, Integer mouth) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndTypeAndMouth(name , type , mouth);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByNameAndTypeAndDay(Integer pageNum, Integer pageSize, String name, String type, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndTypeAndDay(name , type , day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByNameAndMouthAndDay(Integer pageNum, Integer pageSize, String name, Integer mouth, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndMouthAndDay(name , mouth , day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByTypeAndMouthAndDay(Integer pageNum, Integer pageSize, String type, Integer mouth, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageTypeAndMouthAndDay(type , mouth , day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByNameAndMouth(Integer pageNum, Integer pageSize, String name, Integer mouth) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndMouth(name , mouth);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByNameAndDay(Integer pageNum, Integer pageSize, String name, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndDay(name , day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByTypeAndMouth(Integer pageNum, Integer pageSize, String type, Integer mouth) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageTypeAndMouth(type, mouth);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByTypeAndDay(Integer pageNum, Integer pageSize, String type, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageTypeAndDay(type, day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByMouthAndDay(Integer pageNum, Integer pageSize, Integer mouth, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageMouthAndDay(mouth, day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByType(Integer pageNum, Integer pageSize, String type) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageType(type);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> findPageByMouth(Integer pageNum, Integer pageSize, Integer mouth) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageMouth(mouth);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }
    public PageInfo<PlayGround> findPageByDay(Integer pageNum, Integer pageSize, Integer day) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageDay(day);
        for (PlayGround playGround : list) {
            if (playGround.getReservation() != -1) {
                Long reservation = playGround.getReservation();
                playGround.setReservationName(studentInfoDao.selectByPrimaryKey(reservation).getName());
            }
        }
        return PageInfo.of(list);
    }


    public void reservation(Long id , Long userId) {
        PlayGround playGround = playGroundDao.selectByPrimaryKey(id);
        playGround.setReservation(userId);
        playGround.setState("被预约");
        playGroundDao.updateByPrimaryKeySelective(playGround);
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        studentInfo.setPlayGroundRe(playGroundRe + "&" + id);
        playGround.setReservationName(studentInfo.getName());
//        一定要注意更新到数据库当中
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
    }

//    下面是预约之后的展示

    public PageInfo<PlayGround> reservationfindPage(Integer pageNum, Integer pageSize , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (String s : split) {
            if ("null".equals(s)) {
                continue;
            }
            Long aLong = Long.valueOf(s);
            PlayGround playGround = playGroundDao.selectByPrimaryKey(aLong);
            list.add(playGround);
        }
        return PageInfo.of(list);
    }

    public PageInfo<PlayGround> reservationfindPageByNameAndTypeAndMouthAndDay(Integer pageNum, Integer pageSize, String name, String type, Integer mouth, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPage(name , type , mouth , day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByName(Integer pageNum, Integer pageSize, String name , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageName(name);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByNameAndType(Integer pageNum, Integer pageSize, String name, String type , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndType(name , type);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByNameAndTypeAndMouth(Integer pageNum, Integer pageSize, String name, String type, Integer mouth , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndTypeAndMouth(name , type , mouth);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByNameAndTypeAndDay(Integer pageNum, Integer pageSize, String name, String type, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndTypeAndDay(name , type , day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByNameAndMouthAndDay(Integer pageNum, Integer pageSize, String name, Integer mouth, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndMouthAndDay(name , mouth , day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByTypeAndMouthAndDay(Integer pageNum, Integer pageSize, String type, Integer mouth, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageTypeAndMouthAndDay(type , mouth , day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByNameAndMouth(Integer pageNum, Integer pageSize, String name, Integer mouth , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndMouth(name , mouth);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByNameAndDay(Integer pageNum, Integer pageSize, String name, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageNameAndDay(name , day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByTypeAndMouth(Integer pageNum, Integer pageSize, String type, Integer mouth , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageTypeAndMouth(type, mouth);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByTypeAndDay(Integer pageNum, Integer pageSize, String type, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageTypeAndDay(type, day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByMouthAndDay(Integer pageNum, Integer pageSize, Integer mouth, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageMouthAndDay(mouth, day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByType(Integer pageNum, Integer pageSize, String type , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageType(type);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public PageInfo<PlayGround> reservationfindPageByMouth(Integer pageNum, Integer pageSize, Integer mouth , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageMouth(mouth);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }
    public PageInfo<PlayGround> reservationfindPageByDay(Integer pageNum, Integer pageSize, Integer day , Long userId) {
        PageHelper.startPage(pageNum , pageSize);
        List<PlayGround> list = playGroundDao.findPageDay(day);
        List<PlayGround> list1 = new ArrayList<>();
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        for (PlayGround playGround : list) {
            for (String s : split) {
                if ("null".equals(s)) {
                    continue;
                }
                Long aLong = Long.valueOf(s);
                if (aLong == playGround.getId()) {
                    list1.add(playGround);
                }
            }
        }
        return PageInfo.of(list1);
    }

    public void reservationTuiding(Long id , Long userId) {
        PlayGround playGround = playGroundDao.selectByPrimaryKey(id);
        StudentInfo studentInfo = studentInfoDao.selectByPrimaryKey(userId);
        playGround.setReservation(-1l);
        playGround.setReservationName(null);
        playGround.setState("");
        String playGroundRe = studentInfo.getPlayGroundRe();
        String[] split = playGroundRe.split("&");
        String sp = "";
        for (String s : split) {
            if ("null".equals(s) || Long.valueOf(s) == id) {
                continue;
            }
            sp += "&" + s;
        }
        studentInfo.setPlayGroundRe("null" + sp);
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
        playGroundDao.updateByPrimaryKeySelective(playGround);
    }
}
