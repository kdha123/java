package ch07object2;

public class FighterTest {

	public static void main(String[] args) {

		Fighter f1 = new Fighter(100);
	    Fightable f2 = new Fighter(200); // ���� �ڵ庸�� �� ���� ����Ѵ�.
		
		if(f1 instanceof Unit)
			System.out.println("f�� UnitŬ������ �ڼ��Դϴ�.");
		
		if(f1 instanceof Fightable)
			System.out.println("f�� Fightable�������̽��� �����߽��ϴ�.");
		
		if(f2 instanceof Movable)
			System.out.println("f�� Movable�������̽��� �����߽��ϴ�.");
		f1.move(10, 20);
		f1.attack((Unit)f2);
		System.out.println(f1);
		System.out.println(f2);
		
		if(f1 instanceof Attackable)
			System.out.println("f�� Attackable�������̽��� �����߽��ϴ�.");
		
		if(f1 instanceof Object)
			System.out.println("f�� ObjectŬ������ �ڼ��Դϴ�.");
	}

}
// ���� Unit - Unit : HP, x, y ��ӹ޾� ���
class Fighter extends Unit implements Fightable{
	public Fighter(int hp) {
		currentHP = hp;
	}
	public void move(int x, int y) {System.out.println("�������� �̵�");
	this.x = x;
	this.y = y;
	}
	public void attack(Unit u) {System.out.println("�������� ����");
	u.currentHP -=10;
	}
	public String toString() {
		return "Fighter [currentHP=" + currentHP + ", x=" + x + ", y=" + y + "]";
}
}
// Unit
class Unit {
	int currentHP; //������ ü��
	int x; //������ ��ġ(x��ǥ)
	int y; //������ ��ġ(y��ǥ)
}
// �������̽� ����
// �ο��� ������ unit -> �̵�����, ���ݰ���
// interface�� ���߻���� �����ϴ�. <-> Ŭ������ ���� ����� �Ұ���
interface Fightable extends Movable, Attackable {}
// unit�� �̵��� �Ѵ�. -> x, y��ǥ
interface Movable { void move(int x, int y);}
// unit�� ������ �Ѵ�. -> ��� unit
interface Attackable {void attack(Unit u);}