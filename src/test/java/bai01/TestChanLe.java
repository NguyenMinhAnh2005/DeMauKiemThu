package bai01;

import com.example.DeMau_KiemThu.bai01.ChanLe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestChanLe {
    //1 - 100
    //Phân vùng tương đương: số chẵn
    @Test
    public void testSoChan() {
        Assertions.assertTrue(ChanLe.KtraChanLe(2));
        Assertions.assertTrue(ChanLe.KtraChanLe(100));
        Assertions.assertTrue(ChanLe.KtraChanLe(2024));
    }

    //Phân vùng tương đương: số lẻ
    @Test
    public void testSoLe() {
        Assertions.assertFalse(ChanLe.KtraChanLe(1));
        Assertions.assertFalse(ChanLe.KtraChanLe(99));
        Assertions.assertFalse(ChanLe.KtraChanLe(2023));
    }

    //Gía trị biên: số 0
    @Test
    public void testSo_0() {
        Assertions.assertTrue(ChanLe.KtraChanLe(0));
    }

    //Gía trị biên: số nguyên âm chẵn
    @Test
    public void testSoAmChan() {
        Assertions.assertTrue(ChanLe.KtraChanLe(-2));
        Assertions.assertTrue(ChanLe.KtraChanLe(-100));
    }

    // 5.Giá trị biên: số nguyên âm lẻ
    @Test
    public void testSoAmLe() {
        Assertions.assertFalse(ChanLe.KtraChanLe(-1));
        Assertions.assertFalse(ChanLe.KtraChanLe(-99));
    }
}
