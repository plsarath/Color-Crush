import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class BubbleListener extends MouseAdapter {
   private Client applet;
   private Bubble bubble;

   public BubbleListener( Client t, Bubble s )
   {
      applet = t;
      bubble = s;
   }

   public void mouseReleased( MouseEvent e )
   {
      applet.setCurrentSquare( bubble );
      applet.sendClickedSquare( bubble.getSquareLocation() );
   }
}