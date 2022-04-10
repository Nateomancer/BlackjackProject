package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Items {

	// instance variables
	// Map<Integer,Items> gameItems=new HashMap<>();

	// the items name
	private String itemName;
	// the items descirption
	private String itemDescription;
	// number representing the item
	private int itemNumber;

	public Items() {

	}

	public Items(String itemName, String itemDescription, int itemNumber) {
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemNumber = itemNumber;

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	// ---HASHCODE---
	@Override
	public int hashCode() {
		return Objects.hash(itemDescription, itemName, itemNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		return Objects.equals(itemDescription, other.itemDescription) && Objects.equals(itemName, other.itemName)
				&& itemNumber == other.itemNumber;
	}

	// ---TOSTRING---
	@Override
	public String toString() {
		return "\nITEM NAME:\n" + itemName + " \n\n"  +"ITEM DESCRIPTION: \n" + itemDescription + "\n";
	}
}
