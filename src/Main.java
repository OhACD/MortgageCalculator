
public class Main {

    public static void main(String[] args) {
        int principal = (int) Consol.readNumber("Principal:", 1000, 1_000_000);
        float annualInterest = (float) Consol.readNumber("Annual Interest Rate:", 1, 30);
        byte years = (byte) Consol.readNumber("Period (Years):", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}