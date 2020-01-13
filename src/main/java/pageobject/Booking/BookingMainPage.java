package pageobject.Booking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;
import pageobject.panels.BookingCalendarPanel;

import java.util.List;

public class BookingMainPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='ss']")
    private WebElement searchInput;

    @FindBy(xpath = "(//div[@class='sb-searchbox__input sb-date-field__field  -empty sb-date__field-svg_icon']//span)[1]")
    private WebElement openCalendarButton;

    @FindBy(xpath = "//button[contains(@class, 'sb-searchbox__button')]")
    private WebElement searchButton;

    @FindBys({
            @FindBy(xpath = "//span[@class='search_hl_name']")
    })
    private List<WebElement> predictiveSearchList;

    @FindBy(xpath = "//div[@class='xpi__content__container']//h1")
    private WebElement searchBoxTitle;

    public BookingMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public BookingResultsPage performSearch() {
        searchButton.click();
        return new BookingResultsPage(webDriver);
    }

    public void typeTravelPlace(String destination) {
        searchInput.sendKeys(destination);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(predictiveSearchList));
        predictiveSearchList.get(0).click();
    }

    public BookingCalendarPanel openTravelingCalendar() {
        webDriverWait.until(ExpectedConditions.visibilityOf(searchBoxTitle));
        searchBoxTitle.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(openCalendarButton));
        openCalendarButton.click();
        return new BookingCalendarPanel(webDriver);
    }
}
