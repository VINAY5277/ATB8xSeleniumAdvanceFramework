package com.thetestingacademy.vwologin;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.DashboardPage_POM;

public class TestVWOLogin_POM {

    @Owner("PRAMOD")
    @Description("verify that invalid creds give error message")
    @Test
    public void testLoginNegativeVWO(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        DashboardPage_POM loginPagePom = new DashboardPage_POM(driver);
        String error_msg = loginPagePom.loginToVWOLoginInvalidCreds("admin","password");
        toString(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"your email, password, IP address");

        driver.quit();



    }
}
