package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.NoticeDao;
import com.example.entity.Notice;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeService {
    @Resource
    private NoticeDao noticeDao;


    public Notice getNotice(Long id) {
        Notice notice = noticeDao.selectByPrimaryKey(id);
        return notice;
    }

    public void update(Notice notice) {
        noticeDao.updateByPrimaryKeySelective(notice);
    }

}
