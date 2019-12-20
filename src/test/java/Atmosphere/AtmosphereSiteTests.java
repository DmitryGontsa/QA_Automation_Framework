package Atmosphere;

import common.BaseTest;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pageobject.Atmosphere.AtmosphereCurrentProductPage;
import pageobject.Atmosphere.AtmosphereMainPage;
import pageobject.Atmosphere.AtmosphereProductsPage;
import pageobject.Atmosphere.AtmosphereShoppingCartPage;

public class AtmosphereSiteTests extends BaseTest {

    @Test
    public void verifySelectedProductWithFinalShoppingPageFunctionality() {

        String navUrl = propertyHelper.readProperty("atmosphere.site.url");
        webDriver.get(navUrl);

        AtmosphereMainPage atmosphereMainPage = new AtmosphereMainPage(webDriver);
        AtmosphereProductsPage atmosphereProductsPage = atmosphereMainPage.setSearchInputAndClickSubmit("PARKAS");

        String expectedTitleText = atmosphereProductsPage.getProductTitleText();
        String expectedColorText = atmosphereProductsPage.getProductColorText();
        String expectedSizeText = atmosphereProductsPage.getProductSizeText();

        AtmosphereCurrentProductPage atmosphereCurrentProductPage = atmosphereProductsPage.moveToProductPage();
        atmosphereCurrentProductPage.setColorButton();
        atmosphereCurrentProductPage.setSizeButton();
        atmosphereCurrentProductPage.setAddToCartButton();

        AtmosphereShoppingCartPage atmosphereShoppingCartPage = atmosphereCurrentProductPage.moveToShoppingCartPage();
        String actualTitleText = atmosphereShoppingCartPage.getProductTitleText();
        String actualColorText = atmosphereShoppingCartPage.getProductColorText();
        String actualSizeText = atmosphereShoppingCartPage.getProductSizeText();

        SoftAssert asert = new SoftAssert();
        asert.assertEquals(actualTitleText, expectedTitleText, "This is incorrect product name!");
        asert.assertEquals(actualColorText, expectedColorText, "This is incorrect product color!");
        asert.assertEquals(actualSizeText, expectedSizeText, "This is incorrect product size!");
        asert.assertAll();
    }
}
