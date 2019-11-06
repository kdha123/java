package com.webjjang.view;

import java.util.List;

import com.webjjang.board.dto.BoardDTO;

public class BoardView {
	
	// list 화면에 출력
	public void list(List<BoardDTO> list) {
		// title 출력
		System.out.println("***************");
		System.out.println("*** 게시판리스트  ***");
		System.out.println("****************");
		System.out.println("| 번호  |   제목     |  작성자   |   작성일     |  조회수   |");
		// list에 여러개의 데이터가 들어있으므로 각각의 데이터에 대해서 출력을 한다. -> forEach
		for(BoardDTO dto : list) {
			System.out.printf("| %d  |   %s   |   %s   |   %s    |  %d  | %n",
					dto.getNo(),dto.getTitle(),dto.getWriter(),dto.getWriteDate(),dto.getHit());
		}
		System.out.println();
	}

	//view 화면에 출력
	public void view(BoardDTO dto) {
		System.out.println("***************");
		System.out.println("*** 게시판글보기  ***");
		System.out.println("****************");
		System.out.println("글번호 : "+ dto.getNo());
		System.out.println("제목 : "+ dto.getTitle());
		System.out.println("내용 : "+ dto.getContent());
		System.out.println("작성자 : "+ dto.getWriter());
		System.out.println("작성일 : "+ dto.getWriteDate());
		System.out.println("조회수 : "+ dto.getHit());
	
}
	
}
