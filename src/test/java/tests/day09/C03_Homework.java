package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C03_Homework extends TestBase {
    @Test
    public  void test(){
        ///Bir class olusturun: IframeTest02
        //    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //    //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeSayisi=driver.findElements(By.tagName("iframe"));
        System.out.println("iframe sayisi : "+iframeSayisi.size());
        //    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(0); // id olmadigi icin index kullandim
        driver.findElement(By.xpath("//div[@class='ytp-impression-link-logo']")).click();
        //    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-
        //    //project.html) tıklayınız
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();



    }

}
