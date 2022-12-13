package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.ForgotPassword;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by Jay Vaghani
 */
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    ForgotPassword homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new ForgotPassword();
        loginPage = new LoginPage();
    }
    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        String expectedDashboardText = "Dashboard";
        Assert.assertEquals(loginPage.getDashboardText(),expectedDashboardText,"Dashboard");
    }

    @Test(groups = {"smoke","regression"})
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        homePage.clickOnForgotPassword();
        String expectedREsetPasswordText = "Reset Password";
        Assert.assertEquals(homePage.getResetPasswordText(),expectedREsetPasswordText,"Reset Password");
        //forgotPassword.clickOnForgotPassword();
        //String expectedResetPasswordText = "Reset Password";
        //Assert.assertEquals(forgotPassword.getResetPasswordText(),expectedResetPasswordText,"Reset Password");
    }

}
