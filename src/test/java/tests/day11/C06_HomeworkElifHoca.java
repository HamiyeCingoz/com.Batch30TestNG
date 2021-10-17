package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_HomeworkElifHoca extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //url'ye gidin: http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");
        //    "Tamam ile Uyarı"yı tıklayın ve 'bir uyarı kutusu görüntülemek için düğmeyi tıklayın:'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        //    Uyarıyı kabul edin (Ben bir uyarı kutusuyum!) ve konsolda uyarı yazdırın
       driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        //    "Tamam ve İptal ile Uyarı" yı tıklayın ve 'bir onay kutusu görüntülemek için düğmeyi tıklayın'
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //    Uyarıyı iptal et (Bir Düğmeye Basın!)
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.switchTo().alert().dismiss();
        //    "Metin Kutusuyla Uyarı"yı tıklayın ve 'istem kutusunu göstermek için düğmeyi tıklayın'
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        Thread.sleep(2000);
        //    ve ardından sendKeys 'TechProEducation' (Lütfen adınızı girin)
        driver.switchTo().alert().sendKeys("TechProEducation");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //    sonunda bu mesajı konsola yazdırın "Merhaba TechproEducation Bugün nasılsınız"
        WebElement message=driver.findElement(By.id("demo1"));
        System.out.println(message.getText());


    }
}
