package com.skeggib.accounts;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.skeggib.accounts.model.BankAccount;
import com.skeggib.accounts.model.Entry;
import com.skeggib.accounts.model.EntryType;

/**
 * Account manager, allows to manage accounts, entries and entry types
 * @author skeggib
 */
public class AccountManager {
	
	private ConnectionSource source;
	
	private Dao<BankAccount, Integer> bankAccountDao;
	private Dao<EntryType, Integer> entryTypeDao;
	private Dao<Entry, Integer> entryDao;

	public AccountManager(ConnectionSource source) throws SQLException {
		this.source = source;
		
		this.bankAccountDao = DaoManager.createDao(this.source, BankAccount.class);
		this.entryTypeDao = DaoManager.createDao(this.source, EntryType.class);
		this.entryDao = DaoManager.createDao(this.source, Entry.class);
	}
	
	/**
	 * Recreates the tables in the database
	 * @throws SQLException
	 */
	public void recreateTables() throws SQLException {
		TableUtils.dropTable(this.source, Entry.class, true);
		TableUtils.dropTable(this.source, EntryType.class, true);
		TableUtils.dropTable(this.source, BankAccount.class, true);
		
		TableUtils.createTable(this.source, BankAccount.class);
		TableUtils.createTable(this.source, EntryType.class);
		TableUtils.createTable(this.source, Entry.class);
	}
	
	/**
	 * Creates a new entry
	 * @param entry
	 * @throws SQLException
	 */
	public void addEntry(Entry entry) throws SQLException {
		this.entryDao.create(entry);
	}
	
	/**
	 * Deletes an entry
	 * @param entry
	 * @throws SQLException
	 */
	public void deleteEntry(Entry entry) throws SQLException {
		this.entryDao.delete(entry);
	}
	
	/**
	 * Retrieves all entries of a bank account
	 * @param bank
	 * @return A list of entries of the bank account
	 * @throws SQLException
	 */
	public List<Entry> listEntriesByBankAccount(BankAccount bank) throws SQLException {
		Entry entry = new Entry();
		entry.setBankAccount(bank);
		return this.entryDao.queryForMatching(entry);
	}
	
	/**
	 * Creates a new bank account
	 * @param account
	 * @throws SQLException
	 */
	public void addBankAccount(BankAccount account) throws SQLException {
		this.bankAccountDao.create(account);
	}
	
	/**
	 * Deletes a bank account if no entries are associated to it
	 * @param account
	 * @throws SQLException
	 */
	public void deleteBankAccount(BankAccount account) throws SQLException {
		this.bankAccountDao.delete(account);
	}
	
	/**
	 * Retrieves all bank accounts
	 * @return The list of bank accounts
	 * @throws SQLException
	 */
	public List<BankAccount> listBankAccounts() throws SQLException {
		return this.bankAccountDao.queryForAll();
	}

	/**
	 * Retrieves a bank account by id
	 * @param id
	 * @return The bank account identified by the specified id or null if not found
	 * @throws SQLException
	 */
	public BankAccount getBankAccountById(int id) throws SQLException {
		return this.bankAccountDao.queryForId(id);
	}
	
	/**
	 * Retrieves a bank account by reference
	 * @param reference
	 * @return The bank account identified by the specified reference or null if not found
	 * @throws SQLException
	 */
	public BankAccount getBankAccountByReference(String reference) throws SQLException {
		BankAccount bank = new BankAccount();
		bank.setReference(reference);
		List<BankAccount> list = this.bankAccountDao.queryForMatching(bank);
		if (list.size() > 0)
			return list.get(0);
		return null;
	}
	
	public void addEntryType(EntryType type) throws SQLException {
		this.entryTypeDao.create(type);
	}
	
	public void deleteEntryType(EntryType type) throws SQLException {
		this.entryTypeDao.delete(type);
	}
	
}
