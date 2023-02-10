package de.vanclausen.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
  private final int eyes;
  private final DiceColor diceColor;
  private int result;

  public Dice () {
    this(6, DiceColor.WHITE);
  }

  public Dice ( int eyes, DiceColor diceColor) {
    this.eyes = eyes;
    this.diceColor = diceColor;
    rollDice();
  }

  public DiceColor getDiceColor() { return diceColor; }

  public void rollDice () {
    this.result = ThreadLocalRandom.current().nextInt( eyes ) + 1;
  }

  public int getResult() {
    return result;
  }

  @Override
  public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass() != o.getClass() ) return false;

    Dice dice = ( Dice ) o;

    if ( eyes != dice.eyes ) return false;
    return diceColor == dice.diceColor;
  }

  @Override
  public int hashCode() {
    int result = eyes;
    result = 31 * result + diceColor.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return result +
        "/" + eyes +
        "-" + diceColor;
  }
}
