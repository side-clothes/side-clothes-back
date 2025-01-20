package com.mong.mmbs.service;

public interface MailService {
    boolean sendPasswordEmail(String tmpPassword, String memberEmail);
}
