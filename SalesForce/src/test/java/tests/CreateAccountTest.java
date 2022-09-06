package tests;

import models.NewAccountModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.pagefactorypages.AccountsPage;
import pages.pagefactorypages.LoginPage;
import pages.pagefactorypages.NewAccountModalPage;
import testdata.PrepareNewAccountData;

public class CreateAccountTest extends BaseWithFactoryTest {

    @Test
    public void createAccountTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToSalesForce();
        AccountsPage accountsPage = new AccountsPage(driver);
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

        Assert.assertEquals(accountsPage.getCreatedName(), "Alina 123 LLC", "Name doesn't match!");

    }
}
