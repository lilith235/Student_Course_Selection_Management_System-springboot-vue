package com.rainng.coursesystem.controller.student;

import com.rainng.coursesystem.config.themis.annotation.Student;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.vo.request.StudentInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.student.StudentInfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Student
@RequestMapping("/student/info")
@RestController
public class StudentInfoController extends BaseController {
    private final StudentInfoService service;

    public StudentInfoController(StudentInfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResultVO get() {
        return service.get();
    }

    @PutMapping
    public ResultVO update(@RequestBody @Validated StudentInfoFormVO formVO) {
        return service.update(formVO);
    }
}
