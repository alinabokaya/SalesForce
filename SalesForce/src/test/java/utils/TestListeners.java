package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseWithFactoryTest;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Object currentClass = iTestResult.getInstance();
        WebDriver driver = ((BaseWithFactoryTest) currentClass).getDriver();
        AllureService allureService = new AllureService();
        allureService.getSystemName();
        allureService.takeScreenshot(driver);
    }
}
