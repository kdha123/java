
import java.awt.*;
import java.applet.*;
public class Test05_Thread extends Applet
	implements Runnable
{
	//����
	int cnt;
	Thread t;
	
	//init()
	public void init()
	{
		cnt=0;
		t=new Thread(this);
		t.start();
	}
	
	//�������̵� 
	public void run(){
		try{
			while(true){
				repaint();
				Thread.sleep(1000);//1 �ʵ��� ���� ���鼭 
				++cnt;// ���� ���� 
			}//while
		}catch(Exception e){}
		
	}//run 
	public void paint(Graphics g)
	{
		g.setFont(new Font("Dailog",Font.BOLD,36));
		
		FontMetrics fm=g.getFontMetrics();//�۲� ���� ����ϱ� ���� 
		
		String str=cnt+"";//���ڸ� ���ڿ��� ��ȯ 
		Dimension d=getSize();//âũ�� ���Ѵ� 
		
		int x=d.width/2 - fm.stringWidth(str)/2;
		g.drawString(str, x, d.height/2);
	}//paint
}

