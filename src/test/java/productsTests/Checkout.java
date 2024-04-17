package productsTests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Checkout extends TestUtil {

    private final static String BASE_PRODUCT_ID = "add-to-cart-sauce-labs-";

    @Test
    public void CheckoutItems(){

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shoppingCartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
        Assert.assertEquals(shoppingCartBadge.getText(), "1");

        WebElement nextItemToBeAdded = driver.findElement(By.id(BASE_PRODUCT_ID + "bolt-t-shirt"));
        nextItemToBeAdded.click();
        shoppingCartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
        Assert.assertEquals(shoppingCartBadge.getText(), "2");

        WebElement shoppingCartIcon = driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartIcon.click();

        WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutButton.click();

        WebElement firstNameInput = driver.findElement(By.cssSelector("#first-name"));
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("Ivan");

        WebElement lastNameInput = driver.findElement(By.cssSelector("#last-name"));
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Petkov");

        WebElement zipCodeinput = driver.findElement(By.cssSelector("#postal-code"));
        zipCodeinput.click();
        zipCodeinput.clear();
        zipCodeinput.sendKeys("3355");

        WebElement continueButton = driver.findElement(By.xpath("//input[@id='continue']"));
        continueButton.click();

        WebElement finishButton = driver.findElement(By.xpath("//button[@id='finish']"));
        finishButton.click();

        WebElement checkoutPonyExpress = driver.findElement(By.xpath("//img[@alt='Pony Express']"));
        Assert.assertTrue(checkoutPonyExpress.isDisplayed());


    }

}
