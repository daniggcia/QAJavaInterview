package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;

    }


    public void seleccionarCategoria(String nombreCategoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Actions actions = new Actions(driver);

        // Mover el ratón al menú Categories
        WebElement menuCategories = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Categories")));
        actions.moveToElement(menuCategories).perform();

        // Pequeña espera para que aparezca el submenú
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Seleccionar la categoría específica
        String xpath = String.format("//a[normalize-space(text())='%s']", nombreCategoria);
        WebElement opcionCategoria = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        opcionCategoria.click();
    }
}