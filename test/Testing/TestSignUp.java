package Testing;

import com.software.dao.TaiKhoanDAO;
import com.software.entity.TaiKhoan;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class TestSignUp {

	TaiKhoanDAO udao = new TaiKhoanDAO();
	@Rule
	public ErrorCollector ec = new ErrorCollector();
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

	@Before
	public void beforeUser() {
		count = countUser();
		System.out.println(count);
	}

	// TC07
	@Test
	public void testSignup1() {
		try {
			TaiKhoan user = new TaiKhoan();
			udao.insert(user);
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null: " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}

	// TC08
	@Test
	public void testSignup2() {
		try {
			String number_phone = "";
			String password = "123456";
			String confirm = "123456";
			if (password.equals(confirm)) {
				TaiKhoan user = new TaiKhoan();
				user.setSoDienThoai(number_phone);
				user.setMatKhau(password);
				udao.insert(user);
			}

		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null sdt: " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}
	
	//TC09
	@Test
	public void testSignup3() {
		try {
			String number_phone = "037999672";
			String password = "";
			String confirm = "123456";
			if (password.equals(confirm)) {
				TaiKhoan user = new TaiKhoan();
				user.setSoDienThoai(number_phone);
				user.setMatKhau(password);
				udao.insert(user);
			}
		} catch (Exception e) {
			ec.addError(new Throwable("Loi check null pass: " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}
	
	
	//TC10
	@Test
	public void testSignup4() {
		try {
			String number_phone = "037999672";
			String password = "123456";
			String confirm = "";
			if (password.equals(confirm)) {
				TaiKhoan user = new TaiKhoan();
				user.setSoDienThoai(number_phone);
				user.setMatKhau(password);
				udao.insert(user);
			}
		} catch (Exception e) {
			ec.addError(new Throwable("Check không có thông tin xác nhận mật khẩu: " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}
	
	
	//TC11
	@Test
	public void testSignup5() {
		try {
			String number_phone = "037999672";
			String password = "123";
			String confirm = "123";
			if (password.length() < 6 || password.length() > 18) {
				if (password.equals(confirm)) {
					TaiKhoan user = new TaiKhoan();
					user.setSoDienThoai(number_phone);
					user.setMatKhau(password);
					udao.insert(user);
				}
			}
		} catch (Exception e) {
			ec.addError(new Throwable("Check mật khẩu > 6 và < 18 kí tự: " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}
	
	
//	TC12
	@Test
	public void testSignup6() {
		try {
			String number_phone = "0379903799";
			String password = "123456";
			String confirm = "123456";
			if (password.length() < 6 || password.length() > 18) {
				if (password.equals(confirm)) {
					TaiKhoan user = new TaiKhoan();
					user.setSoDienThoai(number_phone);
					user.setMatKhau(password);
					udao.insert(user);
				}
			}
		} catch (Exception e) {
			ec.addError(new Throwable("Check sdt đã được sử dụng : " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}

//	TC13
	@Test
	public void testSignup7() {
		try {
			String number_phone = "0379967723";
			String password = "123456";
			String confirm = "123456";
			if (password.length() < 6 || password.length() > 18) {
				if (password.equals(confirm)) {
					TaiKhoan user = new TaiKhoan();
					user.setSoDienThoai(number_phone);
					user.setMatKhau(password);
					udao.insert(user);
				}
			}
		} catch (Exception e) {
			ec.addError(new Throwable("Check số điện thoại không liên kết với nhân viên nào : " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}

	@Test
	public void testSignup8() {
		try {
			String number_phone = "037991111";
			String password = "123456";
			String confirm = "123456";
			if (password.length() < 6 || password.length() > 18) {
				if (password.equals(confirm)) {
					System.out.println("Bắt đầu insert");
					TaiKhoan user = new TaiKhoan();
					user.setSoDienThoai(number_phone);
					user.setMatKhau(password);
					udao.insert(user);
				}
			}
		} catch (Exception e) {
			ec.addError(new Throwable("Check tạo tài khoản đúng : " + e));
		}
		index = countUser();
		Assert.assertEquals(index, count);
	}

	@After
	public void afterUser() {
		System.out.println(count);
	}

	@AfterClass
	public static void CloseConnect() {

	}

}
