package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.openqa.selenium.Keys.CONTROL;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement fullName;
    @FindBy (id = "userEmail")
    WebElement email;
    @FindBy (id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage enterPersonalData(String name, String mail, String address) {
        type(fullName, name);
        typeScrollWithJS(email,mail,300);
        typeScrollWithJS(currentAddress,address,500);
        return this;
    }
    @FindBy (id = "permanentAddress")
    WebElement permanentAddress;
    public TextBoxPage keyboardEvent() {
        currentAddress.click();
        currentAddress.sendKeys(Keys.chord(Keys.COMMAND, "a")); // Выделить все
        currentAddress.sendKeys(Keys.chord(Keys.COMMAND, "c")); // Копировать
        permanentAddress.click();
        permanentAddress.sendKeys(Keys.chord(Keys.COMMAND, "v")); // Вставить
        return this;
    }

    /* public TextBoxPage keyboardEvent() {
        currentAddress.click();
        currentAddress.sendKeys(Keys.chord(CONTROL, "a"));
        currentAddress.sendKeys(Keys.chord(CONTROL, "c"));
        permanentAddress.click();
        permanentAddress.sendKeys(Keys.chord(CONTROL, "v"));
        return this;
    }*/
        // Проверка значений и вывод сообщения в случае несоответствия
        public void verifyCopyPasteAddress(String expectedAddress) {
            String actualAddress = permanentAddress.getAttribute("value");
            Assert.assertEquals(actualAddress, expectedAddress, "The copied address does not match the expected address!");
    }
}