package objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * <h1>Main Page Objects</h1>
 * The class has locators for Main Page -
 * - elements used for automation
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class PaymentPageObjects {

        //Order Details Screen
        @AndroidFindBy(xpath = "//*[@text='Back']")
        public MobileElement backBtn;

        //Cross (X) on left top of page
        @AndroidFindBy(id = "com.ebay.mobile:id/home")
        public MobileElement crossBtn;
}
