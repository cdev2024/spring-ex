package com.spring.mvcproject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope // 빈의 스코프를 세션으로 변경
public class LoggedUserManagementService {
    // 세션이 유지되는 동안 저장할 데이터를 멤버필드로 추가
    private String userName;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
