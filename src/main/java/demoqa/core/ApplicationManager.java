package demoqa.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationManager {
    public WebDriver driver;

    protected void init() {
        String browser = System.getProperty("browser", "chrome");
// Проверяет значение переменной browser и в зависимости от результата инициализирует нужный драйвер
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default: // Это резервный сценарий на случай, если значение browser не совпадает ни с одним из указанных случаев
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // неявное// явное
        driver.get("https://demoqa.com/");
    }

    protected void stop() {
        if (driver != null) {
            driver.quit(); // Остановка драйвера после всех тестов
        }
    }
}
