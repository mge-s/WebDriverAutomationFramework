package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static WebDriver driver;


    public static void setDriver(WebDriver webdriver) {
        driver = webdriver;
    }

}
