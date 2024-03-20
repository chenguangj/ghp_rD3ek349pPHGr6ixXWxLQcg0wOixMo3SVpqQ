package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.AdminInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminInfoService {
    @Resource
    private AdminInfoDao adminInfoDao;

    public Account login(String name, String password) {
        AdminInfo adminInfo = adminInfoDao.findByNameAndPass(name , password);
        return adminInfo;
    }

    public AdminInfo findById(Long id) {
        return adminInfoDao.selectByPrimaryKey(id);
    }

    public void update(AdminInfo adminInfo) {
        adminInfoDao.updateByPrimaryKeySelective(adminInfo);
    }

    public void add(AdminInfo adminInfo) {
        AdminInfo adminInfo1 = adminInfoDao.findByName(adminInfo.getName());
        if (ObjectUtil.isNotEmpty(adminInfo1)) {
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        if (ObjectUtil.isEmpty(adminInfo.getPassword())) {
            adminInfo.setPassword("123");
        }


        adminInfoDao.insertSelective(adminInfo);
    }

    public List<AdminInfo> findAll() {
        return adminInfoDao.selectAll();
    }

    public void deleteById(Long id) {
        adminInfoDao.deleteByPrimaryKey(id);
    }

    public PageInfo<AdminInfo> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<AdminInfo> list = adminInfoDao.selectAll();
        return PageInfo.of(list);
    }

    public PageInfo<AdminInfo> findPageName(Integer pageNum, Integer pageSize, String name) {
        PageHelper.startPage(pageNum , pageSize);
        List<AdminInfo> list = adminInfoDao.findByNamePage(name);
        return PageInfo.of(list);
    }
}
