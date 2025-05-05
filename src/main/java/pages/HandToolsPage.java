package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HandToolsPage {
    WebDriver driver;
    WebDriverWait wait;

    public HandToolsPage(WebDriver driver) {
        this.driver = driver;
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
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(.,'" + brand + "')]//input")));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // Obtener lista de precios de los productos visibles
    public List<WebElement> getPrices() {
        By priceSelector = By.cssSelector(".card-price"); // ⚠️ Cambiar si difiere
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(priceSelector));
        return driver.findElements(priceSelector);
    }
}