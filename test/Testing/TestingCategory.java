package Testing;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.sql.Date;
import java.util.List;

import org.testng.annotations.Test;

import com.software.dao.LoaiSanPhamDAO;
import com.software.entity.LoaiSanPham;

public class TestingCategory {
	private LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();

	public boolean checkDataAfterUpdate(LoaiSanPham lsp_old, LoaiSanPham lsp_new) {
		if (!lsp_old.getMaLoai().equals(lsp_new.getMaLoai()) || !lsp_old.getMoTa().equals(lsp_new.getMoTa())
				|| !lsp_old.getTenLoai().equals(lsp_new.getTenLoai())) {
			return false;
		}

		return true;
	}

	@Test(priority = 1)
	public void insertNullId() {
		// Tạo một đối tượng LoaiSanPham mới mà không nhập id
		LoaiSanPham newLoaiSP = new LoaiSanPham();
		newLoaiSP.setMaLoai("");
		newLoaiSP.setTenLoai("testlsp999");
		newLoaiSP.setMoTa("Mô tả loại sản phẩm 1");
		// Số lượng LoaiSanPham trước khi thêm
		int sizeBeforeInsert = loaiSanPhamDAO.SelectAll().size();
		// Thêm mới LoaiSanPham vào cơ sở dữ liệu
		loaiSanPhamDAO.insert(newLoaiSP);
		// Số lượng LoaiSanPham sau khi thêm
		int sizeAfterInsert = loaiSanPhamDAO.SelectAll().size();

		// Kiểm tra xem số lượng LoaiSanPham đã tăng lên sau khi thêm
		assertEquals(sizeBeforeInsert, sizeAfterInsert);
		// Kiểm tra xem LoaiSanPham mới đã được chèn vào cơ sở dữ liệu chưa
		LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(newLoaiSP.getMaLoai());
		assertNull(lsp_Found);
	}

	@Test(priority = 2)
	public void testInsertNullName() {
		// Tạo một đối tượng LoaiSanPham mới mà không nhập tên loại
		LoaiSanPham newLoaiSP = new LoaiSanPham();
		newLoaiSP.setMaLoai("testlsp001");
		newLoaiSP.setTenLoai("");
		newLoaiSP.setMoTa("Mô tả loại sản phẩm 1");
		// Số lượng LoaiSanPham trước khi thêm
		int sizeBeforeInsert = loaiSanPhamDAO.SelectAll().size();
		// Thêm mới LoaiSanPham vào cơ sở dữ liệu
		loaiSanPhamDAO.insert(newLoaiSP);
		// Số lượng LoaiSanPham sau khi thêm
		int sizeAfterInsert = loaiSanPhamDAO.SelectAll().size();

		assertEquals(sizeBeforeInsert, sizeAfterInsert);
	}

	@Test(priority = 3)
	public void insertSuccess() {
		System.out.println("test");
		LoaiSanPham newLoaiSP = new LoaiSanPham();
		newLoaiSP.setMaLoai("testlsp001");
		newLoaiSP.setTenLoai("Loại sản phẩm test");
		newLoaiSP.setMoTa("Mô tả loại sản phẩm test");
		// Số lượng LoaiSanPham trước khi thêm
		int sizeBeforeInsert = loaiSanPhamDAO.SelectAll().size();
		// Thêm mới LoaiSanPham vào cơ sở dữ liệu
		loaiSanPhamDAO.insert(newLoaiSP);
		// Số lượng LoaiSanPham sau khi thêm
		int sizeAfterInsert = loaiSanPhamDAO.SelectAll().size();

		// Kiểm tra xem số lượng LoaiSanPham đã tăng lên sau khi thêm
		assertEquals(sizeBeforeInsert + 1, sizeAfterInsert);
		// Kiểm tra xem LoaiSanPham mới đã được chèn vào cơ sở dữ liệu chưa
		LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(newLoaiSP.getMaLoai());
		assertNotNull(lsp_Found);
	}

	@Test(priority = 4)
	public void testInsertExitsId() {
		// Tạo một đối tượng LoaiSanPham mới mà không nhập tên loại
		LoaiSanPham newLoaiSP = new LoaiSanPham();
		newLoaiSP.setMaLoai("1");
		newLoaiSP.setTenLoai("testlsp001");
		newLoaiSP.setMoTa("Mô tả loại sản phẩm testlsp001");
		// Số lượng LoaiSanPham trước khi thêm
		int sizeBeforeInsert = loaiSanPhamDAO.SelectAll().size();
		// Thêm mới LoaiSanPham vào cơ sở dữ liệu
		loaiSanPhamDAO.insert(newLoaiSP);
		// Số lượng LoaiSanPham sau khi thêm
		int sizeAfterInsert = loaiSanPhamDAO.SelectAll().size();

		assertEquals(sizeBeforeInsert, sizeAfterInsert);
	}

	@Test(priority = 5)
	public void insertSuccessWithoutDescription() {

		String id = "testlsp" + Math.round(Math.random() * 1000);
		LoaiSanPham newLoaiSP = new LoaiSanPham();
		newLoaiSP.setMaLoai(id);
		newLoaiSP.setTenLoai("testlsp");
		newLoaiSP.setMoTa("");
		// Số lượng LoaiSanPham trước khi thêm
		int sizeBeforeInsert = loaiSanPhamDAO.SelectAll().size();
		// Thêm mới LoaiSanPham vào cơ sở dữ liệu
		loaiSanPhamDAO.insert(newLoaiSP);
		// Số lượng LoaiSanPham sau khi thêm
		int sizeAfterInsert = loaiSanPhamDAO.SelectAll().size();

		// Kiểm tra xem số lượng LoaiSanPham đã tăng lên sau khi thêm
		assertEquals(sizeBeforeInsert + 1, sizeAfterInsert);
		// Kiểm tra xem LoaiSanPham mới đã được chèn vào cơ sở dữ liệu chưa
		LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(newLoaiSP.getMaLoai());
		assertNotNull(lsp_Found);
	}

	@Test(priority = 6)
	public void UpdateNullName() {
		// edit LoaiSanPham mới mà không nhập tên loại
		LoaiSanPham editLoaiSP = new LoaiSanPham();
		editLoaiSP.setMaLoai("6");
		editLoaiSP.setTenLoai("");
		editLoaiSP.setMoTa("Mô tả update lsp ...");
		loaiSanPhamDAO.update(editLoaiSP);
		LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(editLoaiSP.getMaLoai());
		assertFalse(checkDataAfterUpdate(lsp_Found, editLoaiSP));
	}

	@Test(priority = 7)
	public void UpdateSuccessWithoutDescription() {
		LoaiSanPham editLoaiSP = new LoaiSanPham();
		editLoaiSP.setMaLoai("6");
		editLoaiSP.setTenLoai("update test");
		editLoaiSP.setMoTa("");
		loaiSanPhamDAO.update(editLoaiSP);
		LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(editLoaiSP.getMaLoai());
		assertTrue(checkDataAfterUpdate(lsp_Found, editLoaiSP));
	}

	@Test(priority = 8)
	public void UpdateSuccessFullData() {
		LoaiSanPham editLoaiSP = new LoaiSanPham();
		editLoaiSP.setMaLoai("6");
		editLoaiSP.setTenLoai("update test");
		editLoaiSP.setMoTa("update test");
		loaiSanPhamDAO.update(editLoaiSP);
		LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(editLoaiSP.getMaLoai());
		assertTrue(checkDataAfterUpdate(lsp_Found, editLoaiSP));
	}

	@Test(priority = 9)
	public void testDeleteLoaiSPWithProducts() {
		String id = "1";
		boolean expected = false;
		boolean actual;
		try {
			loaiSanPhamDAO.delete(id);
			LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(id);
			System.out.println("lsp_Found" + lsp_Found);
			actual = lsp_Found == null ? true : false;
		} catch (Exception e) {
			actual = false;
		}
		assertEquals(expected, actual);
	}

	@Test(priority = 10)
	public void deleteWithoutId() {
		String id = "";
		// Số lượng LoaiSanPham trước khi xóa
		int sizeBeforeInsert = loaiSanPhamDAO.SelectAll().size();

		loaiSanPhamDAO.delete(id);

		// Kiểm tra xem số lượng LoaiSanPham sau khi xóa
		int sizeAfterInsert = loaiSanPhamDAO.SelectAll().size();

		assertEquals(sizeBeforeInsert, sizeAfterInsert);
	}

	@Test(priority = 11)
	public void deleteLoaiSPNoExitsProduct() {
		System.out.println("start testing fn deleteLoaiSPNoExitsProduct ");
		String id = "testlsp001";
		boolean expected = true;
		boolean actual;
		try {
			// Số lượng LoaiSanPham trước khi xóa
			int sizeBeforeInsert = loaiSanPhamDAO.SelectAll().size();
			loaiSanPhamDAO.delete(id);
			LoaiSanPham lsp_Found = loaiSanPhamDAO.SelectByID(id);

			System.out.println("deleteLoaiSPNoExitsProduct" + lsp_Found);
			System.out.println("lsp_Found" + lsp_Found);
			actual = lsp_Found == null ? true : false;
			// Kiểm tra xem số lượng LoaiSanPham sau khi xóa
			int sizeAfterInsert = loaiSanPhamDAO.SelectAll().size();


			System.out.println(sizeBeforeInsert);
			System.out.println(sizeAfterInsert);

			assertEquals(sizeBeforeInsert - 1, sizeAfterInsert);
		} catch (Exception e) {
			actual = false;
		}
		assertEquals(expected, actual);
		System.out.println("fn deleteLoaiSPNoExitsProduct oke ");
	}
}
