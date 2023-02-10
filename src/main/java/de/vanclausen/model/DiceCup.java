package de.vanclausen.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiceCup {

  private final List<Dice> dices = new ArrayList<>();

  public DiceCup( int amountOfDice, int eyes, DiceColor diceColor ) {
    for ( int i = 0; i < amountOfDice; i++ ) {
      addDice( eyes, diceColor );
    }
  }

  public void addDice( int eyes, DiceColor diceColor ) {
    if ( dices.size() < 30 )
      this.dices.add( new Dice( eyes, diceColor ) );
  }

  public void removeDice() {
    this.dices.clear();
    addDice( 6, DiceColor.WHITE );
  }

  public void printDices() {
    for ( int i = 0; i < dices.size(); i++ ) {
      System.out.printf( "[%d] - %s%n", i, dices.get( i ) );
    }
  }

  public void rollDices() {
//    Collections.shuffle( dices );
    for ( Dice dice : dices ) {
      dice.rollDice();
    }
  }

  public int[] getResults() {
    int[] result = new int[ dices.size() ];
    for ( int i = 0; i < dices.size(); i++ ) {
      result[ i ] = dices.get( i ).getResult();
    }
    return result;
  }

  public List<Dice> getDices() {
    if (dices.size() == 1)
      return Collections.singletonList( dices.get( 0 ) );
    return List.copyOf( dices );
  }

  @Override
  public String toString() {
    return dices.toString();
  }
}
