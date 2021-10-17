package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {
    //Bir class oluşturun: DropDown
    //● https://the-internet.herokuapp.com/dropdown adresine gidin.
    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    4.Tüm dropdown değerleri(value) yazdırın
    //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
WebDriver driver;
    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Thread.sleep(2000);
        // 1. adim dropdown i locate et
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        // 2. adim select classini kullanarak bir obje olustur ve parametre olarak locate ettigimiz
        // webelementi yaz
        Select select=new Select(dropDown);
        // istedigin option u select objesi kullanarak sec

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

       List<WebElement> tumOpsiyonlar = select.getOptions();
        System.out.println("tum opsiyonlar listesi ");
        for (WebElement each:tumOpsiyonlar
             ) {
            System.out.println(each.getText());

        }
        //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        System.out.println(tumOpsiyonlar.size());
        if (tumOpsiyonlar.size()==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }

}
