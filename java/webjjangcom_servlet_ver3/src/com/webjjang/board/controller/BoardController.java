package com.webjjang.board.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.board.dto.BoardDTO;
import com.webjjang.board.dto.BoardReplyDTO;
import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;


public class BoardController implements Controller {

	private Service listService;
	private Service viewService;
	private Service writeService;
	private Service updateService;
	private Service deleteService;
	private Service replyWriteService;
	private Service replyListService;
	private Service replyUpdateService;
	private Service replyDeleteService;
	
	
	// 생성자를 이용해서 service DI 적용--> Beans에서 생성 후 넣어준다.
	public BoardController(Service listService,Service viewService, Service writeService, Service updateService, Service deleteService,
			Service replyWriteService,Service replyListService,Service replyUpdateService, Service replyDeleteService) {
		this.listService = listService;
		this.viewService = viewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.deleteService = deleteService;
		
		//댓글 서비스
		this.replyWriteService = replyWriteService;
		this.replyListService = replyListService;
		this.replyUpdateService = replyUpdateService;
		this.replyDeleteService = replyDeleteService;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		
		// 공통으로 사용되는 변수
		String jsp = "";
		int no;
		
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"), request.getParameter("perPageNum"));
		
		// 검색에 대한 데이터 셋팅.
		String key = request.getParameter("key");
		String word = request.getParameter("word");
		if(word != null) {
			pageObject.setKey(key);
			pageObject.setWord(word);
		}
		
		//jsp에서 자바 부분을 여기 넣는다.
		switch (uri) {
		case "/board/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject));
			jsp = "board/list";
			break;
		//게시판 글보기 + 댓글 리스트 보기 추가(별도의 데이터를 받아와서 request에 넣는다.)
		case "/board/view.do":
			no = Integer.parseInt(request.getParameter("no"));
			int cnt = Integer.parseInt(request.getParameter("cnt"));
			// request에 실행한 결과값을 저장 -> jsp에서 꺼내 쓴다.
			request.setAttribute("dto", Execute.service(viewService, no, cnt));
			request.setAttribute("replyList", Execute.service(replyListService, no));
			jsp = "board/view";
			// request와 response를 forward로 가져간다.
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
		case "/board/writeForm.do":
			jsp = "board/writeForm";
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
		case "/board/write.do":

			Execute.service(writeService, getDTO(request.getParameter("title"), request.getParameter("content"), request.getParameter("writer")));
			jsp = "redirect:list.do?page=1&perPageNum="+request.getParameter("perPageNum");
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			//게시판 글 수정
		case "/board/updateForm.do":
	
			no = Integer.parseInt(request.getParameter("no"));
			// Execute.service(viewService, 글번호, 조회수 1증가)
			request.setAttribute("dto", Execute.service(viewService, no, 0));
			jsp = "board/updateForm";
			break;
			//게시판 글 수정
		case "/board/update.do":
			no = Integer.parseInt(request.getParameter("no"));
			// 서비스를 호출해서 데이터를 수정
			Execute.service(updateService, getDTO(no, request.getParameter("title"),
						request.getParameter("content"), request.getParameter("writer")));
			jsp ="redirect:view.do?no=" + no 
					+ "&cnt=0"
					+ "&page=" + pageObject.getPage()
					+ "&perPageNum=" + pageObject.getPerPageNum()
					+ ((pageObject.getWord() != null && !pageObject.getWord().equals(""))
					  ?"&key="+pageObject.getKey() + "&word=" + URLEncoder.encode(pageObject.getWord(),"utf-8"):"");
			break;
			//게시판 글 삭제
		case "/board/delete.do":
			// request에 실행한 결과값을 저장 -> jsp에서 꺼내 쓴다.
			Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
			// 자동으로 리스트로 이동시켜야한다.
			
			jsp = "redirect:list.do";
			// request와 response를 forward로 가져간다.
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			
		// 게시판 댓글쓰기 처리
		case "/board/replyWrite.do":
			
			Execute.service(replyWriteService, 
					new BoardReplyDTO(Integer.parseInt(request.getParameter("no")), request.getParameter("content"), request.getParameter("writer")));
			// 자동으로 글보기로 이동시켜야 한다.
			jsp = "redirect:view.do?no="+request.getParameter("no")
										+"&cnt=0&page="+request.getParameter("page")+
										"&perPageNum="+request.getParameter("perPageNum");
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
		//게시판 댓글 수정처리
		case "/board/replyUpdate.do":
			
			Execute.service(replyUpdateService, 
					new BoardReplyDTO(Integer.parseInt(request.getParameter("rno")), request.getParameter("content")));
			// 자동으로 글보기로 이동시켜야 한다.
			jsp = "redirect:view.do?no="+request.getParameter("no")
			+"&cnt=0&page="+request.getParameter("page")+
			"&perPageNum="+request.getParameter("perPageNum");
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
		case "/board/replyDelete.do":
			// request에 실행한 결과값을 저장 -> jsp에서 꺼내 쓴다.
			System.out.println("replyDelete");
			Execute.service(replyDeleteService, Integer.parseInt(request.getParameter("rno")));
			// 자동으로 리스트로 이동시켜야한다.
			
			jsp = "redirect:view.do?no="+request.getParameter("no")
			+"&cnt=0&page="+request.getParameter("page")+
			"&perPageNum="+request.getParameter("perPageNum");
			// request와 response를 forward로 가져간다.
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			
		default:
			break;
		
		
		}
		System.out.println("BoardController.execute().jsp: "+jsp);
		return jsp;
	}
	private BoardDTO getDTO(String title, String content, String writer) {
		BoardDTO dto = new BoardDTO();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setWriter(writer);
		return dto;
	}
	private BoardDTO getDTO(int no, String title, String content, String writer) {
		BoardDTO dto = getDTO(title, content, writer);
		dto.setNo(no);
		return dto;
	}

}
