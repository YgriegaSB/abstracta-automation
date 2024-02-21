package Page.DriverPage;

import org.openqa.selenium.WebDriver;

public final class driverPage {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public driverPage(){}

    public static WebDriver getDriver() {
        return drivers.get();
    }

    public static void addDriver(WebDriver driver){
        drivers.set(driver);
    }
}
