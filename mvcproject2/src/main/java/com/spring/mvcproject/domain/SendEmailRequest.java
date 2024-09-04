package com.spring.mvcproject.domain;

public class SendEmailRequest {
    private String toAddress;
    private String subject;
    private String body;

    //기본 생성자
    public SendEmailRequest(){}

    public String getToAddress() {
        return toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
