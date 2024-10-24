package demoqa.bookstore;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import demoqa.utils.RetryAnalyser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getBookStore().hideAds();
        new SidePage(app.driver).selectLogin().hideAds();
    }

    @Test(retryAnalyzer = RetryAnalyser.class)
    public void loginPositiveTest() {
        new LoginPage(app.driver)
                .enterPersonalData("JULICK","Qwertyuiop@1")
                .clickOnLoginButton()
                .verifyUserName("JULICK");
    }
}
