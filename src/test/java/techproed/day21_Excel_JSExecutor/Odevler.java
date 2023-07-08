package techproed.day21_Excel_JSExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Odevler extends TestBase {

    /*
 */

    @Test
    public void test01() throws IOException {

      //  ODEV1
        //  1.satirdaki 2.hucreye gidelim ve yazdiralim
        //  1.satirdaki 2.hucreyi bir string degiskene atayalim ve  yazdiralim
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String satir1sutun2 = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("Satır 1 sutun 2 :  "+satir1sutun2);

        //  2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String satir2sutun4 = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println("satir2sutun4 = " + satir2sutun4);
        Assert.assertEquals("Kabil", satir2sutun4);

      //  Satir sayisini bulalim
        System.out.println("Son Satir Sayisi  "+workbook.getSheet("Sayfa1").getLastRowNum());

        //  Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Satir Sayisi  "+workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());

        //  Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String,String> ulkeBaskent = new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sayfa1").getPhysicalNumberOfRows(); i++) {
            if(workbook.getSheet("Sayfa1").getRow(i) != null) {//--> Satırlar boş değilse
                String ulke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
                String baskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
                ulkeBaskent.put(ulke, baskent + "\n");
            }
        }
        System.out.println(ulkeBaskent);


    }

    @Test
    public void test02() throws IOException {

   // ODEV2
   // Yeni bir test method olusturalim writeExcelTest()
   // Adimlari takip ederek 1.satira kadar gidelim

        // Olusturdugumuz hucreye "Nufus" yazdiralim
        // 5.hucreye yeni bir cell olusturalim

        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        // 2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");


        // 10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");


        // 15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("540000");


        // Dosyayi kaydedelim
        // Dosyayi kapatalim
        FileOutputStream fos = new FileOutputStream("src/test/java/techproed/resources/ulkeler.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();


    }


}
