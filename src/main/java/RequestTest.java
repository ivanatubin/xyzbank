import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class RequestTest {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private ManagerPage managerPage;
    private AddCustomerPage addCustomerPage;
    private CustomerPage customerPage;
    private AccountPage accountPage;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ivana\\Desktop\\Bootcamp\\novChrome\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        homePage = new HomePage(driver,driverWait);
        managerPage = new ManagerPage(driver,driverWait);
        addCustomerPage = new AddCustomerPage(driver,driverWait);
        customerPage = new CustomerPage(driver,driverWait);
        accountPage = new AccountPage(driver,driverWait);
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test(priority = 1)
    public void testManagerLogin () {
        homePage.managerLogin();
        driverWait.until(ExpectedConditions.urlContains("manager"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
    }

    @Test (priority = 2)
    public void testKreiranjeCustomera () {
        managerPage.clickAddCustomer();
        addCustomerPage.addCustomer("Proba","Prezime","12330");
        Assert.assertTrue(addCustomerPage.isNewCustomerAdded());
        addCustomerPage.acceptAlert();
    }

    @Test (priority = 3)
    public void testCustomerLogin () {
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        homePage.customerLogin();
        customerPage.customerLogin("Albus Dumbledore");
        driverWait.until(ExpectedConditions.urlContains("account"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account");

    }

    @Test (priority = 4)
    public void uspesanDepozitTest () {
        accountPage.deposit("1000");
        Assert.assertEquals(accountPage.messageAfterDeposit(), "Deposit Successful");

    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }

}
