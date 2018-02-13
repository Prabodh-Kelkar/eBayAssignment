package objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.List;

/**
 * <h1>Search Page Objects</h1>
 * The class has locators for Main Page -
 * - elements used for automation
 * <p>
 *
 * @author Prabodh Kelkar
 * @version 1.0
 * @since 2018-02-11
 */
public class SearchPageObjects {

    //Search Text Box on top of page
    @AndroidFindBy(id = "com.ebay.mobile:id/search_src_text")
    public MobileElement searchTextBox;

    //Suggested items list displayed
//    @AndroidFindBy(id = "android.widget.RelativeLayout")
//    public MobileElement searchList;

    //Locator for suggested list elements
    @AndroidFindBy(id = "com.ebay.mobile:id/text")
    public List<MobileElement> suggestedListElements;

//    @AndroidFindBy(id = "com.ebay.mobile:id/textview_item_title")
//    public MobileElement searchItemTitleLabel;

//    @AndroidFindBy(id = "com.ebay.mobile:id/cell_collection_item")
//    public List<MobileElement> allProducts;

    //Locator to identify Product titles in search results
    @AndroidFindBy(id = "com.ebay.mobile:id/textview_item_title")
    public List<MobileElement> productTitles;
}
