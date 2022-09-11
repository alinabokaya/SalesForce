package pages.pagefactorypages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Log in to account")
    public void loginToSalesForce() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.SALES_FORCE_LOGIN));
        driver.get(Urls.SALES_FORCE_LOGIN);
        LOGGER.debug(String.format("Attempt to input username: %s", Credentials.USERNAME));
        usernameInput.sendKeys(Credentials.USERNAME);
        LOGGER.debug(String.format("Attempt to input password: %s", Credentials.PASSWORD));
        passwordInput.sendKeys(Credentials.PASSWORD);
        LOGGER.debug(String.format("Attempt to click login button: %s", loginButton));
        loginButton.click();
    }

}
