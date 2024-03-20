package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.StudentInfoDao;
import com.example.entity.*;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentInfoService {
    @Resource
    private StudentInfoDao studentInfoDao;



    public Account login(String name, String password) {
        StudentInfo studentInfo = studentInfoDao.findByNameAndPass(name , password);
        if (studentInfo.getLegal() == 0l) {
            throw new CustomException("-1" , "你所注册的学生账户还没有被管理员同意，所以不能登录，请等待");
        }
        if (ObjectUtil.isEmpty(studentInfo)) {
            throw new CustomException("-1" , "用户名，密码或角色错误");
        }
        return studentInfo;
    }

    public void register(StudentInfo studentInfo) {
        StudentInfo studentInfo1 = studentInfoDao.findByName(studentInfo.getName());
        if (ObjectUtil.isNotEmpty(studentInfo1)) {
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        studentInfoDao.insertSelective(studentInfo);
    }

    public StudentInfo findById(Long id) {
        return studentInfoDao.selectByPrimaryKey(id);
    }

    public void update(StudentInfo studentInfo) {
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
    }

    public void add(StudentInfo studentInfo) {
        StudentInfo studentInfo1 = studentInfoDao.findByName(studentInfo.getName());
        if (ObjectUtil.isNotEmpty(studentInfo1)) {
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(studentInfo.getPassword())) {
            studentInfo.setPassword("123");
        }

        studentInfoDao.insertSelective(studentInfo);
    }


    public List<StudentInfo> findAll() {
        List<StudentInfo> studentInfos = studentInfoDao.selectAll();
        return studentInfos;
    }

    public void deleteById(Long id) {
        studentInfoDao.deleteByPrimaryKey(id);
    }

    public PageInfo<StudentInfo> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<StudentInfo> list = findAll();
        return PageInfo.of(list);
    }

    public PageInfo<StudentInfo> findPageName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum , pageSize);
        List<StudentInfo> list = studentInfoDao.findByNamePage(name);
        return PageInfo.of(list);
    }

    public void setMailBox(StudentInfo studentInfo, String mailbox) {
        studentInfo.setMailbox(mailbox);
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
    }

    public void agree(StudentInfo studentInfo) {
        studentInfo.setLegal(1l);
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
    }

    public void disagree(Long id) {
        studentInfoDao.deleteByPrimaryKey(id);
    }
}
