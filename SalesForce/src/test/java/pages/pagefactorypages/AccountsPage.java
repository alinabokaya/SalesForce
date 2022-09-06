package pages.pagefactorypages;

import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountsPage extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'branding-actions')]//a[@title='New']")
    private WebElement newButton;

    @FindBy(xpath = "//lightning-formatted-text[contains(@class, 'custom-truncate')]")
    private WebElement createdName;

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    public AccountsPage openAccountsPage() {
        driver.get(Urls.SALES_FORCE_LOGIN.concat(Urls.ACCOUNT_URL));
        return this;
    }

    public NewAccountModalPage openNewAccountModalPage() {
        newButton.click();
        return new NewAccountModalPage(driver);
    }

    public String getCreatedName() {
        return createdName.getText();
    }
}
