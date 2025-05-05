package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.RentalsPage;
import utils.DriverFactory;

import java.util.List;

public class RentalsSteps {

    WebDriver driver = DriverFactory.getDriver();
    RentalsPage rentalsPage = new RentalsPage(driver);

    @Given("el usuario accede a la página principal")
    public void el_usuario_accede_a_la_página_principal() {
        driver.get("https://practicesoftwaretesting.com");
    }

    @When("navega al menú Categories y selecciona Rentals")
    public void navega_al_menú_categories_y_selecciona_rentals() {
        rentalsPage.goToRentals();
    }

    @Then("se visualizan los títulos de todas las herramientas disponibles")
    public void se_visualizan_los_títulos_de_todas_las_herramientas_disponibles() {
        List<WebElement> titles = rentalsPage.getToolTitles();
        Assert.assertFalse("No se encontraron títulos", titles.isEmpty());

        for (WebElement title : titles) {
            String text = title.getText();
            Assert.assertFalse("Título vacío", text.isBlank());
            System.out.println("🔧 Título encontrado: " + text);
        }
    }
}
