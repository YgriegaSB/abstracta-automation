package Page.WebPage.PruebaQAPage;

import Page.BasePage.basePage;
import Page.ExceptionPage.ExceptionPage;
import Utl.ScenarioContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class VideojsPage extends basePage {
    public VideojsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//h2[text()='Advanced Example']")
    private WebElement textHeader;
    @FindBy(xpath = "//button[@class='vjs-big-play-button']")
    private WebElement btnBigButtonPlay;
    @FindBy(xpath = "//button[@class='vjs-play-control vjs-control vjs-button vjs-playing']")
    private WebElement btnSmallButtonPlay;;
    @FindBy(xpath = "//li[@class='vjs-playlist-item vjs-up-next']")
    private WebElement liNextVideo;
    @FindBy(xpath = "(//li[@class='vjs-playlist-item'])[2]")
    private WebElement liSubVideo;
    @FindBy(xpath = "//button[@class='vjs-mute-control vjs-control vjs-button vjs-vol-3']")
    private WebElement btnMuteFull;
    @FindBy(xpath = "//button[@class='vjs-mute-control vjs-control vjs-button vjs-vol-0']")
    private WebElement btnMuteEmpty;
    @FindBy(xpath = "//button[@class='vjs-subs-caps-button vjs-menu-button vjs-menu-button-popup vjs-button']/parent::div")
    private WebElement btnSub;
    @FindBy(xpath = "//video")
    private WebElement video;
    @FindBy(xpath = "//span[@class='vjs-remaining-time-display']")
    private WebElement txtTiempoRestante;
    @FindBy(xpath = "//button[@class='vjs-audio-button vjs-menu-button vjs-menu-button-popup vjs-button']/parent::div")
    private WebElement btnAudioDesc;
    @FindBy(xpath = "//span[text()='Audio Described']")
    private WebElement optAudioDesc;
    @FindBy(xpath = "//button[@title='Picture-in-Picture']")
    private WebElement btnPIP;
    @FindBy(xpath = "//p[text()='Playing in picture-in-picture']")
    private WebElement txtPIP;
    @FindBy(xpath = "//button[@title='Fullscreen']")
    private WebElement btnPantallaCompleta;
    @FindBy(xpath = "//button[@title='Chapters']")
    private WebElement btnChapters;
    @FindBy(xpath = "//button[@title='Replay']")
    private WebElement btnReplay;


    public boolean isvisibleTextHeader() throws Exception {
        try {
            waitUntilElementIsVisible(textHeader);
            return isVisible(textHeader);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public void clickBtnBigButtonPlay() throws Exception {
        try{
            waitUntilElementIsEnabled(btnBigButtonPlay);
            if (!btnBigButtonPlay.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnBigButtonPlay.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnSmallButtonPlay() throws Exception {
        try{
            moveToElement(video);
            waitUntilElementIsEnabled(btnSmallButtonPlay);
            if (!btnSmallButtonPlay.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnSmallButtonPlay.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    public boolean isPlaying() throws Exception {
        try{
            //Debido a un problema con el entorno de ejecucion, esto se podria resumir en un .getText() a el elemento web que contiene el % de reproduccion del video.
            WebElement element = getDriver().findElement(By.xpath("(//div[@class='vjs-time-tooltip'])[2]"));
            String valor = (String) ((JavascriptExecutor) ScenarioContext.getInstance().getContextData("driver")).executeScript("return arguments[0].textContent;", element);
            if (valor.equals("0.00")){throw new ExceptionPage("El video no se esta reproduciendo");}
            return true;
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public boolean waitUntilVideoisFinishedd() throws Exception {
        try{
            //Debido a un problema con el entorno de ejecucion, esto se podria resumir en un .getText() a el elemento web que contiene el % de reproduccion del video.
            WebElement element = getDriver().findElement(By.xpath("(//div[@class='vjs-time-tooltip'])[2]"));
            boolean isFinished = new WebDriverWait((WebDriver)ScenarioContext.getInstance().getContextData("driver"), Duration.ofSeconds(12))
                    .until(d -> ((JavascriptExecutor) d).executeScript("return arguments[0].textContent.trim();", element).equals("100.00")); // Example completion condition
            return isFinished;
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public boolean waitUntilVideoIsFinished() throws Exception {
        try {
            By selector = By.xpath("//span[@class='vjs-remaining-time-display']");
            new WebDriverWait(getDriver(), Duration.ofSeconds(300)).until(ExpectedConditions.textToBe(selector, "0:00"));
            return true;
        } catch (ExceptionPage e) { // Custom exception handling
            throw new ExceptionPage(e.getMessage());
        } catch (Exception e) { // Generic exception handling
            throw new Exception(e.getMessage());
        }
    }



    public boolean isMute() throws Exception {
        try{
            moveToElement(video);
            return btnMuteEmpty.isDisplayed();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void clickLiNextVideo() throws Exception {
        try{
            waitUntilElementIsEnabled(liNextVideo);
            if (!liNextVideo.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            liNextVideo.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickLiSubVideo() throws Exception {
        try{
            waitUntilElementIsEnabled(liSubVideo);
            if (!liSubVideo.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            liSubVideo.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void clickChkMuteFull() throws Exception {
        try{
            moveToElement(video);
            waitUntilElementIsEnabled(btnMuteFull);
            btnMuteFull.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickChkMuteEmpty() throws Exception {
        try{
            moveToElement(video);
            waitUntilElementIsEnabled(btnMuteEmpty);
            btnMuteEmpty.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnSub() throws Exception {
        try{
            moveToElement(video);
            waitUntilElementIsEnabled(btnSub);
            btnSub.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickBtnAudioDesc() throws Exception {
        try{
            moveToElement(video);
            waitUntilElementIsEnabled(btnAudioDesc);
            btnAudioDesc.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickOptAudioDesc() throws Exception {
        try{
            moveToElement(video);
            waitUntilElementIsEnabled(optAudioDesc);
            optAudioDesc.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void selectSubLanguage(String language) throws Exception {
        try{
            moveToElement(video);
            WebElement seleccion = getDriver().findElement(By.xpath("//span[text()='"+language+"']/parent::li"));
            seleccion.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public boolean compareSubLanguage(String language) throws Exception {
        try{
            moveToElement(video);
            WebElement seleccion = getDriver().findElement(By.xpath("//span[text()='"+language+"']/following-sibling::span[contains(text(),'selected')]"));
            if(!seleccion.getText().contains("selected")){return false;}
            return true;
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean isEnabledAudioDesc() throws Exception {
        try{
            moveToElement(video);
            WebElement seleccion = getDriver().findElement(By.xpath("//span[text()='Audio Described']/following-sibling::span[contains(text(),'selected')]"));
            if(!seleccion.getText().contains("selected")){return false;}
            return true;
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickBtnPIP() throws Exception {
        try{
            moveToElement(video);
            waitUntilElementIsEnabled(btnPIP);
            btnPIP.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public boolean isEnabledPIP() throws Exception {
        try{
            return isVisible(txtPIP);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickBtnPantallaCompleta() throws Exception {
        try{
            moveToElement(video);
            btnPantallaCompleta.click();
            Thread.sleep(1000);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickBtnSalirPantallaCompleta() throws Exception {
        try{
            video.sendKeys(Keys.SPACE);
            WebElement element = getDriver().findElement(By.xpath("//button[@title='Exit Fullscreen']"));
            element.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickBtnChapters() throws Exception {
        try{
            moveToElement(video);
            btnChapters.click();
            Thread.sleep(1000);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickOptChapters(String chapter) throws Exception {
        try{
            moveToElement(video);
            WebElement element = getDriver().findElement(By.xpath("//span[text()='"+chapter+"']/parent::li"));
            element.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public boolean isEnabledChapters(String chapter) throws Exception {
        try{
            video.sendKeys(Keys.SPACE);
            WebElement seleccion = getDriver().findElement(By.xpath("//span[text()='"+chapter+"']/following-sibling::span[contains(text(),'selected')]"));
            if(!seleccion.getText().contains("selected")){return false;}
            return true;
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickBtnReplay() throws Exception {
        try{
            moveToElement(video);
            btnReplay.click();
            Thread.sleep(1000);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
