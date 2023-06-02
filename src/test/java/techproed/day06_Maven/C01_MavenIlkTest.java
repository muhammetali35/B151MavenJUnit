package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

        //“Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);


        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi= driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String [] sonusSayisi=sonucYazisi.getText().split(" ");
        System.out.println("Sonuc sayısı "+sonusSayisi[2]);

        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//h2//a)[1]")).click();


        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari = driver.findElements(By.xpath("//h1 | //h2"));//uzamasın diye gerisini almadık h3 h4 h5 h6
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));

        //Sayfayı kapatalım
        driver.close();



    }
}