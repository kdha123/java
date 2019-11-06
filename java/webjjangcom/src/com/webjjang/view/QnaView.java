package com.webjjang.view;

import java.util.List;

import com.webjjang.qna.dto.QnaDTO;



public class QnaView {
	// list 화면에 출력
		public void list(List<QnaDTO> list) {
			// title 출력
			System.out.println("***************");
			System.out.println("*** 질문답변리스트  ***");
			System.out.println("****************");
			System.out.println("| 번호  |   제목     |  작성자 ID   |  작성일    | 조회수   | ");
			// list에 여러개의 데이터가 들어있으므로 각각의 데이터에 대해서 출력을 한다. -> forEach
			for(QnaDTO dto : list) {
				String indent = "";
				for (int i = 0; i < dto.getLevNo();i++)
					indent += "   ";
				System.out.printf("| %3d  |   %s   |   %s   |  %s |  %d   |%n ",
						dto.getNo(),indent + dto.getTitle(),
						dto.getName()+"("+dto.getId()+")",dto.getWriteDate(),dto.getHit());
			}
			System.out.println();
		}

		//view 화면에 출력
		public void view(QnaDTO dto) {
			System.out.println("***************");
			System.out.println("*** 질문답변글보기  ***");
			System.out.println("****************");
			System.out.println("글번호 : "+ dto.getNo());
			System.out.println("제목 : "+ dto.getTitle());
			System.out.println("내용 : "+ dto.getContent());
			System.out.println("작성자 : "+ dto.getName()+ "("+dto.getId()+")");
			System.out.println("작성일 : "+ dto.getWriteDate());
			System.out.println("조회수 : "+ dto.getHit());
			// 사용자에게 보여주지는 않지만 답변글 작성 시 꼭 필요하다.
			System.out.println("관련글 번호 : "+ dto.getRefNo());
			System.out.println("순서 번호 : "+ dto.getOrdNo());
			System.out.println("들여쓰기 번호 : "+ dto.getLevNo());
			System.out.println("부모글 번호 : "+ dto.getParentNo());
		
	}
		
}
