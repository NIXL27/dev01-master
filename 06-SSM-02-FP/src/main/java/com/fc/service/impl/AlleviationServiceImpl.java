package com.fc.service.impl;

import com.fc.dao.AlleviationMapper;
import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Service
public class AlleviationServiceImpl implements AlleviationService {
    @Autowired
    AlleviationMapper alleviationMapper;

    @Override
    public ResultVO getList(Integer pageNo, Integer pageSize, String id) {
        ResultVO resultVO = null;
        List<Alleviation> alleviations = new ArrayList<>();
        Alleviation alleviation;
        try {
            if (id != null) {
                alleviation = alleviationMapper.selectByPrimaryKey(Long.parseLong(id));


                if (alleviation != null) {
                    alleviations.add(alleviation);


                    // 更改最后一次点击时间和点击次数
                    alleviation.setLastClickTime(new Date());
                    alleviation.setClickNum(alleviation.getClickNum() + 1);

                    alleviationMapper.updateByPrimaryKeySelective(alleviation);

                }
            }else {
                PageHelper.startPage(pageNo, pageSize);
                alleviations = alleviationMapper.selectByExample(null);
            }

            PageInfo<Alleviation> pageInfo = new PageInfo<>(alleviations);
            DataVO dataVO = new DataVO(pageInfo.getTotal(), alleviations, pageInfo.getPageNum(), pageInfo.getPageSize());
            resultVO = new ResultVO("查询成功", 200, true, dataVO);


        }catch (Exception e) {
            resultVO = new ResultVO("查询失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO insert(Alleviation alleviation) {
        ResultVO resultVO = null;

        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy");

        Integer year = Integer.parseInt(format.format(date));

        System.out.println(year);

        // 设置创建时间，点击次数，最后一次点击时间，发布时间
        alleviation.setCreateTime(date);
        alleviation.setClickNum(0);
        alleviation.setLastClickTime(null);
        alleviation.setReleaseTime(year);

        int rows = alleviationMapper.insertSelective(alleviation);

        if (rows > 0) {
            resultVO = new ResultVO("添加成功", 200, true, alleviation);
        }else {
            resultVO = new ResultVO("添加失败", -100, false, new DataVO());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO resultVO = null;

        int rows = alleviationMapper.deleteByPrimaryKey(id);

        if (rows > 0) {
            resultVO = new ResultVO("删除成功", 200, true, new DataVO());
        }else {
            resultVO = new ResultVO("删除失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO update(Alleviation alleviation) {
        ResultVO resultVO = null;

        int rows = alleviationMapper.updateByPrimaryKeySelective(alleviation);

        if (rows > 0) {
            Alleviation updatedCarousel = alleviationMapper.selectByPrimaryKey(alleviation.getId());

            resultVO = new ResultVO("修改成功", 200, true, updatedCarousel);
        }else {
            resultVO = new ResultVO("修改失败", -100, false, new DataVO());
        }
        return resultVO;
    }
}
