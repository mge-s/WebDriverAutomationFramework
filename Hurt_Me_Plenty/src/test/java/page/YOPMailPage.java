package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class YOPMailPage extends BasePage {
    private static final String URL = "https://yopmail.com/ru/email-generator";
    private final Logger logger = LogManager.getLogger();
    private List<String> windowHandles;
    @FindBy(xpath = "//*[@id=\"cprnd\"]/span/span[@class='notmobile']")
    private WebElement copy_Email_Button;

    @FindBy(xpath = "//button[@onclick='egengo();']//span")
    private WebElement check_Email_Button;

    @FindBy(xpath = "//*[@id=\"ifmail\"]")
    private WebElement frame;

    @FindBy(xpath = "//*[@id=\"mail\"]/div/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement price;

    public YOPMailPage() {
        PageFactory.initElements(driver, this);
    }

    public YOPMailPage openPage() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(URL);
        windowHandles = new ArrayList<>(driver.getWindowHandles());
        logger.info("********** Email page opened");
        return this;
    }

    public void copyEmail() {
        copy_Email_Button.click();
    }

    public YOPMailPage switchToYOPMailPage() {
        driver.switchTo().window(windowHandles.get(1));
        return this;
    }

    public YOPMailPage checkEmail() {
        logger.info("************** Opened email");
        check_Email_Button.click();
        return this;
    }

    public String getPrice() {
        driver.switchTo().frame(frame);
        return price.getText();
    }
}
