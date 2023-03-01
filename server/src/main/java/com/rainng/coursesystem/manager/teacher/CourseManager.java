package com.rainng.coursesystem.manager.teacher;

import com.rainng.coursesystem.dao.CourseDAO;
import com.rainng.coursesystem.dao.TeacherDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.CourseEntity;
import com.rainng.coursesystem.model.vo.response.StudentInfoVO;
import com.rainng.coursesystem.model.vo.response.TeacherInfoVO;
import com.rainng.coursesystem.model.vo.response.table.TeacherCourseItemVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("teacher_CourseManager")
public class CourseManager extends BaseManager {
    private final TeacherDAO teacherDAO;
    private final CourseDAO courseDAO;
    public CourseManager(TeacherDAO teacherDAO,CourseDAO courseDAO) {
        this.courseDAO=courseDAO;
        this.teacherDAO = teacherDAO;
    }

    public List<TeacherCourseItemVO> listTeacherCourse(Integer teacherId) {
        return teacherDAO.listTeacherCourse(teacherId);
    }

    public CourseEntity get(Integer id) {
        return courseDAO.get(id);
    }

    public int create(CourseEntity entity) {
        return courseDAO.insert(entity);
    }
}
