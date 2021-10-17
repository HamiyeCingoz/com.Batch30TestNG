package tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C03_Homework extends TestBase {
    @Test
    public void test() {


        //● Bir class oluşturun: C3_DropDownAmazon
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");

        //Arama kutusunun yanindaki kategori menusundeki kategori
        //sayisinin 45 oldugunu test edin
      WebElement dropDown=driver.findElement(By.xpath("//select[@name='url']"));
        Select select=new Select(dropDown);
        List<WebElement> kategorilerMenusu=select.getOptions();
        Assert.assertEquals(kategorilerMenusu.size(),45);
        System.out.println(kategorilerMenusu.size());
        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        //2. Arama kutusuna Java yazin ve aratin
        //3. Bulunan sonuc sayisini yazdirin
        //4. Sonucun Java kelimesini icerdigini test edin

    }
}