package org.example.springbootweb.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import java.util.Map;

public class Email {
    private Long id;

    private String sendTo;

    private String sendFrom;

    private String subject;

    private String body;

    public Email() {
    }

    public Email(Long id, String sendTo, String sendFrom, String subject, String body) {
        this.id = id;
        this.sendTo = sendTo;
        this.sendFrom = sendFrom;
        this.subject = subject;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
