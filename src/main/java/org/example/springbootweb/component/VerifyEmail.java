package org.example.springbootweb.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.springbootweb.entity.Email;
import org.example.springbootweb.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("verifyEmail")
public class VerifyEmail {

    private static final Logger LOGGER = LogManager.getLogger(VerifyEmail.class.getName());

    @Autowired
    EmailService emailService;

    public void executeTask() throws Exception {
        LOGGER.debug("Executing task");
        Email email = new Email((long) 1, "l.martinez.rod@gmail.com", "l.martinez.rod@gmail.com", "Test", "Test123");
        emailService.sendSimpleMessage(email);
        LOGGER.debug("Task Finished");
    }

}

