import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomerPage extends BasePage{
    private By selectYourName = By.xpath("//*[@id=\"userSelect\"]");
    private By login = By.xpath("/html/body/div/div/div[2]/div/form/button");



    public CustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void chooseCustomer (String name) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(selectYourName));
        Select selectName = new Select(getDriver().findElement(selectYourName));
        selectName.selectByVisibleText(name);
    }
    public void clickLogin () {
        getDriver().findElement(login).click();
    }
    public void customerLogin (String name) {
        chooseCustomer(name);
        clickLogin();
    }
}
