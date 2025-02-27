package com.example.DeMau_KiemThu.bai01;
//kiểm tra số nguyên âm trong dãy số - 5, 6, -7, -9, 0, -1
public class SoNguyenAm {
    public static boolean SoNguyen(int[] so) {
        for (int num : so) {
            if (num < 0) return true;
        }
        return false;
    }
}
