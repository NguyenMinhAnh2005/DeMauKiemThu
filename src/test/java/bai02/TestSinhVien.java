package bai02;

import com.example.DeMau_KiemThu.bai02.SinhVien;
import com.example.DeMau_KiemThu.bai02.SinhVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestSinhVien {
    private SinhVienService sinhVienService;
    private SinhVien sinhVien;

    @BeforeEach
    void setUp() {
        sinhVienService = new SinhVienService();
        sinhVien = new SinhVien("SV01", "MA", 19, 8.0f, 5, "PTPM");
    }

    //Sửa SV
    @Test
    public void sua01_HopLe() {
        boolean kq = sinhVienService.suaSinhVien(sinhVien, "MA", 18, 9.0f, 5, "UDPM");
        Assertions.assertTrue(kq);
    }

    //   Tên rỗng => Không hợp lệ
    @Test
    public void sua02_TenRong() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.suaSinhVien(sinhVien, "", 19, 8.0f, 5, "PTPM"));
    }

    // Tuổi < 18 => Không hợp lệ (biên dưới)
    @Test
    public void sua03_TuoiNhoHon18() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.suaSinhVien(sinhVien, "LA", 17, 8.0f, 5, "PTPM"));
    }

    // Điểm trung bình âm => Không hợp lệ
    @Test
    public void sua04_DiemAm() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.suaSinhVien(sinhVien, "LA", 19, -0.1f, 5, "PTPM"));
    }

    // Điểm trung bình 10 (biên trên) => Hợp lệ
    @Test
    public void sua05_DiemToiDa() {
        boolean kq = sinhVienService.suaSinhVien(sinhVien, "LA", 19, 10.0f, 5, "PTPM");
        Assertions.assertTrue(kq);
    }

    // Test: Chuyên ngành rỗng => Không hợp lệ
    @Test
    public void sua06_ChuyenNganhRong() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.suaSinhVien(sinhVien, "MA", 19, 8.0f, 5, ""));
    }

    // Test: Mã SV rỗng => Không hợp lệ
    @Test
    public void sua07_MaRong() {
        SinhVien svRongMa = new SinhVien("", "MA", 19, 8.0f, 5, "PTPM");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.suaSinhVien(svRongMa, "MA", 19, 8.0f, 5, "PTPM"));
    }

    @Test
    public void sua08_SinhVienKhongTonTai() {
        SinhVien svKhongTonTai = new SinhVien("SV99", "LA", 19, 8.0f, 5, "PTPM");
        boolean kq = sinhVienService.suaSinhVien(svKhongTonTai, "LA", 19, 8.0f, 5, "PTPM");
        Assertions.assertFalse(kq);
    }


    //Thêm SV
    @Test
    public void them01_HopLe() {
        boolean kq = sinhVienService.themSinhVien(sinhVien);
        Assertions.assertTrue(kq);
    }

    @Test
    public void them02_TuoiNhoHon18() {
        SinhVien sv2 = new SinhVien("SV02", "LAnh", 17, 7.0f, 3, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.themSinhVien(sv2));
    }

    @Test
    public void them03_MaSinhVienRong() {
        SinhVien sv2 = new SinhVien("", "LAN", 19, 7.0f, 3, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.themSinhVien(sv2));
    }

    @Test
    public void them04_TenRong() {
        SinhVien sv = new SinhVien("SV03", "", 20, 7.5f, 4, "KTPM");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.themSinhVien(sv));
    }

    @Test
    public void them05_DiemTren10() {
        SinhVien sv = new SinhVien("SV04", "Nam", 21, 10.1f, 4, "KTPM");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.themSinhVien(sv));
    }

    @Test
    public void them06_Tuoilonhon18() {
        SinhVien sv2 = new SinhVien("SV02", "LAnh", 20, 7.0f, 3, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.themSinhVien(sv2));
    }

    @Test
    public void them07_TuoiNhoHon0() {
        SinhVien sv2 = new SinhVien("SV02", "LAnh", -1, 7.0f, 3, "CNTT");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> sinhVienService.themSinhVien(sv2));
    }


    /*** Test Xóa Sinh Viên ***/
//    @Test
//    public void xoa01_TonTai() {
//        sinhVienService.themSinhVien(sinhVien);
//        boolean kq = sinhVienService.xoaSinhVien("SV01");
//        Assertions.assertTrue(kq);
//    }

    @Test
    public void xoa02_KhongTonTai() {
        boolean kq = sinhVienService.xoaSinhVien("SV99");
        Assertions.assertFalse(kq);
    }

    @Test
    public void sua03_XoaSinhVienDaXoa() {
        sinhVienService.themSinhVien(sinhVien);
        sinhVienService.xoaSinhVien("SV01");
        boolean kq = sinhVienService.xoaSinhVien("SV01"); // Xóa lại SV01 đã bị xóa trước đó
        Assertions.assertFalse(kq);
    }

    @Test
    public void xoa04_DanhSachRong() {
        boolean kq = sinhVienService.xoaSinhVien("SV01"); // Xóa khi chưa có sinh viên nào
        Assertions.assertFalse(kq);
    }

    @Test
    public void xoa05_MaRong() {
        boolean kq = sinhVienService.xoaSinhVien(""); // Mã rỗng không hợp lệ
        Assertions.assertFalse(kq);
    }


    /*** Test Tìm Kiếm Sinh Viên ***/
    @Test
    public void timKiem01_TonTai() {
        sinhVienService.themSinhVien(sinhVien);
        SinhVien kq = sinhVienService.timKiemSinhVien("SV01");
        Assertions.assertNotNull(kq);
    }

    @Test
    public void timKiem02_KhongTonTai() {
        SinhVien kq = sinhVienService.timKiemSinhVien("SV99");
        Assertions.assertNull(kq);
    }

    @Test
    public void timKiem03_MaRong() {
        SinhVien kq = sinhVienService.timKiemSinhVien("");
        Assertions.assertNull(kq);
    }
}
