package bai01;

import com.example.DeMau_KiemThu.bai01.TinhTong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTinhTong {
    TinhTong tt = new TinhTong();

    // Mảng số nguyên từ 1-> 5
    @Test
    public void testTinhTong_MangSoNguyen(){
        int [] so = {1, 2, 3, 4, 5};
        Assertions.assertEquals(15,tt.tinhTong(so));
    }

    // Test tổng của mảng rỗng (kq phải là 0)
    @Test
    public void testTinhTong_MangRong() {
        int[] so = {};
        Assertions.assertEquals(0, tt.tinhTong(so));
    }

    // Test truyền vào mảng null
    @Test
    public void testTinhTong_MangNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            tt.tinhTong(null);
        });
    }

}
