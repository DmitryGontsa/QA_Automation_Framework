package pageobject.RozetkaUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class RozetkaMainPage extends AbstractPage {

    @FindBy(xpath = "//button[@class='menu-toggler']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "(//a[@class='menu__link'])[1]")
    private WebElement productMenuItem;

    public RozetkaMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public RozetkaNotebookProductsPage selectProductMenuItem() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productCatalogButton));
        productCatalogButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(productMenuItem));
        productMenuItem.click();
        return new RozetkaNotebookProductsPage(webDriver);
    }
}
