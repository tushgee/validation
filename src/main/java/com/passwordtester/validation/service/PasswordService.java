package com.passwordtester.validation.service;

public interface PasswordService {

    public boolean check(String password, String rule);

    public String info();
}
