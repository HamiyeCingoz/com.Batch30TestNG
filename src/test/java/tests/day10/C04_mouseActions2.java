package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_mouseActions2 extends TestBase {
    @Test
    public  void
    test(){
        //Yeni bir class olusturalim: D14_MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        driver.get("https://demoqa.com/droppable");
        Actions actions=new Actions(driver);
        WebElement dragElementi=driver.findElement(By.id("draggable"));
        WebElement dropAlani=dragElementi.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragElementi,dropAlani).perform();
        WebElement droppedYazisi=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actuelDroppedYazisi=droppedYazisi.getText();
        String expectedDroppedYazisi="Dropped!";
        Assert.assertEquals(actuelDroppedYazisi,expectedDroppedYazisi);
    }
}
