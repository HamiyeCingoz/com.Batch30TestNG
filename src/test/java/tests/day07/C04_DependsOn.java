package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C04_DependsOn {
    // Bir class oluşturun: DependsOnTest
    //● https://www.amazon.com/ adresine gidin.
    //    1. Test : Amazon ana sayfaya gittiginizi test edin
    //    2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin                          arama yapin ve aramanizin gerceklestigini Test edin
    //    3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin    $16.83 oldugunu test edin

static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }
    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com/","url amazon degil");
    }
    // testleri birbirine bagladigimizda
    //1- 2. methodu tek basina calistirmak istesek bile otomatik olarak once 1. method calisir
    //1- 1. method faild olursa 2. method ignore edilir yani calistirilmaz
    @Test
    public void test2(){
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Nutella"),"nutella icin arama yapilamiyor");
    }
    // eger 3 test veya daha fazlasi birbirine dependson ile baglandiysa
    // 3. yu calistirmak istedigimizde zincir reaksiyon calisip 1. ye gitmez
    @Test
    public void test3(){
       driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
WebElement fiyat= driver.findElement(By.xpath("//*[@class='a-size-base a-color-price']"));
        System.out.println(fiyat.getText());
        Assert.assertEquals(fiyat.getText(),"$16.83");
    }
    @AfterClass
    public  void tearDown(){
        //driver.close();
    }

}
