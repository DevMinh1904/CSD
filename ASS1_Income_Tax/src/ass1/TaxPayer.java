package ass1;

public class TaxPayer {

    String code;
    String name;
    double income;
    double deduction;
    double tax;

    public TaxPayer() {
    }

    
    public TaxPayer(String code, String name, double income, double deduction, double tax) {
        this.code = code;
        this.name = name;
        this.income = income;
        this.deduction = deduction;
        this.tax = tax;
    }

    @Override
    public String toString() {
       return String.format("%5s%10s%10.2f%10.2f%10.2f", code,name,income,deduction,tax);
    }

    
}
