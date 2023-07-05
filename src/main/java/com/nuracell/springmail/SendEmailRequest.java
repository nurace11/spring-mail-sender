package com.nuracell.springmail;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SendEmailRequest {
    private String from;
    private String to;
    private String subject;
    private String text;
}
