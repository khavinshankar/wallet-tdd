import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalletTest {
//    As a wallet owner, I would like to be able to know that 74.85 rupees is equal to 1 dollar.
    @Test
    public void verifySeventyFourRupeesEightyFivePaiseIsOneDollar() {
        Wallet wallet = new Wallet();
        Assertions.assertEquals(1, wallet.rupeesToDollars(74.85));
    }

//    As a wallet owner I would like to be able to put money into my wallet so that I can take it out later.
//    As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.50 & $1 added to my wallet, Then the sum of money in the wallet is Rs.124.85, (Given preferred currency is Rs.)
//    As a wallet owner, I want to know the total money my wallet has for the preferred currency. When Rs.74.85, $1, Rs.149.7 added to my wallet, Then sum of money in the wallet is $4, (Given preferred currency is $)
//    As a wallet owner I would like to be able to take a specified amount of money out of the wallet.

}
