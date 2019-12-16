/*########################
# ��������        
# ������� �г����� ������ 1000
# ���� ����  100       #
# �游���     200       #
# �����   210       #
# �濡���޽��� 400       #
# ��ȭ����   420       #
# �ӼӸ�       450       #
# ������       290       #
# ����         900       #
##########################
 */
package ch21_network;
import java.awt.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class Server extends Frame 
implements Runnable{
  //����
  Vector globalvc=new Vector();//�����ϴ� ���Ŭ���̾�Ʈ ���� ����
  Vector roomvc=new Vector();//���̸� ��������
  TextArea ta=new TextArea();//���� ���� ����Ϸ���
  
  //������
  public Server(){
    ta.setFont(new Font("Dialog",Font.BOLD,12));
    this.add("Center",ta);
    setSize(500,300);
    setVisible(true);
  }//������ end 
  
  public static void main(String[] args) {
    new Thread(new Server()).start();//����, run() ȣ�� 
  }//main end 
  
  //�޼���
  public void run(){
    ServerSocket ss=null;
    try{
      ss=new ServerSocket(7777);//���� ���� 0~65535
      System.out.println("���� ������ ^.^");
      
    }catch(Exception ex){
      ta.append("���� ���� ����");
      System.exit(0);//����
    }//catch end 
    
    ta.append("���� ����Ǿ���, Ŭ���̾�Ʈ ������ ��ٸ��� ��... \n");
    Socket s=null;
    
    while(true){
      try{
        s=ss.accept();//Ŭ���̾�Ʈ ��û�� �ް�, ���Ͽ��� 
        ta.append("client ����:"+s+"\n");
        
        Service ser=new Service(s);//��ü ���� 
        
      }catch(Exception ex){}
    }//while end 
  }//run end 
   
  //inner class
  class Service extends Thread{
    //����
    BufferedReader in;
    OutputStream out;
    
    Room myroom=new Room();// Ŭ���̾�Ʈ 1��� Room����, ����
    String name="";//��ȭ�� ���� 
    
    //������ 
    public Service(Socket s){
      try{
        out=s.getOutputStream();
        in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        name=in.readLine();//��ȭ�� �о��
        myroom.title="����";
        
        //String s3=s.getInetAddress().getHostAddress();//ip ���
        /*
        if(s3.equals("211.183.0.91")){
        System.out.println("211.183.0.91 �� ip ��� �Ұ��� �մϴ�");//
        putMsgTo("100|211.183.0.91 �� ip ��� �Ұ��� �մϴ�");
        return ;
        }*/
        
        
      }catch(Exception ex){
        ta.append("client�� ���� �Ҿ���"+s+"\n");
      }
      
      //��� Ŭ���̾�Ʈ���� , ���� �����ڸ� ������ 
      for(int i=0; i<globalvc.size(); i++){
        
        try{
          Service ser=(Service)globalvc.get(i);
          
          if(name.equals(ser.name)){
            putMsgTo("1000|"+name+" �� ������� ��ȭ�� �Դϴ�");
            return;
          }
          
          //Ŭ���̾�Ʈ�鿡��  ������ 
          putMsgTo("100|"+ser.name+"|"+ser.myroom.title);
          
        }catch(Exception ex){globalvc.remove(i--);}
      }//for end ------------------------
      
      //���� �����ڿ��� ������ �������� ������ 
      for(int i=0; i<roomvc.size(); i++){
        Room r=(Room)roomvc.get(i);//���� ������
        try{
          putMsgTo("200|"+r.title+"|"+r.inwon);
        }catch(Exception ex){}
      }//for end 
      
      globalvc.add(this);//���� �����ڸ� ���ǿ� �ִ´� 
      putMsgAll("100|"+name+"|"+myroom.title);
      //�����ڰ� ���ǿ� �������� ���Ŭ���̾�Ʈ ���� �˸���
      
      start();//���� , run() ȣ�� 
    }//������ end 
    //--------------------------------------
    public void run(){
      while(true){
        try{
        	
          //����
          String msg=in.readLine();//Ŭ���̾�Ʈ�� ���� msg�޴´�
          if(msg==null){return;}
          
         // ta.append(name+">"+msg+"\n");
          
          StringTokenizer token=new StringTokenizer(msg,"|");
          int protocol=Integer.parseInt(token.nextToken());
          
          switch(protocol){
            
          case 200:{//�游��� 
              
              String t=token.nextToken();//������ 
              String flag="";//����
              
              for(int i=0; i<roomvc.size();i++){
                Room r=(Room)roomvc.get(i);//���̸��� ������
                
                if(t.equals(r.title)){//������� ��ȭ�� 
                   
                  putMsgTo("2000|"+t+" �� ������� ��ȭ�� �Դϴ�");
                  flag=t;//
                  break; //for Ż�� 
                }//if
              }//for
               
              if(!flag.equals(t)){

            	  myroom=new Room(t,name,1);//������,����,�ο�
            	  
            	  myroom.uservec.add(this);//��ȭ�濡 ����
            	  
            	  roomvc.add(myroom);//���̸� ���� 
            	  
            	  putMsgAll("200|"+myroom.title+"|"+0);//���� ���� �Ǿ����� ��� Ŭ���̾�Ʈ���� ������
            	  putMsgAll("210|"+name+"|"+myroom.title);//����Դٴ� ���� ��� Ŭ���̾�Ʈ���� �˸���
              } 
                
            }//case 200
            break;
            
          case 210:{//�����, �ٸ� Ŭ���̾�Ʈ �����ö� 
        	  
              String t=token.nextToken();//������
              
              for(int i=0; i<roomvc.size();i++){
            	  
                Room r=(Room)roomvc.get(i);//���̸��� ������
                
                if(t.equals(r.title)){//���� ã������
                  myroom=r;
                  myroom.uservec.add(this);//��ȭ�濡 �ִ´� 
                  myroom.inwon++;//�ο� ���� 
                  
                  //Ŭ���̾�Ʈ���� �����ִ� �޼��� ȣ�� 
                  putMsgAll("210|"+name+"|"+myroom.title);
                  break;//for�� Ż�� 
                }//if
              }//for
            }//case 210
            break;
            
          case 400://�濡�� ��ȭ�ϱ� 
            {
              putMsgRoom("400|"+name+" ���� ��>>"+token.nextToken());
              //                         �޽���
            }
            break;
            
          case 290:{//������ 
              myroom.uservec.remove(this);//�濡�� ���� 
              myroom.inwon=myroom.uservec.size();//�ο� ���� 
              
              if(myroom.inwon==0){
                roomvc.remove(myroom);//������
              }//if
              
              //Ŭ���̾�Ʈ����  ������ �޼��� ȣ�� 
              putMsgAll("290|"+name+"|"+myroom.title);//�濡�� �������� ��ο��� �˸��� 
              
              myroom=new Room();
              myroom.title="����";
            }//case 290
            break;
            
            
          case 420://��ȭ�� ����
            {
              String newName=token.nextToken();// ���ο� ��ȭ���� �о�´� 
              
              //��� Ŭ���̾�Ʈ���� �޼��� ȣ��
              putMsgAll("420|"+name+"|"+newName+"|"+myroom.title);
              
              name=newName;
            }
            break;
            
            
            
          case 450://�ͼӸ�
            {
              String sayName=token.nextToken();//�ӼӸ� ���� ��� 
              String sayC=token.nextToken();//�ӼӸ� ���� 
              
              //��ȭ�濡�� �ӼӸ� ���� ��븦 ã�Ƴ��� 
              for(int i=0;i<myroom.uservec.size();i++){ 
                
                Service ser=(Service)myroom.uservec.get(i);
                
                if(sayName.equals(ser.name)){ 
                  try{	
                    ser.putMsgTo("450|"+name+"|"+sayC);
                    
                  }catch(Exception ex)
                  {
                	  myroom.uservec.remove(ser);
                  }
                  break;//for Ż��
                }//if
              }//for
            }//450
            break;
            
            
            
          case 900:{//���� ( ä�ù����Ʈ����  ���� Ŭ���̾�Ʈ ) 
              globalvc.remove(this);//��ü ���ǿ��� ���� 
              
              //��� Ŭ���̾�Ʈ ���� �����ش� 
              putMsgAll("900|"+name+"|"+myroom.title);//��ο��� �˸��� 
              
              if(!myroom.title.equals("����")){
                //��ȭ�濡�� ��������
                
            	myroom.uservec.remove(this);//�濡�� ���� 
                if(--myroom.inwon==0){
                  roomvc.remove(myroom);//������ 
                }//if
                try{
                  in.close();
                  out.close();
                }catch(Exception ex){}
              }//if
              
              return;// ������ ��� �۾��� ���ְ� �Ѵ� *****
              
            }//case 900
            //break;
            
            
          }//switch end 
        }catch(Exception ex){
        	return;
        }
      }//while end
    }//run end 
    //------------------------------------
    
    
    //����� ���� �޼��� ,��� Ŭ���̾�Ʈ���� �޽��� ���� 
    public void putMsgAll(String msg){
      synchronized (this) {
    	  
        for(int i=0;i<globalvc.size(); i++){
          try{
            Service ser=(Service)globalvc.get(i);
            ser.putMsgTo(msg);//�޼��� ȣ��
          }catch(Exception ex){globalvc.remove(i--);}
        }//for
        
      }//synchronized end 
    }//putMsgAll() end
    //-------------------------------
    
    //����� ���� �޼��� , �濡�� ��ȭ�ϱ�    
    public void putMsgRoom(String msg){ 
      synchronized (this) {
    	  
        for(int i=0; i<myroom.uservec.size(); i++){
          try{
            Service ser=(Service)myroom.uservec.get(i);
            ser.putMsgTo(msg);//�޼��� ȣ�� 
          }catch(Exception ex){myroom.uservec.remove(i--);}
        }//for
        
      }//synchronized end 
    }//putMsgRoom() end--------------------------------- 
    
    public void putMsgTo(String msg) throws Exception{
      synchronized (this) {
        
    	//Ŭ���̾�Ʈ�� msg ����
        out.write((msg+"\r\n").getBytes()); 
        //getBytes()�� ���ڵ� ó���ϴ� �޼���
        
      }//synchronized end
    }//putMsgTo() end 
    
  }//inner class end 
}//outter class end 
