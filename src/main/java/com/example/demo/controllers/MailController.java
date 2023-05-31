package com.example.demo.controllers;

import com.example.demo.service.MailServ;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/mail")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class MailController {

    private final MailServ mailServ;

    @PostMapping("/send")
    public ResponseEntity<Void> sendMail(@RequestParam String text,
                                         @RequestParam String to,
                                         @RequestParam String subject) {
        mailServ.sendSimpleMessage(to, subject, text);
        return ResponseEntity.noContent().build();
    }
}
