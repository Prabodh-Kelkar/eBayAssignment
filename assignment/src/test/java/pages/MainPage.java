package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.MainPageObjects;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.LogResults;

/**
 * <h1>Main Page Operations</h1>
 * The class has methods to be done on Main page elements
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class MainPage extends Helper {

    MainPageObjects mainPageObjects;

    /**
     * Default constructor for Main Page
     *
     * @param driver AppiumDriver object
     */
    public MainPage(AppiumDriver driver) {
        super(driver);
        mainPageObjects = new MainPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), mainPageObjects);
    }

    /**
     * Method to click SignIn button on Main Page
     */
    public void clickSignIn() {
        waitForElelemt(mainPageObjects.signInBtn);
        mainPageObjects.signInBtn.click();
        LogResults.info("Clicked Signin button");
    }

    /**
     * Method to click SignIn button in Home Page menu
     */
    public void clickSignInFromMenu() {
        mainPageObjects.homeBtn.click();
        waitForElelemt(mainPageObjects.signInSignOutbtn);
        mainPageObjects.signInSignOutbtn.click();
        LogResults.info("SignIn from Menu option");
    }

    /**
     * Method to clicks on Search Box - which navigates to Search screen
     */
    public void clickSearch() {
        waitForElelemt(mainPageObjects.searchTextBox);
        mainPageObjects.searchTextBox.click();
        LogResults.info("Clicked Search Box");
    }

    /**
     * Method to click SignOut button in Home Page menu
     */
    public void signOutFromMenu() {
        waitForElelemt(mainPageObjects.homeBtn);
        mainPageObjects.homeBtn.click();
        waitForElelemt(mainPageObjects.signInStatus);
        mainPageObjects.signInStatus.click();
        waitForElelemt(mainPageObjects.signOut);
        mainPageObjects.signOut.click();
        LogResults.info("Signing Out");
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            LogResults.error("Alert about notifications not displayed");
        }
    }
}
