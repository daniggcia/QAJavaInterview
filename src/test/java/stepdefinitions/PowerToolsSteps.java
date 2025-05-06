package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import static org.junit.Assert.*;
import static com.qainterview.utils.DriverFactory.getDriver;

public class PowerToolsSteps {

    WebDriver driver = getDriver();
    PowerToolsPage powerToolsPage = new PowerToolsPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @Given("el usuario accede a la página principal")
    public void el_usuario_accede_a_la_página_principal() {
        driver.get("https://practicesoftwaretesting.com/");
    }

    @When("navega al menú Categories y selecciona {string}")
    public void navega_al_menú_categories_y_selecciona_categoria(String categoria) {
        powerToolsPage.seleccionarCategoria(categoria);
    }

    @When("hace clic en un producto y lo añade al carrito")
    public void hace_clic_en_un_producto_y_lo_añade_al_carrito() {
        powerToolsPage.seleccionarPrimerProductoYAgregarAlCarrito();
    }

    @When("introduce el email {string} y contraseña {string}")
    public void introduce_el_email_y_contraseña(String email, String password) {

    }

    @When("pulsa el botón Login")
    public void pulsa_el_boton_login() {
        checkoutPage.hacerClickEnLogin();
    }

    @Then("se muestra el mensaje de error {string}")
    public void se_muestra_el_mensaje_de_error(String mensajeEsperado) {

    }
    @And("accede al carrito y procede al checkout")
    public void accede_al_carrito_y_procede_al_checkout() {
        cartPage.irAlCarritoYProcederAlCheckout(); // si tienes este método
        cartPage.hacerClickEnProceedToCheckout();
    }
}