package objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * <h1>Review Page Objects</h1>
 * The class has locators for Review Page -
 * - elements used for automation
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class ReviewPageObjects {

    //Review button
    @AndroidFindBy(id = "com.ebay.mobile:id/take_action")
    public MobileElement reviewbtn;

}
