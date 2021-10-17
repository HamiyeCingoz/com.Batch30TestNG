package tests.day09;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_TestBaseIlkTest extends TestBase {
    @Test
    public void test(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getTitle());
    }
}
