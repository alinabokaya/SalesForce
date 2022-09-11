package pages.pagefactorypages;

import elements.DropdownList;
import elements.TextArea;
import elements.TextInput;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import models.NewAccountModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAccountModalPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//span[text()='Account Name']//parent::label//following-sibling::div//input")
    private WebElement accountNameInput;

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//button[@title='Save']")
    private WebElement saveButton;

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in account data")
    public NewAccountModalPage fillInAccountForm(NewAccountModel newAccount) {
        LOGGER.debug("Fill in account data");
        accountNameInput.sendKeys((newAccount.getAccountName()));
        new TextInput(driver, "Phone").inputText(newAccount.getPhone());
        new DropdownList(driver, "Type").selectOptionList(newAccount.getType());
        new DropdownList(driver, "Industry").selectOptionList(newAccount.getIndustry());
        new TextArea(driver, "Description").inputAreaText(newAccount.getDescription());
        new TextArea(driver, "Billing Street").inputAreaText(newAccount.getBillingStreet());
        new TextArea(driver, "Shipping Street").inputAreaText(newAccount.getShippingStreet());
        new TextInput(driver, "Website").inputText(newAccount.getWebsite());
        new TextInput(driver, "Employees").inputText(newAccount.getWebsite());
        new TextInput(driver, "Billing City").inputText(newAccount.getBillingCity());
        new TextInput(driver, "Billing State/Province").inputText(newAccount.getBillingState());
        new TextInput(driver, "Shipping City").inputText(newAccount.getShippingCity());
        new TextInput(driver, "Shipping State/Province").inputText(newAccount.getShippingState());
        new TextInput(driver, "Billing Zip/Postal Code").inputText(newAccount.getBillingZip());
        new TextInput(driver, "Shipping Zip/Postal Code").inputText(newAccount.getShippingZip());
        new TextInput(driver, "Billing Country").inputText(newAccount.getBillingCountry());
        new TextInput(driver, "Shipping Country").inputText(newAccount.getShippingCountry());
        return this;
    }

    @Step("Save account")
    public NewAccountModalPage clickSaveButton() {
        LOGGER.debug(String.format("Attempt to save new account: %s", saveButton));
        saveButton.click();
        return this;
    }
}
