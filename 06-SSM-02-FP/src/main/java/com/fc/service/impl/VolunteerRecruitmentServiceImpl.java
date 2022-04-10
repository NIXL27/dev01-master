package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.dao.VolunteerRecruitmentMapper;
import com.fc.entity.Collection;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.CollectionService;
import com.fc.service.VolunteerRecruitmentService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VolunteerRecruitmentServiceImpl implements VolunteerRecruitmentService {

    @Autowired
    private VolunteerRecruitmentMapper volunteerRecruitmentMapper;


    @Override
    public ResultVO getList(Integer pageNo, Integer pageSize, String id) {
        ResultVO resultVO = null;
        List<VolunteerRecruitment> volunteerRecruitments = new ArrayList<>();
        VolunteerRecruitment volunteerRecruitment;
        try {
            if (id != null) {
                volunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(Long.parseLong(id));
                if (volunteerRecruitment != null) {
                    volunteerRecruitments.add(volunteerRecruitment);
                }
            }else {
                PageHelper.startPage(pageNo, pageSize);
                volunteerRecruitments = volunteerRecruitmentMapper.selectByExample(null);
            }

            PageInfo<VolunteerRecruitment> pageInfo = new PageInfo<>(volunteerRecruitments);
            DataVO dataVO = new DataVO(pageInfo.getTotal(), volunteerRecruitments, pageInfo.getPageNum(), pageInfo.getPageSize());
            resultVO = new ResultVO("查询成功", 200, true, dataVO);


        }catch (Exception e) {
            resultVO = new ResultVO("查询失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO insert(VolunteerRecruitment volunteerRecruitment) {
        ResultVO resultVO = null;

        if (volunteerRecruitment != null) {
            volunteerRecruitment.setCreateTime(new Date());
        }

        int rows = volunteerRecruitmentMapper.insertSelective(volunteerRecruitment);

        if (rows > 0) {
            resultVO = new ResultVO("添加成功", 200, true, volunteerRecruitment);
        }else {
            resultVO = new ResultVO("添加失败", -100, false, new DataVO());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO resultVO = null;

        int rows = volunteerRecruitmentMapper.deleteByPrimaryKey(id);

        if (rows > 0) {
            resultVO = new ResultVO("删除成功", 200, true, new DataVO());
        }else {
            resultVO = new ResultVO("删除失败", -100, false, new DataVO());
        }


        return resultVO;
    }

    @Override
    public ResultVO update(VolunteerRecruitment volunteerRecruitment) {
        ResultVO resultVO = null;

        int rows = volunteerRecruitmentMapper.updateByPrimaryKeySelective(volunteerRecruitment);

        if (rows > 0) {
            VolunteerRecruitment updatedVolunteerRecruitment = volunteerRecruitmentMapper.selectByPrimaryKey(volunteerRecruitment.getId());

            resultVO = new ResultVO("修改成功", 200, true, updatedVolunteerRecruitment);
        }else {
            resultVO = new ResultVO("修改失败", -100, false, new DataVO());
        }
        return resultVO;
    }
}
