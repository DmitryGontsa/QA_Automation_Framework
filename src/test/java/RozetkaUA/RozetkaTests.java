package RozetkaUA;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.RozetkaUA.RozetkaMainPage;
import pageobject.RozetkaUA.RozetkaNotebookProductsPage;

import java.util.List;

public class RozetkaTests extends BaseTest {

    @Test
    public void verifyRozetkaFiltersFunctionality() throws InterruptedException {

        String navUrl = propertyHelper.readProperty("rozetka.site.url");
        webDriver.get(navUrl);

        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(webDriver);
        RozetkaNotebookProductsPage rozetkaNotebookProductsPage = rozetkaMainPage.selectProductMenuItem();

        rozetkaNotebookProductsPage.selectInputProductParameter();
        String expectedProductText = rozetkaNotebookProductsPage.getInputProductParameterText();

        List<String> actualProductText = rozetkaNotebookProductsPage.getProductListText();

        Assert.assertFalse("There are no item found!", actualProductText.isEmpty());
        actualProductText.forEach(item -> {
            Assert.assertTrue("There is no such item present!", item.contains(expectedProductText));
        });
    }
}
