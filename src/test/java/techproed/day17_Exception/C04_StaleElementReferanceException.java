package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C04_StaleElementReferanceException extends TestBase {
    /*
    StaleElementReferanceException:

    bir web sayfasındaki bir webelementin gecerliliginin kayboldugu durumlarda olusur.

    Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
    yeniden o elemente ulasmak istedigimizde StaleElementReferanceException hatasını alırız.

    Bunu handle edebilmek icin webelemente yeniden aynı locate'ı atamalıyız.
    (webelementin locate'ını hatırlatma gibi diyebiliriz.)


     */


    @Test
    public void StaleElementReferanceExceptionTest1() {


        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // sayfayı yenileyelim
        driver.navigate().refresh();


        // LMS LOGIN butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();


    }


    @Test
    public void StaleElementReferanceExceptionTest2() {


        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));


        // sayfayı yenileyelim
        driver.navigate().refresh();


        // LMS LOGIN butonuna tıklayalım

        login.click();  // StaleElementReferenceException


        /*
        LMS LOGIN webelementini locate ettikten sonra sayfayı yeniledigimiz icin LMS LOGIN webelementi eskidi(bayatladı).
        sanrasında bayatlayan webelement'e click yaptıgımız icin StaleElementReferenceException hatası aldık.

        Bu exception'ı handle edebilmek icin refresh yaptıktan sonra tekrar aynı lacate'ı webelemente atamamız gerekiyor.
         */

    }


    @Test
    public void StaleElementReferanceExceptionTest3() {


        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));


        // sayfayı yenileyelim
        driver.navigate().refresh();


        // LMS LOGIN butonuna tıklayalım
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();


    }

    //AKŞAMKİ DERS NOTLARI
        /*
        STALE_ELEMENT_REFERENCE_EXCEPTION
            Bir webelementin sayfayi refresh(yenileme) ya da back-forward yapma sonucunda eskimesi(bayatlamasi)
         durumunda bu exception'i aliriz. Yani driver sayfayi yeniden olustudugunda elementin locate'i ayni
         olmasina ragmen tekrar o elementin locate'ini almamizi ister. Almadigimiz takdirde locate'i eskimis olarak
         gorur ve staleElementReferenceException hatasi verir
         */
    @Test
    public void test01() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        driver.navigate().refresh();
      /*
        org.openqa.selenium.StaleElementReferenceException hatası aldık çünkü refresh yaptıktan sonra
        tekrar locate almadık. Dolayısıyla bu hatayı handle edebilmek için refresh yaptıktan sonra
        tekrar locate almalıyız.
 */
        aramaKutusu.sendKeys("qa", Keys.ENTER);//--> aramaKutusu eskidigi icin sendKeys() methodunu kullanamadi
        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
       /*
        Bu test methodunda test01 methodundaki staleelementreference hatasini nasil handle
        ettigimizi gosterdik
      */

        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        driver.navigate().refresh();
        driver.findElement(By.xpath("//*[@type='search']")).sendKeys("qa", Keys.ENTER);//--> aramaKutusu eskidigi icin sendKeys() methodunu kullanamadi
        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test03() {
        //techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        //arama kutusunda qa aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@type='search']"));
        aramaKutusu.sendKeys("developer",Keys.ENTER);

        driver.navigate().back();

        driver.navigate().forward();
        /*
        org.openqa.selenium.StaleElementReferenceException : back- forward sonrasinda da bu hatayi aldik
         */

        aramaKutusu.sendKeys("qa", Keys.ENTER);

        //sayfa basliginin qa icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));


    }

    @Test
    public void test04() {

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //arama kutusunda iphone aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone",Keys.ENTER);

        //çıkan sonuclardan ilk beşine tıklayıp,her ürünün başlığını konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2//a"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(2);
            System.out.println((i+1)+". Urunun Title: "+driver.getTitle());

            driver.navigate().back();//-->org.openqa.selenium.StaleElementReferenceException:
            bekle(2);
            if (i==4){
                break;
            }
            urunler = driver.findElements(By.xpath("//h2//a"));//-->S.E.R.E. hatasını handle ettik

        }

    }
}