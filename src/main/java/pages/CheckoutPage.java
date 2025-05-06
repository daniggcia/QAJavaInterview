package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void introducirCredenciales(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campoEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));
        WebElement campoPassword = driver.findElement(By.id("login-password"));

        campoEmail.clear();
        campoEmail.sendKeys(email);

        campoPassword.clear();
        campoPassword.sendKeys(password);
    }

    public String obtenerMensajeDeError() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensajeError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".invalid-feedback")));
        return mensajeError.getText();
    }

    public void hacerClickEnLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='submit'][value='Login']")));
        loginButton.click();
    }


}