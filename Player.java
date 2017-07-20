import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class Player extends Thread {
   private Socket connection;
   private DataInputStream input;
   private DataOutputStream output;
   private Server control;
   private int number;
   private char mark;
   int sum=0;
   int sum1=0;

   protected boolean threadSuspended = true;

   public Player( Socket s, Server t, int num )
   {
      mark = ( num == 0 ? 'G' : 'R' );
      connection = s;
      
      try {
         input = new DataInputStream(
                    connection.getInputStream() );
         output = new DataOutputStream(
                    connection.getOutputStream() );
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }

      control = t;
      number = num;
   }

   public void otherPlayerMoved( int loc )
   {
      try {
         output.writeUTF( "Opponent moved" );
         output.writeInt( loc );
      }
      catch ( IOException e ) { e.printStackTrace(); }
   }

   public void run()
   {
      boolean done = false;

      try {
         control.display( "Player " +
            ( number == 0 ? 'G' : 'R' ) + " connected" );
         output.writeChar( mark );
       
         output.writeUTF( "Player " +
            ( number == 0 ? "Player Green connected\n" :
                            "Player Red connected, please wait\n" ) );

        
         if ( mark == 'G' ) {
            output.writeUTF( "Waiting for other player to connect" );

            try {
               synchronized( this ) {   
                  while ( threadSuspended )
                     wait();  
               }
            } 
            catch ( InterruptedException e ) {
               e.printStackTrace();
            }

            output.writeUTF(
               "Other player connected. Your move." );
         }

       
         while ( !done ) {
            int location = input.readInt();
       
            if ( control.validMove( location, number ) ) {
               //control.display( "loc: " + location );
               output.writeUTF( "Valid move." );
            }
            else 
               output.writeUTF( "Invalid move, try again" );

            if ( control.gameOver() )
            {
               done = true;
		if(sum > sum1)
		{
	         control.display("Green Player wins");
                 output.writeUTF("G");		
		}	
		else if(sum < sum1)
		{
		control.display("Red Player wins");
                output.writeUTF("R");
		}
		else
		{
		control.display("It's a DRAW");
                output.writeUTF("D");
		}
            }
            else
            {
            	sum = control.sum;
            	sum1 = control.sum1;
            	if(sum % 4 == 0)
            	{
            		output.writeInt(sum);
            	}
            	if(sum1 % 4 == 0)
            	{
            		output.writeDouble(sum1);
            	}
       
            }
       
         }         
	 
         //connection.close();
      }
      catch( IOException e ) {
    	  
         e.printStackTrace();
         System.exit( 1 );
      }
   }
}                    