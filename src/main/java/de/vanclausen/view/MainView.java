package de.vanclausen.view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

  private final JPanel resultView;


  public MainView(ResultView resultView) {
    setTitle( "Dice" );
    setSize( 500, 700 );
    setLayout( new FlowLayout(FlowLayout.CENTER, 0, 0) );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    setResizable( false );
    setBackground( Color.RED );

    this.resultView = resultView;
    resultView.setPreferredSize( new Dimension(500, 550) );

    add( resultView );
  }
}
