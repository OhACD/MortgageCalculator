import java.text.NumberFormat;

public class PrintMortgage {
    public static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = new Calculations().calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
