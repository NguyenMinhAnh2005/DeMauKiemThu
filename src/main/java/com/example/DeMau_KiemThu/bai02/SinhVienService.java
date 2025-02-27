package com.example.DeMau_KiemThu.bai02;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> danhSachSinhVien = new ArrayList<>();

    // Thêm sinh viên
    public boolean themSinhVien(SinhVien sv) {
        if (sv == null || sv.getMaSV().isEmpty() || sv.getTen().isEmpty() || sv.getChuyenNganh().isEmpty()) {
            throw new IllegalArgumentException("Lỗi: Các trường không được để trống!");
        }
        if (sv.getTuoi() < 18 || sv.getDiemTrungBinh() < 0 || sv.getDiemTrungBinh() > 10) {
            throw new IllegalArgumentException("Lỗi: Tuổi phải >= 18 và điểm từ 0 đến 10");
        }
        return danhSachSinhVien.add(sv);
    }

    // Sửa thông tin sinh viên
    public boolean suaSinhVien(SinhVien sv, String tenMoi, int tuoiMoi, float diemMoi, int KyMoi, String nganhMoi) {
        if (sv == null || sv.getMaSV().isEmpty() || tenMoi.isEmpty() || nganhMoi.isEmpty()) {
            throw new IllegalArgumentException("Lỗi: Các trường không được để trống!");
        }
        if (tuoiMoi < 18 || diemMoi < 0 || diemMoi > 10 || KyMoi < 0) {
            throw new IllegalArgumentException("Lỗi, vui lòng nhập lại :))");
        }
        sv.setTen(tenMoi);
        sv.setTuoi(tuoiMoi);
        sv.setDiemTrungBinh(diemMoi);
        sv.setChuyenNganh(nganhMoi);
        sv.setKyHoc(KyMoi);
        return true;
    }

    // Xóa sinh viên
    public boolean xoaSinhVien(String maSV) {
        return danhSachSinhVien.removeIf(sv -> sv.getMaSV().equals(maSV));
    }

    // Tìm kiếm sinh viên theo mã
    public SinhVien timKiemSinhVien(String maSV) {
        return danhSachSinhVien.stream()
                .filter(sv -> sv.getMaSV().equals(maSV))
                .findFirst()
                .orElse(null);
    }
}
