package com.rainng.coursesystem.controller.teacher;

import com.rainng.coursesystem.config.themis.annotation.Teacher;
import com.rainng.coursesystem.controller.BaseController;
import com.rainng.coursesystem.model.entity.CourseEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.teacher.CourseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Teacher
@RequestMapping("/teacher/course")
@RestController("teacher_courseController")
public class CourseController extends BaseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResultVO create(@RequestBody @Validated CourseEntity entity) {
        return service.create(entity);
    }

    @RequestMapping("/list")
    public ResultVO list() {
        return service.list();
    }
}
