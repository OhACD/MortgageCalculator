import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int principal = (int) readNumber("Principal:", 1000, 1_000_000);
        double annualInterest = readNumber("Annual Interest Rate:", 1, 30);
        double years = (int) readNumber("Period (Years):", 1, 30);

            double mortgage = calculateMortgage(principal,annualInterest ,(int) years);
            String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

                System.out.println("Mortgage: " + mortgageFormatted);
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

    public static double calculateMortgage(int principal, double annualInterest, int years) {

        final int PERCENT = 100;
        final int MONTHS_IN_YEAR = 12;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTHS_IN_YEAR);

        double mortgage = principal * // Dont Multiply by period you goose
                (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)) /
                (Math.pow(monthlyInterest + 1, numberOfPayments) - 1);
        return mortgage;
    }
}