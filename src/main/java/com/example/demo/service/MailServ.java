package com.example.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 * На защите скажешь что очень облажалась но не было времени исправлять
 * На самом деле для сторонних сервисов делается интерфейс поведение которого потом реализуется уже в других
 * классах
 * Скажешь но для демонстрации простой отправки сообщения сойдет и так
 *
 */
@Service
@AllArgsConstructor
public class MailServ {

    private final JavaMailSender emailSender;

    public void sendSimpleMessage(
            String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sonmed@yandex.ru");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}
