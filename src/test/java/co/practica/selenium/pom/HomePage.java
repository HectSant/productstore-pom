package co.practica.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    public By article1 = By.linkText("Samsung galaxy s6");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void home(WebDriver driver) {
        Duration duration = Duration.ofSeconds(10); // Cambiado a Duration
        WebDriverWait wait = new WebDriverWait(driver, duration); // Cambiado a Duration
        WebElement image = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='imgs/galaxy_s6.jpg']"))); // Espera hasta que la imagen sea clickeable
        image.click(); // Hace clic en la imagen

    }
}
