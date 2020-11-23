package org.example.springbootweb.service;


import org.example.springbootweb.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;


    public void sendSimpleMessage(Email email) throws Exception {
        MimeMessage message = emailSender.createMimeMessage();
        // pass 'true' to the constructor to create a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String uniqueEmailTo = "l.martinez.rod@gmail.com";
        //TODO put bcc in a property
        helper.setBcc("l.martinez.rod@gmail.com");
        helper.setSubject(email.getSubject());
        helper.setText(email.getBody(), true);

        emailSender.send(message);
    }
}


