package ch21_network;
import java.util.*; //Vector

public class Room {

	//����
	Vector uservec=new Vector();//�� ����� ���� �Ϸ��� 
	String title,zzang;//������, �����̸�
	int inwon;//�ο�
	
	//������ : ���� 
	public Room(){}
	
	//�����ִ� ������ : ä�� �濡 ��� ������ 
	public Room(String t,String z,int i){
		title=t;
		zzang=z;
		inwon=i;
	}
}//class
//�����ϸ� 
