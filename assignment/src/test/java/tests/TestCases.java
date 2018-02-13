package tests;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.LogResults;
import utils.Utilities;

import java.io.IOException;


/**
 * <h1>Test Cases Class</h1>
 * The Test Cases class has Test Cases automating eBay app
 * TestNG annotations are used in this class.
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class TestCases {

    public AppiumDriver driver;
    public Utilities util;
    //public static Logger logMe;
    public LogResults logResults;

    /**
     * Setup method - setting up environment and initializing driver
     */
    @BeforeClass
    public void setUp() throws IOException, RuntimeException {
        logResults = new LogResults();
        LogResults.info("Starting Logging...");

        util = new Utilities();
        LogResults.info("Starting Appium Server node");
        util.beforeClass();

        LogResults.info("Initializing Driver");
        driver = util.setUpDriver(util.readProperties());
    }

    /**
     * This Test Case performs login, search item, add to kart, review operation
     * (Proceed to payment is not implemented as we are on production environment)
     */
    @Test
    public void TestCase01() throws IOException {
        LogResults.startTestCase("Test Case 01");
        LogResults.info("Clicks Search box on Main Window");
        //Clicks Search box on Main Window
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSearch();

        LogResults.info("Clicks Search box on Main Window");
        //Enter search criteria to search - from properties file
        SearchPage searchPage = new SearchPage(driver);
        searchPage.enterSearchCriteria(util.readProperties());

        LogResults.info("Select from suggested list and click on particular product in search results");
        //Select from suggested list and click on particular product in search results
        searchPage.selectFromSggestedList();
        searchPage.clickSpecificProduct(util.readProperties());

        LogResults.info("Click Buy It Now on product page");
        //Click Buy It Now on product page
        ProductPage productPage = new ProductPage(driver);
        productPage.clickBuyItNow();

        LogResults.info("Signin now to proceed with payment");
        // Signin now to proceed with payment
        SignInPage signInPage = new SignInPage(driver);
        signInPage.loginApp(util.readProperties());

        LogResults.info("Review order quantity");
        //Review order quantity
        ReviewPage reviewPage = new ReviewPage(driver);
        reviewPage.clickReview();

        LogResults.info("Scroll through the Order details page and click Cancel");
        //Scroll through the Order details page and click Cancel
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        orderDetailsPage.scrollPage();
        orderDetailsPage.clickProceedtoPay();

        LogResults.info("Closing the Payment details page - as we are on production environment not proceeding with payment");
        //Click Back on Payment details page
        //
        // (Proceed to payment is not implemented as we are on production environment)
        //
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickCross();

        LogResults.info("Signout after cancelling the payment");
        //Signout after Navigating back to Product page
        productPage = new ProductPage(driver);
        productPage.signOutFromMenu();

        LogResults.endTestCase("Test Case 01");
    }

    /**
     * Teardown method - quitting driver and stopping Appium Sserver node
     */
    @AfterClass
    public void tearDown() {
        util.afterClass();
    }
}