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
				System.out.println("4.update  0.exit");

				String menu = Input.getStringWithMessage("메뉴를 선택하세요.\n 명령어를 입력하셔야합니다.(ex) list)");

				//실행할 서비스를 선언한다.
				Service service = null;
				// 실행할 객체를 준비한다.
				switch (menu) {
				case "list":
					service = Beans.getService(menu);
					List<DTO> list = (List<DTO>)execute(service, null);
					break;
				case "view":
					service = Beans.getService(menu);
					DTO dto = (DTO)execute(service, 1);
					break;
				case "write":
					service = Beans.getService(menu);
					execute(service, null);
					break;
				case "update":
					service = Beans.getService(menu);
					execute(service, null);
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
		return service.service(objs);
	}

}// end of Main class
