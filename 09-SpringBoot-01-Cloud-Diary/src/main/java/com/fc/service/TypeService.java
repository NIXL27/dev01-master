package com.fc.service;

import com.fc.entity.TbNoteType;
import com.fc.vo.ResultVO;

import java.util.List;

public interface TypeService {
    List<TbNoteType> getTypes(Integer id);

    ResultVO add(TbNoteType tbNoteType, Integer id);

    ResultVO update(TbNoteType tbNoteType);

    ResultVO delete(Integer id);
}
