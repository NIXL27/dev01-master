package com.fc.service;

import com.fc.entity.Collection;
import com.fc.vo.ResultVO;

public interface CollectionService {

    ResultVO getList(Integer pageNo, Integer pageSize, String id);

    ResultVO insert(Collection collection);

    ResultVO delete(Long id);

    ResultVO update(Collection collection);
}
