package com.example.DeMau_KiemThu.bai01;

public class TongChanKhongChiaHet8 {
    // Phương thức tính tổng các số chẵn từ 1-50, loại bỏ số chia hết cho 8
    public static int tinhTong() {
        int sum = 0;
        for (int i = 2; i <= 50; i += 2) { // Chỉ duyệt số chẵn
            if (i % 8 != 0) { // Loại bỏ số chia hết cho 8
                sum += i;
            }
        }
        return sum;
    }
}
