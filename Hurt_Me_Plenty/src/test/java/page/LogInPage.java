package page;

import model.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement next_Button;

    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    public void logIn(User user) {
        usernameField.click();
        usernameField.sendKeys(user.getUsername());
        next_Button.click();

    }
}
