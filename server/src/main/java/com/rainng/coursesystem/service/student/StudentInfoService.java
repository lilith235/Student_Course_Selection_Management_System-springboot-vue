package com.rainng.coursesystem.service.student;

import com.rainng.coursesystem.manager.student.StudentInfoManager;
import com.rainng.coursesystem.model.entity.StudentEntity;
import com.rainng.coursesystem.model.vo.request.StudentInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StudentInfoService extends BaseService {
    private final UserService userService;

    private final StudentInfoManager manager;

    public StudentInfoService(UserService userService, StudentInfoManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    public ResultVO get() {
        return result(manager.getStudentInfoByStudentId(getUserId()));
    }

    public ResultVO update(@RequestBody @Validated StudentInfoFormVO studentInfoForm) {
        StudentEntity student = manager.getStudentById(getUserId());

        //String password = student.getPassword();
        BeanUtils.copyProperties(studentInfoForm, student);
        //student.setPassword(password);
        manager.updateStudent(student);

        return result("更新成功");
    }
}
