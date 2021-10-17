package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C02_SoftAssertion {
    // // amazon sayfasina gidin
    //    // url in amazon icerdigini test edin
    //    // title in amazon icerdigini test edin
    //    // java kelimesi aratin ve ilk listedeki ilk urunun java kelimesi icerdigini test edin
    //testleri softassertion ile yapin

    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }

    @Test
    public void test(){
        SoftAssert softAssert=new SoftAssert();
        driver.get("https://amazon.com/");
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"title amazon icermiyor");
        System.out.println("assertion failed oldugu halde bu satir calisir ");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        softAssert.assertTrue(ilkUrun.getText().contains("Java"),"ilk urun java icermiyor");
        softAssert.assertAll();
        System.out.println("assertion failed oldugu halde bu satir calisir ");
        //softassertionda assertalla kadar tum satirlar calisir
        // assertionlar pass olsa da olmasa da assertalla kadar tum satirlar calisir
        // eger testlerden bir tanesi bile failed ise assertAll den sonra execution stops
    }
}
