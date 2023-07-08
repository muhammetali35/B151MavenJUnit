package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C05_StaleElementReferanceException extends TestBase {

    @Test
    public void test01() {


        driver.get("http://amazon.com");


        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone"+ Keys.ENTER);


        List<WebElement> iphoneUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (int i = 0 ; i<iphoneUrunleri.size() ; i++) {

            //iphoneUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

            iphoneUrunleri.get(i).click();

            System.out.println(i+ ".urun title : "+driver.getTitle());
            driver.navigate().back();

            if(i==4){
                break;
            }


        }

    }
}
