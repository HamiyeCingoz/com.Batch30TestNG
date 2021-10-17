package tests.day10;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Homework extends TestBase {
    @Test
    public void test(){
        //http://demo.guru99.com/test/drag_drop.html url'sine gidin
        //      BANKA butonunu BORÇ TARAFINDA bulunan Hesap bölümüne sürükleyip bırakın.
        //      SATIŞ butonunu KREDİ TARAFINDA bulunan Hesap bölümüne sürükleyip bırakın.
        //      BORÇ TARAFINDAKİ Tutar bölümüne 5000 butonunu sürükleyip bırakın
        //      İkinci 5000 düğmesini KREDİ TARAFINDAKİ Tutar bölümüne sürükleyip bırakın


        //Go to http://demo.guru99.com/test/drag_drop.html url
        driver.get("http://demo.guru99.com/test/drag_drop.html ");
        //     Drag and drop the BANK button to the Account section in DEBIT SIDE

        //     Drag and drop the SALES button to the Account section in CREDIT SIDE
        //     Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        //     Drag and drop the second 5000 button to the Amount section in CREDIT SIDE

    }
}
