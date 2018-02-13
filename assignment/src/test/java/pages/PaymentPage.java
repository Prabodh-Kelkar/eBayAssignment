package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.PaymentPageObjects;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.LogResults;

/**
 * <h1>Payment Page Operations</h1>
 * The class has methods to be done on Payment page elements
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class PaymentPage extends Helper{

    PaymentPageObjects paymentPageObjects;

    /**
     * Default constructor for Payment Page
     *
     * @param driver AppiumDriver object
     */
    public PaymentPage(AppiumDriver driver) {
        super(driver);
        paymentPageObjects = new PaymentPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), paymentPageObjects);
    }

    /**
     * Method to click Back button on Payment Page
     */
    public void clickBack() {
        waitForElelemt(paymentPageObjects.backBtn);
        paymentPageObjects.backBtn.click();
        LogResults.info("Clicked Back on Payment page");
    }

    /**
     * Method to click Back button on Payment Page
     */
    public void clickCross() {
        waitForElelemt(paymentPageObjects.crossBtn);
        paymentPageObjects.crossBtn.click();
        LogResults.info("Clicked close on Payment page");
    }

}
