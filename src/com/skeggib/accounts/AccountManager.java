package com.skeggib.accounts;

import java.sql.SQLException;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.skeggib.accounts.model.BankAccount;
import com.skeggib.accounts.model.Entry;
import com.skeggib.accounts.model.EntryType;

public class AccountManager {
	
	private ConnectionSource source;

	public AccountManager(ConnectionSource source) {
		this.source = source;
	}
	
	public void recreateTables() throws SQLException {
		TableUtils.dropTable(this.source, Entry.class, true);
		TableUtils.dropTable(this.source, EntryType.class, true);
		TableUtils.dropTable(this.source, BankAccount.class, true);
		
		TableUtils.createTable(this.source, BankAccount.class);
		TableUtils.createTable(this.source, EntryType.class);
		TableUtils.createTable(this.source, Entry.class);
	}
	
}
