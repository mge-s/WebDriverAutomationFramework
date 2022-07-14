package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.YOPMailPage;

public class PriceCheckTest extends CommonConditions {

    @Test
    public void someTest() {
        Assert.assertTrue(new YOPMailPage().getPrice().contains("2,275.48"));
    }


}
