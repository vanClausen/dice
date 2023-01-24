package de.vanclausen.view;

import de.vanclausen.model.Dice;
import de.vanclausen.model.DiceCup;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ResultView extends JPanel {
  private final DiceCup diceCup;
  private List<JLabel> labelList = new ArrayList<>();


  public ResultView( DiceCup diceCup ) {
    this.diceCup = diceCup;
    setLayout( new FlowLayout() );
    setDiceLabels( diceCup );
  }

  public void setDiceLabels( DiceCup diceCup ) {
    for ( JLabel jLabel : labelList ) {
      remove( jLabel );
    }
    labelList.clear();
    for ( Dice dice : diceCup.getDices() ) {
      JLabel jl = new JLabel( String.valueOf( dice.getResult() ), SwingConstants.CENTER );
      jl.setFont( new Font( "sans-serif", Font.PLAIN, 30 ) );
      Color color = Color.decode( dice.getDiceColor().getHexColor() );
      jl.setOpaque( true );
      jl.setBackground( color );
      jl.setForeground( color.equals( Color.WHITE ) ? Color.BLACK : Color.WHITE );
      jl.setBorder( BorderFactory.createRaisedBevelBorder() );
      jl.setHorizontalTextPosition( JLabel.CENTER );
      Dimension d = new Dimension( 80, 80 );
      jl.setPreferredSize( d );
      labelList.add( jl );
    }
    for ( JLabel jLabel : labelList ) {
      add( jLabel );
    }
  }
}
