package com.webjjang.bean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import java.util.HashMap;
import java.util.Map;

import com.webjjang.board.controller.BoardController;
import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.service.BoardDeleteService;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardReplyDeleteService;
import com.webjjang.board.service.BoardReplyListService;
import com.webjjang.board.service.BoardReplyUpdateService;
import com.webjjang.board.service.BoardReplyWriteService;
import com.webjjang.board.service.BoardUpdateService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.board.service.BoardWriteService;
import com.webjjang.image.controller.ImageController;
import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.service.ImageDeleteService;
import com.webjjang.image.service.ImageListService;
import com.webjjang.image.service.ImageUpdateService;
import com.webjjang.image.service.ImageViewService;
import com.webjjang.image.service.ImageWriteService;
import com.webjjang.main.AjaxController;
import com.webjjang.main.Controller;
import com.webjjang.main.Service;
import com.webjjang.main.controller.MainController;
import com.webjjang.member.controller.MemberController;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.service.MemberIdCheckService;
import com.webjjang.member.service.MemberJoinService;
import com.webjjang.member.service.MemberLoginService;
import com.webjjang.notice.controller.NoticeController;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.service.NoticeDeleteService;
import com.webjjang.notice.service.NoticeListService;
import com.webjjang.notice.service.NoticeUpdateService;
import com.webjjang.notice.service.NoticeViewService;
import com.webjjang.notice.service.NoticeWriteService;
import com.webjjang.qna.controller.QnaController;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.service.QnaAnswerService;
import com.webjjang.qna.service.QnaDeleteService;
import com.webjjang.qna.service.QnaListService;
import com.webjjang.qna.service.QnaUpdateService;
import com.webjjang.qna.service.QnaViewService;
import com.webjjang.qna.service.QnaWriteService;
/**
 * Servlet implementation class Beans
 * 자바에서 사용하던 controller를 url을 이용한 JSP나 Servlet이 담당하므로 사라진다.
 */
@WebServlet(loadOnStartup = 1,urlPatterns = "/init")

public class Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 각각의 객체를 저장할 map객체 선언하고 생성해 놓는다.
	private static Map<String, Controller> controllers = new HashMap<>();
	private static Map<String, Service> services = new HashMap<>();
	private static Map<String, Object> daos = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Beans() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// 클래스가 시작될 때 딱 한번만 실행된다. -> static 블록에서 호출 당한다.
		System.out.println("Beans.init() = static{} 블록");

		System.out.println("객체 초기화중");
		//-----------공지사항---------
		//dao생성
		daos.put("noticeDAO", new NoticeDAO());
		// service 생성
		services.put("noticeListService", new NoticeListService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeViewService", new NoticeViewService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeWriteService", new NoticeWriteService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeUpdateService", new NoticeUpdateService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeDeleteService", new NoticeDeleteService((NoticeDAO) daos.get("noticeDAO")));
		// controller 생성자
		controllers.put("noticeController", new NoticeController(services.get("noticeListService"),
				services.get("noticeViewService"),
				services.get("noticeWriteService"),
				services.get("noticeUpdateService"),
				services.get("noticeDeleteService")));
		
		//-----------게시판---------
		//dao생성
		daos.put("boardDAO", new BoardDAO());
		// service 생성
		services.put("boardListService", new BoardListService((BoardDAO) daos.get("boardDAO")));
		services.put("boardViewService", new BoardViewService((BoardDAO) daos.get("boardDAO")));
		services.put("boardWriteService", new BoardWriteService((BoardDAO) daos.get("boardDAO")));
		services.put("boardUpdateService", new BoardUpdateService((BoardDAO) daos.get("boardDAO")));
		services.put("boardDeleteService", new BoardDeleteService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyWriteService", new BoardReplyWriteService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyListService", new BoardReplyListService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyUpdateService", new BoardReplyUpdateService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyDeleteService", new BoardReplyDeleteService((BoardDAO) daos.get("boardDAO")));
		
		// controller 생성자
		controllers.put("boardController", new BoardController(services.get("boardListService"),
				services.get("boardViewService"),
				services.get("boardWriteService"),
				services.get("boardUpdateService"),
				services.get("boardDeleteService"),
				services.get("boardReplyWriteService"),
				services.get("boardReplyListService"),
				services.get("boardReplyUpdateService"),
				services.get("boardReplyDeleteService")));

		//-----------질문답변---------
		//dao생성
		daos.put("qnaDAO", new QnaDAO());
		// service 생성
		services.put("qnaListService", new QnaListService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaViewService", new QnaViewService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaWriteService", new QnaWriteService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaUpdateService", new QnaUpdateService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaDeleteService", new QnaDeleteService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaAnswerService", new QnaAnswerService((QnaDAO) daos.get("qnaDAO")));
		// controller 생성자
		controllers.put("qnaController", new QnaController(services.get("qnaListService"),
				services.get("qnaViewService"),
				services.get("qnaWriteService"),
				services.get("qnaUpdateService"),
				services.get("qnaDeleteService")));
		
		//-----------이미지게시판---------
		//dao생성
		daos.put("imageDAO", new ImageDAO());
		// service 생성
		services.put("imageListService", new ImageListService((ImageDAO) daos.get("imageDAO")));
		services.put("imageWriteService", new ImageWriteService((ImageDAO) daos.get("imageDAO")));
		services.put("imageViewService", new ImageViewService((ImageDAO) daos.get("imageDAO")));
		services.put("imageUpdateService", new ImageUpdateService((ImageDAO) daos.get("imageDAO")));
		services.put("imageDeleteService", new ImageDeleteService((ImageDAO) daos.get("imageDAO")));
		// controller 생성자
		controllers.put("imageController", new ImageController(services.get("imageListService"),
				services.get("imageViewService"),
				services.get("imageWriteService"),
				services.get("imageUpdateService"),
				services.get("imageDeleteService")));
		
		
		
		//-----------회원관리---------
		//dao생성
		daos.put("memberDAO", new MemberDAO());
		// service 생성
		services.put("memberJoinService", new MemberJoinService((MemberDAO) daos.get("memberDAO")));
		services.put("memberLoginService", new MemberLoginService((MemberDAO) daos.get("memberDAO")));
		services.put("memberIdCheckService", new MemberIdCheckService((MemberDAO) daos.get("memberDAO")));
		controllers.put("memberController", new MemberController(services.get("memberListService"),
				services.get("memberViewService"),
				services.get("memberWriteService"),
				services.get("memberUpdateService"),
				services.get("memberDeleteService")));
		System.out.println("객체 초기화 완료");

		//아이디 중복체크 dao -> memeberDAO(이미등록되어 있음.)
		// 아이디 중복체크 service
		// Controller 생성 저장 ->기본생성자 -> DI 적용은 setter를 이용해서 한다 .
		AjaxController ajaxController = new AjaxController();
		controllers.put("ajaxController", ajaxController);
		ajaxController.setMemberIdCheckService(services.get("memberIdCheckService"));

		//***********Ajax 처리등록 ***********//
		controllers.put("mainController",new MainController(services.get("noticeListService"), services.get("imageListService")));
		
		
		
		
	}// end of init()
	
	public static Service getService(String name) {
		return services.get(name);
	}

	//Controller를 받아내는 메서드 작성
	public static Controller getController(String name) {
		return controllers.get(name);
	}
}// end of Beans class
