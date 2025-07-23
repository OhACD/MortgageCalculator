import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int PERCENT = 100;
        final int MONTHS_IN_YEAR = 12;
        int principal;
        int period;
        double rate;
        double mortgage;
        String mortgageFormatted;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1k - $1M):");
            principal = scanner.nextInt();

            if (principal < 1000 || principal > 1_000_000) {
                System.out.println("You need to enter a value between $1k and $1M");
                continue;
            } break;
        }

        while (true) {
            System.out.print("Annual intrest rate:");
            rate = scanner.nextDouble();

            if (rate < 1 || rate >= 30) {
                System.out.println("You need to enter a value greater than 0 and less than or equals to 30");
                continue;
            } break;
        }
            rate = (rate / PERCENT) / MONTHS_IN_YEAR;

        while (true) {
            System.out.print("Period (Years):");
            period = scanner.nextInt();

            if (period < 1 || period > 30){
                System.out.println("You need to enter a value greater than 0 and less than 30");
                continue;
            } break;
        }
            period = period * MONTHS_IN_YEAR;

            mortgage = principal * // Dont Multiply by period you goose
                    (rate * Math.pow(rate + 1, period)) /
                    (Math.pow(rate + 1, period) - 1);
            mortgage = Math.round(mortgage); // Rounding it to the nearst whole number
            mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
    }
}