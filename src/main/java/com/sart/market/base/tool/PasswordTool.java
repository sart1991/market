package com.sart.market.base.tool;

import org.springframework.stereotype.Component;

@Component
public class PasswordTool {

    public enum SecurityAspect {

        INVALID, WEAK, MEDIUM, STRONG

    }

    public SecurityAspect assesPassword(String password) {
        if (password == null || password.isBlank())
            return SecurityAspect.INVALID;
        if (password.length() < 9 || password.matches("[a-zA-Z]+"))
            return SecurityAspect.WEAK;
        if (password.matches("[a-zA-Z0-9]+"))
            return SecurityAspect.MEDIUM;
        return SecurityAspect.STRONG;
    }

}
