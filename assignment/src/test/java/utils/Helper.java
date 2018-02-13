package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <h1>Helper class</h1>
 * The class has methods common for all pages
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class Helper {

public AppiumDriver<MobileElement> driver;
public WebDriverWait webDriverWait;

    /**
     * Default constructor for Helper class
     *
     * @param driver AppiumDriver object
     */
    public Helper(AppiumDriver driver) {
       this.driver = driver;
        webDriverWait = new WebDriverWait( driver, 30);
    }

    /**
     * This method implements wait functionality till element is clickable
     *
     * @param element MobileElement to be used for wait
     */
    public void waitForElelemt(MobileElement element)
    {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
