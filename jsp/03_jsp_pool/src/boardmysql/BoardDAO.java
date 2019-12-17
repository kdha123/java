package boardmysql;
import java.sql.*;//Connection,PreparedSteatement,Statement, ResultSet
import java.util.*;//Vector,List,ArrayList
import javax.sql.*;//DataSource
import javax.naming.*;//lookup

//DAO : DB처리하는 비지니스 로직
public class BoardDAO {
	//변수
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String sql="";
	
	//싱글톤 객체생성 할 것이다 . 왜? 메모리 절약 효과 때문에
	private static BoardDAO dao=new BoardDAO();
	
	//디폴트 생성자 private으로 선언한 이유는 외부에서 객체생성 못하게 하려고
	private BoardDAO(){};
	
	//jsp에서 dao객체를  사용할 메서드를 만든다
	public static BoardDAO getDAO(){
		return dao;
	}
	
	//커넥션 얻기,메서드
	private Connection getCon() throws Exception{
		Context ct=new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}//getCon() end
	
	//-----------------------
	// 원글, 답글 쓰기 
	//-----------------------
	
	public void insertArticle(BoardDTO dto) throws Exception{
		int num=dto.getNum();//0 이면 원글 , 0 이 아니면 답글
		int ref=dto.getRef();// 답글이면 값이 넘어온다
		int re_step=dto.getRe_step();//답글이면 값이 넘어온다
		int re_level=dto.getRe_level();//답글이면 값이 넘어온다 
		
		int number=0;//글 그룹 처리하기 위한 변수
		
		try{
			con=getCon();//커넥션 얻기 
			//DB의 그룹 함수 : count, max , min, avg
			
			//최대 글번호 얻기 
			pstmt=con.prepareStatement("select max(num) from board");
			rs=pstmt.executeQuery();
			
			if(rs.next()){//글이 존재 하면 
				number=rs.getInt(1)+1;
			}else{
				number=1;//처음글 이면  ref=number
			}//else end
			
			if(num != 0){//답글
				//답글 끼워 넣기 확보
				sql="update board set re_step=re_step+1 where ref=? and re_step>?";
				pstmt=con.prepareStatement(sql);
				//?값 채우기
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();//쿼리 실행 
				
				re_step=re_step+1;//글순서
				re_level=re_level+1;//글 깊이 = 들여쓰기 
			}else{//원글
				ref=number;//글 그룹 번호 
				re_step=0;
				re_level=0;
			}//else -----
			//mysql : NOW() 년월일 시분초
			//mysql : curdate() 년월일
			//Oracle : sysdate
			
			sql="insert into board(writer,email,subject,passwd,reg_date,"+
			"ref,re_step,re_level,content,ip) "+
			"values(?,?,?,?,NOW(),?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);//생성시 인자 들어간다 
			//?값 채우기 
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3,dto.getSubject());
			pstmt.setString(4,dto.getPasswd());
			//날짜
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			
			pstmt.setString(8, dto.getContent());
			pstmt.setString(9, dto.getIp());
			
			pstmt.executeUpdate();//쿼리 실행
			
			
		}catch(Exception ex1){
			System.out.println("insertArticle() 예외 :"+ex1);
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			}catch(Exception ex3){}
		}//finally end
	}//insertArticle() end
	
	//-----------------------------------
	// 글 갯수 
	//-----------------------------------
	
	
	//-----------------------------------
	// 글 갯수 
	//-----------------------------------
}///class end
