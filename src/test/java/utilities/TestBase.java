package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    // abstrac yaparak bu class tan obje uretilmesini onune geceriz

  protected   WebDriver driver;
  //biz testbase classi sadece extends ile inherit ederek kullanacagiz
    // dolayisiyle olusturdugumuz driver variable i icin protected access modifieri seciyoruz
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();



    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
