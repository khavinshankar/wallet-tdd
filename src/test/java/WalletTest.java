import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class WalletTest {
    private Wallet wallet;

    @BeforeEach
    void setup() {
        wallet = new Wallet();
    }

//    As a wallet owner, I would like to be able to know that 74.85 rupees is equal to 1 dollar.
    @Test
    public void verifySeventyFourRupeesEightyFivePaiseIsOneDollar() {
        Assertions.assertEquals(1, wallet.rupeesToDollars(74.85));
    }

    @Test
    public void verifySetPreferredCurrencyOnlyAcceptsValidCurrencies() {
        Assertions.assertAll(
                () -> {
                    wallet.setPreferredCurrency("INR");
                    Assertions.assertEquals("INR", wallet.getPreferredCurrency());
                },
                () -> {
                    wallet.setPreferredCurrency("USD");
                    Assertions.assertEquals("USD", wallet.getPreferredCurrency());
                },
                () -> Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.setPreferredCurrency("SOME"))
        );
    }

    @Nested
    class verifyDepositFunctionality {
        //    As a wallet owner I would like to be able to put money into my wallet so that I can take it out later.
        @Test
        public void verifyDepositFunctionalityWithSingleDeposit() {
            wallet.deposit(50);
            Assertions.assertEquals(50, wallet.getBalance());
        }

        @Test
        public void verifyDepositFunctionalityWithMultipleDeposits() {
            wallet.deposit(50);
            Assertions.assertEquals(50, wallet.getBalance());

            wallet.deposit(150);
            Assertions.assertEquals(200, wallet.getBalance());

            wallet.deposit(100);
            wallet.deposit(20);
            Assertions.assertEquals(320, wallet.getBalance());
        }

        @Test
        public void verifyDepositFunctionalityWithNegativeDeposit() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> wallet.deposit(-50));
        }

        //    As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.50 & $1 added to my wallet, Then the sum of money in the wallet is Rs.124.85, (Given preferred currency is Rs.)
        @Test
        public void verifyMultipleCurrencyDepositWhenPreferredCurrencyIsINR() {
            wallet.setPreferredCurrency("INR");
            wallet.deposit(50, "INR");
            wallet.deposit(1, "USD");

            double balance = wallet.getBalance();
            Assertions.assertEquals(124.85, balance);
        }
    }


//    As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.74.85, $1, Rs.149.7 added to my wallet, Then sum of money in the wallet is $4, (Given preferred currency is $)
//    As a wallet owner I would like to be able to take a specified amount of money out of the wallet.

}
