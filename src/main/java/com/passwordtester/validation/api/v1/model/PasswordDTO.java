package com.passwordtester.validation.api.v1.model;

public class PasswordDTO {
    private String password;
    private String rule;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
}
