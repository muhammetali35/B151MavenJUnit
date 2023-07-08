package techproed.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    /*
    WEBTABLE;
    <table> tagı ile başlar
       <thead> başlıklar için bu tag ile devam eder
            <tr> başlılkların satırı
            <th> tablehead
               <td>  başlıktaki veriler
          <tbody> başlıklar altındaki verileri temsil eder
                <tr> table row(satır)
                  <td> table data (tablodaki veri)


     */
    @Test
    public void test01() {

        extentReport("Chrome","WebTable");
        extentTest=extentReports.createTest("WebTable","Test Raporu");

        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi.");

        //    Task 1 : Table1’i yazdırın
        WebElement table1 = driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("Tablo 1");
        System.out.println(table1.getText());
        extentTest.info("Tablo1 yazdırıldı");

        System.out.println("*****************************************");

        //    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir=driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("3.Satır verileri ");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3.Satır verileri yazıldı");

        System.out.println("*****************************************");

        //    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir=driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
                                        //last() --> istenilene göre son satır yada sutun bilgilerini verir.

        System.out.println("1.Tablo Son Satir Bilgileri : "+ sonSatir.getText());
        extentTest.info("Son satır verileri yazdırıldı.");

        System.out.println("*******************************");
        bekle(2);
        //    Task 4 : 5. Sütun verilerini yazdırın
        System.out.println("**********************************");
        WebElement besinciBaslik = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(besinciBaslik.getText());//-->5. sütun başlığı
        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));
        extentTest.info("5. sutun verileri yazdırıldı.");


        //    Task 5 : 3.Satırdaki 1. ve 2. sutun bilgilerini yazdırınız
        System.out.println("******************************************");
        List <WebElement> ucuncuSatir2 = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatir2.forEach(t-> System.out.print(t.getText()+"\t"));
        extentTest.info("3.Satırdaki 1. ve 2. sutun bilgileri yazdırıldı.");


        //    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        System.out.println();
            //WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));//fbach@yahoo.com
        System.out.println(printData(2,3));
        printData(2,3);
        extentTest.info("2.Satır 3. sutundaki veriler yazdırıldı.");

        //3.Satır 2. Sutun bilgisinin Jack olup olmadıpını doğrulayın
        String actualData = printData(3,2);
        String expectedData ="Jack";
        Assert.assertNotEquals(expectedData, actualData);
        extentTest.fail("3.satır 2. sutun bilgisinin Jason olduğu görüldü." );
        extentTest.info("Sayfa kapatıldı.");
        extentReports.flush();


    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        return satirSutun.getText();
    }


    //ÖDEV
    //C01_WebTables class'ı için aldığımız rapora gidelim
    //Not: driver.get("testOutput/extentReports/extentReport_09_56_26_26062023.html")
    //Başlığın Extent Report olduğunu test edelim
    //Rapor remasını dark yapalım
    //Dashboard bölümğne gidip tabloyu yazdırınız
    //Tester'ın isminiz olduğunu doğrulayın
    //Sayfayı kapatalım


    @Test
    public void test02() {


        //ÖDEV

        extentReport("Chrome","WebTable");
        extentTest=extentReports.createTest("WebTable","Test Raporu");

        Actions actions = new Actions(driver);

        //C01_WebTables class'ı için aldığımız rapora gidelim
        //Not: driver.get("testOutput/extentReports/extentReport_09_56_26_26062023.html")
        driver.get("C:\\Users\\FADİME YILMAZ\\Desktop\\SELENIUM\\B151MavenJUnitTekrarlar\\testOutput\\extentReports\\extentReport_11_35_29_27062023.html");
        extentTest.info("Sayfaya gidildi.");


        //Başlığın Extent Report olduğunu test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Extent Report";

        Assert.assertEquals(expectedTitle,expectedTitle);
        extentTest.info("Sayfa title'ı Extent Report oldugu tespit edildi.");


        bekle(2);
        //Rapor remasını dark yapalım
        driver.findElement(By.id("theme-selector")).click();
        bekle(2);
        extentTest.info("Sayfa arka planı dark yapıldı.");

        //Dashboard bölümğne gidip tabloyu yazdırınız
        driver.findElement(By.xpath("(//li)[2]")).click();
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        bekle(2);
        WebElement table1 = driver.findElement(By.xpath("(//table)[3]"));
        System.out.println("Tablo 1 : ");
        System.out.println(table1.getText());
        extentTest.info("Tablo 1 yazdırıldı.");

        bekle(2);

        System.out.println("***********************************************");
        //Tester'ın isminiz olduğunu doğrulayın
        WebElement testerName = driver.findElement(By.xpath("(//table)[3]//tr[3]//td[2]"));
        System.out.println("Tester ismi: "+ testerName.getText());
        extentTest.info("Tester isminin Muhammet Yılmaz olduğu yazdırıldı.");
        extentTest.info("Sayfa Kapatıldı.");
        extentReports.flush();


    }
}