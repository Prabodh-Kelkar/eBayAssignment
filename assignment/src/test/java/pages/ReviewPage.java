package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.ReviewPageObjects;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.LogResults;

/**
 * <h1>Review Page Operations</h1>
 * The class has methods to be done on Review page elements
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class ReviewPage extends Helper{

    ReviewPageObjects reviewPageObjects;

    /**
     * Default constructor for Review Page
     *
     * @param driver AppiumDriver object
     */
    public ReviewPage(AppiumDriver driver) {
        super(driver);
        reviewPageObjects = new ReviewPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver),reviewPageObjects);
    }

    /**
     * This method clicks on but it now button in product details page
     */
    public void clickReview()
    {
        waitForElelemt(reviewPageObjects.reviewbtn);
        reviewPageObjects.reviewbtn.click();
        LogResults.info("Clicked review on review quantity page");
    }
}
