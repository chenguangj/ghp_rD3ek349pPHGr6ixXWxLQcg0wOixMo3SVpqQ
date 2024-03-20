package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.AdminInfoDao;
import com.example.dao.TeacherInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.TeacherInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherInfoService {
    @Resource
    private TeacherInfoDao teacherInfoDao;

    public void register(TeacherInfo teacherInfo) {
//        我们要先通过名字去查看数据库之中是否右透明的用户存在，若是存在，那提示信息，不允许注册
        TeacherInfo Info = teacherInfoDao.findByName(teacherInfo.getName());
        if (ObjectUtil.isNotEmpty(Info)) {
//            对于用户名已经存在的注册时候，会返回信息给用户查看，下面使用到自定义异常来进行错误信息返回
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
//        若是当前用户名不存在，那直接进行创建即可，下面也是直接使用到Mybatis里面的方法
        teacherInfoDao.insertSelective(teacherInfo);
    }

    public Account login(String name, String password) {
        TeacherInfo teacherInfo = teacherInfoDao.findByNameAndPass(name , password);
        if (ObjectUtil.isEmpty(teacherInfo)) {
            throw new CustomException("-1" , "用户名，密码或角色错误");
        }
        return teacherInfo;
    }

    public TeacherInfo findById(Long id) {
        return teacherInfoDao.selectByPrimaryKey(id);
    }

    public void update(TeacherInfo teacherInfo) {
        teacherInfoDao.updateByPrimaryKeySelective(teacherInfo);
    }

    public List<TeacherInfo> findAll() {
        return teacherInfoDao.selectAll();
    }

    public void add(TeacherInfo teacherInfo) {
        TeacherInfo byName = teacherInfoDao.findByName(teacherInfo.getName());
        if (ObjectUtil.isNotEmpty(byName)) {
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(teacherInfo.getPassword())) {
            teacherInfo.setPassword("123");
        }
        teacherInfoDao.insertSelective(teacherInfo);
    }

    public void deleteById(Long id) {
        teacherInfoDao.deleteByPrimaryKey(id);
    }

    public PageInfo findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<TeacherInfo> list = teacherInfoDao.selectAll();
        return PageInfo.of(list);
    }

    public PageInfo<TeacherInfo> findPageSearch(String search , Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<TeacherInfo> list = teacherInfoDao.findByLikeName(search);
        return PageInfo.of(list);
    }

    public void setMailBox(TeacherInfo teacherInfo, String mailbox) {
        teacherInfo.setMailbox(mailbox);
        teacherInfoDao.updateByPrimaryKeySelective(teacherInfo);
    }
}
