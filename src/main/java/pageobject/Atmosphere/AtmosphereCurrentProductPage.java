package pageobject.Atmosphere;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class AtmosphereCurrentProductPage extends AbstractPage {

    @FindBy(xpath = "//a[@data-value='01']")
    private WebElement colorButton;

    @FindBy(xpath = "//a[@href][@title='S']")
    private WebElement sizeButton;

    @FindBy(xpath = "//button[@class='add-cart product-detail__button product-detail__button-icon']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@href][@class='header-cart__trigger drawer-ui__toggle']")
    private WebElement shoppingCartButton;

    public AtmosphereCurrentProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setColorButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(colorButton));
        colorButton.click();
    }

    public void setSizeButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(sizeButton));
        sizeButton.click();
    }

    public void setAddToCartButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }

    public AtmosphereShoppingCartPage moveToShoppingCartPage() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton));
        shoppingCartButton.click();
        return new AtmosphereShoppingCartPage(webDriver);
    }
}
