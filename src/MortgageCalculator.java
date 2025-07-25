public class MortgageCalculator {
    private final byte PERCENT = 100;
    private final byte MONTHS_IN_YEAR = 12;

    private int principal;
    private double annualInterest;
    private int years;

    public MortgageCalculator(int principal, double annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }
        //Overloaded Method to be used if one of the declared variables is needed
    public MortgageCalculator() {

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

        return principal * // Don't Multiply by period you goose
                (monthlyInterest * Math.pow(monthlyInterest + 1, numberOfPayments)) /
                (Math.pow(monthlyInterest + 1, numberOfPayments) - 1);
    }

    public int getYears() {
        return years;
    }
    public int getMonthsInAYear() {
        return MONTHS_IN_YEAR;
    }
}