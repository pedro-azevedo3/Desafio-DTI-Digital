package automationpractice.page;

import org.openqa.selenium.By;
public class WomenPage {
    public static final By btnWomen = By.cssSelector("#block_top_menu > ul > li:nth-child(1) > a");
    public static final By selectSortBy = By.cssSelector("#selectProductSort");
    public static final By priceFirstProduct = By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > div.content_price > span.price.product-price");
    public static final By priceSecondProduct = By.cssSelector("#center_column > ul > li:nth-child(2) > div > div.right-block > div.content_price > span");
}
