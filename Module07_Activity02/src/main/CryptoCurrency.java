package main;

public class CryptoCurrency {

    private int secretPasscode;

    public CryptoCurrency(int passcode) {
        setSecretPasscode(passcode);
    }

    // The input secretPasscode is a whole number is > 0.
    public void setSecretPasscode(int secretPasscode) {
        if (secretPasscode > 0)
            this.secretPasscode = secretPasscode;
        else
            throw new IllegalArgumentException("Number must be positive integer");
    }

    public int getSecretPasscode() {
        return secretPasscode;
    }

    /*
     * Algorithm Convert the number into smaller currency denominations (dollars,
     * quarters, dimes, nickels, and pennies). If any denomination has 0 units,
     * don't include that denomination in the output. e.g. the input number 12,
     * display the output as 1 dime, 2 pennies instead of 0 dollars, 0 quarters, 1
     * dimes, 0 nickels, 2 pennies For each denomination where the amount is >0,
     * prefix the first two letter of the denomination name in the output. Dollar do
     * Quarter qu Dime di Nickel ni Penny pe
     * 
     * Example: Input (Secret Code) 248 Intermediate Calculation 2 dollars, 1
     * quarter, 2 dimes, 3 pennies Output (Currency Code) 2do1qu2di3pe
     * 
     */
    public String generateCryptoCurrency() {
        int reminder;
        int dollarCount; 	// 100
        int quarterCount; 	// 25
        int dimeCount; 		// 10
        int nickelCount; 	// 5
        int pennyCount; 	// 1

        dollarCount = secretPasscode / 100;
        reminder = secretPasscode % 100;

        quarterCount = reminder / 25;
        reminder = reminder % 25;

        dimeCount = reminder / 10;
        reminder = reminder % 10;

        nickelCount = reminder / 5;
        reminder = reminder % 5;

        pennyCount = reminder;

        String cryptoCurrenycPasscode = "";

        cryptoCurrenycPasscode += appendDollars(dollarCount);
        cryptoCurrenycPasscode += appendQuarter(quarterCount);
        cryptoCurrenycPasscode += appendDime(dimeCount);
        cryptoCurrenycPasscode += appendNickel(nickelCount);
        cryptoCurrenycPasscode += appendPenny(pennyCount);

        return cryptoCurrenycPasscode;
    }

    private String appendDollars(int dollarCount) {
        if (dollarCount > 0)
            return dollarCount + "do";
        else
            return "";
    }

    private String appendQuarter(int quarterCount) {
        if (quarterCount > 0)
            return quarterCount + "qu";
        else
            return "";
    }

    private String appendDime(int dimeCount) {
        if (dimeCount > 0)
            return dimeCount + "di";
        else
            return "";
    }

    private String appendNickel(int nickelCount) {
        if (nickelCount > 0)
            return nickelCount + "ni";
        else
            return "";
    }


    private String appendPenny(int pennyCount) {
        if (pennyCount > 0)
            return pennyCount + "pe";
        else
            return "";
    }
}
