package com.fc.service.impl;

import com.fc.dao.PoorMapper;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
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
public class PoorServiceImpl implements PoorService {

    @Autowired
    private PoorMapper poorMapper;


    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, String id) {
        ResultVO resultVO = null;
        List<PoorWithBLOBs> poors = new ArrayList<>();
        PoorWithBLOBs poor;
        try {
            if (id != null) {
                poor = poorMapper.selectByPrimaryKey(Long.parseLong(id));
                if (poor != null) {
                    poors.add(poor);

                    poorMapper.updateLastClickTimeAndClickNum(new Date(), poor.getId());
                }
            }else {
                PageHelper.startPage(pageNum, pageSize);
                poors = poorMapper.selectByExampleWithBLOBs(null);
            }

            PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(poors);
            DataVO dataVO = new DataVO(pageInfo.getTotal(), poors, pageInfo.getPageNum(), pageInfo.getPageSize());
            resultVO = new ResultVO("查询成功", 200, true, dataVO);


        }catch (Exception e) {
            resultVO = new ResultVO("查询失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO insert(PoorWithBLOBs poor) {
        ResultVO resultVO = null;

        if (poor != null) {
            poor.setCreateTime(new Date());
            poor.setClickNum(0);
            poor.setCreateTime(null);
        }

        int rows = poorMapper.insertSelective(poor);

        if (rows > 0) {
            resultVO = new ResultVO("添加成功", 200, true, poor);
        }else {
            resultVO = new ResultVO("添加失败", -100, false, new DataVO());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO resultVO = null;

        int rows = poorMapper.deleteByPrimaryKey(id);

        if (rows > 0) {
            resultVO = new ResultVO("删除成功", 200, true, new DataVO());
        }else {
            resultVO = new ResultVO("删除失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO update(PoorWithBLOBs poor) {
        ResultVO resultVO = null;

        int rows = poorMapper.updateByPrimaryKeySelective(poor);

        if (rows > 0) {
            PoorWithBLOBs updatedPoor = poorMapper.selectByPrimaryKey(poor.getId());

            resultVO = new ResultVO("修改成功", 200, true, updatedPoor);
        }else {
            resultVO = new ResultVO("修改失败", -100, false, new DataVO());
        }
        return resultVO;
    }
}
