package practice;

public class StringStringBuffer {
    public static void main(String[] args) {
        String s=new String("Durga");
        s.concat("software");
        System.out.println(s);


        StringBuffer sb=new StringBuffer("Durge");
        sb.append("sofwtare");
        System.out.println(sb);
    }
}
