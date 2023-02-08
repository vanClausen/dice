package de.vanclausen;

import de.vanclausen.controller.Controller;
import de.vanclausen.model.DiceColor;
import de.vanclausen.model.DiceCup;
import de.vanclausen.view.DiceCupView;
import de.vanclausen.view.MainView;
import de.vanclausen.view.ResultView;

public class Main {
  public static void main( String[] args ) {

    DiceCup diceCup = new DiceCup( 1, 6, DiceColor.WHITE );
    ResultView resultView = new ResultView(diceCup);
    DiceCupView diceCupView = new DiceCupView(diceCup);
    MainView mainView = new MainView( resultView, diceCupView );
    Controller controller = new Controller(diceCup, mainView, resultView );


//    DiceCup diceCup = new DiceCup( 4, 6, DiceColor.WHITE );
//    System.out.println( Arrays.toString( diceCup.getResults() ) );
//    diceCup.rollDices();
//    System.out.println( Arrays.toString( diceCup.getResults() ) );
//    diceCup.addDice( 6,DiceColor.RED );
//    diceCup.rollDices();
//    System.out.println( Arrays.toString( diceCup.getResults() ) );
//    for ( Dice dice : diceCup.getDices() ) {
//      System.out.println(dice);
//    }
//    System.out.println("-----------");
//    diceCup.rollDices();
//    for ( Dice dice : diceCup.getDices() ) {
//      System.out.println(dice);
//    }
//    System.out.println("-----------");
//    System.out.println(diceCup);
//    System.out.println("-----------");
//    diceCup.printDices();
  }
}