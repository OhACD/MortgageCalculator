import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final int PERCENT = 100;
        final int MONTHS_IN_YEAR = 12;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Principal:");
        int principal = scanner.nextInt();

        System.out.println("Annual intrest rate:");
        double rate = (scanner.nextDouble() / PERCENT) / MONTHS_IN_YEAR;

        System.out.println("Period (Years):");
        int period = scanner.nextInt() * MONTHS_IN_YEAR;
            double mortgage = principal * // Dont Multiply by period you goose
                    (rate * Math.pow(rate + 1, period)) /
                    (Math.pow(rate + 1, period) - 1);
            mortgage = Math.round(mortgage); // Rounding it to the nearst whole number
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);
    }
}