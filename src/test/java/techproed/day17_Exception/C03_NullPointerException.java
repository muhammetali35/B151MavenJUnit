package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class C03_NullPointerException  {
    /*
    NullPointerException:

    degisken yada obje olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde
    NullPointerException hatasi aliriz.

     */

    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    String isim;


    @Test
    public void NullPointerExceptionTest01() {
        //driver = new ChromeDriver(); ataması yapmadığımız için NullPointerException hatası aldık
        driver.get("https://amazon.com");

        /*
        Exception ismini yazdığı yer
     java.lang.NullPointerException: Cannot invoke "org.openqa.selenium.WebDriver.get(String)" because "this.driver" is null
         */


    }

    @Test
    public void NullPointerExceptionTest02() {
        //faker = new Faker(); ataması yapmadığımız için NullPointerException hatası aldık
        System.out.println(faker.name().firstName());

    }

    @Test
    public void NullPointerExceptionTest03() {
        //actions = new Actions(); ataması yapmadığımız için NullPointerException hatası aldık
        actions.doubleClick().perform();


    }
    @Test
    public void NullPointerExceptionTest04() {
        //sayı = 6; sayı değişkenine atama yapmadığımız için NullPointerException hatası aldık
        System.out.println(sayi+5);

    }

    @Test
    public void NullPointerExceptionTest05() {
        // isim = "muhammet"; isim değişkenine atama yapmadığımız için NullPointerException hatası aldık
        System.out.println(isim.charAt(0));

    }


}
