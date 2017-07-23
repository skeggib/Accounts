package com.skeggib.accounts.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Bank account.
 * @author skeggib
 */
@DatabaseTable(tableName = "accounts")
public class BankAccount {
    
    @DatabaseField(generatedId = true)
    private Integer id;
    
    @DatabaseField
    private String name;
    
    @DatabaseField(unique = true)
    private String reference;
    
    public BankAccount() {

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
    
    public String toString() {
    	return "BankAccount:\n"
    			+ "\tid: " + this.id + "\n"
    			+ "\tname: " + this.name + "\n"
    			+ "\treference: " + this.reference;
    }
    
    public boolean equals(Object o) {
    	if (!(o instanceof BankAccount))
    		return false;
    	
    	BankAccount bank = (BankAccount)o;
    	
    	if (this.id != bank.id)
    		return false;
    	
    	if (!this.name.equals(bank.name))
    		return false;
    	
    	if (!this.reference.equals(bank.reference))
    		return false;
    	
    	return true;
    }
	
}