package com.skilldistillery.blackjack.cards;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Inventory {
	// instance variables
	private int itemNumber;
	private String itemDesicrption;
	private Items item;

	// Holds inventory
	Map<Integer, Items> gameItems = new HashMap<>();

	// ---Constructors---
	public Inventory() {

	}

	/// ---GETTERS AND SETTERS---
	public String getItemDesicrption() {
		return itemDesicrption;
	}

	public void setItemDesicrption(String itemDesicrption) {
		this.itemDesicrption = itemDesicrption;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public Map<Integer, Items> getGameItems() {
		return gameItems;
	}

	public void setGameItems(Map<Integer, Items> gameItems) {
		this.gameItems = gameItems;
	}

	// ---TOSTRING---
	@Override
	public String toString() {
		return "Inventory: Item Number" + itemNumber + ", Item Desicrption: " + itemDesicrption + ", Item" + item
				+ ", Game Items" + gameItems;
	}

//---HASHCODE---
	@Override
	public int hashCode() {
		return Objects.hash(gameItems, item, itemDesicrption, itemNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(gameItems, other.gameItems) && Objects.equals(item, other.item)
				&& Objects.equals(itemDesicrption, other.itemDesicrption) && itemNumber == other.itemNumber;
	}

}
