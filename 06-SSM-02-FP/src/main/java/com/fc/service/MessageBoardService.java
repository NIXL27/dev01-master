package com.fc.service;

import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVO;

public interface MessageBoardService {

    ResultVO getList(Integer pageNo, Integer pageSize, String id);

    ResultVO insert(MessageBoardWithBLOBs messageBoard);

    ResultVO delete(Long id);

}
