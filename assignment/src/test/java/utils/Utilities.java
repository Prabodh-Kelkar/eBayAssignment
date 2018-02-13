package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * <h1>Utilities Class</h1>
 * The Utilities class has methods supporting automation
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class Utilities {

    AppiumDriverLocalService service;
    public AppiumDriver driver;
    DesiredCapabilities capabilities;
    public WebDriverWait wait;

    /**
     * This method starts Appium Server node, if not started throws runtime exception
     */
    public void beforeClass() throws RuntimeException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new RuntimeException("Appium Server Node is Not started");
        }
    }

    /**
     * This method quits Appium driver object and stops Appium Server node
     */
    public void afterClass() {
        if (driver != null)
            driver.quit();
        if (service != null)
            service.stop();
    }

    /**
     * This method does setup operation - initializing driver object
     *
     * @param fileProperties Properties file to pick DEVICE_NAME, APP, APP_PACKAGE and APP_ACTIVITY values from eBay.properties
     * @return AppiumDriver This returns initialized AppiumDriver object
     */
    public AppiumDriver setUpDriver(Properties fileProperties) throws MalformedURLException {
        capabilities = new DesiredCapabilities();

        //Setting up required desired capabilities
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, fileProperties.getProperty("DEVICE_NAME"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        //Setting up capabilities related to app under test
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") +
                fileProperties.getProperty("APP"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, fileProperties.getProperty("APP_PACKAGE"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, fileProperties.getProperty("APP_ACTIVITY"));

        //Initializing driver object
        driver = new AndroidDriver(new URL("http://" + fileProperties.getProperty("APPIUM_SERVER") + ":4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return driver;
    }

    /**
     * This method reads values from Properties file
     *
     * @return Properties object pointing to eBay.properties file
     */
    public Properties readProperties() throws FileNotFoundException, IOException {
        File propFile = new File(System.getProperty("user.dir") + "\\properties\\eBay.properties");
        FileInputStream fileIO = new FileInputStream(propFile);
        Properties fileProperties = new Properties();
        fileProperties.load(fileIO);

        return fileProperties;

    }
}
