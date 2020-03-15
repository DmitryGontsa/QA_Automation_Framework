package pageobject.HotlineUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class HotlineMainPage extends AbstractPage {

    @FindBy(xpath = "//li[@class='level-1 computer']")
    private WebElement productItem;

    @FindBy(xpath = "//a[@class='noutbuki-i-netbuki']")
    private WebElement productItemByNotebooks;

    public HotlineMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HotlineProductsPage selectProductItemByNotebooks() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productItem));
        moveToElement(productItem);
        moveToElement(productItemByNotebooks);
        productItemByNotebooks.click();
        return new HotlineProductsPage(webDriver);
    }
}
