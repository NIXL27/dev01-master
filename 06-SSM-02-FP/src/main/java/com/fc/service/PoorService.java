package com.fc.service;

import com.fc.entity.Collection;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVO;

public interface PoorService {

    ResultVO getList(Integer pageNo, Integer pageSize, String id);

    ResultVO insert(PoorWithBLOBs poor);

    ResultVO delete(Long id);

    ResultVO update(PoorWithBLOBs poor);
}
