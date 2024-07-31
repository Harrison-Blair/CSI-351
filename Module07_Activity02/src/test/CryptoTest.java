package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import main.CryptoCurrency;

public class CryptoTest {
	
	CryptoCurrency myCrypto;
	
	@DisplayName("Input of valid passcode is returned.")
	@ParameterizedTest
	@CsvSource({
		"1234",
		"1",
		"2147483647",
	})
	public void AcceptsValidInputTest(int input) {
		// Makes new CryptoCurrency with input as code
		myCrypto = new CryptoCurrency(input);
		
		// Should return input unmodified
		assertEquals(myCrypto.getSecretPasscode(), input);
	}
	
	@DisplayName("Rejects Bad Input")
	@ParameterizedTest
	@CsvSource({
		"0",
		"-1",
		"-2147483648"
	})
	public void DeniesInvalidInput(int input) {
		try {
			// Makes new CryptoCurrency with input as code
			myCrypto = new CryptoCurrency(input);
			
			fail("Should not run this line");
		} catch (Exception ex) {
		}
	}
	
	@DisplayName("Returns Correct Conversion")
	@ParameterizedTest
	@CsvSource({
		"116 , 1do1di1ni1pe",
		"99 , 3qu2di4pe",
		"24 , 2di4pe"
	})
	public void DeniesInvalidInputTest(int input, String passcode) {
		// Makes new CryptoCurrency with input as code
		myCrypto = new CryptoCurrency(input);
		
		// CryptoCurrency generated should equal the pre-determined output
		assertEquals(myCrypto.generateCryptoCurrency(), passcode);
	}
	
	
}