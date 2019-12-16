import java.awt.*;
import java.applet.Applet;
	
	public class Test04_Thread extends Applet implements Runnable
{
	//변수
	int x,y;
	Dimension d;//컴포넌트 크기 구할때 사용(창 크기 구할때 사용할 것임 )
	Thread t;
	Color cols[]={Color.red,Color.blue,Color.green,Color.cyan,Color.magenta};
	
	//생성자=init()
	public void init(){
		t=new Thread(this);
		t.start();
	}
	//메서드
	public void run(){
		try{
			while(true){
				repaint();
				Thread.sleep(100);
			}//while
		}catch(Exception ex){}
	}//run
	
	public void update(Graphics g){
		paint(g);
	}
	public void paint(Graphics g){
		d=getSize();//창크기 구한다 
		x=(int)(Math.random()*d.width);
		y=(int)(Math.random()*d.height);
		
		int r=(int)(Math.random()*cols.length);
		g.setColor(cols[r]);
		
		g.drawOval(x,y,20,20);
		g.drawRect(x,y,20,20);
	}//paint 
}//class

