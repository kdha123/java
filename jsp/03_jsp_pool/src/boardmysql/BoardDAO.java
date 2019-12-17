package boardmysql;
import java.sql.*;//Connection,PreparedSteatement,Statement, ResultSet
import java.util.*;//Vector,List,ArrayList
import javax.sql.*;//DataSource
import javax.naming.*;//lookup

//DAO : DBó���ϴ� �����Ͻ� ����
public class BoardDAO {
	//����
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String sql="";
	
	//�̱��� ��ü���� �� ���̴� . ��? �޸� ���� ȿ�� ������
	private static BoardDAO dao=new BoardDAO();
	
	//����Ʈ ������ private���� ������ ������ �ܺο��� ��ü���� ���ϰ� �Ϸ���
	private BoardDAO(){};
	
	//jsp���� dao��ü��  ����� �޼��带 �����
	public static BoardDAO getDAO(){
		return dao;
	}
	
	//Ŀ�ؼ� ���,�޼���
	private Connection getCon() throws Exception{
		Context ct=new InitialContext();
		DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		return ds.getConnection();
	}//getCon() end
	
	//-----------------------
	// ����, ��� ���� 
	//-----------------------
	
	public void insertArticle(BoardDTO dto) throws Exception{
		int num=dto.getNum();//0 �̸� ���� , 0 �� �ƴϸ� ���
		int ref=dto.getRef();// ����̸� ���� �Ѿ�´�
		int re_step=dto.getRe_step();//����̸� ���� �Ѿ�´�
		int re_level=dto.getRe_level();//����̸� ���� �Ѿ�´� 
		
		int number=0;//�� �׷� ó���ϱ� ���� ����
		
		try{
			con=getCon();//Ŀ�ؼ� ��� 
			//DB�� �׷� �Լ� : count, max , min, avg
			
			//�ִ� �۹�ȣ ��� 
			pstmt=con.prepareStatement("select max(num) from board");
			rs=pstmt.executeQuery();
			
			if(rs.next()){//���� ���� �ϸ� 
				number=rs.getInt(1)+1;
			}else{
				number=1;//ó���� �̸�  ref=number
			}//else end
			
			if(num != 0){//���
				//��� ���� �ֱ� Ȯ��
				sql="update board set re_step=re_step+1 where ref=? and re_step>?";
				pstmt=con.prepareStatement(sql);
				//?�� ä���
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.executeUpdate();//���� ���� 
				
				re_step=re_step+1;//�ۼ���
				re_level=re_level+1;//�� ���� = �鿩���� 
			}else{//����
				ref=number;//�� �׷� ��ȣ 
				re_step=0;
				re_level=0;
			}//else -----
			//mysql : NOW() ����� �ú���
			//mysql : curdate() �����
			//Oracle : sysdate
			
			sql="insert into board(writer,email,subject,passwd,reg_date,"+
			"ref,re_step,re_level,content,ip) "+
			"values(?,?,?,?,NOW(),?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);//������ ���� ���� 
			//?�� ä��� 
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3,dto.getSubject());
			pstmt.setString(4,dto.getPasswd());
			//��¥
			pstmt.setInt(5, ref);
			pstmt.setInt(6, re_step);
			pstmt.setInt(7, re_level);
			
			pstmt.setString(8, dto.getContent());
			pstmt.setString(9, dto.getIp());
			
			pstmt.executeUpdate();//���� ����
			
			
		}catch(Exception ex1){
			System.out.println("insertArticle() ���� :"+ex1);
		}finally{
			try{
				if(rs != null){rs.close();}
				if(pstmt != null){pstmt.close();}
				if(con != null){con.close();}
			}catch(Exception ex3){}
		}//finally end
	}//insertArticle() end
	
	//-----------------------------------
	// �� ���� 
	//-----------------------------------
	
	
	//-----------------------------------
	// �� ���� 
	//-----------------------------------
}///class end
