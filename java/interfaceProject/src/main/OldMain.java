/*
 * main
 * 각각의 서비스가 실행되는 시간을 체크하는 처리 작성.
 */
package main;

import java.util.List;

import com.webjjang.util.io.Input;

import bean.Beans;
import dto.DTO;

public class OldMain {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		System.out.println("환영합니다.");
		// 프로그램을 돌리기전에 모든 객체를 생성해야한다.
		Class.forName("bean.Beans");
		
		while(true) {
			// 메뉴 출력
			System.out.println("[메인] -----------------");
			System.out.println("1.list  2.view 3.write");
			System.out.println("4.update 5.delete 0.exit");
			
			// 메뉴 입력
			String menu = Input.getStringWithMessage("메뉴를 선택하세요.\n 명령어를 입력하셔야합니다. ex) list)");
			// Switch 문에서 사용할 공통 변수
			int no = 0;
			long startTime = 0;
			long endTime = 0;
			// 메뉴 처리
			switch (menu) {
			case "list":
				//시작시간 저장
				startTime = System.nanoTime();
				List<DTO> list = (List<DTO>)Beans.getService(menu).service(null);
				System.out.println(list);
				// 끝나는 시간
				endTime = System.nanoTime();
				// 실행한 시간 결과 출력
				System.out.println(menu + "의 작업시간  : "+(endTime - startTime));
				break;
			case "view":
				startTime = System.nanoTime();
				no = 1;
				DTO dto = (DTO)(Beans.getService(menu).service(no,1));
				System.out.println(dto);
				// 끝나는 시간
				endTime = System.nanoTime();
				System.out.println(menu + "의 작업시간  : "+(endTime - startTime));
				break;
			case "write":
				startTime = System.nanoTime();
				Beans.getService(menu).service(new DTO());
				endTime = System.nanoTime();
				System.out.println(menu + "의 작업시간  : "+(endTime - startTime));
				break;
			case "update":
				startTime = System.nanoTime();
				Beans.getService(menu).service(new DTO());
				endTime = System.nanoTime();
				System.out.println(menu + "의 작업시간  : "+(endTime - startTime));
				break;
			case "delete":
				startTime = System.nanoTime();
				no = 1;
				Beans.getService(menu).service(no);
				endTime = System.nanoTime();
				System.out.println(menu + "의 작업시간  : "+(endTime - startTime));
				break;
			case "exit":
				System.out.println("bye~~");
				System.exit(0);
				break;

			default:
				System.out.println("잘못된 메뉴 선택");
				break;
			}// end of switch
		}
	
}
}
