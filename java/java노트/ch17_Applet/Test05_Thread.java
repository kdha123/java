
import java.awt.*;
import java.applet.*;
public class Test05_Thread extends Applet
	implements Runnable
{
	//변수
	int cnt;
	Thread t;
	
	//init()
	public void init()
	{
		cnt=0;
		t=new Thread(this);
		t.start();
	}
	
	//오버라이딩 
	public void run(){
		try{
			while(true){
				repaint();
				Thread.sleep(1000);//1 초동안 쉬어 가면서 
				++cnt;// 숫자 증가 
			}//while
		}catch(Exception e){}
		
	}//run 
	public void paint(Graphics g)
	{
		g.setFont(new Font("Dailog",Font.BOLD,36));
		
		FontMetrics fm=g.getFontMetrics();//글꼴 정보 사용하기 위해 
		
		String str=cnt+"";//숫자를 문자열로 변환 
		Dimension d=getSize();//창크기 구한다 
		
		int x=d.width/2 - fm.stringWidth(str)/2;
		g.drawString(str, x, d.height/2);
	}//paint
}

