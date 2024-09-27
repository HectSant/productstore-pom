package co.practica.selenium.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DetailPage extends BasePage {

    public By addArticle1 = By.linkText("Add to cart");

    public DetailPage(WebDriver driver) {
        super(driver);
    }

    public void addArticle(WebDriver driver) throws InterruptedException {
        click(addArticle1);
    }

 public String PopUpClick(WebDriver driver) throws InterruptedException {
     WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10)); // Inicializa el wait
     //Acepta PopUp
     Alert alert = wait.until(ExpectedConditions.alertIsPresent());
     String text = alert.getText();
     alert.accept();
     System.out.println("Product added." + text);  //*****revisar que si se puede poner en addcartest***** Verifica que el Texto del PopUp sea Igual al esperado
     return text;
 }

}