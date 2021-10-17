package tests.day10;

public class Not {
    //●   TestBase, testlerden önce ve sonra tekrar tekrar kullandığımız kodları içermektedir.
    //●  İçerisindeki metodları kullanabilmemiz için extend yapıyoruz. Bu sayede test class' ımızda sadece test case'ler bulunmaktadır.
    //●  Utilities package'da TestBase'i oluşturuyoruz.
    //    ○  setUp method
    //    ○  reports (Raporlar)
    //    ○  tearDown method
    //●  TestBase class'i abstract yapabiliriz (Olmasa da olabilir) , extends yaparak kullanabiliriz. Ve bu class'da object create edemeyiz.
    //●   olusturdugumuz driver in farklı package lerden kullanabilmek için PROTECTED yapariz
    //
    //Tabs- Sekmeler
    //Birden çok pencere arasında geçiş yapma( Switch).
    //Bazen bir butona tıkladığımızda, başka bir sekmede(tab) yeni bir pencere açılır.
    //
    //Birden fazla pencereyle uğraşırken driver'ı pencereler arasında değiştirmemiz gerekir.
    //
    //Selenium WebDriver, WebDriver objesi başlatıldığında her pencereye bir alfanumerik kimlik
    //atar.Bu benzersiz(unique) alfanumerik kimliğe pencere tanıtıcısı(window handle ) denir. Selenium, birkaç
    //pencere arasında kontrolü değiştirmek için bu benzersiz kimliği kullanır
    //
    //Tabs(Sekmeler)
    //●switchTo() => pencereler arasında geçiş yapma(switch) metodu
    //●getWindowHandle() => WebDriver'ın o anda kontrol ettiği sayfanın window handle'ini almak için kullanılır. String return eder.
    //●getWindowHandles() =>Açık olan tüm pencerelerin window handle' lari ni almak için kullanılır. Set return eder.
    //●Syntax: driver.switchTo().window(driver.getWindowHandle);
    //https://the internet.herokuapp.com/iframe
    //
    //Actions Class
    //Fare ve klavye eylemlerini gerçekleştirmek için Actions class'ı kullanmamız gerekir.
    //Actions Class birçok kullanışlı fare ve klavye işlevine sahiptir
    //Çift tıklama (double click), sürükleme ve bırakma(drag and drop), fareyi hareket
    //ettirme (mouse actions) gibi karmaşık fare eylemleri icin v eya Keyword ile
    //yapabilecegimiz pageUp,pageDown,shift,arrowDown gibi islemleri Actions
    //classindan object ureterek yapariz
    //
    //1.Adım: Actions class'ta bir object oluşturulur.
    //Actions actions = new Actions(driver);
    //2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
    //WebElement element = driver.findElement(By.id("ID");
    //3.Adim : Ardından bu webelement üzerinde action gerçekleştirilir. Örneğin sağ tıklamak için
    //actions.contextClick(element)
    //perform() :En sonda action'ı gerçekleştirmek için kullanılır
    //
    //Mouse  Aksiyonlari
    //■ doubleClick (): Öğeye çift tıklama yapar
    //■ clickAndHold (): Fareyi serbest bırakmadan uzun tıklama yapar
    //■ dragAndDrop (): Öğeyi bir noktadan diğerine sürükler ve bırakır
    //■ moveToElement (): Fare işaretçisini öğenin ortasına kaydırır
    //■ contextClick (): Fare üzerinde sağ tıklama yapar
    //
    //Keyboard Base Actions
    //Klavye Aksiyonlari
    //Klavye aksiyonlari ile klavyedeki tuslari control edebiliriz. Bunun icin 3 tane aksiyon
    //kullaniriz.
    //■ sendKeys (): Öğeye bir dizi anahtar gönderir
    //■ keyDown (): Klavyede tuşa basma işlemi gerçekleştirir
    //■ keyUp (): Klavyede tuşu serbest bırakma işlemi gerçekleştirir
}
