package pageobject.Atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class AtmosphereShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='sc-product__title-link']")
    private WebElement productTitle;

    @FindBy(xpath = "(//span[@class='sc-product__property__value']/span/..)[1]")
    private WebElement productColor;

    @FindBy(xpath = "(//span[@class='sc-product__property__value'])[2]")
    private WebElement productSize;

    public AtmosphereShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductTitleText() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productTitle));
        String productTitleValue = productTitle.getText();
        return productTitleValue;
    }

    public String getProductColorText() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productColor));
        String productColorValue = productColor.getText();
        return productColorValue;
    }

    public String getProductSizeText() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productSize));
        String productSizeValue = productSize.getText();
        return productSizeValue;
    }
}
