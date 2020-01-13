package Booking;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.Booking.BookingMainPage;
import pageobject.Booking.BookingResultsPage;
import pageobject.panels.BookingCalendarPanel;

public class BookingTests extends BaseTest {

    @Test
    public void verifySearchWorksAsExpectedTest() {
        String navigationUrl = propertyHelper.readProperty("booking.main.page.url");
        webDriver.get(navigationUrl);

        BookingMainPage bookingMainPage = new BookingMainPage(webDriver);
        bookingMainPage.typeTravelPlace("Милан");

        BookingCalendarPanel calendarPanel = bookingMainPage.openTravelingCalendar();
        calendarPanel.selectTravelDate("25", "Март 2020");

        BookingResultsPage bookingResultsPage = bookingMainPage.performSearch();
        String firstHotel = bookingResultsPage.getFirstAvailableHotelDestination();
        String actualResult = firstHotel.contains(" ") ? firstHotel.split(" ")[0] : firstHotel;

        Assert.assertEquals("There is incorrect first destination displayed!",
                "Mилан", actualResult);
    }
}
