import exceptions.InsufficientFundsException;

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
        switch (preferredCurrency) {
            case "INR":
            case "USD": this.preferredCurrency = preferredCurrency; break;
            default: throw new IllegalArgumentException("make sure preferred currency is valid");
        }
    }


    Wallet() {
        setPreferredCurrency("INR");
    }

    Wallet(String preferredCurrency) {
        setPreferredCurrency(preferredCurrency);
    }


    public void withdraw(double amount) throws InsufficientFundsException {
        withdraw(amount, preferredCurrency);
    }

    public void withdraw(double amount, String currency) throws InsufficientFundsException {
        if (amount < 0) {
            throw new IllegalArgumentException("withdrawal amount cannot be negative");
        }

        switch (currency) {
            case "INR": withdrawINR(amount); break;
            case "USD": withdrawUSD(amount); break;
        }
    }

    public void withdrawINR(double amount) throws InsufficientFundsException {
        double amountInUSD = this.rupeesToDollars(amount); // INR -> USD
        withdrawUSD(amountInUSD);
    }

    public void withdrawUSD(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("withdrawal amount cannot be greater than balance");
        }
        balance -= amount;
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
        depositUSD(amountInUSD);
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
