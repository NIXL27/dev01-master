package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.IndexService;
import com.fc.vo.NoteVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private TbNoteMapper tbNoteMapper;

    @Override
    public PageInfo<TbNote> page(Integer pageNum, Integer pageSize, Integer userId, Integer id, String title, String date) {
        // 准备模糊查询的条件
        if (title != null && !title.equals("")) {
            title = "%" + title + "%";
        }

        // 开启分页
        PageHelper.startPage(pageNum, pageSize);

        List<TbNote> notes = tbNoteMapper.findByPageAndUserId(userId, id, title, date);

        return new PageInfo<>(notes);
    }

    // 获取类别分类列表
    @Override
    public List<NoteVO> findTypeInfo(Integer userId) {
        return tbNoteMapper.findTypeInfo(userId);
    }

    // 获取日期分类列表
    @Override
    public List<NoteVO> findDateInfo(Integer userId) {
        return tbNoteMapper.findDateInfo(userId);
    }
}
