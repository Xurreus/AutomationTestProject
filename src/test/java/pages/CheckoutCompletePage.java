package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isAt() {
        return  ponyExpress.isDisplayed();
    }
    @FindBy(xpath = "//img[@alt='Pony Express']")
    WebElement ponyExpress;
    public void assertPonyExpressImageDisplayed() {
        WebElement ponyExpressImage = driver.findElement(By.xpath("//img[@alt='Pony Express']"));
        Assert.assertTrue(ponyExpressImage.isDisplayed(), "Pony Express image is displayed");
    }
}
