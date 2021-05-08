package practice;

public class ParameterterminalTest {
    public static void main(String[] args) {
        int ch= Integer.parseInt((System.getProperty("chrome")));
      //  String a= System.getProperty("param");

        System.out.println(ch);
       // System.out.println(a);
    }
}
//mvn exec:java -Dexec.mainClass="ParameterterminalTest.Main" -Dchrome=2