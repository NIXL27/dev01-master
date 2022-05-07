package com.fc.dao;

import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface TbNoteTypeMapper {
    long countByExample(TbNoteTypeExample example);

    int deleteByExample(TbNoteTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbNoteType record);

    int insertSelective(TbNoteType record);

    List<TbNoteType> selectByExample(TbNoteTypeExample example);

    TbNoteType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbNoteType record, @Param("example") TbNoteTypeExample example);

    int updateByExample(@Param("record") TbNoteType record, @Param("example") TbNoteTypeExample example);

    int updateByPrimaryKeySelective(TbNoteType record);

    int updateByPrimaryKey(TbNoteType record);

    List<TbNoteType> selectByUserId(@Param("id") Integer id);

    Integer selectTypeWithNote(@Param("id") Integer id);
}