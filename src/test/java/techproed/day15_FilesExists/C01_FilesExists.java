package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {


    /*
    Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
için;
    Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
assing ederiz.

NOT:
    Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
    yolunu almak istediğimiz dosyanun üzerine gelip shift+sayKlik tusuna basarak yol olarak kopyala
    seçeneği ile dosya yolunu kopyalayabiliriz.


 */

        String dosyaYolu = "C:/Users/FADİME YILMAZ/Desktop/Yeni Metin Belgesi.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void test02() {

        String dosyaYolu2="C:/Users/FADİME YILMAZ/Desktop/boş.txt";
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu2)));//Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }

    @Test
    public void test03() throws InterruptedException {

        /*
Bir server'da farklı işletim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
daha dinamik olması açısından System.getProperty("as.name")  bu şekilde işletim sistemi alır
her işletim sisteminin kullanıcı yolu farklı olacağından System.getProperty("user.home")
bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
atayarak herseferinde farklı yolları almayla uğraşmamış oluruz.Dosya diyelim ki masa ustunde ve her isletim
 sisteminde bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz
   */
        //--> Dosya yolumuz : //
        String farkliYol="";
        String isletimSistemiAdi=System.getProperty("os.name");//İşletim sistemimizin adını verir.
        System.out.println(isletimSistemiAdi);//Windows 11
        System.out.println(System.getProperty("user.home"));//Bilgisayarımızdaki kullanıcı yolunu verir.

        if(isletimSistemiAdi.contains("Win")){
            farkliYol=System.getProperty("user.home");//Windows 11--> C:\Users\FADİME YILMAZ
        } else if (isletimSistemiAdi.contains("mac")) {
            farkliYol="/Users/aycapolatkamali";// Mac işletim yolu
        }

        String ortakYol="/Desktop/Yeni Metin Belgesi.txt";
        String dosyaYolu=farkliYol+ortakYol;
        System.out.println(dosyaYolu);
       Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu));//Bu şekilde belirtilmiş olduğumuz dosyayı sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadı");
        }

        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//Sildiğimiz için assertFalse kullandık

        Thread.sleep(3000);
        //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
        try {
            Files.createFile(Paths.get(dosyaYolu));//Belirtmiş olduğumuz dosyayı oluşturduk
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

    @Test
    public void test04() {
        /*
        Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığının Files.exists() methoduyla test etmiştik.
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */
        String dosyaYolu="C:/Users/FADİME YILMAZ/Desktop/Yeni Metin Belgesi.txt";
        File file = new File(dosyaYolu);
        System.out.println(new File(dosyaYolu).exists());
        Assert.assertTrue(file.exists());
        //file.delete();
    }

}







