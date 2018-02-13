package objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * <h1>SignIn Page Objects</h1>
 * The class has locators for SignIn Page -
 * - elements used for automation
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class SignInPageObjects {

    // Username text box
    @AndroidFindBy(id = "com.ebay.mobile:id/edit_text_username")
    public MobileElement usernameTextbox;

    //Password text box
    @AndroidFindBy(id = "com.ebay.mobile:id/edit_text_password")
    public MobileElement passwordTextbox;

    //SignIn button
    @AndroidFindBy(id = "com.ebay.mobile:id/button_sign_in")
    public MobileElement signInBtn;

    //No Thanks button to skip eBay and Google acct linking
    @AndroidFindBy(id = "com.ebay.mobile:id/button_google_deny")
    public MobileElement noThanksBtn;

}
