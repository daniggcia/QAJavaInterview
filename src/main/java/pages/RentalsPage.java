package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class RentalsPage {

    WebDriver driver;

    public RentalsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRentals() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories")));
        categories.click();
        WebElement rentals = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Rentals")));
        rentals.click();
    }

    public List<WebElement> getToolTitles() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By productTitles = By.cssSelector("h5.card-title");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productTitles));
        return driver.findElements(productTitles);
    }
}