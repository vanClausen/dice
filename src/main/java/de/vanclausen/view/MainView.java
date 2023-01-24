package de.vanclausen.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainView extends JFrame {

  private final JPanel resultView;
  private final JPanel diceCupView;
//  private JButton jButton;


  public MainView(ResultView resultView, DiceCupView diceCupView) {
    setTitle( "Dice" );
    setSize( 500, 700 );
    setLayout( new FlowLayout(FlowLayout.CENTER, 0, 0) );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    setResizable( false );
    setBackground( Color.RED );

    this.resultView = resultView;
//    resultView.setSize( 500, 450 );
//    resultView.setBorder( new LineBorder( Color.BLACK ) );
    resultView.setPreferredSize( new Dimension(500, 550) );

    this.diceCupView = diceCupView;
    diceCupView.setBackground( Color.gray );

    add( resultView );
//    add( diceCupView );

  }
}
