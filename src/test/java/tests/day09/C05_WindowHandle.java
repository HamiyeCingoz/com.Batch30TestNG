package tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C05_WindowHandle extends TestBase {
    @Test
    public void test()
    {
        //● Tests package’inda yeni bir class olusturun: C04_WindowHandle
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actuelYazi=driver.findElement(By.tagName("h3")).getText();
        String expectecYazi="Opening a new window";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actuelYazi,expectecYazi);
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actuelTitle=driver.getTitle();
        String expectedTitle="The Internet";
        softAssert.assertEquals(actuelTitle,expectedTitle);
        softAssert.assertAll();
        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window("");
        String actuelYeniTitle=driver.getTitle();
        String expectedYeniTitle="New Window";
        softAssert.assertEquals(actuelYeniTitle,expectedYeniTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    }}
