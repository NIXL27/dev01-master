package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.entity.VolunteerRecruitmentWithBLOBs;
import com.fc.service.VolunteerRecruitmentService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")
public class VolunteerRecruitmentController {

    @Autowired
    private VolunteerRecruitmentService volunteerRecruitmentService;

    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return volunteerRecruitmentService.getList(pageNum, pageSize, id);
    }

    @RequestMapping("add")
    public ResultVO insert(@RequestBody VolunteerRecruitmentWithBLOBs volunteerRecruitment) {
        return volunteerRecruitmentService.insert(volunteerRecruitment);
    }

    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return volunteerRecruitmentService.delete(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody VolunteerRecruitmentWithBLOBs volunteerRecruitment) {
        return volunteerRecruitmentService.update(volunteerRecruitment);
    }

}









