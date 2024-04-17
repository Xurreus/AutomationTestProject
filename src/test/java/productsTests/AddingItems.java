package productsTests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddingItems extends TestUtil {
    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";

    @Test
    public void addProductToTheCart(){

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[name=login-button]"));
        loginButton.click();
        WebElement productPagesTitle = driver.findElement(By.xpath("//span[contains(text(), 'Products')]"));

        WebElement itemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + "backpack"));
        itemToBeAdded.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement shoppingCartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
        Assert.assertEquals(shoppingCartBadge.getText(), "1");

        WebElement nextItemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + "bolt-t-shirt"));
        nextItemToBeAdded.click();
        shoppingCartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
        Assert.assertEquals(shoppingCartBadge.getText(), "2");

    }
}
