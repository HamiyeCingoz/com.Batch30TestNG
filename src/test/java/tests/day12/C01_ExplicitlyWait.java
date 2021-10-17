package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_ExplicitlyWait extends TestBase {
    @Test
    public void implicitlyWaitTest(){

        //1. Bir class olusturun : C01_WaitTest
        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //  Iki metod icin de asagidaki adimlari test edin.
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        SoftAssert softAssert=new SoftAssert();
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed());

        softAssert.assertAll();
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());

    }

    @Test
    public void explicitlyWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebDriverWait wait=new WebDriverWait(driver,20);
        //expilcitly waiti istersek locate islemi ile birlikte tek satirda yapabiliriz
        // veya once locate edip uygun method kullanarak beklemeyi yapabiliriz
        //ancak bu test icin once webelementi olusturmak anlamsiz olur
        // cunku biz wait islemini zaten o webelement olusssun diye yapiyoruz
        //wait olmadan o element olmaz o element olmadanda sectigimiz method calismaz

        WebElement yaziLocateIleBirlukte=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(yaziLocateIleBirlukte.isDisplayed());

        //WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));
       // wait.until(ExpectedConditions.visibilityOf(sonucYazisi));
        //Assert.assertTrue(sonucYazisi.isDisplayed());

        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        WebElement itsBackLocateIle=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

    }
}
