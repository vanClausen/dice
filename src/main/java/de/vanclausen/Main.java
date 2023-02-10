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
//    DiceCupView diceCupView = new DiceCupView(diceCup);
    MainView mainView = new MainView( resultView );
    Controller controller = new Controller(diceCup, mainView, resultView );
  }
}