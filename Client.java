
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;


public class Client extends JApplet
                             implements Runnable {
   private JTextField id;
   private JTextArea display;
   private JPanel boardPanel, panel2;
   private Bubble board[][], currentSquare;
   private Socket connection;
   private DataInputStream input;
   private DataOutputStream output;
   private Thread outputThread;
   private char myMark;
   private char myColor;
   private boolean myTurn;
   private String colors = "";
   private Bubble color;
   private JLabel label;
   private JLabel redlabel;
   private JLabel greenlabel;
   private JTextField score;
   private JTextField redscore;
   int i = 0;
   int j = 0;
  
   public void init()
   {
	  
      display = new JTextArea( 4, 30 );
      display.setFont(new Font("SansSerif", Font.BOLD, 20));
      display.setEditable( false );
      getContentPane().add( new JScrollPane( display ),
                            BorderLayout.SOUTH );
      score = new JTextField();
      score.setPreferredSize(new Dimension(55,50 ));
      score.setFont(new Font("SansSerif", Font.BOLD, 20));
      score.setHorizontalAlignment(JTextField.CENTER);
      redscore = new JTextField();
      redscore.setPreferredSize(new Dimension(55,50 ));
      redscore.setFont(new Font("SansSerif", Font.BOLD, 20));
      redscore.setHorizontalAlignment(JTextField.CENTER);
      boardPanel = new JPanel();
      color = new Bubble();
      label = new JLabel("YOUR COLOR IS :");
      redlabel = new JLabel("RED SCORE IS:");
      greenlabel = new JLabel("GREEN SCORE IS:");
      GridLayout layout = new GridLayout( 8, 8, 3, 3 );
      boardPanel.setLayout( layout );
      board = new Bubble[ 8 ][ 8 ];
      
      for ( int row = 0; row < board.length; row++ )
      {
         for ( int col = 0;
                   col < board[ row ].length; col++ ) {
            board[ row ][ col ] =
               new Bubble( ' ', row * 8 + col );
            board[ row ][ col ].addMouseListener(
               new BubbleListener(
                  this, board[ row ][ col ] ) );

            boardPanel.add( board[ row ][ col ] );        
         }
      }

      id = new JTextField();
      id.setEditable( false );
      
      getContentPane().add( id, BorderLayout.NORTH );
      
      panel2 = new JPanel();
      panel2.add( boardPanel, BorderLayout.CENTER );
     panel2.add(label , BorderLayout.SOUTH);
      panel2.add( color,BorderLayout.EAST);
      panel2.add(greenlabel,BorderLayout.SOUTH);
      panel2.add(score,BorderLayout.SOUTH);
      panel2.add(redlabel,BorderLayout.SOUTH);
      panel2.add(redscore,BorderLayout.SOUTH);
      getContentPane().add( panel2, BorderLayout.CENTER );
      
   }

  
   public void start()
   {
      try {
         connection = new Socket(
            InetAddress.getByName( "127.0.0.1" ), 5120 );
         input = new DataInputStream(
                        connection.getInputStream() );
         output = new DataOutputStream(
                        connection.getOutputStream() );
      }
      catch ( IOException e ) {
         e.printStackTrace();         
      }

      outputThread = new Thread( this );
      outputThread.start();
   }

  
   public void run()
   {
   
      try {
         myMark = input.readChar(); 
         myColor = ( myMark == 'G' ? 'G' : 'R');
         colors = ( myColor == 'G' ? "Green" : "Red");
         color.setColor(myColor);
         color.repaint();
         id.setText( "You are player \"" + colors + "\"" );
         myTurn = ( myMark == 'G' ? true  : false );
      }
      catch ( IOException e ) {
         e.printStackTrace();         
      }

      
      while ( true ) {
         try {
            String s = input.readUTF();
            processMessage( s );
         }
         catch ( IOException e ) {
            e.printStackTrace();         
         }
      }
   }
   public void processScorered(int sum1)
   {
   if(myMark == 'R')
	redscore.setText(""+sum1);
    score.setText(""+i);
   }
   public void processScore(int sum)
   {
	   if(myMark == 'G')
	   score.setText(""+sum);
	   redscore.setText(""+j);
   }

   public void processMessage( String s )
   {
      if ( s.equals( "Valid move." ) ) {
         display.append( "\n" );
         currentSquare.setMark( myMark );
         currentSquare.repaint();
         
		try {
			i = input.readInt();
			j = (int)input.readDouble();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         processScore(i);
         processScorered(j);

      }
      else if ( s.equals( "Invalid move, try again" ) ) {
         display.append( "" + "\n" );
         myTurn = true;
      }
      else if ( s.equals( "Opponent moved" ) ) {
         try {
            int loc = input.readInt();
 
            board[ loc / 8 ][ loc % 8 ].setMark(
                  ( myMark == 'G' ? 'R' : 'G' ) );
            board[ loc / 8 ][ loc % 8 ].repaint();
                 
            display.append(
               "YOUR CHANCE\n\n\n" );
            myTurn = true;
         }
         catch ( IOException e ) {
            e.printStackTrace();         
         }
      }
     else if( s.equals( "R" ))
     {
          display.append( "Game over.Red wins" + "\n" );
     }
     else if( s.equals( "G" ))
     {
          display.append( "Game over.Green wins" + "\n" );
     }
     else if( s.equals( "D" ))
     {
          display.append( "It's a DRAW" + "\n" );
     }
      else
         display.append( s + "\n" );

      display.setCaretPosition(
         display.getText().length() );
   }

   public void sendClickedSquare( int loc )
   {
      if ( myTurn )
         try {
            output.writeInt( loc );
            myTurn = false;
         }
         catch ( IOException ie ) {
            ie.printStackTrace();         
         }
   }

   public void setCurrentSquare( Bubble s )
   {
      currentSquare = s;
   }
	
}
