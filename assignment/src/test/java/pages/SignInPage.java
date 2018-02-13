package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.SignInPageObjects;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.LogResults;

import java.util.Properties;

public class SignInPage extends Helper {

    SignInPageObjects signInPageObjects;

    /**
     * Default constructor for Signin Page
     *
     * @param driver AppiumDriver object
     */
    public SignInPage(AppiumDriver driver) {
        super(driver);
        signInPageObjects = new SignInPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), signInPageObjects);
    }

    /**
     * Method does login operation from Signin page
     *
     * @param fileProperties Properties file to pick UserName and Password value from eBay.properties
     */
    public void loginApp(Properties fileProperties) {
        LogResults.info("Signing into the app");
        waitForElelemt(signInPageObjects.usernameTextbox);
        signInPageObjects.usernameTextbox.sendKeys(fileProperties.getProperty("UserName"));
        waitForElelemt(signInPageObjects.passwordTextbox);
        signInPageObjects.passwordTextbox.sendKeys(fileProperties.getProperty("Password"));
        waitForElelemt(signInPageObjects.signInBtn);
        signInPageObjects.signInBtn.click();
        try
        {
            waitForElelemt(signInPageObjects.noThanksBtn);
            signInPageObjects.noThanksBtn.click();
        }
        catch (Exception e)
        {
            LogResults.info("Google Account Linking not displayed");
        }
    }
}
