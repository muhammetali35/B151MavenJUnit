package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodları static olmak zorundadır.
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her class'tan önce BeforeClass Method'u birkez çalışır.");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'tan sonra AfterClass Method'u birkez çalışır.");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her method'tan önce Before Method'u birkez çalışır.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method'tan sonra After Method'u birkez çalışır.");

    }


    @Test
    public void test01() {
    }
    @Test
    public void test02() {
    }
    @Test
    public void test03() {
    }


}
