package de.vanclausen.controller;

import de.vanclausen.model.DiceColor;
import de.vanclausen.model.DiceCup;
import de.vanclausen.view.MainView;
import de.vanclausen.view.ResultView;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
  private final DiceCup diceCup;
  private final MainView mainView;
  private final ResultView resultView;
  private JButton rollDiceButton;
  private JButton clearDiceButton;
  private JButton addDiceButton;
  private final ButtonActions buttonActions = new ButtonActions();

  public Controller( DiceCup diceCup, MainView mainView, ResultView resultView ) {

    this.diceCup = diceCup;
    this.mainView = mainView;
    this.resultView = resultView;

    rollDiceButton = new JButton( "Roll dice" );
    rollDiceButton.setBorder( new LineBorder( Color.BLACK, 2, true ) );
    rollDiceButton.setBackground( Color.WHITE );
    rollDiceButton.setForeground( Color.BLACK );
    rollDiceButton.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 15 ) );
    rollDiceButton.setPreferredSize( new Dimension( 120, 50 ) );
    rollDiceButton.addActionListener( buttonActions );

    clearDiceButton = new JButton( "Remove all dice" );
    clearDiceButton.setBorder( new LineBorder( Color.BLACK, 2, true ) );
    clearDiceButton.setBackground( Color.WHITE );
    clearDiceButton.setForeground( Color.BLACK );
    clearDiceButton.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 15 ) );
    clearDiceButton.setPreferredSize( new Dimension( 120, 50 ) );
    clearDiceButton.addActionListener( buttonActions );

    addDiceButton = new JButton( "Add dice" );
    addDiceButton.setBorder( new LineBorder( Color.BLACK, 2, true ) );
    addDiceButton.setBackground( Color.WHITE );
    addDiceButton.setForeground( Color.BLACK );
    addDiceButton.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 15 ) );
    addDiceButton.setPreferredSize( new Dimension( 120, 50 ) );
    addDiceButton.addActionListener( buttonActions );

    mainView.add( rollDiceButton );
    mainView.add( clearDiceButton );
    mainView.add( addDiceButton );

    mainView.setLocationRelativeTo( null );
    mainView.setVisible( true );
  }

  private class ButtonActions implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ) {

      if ( e.getSource().equals( rollDiceButton ) ) {
        diceCup.rollDices();
        resultView.setDiceLabels( diceCup );
        resultView.updateUI();
      }
      if ( e.getSource().equals( clearDiceButton ) ) {
        diceCup.removeDice();
        resultView.setDiceLabels( diceCup );
        resultView.updateUI();
      }
      if ( e.getSource().equals( addDiceButton ) ) {
        diceCup.addDice( 6 , DiceColor.WHITE );
        resultView.setDiceLabels( diceCup );
        resultView.updateUI();
      }
    }
  }

}
