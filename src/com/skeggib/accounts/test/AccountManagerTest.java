package com.skeggib.accounts.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.skeggib.accounts.AccountManager;

public class AccountManagerTest {
	
	@Test
	public void connect() {
		try {
			new AccountManager(new JdbcConnectionSource("jdbc:sqlite:db.sqlite"));
		} catch (SQLException e) {
			fail("Connection to 'db.sqlite' should not throw exceptions");
		}
	}

	@Test
	public void recreateTables() {
		try {
			AccountManager manager = new AccountManager(new JdbcConnectionSource("jdbc:sqlite:db.sqlite"));
			manager.recreateTables();
		} catch (SQLException e) {
			fail("Recreating tables should not throw exceptions");
		}
	}

}
