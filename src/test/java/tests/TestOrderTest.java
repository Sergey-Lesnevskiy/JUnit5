package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOrderTest {
    private WebDriver driver = Driver.getChromeDriver();

    @Test
    @Order(1)
    public void open() {
        System.out.println("Открываем страницу");
        driver.get("http://a.testaddressbook.com/sign_in");
        driver.close();
    }

    @Test
    @Order(2)
    public void write() {
        driver.get("http://a.testaddressbook.com/sign_in");
        System.out.println("Заполняем поля");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sergeybaian@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123321");
        driver.findElement(By.name("commit")).click();
        driver.close();
    }

    @Test
    @Order(3)
    public void fill() {
        driver.get("http://a.testaddressbook.com/sign_in");

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sergeybaian@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123321");
        driver.findElement(By.name("commit")).click();
        Log.info("переходим на страницу добавления адресов");
        driver.findElement(By.xpath("//div/a[@data-test='addresses']")).click();
        driver.findElement(By.xpath("//a[@data-test='create']")).click();
        Log.info("перешли на страницу ввода данных");
        driver.findElement(By.xpath("//div[1]/input[@class='form-control col']")).sendKeys("qwe");
        driver.findElement(By.id("address_last_name")).sendKeys("eewq");
        driver.findElement(By.name("address[address1]")).sendKeys("rew");
        driver.findElement(By.id("address_secondary_address")).sendKeys("qwe");
        driver.findElement(By.name("address[city]")).sendKeys("rew");
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
        driver.close();
    }

    @Test
    @Order(4)
    public void change() {
        driver.get("http://a.testaddressbook.com/sign_in");

        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sergeybaian@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123321");
        driver.findElement(By.name("commit")).click();
        Log.info("переходим на страницу добавления адресов");
        driver.findElement(By.xpath("//div/a[@data-test='addresses']")).click();
        driver.findElement(By.xpath("//a[@data-test='create']")).click();
        Log.info("перешли на страницу ввода данных");


        driver.findElement(By.xpath("//tr[1]//a[text()='Edit']")).click();
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
        driver.close();


    }

    @Test
    @Order(5)
    public void delete() {
        driver.get("http://a.testaddressbook.com/sign_in");
        System.out.println("Заполняем поля");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sergeybaian@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123321");
        driver.findElement(By.name("commit")).click();

        driver.findElement(By.xpath("//div/a[@data-test='addresses']")).click();
        driver.findElement(By.xpath("//tr[1]//a[text()='Destroy']")).click();
        driver.switchTo().alert().accept();
    }

    @Test
    @Order(6)
    public void testOut() {
        driver.get("http://a.testaddressbook.com/sign_in");
        System.out.println("Заполняем поля");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sergeybaian@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123321");
        driver.findElement(By.name("commit")).click();
        Log.info("Выходим на страницу регистрации");
        driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();
        driver.quit();
    }
}
