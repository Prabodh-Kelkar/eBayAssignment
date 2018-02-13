package objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * <h1>Product Details Page Objects</h1>
 * The class has locators for Product Details -
 * - Page elements used for automation
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class ProductPageObjects {

    //Product Name label
    //@AndroidFindBy(accessibility = "Logitech M170 Wireless Optical Mouse")
    //public MobileElement productNameLabel;

    //BuyItNow button
    @AndroidFindBy(id = "com.ebay.mobile:id/button_bin")
    public MobileElement buyItNowbtn;

    //Home page icon/image on top left of screen
    @AndroidFindBy (id="com.ebay.mobile:id/home")
    public MobileElement homeBtn;

    //SignIn status button in menu
    @AndroidFindBy (id="com.ebay.mobile:id/textview_sign_in_status")
    public MobileElement signInStatus;

    //Signout button in menu
    @AndroidFindBy (xpath="//*[@text='Sign out']")
    public MobileElement signOut;

}
