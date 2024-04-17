package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CheckoutPageOverview extends BasePage {
    public CheckoutPageOverview(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isAt() {
        return finishButton.isDisplayed();
    }
    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;
    public void clickFinishButton() {
        finishButton.click();
    }
}
