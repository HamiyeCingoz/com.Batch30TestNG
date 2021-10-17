package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_Homework extends TestBase {
    @Test
    public void test() {
        //"http://webdriveruniversity.com/Actions" sayfasina gidin
         driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hover=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        actions.moveToElement(hover).perform();
        //3- Link 1" e tiklayin
        WebElement link1=driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.click(link1).perform();
        //4- Popup mesajini yazdirin
        String mesaj=driver.switchTo().alert().getText();
        System.out.println(mesaj);


        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHold).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement wellDoneMesaj=driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']"));
        System.out.println(wellDoneMesaj.getText());

        //8- “Double click me" butonunu cift tiklayin
        WebElement clickMeDouble=driver.findElement(By.tagName("h2"));
        actions.doubleClick(clickMeDouble).perform();
    }
}
