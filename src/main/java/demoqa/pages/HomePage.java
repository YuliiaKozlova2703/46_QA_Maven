package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePage getBookStore() {
        click(bookStore);
        //clickWithJS(bookStore, 0, 500);
        return new SidePage(driver);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFrameWindows;

    public SidePage getAlertsFrameWindows() {
        click(alertsFrameWindows);
        //clickWithJS(alertsFrameWindows, 0, 500);
        return new SidePage(driver);
    }
    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;

    public SidePage getWidgets() {
        click(widgets);
        //clickWithJS(widgets, 0, 500);
        return new SidePage(driver);
    }
    //Шаг который ведет к элементам
    @FindBy(css= ".top-card:nth-child(1)")
    WebElement elements;

    public SidePage getElements() {
        clickWithJS(elements, 0, 800);
        return new SidePage(driver);
    }
    @FindBy(css= ".top-card:nth-child(2)")
    WebElement forms;

    public SidePage getForms() {
        click(forms);
        return new SidePage(driver);
    }

}
