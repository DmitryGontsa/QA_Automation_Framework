package HotlineUA;

import common.BaseTest;
import common.model.HotlineItems;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import pageobject.HotlineUA.HotlineMainPage;
import pageobject.HotlineUA.HotlineProductsPage;

import java.util.Comparator;
import java.util.List;

public class HotlineTest extends BaseTest {

    @Test
    public void verifyHotlineDescendingSortingTest() {

        String navigateUrl = propertyHelper.readProperty("hotline.main.page.url");
        webDriver.get(navigateUrl);

        HotlineMainPage hotlineMainPage = new HotlineMainPage(webDriver);
        HotlineProductsPage hotlineProductsPage = hotlineMainPage.selectProductItemByNotebooks();

        hotlineProductsPage.clickOnProductInputByLaptopsForGames();
        hotlineProductsPage.clickOnProductInputByRazerLaptops();

        List<HotlineItems> unsortedHotlineItemsList = hotlineProductsPage.getHotlineItems();
        unsortedHotlineItemsList.sort(Comparator.reverseOrder());

        hotlineProductsPage.orderBy("убыванию цены");

        List<HotlineItems> sortedHotlineItemsList = hotlineProductsPage.getHotlineItems();

        ReflectionAssert.assertReflectionEquals("There is incorrect sorting found!",
                unsortedHotlineItemsList, sortedHotlineItemsList);
    }
}
