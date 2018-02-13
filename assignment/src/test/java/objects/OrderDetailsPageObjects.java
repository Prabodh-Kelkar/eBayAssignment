package objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * <h1>Order Details Page Objects</h1>
 * The class has locators for Order Details -
 * - page elements used for automation
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class OrderDetailsPageObjects {

    //Order Details Screen
    @AndroidFindBy(id = "com.ebay.mobile:id/toolbar_coordinator")
    public MobileElement orderDetailsScreen;

    //Proceed To Pay button
    @AndroidFindBy(xpath = "//*[@text='Proceed to Pay']")
    public MobileElement proceedToPayBtn;

    //Cancel button
    @AndroidFindBy(xpath = "//*[@text='Cancel']")
    public MobileElement cancelBtn;

    //Delivery Address Label
    @AndroidFindBy(xpath = "//*[@text='Delivery address']")
    public MobileElement deliveryAddressLabel;

    //DItem Details Label
    @AndroidFindBy(xpath = "//*[@text='Item details']")
    public MobileElement itemDetailsLabel;

    //Order Summary Label
    @AndroidFindBy(xpath = "//*[@text='Order summary']")
    public MobileElement orderSummaryLabel;

}
