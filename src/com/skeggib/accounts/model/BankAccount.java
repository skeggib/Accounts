package com.skeggib.accounts.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class BankAccount {
    
    @DatabaseField(id = true)
    private int id;
    
    @DatabaseField
    private String name;
    
    @DatabaseField
    private String reference;
    
    public BankAccount() {
        // ORMLite needs a no-arg constructor
    	
    	this.name = new String();
    	this.reference = new String();
    }
    
    public BankAccount(String name, String reference) {
        this.name = name;
        this.setReference(reference);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
		return reference;
	}

    public void setReference(String reference) {
		this.reference = reference;
	}
	
}