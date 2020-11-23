package org.example.springbootweb.service;

import org.example.springbootweb.entity.Email;

public interface EmailService {
    public void sendSimpleMessage(Email email) throws Exception;
}
