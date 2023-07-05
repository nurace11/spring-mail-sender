package com.nuracell.springmail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailSenderService {

    private final JavaMailSender mailSender;

    public void sendSimpleMessage(SendEmailRequest emailRequest) throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("default@default.com");
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());

        try {
            mailSender.send(message);
        } catch (Exception e) {
            log.error("Couldn't send message: {}", e.getMessage());
            throw e;
        }

        log.info("Message successfully sent to {}", emailRequest.getTo());
    }

    public void sendMessageWithFrom(SendEmailRequest emailRequest) throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailRequest.getFrom());
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());

        try {
            mailSender.send(message);
        } catch (Exception e) {
            log.error("Couldn't send message: {}", e.getMessage());
            throw e;
        }

        log.info("Message with from successfully sent to {}", emailRequest.getTo());
    }
}
