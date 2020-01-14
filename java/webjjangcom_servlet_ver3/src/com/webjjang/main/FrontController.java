package com.webjjang.main;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.bean.Beans;

//static 메서드인 경우  static import를 사용해서 메서드까지 지정을 해놓으면 메서드만 사용할 수 있다.
import static com.webjjang.util.io.ViewResolver.forward;
/**
 * Servlet implementation class MainServlet
 */


// url 패턴은 web.xml에 설정하도록 한다.
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
// 실행해야할 컨트롤러 선언
	private Controller mainController = Beans.getController("mainController");
	private Controller boardController = Beans.getController("boardController");
	private Controller noticeController = Beans.getController("noticeController");
	private Controller qnaController = Beans.getController("qnaController");
	private Controller memberController = Beans.getController("memberController");
	private Controller ajaxController = Beans.getController("ajaxController");
	private Controller imageController = Beans.getController("imageController");
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// forward나 sendRedirect를 할 내용을 저장하는 변수
		String jsp = "";
		try {
			System.out.println("FrontController.service() - 시작부분");
			// 요청한 uri
			String uri = request.getServletPath();
			System.out.println(uri);
			if(uri.indexOf("/board")== 0) {
				System.out.println("게시판 처리");
			jsp = boardController.execute(request, response, uri);
			}else if(uri.indexOf("/notice")== 0) {
				System.out.println("공지사항처리");
			jsp = noticeController.execute(request, response, uri);
			}else if(uri.indexOf("/message")== 0) {
				System.out.println("메시지처리");
			}else if(uri.indexOf("/qna")== 0) {
				System.out.println("질문답변처리");
				jsp = qnaController.execute(request, response, uri);
			}else if(uri.indexOf("/image")== 0) {
				System.out.println("이미지처리");
				jsp = imageController.execute(request, response, uri);
			}else if(uri.indexOf("/member")== 0) {
				System.out.println("회원관리처리");
				jsp = memberController.execute(request, response, uri);
			}else if(uri.indexOf("/main.do")== 0) {
				System.out.println("메인 페이지 처리");
				jsp = mainController.execute(request, response, uri);
			}else if(uri.indexOf("/ajax")== 0) {
				//ajax인 경우 주로 jsp를 만들지 않고 데이터를 그대로 보낸다.
				System.out.println("Ajax처리");
				ajaxController.execute(request, response, uri);
				return;

			}else {
				System.out.println("404에러 없는 페이지 요청");
			}
			// ViewResolver.forward를 static import해 놓아서 메서드 이름만 사용 가능하다.
			// 처리가 다 끝나면 jsp로 forward할지 url로 redirect할지를 처리하는 문을 작성
			forward(request, response, jsp);
		}catch (Exception e) {

			throw new ServletException(e);
		}
	}

}
