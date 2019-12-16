/*########################
# 프로토콜        
# 사용중인 닉네임이 있을때 1000
# 대기실 입장  100       #
# 방만들기     200       #
# 방들어가기   210       #
# 방에서메시지 400       #
# 대화명변경   420       #
# 귓속말       450       #
# 방퇴장       290       #
# 종료         900       #
##########################
 */
package ch21_network;
import java.awt.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class Server extends Frame 
implements Runnable{
  //변수
  Vector globalvc=new Vector();//입장하는 모든클라이언트 넣을 공간
  Vector roomvc=new Vector();//방이름 넣을려고
  TextArea ta=new TextArea();//서버 정보 출력하려고
  
  //생성자
  public Server(){
    ta.setFont(new Font("Dialog",Font.BOLD,12));
    this.add("Center",ta);
    setSize(500,300);
    setVisible(true);
  }//생성자 end 
  
  public static void main(String[] args) {
    new Thread(new Server()).start();//시작, run() 호출 
  }//main end 
  
  //메서드
  public void run(){
    ServerSocket ss=null;
    try{
      ss=new ServerSocket(7777);//서버 구동 0~65535
      System.out.println("서버 구동중 ^.^");
      
    }catch(Exception ex){
      ta.append("서버 구동 실패");
      System.exit(0);//종료
    }//catch end 
    
    ta.append("서버 실행되었음, 클라이언트 접속을 기다리는 중... \n");
    Socket s=null;
    
    while(true){
      try{
        s=ss.accept();//클라이언트 요청을 받고, 소켓연결 
        ta.append("client 접속:"+s+"\n");
        
        Service ser=new Service(s);//객체 생성 
        
      }catch(Exception ex){}
    }//while end 
  }//run end 
   
  //inner class
  class Service extends Thread{
    //변수
    BufferedReader in;
    OutputStream out;
    
    Room myroom=new Room();// 클라이언트 1명당 Room생성, 대기실
    String name="";//대화명 변수 
    
    //생성자 
    public Service(Socket s){
      try{
        out=s.getOutputStream();
        in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        name=in.readLine();//대화명 읽어옴
        myroom.title="대기실";
        
        //String s3=s.getInetAddress().getHostAddress();//ip 얻기
        /*
        if(s3.equals("211.183.0.91")){
        System.out.println("211.183.0.91 이 ip 사용 불가능 합니다");//
        putMsgTo("100|211.183.0.91 이 ip 사용 불가능 합니다");
        return ;
        }*/
        
        
      }catch(Exception ex){
        ta.append("client와 연결 불안전"+s+"\n");
      }
      
      //모든 클라이언트에게 , 현재 접속자를 보낸다 
      for(int i=0; i<globalvc.size(); i++){
        
        try{
          Service ser=(Service)globalvc.get(i);
          
          if(name.equals(ser.name)){
            putMsgTo("1000|"+name+" 은 사용중인 대화명 입니다");
            return;
          }
          
          //클라이언트들에게  보낸다 
          putMsgTo("100|"+ser.name+"|"+ser.myroom.title);
          
        }catch(Exception ex){globalvc.remove(i--);}
      }//for end ------------------------
      
      //현재 접속자에게 개설된 방정보를 보낸다 
      for(int i=0; i<roomvc.size(); i++){
        Room r=(Room)roomvc.get(i);//방을 꺼내어
        try{
          putMsgTo("200|"+r.title+"|"+r.inwon);
        }catch(Exception ex){}
      }//for end 
      
      globalvc.add(this);//현재 접속자를 대기실에 넣는다 
      putMsgAll("100|"+name+"|"+myroom.title);
      //접속자가 대기실에 들어왔음을 모든클라이언트 에게 알린다
      
      start();//시작 , run() 호출 
    }//생성자 end 
    //--------------------------------------
    public void run(){
      while(true){
        try{
        	
          //변수
          String msg=in.readLine();//클라이언트가 보낸 msg받는다
          if(msg==null){return;}
          
         // ta.append(name+">"+msg+"\n");
          
          StringTokenizer token=new StringTokenizer(msg,"|");
          int protocol=Integer.parseInt(token.nextToken());
          
          switch(protocol){
            
          case 200:{//방만들기 
              
              String t=token.nextToken();//방제목 
              String flag="";//변수
              
              for(int i=0; i<roomvc.size();i++){
                Room r=(Room)roomvc.get(i);//방이름을 꺼낸다
                
                if(t.equals(r.title)){//사용중인 대화방 
                   
                  putMsgTo("2000|"+t+" 는 사용중인 대화방 입니다");
                  flag=t;//
                  break; //for 탈출 
                }//if
              }//for
               
              if(!flag.equals(t)){

            	  myroom=new Room(t,name,1);//방제목,방장,인원
            	  
            	  myroom.uservec.add(this);//대화방에 저장
            	  
            	  roomvc.add(myroom);//방이름 저장 
            	  
            	  putMsgAll("200|"+myroom.title+"|"+0);//방이 개설 되었음을 모든 클라이언트에게 보낸다
            	  putMsgAll("210|"+name+"|"+myroom.title);//방들어왔다는 것을 모든 클라이언트에게 알린다
              } 
                
            }//case 200
            break;
            
          case 210:{//방들어가기, 다른 클라이언트 가들어올때 
        	  
              String t=token.nextToken();//방제목
              
              for(int i=0; i<roomvc.size();i++){
            	  
                Room r=(Room)roomvc.get(i);//방이름을 꺼낸다
                
                if(t.equals(r.title)){//방을 찾았으면
                  myroom=r;
                  myroom.uservec.add(this);//대화방에 넣는다 
                  myroom.inwon++;//인원 증가 
                  
                  //클라이언트에게 보내주는 메서드 호출 
                  putMsgAll("210|"+name+"|"+myroom.title);
                  break;//for문 탈출 
                }//if
              }//for
            }//case 210
            break;
            
          case 400://방에서 대화하기 
            {
              putMsgRoom("400|"+name+" 님의 말>>"+token.nextToken());
              //                         메시지
            }
            break;
            
          case 290:{//방퇴장 
              myroom.uservec.remove(this);//방에서 제거 
              myroom.inwon=myroom.uservec.size();//인원 정리 
              
              if(myroom.inwon==0){
                roomvc.remove(myroom);//방제거
              }//if
              
              //클라이언트에게  보내는 메서드 호출 
              putMsgAll("290|"+name+"|"+myroom.title);//방에서 나갔음을 모두에게 알린다 
              
              myroom=new Room();
              myroom.title="대기실";
            }//case 290
            break;
            
            
          case 420://대화명 변경
            {
              String newName=token.nextToken();// 새로운 대화명을 읽어온다 
              
              //모든 클라이언트에게 메서드 호출
              putMsgAll("420|"+name+"|"+newName+"|"+myroom.title);
              
              name=newName;
            }
            break;
            
            
            
          case 450://귀속말
            {
              String sayName=token.nextToken();//귓속말 보낼 대상 
              String sayC=token.nextToken();//귓속말 내용 
              
              //대화방에서 귓속말 보낼 상대를 찾아낸다 
              for(int i=0;i<myroom.uservec.size();i++){ 
                
                Service ser=(Service)myroom.uservec.get(i);
                
                if(sayName.equals(ser.name)){ 
                  try{	
                    ser.putMsgTo("450|"+name+"|"+sayC);
                    
                  }catch(Exception ex)
                  {
                	  myroom.uservec.remove(ser);
                  }
                  break;//for 탈출
                }//if
              }//for
            }//450
            break;
            
            
            
          case 900:{//종료 ( 채팅방사이트에서  나간 클라이언트 ) 
              globalvc.remove(this);//전체 대기실에서 제거 
              
              //모든 클라이언트 에게 보내준다 
              putMsgAll("900|"+name+"|"+myroom.title);//모두에게 알린다 
              
              if(!myroom.title.equals("대기실")){
                //대화방에서 나갔으면
                
            	myroom.uservec.remove(this);//방에서 제거 
                if(--myroom.inwon==0){
                  roomvc.remove(myroom);//방제거 
                }//if
                try{
                  in.close();
                  out.close();
                }catch(Exception ex){}
              }//if
              
              return;// 서버는 계속 작업을 해주게 한다 *****
              
            }//case 900
            //break;
            
            
          }//switch end 
        }catch(Exception ex){
        	return;
        }
      }//while end
    }//run end 
    //------------------------------------
    
    
    //사용자 정의 메서드 ,모든 클라이언트에게 메시지 전달 
    public void putMsgAll(String msg){
      synchronized (this) {
    	  
        for(int i=0;i<globalvc.size(); i++){
          try{
            Service ser=(Service)globalvc.get(i);
            ser.putMsgTo(msg);//메서드 호출
          }catch(Exception ex){globalvc.remove(i--);}
        }//for
        
      }//synchronized end 
    }//putMsgAll() end
    //-------------------------------
    
    //사용자 정의 메서드 , 방에서 대화하기    
    public void putMsgRoom(String msg){ 
      synchronized (this) {
    	  
        for(int i=0; i<myroom.uservec.size(); i++){
          try{
            Service ser=(Service)myroom.uservec.get(i);
            ser.putMsgTo(msg);//메서드 호출 
          }catch(Exception ex){myroom.uservec.remove(i--);}
        }//for
        
      }//synchronized end 
    }//putMsgRoom() end--------------------------------- 
    
    public void putMsgTo(String msg) throws Exception{
      synchronized (this) {
        
    	//클라이언트로 msg 전송
        out.write((msg+"\r\n").getBytes()); 
        //getBytes()는 인코딩 처리하는 메서드
        
      }//synchronized end
    }//putMsgTo() end 
    
  }//inner class end 
}//outter class end 
