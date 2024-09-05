package com.spring.mvcproject.controller;

import com.spring.mvcproject.domain.SendEmailRequest;
import com.spring.mvcproject.service.EmailServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // @Controller라는 어노테이션을 붙여서 자동으로 Bean으로 등록
@RequestMapping("/email")
public class EmailController {

    //EmailServiceClient를 주입 받음
    @Autowired
    private EmailServiceClient emailServiceClient;

    // http://localhost:8080/email/sendEmail
    @RequestMapping(value = "/sendEmail")
    @ResponseBody
    public String sendEmail() {
        // EmailServiceClient emailServiceClient = new EmailServiceClient(); // Spring에서 자동으로 주입받음
        SendEmailRequest sendEmailRequest = generateEmailRequest();
        emailServiceClient.sendEmail(sendEmailRequest);
        return "성공";
    }

    public SendEmailRequest generateEmailRequest(){
        // 간단한 이메일 요청 객체 생성
        SendEmailRequest request = new SendEmailRequest();
        request.setToAddress("test@example.com");
        request.setSubject("Test Email");
        request.setBody("This is a test email.");
        return request;
    }

}
