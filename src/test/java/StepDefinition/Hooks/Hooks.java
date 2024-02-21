package StepDefinition.Hooks;
import Page.DriverPage.DriverSelector;
import Utl.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Map;

public class Hooks {
    private static final Logger logger =LoggerFactory.getLogger(Hooks.class);
    private WebDriver driver;
    private ScenarioContext context;
    @Before
    public void beforeScenario(Scenario scenario) throws IOException,Exception {
        Map<String,String> variablesEntorno = Utilidades.getEnv();
        context = ScenarioContext.getInstance();
        context.clearContextData();
        context.setContextData("env",variablesEntorno);
        driver = DriverSelector.driverSelector();
        logger.info("Nombre de escenario: " + scenario.getName());
        logger.info("Tag: " + scenario.getSourceTagNames().stream().findFirst().toString().split("@")[1].split("]")[0]);
        logger.info("Configurando Scenario Context");
        context.setContextData("driver",driver);
        context.setContextData("scenario",scenario);
        context.setContextData("environment",variablesEntorno);
        context.setContextData("tag",scenario.getSourceTagNames().stream().findFirst().toString().split("@")[1].split("]")[0]);
        context.setContextData("rutaEjecucion",String.valueOf(System.currentTimeMillis()));
    }
    @After
    public void Close(Scenario scenario) throws Exception {
        logger.info("Cerrando Driver");
        Thread.sleep(3000);
        driver.quit();
    }
}
