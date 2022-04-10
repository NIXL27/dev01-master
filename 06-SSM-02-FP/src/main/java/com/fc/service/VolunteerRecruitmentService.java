package com.fc.service;

import com.fc.entity.Collection;
import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVO;

public interface VolunteerRecruitmentService {

    ResultVO getList(Integer pageNo, Integer pageSize, String id);

    ResultVO insert(VolunteerRecruitment volunteerRecruitment);

    ResultVO delete(Long id);

    ResultVO update(VolunteerRecruitment volunteerRecruitment);
}
