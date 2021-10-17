package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownLoad extends TestBase {
    @Test
    public  void test() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. Iki tane metod oluşturun : isExist() ve downloadTest()


        //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
    }
    @Test
    public void isExist(){
        String dosyaYolu=System.getProperty("user.home")+ "\\Downloads\\logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
    @Test
    public void downloadTest() throws InterruptedException {
        //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
        // - https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // - logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        Thread.sleep(5000);

    }
}
