package co.practica.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class AddCarTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private DetailPage detailPage;
    private WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage.visit("https://www.demoblaze.com/");
        homePage = new HomePage(driver);
        detailPage = new DetailPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginUser() throws InterruptedException {
        loginPage.login("aaaaa123789", "aaaaa123");
        Thread.sleep(2000);  // Esto es mejor reemplazarlo por un WebDriverWait para mayor robustez
        // Esperar hasta que el artículo "Samsung galaxy s6" sea visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.article1));
        // Interactuar con el HomePage para seleccionar el artículo
        homePage.home(driver);
        Thread.sleep(2000);  // Esto es mejor reemplazarlo por un WebDriverWait para mayor robustez
        // Interacion con la seccion de detail para agregar el producto
        detailPage.addArticle(driver);
        Thread.sleep(2000);  // Esto es mejor reemplazarlo por un WebDriverWait para mayor robustez
        //click en aceptar PopUp
        detailPage.PopUpClick(driver);
        Thread.sleep(2000);  // Esto es mejor reemplazarlo por un WebDriverWait para mayor robustez



    }
}
