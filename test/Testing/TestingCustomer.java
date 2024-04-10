package Testing;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.software.dao.KhachHangDAO;
import com.software.entity.KhachHang;
import com.software.entity.NhanVien;

public class TestingCustomer {

	KhachHangDAO KH_DAO = new KhachHangDAO();

	public boolean validateData(KhachHang kh) {
		if (kh.getMaKhachHang() == null || kh.getSoDT().isEmpty() || kh.getTenKhachHang().isEmpty()) {
			System.out.println("chưa điền đầy đủ thông tin");
			return false;
		}

		if (!(kh.getSoDT().matches("\\d{10}"))) {
			System.out.println("Số điện thoại không hợp lệ");
			return false;
		}
		

		return true;
	}

	public boolean checkDataAfterUpdate(KhachHang kh_old, KhachHang kh_new) {
		boolean check = kh_old.getSoDT().equals(kh_new.getSoDT())
				&& kh_old.getTenKhachHang().equals(kh_new.getTenKhachHang());
		return check;

	}


	@Test(priority = 1)
	public void addCustomerSucess() {
		System.out.println("(fn addCustomerSucess) Start testing... ");
		int maKH = 99999;
		String fullname = "Nguyễn Văn A";
		String numberP = "0389722389";
		boolean expected = true;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if(validateData(khach_hang_create)) {
				KH_DAO.insert(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				actual = KH_found != null ? true : false;
			}else actual = false;

		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(actual, expected);
		System.out.println("fn deleteSuccess OK !");
	}

	@Test(priority = 2)
	public void addCustomerNullFullname(){
		System.out.println("(fn addCustomerSucess) Start testing... ");
		int maKH = 99999;
		String fullname = "";
		String numberP = "0389722389";
		boolean expected = false;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.insert(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				actual = KH_found != null ? true : false;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(actual, expected);
		System.out.println("fn deleteSuccess OK !");
	}
	
	
	@Test(priority = 3)
	public void addCustomerNullNumberPhone(){
		System.out.println("(fn addCustomerIncorrectNumberPhone) Start testing... ");
		int maKH = 99999;
		String fullname = "Nguyễn Văn A";
		String numberP = "";
		boolean expected = false;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.insert(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				actual = KH_found != null ? true : false;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(actual, expected);
		System.out.println("fn addCustomerIncorrectNumberPhone OK !");
	}
	
	
	@Test(priority = 4)
	public void addCustomerIncorrectNumberPhone(){
		System.out.println("(fn addCustomerIncorrectNumberPhone) Start testing... ");
		int maKH = 99999;
		String fullname = "Nguyễn Văn A";
		String numberP = "sdfds32";
		boolean expected = false;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.insert(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				actual = KH_found != null ? true : false;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(actual, expected);
		System.out.println("fn addCustomerIncorrectNumberPhone OK !");
	}
	

	
	@Test(priority = 5)
	public void updateCustomerSucess() {
		System.out.println("(fn updateCustomerSucess) Start testing... ");
		int maKH = 99999;
		String fullname = "Nguyễn Văn C";
		String numberP = "0389722389";
		boolean expected = true;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.update(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				if (KH_found != null) {
					actual = checkDataAfterUpdate(khach_hang_create, KH_found);
				} else
					actual = false;
			} else
				actual = false;

		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(expected, actual);
		System.out.println("fn updateCustomerSucess OK !");
	}
	
	
	@Test(priority = 6)
	public void updateCustomerNullSDT() {
		System.out.println("(fn updateCustomerNullSDT) Start testing... ");
		int maKH = 99999;
		String fullname = "Nguyễn Văn C";
		String numberP = "";
		boolean expected = false;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.update(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				if (KH_found != null) {
					actual = checkDataAfterUpdate(khach_hang_create, KH_found);
				} else
					actual = false;
			} else
				actual = false;

		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(expected, actual);
		System.out.println("fn updateCustomerNullSDT OK !");
	}
	
	
	@Test(priority = 7)
	public void updateCustomerNullName() {
		System.out.println("(fn updateCustomerNullName) Start testing... ");
		int maKH = 99999;
		String fullname = "";
		String numberP = "0377932932";
		boolean expected = false;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.update(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				if (KH_found != null) {
					actual = checkDataAfterUpdate(khach_hang_create, KH_found);
				} else
					actual = false;
			} else
				actual = false;

		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(expected, actual);
		System.out.println("fn updateCustomerNullName OK !");
	}
	
	
	@Test(priority = 8)
	public void updateCustomerIncorrectPhone() {
		System.out.println("(fn updateCustomerIncorrectPhone) Start testing... ");
		int maKH = 99999;
		String fullname = "Nguyễn Văn A";
		String numberP = "03sdxf2932";
		boolean expected = false;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.update(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				if (KH_found != null) {
					actual = checkDataAfterUpdate(khach_hang_create, KH_found);
				} else
					actual = false;
			} else
				actual = false;

		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(expected, actual);
		System.out.println("fn updateCustomerIncorrectPhone OK !");
	}
	
	@Test(priority = 9)
	public void updateCustomerIncorrectName() {
		System.out.println("(fn updateCustomerIncorrectPhone) Start testing... ");
		int maKH = 99999;
		String fullname = "   ";
		String numberP = "03799667753";
		boolean expected = false;
		boolean actual;
		try {
			KhachHang khach_hang_create = new KhachHang(maKH, fullname, numberP);
			if (validateData(khach_hang_create)) {
				KH_DAO.update(khach_hang_create);
				KhachHang KH_found = KH_DAO.SelectByID(maKH);
				if (KH_found != null) {
					actual = checkDataAfterUpdate(khach_hang_create, KH_found);
				} else
					actual = false;
			} else
				actual = false;

		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(expected, actual);
		System.out.println("fn updateCustomerIncorrectPhone OK !");
	}

	@Test(priority = 10)
	public void deleteNVNotFoundId() {
		System.out.println("(fn deleteNVNotFoundId) Start testing... ");
		int id = 324234;

		boolean expected = false;
		boolean actual;
		try {
			KhachHang found = KH_DAO.SelectByID(id);
			if (found != null) {
				KH_DAO.delete(id);
				actual = true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(actual, expected);
		System.out.println("fn deleteNVNotFoundId OK !");
	}

	@Test(priority = 11)
	public void deleteSuccess() {
		System.out.println("(fn deleteSuccess) Start testing... ");
		int id = 99999;

		boolean expected = true;
		boolean actual;
		try {
			KhachHang found = KH_DAO.SelectByID(id);
			if (found != null) {
				KH_DAO.delete(id);
				actual = true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		assertEquals(actual, expected);
		System.out.println("fn deleteSuccess OK !");
	}

}
