package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.teacher.CourseManager;
import com.rainng.coursesystem.model.entity.CourseEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherCourseItemVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.util.LessonTimeConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacher_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public CourseService(CourseManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO list() {
        Integer teacherId = getUserId();

        List<TeacherCourseItemVO> list = manager.listTeacherCourse(teacherId);
        for (TeacherCourseItemVO vo : list) {
            vo.setTime(lessonTimeConverter.covertTimePart(vo.getTime()));
        }

        return result(list);
    }

    public ResultVO create(CourseEntity entity) {
        Integer teacherId = getUserId();
        entity.setTeacherId(teacherId);
        if (manager.get(entity.getId()) != null) {
            return failedResult("课程Id: " + entity.getId() + "已存在!");
        }
        manager.create(entity);
        return result("添加成功");
    }
}
