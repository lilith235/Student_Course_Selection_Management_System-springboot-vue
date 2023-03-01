package com.rainng.coursesystem.service.student;

import com.rainng.coursesystem.manager.student.CourseSelectManager;
import com.rainng.coursesystem.model.bo.StudentCourseSelectItemBO;
import com.rainng.coursesystem.model.entity.CourseEntity;
import com.rainng.coursesystem.model.entity.StudentCourseEntity;
import com.rainng.coursesystem.model.entity.StudentEntity;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.model.vo.response.table.StudentCourseSelectItemVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.util.LessonTimeConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseSelectService extends BaseService {
    private final CourseSelectManager manager;
    private final LessonTimeConverter lessonTimeConverter;

    public CourseSelectService(CourseSelectManager manager, LessonTimeConverter lessonTimeConverter) {
        this.manager = manager;
        this.lessonTimeConverter = lessonTimeConverter;
    }

    public ResultVO getPageCount(String courseName, String teacherName) {
        Integer studentId = getUserId();
        return result(manager.getPageCount(studentId, courseName, teacherName));
    }

    public ResultVO getPage(Integer index, String courseName, String teacherName) {
        Integer studentId = getUserId();

        List<StudentCourseSelectItemBO> boList = manager.getPage(index, studentId, courseName, teacherName);
        List<StudentCourseSelectItemVO> voList = new ArrayList<>(boList.size());

        for (StudentCourseSelectItemBO bo : boList) {
            StudentCourseSelectItemVO vo = new StudentCourseSelectItemVO();
            BeanUtils.copyProperties(bo, vo);
            vo.setTime(lessonTimeConverter.covertTimePart(bo.getTime()));
            voList.add(vo);
        }

        return result(voList);
    }

    public ResultVO create(Integer courseId) {
        Integer studentId = getUserId();
        StudentEntity student = manager.getStudentById(studentId);
        CourseEntity course = manager.getCourseById(courseId);
        if (student == null) {
            return failedResult("学生Id:" + studentId + "不存在!");
        }
        if (course == null) {
            return failedResult("课程Id:" + courseId + "不存在!");
        }
        if (!manager.inSameDepartment(courseId, studentId)) {
            return failedResult("学生不能选择非教学系的课程!");
        }
        if (course.getSelectedCount() >= course.getMaxSize()) {
            return failedResult("课容量已满!");
        }
        if (manager.getStudentCourseByCourseIdAndStudentId(courseId, studentId) != null) {
            return failedResult("学生已选修此课程!");
        }
        if (!manager.getStudentGradeById(student.getId()).equals(course.getGrade())) {
            return failedResult("学生与课程不在同一年级");
        }
        String timePart = splitTimePart(course.getTime());
        if (manager.countStudentCourseSelectedByTimePart(studentId, timePart) > 0) {
            return failedResult("上课时间冲突!");
        }

        StudentCourseEntity studentCourse = new StudentCourseEntity();
        studentCourse.setCourseId(courseId);
        studentCourse.setStudentId(studentId);
        manager.create(studentCourse);

        return result("选课成功");
    }

    private String splitTimePart(String time) {
        String[] spilt = time.split("-");
        return spilt[0] + "-" + spilt[1];
    }
}
