package bai03;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;

public class TestTrangWeb {
    ChromeDriver chromeDriver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=/tmp/chrome-profile"); // Tạo profile riêng biệt
        options.addArguments("--disable-dev-shm-usage"); // Tránh lỗi trên Docker
        options.addArguments("--remote-allow-origins=*"); // Tránh lỗi kết nối trình duyệt
        chromeDriver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }

    @Test
    public void testDangKi(){
        chromeDriver.get("https://vitimex.com.vn/dang-ky.html");

        //Nhập họ tên
        WebElement inputName = chromeDriver.findElement(By.xpath("//input[@id='name']"));
                inputName.sendKeys("Nguyen Minh Anh");

        //Nhập sđt
        WebElement inputPhone = chromeDriver.findElement(By.xpath("//input[@id='phone']"));
        inputPhone.sendKeys("0972302542");

        //Nhập email
        WebElement inputEmail = chromeDriver.findElement(By.xpath("//input[@id='email']"));
        inputEmail.sendKeys("ntma@gmail.com");

        //Nhập mật khẩu
        WebElement inputPass = chromeDriver.findElement(By.xpath("//input[@id='pass-regis']"));
        inputPass.sendKeys("ntma2005");

        //Nhập xác nhận mật khẩu
        WebElement inputXacNhan = chromeDriver.findElement(By.xpath("//input[@id='pass-confirm']"));
        inputXacNhan.sendKeys("ntma2005");

        //Nút đăng kí
        WebElement inputDangky = chromeDriver.findElement(By.xpath("//a[@id='register-btn']"));
        inputDangky.click();
    }


    @Test
    public void testDangNhap() throws InterruptedException {
        chromeDriver.get("https://vitimex.com.vn/");
        WebElement loginIcon = chromeDriver.findElement(By.xpath("//div[@class='li_log']//a[@data-bs-toggle='modal']//*[name()='svg']"));
        loginIcon.click();
        Thread.sleep(2000); // Đợi popup hiện

        //Nhập sdt
        WebElement inputPhone = chromeDriver.findElement(By.xpath("//input[@id='account']"));
        inputPhone.sendKeys("0972302542");

        //Nhập mật khẩu
        WebElement inputPass = chromeDriver.findElement(By.xpath("//input[@id='pass']"));
        inputPass.sendKeys("ntma2005");

        //Nút đăng nhập
        WebElement buttonDangNhap = chromeDriver.findElement(By.xpath("//a[@id='signin-btn']"));
        buttonDangNhap.click();
    }


    @Test
    public void testThemSPVaoGioHang() {
        //Test cho sp vào giỏ hàng
        chromeDriver.get("https://vitimex.com.vn/ao-polo-nam-vitimex-atr3006-dp825.html");

        // Tìm sản phẩm đầu tiên trên trang chủ
        WebElement inputAnh = chromeDriver.findElement(By.xpath("//div[@class='slider-for slick-initialized slick-slider']//div[@class='slick-list draggable']//div[@class='slick-track']//div[@class='slick-slide slick-current slick-active']//div//img[@class='img-fluid']"));
        inputAnh.click();

        //Nhập màu sắc
        WebElement inputColor = chromeDriver.findElement(By.xpath("//span[@class='chose-color']"));
        inputColor.click();
        //Nhập size
        WebElement inputSize = chromeDriver.findElement(By.xpath("//a[@id='size3']"));
        inputSize.click();

        //Nút Thêm giỏ hàng
        WebElement inputGioHang = chromeDriver.findElement(By.xpath("(//a[@id='addCart_page0'])[1]"));
        inputGioHang.click();
    }
}
