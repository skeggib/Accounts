package com.skeggib.accounts.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.skeggib.accounts.AccountManager;
import com.skeggib.accounts.model.BankAccount;

public class AccountManagerTest {
	
	private static String ConnectionString = "jdbc:sqlite:db.sqlite";
	
	@Test
	public void connect() {
		try {
			new AccountManager(new JdbcConnectionSource(AccountManagerTest.ConnectionString));
		} catch (SQLException e) {
			fail("Connection to 'db.sqlite' should not throw an exception");
		}
	}

	@Test
	public void recreateTables() {
		try {
			AccountManager manager = new AccountManager(new JdbcConnectionSource(AccountManagerTest.ConnectionString));
			manager.recreateTables();
		} catch (SQLException e) {
			fail("Recreating tables should not throw an exception");
		}
	}
	
	@Test
	public void addBankAccount() {
		try {
			AccountManager manager;
			manager = new AccountManager(new JdbcConnectionSource(AccountManagerTest.ConnectionString));
			manager.recreateTables();
			
			BankAccount bank = new BankAccount();
			bank.setName("Test bank account");
			bank.setReference("Ref00001");
			
			manager.addBankAccount(bank);
			
			List<BankAccount> list = manager.listBankAccounts();
			assertEquals(1, list.size());
			BankAccount actualBank = list.get(0);
			assertEquals(bank, actualBank);
		} catch (SQLException e) {
			fail("Adding a bank account should not throw an exception");
		}
	}
	
	@Test
	public void deleteBankAccount() {
		try {
			AccountManager manager;
			manager = new AccountManager(new JdbcConnectionSource(AccountManagerTest.ConnectionString));
			manager.recreateTables();
			
			BankAccount bank1 = new BankAccount();
			bank1.setName("Test bank account 1");
			bank1.setReference("Ref00001");
			manager.addBankAccount(bank1);

			BankAccount bank2 = new BankAccount();
			bank2.setName("Test bank account 2");
			bank2.setReference("Ref00002");
			manager.addBankAccount(bank2);
			
			List<BankAccount> list = manager.listBankAccounts();
			bank1 = list.get(0);
			bank2 = list.get(1);
			manager.deleteBankAccount(bank1);
			
			list = manager.listBankAccounts();
			assertEquals(1, list.size());
			assertEquals(bank2, list.get(0));
			
		} catch (SQLException e) {
			fail("Deleting a bank account should not throw an exception");
		}
	}

}
