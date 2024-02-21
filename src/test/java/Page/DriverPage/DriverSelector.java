package Page.DriverPage;

import Constants.Constants;
import Utl.ScenarioContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface WebDriverSelector { WebDriver initDriver();}
public class DriverSelector {
    private static List<String> getOptionList(){
        List<String> optionList = new ArrayList<String>();
        optionList.add("start-maximized");
        optionList.add("--remote-allow-origins=*");
        optionList.add("ignore-certificate-errors");
        optionList.add("disable-infobars");
        optionList.add("disable-extensions");
        optionList.add("--disable-dev-shm-usage");
        optionList.add("--no-sandbox");
        if (System.getenv("ENVIRONMENT").equals(Constants.ENVIRONMENTS.get("PRODUCTION"))){
            optionList.add("--headless");
            optionList.add("--disable-gpu");
            optionList.add("--window-size=1920,1080");
        }
        return optionList;
    }
    private static HashMap<String, WebDriverSelector> getDrivers(){
        HashMap<String, WebDriverSelector> drivers = new HashMap<>();
        drivers.put(Constants.BROWSERS.get("CHROME"), ()-> {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(getOptionList());
            WebDriver driver = new ChromeDriver(options);
            return driver;
        });
        drivers.put(Constants.BROWSERS.get("EDGE"), ()->{
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments(getOptionList());
            WebDriver driver = new EdgeDriver(options);
            return driver;
        });
        return drivers;
    }
    public static WebDriver driverSelector() throws Exception {
        String browserName = ScenarioContext.getInstance().getEnvVariable("BROWSER");
        if(!getDrivers().containsKey(browserName)) throw new IllegalArgumentException("Browser not found");
        WebDriver driver = getDrivers().get(browserName).initDriver();
        driverPage.addDriver(driver);
        return driver;
    }
}
