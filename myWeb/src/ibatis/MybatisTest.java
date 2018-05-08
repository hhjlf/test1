package ibatis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ibatis.MyUser;

public class MybatisTest {
	private SqlSessionFactory getSqlSessionFactiry() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public List<MyUser> selectAllUsers() {
		SqlSession sqlSession = getSqlSessionFactiry().openSession();
		try {
			String statement = "ibatis.MyUser.selectAllUsers";
			return sqlSession.selectList(statement);
		} finally {
			sqlSession.close();
		}
	}

	public MyUser selectUserById(String id) {
		SqlSession sqlSession = getSqlSessionFactiry().openSession();
		try {
			String statement = "ibatis.MyUser.seelctUserById";
			return (MyUser) sqlSession.selectOne(statement, id);
		} finally {
			sqlSession.close();
		}

	}

	public Integer insertUser(MyUser user) {
		SqlSession sqlSession = getSqlSessionFactiry().openSession();
		try {
			String statement = "ibatis.MyUser.insertUser";
			int result = sqlSession.insert(statement, user);
			if (result > 0) {
				sqlSession.commit();

			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Integer updateUser(MyUser user) {
		SqlSession sqlSession = getSqlSessionFactiry().openSession();
		try {
			String statment = "ibatis.MyUser.updateUser";
			int result = sqlSession.update(statment, user);
			if (result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	public Integer deleteUser(String id) {
		SqlSession sqlSession = getSqlSessionFactiry().openSession();
		try {
			String statment = "ibatis.MyUser.deleteUserById";
			int result = sqlSession.delete(statment,id);
			if(result>0) {
				sqlSession.commit();
			}
			return result;
		}finally {
			sqlSession.close();
		}
	}
	public static void main(String[]ar) throws IOException,SQLException{
		MybatisTest test = new MybatisTest();
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
				List<MyUser> list = test.selectAllUsers();						
				for (MyUser myuser :list) {
					System.out.println(myuser.toString());
				}
				break;
			case 2:
				System.out.println("찾으시는 ID: ");
				id = br.readLine();
				user = test.selectUserById(id);
						
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
				test.insertUser(user);
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
				test.updateUser(user);
				System.out.println("정보수정완ㄹy");
				break;
			case 5:
				System.out.println("삭제할 회원 ID");
				id =br.readLine();
			test.deleteUser(id);
				System.out.println(id+"회원정보삭제완료");
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				break;			
			}
		}
	
	}
}
