import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerPage extends BasePage{
    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By openAccount = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By customers = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");


    public ManagerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getAddCustomer() {
        return addCustomer;
    }

    public void setAddCustomer(By addCustomer) {
        this.addCustomer = addCustomer;
    }

    public By getOpenAccount() {
        return openAccount;
    }

    public void setOpenAccount(By openAccount) {
        this.openAccount = openAccount;
    }

    public By getCustomers() {
        return customers;
    }

    public void setCustomers(By customers) {
        this.customers = customers;
    }

    public void clickAddCustomer () {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(addCustomer));
        getDriver().findElement(addCustomer).click();
    }
    public void clickOpenAccount () {
        getDriver().findElement(openAccount).click();
    }
    public void clickCustomers () {

        getDriverWait().until(ExpectedConditions.elementToBeClickable(customers));
        getDriver().findElement(customers).click();
    }
}

