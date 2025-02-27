package bai01;

import com.example.DeMau_KiemThu.bai01.TongHaiSoChan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTongHaiSoChan {
    @Test
    void testTongChan() {
        assertTrue(TongHaiSoChan.tongChan(2, 4));  //Cả hai số là chẵn → tổng luôn chẵn
        assertTrue(TongHaiSoChan.tongChan(0, 8));  //0 là số chẵn → tổng vẫn chẵn
        assertTrue(TongHaiSoChan.tongChan(-2, -4));  //Số âm nhưng vẫn là số chẵn → tổng chẵn
        assertFalse(TongHaiSoChan.tongChan(3, 4));  //Một số lẻ + một số chẵn → tổng lẻ
        assertTrue(TongHaiSoChan.tongChan(1, 3)); //Cả hai số là lẻ → tổng chẵn
    }
}
