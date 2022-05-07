package com.fc.service;

import com.fc.entity.TbNote;
import com.fc.vo.NoteVO;
import com.fc.vo.ResultVO;

public interface NoteService {
    ResultVO update(TbNote note);

    ResultVO add(TbNote note);

    NoteVO getNoteById(Integer id);

    ResultVO delete(Integer id);
}
