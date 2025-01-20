package com.mong.mmbs.service.implement;

import com.mong.mmbs.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mong.mmbs.dto.MailDto;

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
