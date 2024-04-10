package Testing;

import com.software.dao.TaiKhoanDAO;
import com.software.entity.TaiKhoan;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSignUp {

	TaiKhoanDAO udao = new TaiKhoanDAO();
	static int count, index;

	public int countUser() {
		int temp = 0;
		try {
			List<TaiKhoan> u = udao.SelectAll();
			temp = u.size();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}

	@BeforeMethod
	public void beforeUser() {
		count = countUser();
		System.out.println(count);
	}

	// TC07
	@Test(priority = 1)
	public void signupNullAll() {
		String number_phone = "";
		String password = "";
		TaiKhoan user = new TaiKhoan(number_phone, password);
		udao.insert(user);
		index = countUser();
		assertEquals(index, count);
	}

	// TC08
	@Test(priority = 2)
	public void signupNullNumberPhone() {
		String number_phone = "";
		String password = "123456";
		String confirm = "123456";
		if (password.equals(confirm)) {
			TaiKhoan user = new TaiKhoan();
			user.setSoDienThoai(number_phone);
			user.setMatKhau(password);
			udao.insert(user);
		}
		index = countUser();
		assertEquals(index, count);
	}

	// TC09
	@Test
	public void signupNullPass() {
		String number_phone = "037999672";
		String password = "";
		String confirm = "123456";
		if (password.equals(confirm)) {
			TaiKhoan user = new TaiKhoan();
			user.setSoDienThoai(number_phone);
			user.setMatKhau(password);
			udao.insert(user);
		}
		index = countUser();
		assertEquals(index, count);
	}

//	 TC10
	@Test
	public void signupNullConfirmPass() {
		String number_phone = "037999672";
		String password = "123456";
		String confirm = "";
		if (password.equals(confirm)) {
			TaiKhoan user = new TaiKhoan();
			user.setSoDienThoai(number_phone);
			user.setMatKhau(password);
			udao.insert(user);
		}
		index = countUser();
		assertEquals(index, count);
	}

	// TC11
	@Test
	public void signupNullIncorrectLengthPass() {
		String number_phone = "0379989672";
		String password = "123";
		String confirm = "123";
		if (password.equals(confirm)) {
			TaiKhoan user = new TaiKhoan();
			user.setSoDienThoai(number_phone);
			user.setMatKhau(password);
			udao.insert(user);
		}
		index = countUser();
		assertEquals(index, count);
	}

//	TC12
	@Test
	public void signupNumberPhoneExits() {
		String number_phone = "0379999999";
		String password = "123456";
		String confirm = "123456";
		if (password.equals(confirm)) {
			TaiKhoan user = new TaiKhoan();
			user.setSoDienThoai(number_phone);
			user.setMatKhau(password);
			udao.insert(user);
		}
		index = countUser();
		assertEquals(index, count);
	}

	@Test
	public void signupSuccess() {
		String number_phone = "0" + Math.round(Math.random() * 1000000000);
		String password = "123456";
		String confirm = "123456";
		if (password.equals(confirm)) {
			TaiKhoan user = new TaiKhoan();
			user.setSoDienThoai(number_phone);
			user.setMatKhau(password);
			udao.insert(user);
		}
		index = countUser();
		assertEquals(index, count + 1);
	}


}
