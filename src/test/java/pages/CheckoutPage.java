package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    public CheckoutPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isAt() {
        return continueButton.isDisplayed();
    }
    @FindBy(css = "#first-name")
    WebElement  firstNameInput;
    @FindBy(css = "#last-name")
    WebElement lastNameInput;
    @FindBy(css = "#postal-code")
    WebElement zipCodeInput;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;
    public  CheckoutPageOverview  checkoutPageOverview(String firstName, String lastName, int zipCode ){
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys("ivan");

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys("Petkov");

        zipCodeInput.click();
        zipCodeInput.clear();
        zipCodeInput.sendKeys(String.valueOf(zipCode));

        continueButton.click();
        return new CheckoutPageOverview(driver);
    }
}
