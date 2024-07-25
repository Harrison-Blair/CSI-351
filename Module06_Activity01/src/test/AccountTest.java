/* Harrison Blair's AccountTest.java for Module06-Activity01
 * 
 */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import main.Account;

public class AccountTest {
	
	Account Account1;
	Account Account2;
	
	@BeforeEach
	public void beforeMethod() {
		// Initializes two new Accounts for use in each test
		Account1 = new Account();
		Account2 = new Account();
	}
	
	@Test
	@DisplayName("Ensure Initial Value is 0.0")
	public void testInitialValue() {
		// Initial balance should be 0.0
		assertEquals(Account1.getBalance(), 0.0);
	}
	
	@Test
	@DisplayName("Testing the deoposit function")
	public void testDeposit() {
		// Depositing a starting (40.57) amount into the account
		Account1.deposit(40.57);
		
		// New balance should be 40.57
		assertEquals(Account1.getBalance(), 40.57);
	}
	
	@Test
	@DisplayName("Disallow depositing a negative number")
	public void testNegativeDeposit() {
		// Attempt to deposit a negative value
		Account1.deposit(-5);
		
		// Account balance should still be 0.0
		assertEquals(Account1.getBalance(), 0.0);
	}
	
	@Test
	@DisplayName("Testing the withdraw function")
	public void testWithdraw() {
		// Depositing a starting (40.57) amount into the account
		Account1.deposit(55);
				
		// Withdraw(50) should return 50
		assertEquals(Account1.withdraw(50.0), 50.0);
		
		// Remaining balance should be 5
		assertEquals(Account1.getBalance(), 5);
	}
	
	@Test
	@DisplayName("Disallow withdrawing a negative number")
	public void testNegativeWithdraw() {
		// Withdraw(-20) should return 0.0
		assertEquals(Account1.withdraw(-20.0), 0.0);
	}
	
	@Test
	@DisplayName("Test transfer function")
	public void testTransfer() {
		// Deposit 50.5 in Account1
		Account1.deposit(50.5);
		
		// Transfer 30.5 to Account2
		Account1.transferMoney(Account2, 30.5);
		
		// Ensure 30.5 was taken out of Account1 (remaining 20.0)
		assertEquals(Account1.getBalance(), 20.0);
		
		// Ensure 30.5 arrived in Account2
		assertEquals(Account2.getBalance(), 30.5);
	}
	
	@Test
	@DisplayName("Ensure no negative transfers allowed")
	public void testNegativeTransfer() {
		// Attempt transfer
		Account1.transferMoney(Account2, -40.5);
		
		// Account1 Balance 0.0
		assertEquals(Account1.getBalance(), 0.0);
		
		// Account2 Balance 0.0
		assertEquals(Account2.getBalance(), 0.0);
	}
	
	@Test
	@DisplayName("Test interest function")
	@Disabled("Disabled until interest function is reimplimented")
	public void testInterest() {
		//Super awesome interest functions here
		
		// Random assertion that would fail if ran
		assertEquals(Account1.getBalance(), -2200.0);
	}
}