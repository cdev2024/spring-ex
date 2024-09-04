package com.spring.mvcproject.controller;

import com.spring.mvcproject.domain.SendEmailRequest;
import com.spring.mvcproject.service.EmailServiceClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email")
public class EmailController {

    // http://localhost:8080/email/sendEmail
    @RequestMapping(value = "/sendEmail")
    @ResponseBody
    public String sendEmail() {
        EmailServiceClient emailServiceClient = new EmailServiceClient();
        SendEmailRequest sendEmailRequest = generateEmailRequest();
        emailServiceClient.sendEmail(sendEmailRequest);
        return "Success";
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
