package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PowerToolsPage extends BasePage {

    public PowerToolsPage(WebDriver driver) {
        super(driver);
    }

    public void seleccionarCategoria(String nombreCategoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Espera a que esté presente el menú Categories
        WebElement menuCategories = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("a.nav-link.dropdown-toggle")));

        // Haz clic con JavaScriptExecutor por si Selenium no lo logra hacer normalmente
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menuCategories);

        // Espera y hace clic en la categoría especificada dentro del desplegable
        WebElement categoria = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[normalize-space(text())='" + nombreCategoria + "']")));
        categoria.click();
    }

    public void seleccionarPrimerProductoYAgregarAlCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperamos a que haya al menos un enlace a un producto
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.container a.card")));

        List<WebElement> productos = driver.findElements(By.cssSelector("div.container a.card"));
        System.out.println("Cantidad de productos encontrados: " + productos.size());

        if (productos.isEmpty()) {
            throw new NoSuchElementException("No se encontraron productos.");
        }

        // Hacemos clic en el primer producto
        productos.get(0).click();

        // Esperamos al botón 'Add to Cart'
        WebElement botonAdd = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='add-to-cart']")));
        botonAdd.click();
    }
}