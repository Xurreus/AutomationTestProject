package loginTests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnSuccessFulLogin extends TestUtil {

    @Test (dataProvider = "wrongUsers")
    public void UnSuccessFulLogin(String username, String password){

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("username");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("password");

        WebElement loginButton = driver.findElement(By.cssSelector("[name=login-button]"));
        loginButton.click();

        WebElement closeErrorMsgBtn = driver.findElement(By.cssSelector(".error-button"));

        Assert.assertTrue(closeErrorMsgBtn.isDisplayed());
    }
}

