package com.spring.mvcproject.service;

import com.spring.mvcproject.domain.SendEmailRequest;
import org.springframework.stereotype.Service;

@Service //Spring이 관리하는 서비스 빈으로 등록
public class EmailServiceClient {
    public void sendEmail(SendEmailRequest request) {
        //실제 이메일 발송 로직은 여기에 작성합니다.
        System.out.println("Sending email to: " + request.getToAddress());
        System.out.println("Subject : " + request.getSubject());
        System.out.println("Body : " + request.getBody());
        // 이메일 발송 시 추가적인 로직을 작성할 수 있음
    }
}
