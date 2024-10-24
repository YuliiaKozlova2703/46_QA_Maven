package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.devtools.v85.debugger.Debugger.pause;

public class ButtonsPage extends BasePage {

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickbutton;
    public ButtonsPage doubleClick() {
        new Actions(driver).doubleClick(doubleClickbutton).perform();
        return this;
    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonsPage verifyDoubleClickMessage(String textToFind) {
        shouldHaveText(doubleClickMessage, textToFind, 2000);
        assert doubleClickMessage.getText().equalsIgnoreCase("You have done a double click");
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClickButton() throws InterruptedException {
       Thread.sleep(1000); // To simulate right click
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage verifyRightClickMessage(String text) {
        assert rightClickMessage.getText().equalsIgnoreCase("You have done a right click");
        return this;
    }
    @FindBy(xpath = "//button[.='Click Me']")
    WebElement dynamicClickButton;

    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;

    public ButtonsPage dynamicClickButton() {
        click(dynamicClickButton);
        return this;
    }
    public ButtonsPage verifyDynamicClickButton(String text) {
        assert dynamicClickMessage.getText().equalsIgnoreCase("You have done a double click");
        return this;
    }
}
