package com.rainng.coursesystem.service.student;

import com.rainng.coursesystem.manager.student.CourseManager;
import com.rainng.coursesystem.model.entity.StudentCourseEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import org.springframework.stereotype.Service;

@Service("student_courseService")
public class CourseService extends BaseService {
    private final CourseManager manager;

    public CourseService(CourseManager manager) {
        this.manager = manager;
    }

    public ResultVO list() {
        Integer studentId = getUserId();
        return result(manager.listStudentCourseSelected(studentId));
    }

    public ResultVO delete(Integer studentCourseId) {
        Integer studentId = getUserId();
        StudentCourseEntity studentCourse = manager.getStudentCourseById(studentCourseId);
        if (studentCourse == null) {
            return failedResult("学生选课Id:" + studentCourseId + "不存在");
        }
        if (!studentCourse.getStudentId().equals(studentId)) {
            return failedResult("此课程非此学生所选!");
        }
        if (studentCourse.getDailyScore() != null || studentCourse.getExamScore() != null || studentCourse.getScore() != null) {
            return failedResult("学生已获得成绩, 不能退选");
        }

        manager.deleteStudentCourse(studentCourse);
        return result("退选成功");
    }
}
