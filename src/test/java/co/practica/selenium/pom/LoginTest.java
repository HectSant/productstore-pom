package co.practica.selenium.pom;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class LoginTest {
    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws Exception {
        loginPage = new LoginPage(driver);  // Inicializa el driver
        driver = loginPage.chromeDriverConnection();  // Luego conecta el driver
        loginPage.visit("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void loginUser() throws InterruptedException {
        loginPage.login("username", "password");
        Thread.sleep(2000);  // Esto es mejor reemplazarlo por un WebDriverWait para mayor robustez

        assertEquals(loginPage.loginSuccessfulText(), "Welcome username", "El mensaje de confirmación no coincide!");
    }
}