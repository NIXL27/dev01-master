package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.entity.VolunteerRecruitmentWithBLOBs;
import com.fc.vo.ResultVO;

public interface VolunteerRecruitmentService {

    ResultVO getList(Integer pageNum, Integer pageSize, String id);

    ResultVO insert(VolunteerRecruitmentWithBLOBs volunteerRecruitment);

    ResultVO delete(Long id);

    ResultVO update(VolunteerRecruitmentWithBLOBs volunteerRecruitment);
}
