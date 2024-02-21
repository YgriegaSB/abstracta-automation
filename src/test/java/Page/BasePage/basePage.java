package Page.BasePage;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
public class basePage {
    WebDriver driver;
    private static final int WAIT_TIMEOUT=3;
    private static final int POLLING = 10;
    JavascriptExecutor js;
    //private final WebDriverWait wait;

    protected basePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,WAIT_TIMEOUT), this);
    }

    protected WebDriver getDriver(){
        return driver;
    }

    protected boolean isVisible(WebElement webElement) throws NoSuchElementException{
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e){
            System.out.println("Exception:" +webElement);
            return false;
        }
    }

    protected boolean isInvisible(WebElement element){
        try {
            return !element.isDisplayed();
        } catch (java.util.NoSuchElementException | StaleElementReferenceException e){
            return true;
        }catch (Exception e){
            throw new ConditionTimeoutException(String.format("No se encuentra el elemento despues de 30 segundos\nElemento: %s", element));
        }
    }
    protected boolean isEnabled (WebElement webElement) throws NoSuchElementException{
        try {
            return webElement.isEnabled();
        } catch (NoSuchElementException e){
            System.out.println("Exception:" +webElement);
            return false;
        }
    }

    protected void waitUntilElementIsVisible(WebElement element){
        try{
            await().atMost(WAIT_TIMEOUT, SECONDS).until(()->isVisible(element));
        }catch (ConditionTimeoutException e){
            throw new ConditionTimeoutException(String.format("No se encuentra el elemento despues de 30 segundos\nElemento: %s", element));
        }
    }

    protected void waitUntilElementIsEnabled(WebElement element){
        try{
            await().atMost(30, SECONDS).until(()->isEnabled(element));
        }catch (ConditionTimeoutException e){
            throw new ConditionTimeoutException(String.format("Elemento no disponible despues de 30 segundos\nElemento: %s", element));
        }
    }

    protected void waitUntilElementIsVisible(By element){
        try{
            await().atMost(WAIT_TIMEOUT, SECONDS).until(()->isVisible(element));
        }catch (ConditionTimeoutException e){
            throw new ConditionTimeoutException(String.format("No se encuentra el elemento despues de 30 segundos\nElemento: %s", element));
        }
    }

    protected void waitUntilElementIsInVisible(WebElement element){
        try{
            await().atMost(WAIT_TIMEOUT, SECONDS).until(()->isInvisible(element));
        }catch (ConditionTimeoutException e){
            throw new ConditionTimeoutException(String.format("El elemento no desaparece despues de 30 segundos\nElemento: %s", element));
        }
    }

    protected void waitFor(int segundos){
        try {
            Thread.sleep(segundos*1000);
        }catch (InterruptedException ignored){
        }
    }

    public byte[] takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    protected boolean isVisible(By element) throws Exception {
        try {
            return getDriver().findElement(element).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            System.out.println("El elemento no esta visible en la pagina web");
            //throw new NoSuchElementException("");
            return false;
        } catch (Exception e) {
            System.out.println("El elemento no esta visible: " +element);
            return false;
        }
    }

    protected void waitUntilElementIsVisibleNonThrow(WebElement element, int WAIT_TIMEOUT){
        try{
            await().atMost(WAIT_TIMEOUT, SECONDS).until(()->isVisible(element));
        } catch (ConditionTimeoutException e) {
            throw new ConditionTimeoutException(String.format("El elemento no desaparece despues de 30 segundos\nElemento: %s", element));
            //System.out.println("El tiempo maximo de espera ha sido superado no se ha encontrado: "+ WAIT_TIMEOUT);
        }
    }

    public void waitUntilElementIsVisibleNonThrow(By element, int WAIT_TIMEOUT){
        try{
            await().atMost(WAIT_TIMEOUT, SECONDS).until(()->isVisible(element));
        } catch (ConditionTimeoutException e) {
            throw new ConditionTimeoutException(String.format("El elemento no desaparece despues de 30 segundos\nElemento: %s", element));
            //System.out.println("El tiempo maximo ha sido superado"+ element);
        }
    }

    public String getGlobalText(String text){
        By selector = By.xpath("//*[text()='"+text+"']");
        waitUntilElementIsVisible(selector);
        WebElement globalTextElement = getDriver().findElement(selector);
        return globalTextElement.getText();
    }

    public void SelectFile(WebElement element){
        File file = new File("");
        String path = file.getAbsolutePath();

    }

    public void clickGlobalText(String text){
        By selector = By.xpath("//*[text()='"+text+"']");
        waitUntilElementIsVisible(selector);
        WebElement globalClickText = getDriver().findElement(selector);
        globalClickText.click();
    }

    public Boolean isFileDownloaded() {

        boolean result = false;
        JavascriptExecutor jse = (JavascriptExecutor) this.getDriver();
        String javaScript = "browserstack_executor: {\"action\": \"fileExists\"}";

        await().atMost(WAIT_TIMEOUT, SECONDS)
                .until(() -> Boolean.parseBoolean(String.valueOf(jse.executeScript(javaScript))));
        result = Boolean.parseBoolean(String.valueOf(jse.executeScript(javaScript)));
        return result;
    }

    protected void moveToElement (WebElement element){
       try {
           new Actions(driver)
                   .moveToElement(element)
                   .perform();
       }catch (NoSuchElementException e){
           System.out.println("No se encuentra el elemento");
       }
    }

    public void scrollDownToElement(WebElement element) {
        try{
            if(js!=null) js=(JavascriptExecutor) driver;
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e){
            System.out.println("Problemas en el scroll down element");
        }

    }
    public void executeJavaScript(String script) throws Exception {
        try{
            ((JavascriptExecutor)driver).executeScript(script);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public Boolean executeJavaScript(String script, WebElement elemento) throws Exception {
        try{
            ((JavascriptExecutor)driver).executeScript(script,elemento);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public Boolean executeClickWithJavaScript(WebElement elemento) throws Exception {
        try{
            ((JavascriptExecutor)driver).executeScript("arguments[0].click()",elemento);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void excecuteJavaScriptToManyElements(String script, List<WebElement> elementos) throws Exception {
        throw new Exception("In Progress...");
    }
    public void clickElementUsingScript(WebElement elem){
        if(js!=null) js=(JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elem);
    }

    public void scrollDown(){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)");
    }
    public Boolean changeValueToElement(WebElement element, String value) throws Exception {
        try{
            ((JavascriptExecutor)driver).executeScript("arguments[0].value='"+value+"';", element);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void scrollDown(String pixel){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixel+")");
    }
    public Boolean selectOption(WebElement element, String option){
        try{
            Select cbxUser = new Select(element);
            cbxUser.selectByVisibleText(option);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}