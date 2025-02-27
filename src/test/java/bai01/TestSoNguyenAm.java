package bai01;

import com.example.DeMau_KiemThu.bai01.SoNguyenAm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSoNguyenAm {
    @Test
    void testSoNguyen(){
        assertTrue(SoNguyenAm.SoNguyen(new int[]{-5, 6, -7, -9, 0, -1}));//Có số âm trong mảng
        assertFalse(SoNguyenAm.SoNguyen(new int[]{1, 2, 3, 4}));//Không có số âm
        assertTrue(SoNguyenAm.SoNguyen(new int[]{-1}));//Mảng chỉ có một số âm
        assertFalse(SoNguyenAm.SoNguyen(new int[]{}));//Không có số nào nên không có số âm
        assertTrue(SoNguyenAm.SoNguyen(new int[]{-5, -6, -7}));//Toàn bộ mảng là số âm
    }
}
