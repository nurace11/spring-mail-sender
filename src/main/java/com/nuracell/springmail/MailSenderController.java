package com.nuracell.springmail;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
@RequiredArgsConstructor
public class MailSenderController {

    private final MailSenderService mailSenderService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody SendEmailRequest emailSendRequest) {
        try {
            if (emailSendRequest.getFrom() == null || emailSendRequest.getFrom().isBlank()) {
                mailSenderService.sendSimpleMessage(emailSendRequest);
            } else {
                mailSenderService.sendMessageWithFrom(emailSendRequest);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error. Couldn't send a message. Check the app logs");
        }

        return ResponseEntity.ok("Message sent");
    }
}
