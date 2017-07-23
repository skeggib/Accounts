package com.skeggib.accounts.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Type of entries, can be used to group similar spending.
 * @author skeggib
 */
@DatabaseTable(tableName = "entriestypes")
public class EntryType {

	@DatabaseField(id = true)
	private int id;
	
	@DatabaseField
	private String name;
	
	public EntryType() {

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
	
}
