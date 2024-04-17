import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutTest extends TestUtil {

    @Test
    public void Checkout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart("bike-light");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 1);

        productsPage.addItemToCart("backpack");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 2);

        WebElement shoppingCartLink = driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCartLink.click();

        CartPageInfo cartPage = new CartPageInfo(driver);
        cartPage.clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutPageOverview checkoutOverviewPage = checkoutPage.checkoutPageOverview("ivan", "Petkov", 3355);

        checkoutOverviewPage.clickFinishButton();

        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        Assert.assertTrue(completePage.isAt(), "Checkout complete page is not displayed");
        completePage.assertPonyExpressImageDisplayed();
    }
}
