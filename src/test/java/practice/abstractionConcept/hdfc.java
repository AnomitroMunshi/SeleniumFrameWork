package practice.abstractionConcept;

public class hdfc extends bank{

    public void debit(){
        System.out.println("from hdfc debit");
    }
    public void funds(){
        System.out.println("from hdfc funds");
    }
    @Override
    public void loan() {
        System.out.println("from hdfc loan");
    }
}
