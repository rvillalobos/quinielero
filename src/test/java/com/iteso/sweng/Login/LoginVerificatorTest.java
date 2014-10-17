package com.iteso.sweng.Login;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginVerificatorTest {

    @Test
    public void testCheckUserAndPassword_ValidUserAndPassword() throws Exception {

        // Arrange
        String userName = "Luis";
        String userPassword = "Luis";
        LoginVerificator loginVerificator = new LoginVerificator();
        LoginVerificator.LoginResults loginResults;

        // Act
        loginResults = loginVerificator.checkUserAndPassword(userName,userPassword);

        // Assert
        Assert.assertEquals(loginResults, LoginVerificator.LoginResults.VALID_USER_AND_PASSWORD);
    }
    @Test
    public void testCheckUserAndPassword_UnknownUser() throws Exception {

        // Arrange
        String userName = "Lance";
        String userPassword = "Armstrong";
        LoginVerificator loginVerificator = new LoginVerificator();
        LoginVerificator.LoginResults loginResults;

        // Act
        loginResults = loginVerificator.checkUserAndPassword(userName,userPassword);

        // Assert
        Assert.assertEquals(loginResults, LoginVerificator.LoginResults.UNKNOWN_USER);
    }

    @Test
    public void testCheckUserAndPassword_WrongPassword() throws Exception {

        // Arrange
        String userName = "Luis";
        String userPassword = "Suil";
        LoginVerificator loginVerificator = new LoginVerificator();
        LoginVerificator.LoginResults loginResults;

        // Act
        loginResults = loginVerificator.checkUserAndPassword(userName,userPassword);

        // Assert
        Assert.assertEquals(loginResults, LoginVerificator.LoginResults.WRONG_PASSWORD);
    }

    @Test
    public void testCheckUserAndPassword_EmptyUser() throws Exception {

        // Arrange
        String userName = "";
        String userPassword = "Luis";
        LoginVerificator loginVerificator = new LoginVerificator();
        LoginVerificator.LoginResults loginResults;

        // Act
        loginResults = loginVerificator.checkUserAndPassword(userName,userPassword);

        // Assert
        Assert.assertEquals(loginResults, LoginVerificator.LoginResults.UNKNOWN_USER);
    }

    @Test
    public void testCheckUserAndPassword_EmptyPassword() throws Exception {

        // Arrange
        String userName = "Luis";
        String userPassword = "";
        LoginVerificator loginVerificator = new LoginVerificator();
        LoginVerificator.LoginResults loginResults;

        // Act
        loginResults = loginVerificator.checkUserAndPassword(userName,userPassword);

        // Assert
        Assert.assertEquals(loginResults, LoginVerificator.LoginResults.WRONG_PASSWORD);
    }
}