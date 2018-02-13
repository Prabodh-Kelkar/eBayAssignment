package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.ElementOption;
import objects.OrderDetailsPageObjects;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.LogResults;

/**
 * <h1>Order Details Page Operations</h1>
 * The class has methods to be done on Order Details elements
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class OrderDetailsPage extends Helper {

    OrderDetailsPageObjects orderDetailsPageObjects;

    /**
     * Default constructor for Order Details Page
     *
     * @param driver AppiumDriver object
     */
    public OrderDetailsPage(AppiumDriver driver) {
        super(driver);
        orderDetailsPageObjects = new OrderDetailsPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), orderDetailsPageObjects);
    }

    /**
     * Method to scroll down the Order Details Page
     */
    public void scrollPage() {
        LogResults.info("Scrolling the Order Details page");

        TouchAction verticalAction = new TouchAction(driver);

        waitForElelemt(orderDetailsPageObjects.deliveryAddressLabel);
        MobileElement elementScrollFrom = orderDetailsPageObjects.itemDetailsLabel;
        MobileElement elementScrollTo = orderDetailsPageObjects.deliveryAddressLabel;

        Dimension dragMeDimension = elementScrollFrom.getSize();
        Dimension dragToDimension = elementScrollTo.getSize();

        //Scroll till Item Details section
        verticalAction.press(ElementOption.element(elementScrollFrom, dragMeDimension.getWidth() / 2, dragMeDimension.getHeight() / 2)).
                moveTo(ElementOption.element(elementScrollTo, dragToDimension.getWidth() / 2, dragToDimension.getHeight() / 2)).
                release().perform();

        elementScrollFrom = orderDetailsPageObjects.orderSummaryLabel;
        elementScrollTo = orderDetailsPageObjects.itemDetailsLabel;

        dragMeDimension = elementScrollFrom.getSize();
        dragToDimension = elementScrollTo.getSize();
        //Scroll till Order Summary section
        verticalAction.press(ElementOption.element(elementScrollFrom, dragMeDimension.getWidth() / 2, dragMeDimension.getHeight() / 2)).
                moveTo(ElementOption.element(elementScrollTo, dragToDimension.getWidth() / 2, dragToDimension.getHeight() / 2)).
                release().perform();
    }

    /**
     * Method to click Proceed to Pay button on Order Details Page
     */
    public void clickProceedtoPay() {
        waitForElelemt(orderDetailsPageObjects.proceedToPayBtn);
        orderDetailsPageObjects.proceedToPayBtn.click();
        LogResults.info("Clicked Proceed to Payment on Order Details page");
    }

    /**
     * Method to click Cancel button on Order Details Page
     */
    public void clickCancel() {
        waitForElelemt(orderDetailsPageObjects.cancelBtn);
        orderDetailsPageObjects.cancelBtn.click();
        LogResults.info("Clicked Cancel on Order Details page");
    }

}
