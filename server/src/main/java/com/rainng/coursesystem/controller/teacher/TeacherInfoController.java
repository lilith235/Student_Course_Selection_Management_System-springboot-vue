package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Teacher;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.request.TeacherInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;

import com.rainng.coursesystem.service.teacher.TeacherInfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Teacher
@RequestMapping("/teacher/info")
@RestController
public class TeacherInfoController extends BaseController {
    private final TeacherInfoService service;

    public TeacherInfoController(TeacherInfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated TeacherInfoFormVO formVO) {
        return service.update(formVO);
    }
}
