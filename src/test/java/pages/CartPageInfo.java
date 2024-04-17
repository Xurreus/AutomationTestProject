package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CartPageInfo extends BasePage {
    public CartPageInfo(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isAt() {
        return checkoutButton.isDisplayed();
    }
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkoutButton;
    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}




