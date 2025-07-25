import java.text.NumberFormat;

public class PrintPaymentSchedule {
    public static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * Calculations.MONTHS_IN_YEAR; month++) {
            double balance = new Calculations().calculateBalance(principal, annualInterest, years, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
    }
}
