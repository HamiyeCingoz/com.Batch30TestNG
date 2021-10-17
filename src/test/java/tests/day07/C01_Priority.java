package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class C01_Priority {
    //3 test methodu olusturun
    // 1. amazon ana sayfasina
    //2. techproeducation a
    //3. facebookk ana sayfasina gitsin
    // ve sayfa title larini yazdirsin
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test(priority = 2)
    public void amazonTest() {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
    }

    @Test(priority = 1)
    public void techproTest() {
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }

    @Test
    public void facebook() {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
    }
    @AfterMethod
    public  void tearDown(){
        driver.close();
    }
}