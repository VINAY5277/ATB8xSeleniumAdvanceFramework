package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPage_POM {
WebDriver driver;

    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
}
    // page locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signbutton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // if you are not using it, don't keep.

    // page actions
    public String loginToVWOLoginCreds(String user,String pwd) {

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signbutton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

       String error_message_text =  driver.findElement(error_message).getText();
        return error_message_text;

    }
}
