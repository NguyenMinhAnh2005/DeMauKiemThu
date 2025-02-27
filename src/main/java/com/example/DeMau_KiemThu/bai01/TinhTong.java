package com.example.DeMau_KiemThu.bai01;

//tính tổng của một mảng số nguyên.
public class TinhTong {
    public int tinhTong(int[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Mảng không được null");
        }
        int tong = 0;
        for (int i : a) {
            tong += i;
        }
        System.out.println(tong);
        return tong;
    }
}
