import java.util.Scanner;

public class Consol {
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
}