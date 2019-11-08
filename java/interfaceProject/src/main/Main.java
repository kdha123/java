package main;

import java.util.List;

import com.webjjang.util.io.Input;

import bean.Beans;
import dto.DTO;

public class Main {

	//project의 시작
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 객체가 생성이 되도록 Beans를 한번 찾아준다.
		try {
			Class.forName("bean.Beans");
			while(true) {
				System.out.println("[메인] -----------------");
				System.out.println("1.list  2.view 3.write");
				System.out.println("4.update  5. delete 0.exit");

				String menu = Input.getStringWithMessage("메뉴를 선택하세요.\n 명령어를 입력하셔야합니다.(ex) list)");

				int no = 0;
				// 실행할 객체를 준비한다.
				switch (menu) {
				case "list":
					List<DTO> list = (List<DTO>)execute(Beans.getService(menu), null);
					System.out.println(list);
					break;
				case "view":
					no = 1;
					DTO dto = (DTO)execute(Beans.getService(menu), 1, 1);
					System.out.println(dto);
					break;
				case "write":
					execute(Beans.getService(menu), new DTO());
					break;
				case "update":
					execute(Beans.getService(menu), new DTO());
					break;
				case "delete":
					execute(Beans.getService(menu), 1);
					break;
				case "exit":
					System.out.println("bye~~");
					System.exit(0);
					break;

				default:
					System.out.println("잘못된 메뉴 선택");
					break;
				}// end of switch
			}// end of while


		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// end of try/catch
	}// end of main()
	
	// main() 밖에다가 실행 메서드를 만든다.
	public static Object execute(Service service, Object ...objs) {
		System.out.println("Main.execute() : service 실행");
		return timeCheck(service, objs);
	}
	// 시간을 체크하는 메서드
	public static Object timeCheck(Service service, Object[] objs) {
		System.out.println("Main.timeCheck() : service 실행시간 처리");
		long start = System.nanoTime();
//		Object result = service.service(objs);
		Object result = authCheck(service, objs);
		long end = System.nanoTime();
		System.out.println("실행시간 : " + (end - start));
		return result;
	}
	public static Object authCheck(Service service, Object[] objs) {
		System.out.println("Main.authCheck() : service 권한 처리");
		// 권한처리를 한다.
		Object result = service.service(objs);
		return result;
	}
}// end of Main class
