package com.fc.dao;

import com.fc.entity.Alleviation;
import com.fc.entity.AlleviationExample;
import java.util.List;

import com.fc.entity.AlleviationWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface AlleviationMapper {
    long countByExample(AlleviationExample example);

    int deleteByExample(AlleviationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Alleviation record);

    int insertSelective(Alleviation record);

    List<AlleviationWithBLOBs> selectByExampleWithBLOBs(AlleviationExample example);

    List<Alleviation> selectByExample(AlleviationExample example);

    AlleviationWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByExampleWithBLOBs(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByExample(@Param("record") Alleviation record, @Param("example") AlleviationExample example);

    int updateByPrimaryKeySelective(Alleviation record);

    int updateByPrimaryKeyWithBLOBs(Alleviation record);

    int updateByPrimaryKey(Alleviation record);
}