package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void irAlCarritoYProcederAlCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement botonCarrito = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-test='nav-cart']")));
        botonCarrito.click();
    }
    public void hacerClickEnProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement checkoutBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Proceed to checkout')]"))
            );
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
            checkoutBtn.click();
        } catch (TimeoutException e) {
            System.err.println("Botón 'Proceed to checkout' no disponible: " + e.getMessage());
            throw e;
        }
    }
}