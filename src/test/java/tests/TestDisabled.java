package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.Log;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestDisabled {
    private WebDriver driver = Driver.getChromeDriver();

    @BeforeAll
    public void openPage() {
        Log.info("открываем страницу регистации ивводим пароль");
        driver.get("http://a.testaddressbook.com/sign_in");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle, "Не открыта страница регитрации");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("sergeybaian@mail.ru");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123321");
        driver.findElement(By.name("commit")).click();

        Log.info("проверяем перешлили мы главную страницу сайта ");
        String pageHome = driver.getTitle();
        Assertions.assertEquals("Address Book", pageHome, "Не перешли на главную страницу");
        Log.info("переходим на страницу просмотров адресов");
        driver.findElement(By.xpath("//div/a[@data-test='addresses']")).click();
    }

    @Test
    @DisplayName("Добавление адреса")
    public void testAddAddress() {

        Log.info("переходим на страницу добавления адресов");
        driver.findElement(By.xpath("//a[@data-test='create']")).click();
        Log.info("перешли на страницу ввода данных");
        driver.findElement(By.xpath("//div[1]/input[@class='form-control col']")).sendKeys("qwe");
        driver.findElement(By.id("address_last_name")).sendKeys("qwe");
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

        Log.info("Проверяем как записалось FirstName");
        WebElement firstname = driver.findElements(By.xpath("//tr/td[1]")).get(0);
        String pageFirstName = firstname.getText();
        Assertions.assertEquals("qwe", pageFirstName, "FirstName");

        Log.info("Проверяем как записалось LastName");
        WebElement lastname = driver.findElements(By.xpath("//tr/td[2]")).get(0);
        String pageLastName = lastname.getText();
        Assertions.assertEquals("qwe", pageLastName, "Не записалось LastName");
        Log.info("Проверяем как записалось City");
        WebElement city = driver.findElements(By.xpath("//tr/td[3]")).get(0);
        String pageCity = city.getText();
        Assertions.assertEquals("rew", pageCity, "Не записалось City");
        Log.info("Проверяем как записалось State");
        WebElement State = driver.findElements(By.xpath("//tr/td[4]")).get(0);
        String pageState = State.getText();
        Assertions.assertEquals("DE", pageState, "Не записалось State");
    }

    @Disabled
    @Test
    @DisplayName("Редактирование адреса")
    public void testChangeAddress() {
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
        Log.info("Проверяем как записалось FirstName");
        WebElement firstname = driver.findElements(By.xpath("//tr/td[1]")).get(0);
        String pageFirstName = firstname.getText();
        Assertions.assertEquals("Sergey", pageFirstName, "FirstName");

        Log.info("Проверяем как записалось LastName");
        WebElement lastname = driver.findElements(By.xpath("//tr/td[2]")).get(0);
        String pageLastName = lastname.getText();
        Assertions.assertEquals("Lesnevskiy", pageLastName, "Не записалось LastName");
        Log.info("Проверяем как записалось City");
        WebElement city = driver.findElements(By.xpath("//tr/td[3]")).get(0);
        String pageCity = city.getText();
        Assertions.assertEquals("Юрика", pageCity, "Не записалось City");
        Log.info("Проверяем как записалось State");
        WebElement State = driver.findElements(By.xpath("//tr/td[4]")).get(0);
        String pageState = State.getText();
        Assertions.assertEquals("CA", pageState, "Не записалось State");
    }

    @Test
    @DisplayName("Удаление адреса")
    public void testDeleteAddress() {
        driver.findElement(By.xpath("//tr[1]//a[text()='Destroy']")).click();
        driver.switchTo().alert().accept();
        Log.info("Проверяем удаление адреса");
        WebElement lastname = driver.findElements(By.xpath("//tr/td[2]")).get(0);
        String pageLastName = lastname.getText();
        Assertions.assertEquals("qwe", pageLastName, "Есть такой адрес");
    }

    @Disabled
    @Test
    @DisplayName("Выход со страницы")
    public void testOut() {
        Log.info("Выходим на страницу регистрации");
        driver.findElement(By.xpath("//a[@data-test='sign-out']")).click();
        String pageTitle2 = driver.getTitle();
        Assertions.assertEquals("Address Book - Sign In", pageTitle2, "Не открыта страница регитрации");
    }


    @AfterAll
    public void tearDown() {

        Log.info("Закрываем браузер");
        driver.quit();


    }


}






