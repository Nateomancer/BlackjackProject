package com.skilldistillery.blackjack.cards;

public enum Suit {
  HEARTS("Hearts"), SPADES("Spades"), CLUBS("Clubs"), DIAMONDS("Diamonds");
  private String name;

  
  //---Constructor--
  Suit(String name) {
    this.name = name;
  }
  
  

  
  public String getName() {
	return name;
}

//---toString---
  @Override
  public String toString() {
    return name;
  }
}