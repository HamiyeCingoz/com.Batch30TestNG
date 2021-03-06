package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_IframeTest {
    // Her Allert JS Allert degildir
// Allert ciktiginda sag click yapip incele diyebiliyorsak bu bir HTML alert'dir
// HTML alert'ler siradan webelement'ler olarak locate edilip kullanilabilir
// Sag click yapamiyorsak alert bir JS Allert'dur ve switchTo() kullanilarak handle edilebilir
    //● Bir class olusturun: C02_IframeTest
    //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //  ● Bir metod olusturun: iframeTest
    // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
    // ○ Text Box’a “Merhaba Dunya!” yazin.
    // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void test() throws InterruptedException {
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda     yazdirin.
        WebElement baslikYazielemneti= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikYazielemneti.isEnabled(),"baslik yazisi erisilebilir degil");
        System.out.println(baslikYazielemneti.getText());
        //      ○ Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");
        WebElement yaziKutusu= driver.findElement(By.xpath("//*[@id='tinymce']"));
        yaziKutusu.clear();
        yaziKutusu.sendKeys("Merhaba Dunya");
// bir iframe e gecis yaptiktan sonra yeniden ana sayfa ile ilgili islem yapmak isterseniz
        // gecis yaptigimiz iframe eden geri donmleiyiz

        driver.switchTo().defaultContent();
        WebElement elementalLinki=driver.findElement(By.linkText("Elemental Selenium"));
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(elementalLinki.isDisplayed());
        System.out.println(elementalLinki.getText());
        elementalLinki.click();
Thread.sleep(5000);
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }
}