package techproed.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3.Login alanine "username" yazdirin
        //4.Password alanine "password" yazdirin
        //5.Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("input#user_login"));
        Thread.sleep(2000);
        login.sendKeys("username", Keys.TAB,"password", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();

        //6.Online Baking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()=.])[11]")).click();
        driver.findElement(By.xpath("((//h4)[4]//span")).click();
            //driver.findElement(By.id("pay_bills_link")).click();
        //-->(//*[text()=.])[11] Bu şekilde text ile aldığımız bir xpath'de text değişse bile biz o webelementi handle edebiliriz.



        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin0
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("1000",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);

            //Keys.TAB ile yaptık o yüzden yoruma aldım
        //8.tarih kismina "2020-09-10" yazdirin
            //driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
            //driver.findElement(By.id("pay_saved_payees")).click();

        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement actualText= driver.findElement(By.xpath("(//span)[1]"));
            //WebElement actualText= driver.findElement(By.id("alert_content"));
        System.out.println(actualText.getText());
        String expextedText = "The payment was successfully submitted.";
        if (actualText.getText().equals(expextedText)){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        if (actualText.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");


        Thread.sleep(2000);
        driver.close();

    }
}
