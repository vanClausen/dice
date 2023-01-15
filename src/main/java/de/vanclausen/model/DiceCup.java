package de.vanclausen.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceCup {

  private final List<Dice> dices = new ArrayList<>();

  public DiceCup( int dices, int eyes, DiceColor diceColor ) {
    for ( int i = 0; i < dices; i++ ) {
      addDice( eyes, diceColor );
    };
  }

  public void addDice( int eyes, DiceColor diceColor ) {
    this.dices.add( new Dice( eyes, diceColor ) );
  }

  public void removeDice( int index ) {
    this.dices.remove( index );
  }

  public void printDices() {
    for ( int i = 0; i < dices.size(); i++ ) {
      System.out.printf( "[%d] - %s%n", i, dices.get( i ));
    }
  }

  public void rollDices() {
    Collections.shuffle( dices );
    for ( Dice dice : dices ) {
      dice.rollDice();
    }
  }

  public int[] getResults(){
    int[] result = new int[dices.size()];
    for ( int i = 0; i < dices.size(); i++ ) {
      result[i] = dices.get( i ).getResult();
    }
    return result;
  }

  public List<Dice> getDices() {
    return List.copyOf( dices );
  }

  @Override
  public String toString() {
    return dices.toString();
  }
}