package ch05array;

import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		
		// ���� : 50, 60, 70, 80, 90 - ������ ����ϰ� �հ踦 ������.
		
//		 �迭�� ���� = �迭�� ����
//		int[] score = new int[5];
//		 ���� �ִ´�.
//		score[0] = 50;
//		score[1] = 60;
//		score[2] = 70;
//		score[3] = 80;
//		score[4] = 90;
		
		// ���� �������ְ� �����Ͱ� ���� ���� ���
//		int[] score = new int[] {50, 60, 70, 80, 90};
		
		// ���� �������ְ� �����Ͱ� ���� ���� ��� - new�� �迭�� ����
		int[] score = {50, 60, 70, 80, 90};
				
		// �հ踦 ���� ����
		int sum = 0;
		
		// �迭 0~4 : �ʱⰪ : 0, ������  : +1, ���� : i <= 4 / i < 5
		
		for(int i = 0; i <= 4; i++) {
			//����Ѵ�.
			System.out.println(score[i]);
			// �հ�
			sum += score[i];
		}
		System.out.println("�հ� : "+ sum);
		
		// �迭 ��ü ���
		System.out.println(score);
		
		// �迭�� ����ϰ� �Ǹ� Ÿ�԰� �ּҰ��� ������ ����� �ȴ�.
		// ������ ����� �� ���� ����ؾ��Ѵ�.
		// 1. �ε����� ����ϴ� ��� -> ���� �ڵ�
		// 2. foreach (���� for) -> ��� ������ ������ ���ؼ� ó���� �ϰ��� �� ��(�ε��� ���X)
		sum = 0;
		for(int s : score) {
			System.out.println(s);
			sum += s;
		}
		System.out.println("�հ� : "+ sum);
		
		// 1. �ε����� ����� �� ��� �迭�� ����(�迭�� ������ ������ �Ǿ ����) ��ŭ ó��
		for(int i = 0; i < score.length; i++)
			System.out.println(score[i]);
		
		// �迭�� ��� �����͸� ����ϴ� ������ ���ڿ��� ������ִ� �޼���
		// Arrays.toString(�迭[])
		System.out.println(Arrays.toString(score));
	}

}
