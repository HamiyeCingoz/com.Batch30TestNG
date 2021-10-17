package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class C01_Allerts {

    //● Bir class olusturun: C01_Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //        “You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //        “successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


    }
    @Test
    public void accepterAlert(){
driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
driver.switchTo().alert().accept();
        WebElement resultYaziElementi=driver.findElement(By.id("result"));
        String expectedResult="You successfully clicked an alert";
        String actuelResult=resultYaziElementi.getText();
        assertEquals(actuelResult,expectedResult,"sonuc yazisi istenen ile ayni degil");


    }
    @Test
    public void dismissAlert(){
//● Bir metod olusturun: dismissAlert
        //        ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //        “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String istenmeyenKelime="successfuly";
        WebElement resultYaziElementi=driver.findElement(By.id("result"));
        String actuelResult=resultYaziElementi.getText();
        assertFalse(actuelResult.contains(istenmeyenKelime));


    }
    @Test
    public void sendKeysAlert(){
//● Bir metod olusturun: sendKeysAlert
        //        ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        String isim="hamiye";
        driver.switchTo().alert().sendKeys(isim);
        driver.switchTo().alert().accept();
        WebElement resultYaziElementi=driver.findElement(By.id("result"));
        String actuelResult=resultYaziElementi.getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actuelResult.contains(isim));
        softAssert.assertAll();

    }

}
