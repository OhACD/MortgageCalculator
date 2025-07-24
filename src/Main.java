import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal;
        int years;
        float annualInterest;
        double mortgage;

        while (true) {
            System.out.print("Principal ($1k - $1M):");
            principal = scanner.nextInt();

            if (principal < 1000 || principal > 1_000_000) {
                System.out.println("You need to enter a value between $1k and $1M");
                continue;
            } break;
        }

        while (true) {
            System.out.print("Rate:");
                annualInterest = scanner.nextFloat();

            if (annualInterest < 1 || annualInterest > 30) {
                System.out.println("You need to enter a value greater than 0 and less than or equals to 30");
                continue;
            } break;
        }

        while (true) {
            System.out.print("Period (Years):");
            years = scanner.nextInt();

            if (years < 1 || years > 30){
                System.out.println("You need to enter a value greater than 0 and less than 30");
                continue;
            } break;
        }

        mortgage = calculateMortgage(principal,annualInterest ,years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
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