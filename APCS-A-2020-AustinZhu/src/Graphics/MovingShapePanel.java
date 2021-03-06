package Graphics;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Font; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingShapePanel extends JPanel implements Runnable
{
	private Shape sh;

	public MovingShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);

		//refer sh to a new Shape


		new Thread(this).start();
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("test!",40,40);

		//tell sh to move and draw
		Shape sh = new Shape(getWidth()/2, getHeight()/2, 20, 40, Color.RED, 5, 5);
		window.fillRect(getWidth()/2, getHeight()/2, 20, 40);
		//this code handles the left and right walls
		
		if(!(sh.getX()>=10 && sh.getX()<=730))
		{
			sh.setXSpeed(-sh.getXSpeed());
		}
		

		//add code to handle the top and bottom walls
		/* uncomment once Shape is built
		 *
		if(!(sh.getY()>=10 && sh.getY()<=730))
		{
			sh.setYSpeed(-sh.getYSpeed());
		}
		*/

	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(10);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}