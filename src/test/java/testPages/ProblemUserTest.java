package testPages;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProblemUserTest extends TestUtil {

    @Test
    public void Checkout() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("error_user", "secret_sauce");

        productsPage.addItemToCart("bike-light");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 1);

        productsPage.removeItemFromTheCart("bike-light");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 0);
    }
}