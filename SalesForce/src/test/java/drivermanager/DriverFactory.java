package drivermanager;

public class DriverFactory {

    public DriverManager getManager(drivermanager.DriverType driverType) {

        DriverManager driverManager;

        switch (driverType) {
            case CHROME:
                driverManager = new drivermanager.ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new drivermanager.FirefoxDriverManager();
                break;
            case REMOTE:
                driverManager = new drivermanager.RemoteDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
            default:
                throw new IllegalStateException("Unexpected driver type " + driverType);
        }
        return driverManager;
    }
}