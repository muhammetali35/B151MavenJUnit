package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {

    @Test
    public void test01() {

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");

        bekle(2);

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklam

        bekle(4);

        // Arama kutusuna "QA" yazıp aratın

       WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));

        aramaKutusu.sendKeys("QA" + Keys.ENTER);

        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].value='QA'",aramaKutusu);

         sendKeysJS(aramaKutusu,"QA");


        /*

        2.Yol

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);

*/

        sendAttributeJS(aramaKutusu,"QA");

        //arama kutusunun HTML kodlari arasinda value attribute vardir. Bu HTML kodlarinin son kelimesidir.
        //Value degerine QA yazdirmis oluyoruz.Bu kod attribute kalici deger atamaz.
        //Arguments[0] ise origin'i temsil etmektedir.


    }
}
