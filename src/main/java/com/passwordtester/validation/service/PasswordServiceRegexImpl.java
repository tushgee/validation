package com.passwordtester.validation.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PasswordServiceRegexImpl implements PasswordService {

    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean check(String password, String rule) {
        pattern = Pattern.compile(rule);
        matcher = pattern.matcher(password);
        System.out.println(pattern);
        System.out.println(matcher);

        return matcher.matches();
    }

    @Override
    public String info() {
        // Can use Swagger for API documentation
        return
                "{\n" +
                "  \"password\": \"password to check\",\n" +
                "  \"rule\": \"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})\"\n " +
                "}" + "Use regex for validation rules:" +
                "(\t\t\t# Start of group\n" +
                        "  (?=.*\\d)\t\t#   must contains one digit from 0-9\n" +
                        "  (?=.*[a-z])\t\t#   must contains one lowercase characters\n" +
                        "  (?=.*[A-Z])\t\t#   must contains one uppercase characters\n" +
                        "  (?=.*[@#$%])\t\t#   must contains one special symbols in the list \"@#$%\"\n" +
                        "              .\t\t#     match anything with previous condition checking\n" +
                        "                {6,20}\t#        length at least 6 characters and maximum of 20\t\n" +
                        ")\t\t\t# End of group "+
                "}";
    }
}
