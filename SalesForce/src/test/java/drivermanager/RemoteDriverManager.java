package drivermanager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RemoteDriverManager extends DriverManager{
    @Override
    public void createDriver() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("build", "1");
        sauceOptions.put("name", "Salesforce Create Account");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = null;
        try {
            url = new URL("https://oauth-ali.user.inc-687d0:115ff3a1-689f-4a81-b13b-14513d9865c2@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new RemoteWebDriver(url, browserOptions);
    }
}
