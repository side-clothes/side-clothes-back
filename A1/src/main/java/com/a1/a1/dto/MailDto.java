package com.a1.a1.dto;

import org.springframework.mail.SimpleMailMessage;

public class MailDto extends SimpleMailMessage {

    private static final String SUBJECT = "임시 비밀번호 안내 이메일입니다.";
    private static final String TEXT = "안녕하세요. 임시 비밀번호 안내 메일입니다. "
            + "\n" + "회원님의 임시 비밀번호는 아래와 같습니다. 로그인 후 반드시 비밀번호를 변경해주세요." + "\n";
    private static final String FROM = "helpringproject@gmail.com"; // 발신자 이메일

    public MailDto(String tmpPassword, String memberEmail) {

        super.setTo(memberEmail);
        super.setSubject(SUBJECT);
        super.setText(TEXT + tmpPassword);
        super.setFrom(FROM);

    }

}