package com.fc.service;

import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVO;

public interface PoorService {

    ResultVO getList(Integer pageNum, Integer pageSize, String id);

    ResultVO insert(PoorWithBLOBs poor);

    ResultVO delete(Long id);

    ResultVO update(PoorWithBLOBs poor);
}
