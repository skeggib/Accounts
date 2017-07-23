package com.skeggib.accounts.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Entry composed of a label, a unique reference, a date, an amount and a type.
 * An entry is linked to a bank account.
 * @author skeggib
 */
@DatabaseTable(tableName = "entries")
public class Entry {

	@DatabaseField(id = true)
	private int id;
	
	@DatabaseField
	private String label;

	@DatabaseField
	private String reference;

	@DatabaseField
	private Date date;

	@DatabaseField
	private double amount;
	
	@DatabaseField(foreign = true)
	private BankAccount bankAccount;
	
	@DatabaseField(foreign = true)
	private EntryType type;
	
	public Entry() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public BankAccount getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(BankAccount bank) {
		this.bankAccount = bank;
	}
	
	public EntryType getType() {
		return this.type;
	}
	
	public void setType(EntryType type) {
		this.type = type;
	}
	
}
