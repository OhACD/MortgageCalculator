public class MortgageCalculator {
    final static byte PERCENT = 100;
    final static byte MONTHS_IN_YEAR = 12;

    private int principal;
    private double annualInterest;
    private int years;

    public MortgageCalculator(int principal, double annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTHS_IN_YEAR);

        return (principal * (Math.pow((1 + monthlyInterest), numberOfPayments)
                - Math.pow((1 + monthlyInterest), numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
    }

    public double calculateMortgage() {
        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = (float) (annualInterest / PERCENT / MONTHS_IN_YEAR);

        return principal * // Dont Multiply by period you goose
                (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)) /
                (Math.pow(monthlyInterest + 1, numberOfPayments) - 1);
    }

    public int getYears() {
        return years;
    }
}