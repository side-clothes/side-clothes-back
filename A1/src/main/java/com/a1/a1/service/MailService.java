package com.a1.a1.service;

public interface MailService {
    boolean sendPasswordEmail(String tmpPassword, String memberEmail);
}