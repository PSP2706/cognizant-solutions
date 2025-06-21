public class DSExercise7 {
    public static void main(String[] args) {
        double initialAmount = 1000.0;
        double annualRate = 0.05;
        int durationYears = 5;

        double projectedAmount = forecastValueRecursive(initialAmount, annualRate, durationYears);
        System.out.printf("Projected Value after %d years: %.2f%n", durationYears, projectedAmount);
    }
    public static double forecastValueRecursive(double amount, double rate, int yearsLeft) {
        if (yearsLeft == 0) {
            return amount;
        }
        return forecastValueRecursive(amount, rate, yearsLeft - 1) * (1 + rate);
    }
}
