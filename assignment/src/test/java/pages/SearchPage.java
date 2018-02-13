package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import objects.SearchPageObjects;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;
import utils.LogResults;

import java.util.List;
import java.util.Properties;

/**
 * <h1>Search Page Operations</h1>
 * The class has methods to be done on Search page elements
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-12
 */
public class SearchPage extends Helper {
    SearchPageObjects searchPageObjects;

    /**
     * Default constructor for Search Page
     *
     * @param driver AppiumDriver object
     */
    public SearchPage(AppiumDriver driver) {
        super(driver);
        searchPageObjects = new SearchPageObjects();
        PageFactory.initElements(new AppiumFieldDecorator(driver), searchPageObjects);
    }

    /**
     * Method to enter Search Criteria on Search Page
     *
     * @param fileProperties Properties file to pick SearchCriteria value from eBay.properties
     */
    public void enterSearchCriteria(Properties fileProperties) {
        searchPageObjects.searchTextBox.sendKeys(fileProperties.getProperty("SearchCriteria"));
        LogResults.info("Entered Search Criteria on Search page");
    }

    /**
     * Method selects item from suggested list dispayed after adding search criteria on Search Page
     */
    public void selectFromSggestedList() {
        waitForElelemt(searchPageObjects.suggestedListElements.get(0));
        searchPageObjects.suggestedListElements.get(0).click();
        LogResults.info("Selects item from suggested list on Search page");
    }

    /**
     * Method clicks on relevant item from product list dispayed in search results
     *
     * @param fileProperties Properties file to pick SelectProductStartWith value from eBay.properties
     */
    public void clickSpecificProduct(Properties fileProperties) {
        LogResults.info("Select specific product from search results");
        List<MobileElement> allProducts = searchPageObjects.productTitles;
        MobileElement ele;
        for (MobileElement e : allProducts) {
            if (e.getText().startsWith(fileProperties.getProperty("SelectProductStartWith"))) {
                e.click();
                break;
            }
        }
    }

}
