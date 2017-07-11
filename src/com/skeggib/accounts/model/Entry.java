package com.skeggib.accounts.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

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
		this.label = new String();
		this.reference = new String();
		this.date = new Date();
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
	
}
