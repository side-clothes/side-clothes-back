package com.a1.a1.service.implement;

import com.a1.a1.dto.MailDto;
import com.a1.a1.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender mailSender;

    public boolean sendPasswordEmail(String tmpPassword, String memberEmail) {

        try {

            MailDto mailDto = new MailDto(tmpPassword, memberEmail);
            mailSender.send(mailDto);

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }

}
