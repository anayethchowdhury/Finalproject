package YourLogoTest;
import Utils.ExcelUtils;
import Utils.MainBaseMethod;
import YourLogoPOM.YourLogoPOM;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import javax.lang.model.element.Name;
import java.time.Duration;
import java.util.List;
public class YourLogoTest extends MainBaseMethod {
    WebDriver driver;
    YourLogoPOM yourLogoPOM = new YourLogoPOM();
    WebDriverWait wait;
    static final String EXCEL_FILE_PATH = System.getProperty("user.dir") + "/Excel/ExcelSpreadsheet.xlsx";


    @BeforeClass
    void setup() {
        driver = getWebDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(yourLogoPOM.url);
    }

    @DataProvider(name = "loadFromdata")
    public static Object[][] dataload() throws Exception {
        return ExcelUtils.getTableArray(EXCEL_FILE_PATH, "Sheet1");
    }

    @Test(dataProvider = "loadFromdata")
    void testForm(String email, String title, String firstname, String lastname, String password, String address, String city, Double zipcode, Double phonenum) throws InterruptedException {
        driver.findElement(yourLogoPOM.Signin1).click();
        Faker faker = new Faker();
        driver.findElement(yourLogoPOM.signinemail).sendKeys(faker.name().username() + "2054@gmail.com");
        driver.findElement(yourLogoPOM.createacc).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Create an account']")));
        sendKeysToElement(yourLogoPOM.cxfirstname, firstname);
        driver.findElement(yourLogoPOM.cxlastname).sendKeys(lastname);
        driver.findElement(yourLogoPOM.password).sendKeys(password);
        int day = faker.random().nextInt(1, 28);
        selectByValue(yourLogoPOM.dobdays, String.valueOf(day));
        int month = faker.random().nextInt(1, 12);
        selectByValue(yourLogoPOM.dobmonths, String.valueOf(month));
        int year = faker.random().nextInt(1950, 2015);
        selectByValue(yourLogoPOM.dobyears, String.valueOf(year));
        sendKeysToElement(yourLogoPOM.address, address);
        sendKeysToElement(yourLogoPOM.city, city);
        selectByVisibleText(yourLogoPOM.state, "New York");
        sendKeysToElement(yourLogoPOM.zipcode, String.valueOf(zipcode));
        sendKeysToElement(yourLogoPOM.mobilephone, String.valueOf(phonenum));
        click(yourLogoPOM.register);

        driver.get(yourLogoPOM.url);
        click(yourLogoPOM.Signin1);
        String userName = initializeProperties().getProperty("username");
        String passwords = initializeProperties().getProperty("password");
        driver.findElement(yourLogoPOM.loginemail).sendKeys(userName);
        driver.findElement(yourLogoPOM.password).sendKeys(password);
        click(yourLogoPOM.signin);
        click(yourLogoPOM.women);
        List<WebElement> womenCart = driver.findElements(yourLogoPOM.addinvisblecart);
        WebElement womenlastCart = womenCart.get(womenCart.size() - 1);
        javaScriptExecutorClick(womenlastCart);
        click(yourLogoPOM.continueshopping);
        String shoppingCart = driver.findElement(yourLogoPOM.getAddtocart).getText();
        int counter = 1;
        Assert.assertTrue(shoppingCart.contains(String.valueOf(counter++)));
        click(yourLogoPOM.tops);
        javaScriptExecutorClick(yourLogoPOM.smallsize);
        wait.until(ExpectedConditions.urlContains("size-s"));
        List<WebElement> topsCart = driver.findElements(yourLogoPOM.addinvisblecart);
        System.out.println(topsCart.size());
        for (int i = 0; i < topsCart.size(); i++) {
            javaScriptExecutorClick(topsCart.get(i));
            click(yourLogoPOM.continueshopping);
            String shoppingCart1 = driver.findElement(yourLogoPOM.getAddtocart).getText();
            int counter1 = 1;
            Assert.assertTrue(shoppingCart.contains(String.valueOf(counter1++)));
        }
        click(yourLogoPOM.getAddtocart);
        click(yourLogoPOM.proceedcheckout);
        click(yourLogoPOM.proceedcheckout1);
        click(yourLogoPOM.addressproceedcheckout);
        click(yourLogoPOM.termsandcondition);
        click(yourLogoPOM.shippingproceedcheckout);
        String totalProduct = driver.findElement(yourLogoPOM.totalproducct).getText();
        totalProduct = totalProduct.replace("$", "");
        String totalShipping = driver.findElement(yourLogoPOM.totalshipping).getText();
        totalShipping = totalShipping.replace("$", "");
        Double addtotal = Double.valueOf(totalProduct) + Double.valueOf(totalShipping);
        System.out.println(addtotal);
        String total = driver.findElement(yourLogoPOM.TOTAL).getText();
        System.out.println(total);
        Assert.assertTrue(total.contains(String.valueOf(addtotal)));
        click(yourLogoPOM.paymentbankwire);
        click(yourLogoPOM.confirmorder);
    }

    @AfterClass
    void wrapup() {
        driver.quit();
    }
}
