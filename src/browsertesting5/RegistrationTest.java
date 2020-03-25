package browsertesting5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {
 private WebDriver driver;

    @Before
    public void openBrowser() {
        String baseUrl1 = "https://demo.nopcommerce.com/";
        //set the property
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //declare the driver
        driver = new ChromeDriver();
        //maximize window
        driver.manage().window().maximize();
        //add time for timeout using TimeUnit
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open url
        driver.get(baseUrl1);
    }
    @Test
    public void UserShouldLoginSucessfullyRegister() {
        WebElement register;
        register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        WebElement welcomemesg = driver.findElement(By.xpath("//div[@class='title']//strong[contains(text(),'Your Personal Details')]"));
        String expectedtest = "Your Personal Details";
        String actualText = welcomemesg.getText();
        Assert.assertEquals(expectedtest, actualText);
    }

    @Test
    public void VerfityUserSholdRegisterSucessfullyGender() throws InterruptedException {
        WebElement register;
        register = driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        Thread.sleep(3000);
        WebElement gender;
        gender = driver.findElement(By.xpath("//div[@class='gender']/span/input"));
        gender.click();

        WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstname.sendKeys("Ravikumar");
        //sending firstname to the field
        WebElement Secoundname = driver.findElement(By.xpath("//input[@id='LastName']"));
        Secoundname.sendKeys("Makwana");
        //sending last name to the field
        //  WebElement dateofbirt = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        //dateofbirt.findElement(17);
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }
}
