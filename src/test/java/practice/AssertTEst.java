package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTEst {
    SoftAssert sa=new SoftAssert();

    @Test
    public void test1(){
        System.out.println("hi");
       // Assert.assertEquals(true,false);
        sa.assertEquals(true,false);
        System.out.println("hello");
        System.out.println("ok");
        sa.assertEquals(true,false);

        System.out.println("after soft assert");
        sa.assertAll();
    }
}
