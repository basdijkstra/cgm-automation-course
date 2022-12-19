package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.models.User;

public class LoginPage extends BasePage {

    private final By textfieldUsername = By.name("username");
    private final By textfieldPassword = By.name("password");
    private final By buttonDoLogin = By.xpath("//input[@value='Log In']");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get("https://parabank.parasoft.com");
    }

    public void loginAs(String username, String password) {
        sendKeys(textfieldUsername, username);
        sendKeys(textfieldPassword, password);
        click(buttonDoLogin);
    }

    public void loginAs(User user) {
        sendKeys(textfieldUsername, user.getUsername());
        sendKeys(textfieldPassword, user.getPassword());
        click(buttonDoLogin);
    }
}
