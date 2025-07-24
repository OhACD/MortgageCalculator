import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal:", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate:", 1, 30);
        byte years = (byte) readNumber("Period (Years):", 1, 30);

        printMortgage(principal, annualInterest, years);
        printPaymentSchedule(years, principal, annualInterest);
    }

    private static void printPaymentSchedule(byte years, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            String balanceFormatted = NumberFormat.getCurrencyInstance().format(balance);
            System.out.println(balanceFormatted);
        }
    }

    private static void printMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    public static double readNumber(String prompt, double min, double max ) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();

            if (value < min || value > max) {
                System.out.println("You need to enter a value between " + min + " and " + max);
                continue;
            } break;
        }
        return value;
    }

    public static double calculateBalance(int principal, double annualInterest, int years, short numberOfPaymentsMade) {
        float numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTHS_IN_YEAR);

        return (principal * (Math.pow((1 + monthlyInterest), numberOfPayments)
                        - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    public static double calculateMortgage(int principal, double annualInterest, int years) {

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTHS_IN_YEAR);

        // Dont Multiply by period you goose
        return principal * // Dont Multiply by period you goose
                (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)) /
                (Math.pow(monthlyInterest + 1, numberOfPayments) - 1);
    }
}