package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.ProductPageObjects;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.LogResults;


/**
 * <h1>Product Page Operations</h1>
 * The class has methods to be done on Product page elements
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class ProductPage extends Helper {

    ProductPageObjects productPageObjects;

    /**
     * Default constructor for Product Page
     *
     * @param driver AppiumDriver object
     */
    public ProductPage(AppiumDriver driver) {
        super(driver);
        productPageObjects = new ProductPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), productPageObjects);
    }

    /**
     * This method clicks on but it now button in product details page
     */
    public void clickBuyItNow() {
        waitForElelemt(productPageObjects.buyItNowbtn);
        productPageObjects.buyItNowbtn.click();
        LogResults.info("Clicked Buy It Now on Product page");
    }

    /**
     * Method to click SignOut button in Product Page
     */
    public void signOutFromMenu() {
        waitForElelemt(productPageObjects.homeBtn);
        productPageObjects.homeBtn.click();
        waitForElelemt(productPageObjects.signInStatus);
        productPageObjects.signInStatus.click();
        waitForElelemt(productPageObjects.signOut);
        productPageObjects.signOut.click();
        LogResults.info("Signing Out");
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            LogResults.error("Alert about notifications not displayed");
        }
    }
}

