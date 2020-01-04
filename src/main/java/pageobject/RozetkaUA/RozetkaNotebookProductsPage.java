package pageobject.RozetkaUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

import java.util.List;
import java.util.stream.Collectors;

public class RozetkaNotebookProductsPage extends AbstractPage {

    @FindBy(xpath = "//label[@for='ROG']")
    private WebElement inputProductParameter;

    @FindBys({
            @FindBy(xpath = "//span[@class='goods-tile__title']")
    })
    private List<WebElement> productList;

    public RozetkaNotebookProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getInputProductParameterText() {
        String productText = inputProductParameter.getAttribute("for");
        return productText;
    }

    public void selectInputProductParameter() throws InterruptedException {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputProductParameter));
        inputProductParameter.click();
        Thread.sleep(1000);
    }

    public List<String> getProductListText() {
        return productList
                .stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }
}
