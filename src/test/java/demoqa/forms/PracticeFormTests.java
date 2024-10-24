package demoqa.forms;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.PracticeFormPage;
import demoqa.pages.SidePage;
import demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getForms().hideAds();
        new SidePage(app.driver).selectPracticeForm().hideAds();
    }

    @Test
    public void practiceFormTest() {
        new PracticeFormPage(app.driver)
                .enterPersonalData("Yuliia", "Kozlova", "mail@gmail.com", "1234567890")
                .selectGender("Female")
                .chooseDateAsString("04/May/1965")
                /*.chooseDate("4", "May", "1965")*/
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("/Users/yuliia/Selenium/istockphoto-1443562748-612x612.jpg")
                .enterCurrentAddress("Berlin, Germany")
                .enterState("NCR")
                /*.enterCity("Delhi")*/
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
    //"Yuliia", "Kozlova", "mail@gmail.com", "1234567890"
    @Test(dataProvider = "addNewUserFormFromCSVFile", dataProviderClass = DataProviders.class)
    @Parameters({"firstName", "lastName", "email", "phoneNumber"})
    public void practiceFormParametersTest(String firstName, String lastName, String email, String phoneNumber) {
        new PracticeFormPage(app.driver)
                .enterPersonalData(firstName, lastName, email, phoneNumber)
                .selectGender("Female")
                //.chooseDateAsString("04/May/1965")
                .chooseDate("4", "May", "1965")
                .enterSubject(new String[]{"Maths", "English"})
                .chooseHobbies(new String[]{"Sports", "Music"})
                .uploadPicture("/Users/yuliia/Selenium/istockphoto-1443562748-612x612.jpg")
                .enterCurrentAddress("Berlin, Germany")
                .enterState("NCR")
                .enterCity("Delhi")
                .submitForm()
                .verifySuccessRegistration("Thanks for submitting the form");
    }
}
