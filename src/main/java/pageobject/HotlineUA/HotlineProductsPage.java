package pageobject.HotlineUA;

import common.model.HotlineItems;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageobject.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class HotlineProductsPage extends AbstractPage {

    @FindBy(xpath = "(//label[@class='type-checkbox plus'])[5]")
    private WebElement productInputByLaptopsForGames;

    @FindBy(xpath = "(//label[@class='type-checkbox plus'])[76]")
    private WebElement productInputByRazerLaptops;

    @FindBys({
            @FindBy(xpath = "//li[@class='product-item']")
    })
    private List<WebElement> notebooksList;

    @FindBy(xpath = "//select[@name='sort']")
    private WebElement sortSelect;

    private static final String TITLE_LOCATOR = ".//p[@class='h4']/a";
    private static final String PRICE_LOCATOR = ".//div[@class='stick-pull cell-xs-6']//span[@class='value']";

    public HotlineProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnProductInputByLaptopsForGames() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productInputByLaptopsForGames));
        productInputByLaptopsForGames.click();
    }

    public void clickOnProductInputByRazerLaptops() {
        moveToElement(productInputByRazerLaptops);
        webDriverWait.until(ExpectedConditions.visibilityOf(productInputByRazerLaptops));
        productInputByRazerLaptops.click();
    }

    public void orderBy(String text) {
        Select orderSelect = new Select(sortSelect);
        orderSelect.selectByVisibleText(text);
    }

    public List<HotlineItems> getHotlineItems() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(notebooksList));
        return notebooksList
                .stream()
                .map(product -> {
                    String title = product.findElement(By.xpath(TITLE_LOCATOR)).getText();
                    String value1 = product.findElement(By.xpath(PRICE_LOCATOR)).getText();
                    String value2 = value1.replaceAll("\\s", "");
                    Integer price = Integer.valueOf(value2);
                    return new HotlineItems(title, price);
                })
                .collect(Collectors.toList());
    }
}
