import java.text.NumberFormat;

public class MortgageCalculator {
    private final byte MONTHS_IN_YEAR = 12;

    private final int principal;
    private final double annualInterest;
    private final int years;

    public MortgageCalculator(int principal, double annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        return (principal * (Math.pow((1 + monthlyInterest), numberOfPayments)
                - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }


    public double calculateMortgage() {
        int numberOfPayments = getNumberOfPayments();
        float monthlyInterest = getMonthlyInterest();

        return principal * // Don't Multiply by period you goose
                (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)) /
                (Math.pow(monthlyInterest + 1, numberOfPayments) - 1);
    }

    public void getPaymentSchedule() {
        for (short month = 1; month <= getNumberOfPayments(); month++) {
            double balance = calculateBalance(month);
            System.out.println("After month " + month + ": " + NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private float getMonthlyInterest() {
        byte PERCENT = 100;
        return (float) (annualInterest / PERCENT / MONTHS_IN_YEAR);
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}