package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class task03forJunit {
    /*
     -Amazon sayfasına gidelim
 -Arama Kutusundaki Dropdown menuyu yazdıralım
 -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
             başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
             Not: Select Class'ı kullanalım

      */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com/");

    }
    WebElement ddm;
    Select select;


    @Test
    public void amazon() throws InterruptedException {
        ddm =driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> secenekler=select.getOptions();
        secenekler.forEach(t-> System.out.println(t.getText()));

        for (int i = 0; i <6 ; i++) {
            ddm =driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
            select=new Select(ddm);
            select.selectByIndex(i);

            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();
        }

    }
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}
