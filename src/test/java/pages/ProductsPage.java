package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BasePage {
    private final static String PRODUCT_BASE_ID = "add-to-cart-sauce-labs-";
    private final static String REMOVE_PRODUCT_BASE_ID = "remove-sauce-labs-";
    @FindBy(xpath = "//span[contains(text(), 'Products')]")
    WebElement productsPageTitle;
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCartBadge;
    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCartLink;
    public ProductsPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean isAt() {
        return productsPageTitle.isDisplayed();
    }
    public void addItemToCart(String itemName){
        WebElement itemToBeAdded = driver.findElement(By.id(PRODUCT_BASE_ID + itemName));
        itemToBeAdded.click();

    }
    public void removeItemFromTheCart(String itemName){
        WebElement itemToBeRemoved = driver.findElement(By.id(REMOVE_PRODUCT_BASE_ID + itemName));
        itemToBeRemoved.click();

    }
    public int getItemsInTheCart(){
        return Integer.parseInt(shoppingCartBadge.getText());
    }
    public void shoppingCartLink(){
        WebElement shoppingCartLink = driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();
    }

}
