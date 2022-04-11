package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface AlleviationService {
    ResultVO getList(Integer pageNo, Integer pageSize, String id);

    ResultVO insert(Alleviation alleviation);

    ResultVO delete(Long id);

    ResultVO update(Alleviation alleviation);
}
