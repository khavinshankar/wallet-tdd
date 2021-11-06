public class Wallet {
    private final double DOLLARTORUPEES = 74.85;

    private double balance = 0; // balance is always maintained in dollars (USD)
    private String preferredCurrency;


    public double getBalance() {
        switch (preferredCurrency) {
            case "INR": return round(dollarsToRupees(balance)); // USD -> INR
            case "USD": return round(balance);
        }

        return balance;
    }

    public String getPreferredCurrency() {
        return preferredCurrency;
    }

    public void setPreferredCurrency(String preferredCurrency) {
        this.preferredCurrency = preferredCurrency;
    }


    Wallet() {
        setPreferredCurrency("INR");
    }

    Wallet(String preferredCurrency) {
        setPreferredCurrency(preferredCurrency);
    }


    public void deposit(double amount) {
        deposit(amount, preferredCurrency);
    }

    public void deposit(double amount, String currency) {
        if (amount < 0) { throw new IllegalArgumentException("deposit amount cannot be negative"); }

        switch (currency) {
            case "INR": depositINR(amount); break;
            case "USD": depositUSD(amount); break;
        }
    }

    public void depositINR(double amount) {
        double amountInUSD = this.rupeesToDollars(amount); // INR -> USD
        balance += amountInUSD;
    }

    public void depositUSD(double amount) {
        balance += amount;
    }


    public double rupeesToDollars(double rupees) {
        return rupees / DOLLARTORUPEES;
    }

    public double dollarsToRupees(double dollars) {
        return dollars * DOLLARTORUPEES;
    }

    public double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
