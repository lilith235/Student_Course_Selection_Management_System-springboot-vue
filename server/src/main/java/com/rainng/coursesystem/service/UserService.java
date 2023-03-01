package com.rainng.coursesystem.service;

import com.rainng.coursesystem.manager.LoginStatusManager;
import com.rainng.coursesystem.manager.UserManager;
import com.rainng.coursesystem.model.bo.AuthInfoBO;
import com.rainng.coursesystem.model.bo.LoginStatusBO;
import com.rainng.coursesystem.model.constant.UserType;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService extends BaseService {
    private final HttpSession session;
    private final UserManager manager;
    private final LoginStatusManager loginStatusManager;



    public UserService(HttpSession session, UserManager manager, LoginStatusManager loginStatusManager) {
        this.session = session;
        this.manager = manager;
        this.loginStatusManager = loginStatusManager;

    }

    public ResultVO login(String swnumber, String password, Integer userType) {
        AuthInfoBO authInfo = manager.getAuthInfoBySwnumber(swnumber, userType);
        if (authInfo == null) {
            return failedResult("用户不存在");
        }
        if (!password.equals(authInfo.getPassword())) {
            return failedResult("密码错误");
        }

        if (authInfo.getUserType().equals(UserType.STUDENT)) {
            manager.updateStudentLastLoginTime(swnumber);
        }

        LoginStatusBO statusBO = LoginStatusBO.fromAuthInfo(authInfo);
        loginStatusManager.setLoginStatus(session, statusBO);

        return result(statusBO);
    }



    public ResultVO getLoginStatus() {
        LoginStatusBO statusBO = loginStatusManager.getLoginStatus(session);
        return result(statusBO);
    }

    public ResultVO logout() {
        loginStatusManager.setLoginStatus(session, null);
        return result("注销成功");
    }
}
