package Runner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class test {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver_win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://tiki.vn/");
        driver.manage().window().maximize();
    }
    @Test
    public void Search(){
        WebElement keySearch=driver.findElement(By.xpath("//input[@data-view-id='main_search_form_input']"));
        WebElement buttonSearch=driver.findElement(By.xpath("//button[@data-view-id='main_search_form_button']"));
        WebElement anhSP=driver.findElement(By.xpath("//img[@alt='Bàn phím dành cho Laptop Asus X451c, Asus X451ca']"));

        keySearch.sendKeys("Asus");
        buttonSearch.click();
        anhSP.click();


        WebElement tieuDe = driver.findElement(By.xpath("//div[@class='header']//h1[@class='title']"));
        Assert.assertEquals("Bàn phím dành cho Laptop Asus X451c, Asus X451ca",tieuDe.getText());
        WebElement giaBan = driver.findElement(By.xpath("//div[@class='product-price']//span[@class='product-price__current-price']"));
        Assert.assertEquals("275.000 ₫",giaBan.getText());
        WebElement anh = driver.findElement(By.xpath("//div[@class='container']//div//div//img"));
        Assert.assertTrue(anh.isDisplayed());
        WebElement thoigianBH = driver.findElement(By.xpath("//div[@class='warranty-item']//span[@class='itemRight']"));
        Assert.assertEquals("12 Tháng",thoigianBH.getText());
        WebElement hinhthucBH = driver.findElement(By.xpath("//div[@class='warranty-item']//span[@class='itemRight']"));
        Assert.assertEquals("Tem bảo hành",hinhthucBH.getText());
        WebElement btnChonMua = driver.findElement(By.xpath("//div[@class='group-button']//button[@class='btn btn-add-to-cart']"));
        Assert.assertEquals("Chọn Mua",btnChonMua.getText());
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
