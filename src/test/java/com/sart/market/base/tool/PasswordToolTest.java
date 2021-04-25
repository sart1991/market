package com.sart.market.base.tool;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.sart.market.base.tool.PasswordTool.SecurityAspect.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordToolTest {

    @Autowired
    private PasswordTool passwordTool;

    @Test
    void assesPasswordWeakLessThan9Letters() {

        String password = "12345678";

        assertEquals(WEAK, passwordTool.assesPassword(password));

    }

    @Test
    void assesPasswordWeakJustLetters() {

        String password = "asdfghjk";

        assertEquals(WEAK, passwordTool.assesPassword(password));

    }

    @Test
    void assesPasswordMediumLettersAndNumbers() {

        String password = "asdfghjKlT1";

        assertEquals(MEDIUM, passwordTool.assesPassword(password));

    }

    @Test
    void assesPasswordStrongLettersNumbersAndSpecialChars() {

        String password = "!asdfghjkl!";

        assertEquals(STRONG, passwordTool.assesPassword(password));

    }
}