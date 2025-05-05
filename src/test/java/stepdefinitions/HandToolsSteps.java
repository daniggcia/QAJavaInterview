package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HandToolsPage;


import java.util.List;

public class HandToolsSteps {

    WebDriver driver = DriverFactory.getDriver();
    HandToolsPage handToolsPage = new HandToolsPage(driver);

    @When("navega al menú Categories y selecciona Hand Tools")
    public void navega_al_menú_categories_y_selecciona_hand_tools() {
        handToolsPage.goToHandTools();
    }

    @And("aplica los filtros por categoría {string} y marca {string}")
    public void aplica_los_filtros(String category, String brand) {
        handToolsPage.filterByCategory(category);
        handToolsPage.filterByBrand(brand);
    }

    @Then("el precio de cada herramienta mostrada es mayor a cero")
    public void el_precio_de_cada_herramienta_es_mayor_a_cero() {
        List<WebElement> prices = handToolsPage.getPrices();
        Assert.assertFalse("No se encontraron precios", prices.isEmpty());

        for (WebElement price : prices) {
            String text = price.getText().replace("€", "").trim();
            double value = Double.parseDouble(text);
            System.out.println("💰 Precio encontrado: " + value);
            Assert.assertTrue("Precio no válido: " + value, value > 0);
        }
    }
}