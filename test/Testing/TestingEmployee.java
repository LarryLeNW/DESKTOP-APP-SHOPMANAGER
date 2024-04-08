package Testing;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Test;

import com.software.dao.NhanVienDAO;
import com.software.entity.NhanVien;

public class TestingEmployee {

	NhanVienDAO NV_DAO = new NhanVienDAO();

	public boolean validateData(NhanVien nv) {
		if (nv.getMaNV().isEmpty() || nv.getCmnd().isEmpty() || nv.getDiaChi().isEmpty() || nv.getGmail().isEmpty()
				|| nv.getMaChucVu().isEmpty() || nv.getPath().isEmpty() || nv.getSoDienThoai().isEmpty()
				|| nv.getTenNV().isEmpty()) {
			System.out.println(" chưa điền đầy đủ thông tin");
			return false;
		}

		if (!(nv.getCmnd().matches("\\d{9}"))) {
			System.out.println("cmnd không hợp lệ");
			return false;
		}

		if (!(nv.getSoDienThoai().matches("\\d{10}"))) {
			System.out.println("Số điện thoại không hợp lệ");
			return false;
		}

		if (!(nv.getGmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))) {
			System.out.println("Email không hợp lệ");
			return false;
		}

		return true;
	}

	public boolean checkDataAfterUpdate(NhanVien nv_old, NhanVien nv_new) {
		return nv_old.getMaNV().equals(nv_new.getMaNV()) && nv_old.getTenNV().equals(nv_new.getTenNV())
				&& nv_old.getGmail().equals(nv_new.getGmail()) && nv_old.getMaChucVu().equals(nv_new.getMaChucVu())
				&& nv_old.getSoDienThoai().equals(nv_new.getSoDienThoai())
				&& nv_old.getDiaChi().equals(nv_new.getDiaChi()) && nv_old.getCmnd().equals(nv_new.getCmnd())
				&& nv_old.getPath().equals(nv_new.getPath()) && nv_old.isGioiTinh() == nv_new.isGioiTinh();
	}

	@Test
	public void testAddNVSuccess() {
		System.out.println("(fn testAddNVSuccess) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "nvtest";
		String soDienThoai = "0379999999";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "023129332";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtest@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = true;
		boolean actual;
		try {
			NV_DAO.insert(nv);
			NhanVien nvFound = NV_DAO.SelectByID(maNV);
			actual = nvFound == null ? false : true;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddNVSuccess OK !");
	}

	@Test
	public void testAddNullMaNV() {
		System.out.println("(fn testAddNullMaNV) Start testing... ");
		String maNV = "";
		String tenNV = "nvtest";
		String soDienThoai = "0379999922";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "332013201";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtesdt@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddNullMaNV OK !");
	}

	@Test
	public void testAddNullFullname() {
		System.out.println("(fn testAddNullFullname) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "";
		String soDienThoai = "0379999922";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "332013201";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtesdt@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddNullFullname OK !");
	}

	@Test
	public void testAddNullNumberPhone() {
		System.out.println("(fn testAddNullNumberPhone) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "test9999";
		String soDienThoai = "";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "332013201";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtesdt@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddNullNumberPhone OK !");
	}

	@Test
	public void testAddNullEmail() {
		System.out.println("(fn testAddNullEmail) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "test9999";
		String soDienThoai = "0379967723";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "332013201";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddNullEmail OK !");
	}

	@Test
	public void testAddNullCMND() {
		System.out.println("(fn testAddNullCMND) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "test9999";
		String soDienThoai = "0379967723";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtesdt@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddNullCMND OK !");
	}

	@Test
	public void testAddInCorrectCMND() {
		System.out.println("(fn testAddInCorrectCMND) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "test9999";
		String soDienThoai = "03799677237";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "0101010";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtesdt@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddInCorrectCMND OK !");
	}
	
	@Test
	public void testAddMaNVIsExits() {
		System.out.println("(fn testAddMaNVIsExits) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "test9999";
		String soDienThoai = "0379999999";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "123456789";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtesdt@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				System.out.println("Nhân viên tìm được : "  + nvFound);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddMaNVIsExits OK !");
	}

	@Test
	public void testAddCMNDIsExits() {
		System.out.println("(fn testAddMaNVIsExits) Start testing... ");
		String maNV = "CMNDIsExits";
		String tenNV = "testCMNDIsExits";
		String soDienThoai = "0379999922";
		String diaChi = "hòa an cẩm lệ ";
		String cmnd = "123456789";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "nvtesdt@gmail.com";
		String path = "test.img";

		NhanVien nv = new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(nv)) {
				NV_DAO.insert(nv);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				System.out.println("Nhân viên tìm được : "  + nvFound);
				actual = nvFound == null ? false : true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}

		Assert.assertEquals(actual, expected);
		System.out.println("fn testAddMaNVIsExits OK !");
	}
	
	@Test
	public void updateNVSuccess() {
		System.out.println("(fn updateNVSuccess) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "updateNVSuccess";
		String soDienThoai = "0379999999";
		String diaChi = "updateNVSuccess";
		String cmnd = "123456789";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "updateNVSuccess@gmail.com";
		String path = "updateNVSuccess.img";

		NhanVien NV_Update =  new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = true;
		boolean actual;
		try {
			if (validateData(NV_Update)) {
				NV_DAO.update(NV_Update);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				if (nvFound != null) {
					
					actual = checkDataAfterUpdate(nvFound,NV_Update);
				} else {
					System.out.println("Không tìm thấy nv");
					actual = false;
				}
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		Assert.assertEquals(actual, expected);
		System.out.println("fn updateNVSuccess OK !");
	}

	@Test
	public void updateIncorrectCMND() {
		System.out.println("(fn updateIncorrectCMND) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "updateNVSuccess";
		String soDienThoai = "0379999999";
		String diaChi = "updateNVSuccess";
		String cmnd = "3123d";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "updateNVSuccess@gmail.com";
		String path = "updateNVSuccess.img";

		NhanVien NV_Update =  new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(NV_Update)) {
				NV_DAO.update(NV_Update);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				if (nvFound != null) {
					
					actual = checkDataAfterUpdate(nvFound,NV_Update);
				} else {
					System.out.println("Không tìm thấy nv");
					actual = false;
				}
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		Assert.assertEquals(actual, expected);
		System.out.println("fn updateIncorrectCMND OK !");
	}
	
	@Test
	public void updateIncorrectNumberPhone() {
		System.out.println("(fn updateIncorrectNumberPhone) Start testing... ");
		String maNV = "nvtest999";
		String tenNV = "updateNVSuccess";
		String soDienThoai = "sfdfsdf";
		String diaChi = "updateNVSuccess";
		String cmnd = "123456789";
		boolean gioiTinh = true;
		String maChucVu = "1";
		String gmail = "updateNVSuccess@gmail.com";
		String path = "updateNVSuccess.img";

		NhanVien NV_Update =  new NhanVien(maNV, tenNV, soDienThoai, diaChi, cmnd, gioiTinh, maChucVu, gmail, path);

		boolean expected = false;
		boolean actual;
		try {
			if (validateData(NV_Update)) {
				NV_DAO.update(NV_Update);
				NhanVien nvFound = NV_DAO.SelectByID(maNV);
				if (nvFound != null) {
					
					actual = checkDataAfterUpdate(nvFound,NV_Update);
				} else {
					System.out.println("Không tìm thấy nv");
					actual = false;
				}
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		Assert.assertEquals(actual, expected);
		System.out.println("fn updateIncorrectNumberPhone OK !");
	}

	@Test
	public void deleteNVNotFoundId() {
		System.out.println("(fn deleteNVNotFoundId) Start testing... ");
		String id = "nvdl000";
		
		boolean expected = false;
		boolean actual;
		try {
			NhanVien found = NV_DAO.SelectByID(id);
			if (found != null) {
				NV_DAO.delete(id);
				actual = true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		Assert.assertEquals(actual, expected);
		System.out.println("fn deleteNVNotFoundId OK !");
	}

	@Test
	public void deleteSuccess() {
		System.out.println("(fn deleteSuccess) Start testing... ");
		String id = "nvtest999";
		
		boolean expected = true;
		boolean actual;
		try {
			NhanVien found = NV_DAO.SelectByID(id);
			if (found != null) {
				NV_DAO.delete(id);
				actual = true;
			} else
				actual = false;
		} catch (Exception e) {
			System.out.println(e);
			actual = false;
		}
		Assert.assertEquals(actual, expected);
		System.out.println("fn deleteSuccess OK !");
	}
}
