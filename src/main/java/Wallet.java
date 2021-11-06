public class Wallet {
    private final double DOLLARTORUPEES = 74.85;

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("deposit amount should not be negative");
        balance += amount;
    }

    public double rupeesToDollars(double rupees) {
        return rupees / DOLLARTORUPEES;
    }
}
