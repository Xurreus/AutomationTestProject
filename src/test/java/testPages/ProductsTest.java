package testPages;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends TestUtil {
    @Test
    public void addItemToCart(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        productsPage.addItemToCart("bike-light");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 1);

        productsPage.addItemToCart("backpack");
        Assert.assertEquals(productsPage.getItemsInTheCart(), 2);
    }

}
