package practice.abstractionConcept;

public class testBank {
    public static void main(String[] args) {
        bank b=new hdfc();
        hdfc h=new hdfc();

        h.credit();
        h.debit();
        b.credit();
        b.debit();

        System.out.println("Loan method");
        h.loan();
        b.loan();

        h.funds();
    }
}
