package steps;

import page.GoogleCloudPricingCalculator;
import page.GoogleHomePage;
import page.YOPMailPage;
import service.UserCreator;

public class CommonSteps {
    private final String SEARCH_TEXT = "Google Cloud Platform Pricing Calculator";
    private final GoogleHomePage googleHomePage = new GoogleHomePage();
    private final GoogleCloudPricingCalculator googleCloudPricingCalculator = new GoogleCloudPricingCalculator();
    private final YOPMailPage yopMailPage = new YOPMailPage();

    public void logIn() {
        googleHomePage.enterlogInPage()
                .logIn(UserCreator.getUser());
    }

    public void searchItem() {
        googleHomePage.googleSearchCalculator(SEARCH_TEXT)
                .chooseCalculator();
    }

    public void chooseComputeEngine() {
        googleCloudPricingCalculator.chooseComputeEngine();
    }

    public void formFilling() {
        googleCloudPricingCalculator.formFilling();
    }

    public void openYopMailPage() {
        yopMailPage.openPage();
    }

    public void copyEmail() {
        yopMailPage.copyEmail();
    }

    public void switchBack() {
        googleCloudPricingCalculator.switchBack();
    }

    public void sendEmail() {
        googleCloudPricingCalculator.sendEmail();
    }

    public void switchToYOPMail() {
        yopMailPage.switchToYOPMailPage();
    }

    public void checkMail() {
        yopMailPage.checkEmail();
    }
}
