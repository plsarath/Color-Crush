
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class Server extends JFrame {
   private byte board[];
   private boolean xMove;
   private JTextArea output;
   private Player players[];
   private ServerSocket server;
   private int currentPlayer;
   boolean greenx[]=new boolean[40];
   public int sum = 0;
   public int sum1 = 0;
   boolean occupied[]=new boolean[40];
   boolean redflag[]=new boolean[40];
   boolean redx[]=new boolean[40];
   public  Server()
   {
      super( "Color Crush Server" );

      board = new byte[ 64 ];
      xMove = true;
      players = new Player[ 2 ];
      currentPlayer = 0;
      for(int i=0;i<40;i++)
      {
      occupied[i]= true;
      }
      for(int i=0;i<40;i++)
      {
      redflag[i]= true;
      }
      for(int i=0;i<40;i++)
      {
      redx[i]=true;
      }
      for(int i=0;i<40;i++)
      {
      greenx[i]=true;
      }

     
      try {
         server = new ServerSocket( 5120, 2 );
      }
      catch( IOException e ) {
         e.printStackTrace();
         System.exit( 1 );
      }
      output = new JTextArea();
      output.setFont(new Font("SansSerif", Font.BOLD, 20));
      getContentPane().add( output, BorderLayout.CENTER );
      output.setText( "Server started\n" );

      setSize( 300, 300 );
      show();
   }

  
   public void execute()
   {
      for ( int i = 0; i < players.length; i++ ) {
         try {
            players[ i ] =
               new Player( server.accept(), this, i );
            players[ i ].start();
         }
         catch( IOException e ) {
            e.printStackTrace();
            System.exit( 1 );
         }
      }
        
      synchronized ( players[ 0 ] ) {
         players[ 0 ].threadSuspended = false;   
         players[ 0 ].notify();
      }
   }
   
   public void display( String s )
   {
      output.append( s + "\n" );
   }
 
   public synchronized boolean validMove( int loc,
                                          int player )
   {
      boolean moveDone = false;

      while ( player != currentPlayer ) {
         try {
            wait();
         }
         catch( InterruptedException e ) {
            e.printStackTrace();
         }
      }

      if ( !isOccupied( loc ) ) {
         board[ loc ] =
            (byte) ( currentPlayer == 0 ? 'G' : 'R' );
         currentPlayer = ( currentPlayer + 1 ) % 2;
         players[ currentPlayer ].otherPlayerMoved( loc );
         notify();   
         return true;
      }
      else 
         return false;
   }

   public boolean isOccupied( int loc )
   {
      if ( board[ loc ] == 'G' || board [ loc ] == 'R')
          return true;
      else
          return false;
   }
  
   public boolean gameOver()
   {
int counts = 0;
for(int i = 0; i < 64; i++)
{
	if(isOccupied(i))
	counts++;
	if(counts == 64)
	return true;
}
if (greenx[0]==true && board[ 0 ] == 'G' && board[ 1 ] == 'G' && board[ 2 ] == 'G' && board[ 3 ] == 'G')  
{
sum=sum+4;
      	 
greenx[0]=false;
return false;
}

else if (greenx[1]==true && board[ 1 ] == 'G' && board[ 2 ] == 'G' && board[ 3 ] == 'G' && board[ 4 ] == 'G') 
{
sum=sum+4;
      	 
greenx[1]=false;
return false;
} 
else if (greenx[2]==true && board[ 2 ] == 'G' && board[ 3 ] == 'G' && board[ 4 ] == 'G' && board[ 5 ] == 'G')
{
sum=sum+4;
      	 
greenx[2]=false;
return false;
}  
else if (greenx[3]==true && board[ 3 ] == 'G' && board[ 4 ] == 'G' && board[ 5 ] == 'G' && board[ 6 ] == 'G')
{
sum=sum+4;
      	 
greenx[3]=false;
return false;
}   
else if (greenx[4]==true && board[ 4 ] == 'G' && board[ 5 ] == 'G' && board[ 6 ] == 'G' && board[ 7 ] == 'G')
{
sum=sum+4;
      	 
greenx[4]=false;
return false;
}   
else if (greenx[5]==true && board[ 8 ] == 'G' && board[ 9 ] == 'G' && board[ 10 ] == 'G' && board[ 11 ] == 'G')
{
sum=sum+4;
      	 
greenx[5]=false;
return false;
}  
else if (greenx[6]==true && board[ 9 ] == 'G' && board[ 10 ] == 'G' && board[ 11 ] == 'G' && board[ 12 ] == 'G') 
{
sum=sum+4;
      	 
greenx[6]=false;
return false;
}  
else if (greenx[7]==true && board[ 10 ] == 'G' && board[ 11 ] == 'G' && board[ 12 ] == 'G' && board[ 13 ] == 'G')
{
sum=sum+4;
      	 
greenx[7]=false;
return false;
}  
else if (greenx[8]==true && board[ 11 ] == 'G' && board[ 12 ] == 'G' && board[ 13 ] == 'G' && board[ 14 ] == 'G')
{
sum=sum+4;
      	 
greenx[8]=false;
return false;
}  
else if (greenx[9]==true && board[ 12 ] == 'G' && board[ 13 ] == 'G' && board[ 14 ] == 'G' && board[ 15 ] == 'G')
{
sum=sum+4;
      	 
greenx[9]=false;
return false;
} 
else if (greenx[10]==true && board[ 16 ] == 'G' && board[ 17 ] == 'G' && board[ 18 ] == 'G' && board[ 19 ] == 'G')
{
sum=sum+4;
      	 
greenx[10]=false;
return false;
}  
else if (greenx[11]==true && board[ 17 ] == 'G' && board[ 18 ] == 'G' && board[ 19 ] == 'G' && board[ 20 ] == 'G')
{
sum=sum+4;
      	 
greenx[11]=false;
return false;
}  
else if (greenx[12]==true && board[ 18 ] == 'G' && board[ 19 ] == 'G' && board[ 20 ] == 'G' && board[ 21 ] == 'G') 
{
sum=sum+4;
      	 
greenx[12]=false;
return false;
} 
else if (greenx[13]==true && board[ 19 ] == 'G' && board[ 20 ] == 'G' && board[ 21 ] == 'G' && board[ 22 ] == 'G')
{
sum=sum+4;
      	 
greenx[13]=false;
return false;
}  
else if (greenx[14]==true && board[ 20 ] == 'G' && board[ 21 ] == 'G' && board[ 22 ] == 'G' && board[ 23 ] == 'G')
{
sum=sum+4;
      	 
greenx[14]=false;
return false;
} 
else if (greenx[15]==true && board[ 24 ] == 'G' && board[ 25 ] == 'G' && board[ 26 ] == 'G' && board[ 27 ] == 'G') 
{
sum=sum+4;
      	 
greenx[15]=false;
return false;
} 
else if (greenx[16]==true && board[ 25 ] == 'G' && board[ 26 ] == 'G' && board[ 27 ] == 'G' && board[ 28 ] == 'G')
{
sum=sum+4;
      	 
greenx[16]=false;
return false;
}  
else if (greenx[17]==true && board[ 26 ] == 'G' && board[ 27 ] == 'G' && board[ 28 ] == 'G' && board[ 29 ] == 'G') 
{
sum=sum+4;
      	 
greenx[17]=false;
return false;
} 
else if (greenx[18]==true && board[ 27 ] == 'G' && board[ 28 ] == 'G' && board[ 29 ] == 'G' && board[ 30 ] == 'G') 
{
sum=sum+4;
      	 
greenx[18]=false;
return false;
}
else if (greenx[19]==true && board[ 28 ] == 'G' && board[ 29 ] == 'G' && board[ 30 ] == 'G' && board[ 31 ] == 'G')
{
sum=sum+4;
      	 
greenx[19]=false;
return false;
} 
else if (greenx[20]==true && board[ 32 ] == 'G' && board[ 33 ] == 'G' && board[ 34 ] == 'G' && board[ 35 ] == 'G')
{
sum=sum+4;
      	 
greenx[20]=false;
return false;
}  
else if (greenx[21]==true && board[ 33 ] == 'G' && board[ 34 ] == 'G' && board[ 35 ] == 'G' && board[ 36 ] == 'G') 
{
sum=sum+4;
      	 
greenx[21]=false;
return false;
} 
else if (greenx[22]==true && board[ 34 ] == 'G' && board[ 35 ] == 'G' && board[ 36 ] == 'G' && board[ 37 ] == 'G')
{
sum=sum+4;
      	 
greenx[22]=false;
return false;
}  
else if (greenx[23]==true && board[ 35 ] == 'G' && board[ 36 ] == 'G' && board[ 37 ] == 'G' && board[ 38 ] == 'G')
{
sum=sum+4;
      	 
greenx[23]=false;
return false;
}  
else if (greenx[24]==true && board[ 36 ] == 'G' && board[ 37 ] == 'G' && board[ 38 ] == 'G' && board[ 39 ] == 'G')
{
sum=sum+4;
      	 
greenx[24]=false;
return false;
} 
else if (greenx[25]==true && board[ 40 ] == 'G' && board[ 41 ] == 'G' && board[ 42 ] == 'G' && board[ 43 ] == 'G')
{
sum=sum+4;
      	 
greenx[25]=false;
return false;
}  
else if (greenx[26]==true && board[ 41 ] == 'G' && board[ 42 ] == 'G' && board[ 43 ] == 'G' && board[ 44 ] == 'G')
{
sum=sum+4;
      	 
greenx[26]=false;
return false;
}  
else if (greenx[27]==true && board[ 42 ] == 'G' && board[ 43 ] == 'G' && board[ 44 ] == 'G' && board[ 45 ] == 'G')
{
sum=sum+4;
      	 
greenx[27]=false;
return false;
}  
else if (greenx[28]==true && board[ 43 ] == 'G' && board[ 44 ] == 'G' && board[ 45 ] == 'G' && board[ 46 ] == 'G')
{
sum=sum+4;
      	 
greenx[28]=false;
return false;
}  
else if (greenx[29]==true && board[ 44 ] == 'G' && board[ 45 ] == 'G' && board[ 46 ] == 'G' && board[ 47 ] == 'G')
{
sum=sum+4;
      	 
greenx[29]=false;
return false;
} 
else if (greenx[30]==true && board[ 48 ] == 'G' && board[ 49 ] == 'G' && board[ 50 ] == 'G' && board[ 51 ] == 'G')
{
sum=sum+4;
      	 
greenx[30]=false;
return false;
}  
else if (greenx[31]==true && board[ 49 ] == 'G' && board[ 50 ] == 'G' && board[ 51 ] == 'G' && board[ 52 ] == 'G') 
{
sum=sum+4;
      	 
greenx[31]=false;
return false;
} 
else if (greenx[32]==true && board[ 50 ] == 'G' && board[ 51 ] == 'G' && board[ 52 ] == 'G' && board[ 53 ] == 'G')
{
sum=sum+4;
      	 
greenx[32]=false;
return false;
}  
else if (greenx[33]==true && board[ 51 ] == 'G' && board[ 52 ] == 'G' && board[ 53 ] == 'G' && board[ 54 ] == 'G')
{
sum=sum+4;
      	 
greenx[33]=false;
return false;
}  
else if (greenx[34]==true && board[ 52 ] == 'G' && board[ 53 ] == 'G' && board[ 54 ] == 'G' && board[ 55 ] == 'G')
{
sum=sum+4;
      	 
greenx[34]=false;
return false;
} 
else if (greenx[35]==true && board[ 56 ] == 'G' && board[ 57 ] == 'G' && board[ 58 ] == 'G' && board[ 59 ] == 'G')
{
sum=sum+4;
      	 
greenx[35]=false;
return false;
}  
else if (greenx[36]==true && board[ 57 ] == 'G' && board[ 58 ] == 'G' && board[ 59 ] == 'G' && board[ 60 ] == 'G')
{
sum=sum+4;
      	 
greenx[36]=false;
return false;
}  
else if (greenx[37]==true && board[ 58 ] == 'G' && board[ 59 ] == 'G' && board[ 60 ] == 'G' && board[ 61 ] == 'G')
{
sum=sum+4;
      	 
greenx[37]=false;
return false;
}  
else if (greenx[38]==true && board[ 59 ] == 'G' && board[ 60 ] == 'G' && board[ 61 ] == 'G' && board[ 62 ] == 'G')
{
sum=sum+4;
      	 
greenx[38]=false;
return false;
}  
else if (greenx[39]==true && board[ 60 ] == 'G' && board[ 61 ] == 'G' && board[ 62 ] == 'G' && board[ 63 ] == 'G')
{
sum=sum+4;
      	 
greenx[39]=false;
return false;
} 

else if (occupied[0]==true && board[ 0 ] == 'G' && board[ 8 ] == 'G' && board[ 16 ] == 'G' && board[ 24 ] == 'G')  
{
sum=sum+4;
      	 
occupied[0]=false;
return false;
}

else if (occupied[1]==true && board[ 1 ] == 'G' && board[ 9 ] == 'G' && board[ 17 ] == 'G' && board[ 25 ] == 'G') 
{
sum=sum+4;
      	 
occupied[1]=false;
return false;
} 
else if (occupied[2]==true && board[ 2 ] == 'G' && board[ 10 ] == 'G' && board[ 18 ] == 'G' && board[ 26 ] == 'G')
{
sum=sum+4;
      	 
occupied[2]=false;
return false;
}  
else if (occupied[3]==true && board[ 3 ] == 'G' && board[ 11 ] == 'G' && board[ 19 ] == 'G' && board[ 27 ] == 'G')
{
sum=sum+4;
      	 
occupied[3]=false;
return false;
}   
else if (occupied[4]==true && board[ 4 ] == 'G' && board[ 12 ] == 'G' && board[ 20 ] == 'G' && board[ 28 ] == 'G')
{
sum=sum+4;
      	 
occupied[4]=false;
return false;
}   
else if (occupied[5]==true && board[ 5 ] == 'G' && board[ 13 ] == 'G' && board[ 21 ] == 'G' && board[ 29 ] == 'G')
{
sum=sum+4;
      	 
occupied[5]=false;
return false;
}  
else if (occupied[6]==true && board[ 6 ] == 'G' && board[ 14 ] == 'G' && board[ 22 ] == 'G' && board[ 30 ] == 'G') 
{
sum=sum+4;
      	 
occupied[6]=false;
return false;
}  
else if (occupied[7]==true && board[ 7 ] == 'G' && board[ 15 ] == 'G' && board[ 23 ] == 'G' && board[ 31 ] == 'G')
{
sum=sum+4;
      	 
occupied[7]=false;
return false;
}  
else if (occupied[8]==true && board[ 8 ] == 'G' && board[ 16 ] == 'G' && board[ 24 ] == 'G' && board[ 32 ] == 'G')
{
sum=sum+4;
      	 
occupied[8]=false;
return false;
}  
else if (occupied[9]==true && board[ 9 ] == 'G' && board[ 17 ] == 'G' && board[ 25 ] == 'G' && board[ 33 ] == 'G')
{
sum=sum+4;
      	 
occupied[9]=false;
return false;
} 
else if (occupied[10]==true && board[ 10 ] == 'G' && board[ 18 ] == 'G' && board[ 26 ] == 'G' && board[ 34 ] == 'G')
{
sum=sum+4;
      	 
occupied[10]=false;
return false;
}  
else if (occupied[11]==true && board[ 11 ] == 'G' && board[ 19 ] == 'G' && board[ 27 ] == 'G' && board[ 35 ] == 'G')
{
sum=sum+4;
      	 
occupied[11]=false;
return false;
}  
else if (occupied[12]==true && board[ 12 ] == 'G' && board[ 20 ] == 'G' && board[ 28 ] == 'G' && board[ 36 ] == 'G') 
{
sum=sum+4;
      	 
occupied[12]=false;
return false;
} 
else if (occupied[13]==true && board[ 13 ] == 'G' && board[ 21 ] == 'G' && board[ 29 ] == 'G' && board[ 37 ] == 'G')
{
sum=sum+4;
      	 
occupied[13]=false;
return false;
}  
else if (occupied[14]==true && board[ 14 ] == 'G' && board[ 22 ] == 'G' && board[ 30 ] == 'G' && board[ 38 ] == 'G')
{
sum=sum+4;
      	 
occupied[14]=false;
return false;
} 
else if (occupied[15]==true && board[ 15 ] == 'G' && board[ 23 ] == 'G' && board[ 31 ] == 'G' && board[ 39 ] == 'G') 
{
sum=sum+4;
      	 
occupied[15]=false;
return false;
} 
else if (occupied[16]==true && board[ 16 ] == 'G' && board[ 24 ] == 'G' && board[ 32 ] == 'G' && board[ 40 ] == 'G')
{
sum=sum+4;
      	 
occupied[16]=false;
return false;
}  
else if (occupied[17]==true && board[ 17 ] == 'G' && board[ 25 ] == 'G' && board[ 33 ] == 'G' && board[ 41 ] == 'G') 
{
sum=sum+4;
      	 
occupied[17]=false;
return false;
} 
else if (occupied[18]==true && board[ 18 ] == 'G' && board[ 26 ] == 'G' && board[ 34 ] == 'G' && board[ 42 ] == 'G') 
{
sum=sum+4;
      	 
occupied[18]=false;
return false;
}
else if (occupied[19]==true && board[ 19 ] == 'G' && board[ 27 ] == 'G' && board[ 35 ] == 'G' && board[ 43 ] == 'G')
{
sum=sum+4;
      	 
occupied[19]=false;
return false;
} 
else if (occupied[20]==true && board[ 20 ] == 'G' && board[ 28 ] == 'G' && board[ 36 ] == 'G' && board[ 44 ] == 'G')
{
sum=sum+4;
      	 
occupied[20]=false;
return false;
}  
else if (occupied[21]==true && board[ 21 ] == 'G' && board[ 29 ] == 'G' && board[ 37 ] == 'G' && board[ 45 ] == 'G') 
{
sum=sum+4;
      	 
occupied[21]=false;
return false;
} 
else if (occupied[22]==true && board[ 22 ] == 'G' && board[ 30 ] == 'G' && board[ 38 ] == 'G' && board[ 46 ] == 'G')
{
sum=sum+4;
      	 
occupied[22]=false;
return false;
}  
else if (occupied[23]==true && board[ 23 ] == 'G' && board[ 31 ] == 'G' && board[ 39 ] == 'G' && board[ 47 ] == 'G')
{
sum=sum+4;
      	 
occupied[23]=false;
return false;
}  
else if (occupied[24]==true && board[ 24 ] == 'G' && board[ 32 ] == 'G' && board[ 40 ] == 'G' && board[ 48 ] == 'G')
{
sum=sum+4;
      	 
occupied[24]=false;
return false;
} 
else if (occupied[25]==true && board[ 25 ] == 'G' && board[ 33 ] == 'G' && board[ 41 ] == 'G' && board[ 49 ] == 'G')
{
sum=sum+4;
      	 
occupied[25]=false;
return false;
}  
else if (occupied[26]==true && board[ 26 ] == 'G' && board[ 34 ] == 'G' && board[ 42 ] == 'G' && board[ 50 ] == 'G')
{
sum=sum+4;
      	 
occupied[26]=false;
return false;
}  
else if (occupied[27]==true && board[ 27 ] == 'G' && board[ 35 ] == 'G' && board[ 43 ] == 'G' && board[ 51 ] == 'G')
{
sum=sum+4;
      	 
occupied[27]=false;
return false;
}  
else if (occupied[28]==true && board[ 28 ] == 'G' && board[ 36 ] == 'G' && board[ 44 ] == 'G' && board[ 52 ] == 'G')
{
sum=sum+4;
      	 
occupied[28]=false;
return false;
}  
else if (occupied[29]==true && board[ 29 ] == 'G' && board[ 37 ] == 'G' && board[ 45 ] == 'G' && board[ 53 ] == 'G')
{
sum=sum+4;
      	 
occupied[29]=false;
return false;
} 
else if (occupied[30]==true && board[ 30 ] == 'G' && board[ 38 ] == 'G' && board[ 46 ] == 'G' && board[ 54 ] == 'G')
{
sum=sum+4;
      	 
occupied[30]=false;
return false;
}  
else if (occupied[31]==true && board[ 31 ] == 'G' && board[ 39 ] == 'G' && board[ 47 ] == 'G' && board[ 55 ] == 'G') 
{
sum=sum+4;
      	 
occupied[31]=false;
return false;
} 
else if (occupied[32]==true && board[ 32 ] == 'G' && board[ 40 ] == 'G' && board[ 48 ] == 'G' && board[ 56 ] == 'G')
{
sum=sum+4;
      	 
occupied[32]=false;
return false;
}  
else if (occupied[33]==true && board[ 33 ] == 'G' && board[ 41 ] == 'G' && board[ 49 ] == 'G' && board[ 57 ] == 'G')
{
sum=sum+4;
      	 
occupied[33]=false;
return false;
}  
else if (occupied[34]==true && board[ 34 ] == 'G' && board[ 42 ] == 'G' && board[ 50 ] == 'G' && board[ 58 ] == 'G')
{
sum=sum+4;
      	 
occupied[34]=false;
return false;
} 
else if (occupied[35]==true && board[ 35 ] == 'G' && board[ 43 ] == 'G' && board[ 51 ] == 'G' && board[ 59 ] == 'G')
{
sum=sum+4;
      	 
occupied[35]=false;
return false;
}  
else if (occupied[36]==true && board[ 36 ] == 'G' && board[ 44 ] == 'G' && board[ 52 ] == 'G' && board[ 60 ] == 'G')
{
sum=sum+4;
      	 
occupied[36]=false;
return false;
}  
else if (occupied[37]==true && board[ 37 ] == 'G' && board[ 45 ] == 'G' && board[ 53 ] == 'G' && board[ 61 ] == 'G')
{
sum=sum+4;
      	 
occupied[37]=false;
return false;
}  
else if (occupied[38]==true && board[ 38 ] == 'G' && board[ 46 ] == 'G' && board[ 54 ] == 'G' && board[ 62 ] == 'G')
{
sum=sum+4;
      	 
occupied[38]=false;
return false;
}  
else if (occupied[39]==true && board[ 39 ] == 'G' && board[ 47 ] == 'G' && board[ 55 ] == 'G' && board[ 63 ] == 'G')
{
sum=sum+4;
      	 
occupied[39]=false;
return false;
} 


	   else if (redflag[0]==true && board[ 0 ] == 'R' && board[ 8 ] == 'R' && board[ 16 ] == 'R' && board[ 24 ] == 'R')  
	   {
	   sum1=sum1+4;
	         	  
	   redflag[0]=false;
	   return false;
	   }

	   else if (redflag[1]==true && board[ 1 ] == 'R' && board[ 9 ] == 'R' && board[ 17 ] == 'R' && board[ 25 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[1]=false;
	   return false;
	   } 
	   else if (redflag[2]==true && board[ 2 ] == 'R' && board[ 10 ] == 'R' && board[ 18 ] == 'R' && board[ 26 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[2]=false;
	   return false;
	   }  
	   else if (redflag[3]==true && board[ 3 ] == 'R' && board[ 11 ] == 'R' && board[ 19 ] == 'R' && board[ 27 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[3]=false;
	   return false;
	   }   
	   else if (redflag[4]==true && board[ 4 ] == 'R' && board[ 12 ] == 'R' && board[ 20 ] == 'R' && board[ 28 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[4]=false;
	   return false;
	   }   
	   else if (redflag[5]==true && board[ 5 ] == 'R' && board[ 13 ] == 'R' && board[ 21 ] == 'R' && board[ 29 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[5]=false;
	   return false;
	   }  
	   else if (redflag[6]==true && board[ 6 ] == 'R' && board[ 14 ] == 'R' && board[ 22 ] == 'R' && board[ 30 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[6]=false;
	   return false;
	   }  
	   else if (redflag[7]==true && board[ 7 ] == 'R' && board[ 15 ] == 'R' && board[ 23 ] == 'R' && board[ 31 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[7]=false;
	   return false;
	   }  
	   else if (redflag[8]==true && board[ 8 ] == 'R' && board[ 16 ] == 'R' && board[ 24 ] == 'R' && board[ 32 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[8]=false;
	   return false;
	   }  
	   else if (redflag[9]==true && board[ 9 ] == 'R' && board[ 17 ] == 'R' && board[ 25 ] == 'R' && board[ 33 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[9]=false;
	   return false;
	   } 
	   else if (redflag[10]==true && board[ 10 ] == 'R' && board[ 18 ] == 'R' && board[ 26 ] == 'R' && board[ 34 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[10]=false;
	   return false;
	   }  
	   else if (redflag[11]==true && board[ 11 ] == 'R' && board[ 19 ] == 'R' && board[ 27 ] == 'R' && board[ 35 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[11]=false;
	   return false;
	   }  
	   else if (redflag[12]==true && board[ 12 ] == 'R' && board[ 20 ] == 'R' && board[ 28 ] == 'R' && board[ 36 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[12]=false;
	   return false;
	   } 
	   else if (redflag[13]==true && board[ 13 ] == 'R' && board[ 21 ] == 'R' && board[ 29 ] == 'R' && board[ 37 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[13]=false;
	   return false;
	   }  
	   else if (redflag[14]==true && board[ 14 ] == 'R' && board[ 22 ] == 'R' && board[ 30 ] == 'R' && board[ 38 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[14]=false;
	   return false;
	   } 
	   else if (redflag[15]==true && board[ 15 ] == 'R' && board[ 23 ] == 'R' && board[ 31 ] == 'R' && board[ 39 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[15]=false;
	   return false;
	   } 
	   else if (redflag[16]==true && board[ 16 ] == 'R' && board[ 24 ] == 'R' && board[ 32 ] == 'R' && board[ 40 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[16]=false;
	   return false;
	   }  
	   else if (redflag[17]==true && board[ 17 ] == 'R' && board[ 25 ] == 'R' && board[ 33 ] == 'R' && board[ 41 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[17]=false;
	   return false;
	   } 
	   else if (redflag[18]==true && board[ 18 ] == 'R' && board[ 26 ] == 'R' && board[ 34 ] == 'R' && board[ 42 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[18]=false;
	   return false;
	   }
	   else if (redflag[19]==true && board[ 19 ] == 'R' && board[ 27 ] == 'R' && board[ 35 ] == 'R' && board[ 43 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[19]=false;
	   return false;
	   } 
	   else if (redflag[20]==true && board[ 20 ] == 'R' && board[ 28 ] == 'R' && board[ 36 ] == 'R' && board[ 44 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[20]=false;
	   return false;
	   }  
	   else if (redflag[21]==true && board[ 21 ] == 'R' && board[ 29 ] == 'R' && board[ 37 ] == 'R' && board[ 45 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[21]=false;
	   return false;
	   } 
	   else if (redflag[22]==true && board[ 22 ] == 'R' && board[ 30 ] == 'R' && board[ 38 ] == 'R' && board[ 46 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[22]=false;
	   return false;
	   }  
	   else if (redflag[23]==true && board[ 23 ] == 'R' && board[ 31 ] == 'R' && board[ 39 ] == 'R' && board[ 47 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[23]=false;
	   return false;
	   }  
	   else if (redflag[24]==true && board[ 24 ] == 'R' && board[ 32 ] == 'R' && board[ 40 ] == 'R' && board[ 48 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[24]=false;
	   return false;
	   } 
	   else if (redflag[25]==true && board[ 25 ] == 'R' && board[ 33 ] == 'R' && board[ 41 ] == 'R' && board[ 49 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[25]=false;
	   return false;
	   }  
	   else if (redflag[26]==true && board[ 26 ] == 'R' && board[ 34 ] == 'R' && board[ 42 ] == 'R' && board[ 50 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[26]=false;
	   return false;
	   }  
	   else if (redflag[27]==true && board[ 27 ] == 'R' && board[ 35 ] == 'R' && board[ 43 ] == 'R' && board[ 51 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[27]=false;
	   return false;
	   }  
	   else if (redflag[28]==true && board[ 28 ] == 'R' && board[ 36 ] == 'R' && board[ 44 ] == 'R' && board[ 52 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[28]=false;
	   return false;
	   }  
	   else if (redflag[29]==true && board[ 29 ] == 'R' && board[ 37 ] == 'R' && board[ 45 ] == 'R' && board[ 53 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[29]=false;
	   return false;
	   } 
	   else if (redflag[30]==true && board[ 30 ] == 'R' && board[ 38 ] == 'R' && board[ 46 ] == 'R' && board[ 54 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[30]=false;
	   return false;
	   }  
	   else if (redflag[31]==true && board[ 31 ] == 'R' && board[ 39 ] == 'R' && board[ 47 ] == 'R' && board[ 55 ] == 'R') 
	   {
	   sum1=sum1+4;
	         	  
	   redflag[31]=false;
	   return false;
	   } 
	   else if (redflag[32]==true && board[ 32 ] == 'R' && board[ 40 ] == 'R' && board[ 48 ] == 'R' && board[ 56 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[32]=false;
	   return false;
	   }  
	   else if (redflag[33]==true && board[ 33 ] == 'R' && board[ 41 ] == 'R' && board[ 49 ] == 'R' && board[ 57 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[33]=false;
	   return false;
	   }  
	   else if (redflag[34]==true && board[ 34 ] == 'R' && board[ 42 ] == 'R' && board[ 50 ] == 'R' && board[ 58 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[34]=false;
	   return false;
	   } 
	   else if (redflag[35]==true && board[ 35 ] == 'R' && board[ 43 ] == 'R' && board[ 51 ] == 'R' && board[ 59 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[35]=false;
	   return false;
	   }  
	   else if (redflag[36]==true && board[ 36 ] == 'R' && board[ 44 ] == 'R' && board[ 52 ] == 'R' && board[ 60 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[36]=false;
	   return false;
	   }  
	   else if (redflag[37]==true && board[ 37 ] == 'R' && board[ 45 ] == 'R' && board[ 53 ] == 'R' && board[ 61 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[37]=false;
	   return false;
	   }  
	   else if (redflag[38]==true && board[ 38 ] == 'R' && board[ 46 ] == 'R' && board[ 54 ] == 'R' && board[ 62 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[38]=false;
	   return false;
	   }  
	   else if (redflag[39]==true && board[ 39 ] == 'R' && board[ 47 ] == 'R' && board[ 55 ] == 'R' && board[ 63 ] == 'R')
	   {
	   sum1=sum1+4;
	         	  
	   redflag[39]=false;
	   return false;
	   } 


else if (redx[0]==true && board[ 0 ] == 'R' && board[ 1 ] == 'R' && board[ 2 ] == 'R' && board[ 3 ] == 'R')  
{
sum1=sum1+4;
      	  
redx[0]=false;
return false;
}

else if (redx[1]==true && board[ 1 ] == 'R' && board[ 2 ] == 'R' && board[ 3 ] == 'R' && board[ 4 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[1]=false;
return false;
} 
else if (redx[2]==true && board[ 2 ] == 'R' && board[ 3 ] == 'R' && board[ 4 ] == 'R' && board[ 5 ] == 'R')
{
sum1=sum1+4;
      	  
redx[2]=false;
return false;
}  
else if (redx[3]==true && board[ 3 ] == 'R' && board[ 4 ] == 'R' && board[ 5 ] == 'R' && board[ 6 ] == 'R')
{
sum1=sum1+4;
      	  
redx[3]=false;
return false;
}   
else if (redx[4]==true && board[ 4 ] == 'R' && board[ 5 ] == 'R' && board[ 6 ] == 'R' && board[ 7 ] == 'R')
{
sum1=sum1+4;
      	  
redx[4]=false;
return false;
}   
else if (redx[5]==true && board[ 8 ] == 'R' && board[ 9 ] == 'R' && board[ 10 ] == 'R' && board[ 11 ] == 'R')
{
sum1=sum1+4;
      	  
redx[5]=false;
return false;
}  
else if (redx[6]==true && board[ 9 ] == 'R' && board[ 10 ] == 'R' && board[ 11 ] == 'R' && board[ 12 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[6]=false;
return false;
}  
else if (redx[7]==true && board[ 10 ] == 'R' && board[ 11 ] == 'R' && board[ 12 ] == 'R' && board[ 13 ] == 'R')
{
sum1=sum1+4;
      	  
redx[7]=false;
return false;
}  
else if (redx[8]==true && board[ 11 ] == 'R' && board[ 12 ] == 'R' && board[ 13 ] == 'R' && board[ 14 ] == 'R')
{
sum1=sum1+4;
      	  
redx[8]=false;
return false;
}  
else if (redx[9]==true && board[ 12 ] == 'R' && board[ 13 ] == 'R' && board[ 14 ] == 'R' && board[ 15 ] == 'R')
{
sum1=sum1+4;
      	  
redx[9]=false;
return false;
} 
else if (redx[10]==true && board[ 16 ] == 'R' && board[ 17 ] == 'R' && board[ 18 ] == 'R' && board[ 19 ] == 'R')
{
sum1=sum1+4;
      	  
redx[10]=false;
return false;
}  
else if (redx[11]==true && board[ 17 ] == 'R' && board[ 18 ] == 'R' && board[ 19 ] == 'R' && board[ 20 ] == 'R')
{
sum1=sum1+4;
      	  
redx[11]=false;
return false;
}  
else if (redx[12]==true && board[ 18 ] == 'R' && board[ 19 ] == 'R' && board[ 20 ] == 'R' && board[ 21 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[12]=false;
return false;
} 
else if (redx[13]==true && board[ 19 ] == 'R' && board[ 20 ] == 'R' && board[ 21 ] == 'R' && board[ 22 ] == 'R')
{
sum1=sum1+4;
      	  
redx[13]=false;
return false;
}  
else if (redx[14]==true && board[ 20 ] == 'R' && board[ 21 ] == 'R' && board[ 22 ] == 'R' && board[ 23 ] == 'R')
{
sum1=sum1+4;
      	  
redx[14]=false;
return false;
} 
else if (redx[15]==true && board[ 24 ] == 'R' && board[ 25 ] == 'R' && board[ 26 ] == 'R' && board[ 27 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[15]=false;
return false;
} 
else if (redx[16]==true && board[ 25 ] == 'R' && board[ 26 ] == 'R' && board[ 27 ] == 'R' && board[ 28 ] == 'R')
{
sum1=sum1+4;
      	  
redx[16]=false;
return false;
}  
else if (redx[17]==true && board[ 26 ] == 'R' && board[ 27 ] == 'R' && board[ 28 ] == 'R' && board[ 29 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[17]=false;
return false;
} 
else if (redx[18]==true && board[ 27 ] == 'R' && board[ 28 ] == 'R' && board[ 29 ] == 'R' && board[ 30 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[18]=false;
return false;
}
else if (redx[19]==true && board[ 28 ] == 'R' && board[ 29 ] == 'R' && board[ 30 ] == 'R' && board[ 31 ] == 'R')
{
sum1=sum1+4;
      	  
redx[19]=false;
return false;
} 
else if (redx[20]==true && board[ 32 ] == 'R' && board[ 33 ] == 'R' && board[ 34 ] == 'R' && board[ 35 ] == 'R')
{
sum1=sum1+4;
      	  
redx[20]=false;
return false;
}  
else if (redx[21]==true && board[ 33 ] == 'R' && board[ 34 ] == 'R' && board[ 35 ] == 'R' && board[ 36 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[21]=false;
return false;
} 
else if (redx[22]==true && board[ 34 ] == 'R' && board[ 35 ] == 'R' && board[ 36 ] == 'R' && board[ 37 ] == 'R')
{
sum1=sum1+4;
      	  
redx[22]=false;
return false;
}  
else if (redx[23]==true && board[ 35 ] == 'R' && board[ 36 ] == 'R' && board[ 37 ] == 'R' && board[ 38 ] == 'R')
{
sum1=sum1+4;
      	  
redx[23]=false;
return false;
}  
else if (redx[24]==true && board[ 36 ] == 'R' && board[ 37 ] == 'R' && board[ 38 ] == 'R' && board[ 39 ] == 'R')
{
sum1=sum1+4;
      	  
redx[24]=false;
return false;
} 
else if (redx[25]==true && board[ 40 ] == 'R' && board[ 41 ] == 'R' && board[ 42 ] == 'R' && board[ 43 ] == 'R')
{
sum1=sum1+4;
      	  
redx[25]=false;
return false;
}  
else if (redx[26]==true && board[ 41 ] == 'R' && board[ 42 ] == 'R' && board[ 43 ] == 'R' && board[ 44 ] == 'R')
{
sum1=sum1+4;
      	  
redx[26]=false;
return false;
}  
else if (redx[27]==true && board[ 42 ] == 'R' && board[ 43 ] == 'R' && board[ 44 ] == 'R' && board[ 45 ] == 'R')
{
sum1=sum1+4;
      	  
redx[27]=false;
return false;
}  
else if (redx[28]==true && board[ 43 ] == 'R' && board[ 44 ] == 'R' && board[ 45 ] == 'R' && board[ 46 ] == 'R')
{
sum1=sum1+4;
      	  
redx[28]=false;
return false;
}  
else if (redx[29]==true && board[ 44 ] == 'R' && board[ 45 ] == 'R' && board[ 46 ] == 'R' && board[ 47 ] == 'R')
{
sum1=sum1+4;
      	  
redx[29]=false;
return false;
} 
else if (redx[30]==true && board[ 48 ] == 'R' && board[ 49 ] == 'R' && board[ 50 ] == 'R' && board[ 51 ] == 'R')
{
sum1=sum1+4;
      	  
redx[30]=false;
return false;
}  
else if (redx[31]==true && board[ 49 ] == 'R' && board[ 50 ] == 'R' && board[ 51 ] == 'R' && board[ 52 ] == 'R') 
{
sum1=sum1+4;
      	  
redx[31]=false;
return false;
} 
else if (redx[32]==true && board[ 50 ] == 'R' && board[ 51 ] == 'R' && board[ 52 ] == 'R' && board[ 53 ] == 'R')
{
sum1=sum1+4;
      	  
redx[32]=false;
return false;
}  
else if (redx[33]==true && board[ 51 ] == 'R' && board[ 52 ] == 'R' && board[ 53 ] == 'R' && board[ 54 ] == 'R')
{
sum1=sum1+4;
      	  
redx[33]=false;
return false;
}  
else if (redx[34]==true && board[ 52 ] == 'R' && board[ 53 ] == 'R' && board[ 54 ] == 'R' && board[ 55 ] == 'R')
{
sum1=sum1+4;
      	  
redx[34]=false;
return false;
} 
else if (redx[35]==true && board[ 56 ] == 'R' && board[ 57 ] == 'R' && board[ 58 ] == 'R' && board[ 59 ] == 'R')
{
sum1=sum1+4;
      	  
redx[35]=false;
return false;
}  
else if (redx[36]==true && board[ 57 ] == 'R' && board[ 58 ] == 'R' && board[ 59 ] == 'R' && board[ 60 ] == 'R')
{
sum1=sum1+4;
      	  
redx[36]=false;
return false;
}  
else if (redx[37]==true && board[ 58 ] == 'R' && board[ 59 ] == 'R' && board[ 60 ] == 'R' && board[ 61 ] == 'R')
{
sum1=sum1+4;
      	  
redx[37]=false;
return false;
}  
else if (redx[38]==true && board[ 59 ] == 'R' && board[ 60 ] == 'R' && board[ 61 ] == 'R' && board[ 62 ] == 'R')
{
sum1=sum1+4;
      	  
redx[38]=false;
return false;
}  
else if (redx[39]==true && board[ 60 ] == 'R' && board[ 61 ] == 'R' && board[ 62 ] == 'R' && board[ 63 ] == 'R')
{
sum1=sum1+4;
      	  
redx[39]=false;
return false;
} 
else
return false;
}

   public static void main( String args[] )
   {
      Server game = new Server();

      game.addWindowListener( new WindowAdapter() {
        public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );

      game.execute();
   }
}


                                       