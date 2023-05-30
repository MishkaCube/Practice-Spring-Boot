package com.example.demo.controllers;

import com.example.demo.service.MailServ;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/sendMail")
public class MailController {
    private final MailServ mailServ;
    @PostMapping
    public ResponseEntity<Void> sendMail(@RequestParam String text,
                                         @RequestParam String to,
                                         @RequestParam String subject) {
        mailServ.sendSimpleMessage(to, subject, text);
        return ResponseEntity.noContent().build();
    }
}
