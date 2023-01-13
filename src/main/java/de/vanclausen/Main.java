package de.vanclausen;

import java.util.Arrays;

public class Main {
  public static void main( String[] args ) {

    DiceCup diceCup = new DiceCup( 4, 6, DiceColor.WHITE );
    System.out.println( Arrays.toString( diceCup.getResults() ) );
    diceCup.rollDices();
    System.out.println( Arrays.toString( diceCup.getResults() ) );
    diceCup.addDice( 6,DiceColor.RED );
    diceCup.rollDices();
    System.out.println( Arrays.toString( diceCup.getResults() ) );
    for ( Dice dice : diceCup.getDices() ) {
      System.out.println(dice);
    }
    System.out.println("-----------");
    diceCup.rollDices();
    for ( Dice dice : diceCup.getDices() ) {
      System.out.println(dice);
    }
    System.out.println("-----------");
    System.out.println(diceCup);
    System.out.println("-----------");
    diceCup.printDices();
  }
}