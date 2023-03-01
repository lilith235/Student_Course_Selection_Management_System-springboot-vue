package com.rainng.coursesystem.service.teacher;

import com.rainng.coursesystem.manager.teacher.TeacherInfoManager;
import com.rainng.coursesystem.model.entity.TeacherEntity;
import com.rainng.coursesystem.model.vo.request.TeacherInfoFormVO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import com.rainng.coursesystem.service.BaseService;
import com.rainng.coursesystem.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TeacherInfoService extends BaseService {
    private final UserService userService;

    private final TeacherInfoManager manager;

    public TeacherInfoService(UserService userService, TeacherInfoManager manager) {
        this.userService = userService;
        this.manager = manager;
    }

    public ResultVO get() {
        //System.out.println(getUserId());
        return result(manager.getTeacherInfoById(getUserId()));
    }

    public ResultVO update(@RequestBody @Validated TeacherInfoFormVO teacherInfoForm) {
        TeacherEntity teacher = manager.getTeacherById(getUserId());

        //String password = teacher.getPassword();
        BeanUtils.copyProperties(teacherInfoForm, teacher);
        //teacher.setPassword(password);
        manager.updateTeacher(teacher);

        return result("更新成功");
    }
}
