package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import techproed.utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    /*
    TimeOutException:

    sayfada aradıgımız elementi wait ile belirttigimiz max. sürede
    bulamadıgı durumda TimeOutException hatası alırız.

 */

     /*
                    TimeOutException:
        Explicit wait kullanildiginda, ve element bulunamadiginda
        alinir.
        Explicit wait & yanlis locator-> timeout
        Explicit wait & doğru locator & sure yeterli degil -> timeout
        Explicit wait & dogru locator & sure yeterli & iframe var ->
        time out


                    Solution:
        -Sureyi arttirmak
        -Farkli explicit kullanmak: wait visibilityOfElementLocated
        YERINE presenceOfElementLocated. Yada javascript executor
        da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
        -Locatori tekrar kontrol etmek
        -Frameworkunde hazir reusable method lar var Bu durumda
        timeoutexception aldigimda hızlıca o metotlar yardımıyla
        problemi cozebiliyoruz

         */


    @Test
    public void TimeOutException() {
        //techpro sayfasına gidelim


        driver.get("https://techproeducation.com");
        bekle(2);


        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);


        //searchBox görünür oluncaya kadar bekleyiniz
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));

        /*
        at techproed.day_17_Exception.C02_TimeOutException.TimeOutException(C02_TimeOutException.java:39)
                HATALI KOD SATIRINI  TERMİNALDE BU SATIRDAN GÖRÜYORUZ
         */


    }

    @Test
    public void TimeOutException02() {
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorldYazisi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(helloWorldYazisi));

        Assert.assertTrue(helloWorldYazisi.isDisplayed());


        //HATALI KOD
        //Duration.ofSeconds(1); ortalama 6 sn geciyor ancak 1 sn yazdik. Hata verecektir.


        /*
        Start butonuna bastiktan sonra neredeyse 6sn sonra yazi görünür. Biz burda o süreden daha az süre belirleiz
 ve bilerek hata aliriz. !!! TIMEOUTEXCEPTION

 Gercekte Hello World! yazisi ortalama 6sn sonra gözüküyor TimeOutException alabilmek icin Explicit Wait'e
 max. bekleme süresini 3 sn verdik. Bu sebeple; TimeOutException hatasi almis olduk.
        */


    }
            //Akşamki ders notları
    /*
     TIME_OUT_EXCEPTION
          Expilicit wait kullanirken yanlis method yada yanlis max. bekleme suresi gibi durumlarda
      org.openqa.selenium.TimeoutException hatasi aliriz
      */
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));

         /*
          org.openqa.selenium.TimeoutException: normalde helloWorldText webelemnti 5-6 saniye civarinda
          etkilesime girerken biz max. bekleme suresini 2 saniye verdigimiz icin bu hatayi aldik. Dolayisiyla
          bu exception'i handle edebilmek icin dogru sureyi ve dogru methodu kullanmamiz gerekir.
         */

        Assert.assertEquals("Hello World!",helloWorldText.getText());

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlisLocate")));
        /*
        Yukaridaki ornekte max. sureyi dogru vermemize ragmen yanlis locate aldigimiz icin yine
        org.openqa.selenium.TimeoutException hatasi aliriz. Dolayısıyla bu exception'ı handle edebilmek için
        locate'i doğru almalıyız
         */

    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan buttona tıklayalım
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='ch']")));

        /*
        org.openqa.selenium.TimeoutException: Gorunur olan bir webelementi gorunur olmayana kadar bekleme methodunu kullandigimiz
        icin TimeoutException hatasi aldik.
         */

        //checkBox'in secili oldugunu dogrulayalim
        WebElement checkBox= driver.findElement(By.id("//*[@id='ch']"));
        Assert.assertTrue(checkBox.isSelected());


    }
}