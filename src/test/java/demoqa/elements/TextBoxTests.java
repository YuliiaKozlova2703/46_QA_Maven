package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectTextBox().hideAds();
}
@Test
public void keyboardEventTest() {
        new TextBoxPage(app.driver)
                .enterPersonalData("Yuliia", "email@gmail.com", "Berlin, Germany")
                .keyboardEvent()
                .verifyCopyPasteAddress("address");
    }
   // "Yuliia", "email@gmail.com", "Berlin, Germany"
    @Test
    public void keyboardEventDataProviderTest(String name, String email, String address) {
        new TextBoxPage(app.driver)
                .enterPersonalData(name, email, address)
                .keyboardEvent()
                .verifyCopyPasteAddress("address");
    }
}
