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
	public int getArticleCount() throws Exception{
		int x = 0;
		try {
			con = getCon();//커넥션 얻기
			pstmt = con.prepareStatement(" select count(*) from board ");
			rs = pstmt.executeQuery();//쿼리 실행
			if(rs.next()){
				x = rs.getInt(1);//글 개수
			}//if
			
		} catch (Exception ex1) {
			System.out.println("getArticleCount() 예외: "+ex1);
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			}catch(Exception ex2){}
		}// finally end
		return x;
	}//getArticleCount() end
	
	//-----------------------------------
	// list
	//-----------------------------------
	public List<BoardDTO> getList(int start, int cnt) throws Exception{
		List<BoardDTO> list = null;
		try{
			con = getCon();//커넥션 얻기
			sql = " select * from board order by ref desc, re_step asc limit ?,? ";
			// limit ?,? = ?부터 ?개수만큼
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, cnt);
			rs = pstmt.executeQuery();//쿼리 실행
			
			if(rs.next()){//글이 있으면
				list = new ArrayList<BoardDTO>();
				do{
					BoardDTO dto = new BoardDTO();
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setEmail(rs.getString("email"));
					dto.setSubject(rs.getString("subject"));
					dto.setPasswd(rs.getString("passwd"));
					
//					dto.setReg_date(rs.getDate("reg_date"));
					dto.setReg_date(rs.getTimestamp("reg_date"));//연월일 시분초
					 System.out.println("날짜"+rs.getDate("reg_date"));
					 System.out.println("날짜"+rs.getString("reg_date"));
					 System.out.println("날짜"+rs.getTimestamp("reg_date"));
					
					 dto.setReadcount(rs.getInt("readcount"));//조회수
					 dto.setRef(rs.getInt("ref"));
					 dto.setRe_step(rs.getInt("re_step"));
					 dto.setRe_level(rs.getInt("re_level"));
					 
					 dto.setContent(rs.getString("content"));
					 dto.setIp(rs.getString("ip"));
					 list.add(dto); // dto를 list에 넣기
					 
				}while(rs.next());
			}
			
			
		}catch(Exception ex1){
			System.out.println("getList() 예외 : "+ ex1);
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			}catch(Exception ex2){}
		}// finally end
		
		return list;
	}
//------------
// 글 내용 보기
//-----------
	public BoardDTO getArticle(int num) throws Exception{
		BoardDTO dto=null;
		try{
			con=getCon();//커넥션 얻기 
		
			//조횟수 증가 
			sql="update board set readcount=readcount+1 where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();//쿼리 실행 
			
			//글내용 보기 
			pstmt=con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();//쿼리 실행 
			
			if(rs.next()){
				dto=new BoardDTO();//객체생성
				
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setEmail(rs.getString("email"));
				
				dto.setSubject(rs.getString("subject"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
				
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
			}//if
			
		}catch(Exception ex1){
			System.out.println("getArticle() 예외 :"+ex1);
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			}catch(Exception ex2){}
		}//finally
		
		return dto;
	}//getArticle() end
	//-------------------------------
	// 글 수정 폼(updateForm) 으로 보내주는 작업
	//-------------------------------
	public BoardDTO updateGetArticle(int num) throws Exception{
		BoardDTO dto = null;
		try{
			con=getCon();//커넥션 얻기
			pstmt= con.prepareStatement("select * from board where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			while(rs.next()){
				dto = new BoardDTO();//객체 생성
				
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setEmail(rs.getString("email"));
				
				dto.setSubject(rs.getString("subject"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
				
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
				
			}//while end
		}catch(Exception ex1){
			System.out.println("updateGetArticle() 예외 : "+ex1);
		}finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally
		return dto;
	}//updateGetArticle()
	//-------------------------
	// DB 글 수정하기
	//-------------------------
	public int updateArticle(BoardDTO dto) throws Exception{
		String dbPasswd="";//변수
		int x = -100;
		
		try {
			con=getCon();//커넥션 얻기
			pstmt= con.prepareStatement("select passwd from board where num=?");
			pstmt.setInt(1, dto.getNum());
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dbPasswd = rs.getString("passwd");
				if(dbPasswd.equals(dto.getPasswd())){//암호가 일치하면 글수정
					sql="update board set writer=?, email=?, subject=?,"
							+ "content=? where num=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, dto.getWriter());
					pstmt.setString(2, dto.getEmail());
					pstmt.setString(3,dto.getSubject());
					
					pstmt.setString(4,dto.getContent());
					pstmt.setInt(5, dto.getNum());
					
					pstmt.executeUpdate();
					x=1;
				}else{//암호가 틀릴때
					x = 0;
				}//else end
			}//if
		} catch (Exception ex1) {
			System.out.println("updateArticle() 예외 : "+ex1);
		}finally{
			try {
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			} catch (Exception ex2) {}
		}//finally
		
		return x;
	}//updateArticle() end
}///class end
