package techproed.day07_MavenJUnit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    /*
       Notasyonlara sahip methodlar oluşturabilmek için mause+sağ tık+ gererate(alt+insert) yaparak
       after methodu için teardown'u seçeriz.
       before method'u için setup'ı seçeriz.
       test method'u için test'i seçeriz.

        JUnit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.
        Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve
        sayisal olarak belirtmemiz gerekir
     */
    @After
    public void tearDown() {
        System.out.println("Her test method'undan sonra birkez çalışır.");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test method'undan önce birkez çalışır.'");
    }

    @Test
    public void test1() {
        System.out.println("test1 methodu çalıştı.");
    }

    @Test
    public void test3() {
        System.out.println("test3 methodu çalıştı.");
    }

    @Test
    public void test2() {
        System.out.println("test2 methodu çalıştı.");
    }




}
