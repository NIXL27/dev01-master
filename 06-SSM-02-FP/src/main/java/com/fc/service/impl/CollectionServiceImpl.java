package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.entity.Collection;
import com.fc.service.CollectionService;
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
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    private CollectionMapper collectionMapper;


    @Override
    public ResultVO getList(Integer pageNo, Integer pageSize, String id) {
        ResultVO resultVO = null;
        List<Collection> collections = new ArrayList<>();
        Collection collection;
        try {
            if (id != null) {
                 collection = collectionMapper.selectByPrimaryKey(Long.parseLong(id));
                if (collection != null) {
                    collections.add(collection);
                }
            }else {
                PageHelper.startPage(pageNo, pageSize);
                collections = collectionMapper.selectByExample(null);
            }

            PageInfo<Collection> pageInfo = new PageInfo<>(collections);
            DataVO dataVO = new DataVO(pageInfo.getTotal(), collections, pageInfo.getPageNum(), pageInfo.getPageSize());
            resultVO = new ResultVO("查询成功", 200, true, dataVO);


        }catch (Exception e) {
            resultVO = new ResultVO("查询失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO insert(Collection collection) {
        ResultVO resultVO = null;

        if (collection != null) {
            collection.setCreateTime(new Date());
        }

        int rows = collectionMapper.insertSelective(collection);

        if (rows > 0) {
            resultVO = new ResultVO("添加成功", 200, true, collection);
        }else {
            resultVO = new ResultVO("添加失败", -100, false, new DataVO());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO resultVO = null;

        int rows = collectionMapper.deleteByPrimaryKey(id);

        if (rows > 0) {
            resultVO = new ResultVO("删除成功", 200, true, new DataVO());
        }else {
            resultVO = new ResultVO("删除失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO update(Collection collection) {
        ResultVO resultVO = null;

        int rows = collectionMapper.updateByPrimaryKeySelective(collection);

        if (rows > 0) {
            Collection updatedCollection = collectionMapper.selectByPrimaryKey(collection.getId());

            resultVO = new ResultVO("修改成功", 200, true, updatedCollection);
        }else {
            resultVO = new ResultVO("修改失败", -100, false, new DataVO());
        }
        return resultVO;
    }
}
