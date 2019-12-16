import java.awt.*;
import java.applet.Applet;
	
	public class Test04_Thread extends Applet implements Runnable
{
	//����
	int x,y;
	Dimension d;//������Ʈ ũ�� ���Ҷ� ���(â ũ�� ���Ҷ� ����� ���� )
	Thread t;
	Color cols[]={Color.red,Color.blue,Color.green,Color.cyan,Color.magenta};
	
	//������=init()
	public void init(){
		t=new Thread(this);
		t.start();
	}
	//�޼���
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
		d=getSize();//âũ�� ���Ѵ� 
		x=(int)(Math.random()*d.width);
		y=(int)(Math.random()*d.height);
		
		int r=(int)(Math.random()*cols.length);
		g.setColor(cols[r]);
		
		g.drawOval(x,y,20,20);
		g.drawRect(x,y,20,20);
	}//paint 
}//class

