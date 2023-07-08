package techproed.day17_Exception;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void NoSuchElementException() {

          /*
        NoSuchElementException:
         Sayfada bulunmayan bir elemenente erisim saglanmaya calisildiginde
        NoSuchElementException hatasi aliriz.
         */

         /*
         NoSuchElementException:
    Yanlis locator
    Popup, yeni pencere, iframe,…
    Sayfa dolmada problemler ve yavaslamalar
    Sakli olan elementle

                Solution:
    Locatorin dogrulugunu tekrar kontrol et
    Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
    Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada
    fluent wait kullaniriz
         */




            // techproeducation sayfasına gidiniz
            driver.get("https://techproeducation.com");
            bekle(3);


            // reklamı kapatınız
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();



            // searchBox'a java yazıp aratınız
            driver.findElement(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")).sendKeys("Java" + Keys.ENTER);

    //at techproed.day_17_Exception.C01_NosSuchElementException.NoSuchElementException(C01_NosSuchElementException.java:19)
        //HATALI KODU AŞAĞIDAKİ TERMİNALDE BU SATIRDAN GÖRÜYORUZ


        }

}