package com.passwordtester.validation.controller.v1;

import com.passwordtester.validation.api.v1.model.PasswordDTO;
import com.passwordtester.validation.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PasswordController.BASE_URL)
public class PasswordController {

    public static final String BASE_URL = "/api/v1/validation";

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getInfo() {
        return passwordService.info();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String checkPassword(@RequestBody PasswordDTO passwordDTO) {
        if (passwordService.check(passwordDTO.getPassword(), passwordDTO.getRule()))
            return "valid";
        else
            return "invalid";
    }

}
