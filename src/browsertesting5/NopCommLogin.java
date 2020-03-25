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

public class NopCommLogin {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        String baseUrl = "https://demo.nopcommerce.com/";
        //set the property
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //declare the driver
        driver = new ChromeDriver();
        //maximize window
        driver.manage().window().maximize();
        //add time for timeout using TimeUnit
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open url
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPage() {
        WebElement loginlink;
        loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();
        WebElement welcomeText = driver.findElement(By.linkText("Log in"));
        String expectedText = "Welcome, Please Sign In!";
        String actualText = welcomeText.getText();
        Assert.assertEquals(expectedText, actualText);

        WebElement emailField = driver.findElement(By.xpath("//input[@id='Email']"));
        emailField.sendKeys("ravee.123@gmail.com");

        WebElement passWordField = driver.findElement(By.id("Password"));
        passWordField.sendKeys("bac133");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginBtn.click();

    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

}
