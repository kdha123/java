package com.webjjang.view;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;

public class BoardView {
	
	// list ȭ�鿡 ���
	public void list(List<BoardDTO> list) {
		// title ���
		System.out.println("***************");
		System.out.println("*** �Խ��Ǹ���Ʈ  ***");
		System.out.println("****************");
		System.out.println("| ��ȣ  |   ����     |  �ۼ���   |   �ۼ���     |  ��ȸ��   |");
		// list�� �������� �����Ͱ� ��������Ƿ� ������ �����Ϳ� ���ؼ� ����� �Ѵ�. -> forEach
		for(BoardDTO dto : list) {
			System.out.printf("| %d  |   %s   |   %s   |   %s    |  %d  | %n",
					dto.getNo(),dto.getTitle(),dto.getWriter(),dto.getWriteDate(),dto.getHit());
		}
		System.out.println();
	}

	//view ȭ�鿡 ���
	public void view(BoardDTO dto) {
		System.out.println("***************");
		System.out.println("*** �Խ��Ǳۺ���  ***");
		System.out.println("****************");
		System.out.println("�۹�ȣ : "+ dto.getNo());
		System.out.println("���� : "+ dto.getTitle());
		System.out.println("���� : "+ dto.getContent());
		System.out.println("�ۼ��� : "+ dto.getWriter());
		System.out.println("�ۼ��� : "+ dto.getWriteDate());
		System.out.println("��ȸ�� : "+ dto.getHit());
	
}
	
}
