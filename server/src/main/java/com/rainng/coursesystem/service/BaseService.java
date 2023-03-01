package com.rainng.coursesystem.service;

import com.rainng.coursesystem.manager.LoginStatusManager;
import com.rainng.coursesystem.model.bo.LoginStatusBO;
import com.rainng.coursesystem.model.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
//可以直接解析出当前请求对象的ID
public class BaseService {
    @Autowired
    private HttpSession session;
    @Autowired
    private LoginStatusManager loginStatusManager;

    private LoginStatusBO getLoginStatus() {
        return loginStatusManager.getLoginStatus(session);
    }

    protected Integer getUserId() {
        return getLoginStatus().getUserId();
    }

    protected ResultVO result(Object data) {
        return new ResultVO(ResultVO.SUCCESS, "success", data);
    }

    protected ResultVO result(Object data, String message) {
        return new ResultVO(ResultVO.SUCCESS, message, data);
    }

    protected ResultVO failedResult(String message) {
        return new ResultVO(ResultVO.FAIL, message, null);
    }

    protected ResultVO failedResult(String message, Object data) {
        return new ResultVO(ResultVO.FAIL, message, data);
    }

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public LoginStatusManager getLoginStatusManager() {
		return loginStatusManager;
	}

	public void setLoginStatusManager(LoginStatusManager loginStatusManager) {
		this.loginStatusManager = loginStatusManager;
	}
}
