package Testing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.software.dao.TaiKhoanDAO;

public class TestLogin {

	TaiKhoanDAO udao = new TaiKhoanDAO();

	@Test(priority = 1)
	public void loginNullUsernameAndPass() {
		String user = null;
		String pass = null;
		boolean expected = false;
		boolean actual = udao.checkLogin(user, pass) != null;
		assertEquals(actual, expected);
	}

	@Test(priority = 2)
	public void loginNullUsername() {
		String user = "";
		String pass = "abc";
		boolean expected = false;
		boolean actual = udao.checkLogin(user, pass) != null;
		assertEquals(actual, expected);
	}

	@Test(priority = 3)
	public void loginNullPass() {
		String user = "tuine";
		String pass = "";
		boolean expected = false;
		boolean actual = udao.checkLogin(user, pass) != null;

		assertEquals(actual, expected);

	}

	@Test(priority = 4)
	public void loginIncorrectAll() {
		String user = "tuine";
		String pass = "123";
		boolean expected = false;
		boolean actual = udao.checkLogin(user, pass) != null;
		assertEquals(actual, expected);
	}

	@Test(priority = 5)
	public void loginIncorrectFullname() {
		String user = "phine";
		String pass = "0379967723";
		boolean expected = false;
		boolean actual = udao.checkLogin(user, pass) != null;

		assertEquals(actual, expected);

	}

	@Test(priority = 6)
	public void loginIncorrectPass() {
		String user = "0379967723";
		String pass = "1234";
		boolean expected = false;
		boolean actual = udao.checkLogin(user, pass) != null;

		assertEquals(actual, expected);

	}

	@Test(priority = 7)
	public void loginSuccess() {
		String user = "0379999999";
		String pass = "12345678";
		boolean expected = true;
		System.out.println("kq1 " + udao.checkLogin(user, pass));
		boolean actual = udao.checkLogin(user, pass) != null;
		System.out.println("actual" + actual);
		assertEquals(actual, expected);

	}
}
