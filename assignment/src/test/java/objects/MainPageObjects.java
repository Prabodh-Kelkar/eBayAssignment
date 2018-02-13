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
public class MainPageObjects {

    //Search Text Box
    @AndroidFindBy (id = "com.ebay.mobile:id/search_box")
    public MobileElement searchTextBox;

    //SignIn button on home page
    @AndroidFindBy (id="com.ebay.mobile:id/button_sign_in")
    public MobileElement signInBtn;

    //Home page icon/image on top left of screen
    @AndroidFindBy (id="com.ebay.mobile:id/home")
    public MobileElement homeBtn;

    //SignIn / Signout status button in menu
    @AndroidFindBy (id="com.ebay.mobile:id/textview_sign_out_status")
    public MobileElement signInSignOutbtn;

    //SignIn status button in menu
    @AndroidFindBy (id="com.ebay.mobile:id/textview_sign_in_status")
    public MobileElement signInStatus;

    //Signout button in menu
    @AndroidFindBy (xpath="//*[@text='Sign out']")
    public MobileElement signOut;

}
