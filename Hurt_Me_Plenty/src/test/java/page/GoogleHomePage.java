package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleHomePage extends BasePage {
    private static final String URL = " https://cloud.google.com/";

    @FindBy(xpath = "//div//input[@name='q']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='gs-title']//b[contains(text(),'Google Cloud Pricing Calculator')]")
    private WebElement google_Cloud_Pricing_Calculator;

    @FindBy(xpath = "//a[@class='devsite-user-signin button devsite-top-button']")
    private WebElement logIn_Button;

    public GoogleHomePage() {
        driver.get(URL);
        PageFactory.initElements(driver, this);
    }

    public LogInPage enterlogInPage(){
        logIn_Button.click();
        return new LogInPage();
    }
    public GoogleHomePage googleSearchCalculator(String searchText) {
        searchButton.click();
        searchButton.sendKeys(searchText, Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(google_Cloud_Pricing_Calculator));
        return this;
    }

    public GoogleCloudPricingCalculator chooseCalculator() {
        google_Cloud_Pricing_Calculator.click();
        return new GoogleCloudPricingCalculator();
    }
}
