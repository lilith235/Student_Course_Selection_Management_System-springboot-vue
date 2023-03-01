package com.rainng.coursesystem.manager.teacher;
import com.rainng.coursesystem.dao.TeacherDAO;
import com.rainng.coursesystem.manager.BaseManager;
import com.rainng.coursesystem.model.entity.TeacherEntity;
import com.rainng.coursesystem.model.vo.response.TeacherInfoVO;
import org.springframework.stereotype.Component;

@Component
public class TeacherInfoManager extends BaseManager {
    private final TeacherDAO teacherDAO;

    public TeacherInfoManager(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public TeacherInfoVO getTeacherInfoById(Integer teacherId) {
        return teacherDAO.getTeacherInfoById(teacherId);
    }

    public TeacherEntity getTeacherById(Integer teacherId) {
        return teacherDAO.get(teacherId);
    }

    public int updateTeacher(TeacherEntity entity) {
        return teacherDAO.update(entity);
    }
}
