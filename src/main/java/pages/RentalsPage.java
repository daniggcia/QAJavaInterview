package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class RentalsPage {

    WebDriver driver;

    // Constructor
    public RentalsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Localizador del menú Categories > Rentals
    By categoriesMenu = By.xpath("//a[text()='Categories']");
    By rentalsOption = By.xpath("//a[text()='Rentals']");

    // Títulos de productos
    By productTitles = By.cssSelector(".product-title");

    // Método para navegar a Rentals
    public void goToRentals() {
        driver.findElement(categoriesMenu).click();
        driver.findElement(rentalsOption).click();
    }

    // Método para obtener todos los títulos de herramientas
    public List<WebElement> getToolTitles() {
        return driver.findElements(productTitles);
    }
}