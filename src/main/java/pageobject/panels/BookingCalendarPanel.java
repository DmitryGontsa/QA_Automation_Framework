package pageobject.panels;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.AbstractPage;

import java.util.List;

public class BookingCalendarPanel extends AbstractPage {

    @FindBy(xpath = "//div[@data-bui-ref='calendar-next']")
    private WebElement nextMonthButton;

    @FindBy(xpath = "(//div[@class='bui-calendar__wrapper'])[1]")
    private WebElement calendarMonth;

    public BookingCalendarPanel(WebDriver webDriver) {
        super(webDriver);
    }

    public void selectTravelDate(String day, String monthYear) {
        selectTravelMonthAndYear(monthYear);
        selectTravelDay(day);
    }

    private void selectTravelDay(String day) {
        String travelDayLocator = ".//td[@data-date]//span[@aria-hidden]";

        List<WebElement> travelDays = calendarMonth.findElements(By.xpath(travelDayLocator));
        for (WebElement travelDay : travelDays) {
            if (StringUtils.equals(travelDay.getText(), day)) {
                travelDay.click();
                break;
            }
        }
    }

    private void selectTravelMonthAndYear(String monthYear) {
        boolean isMonthNotFound = true;

        while (isMonthNotFound) {
            WebElement month = webDriver.findElement(By.xpath("(//div[@class='bui-calendar__month'])[1]"));
            if (StringUtils.equals(month.getText(), monthYear)) {
                isMonthNotFound = false;
            } else {
                nextMonthButton.click();
            }
        }
    }
}
