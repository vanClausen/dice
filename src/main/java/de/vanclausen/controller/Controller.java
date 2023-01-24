package de.vanclausen.controller;

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
  private final ButtonActions buttonActions = new ButtonActions();
  public Controller( DiceCup diceCup, MainView mainView, ResultView resultView ) {

    this.diceCup = diceCup;
    this.mainView = mainView;
    this.resultView = resultView;

    rollDiceButton = new JButton("Roll Dice" );
    rollDiceButton.setBorder( new LineBorder( Color.BLACK, 2, true ) );
    rollDiceButton.setBackground( Color.WHITE );
    rollDiceButton.setForeground( Color.BLACK );
    rollDiceButton.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 20 ) );
//    jButton.setBounds( 0, 0, 100, 100 );
    rollDiceButton.setPreferredSize( new Dimension( 100, 50) );
    rollDiceButton.addActionListener( buttonActions );

    mainView.add( rollDiceButton );

    mainView.setLocationRelativeTo( null );
    mainView.setVisible( true );
  }

  private class ButtonActions implements ActionListener {
    @Override
    public void actionPerformed( ActionEvent e ) {
      diceCup.rollDices();
      resultView.setDiceLabels( diceCup );
      resultView.updateUI();
    }
  }

}
