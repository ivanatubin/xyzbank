import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage{
    private By transactions = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]");
    private By deposit = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By withdrawal = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By input = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By button = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By message = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");
    private By logout = By.xpath("/html/body/div/div/div[1]/button[2]");


    public AccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void withdrawal (String iznos) throws InterruptedException {
        getDriver().findElement(withdrawal).click();
        Thread.sleep(2000);
        getDriver().findElement(input).sendKeys(iznos);
        Thread.sleep(2000);
        getDriver().findElement(button).click();
        Thread.sleep(2000);
    }


    public void deposit (String cifra) {
        getDriver().findElement(deposit).click();
        getDriverWait().until(ExpectedConditions.elementToBeClickable(input));
        getDriver().findElement(input).sendKeys(cifra);
        getDriver().findElement(button).click();

    }
    public String messageText () {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(message));
        return getDriver().findElement(message).getText();
    }

    public void logout () {
        getDriver().findElement(logout).click();
    }

    public By getTransactions() {
        return transactions;
    }

    public void setTransactions(By transactions) {
        this.transactions = transactions;
    }

    public By getDeposit() {
        return deposit;
    }

    public void setDeposit(By deposit) {
        this.deposit = deposit;
    }

    public By getWithdrawl() {
        return withdrawal;
    }

    public void setWithdrawl(By withdrawl) {
        this.withdrawal = withdrawl;
    }
}
