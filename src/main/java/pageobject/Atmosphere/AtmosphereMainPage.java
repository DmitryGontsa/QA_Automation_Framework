package pageobject.Atmosphere;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class AtmosphereMainPage extends AbstractPage {

    @FindBy(xpath = "//input[@class='header-search__input ui-autocomplete-input']")
    private WebElement searchInput;

    public AtmosphereMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public AtmosphereProductsPage setSearchInputAndClickSubmit(String searchText) {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(searchText, Keys.ENTER);
        return new AtmosphereProductsPage(webDriver);
    }
}
