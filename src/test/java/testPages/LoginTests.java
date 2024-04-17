package testPages;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends TestUtil {

    @Test
    public void successFulLogin(){
        LoginPage loginpage = new LoginPage(driver);
        ProductsPage productsPage = loginpage.login("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isAt());
    }
    @Test
    public void unSuccessFulLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("username", "password");

    }

}
