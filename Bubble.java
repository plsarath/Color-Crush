import java.awt.Color;
import java.util.Random;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

class Bubble extends JPanel {
   private char mark;
   private int location;
   private int count = 0;
   private char color;
  public Bubble()
  {
	  count++;
	  
  }
   public Bubble( char m, int loc)
   {
      mark = m;
      location = loc;
      setSize ( 50, 50 );
      
      setVisible(true);
   }

   public Dimension getPreferredSize() { 
      return ( new Dimension( 80, 80 ) );
   }

   public Dimension getMinimumSize() {
      return ( getPreferredSize() );
   }

   public void setMark( char c ) { mark = c; }
   
 public void setColor(char c) { color = c;}

   public int getSquareLocation() { return location; }

   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      g.setColor(Color.black);
      g.drawOval( 0, 0, 60, 60 );
      if(color == 'G')
      {
    	  g.setColor(Color.green);
    	  g.fillOval(0, 0, 60, 60);
      }
      else if(color == 'R')
      {
    	  g.setColor(Color.red);
    	  g.fillOval(0, 0, 60, 60);
      }
    	  //g.drawString( String.valueOf( mark ), 11, 20 );
      if(mark == 'G')
      {
    	  g.setColor(Color.green);
    	  g.fillOval(0, 0, 60, 60);
      }
      else if(mark == 'R')
      {
    	  g.setColor(Color.red);
    	  g.fillOval(0, 0, 60, 60);
      }
    	
   }
}