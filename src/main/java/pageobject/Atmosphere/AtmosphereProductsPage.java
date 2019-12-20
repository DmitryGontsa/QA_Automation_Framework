package pageobject.Atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class AtmosphereProductsPage extends AbstractPage {

    @FindBy(xpath = "(//span[@class='product-title-text'])[5]")
    private WebElement productTitle;

    @FindBy(xpath = "//span[@class='facets-side__items-colour-box'][@title='Black']")
    private WebElement productColor;

    @FindBy(xpath = "//span[text()='S (51)']")
    private WebElement productSize;

    protected AtmosphereProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AtmosphereCurrentProductPage moveToProductPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productTitle));
        productTitle.click();
        return new AtmosphereCurrentProductPage(webDriver);
    }

    public String getProductTitleText() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productTitle));
        String productTitleText = productTitle.getText();
        return productTitleText;
    }

    public String getProductColorText() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productColor));
        String productColorText = productColor.getAttribute("title");
        return productColorText;
    }

    public String getProductSizeText() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productSize));
        String productSizeText = productSize.getText();
        return productSizeText;
    }
}
