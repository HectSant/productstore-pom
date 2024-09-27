package co.practica.selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public By cartButton = By.id("cartur");
    public By PlaceOrderButton = By.cssSelector("button[data-target='#orderModal']");
//Formulario PlaceOrder
    public By nameOrder = By.id("name");
    public By countryOrder = By.id("country");
    public By cityOrder = By.id("city");
    public By creditCardOrder = By.id("card");
    public By monthOrder = By.id("month");
    public By yearOrder = By.id("year");
 //Boton Purchase
    public By purchaseButton = By.xpath("//button[text()='Purchase']");

    private By OkButtonPurchase = By.cssSelector("button.confirm.btn.btn-lg.btn-primary");

 //Confirmation Element
    public By ConfimationText = By.xpath("/html/body/div[10]/h2");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void cart(WebDriver driver) throws InterruptedException {
        click(cartButton);
    }
    public void OrderButton(WebDriver driver) throws InterruptedException {
        click(PlaceOrderButton);
    }
    public void PlaceOrder(String username, String country, String city, String creditCard, String month, String year)
            throws InterruptedException {
        type(username, this.nameOrder);
        type(country, this.countryOrder);
        type(city, this.cityOrder);
        type(creditCard, this.creditCardOrder);
        type(month, this.monthOrder);
        type(year, this.yearOrder);
        click(purchaseButton);
    }
    public String confirmationPurchase(WebDriver driver) throws InterruptedException {
        WebElement confirmation = driver.findElement(ConfimationText);
        String confirmationText = confirmation.getText();
        System.out.println("Thank you for your purchase!" + confirmationText);  //imprime mensaje que trae y esperado
        click(OkButtonPurchase);
        return confirmationText;
    }

}
