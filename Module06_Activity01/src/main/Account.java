/* Harrison Blair's Account.java for Module06-Activity01
 * 
 */

package main;

public class Account {

	double balance;
	
	public Account() {
		balance = 0.0;
	}
	
	public double getBalance() { return balance; }
	
	public void deposit(double amount) {
		if (amount < 0)
			return;
		balance += amount;
	}
	
	public double withdraw(double amount) {
		if (amount <= balance & 0 < amount) {
			balance -= amount;
			return amount;
		}
		return 0.0;
	}
	
	public void transferMoney(Account toAccount, double amount) {
		if (withdraw(amount) == 0.0) {
			return;
		}
		toAccount.deposit(amount);
	}
	
}