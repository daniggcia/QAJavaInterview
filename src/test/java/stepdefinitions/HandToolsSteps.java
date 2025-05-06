package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HandToolsPage;
import com.qainterview.utils.DriverFactory;

import java.util.List;

public class HandToolsSteps {

    WebDriver driver = DriverFactory.getDriver();
    HandToolsPage handToolsPage = new HandToolsPage(driver);

    @When("navega al menú Categories y selecciona Hand Tools")
    public void navega_al_menú_categories_y_selecciona_hand_tools() {

    }

    @And("aplica los filtros por categoría {string} y marca {string}")
    public void aplica_los_filtros(String category, String brand) {
        handToolsPage.filterByCategory(category);
        handToolsPage.filterByBrand(brand);
    }

    @Then("el precio de cada herramienta mostrada es mayor a cero")
    public void el_precio_de_cada_herramienta_es_mayor_a_cero() {
        List<WebElement> precios = handToolsPage.getPrices();
        for (WebElement precio : precios) {
            String textoPrecio = precio.getText().replace("$", "").trim();
            double valor = Double.parseDouble(textoPrecio);
            Assert.assertTrue("El precio es menor o igual a cero: " + valor, valor > 0);
        }
    }
}