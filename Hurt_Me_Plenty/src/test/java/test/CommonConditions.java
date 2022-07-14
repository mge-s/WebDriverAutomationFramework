package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import page.BasePage;
import page.GoogleCloudPricingCalculator;
import steps.CommonSteps;

@Listeners(util.TestListener.class)
public class CommonConditions {
    protected WebDriver driver;
    private GoogleCloudPricingCalculator googleCloudPricingCalculator;

    @BeforeTest(alwaysRun = true)
    public void setUp() throws InterruptedException {
        driver = DriverSingleton.getDriver();
        BasePage.setDriver(driver);
        googleCloudPricingCalculator = new GoogleCloudPricingCalculator();
        CommonSteps commonSteps = new CommonSteps();
        // commonSteps.logIn();
        commonSteps.searchItem();
        commonSteps.chooseComputeEngine();
        commonSteps.formFilling();
        commonSteps.openYopMailPage();
        commonSteps.copyEmail();
        commonSteps.switchBack();
        commonSteps.sendEmail();
        commonSteps.switchToYOPMail();
        Thread.sleep(3000);
        commonSteps.checkMail();
    }

    @AfterTest(alwaysRun = true)
    public void shutDown() {
        DriverSingleton.closeDriver();
    }
}
