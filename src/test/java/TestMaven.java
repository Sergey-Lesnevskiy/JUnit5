import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class TestMaven {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\java\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://a.testaddressbook.com/sign_in");
//1 проверка (логин, пароль)

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sergeybaian@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123321");
        driver.findElement(By.name("commit")).click();
        driver.findElement(By.xpath("//div/a[@data-test='addresses']")).click();
        driver.findElement(By.xpath("//a[@data-test='create']")).click();
//2 проверка  (заполнение анкеты)
        driver.findElement(By.id("address_first_name")).sendKeys("qwe");
        driver.findElement(By.id("address_last_name")).sendKeys("qwe");
        driver.findElement(By.name("address[address1]")).sendKeys("qwe");
        driver.findElement(By.id("address_secondary_address")).sendKeys("qwe");
        driver.findElement(By.name("address[city]")).sendKeys("qwe");
        driver.findElement(By.id("address_state")).click();
        driver.findElement(By.cssSelector("option[value='DE']")).click();
        driver.findElement(By.name("address[zip_code]")).sendKeys("123");
        driver.findElement(By.cssSelector("input[value='us']")).click();
        driver.findElement(By.name("address[birthday]")).sendKeys("12121212");
        driver.findElement(By.name("address[color]")).sendKeys("#4CC016");
        driver.findElement(By.name("address[age]")).sendKeys("321");
        driver.findElement(By.name("address[website]")).sendKeys("https://senlainc.com/");
        driver.findElement(By.name("address[phone]")).sendKeys("801515151515");
        driver.findElement(By.id("address_interest_read")).click();
        driver.findElement(By.id("address_note")).sendKeys("It's interesting.");
        driver.findElement(By.cssSelector("input[value='Create Address']")).click();
        driver.findElement(By.cssSelector("a[data-test='list']")).click();

        //3 проверка (редактирование)

        driver.findElement(By.xpath("//tr[1]//a[text()='Edit']")).click();// если
        driver.findElement(By.id("address_first_name")).clear();
        driver.findElement(By.id("address_first_name")).sendKeys("Sergey");
        driver.findElement(By.id("address_last_name")).clear();
        driver.findElement(By.id("address_last_name")).sendKeys("Lesnevskiy");
        driver.findElement(By.name("address[address1]")).clear();
        driver.findElement(By.name("address[address1]")).sendKeys("Mira");
        driver.findElement(By.id("address_secondary_address")).clear();
        driver.findElement(By.id("address_secondary_address")).sendKeys("21");
        driver.findElement(By.name("address[city]")).clear();
        driver.findElement(By.name("address[city]")).sendKeys("Юрика");
        driver.findElement(By.id("address_state")).click();
        driver.findElement(By.cssSelector("option[value='CA']")).click();
        driver.findElement(By.name("address[zip_code]")).clear();
        driver.findElement(By.name("address[zip_code]")).sendKeys("2312");
        driver.findElement(By.cssSelector("input[value='us']")).click();
        driver.findElement(By.name("address[birthday]")).clear();
        driver.findElement(By.name("address[birthday]")).sendKeys("20022020");
        driver.findElement(By.name("address[color]")).sendKeys("#A61763");
        driver.findElement(By.name("address[age]")).clear();
        driver.findElement(By.name("address[age]")).sendKeys("1");
        driver.findElement(By.name("address[website]")).sendKeys("https://senlainc.com/");
        driver.findElement(By.name("address[phone]")).clear();
        driver.findElement(By.name("address[phone]")).sendKeys("8012121212");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_note")).clear();
        driver.findElement(By.id("address_note")).sendKeys("It's a interesting lesson.");
        driver.findElement(By.cssSelector("input[value='Update Address']")).click();
        driver.findElement(By.cssSelector("a[data-test='list']")).click();
        // 4 проверка (удаление)
        driver.findElement(By.xpath("//tr[1]//a[text()='Destroy']")).click();
        driver.switchTo().alert().accept();//удаление вовсплывающем окне
        //5 проверка (выход)
        driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();

        Thread.sleep(5000);

        driver.quit();

    }

}
