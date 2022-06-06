import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage extends BasePage{

    private By selectCustomer = By.id("userSelect");
    private By currency = By.id("currency");
    private By processBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");


    public boolean isAccOpenSuccessfully () {
        if (getDriver().switchTo().alert().getText().contains("Account created successfully")) {
            return true;}
        return false;
    }

    public void openAcc( String customer, String currency){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(selectCustomer));
        Select selectName = new Select(getDriver().findElement(selectCustomer));
        selectName.selectByVisibleText(customer);

        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.currency));
        Select selectCurrency = new Select(getDriver().findElement(this.currency));
        selectCurrency.selectByVisibleText(currency);

        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.processBtn));
        getDriver().findElement(processBtn).click();

    }

    public OpenAccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }
}

