package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HandToolsPage extends BasePage {
    private WebDriverWait wait;

    public HandToolsPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navegar a Hand Tools
    public void goToHandTools() {
        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories")));
        categories.click();

        WebElement handTools = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Hand Tools")));
        handTools.click();
    }

    // Aplicar filtro por categoría
    public void filterByCategory(String category) {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'" + category + "')]//input")));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // Aplicar filtro por marca
    public void filterByBrand(String brand) {
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(.,'" + brand + "')]//input")
        ));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }
    public List<WebElement> getPrices() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("span[data-test='product-price']")
        ));
        return driver.findElements(By.cssSelector("span[data-test='product-price']"));
    }


}