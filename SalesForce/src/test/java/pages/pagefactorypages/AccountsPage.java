package pages.pagefactorypages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//ul[contains(@class, 'branding-actions')]//a[@title='New']")
    private WebElement newButton;

    @FindBy(xpath = "//lightning-formatted-text[contains(@class, 'custom-truncate')]")
    private WebElement createdName;

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Accounts page")
    public AccountsPage openAccountsPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.ACCOUNT_URL));
        driver.get(Urls.SALES_FORCE_LOGIN.concat(Urls.ACCOUNT_URL));
        return this;
    }

    @Step("Starting new account creation")
    public NewAccountModalPage openNewAccountModalPage() {
        LOGGER.debug(String.format("Attempt to start creating new account: %s", newButton));
        newButton.click();
        return new NewAccountModalPage(driver);
    }

    public String getCreatedName() {
        LOGGER.debug(String.format("Get created name: %s", createdName));
        return createdName.getText();
    }
}
