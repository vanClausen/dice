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
  private JComboBox colorChoice;
  private JComboBox sideChoice;
  private final ButtonActions buttonActions = new ButtonActions();

  public Controller( DiceCup diceCup, MainView mainView, ResultView resultView ) {

    this.diceCup = diceCup;
    this.mainView = mainView;
    this.resultView = resultView;

    int buttonWidth = 150;
    int buttonHeight = 50;

    rollDiceButton = new JButton( "Roll Dice" );
    rollDiceButton.setBorder( new LineBorder( Color.BLACK, 2, true ) );
    rollDiceButton.setBackground( Color.WHITE );
    rollDiceButton.setForeground( Color.BLACK );
    rollDiceButton.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 15 ) );
    rollDiceButton.setPreferredSize( new Dimension( buttonWidth, buttonHeight ) );
    rollDiceButton.addActionListener( buttonActions );

    clearDiceButton = new JButton( "Reset Dice Cup" );
    clearDiceButton.setBorder( new LineBorder( Color.BLACK, 2, true ) );
    clearDiceButton.setBackground( Color.WHITE );
    clearDiceButton.setForeground( Color.BLACK );
    clearDiceButton.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 15 ) );
    clearDiceButton.setPreferredSize( new Dimension( buttonWidth, buttonHeight ) );
    clearDiceButton.addActionListener( buttonActions );

    addDiceButton = new JButton( "Add Dice" );
    addDiceButton.setBorder( new LineBorder( Color.BLACK, 2, true ) );
    addDiceButton.setBackground( Color.WHITE );
    addDiceButton.setForeground( Color.BLACK );
    addDiceButton.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 15 ) );
    addDiceButton.setPreferredSize( new Dimension( buttonWidth, buttonHeight ) );
    addDiceButton.addActionListener( buttonActions );

    JLabel newDiceColor = new JLabel("New Dice Color: ");

    colorChoice = new JComboBox();
    for ( DiceColor color : DiceColor.class.getEnumConstants() ) {
      colorChoice.addItem( color );
    }
    colorChoice.setSelectedItem( DiceColor.WHITE );

    JLabel newDiceSides = new JLabel("New Dice Sides: ");

    sideChoice = new JComboBox();
    for ( int i = 1; i <= 20; i++ ) {
      sideChoice.addItem( i );
    }
    sideChoice.setSelectedItem( 6 );

    mainView.add( rollDiceButton );
    mainView.add( clearDiceButton );
    mainView.add( addDiceButton );
    mainView.add( newDiceColor );
    mainView.add( colorChoice );
    mainView.add( newDiceSides );
    mainView.add( sideChoice );

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
        diceCup.addDice( ( int ) sideChoice.getSelectedItem(), ( DiceColor ) colorChoice.getSelectedItem() );
        resultView.setDiceLabels( diceCup );
        resultView.updateUI();
      }
    }
  }

}
