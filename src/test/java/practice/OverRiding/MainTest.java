package practice.OverRiding;

public class MainTest {
    public static void main(String[] args) {
        test t=new test();
        child c=new child();
        test test2=new child();
        //child c2= (child) new test();

        System.out.println("***** test t=new test() ******");
        t.m1();
        t.m2();
        t.m3();

        System.out.println("***** child c=new child() ******");

        c.m1();
        c.m2();
        c.m3();
        c.m4();

        System.out.println("***** test test2=new child() ******");
        test2.m1();
        test2.m2();
        test2.m3();


        /*System.out.println("***** child c2= (child) new test() ******");
        c2.m1();
        c2.m2();
        c2.m3();
        c2.m4();*/  //classCastException

    }
}
