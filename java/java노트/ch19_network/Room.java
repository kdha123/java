package ch21_network;
import java.util.*; //Vector

public class Room {

	//변수
	Vector uservec=new Vector();//방 사람들 저장 하려고 
	String title,zzang;//방제목, 방장이름
	int inwon;//인원
	
	//생성자 : 대기실 
	public Room(){}
	
	//인자있는 생성자 : 채팅 방에 들어 왔을때 
	public Room(String t,String z,int i){
		title=t;
		zzang=z;
		inwon=i;
	}
}//class
//컴파일만 
