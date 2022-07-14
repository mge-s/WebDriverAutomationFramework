package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPricingCalculator extends BasePage {
    private final String currentHandle = driver.getWindowHandle();
    private final Logger logger = LogManager.getLogger();

    @FindBy(xpath = "//md-tab-item[@role='tab']//div[@class='name ng-binding'][normalize-space()='Compute Engine']")
    private WebElement compute_Engine;

    @FindBy(xpath = "//*[@id=\"cloud-site\"]/devsite-iframe/iframe")
    private WebElement frame;

    @FindBy(xpath = "//*[@id=\"myFrame\"]")
    private WebElement innerFrame;

    @FindBy(xpath = "//input[@id='input_85']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//*[@id=\"select_value_label_80\"]/span/div[@class='md-text ng-binding']")
    private WebElement series;

    @FindBy(xpath = "//md-option[@id='select_option_195']/div[contains(text(),'N1')]")
    private WebElement n1;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_81']//div[@class='md-text ng-binding']")
    private WebElement machineType;

    @FindBy(xpath = "//md-option//div[contains(text(),'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")
    private WebElement machineTypeValue;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[12]/div[1]/md-input-container/md-checkbox/div[1]")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//*[@id=\"select_458\"]")
    private WebElement number_Of_GPUs;

    @FindBy(xpath = "//*[@id=\"select_456\"]")
    private WebElement GPU_Type;

    @FindBy(xpath = "//div[normalize-space()='NVIDIA Tesla P4']")
    private WebElement GPU_Type_Value;

    @FindBy(xpath = "//*[@id=\"select_option_467\"]")
    private WebElement number_Of_GPUs_Value;

    @FindBy(xpath = "//*[@id=\"select_value_label_412\"]/span/div[@class='md-text ng-binding']")
    private WebElement local_SSD;

    @FindBy(xpath = "//*[@id=\"select_option_439\"]/div")
    private WebElement local_SSD_Value;

    @FindBy(xpath = "//*[@id=\"select_value_label_83\"]/span[1]/div")
    private WebElement dataCenter_Location;

    @FindBy(xpath = "//*[@id=\"select_option_221\"]/div[contains(text(),'Frankfurt')]")
    private WebElement frankfurt_europe_west3;

    @FindBy(xpath = "//*[@id=\"select_value_label_84\"]/span[1]")
    private WebElement commited_Usage;

    @FindBy(xpath = "//*[@id=\"select_option_123\"]/div")
    private WebElement usage_Value;

    @FindBy(xpath = "//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[19]/button")
    private WebElement add_To_Estimate_Button;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item/div[@class='md-list-item-text ng-binding'][contains(text(),'Regular')]")
    private WebElement provisioning_Model_Estimated;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[@class='md-1-line md-no-proxy']/div[@class='md-list-item-text ng-binding cpc-cart-multiline flex']")
    private WebElement instanceType_Estimated;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item[@class='md-1-line md-no-proxy']/div[contains(text(),'Frankfurt')]")
    private WebElement region_Estimated;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item/div[contains(text(),'Local SSD:')]")
    private WebElement local_SSD_Estimated;

    @FindBy(xpath = "//*[@id=\"compute\"]/md-list/md-list-item/div[contains(text(),'Commitment')]")
    private WebElement commitment_Term_Estimated;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")
    private WebElement total_Price;

    @FindBy(xpath = "//*[@id=\"email_quote\"]")
    private WebElement email_Button;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement email_Field;

    @FindBy(xpath = "//*[@id=\"dialogContent_539\"]/form/md-dialog-actions/button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement send_Email_Button;

    public GoogleCloudPricingCalculator() {
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculator chooseComputeEngine() {
        driver.switchTo().frame(frame);
        driver.switchTo().frame(innerFrame);
        compute_Engine.click();
        return this;
    }

    public GoogleCloudPricingCalculator formFilling() {
        logger.info("************FormFilling started");
        numberOfInstances.click();
        numberOfInstances.sendKeys("4");
        series.click();
        n1.click();
        machineType.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(machineTypeValue));
        machineTypeValue.click();
        addGPUCheckbox.click();
        GPU_Type.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(GPU_Type_Value));
        GPU_Type_Value.click();
        number_Of_GPUs.click();
        number_Of_GPUs_Value.click();
        local_SSD.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(local_SSD_Value));
        local_SSD_Value.click();
        dataCenter_Location.click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(frankfurt_europe_west3));
        frankfurt_europe_west3.click();
        commited_Usage.click();
        usage_Value.click();
        add_To_Estimate_Button.click();
        logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Form is filled");
        return this;
    }

    public GoogleCloudPricingCalculator switchBack() {
        driver.switchTo().window(currentHandle);
        return this;
    }

    public GoogleCloudPricingCalculator sendEmail() {
        driver.switchTo().frame(frame);
        driver.switchTo().frame(innerFrame);
        email_Button.click();
        email_Field.click();
        email_Field.sendKeys(Keys.CONTROL + "v");
        send_Email_Button.click();
        logger.info("******************** Email is sent");
        return this;
    }


}
