public class Wallet {
    private final double DOLLARTORUPEES = 74.85;

    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double rupeesToDollars(double rupees) {
        return rupees / DOLLARTORUPEES;
    }
}
