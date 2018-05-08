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
			throw new RuntimeException("SqlMapClient ��������",e); 
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
			System.out.println("1,��ü���");
			System.out.println("2,ȸ���˻�");
			System.out.println("3,ȸ�����");
			System.out.println("4,��������");
			System.out.println("5,ȸ��Ż��");
			System.out.println("0,���α׷� ����");
			System.out.println("�޴�����");
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
				System.out.println("ã���ô� ID: ");
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
				System.out.println("�ű� ȸ����� ����");
				break;
			case 4:
				System.out.println("������ȸ�� iD= ");
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
				System.out.println("���������Ϥ�y");
				break;
			case 5:
				System.out.println("������ ȸ�� ID");
				id =br.readLine();
				deleteUser(id);
				System.out.println(id+"ȸ�����������Ϸ�");
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�");
				break;			
			}
		}
		
	}

}
