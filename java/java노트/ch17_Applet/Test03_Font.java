 
import java.awt.*;

public class Test03_Font extends java.applet.Applet
{
 
	public void paint(Graphics g){
		int baseLine=100;//����
		g.setColor(Color.lightGray);
		g.drawLine(0,baseLine,250,baseLine);
		
		g.setFont(new Font("Dialog",Font.BOLD,30));
		g.setColor(Color.black);
		g.drawString("�ڹ� �ȳ� hi good",10,baseLine);
	}
}

