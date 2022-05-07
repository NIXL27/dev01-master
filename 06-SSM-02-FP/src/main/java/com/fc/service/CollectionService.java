package com.fc.service;

import com.fc.entity.Collection;
import com.fc.vo.ResultVO;

public interface CollectionService {

    ResultVO getList(Integer pageNum, Integer pageSize, String id);

    ResultVO insert(Collection collection);

    ResultVO delete(Long id);

    ResultVO update(Collection collection);
}
