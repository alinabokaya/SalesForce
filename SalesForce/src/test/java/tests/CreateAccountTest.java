package tests;

import io.qameta.allure.Description;
import models.NewAccountModel;
import org.testng.Assert;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.pagefactorypages.AccountsPage;
import pages.pagefactorypages.LoginPage;
import pages.pagefactorypages.NewAccountModalPage;
import testdata.PrepareNewAccountData;

public class CreateAccountTest extends BaseWithFactoryTest {

    private static  final Logger LOGGER = LogManager.getLogger(CreateAccountTest.class.getName());

    @Test
    @Description("New account creation")
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LOGGER.info(String.format("Sign in to account"));
        loginPage.loginToSalesForce();
        LOGGER.info(String.format("Page %s initialised", AccountsPage.class.getName()));
        AccountsPage accountsPage = new AccountsPage(driver);
        LOGGER.info("Start creating new account");
        NewAccountModalPage newAccountModalPage = new NewAccountModalPage(driver);
        NewAccountModel accountModel = PrepareNewAccountData.getValidData();
        accountsPage.
                openAccountsPage().
                openNewAccountModalPage().
                fillInAccountForm(accountModel);

        String name = accountModel.getAccountName();
        System.out.println(name);
        newAccountModalPage.clickSaveButton();
        System.out.println(accountsPage.getCreatedName());

        LOGGER.info("Check created name is correct");
        Assert.assertEquals(accountsPage.getCreatedName(), name, "Name doesn't match!");

    }
}
