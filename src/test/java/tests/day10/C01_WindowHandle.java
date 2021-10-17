package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {
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
        System.out.println("ilk sayfanin handle degeri : "+driver.getWindowHandle());
        // windov handle ederken ilk adim 1 sayfa acikken o sayfanin handle degerini alip bir stringe atamak

        String ilkSayfaHandle= driver.getWindowHandle();

        //● Click Here butonuna basın.
        // bu satirda ikinci window acildi
        driver.findElement(By.linkText("Click Here")).click();
//2. adim iki sayfa acildiginda her iki sayfanin handle degerlerini koymak icin bir set olusturup getWindowhandles methodu ile
        // bu degerleri elde etmek
        Set<String> tumWindowHanlelari = driver.getWindowHandles();
        System.out.println("tum handle ler : "+tumWindowHanlelari);
            // 3. adim set icerisinde 1. sayfanin handle degerine esit olmayana
            // handle degerini bulup bir string degiskene atamak
        String ikinciWindowHandle="";
        for (String each:tumWindowHanlelari
             ) {
            if(!each.equals(ilkSayfaHandle)){
                ikinciWindowHandle=each;

            }


        }
        // bu satira geldigimizde elimizde ikinci sayfanin handle degeri var
        System.out.println("ikinci sayfa handle degeri : "+ ikinciWindowHandle);
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowHandle);
        // switchTo ile window degistireceksek gidecegimiz windowun window handle degerine ihtiyacimiz var
        String actuelYeniTitle=driver.getTitle();
        String expectedYeniTitle="New Window";
        softAssert.assertEquals(actuelYeniTitle,expectedYeniTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement yeniSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYaziYeniSayfa="New Window";
        String actuelSayfaYazisiYeniYazi=yeniSayfaYaziElementi.getText();
        softAssert.assertEquals(actuelSayfaYazisiYeniYazi,expectedYaziYeniSayfa);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
driver.switchTo().window(ilkSayfaHandle);
       actuelTitle=driver.getTitle();

        softAssert.assertEquals(actuelTitle,expectedTitle);
        softAssert.assertAll();
    }}



