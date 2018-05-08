package ibatis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;



import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class UserTest {
	
	private static SqlMapClient sqlMapper;
	static {
		try {
			Reader reader =
					Resources.getResourceAsReader("sqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
			
		}catch(IOException e) {
			throw new RuntimeException("SqlMapClient 생성실패",e); 
		}
	}
	@SuppressWarnings("unchecked")
	public static List<MyUser> selectAllUsers() throws SQLException{
		return (List<MyUser>) sqlMapper.queryForList("selectAllUsers");
	}
	public static MyUser selectUserById(String id) throws SQLException{
		return (MyUser) sqlMapper.queryForObject("selectUserById",id);
	}
	public static void insertUser(MyUser user)throws SQLException{
		sqlMapper.insert("insertUser",user);
	}
	public static void updateUser(MyUser user)throws SQLException{
		sqlMapper.update("updateUser",user);
	}
	public static void deleteUser(String id)throws SQLException{
		sqlMapper.delete("deleteUserById",id);
	}
	public static void main(String[]ar) throws IOException,SQLException{
		int menu = -1;
		String id="";
		String pass="";
		String name="";
		int age = 0;
		MyUser user =null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(menu!=0) {
			System.out.println("1,전체목록");
			System.out.println("2,회원검색");
			System.out.println("3,회원등록");
			System.out.println("4,정보수정");
			System.out.println("5,회원탈퇴");
			System.out.println("0,프로그램 종료");
			System.out.println("메뉴선택");
			try {
				menu = Integer.parseInt(br.readLine());
			}catch(NumberFormatException e) {
				e.printStackTrace();
				continue;
			}
			
			switch (menu) {
			case 1:
				List<MyUser> list = selectAllUsers();						
				for (MyUser myuser :list) {
					System.out.println(myuser.toString());
				}
				break;
			case 2:
				System.out.println("찾으시는 ID: ");
				id = br.readLine();
				user = selectUserById(id);
						
				System.out.println(user.toString());
				break;
			case 3:
				System.out.println("ID=");
				id =br.readLine();
				System.out.println("PASS = ");
				pass  =br.readLine();
				System.out.println("NAME = ");
				name = br.readLine();
				System.out.println("AGE = ");
				age = Integer.parseInt(br.readLine());
				user = new MyUser();
				user.setId(id);user.setPass(pass);user.setName(name);user.setAge(age);
				insertUser(user);
				System.out.println("신규 회원등록 성공");
				break;
			case 4:
				System.out.println("수정할회원 iD= ");
				id= br.readLine();
				System.out.println("PASS = ");
				pass = br.readLine();
				System.out.println("NAME = ");
				name=br.readLine();
				System.out.println("AGE = ");
				age = Integer.parseInt(br.readLine());
				user = new MyUser();
				user.setId(id); user.setPass(pass); user.setName(name); user.setAge(age);
				updateUser(user);
				System.out.println("정보수정완ㄹy");
				break;
			case 5:
				System.out.println("삭제할 회원 ID");
				id =br.readLine();
				deleteUser(id);
				System.out.println(id+"회원정보삭제완료");
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				break;			
			}
		}
		
	}

}
