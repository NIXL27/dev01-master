package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteExample;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.service.TypeService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TbNoteTypeMapper typeMapper;

    @Autowired
    private TbNoteMapper noteMapper;

    @Override
    public List<TbNoteType> getTypes(Integer id) {
        TbNoteTypeExample tbNoteTypeExample = new TbNoteTypeExample();

        TbNoteTypeExample.Criteria criteria = tbNoteTypeExample.createCriteria();

        criteria.andUserIdEqualTo(id);
        return typeMapper.selectByExample(tbNoteTypeExample);
    }

    // 添加操作需要用户id
    @Override
    public ResultVO add(TbNoteType tbNoteType, Integer id) {
        ResultVO resultVO = new ResultVO();

        TbNoteType noteType = new TbNoteType();

        noteType.setTypeName(tbNoteType.getTypeName());
        noteType.setUserId(id);

        int rows = typeMapper.insertSelective(noteType);

        if (rows > 0){
            resultVO.setCode(1);
            resultVO.setMessage("添加成功");
            resultVO.setData(noteType.getId());
        } else {
            resultVO.setCode(0);
            resultVO.setMessage("添加失败");
        }

        return resultVO;
    }

    @Override
    public ResultVO update(TbNoteType tbNoteType) {
        ResultVO resultVO = new ResultVO();

        int rows = typeMapper.updateByPrimaryKeySelective(tbNoteType);

        if (rows > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("修改成功");
            resultVO.setData(tbNoteType.getId());
        } else {
            resultVO.setCode(0);
            resultVO.setMessage("修改失败");
        }

        return resultVO;
    }

    @Override
    public ResultVO delete(Integer id) {
        ResultVO vo = new ResultVO();

        TbNoteExample example = new TbNoteExample();

        TbNoteExample.Criteria criteria = example.createCriteria();

        criteria.andTypeIdEqualTo(id);

        List<TbNote> notes = noteMapper.selectByExample(example);

        int rows = 0;
        if (notes.isEmpty()) {
            rows = typeMapper.deleteByPrimaryKey(id);
        }
        if (rows > 0) {
            vo.setCode(1);
            vo.setMessage("删除成功！");
        } else {
            vo.setCode(0);
            vo.setMessage("删除失败！！！");
        }

        return vo;
    }
}
