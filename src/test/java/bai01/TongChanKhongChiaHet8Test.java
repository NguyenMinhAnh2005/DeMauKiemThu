package bai01;

import com.example.DeMau_KiemThu.bai01.TongChanKhongChiaHet8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TongChanKhongChiaHet8Test {
    // 1. Kiểm tra tổng chính xác của các số chẵn từ 1-50 (loại bỏ số chia hết cho 8)
    @Test
    public void testTongChinhXac() {
        int expSum = 2 + 4 + 6 + 10 + 12 + 14 + 18 + 20 + 22 + 26 + 28 + 30
                + 34 + 36 + 38 + 42 + 44 + 46 + 50; // Không gồm 8, 16, 24, 32, 40, 48
        Assertions.assertEquals(expSum, TongChanKhongChiaHet8.tinhTong());
    }

    // 2. Gtrị biên: Tổng có chứa số chẵn nhỏ nhất (2)
    @Test
    public void testCoSoChanNhoNhat() {
        Assertions.assertTrue(TongChanKhongChiaHet8.tinhTong() >= 2);
    }

    // 3. gtrị biên: Tổng không chứa số lớn nhất chia hết cho 8 (48)
    @Test
    public void testKhongChuaSoChiaHet8() {
        int tong = TongChanKhongChiaHet8.tinhTong();
        Assertions.assertFalse(tong % 8 == 0, "Tổng không nên chia hết cho 8");
    }

    // 4. gtrị biên: Tổng có chứa số chẵn lớn nhất (50)
    @Test
    public void testCoSoChanLonNhat() {
        Assertions.assertTrue(TongChanKhongChiaHet8.tinhTong() >= 50);
    }
}
