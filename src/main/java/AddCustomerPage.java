import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage {
    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomerBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");


    public AddCustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public By getFirstName() {
        return firstName;
    }

    public void setFirstName(By firstName) {
        this.firstName = firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public void setLastName(By lastName) {
        this.lastName = lastName;
    }

    public By getPostCode() {
        return postCode;
    }

    public void setPostCode(By postCode) {
        this.postCode = postCode;
    }

    public By getAddCustomerBtn() {
        return addCustomerBtn;
    }

    public void setAddCustomerBtn(By addCustomerBtn) {
        this.addCustomerBtn = addCustomerBtn;
    }

    public void addCustomer(String ime, String prezime, String postalcode) {
        addName(ime);
        addLastName(prezime);
        addPostCode(postalcode);
        clickAddCustomer();

    }

    public void addName(String name) {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(firstName));
        getDriver().findElement(firstName).sendKeys(name);
    }

    public void addLastName(String lastName) {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.lastName));
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public void addPostCode(String postBr) {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(postCode));
        getDriver().findElement(this.postCode).sendKeys(postBr);
    }

    public void clickAddCustomer() {
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(addCustomerBtn));
        getDriver().findElement(addCustomerBtn).click();
    }

    public boolean isNewCustomerAdded() {
        if (getDriver().switchTo().alert().getText().contains("Customer added successfully")) {
            return true;
        }
        return false;
    }
}
