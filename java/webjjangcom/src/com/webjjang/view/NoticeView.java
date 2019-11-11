package com.webjjang.view;

import java.util.List;

import com.webjjang.notice.dto.NoticeDTO;
import com.webjjang.util.io.OutPut;

public class NoticeView {
	
	public static void list(List<NoticeDTO> list) {
		// 타이틀 출력
		OutPut.title("공지사항 리스트");
		if(list == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		System.out.println("|  번호  |  제목   |  시작일   |  종료일   |  작성일   |  수정일   |");
		// list에 여러개의 데이터가 들어 있으므로 각각의 데이터에 대해서 출력을 한다. -> forEach
		for(NoticeDTO dto : list) {
			System.out.printf("|  %3d  |  %s  |  %s  |  %s  |  %S  |  %s  |%n",
					dto.getNo(), dto.getTitle(), dto.getStartDate(), 
					dto.getEndDate(), dto.getWriteDate(), dto.getUpdateDate());				
		}
		System.out.println();
	}
	
	// view 화면에 출력
	public static void  view(NoticeDTO dto) {
		//타이틀 출력
		OutPut.title("공지사항 글보기 ");
		if(dto ==null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		System.out.println("글번호 : " + dto.getNo());
		System.out.println("제  목 : " + dto.getTitle());
		System.out.println("내  용 : " + dto.getContent());
		System.out.println("시작일 : " + dto.getStartDate());
		System.out.println("종료일 : " + dto.getEndDate());
		System.out.println("작성일 : " + dto.getWriteDate());
		System.out.println("수정일 : " + dto.getUpdateDate());
		System.out.println();
	}
}
