package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.entity.AlleviationWithBLOBs;
import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface AlleviationService {
    ResultVO getList(Integer pageNum, Integer pageSize, String id);

    ResultVO insert(AlleviationWithBLOBs alleviation);

    ResultVO delete(Long id);

    ResultVO update(AlleviationWithBLOBs alleviation);
}
