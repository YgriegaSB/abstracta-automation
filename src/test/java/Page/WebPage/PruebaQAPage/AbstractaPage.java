package Page.WebPage.PruebaQAPage;

import Page.BasePage.basePage;
import Page.ExceptionPage.ExceptionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AbstractaPage extends basePage {

    public AbstractaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//h1/a[text()='Your Store']")
    private WebElement textHeader;

    @FindBy(xpath = "//div[@id='search']/input")
    private WebElement inputSearch;

    @FindBy(xpath = "//div[@id='search']//descendant::button")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[@id='content']/h1")
    private WebElement titleSearch;

    @FindBy(xpath = "//div[@class='caption']/h4/a[1]")
    private WebElement btnProductName;

    @FindBy(xpath = "//div[@id='tab-description']/p")
    private WebElement textDescriptionProduct;

    @FindBy(xpath = "//div[@class='col-sm-4']/ul[2]/li[1]")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='col-sm-4']/ul[1]/li[2]")
    private WebElement productCode;

    @FindBy(xpath = "//div[@id='product']//descendant::button")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//div[contains(text(), 'You have added')]")
    private WebElement textAlertConfirm;

    @FindBy(xpath = "//div[@id='cart']/button")
    private WebElement btnCart;

    @FindBy(xpath = "//div[@id='cart']//descendant::p/a[1]")
    private WebElement btnViewCart;

    @FindBy(xpath = "//div[@id='checkout-cart']//descendant::a[text()='Shopping Cart']")
    private WebElement titleModuleCart;

    @FindBy(xpath = "//div[@id='content']//following-sibling::td[2]/a")
    private WebElement cartProductName;

    @FindBy(xpath = "//div[@id='content']//following-sibling::tr[3]/td[2]")
    private WebElement cartProductPrice;

    @FindBy(xpath = "//div[@id='content']//descendant::tbody/tr/td[3]")
    private WebElement cartProductCode;

    @FindBy(xpath = "//div[@id='content']//following-sibling::span/button[2]")
    private WebElement btnRemoveFromCart;

    @FindBy(xpath = "//div[@id='content']/p[text()='Your shopping cart is empty!']")
    private WebElement textShoppingCartEmpty;

    @FindBy(xpath = "//div[@id='logo']/h1/a")
    private WebElement btnHome;


    public boolean isVisibleTextHeader() throws Exception {
        try {
            waitUntilElementIsVisible(textHeader);
            return isVisible(textHeader);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void sendKeysInputSearch(String product) throws Exception {
        try {
            waitUntilElementIsVisible(inputSearch);
            if (!inputSearch.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            inputSearch.sendKeys(product);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void clickbtnSearch() throws Exception {
        try {
            waitUntilElementIsVisible(btnSearch);
            if (!btnSearch.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnSearch.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleTitleSearch() throws Exception {
        try {
            waitUntilElementIsVisible(titleSearch);
            return isVisible(titleSearch);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getTextTitleSearch() throws Exception {
        try {
            waitUntilElementIsVisible(titleSearch);
            return titleSearch.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnProductName() throws Exception {
        try {
            waitUntilElementIsVisible(btnProductName);
            if (!btnProductName.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnProductName.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleDescriptionProduct() throws Exception {
        try {
            waitUntilElementIsVisible(textDescriptionProduct);
            return isVisible(textDescriptionProduct);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getTextDescriptionProduct() throws Exception {
        try {
            waitUntilElementIsVisible(textDescriptionProduct);
            return textDescriptionProduct.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getTextProductPrice() throws Exception {
        try {
            waitUntilElementIsVisible(cartProductPrice);
            return cartProductPrice.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getProductPrice() throws Exception {
        try {
            waitUntilElementIsVisible(productPrice);
            return productPrice.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleStatusCartEmpty() throws Exception {
        try {
            waitUntilElementIsVisible(textShoppingCartEmpty);
            return isVisible(textShoppingCartEmpty);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getTextStatusCartEmpty() throws Exception {
        try {
            waitUntilElementIsVisible(textShoppingCartEmpty);
            return textShoppingCartEmpty.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleProductCode() throws Exception {
        try {
            waitUntilElementIsVisible(productCode);
            return isVisible(productCode);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getcartProductCode() throws Exception {
        try {
            waitUntilElementIsVisible(cartProductCode);
            return cartProductCode.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getProductCode() throws Exception {
        try {
            waitUntilElementIsVisible(productCode);
            return productCode.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnAddToCart() throws Exception {
        try {
            waitUntilElementIsVisible(btnAddToCart);
            if (!btnAddToCart.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnAddToCart.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleAlertMessage() throws Exception {
        try {
            waitUntilElementIsVisible(textAlertConfirm);
            return isVisible(textAlertConfirm);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getTextAlert() throws Exception {
        try {
            waitUntilElementIsVisible(textAlertConfirm);
            return textAlertConfirm.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnCart() throws Exception {
        try {
            waitUntilElementIsVisible(btnCart);
            if (!btnCart.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnCart.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleBtnViewCart() throws Exception {
        try {
            waitUntilElementIsVisible(btnViewCart);
            return isVisible(btnViewCart);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnViewCart() throws Exception {
        try {
            waitUntilElementIsVisible(btnViewCart);
            if (!btnViewCart.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnViewCart.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleTitleModuleCart() throws Exception {
        try {
            waitUntilElementIsVisible(titleModuleCart);
            return isVisible(titleModuleCart);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String getCartProductName() throws Exception {
        try {
            waitUntilElementIsVisible(cartProductName);
            return cartProductName.getText();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean isVisibleBtnRemoveProduct() throws Exception {
        try {
            waitUntilElementIsVisible(btnRemoveFromCart);
            return isVisible(btnRemoveFromCart);
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnRemoveProduct() throws Exception {
        try {
            waitUntilElementIsVisible(btnRemoveFromCart);
            if (!btnRemoveFromCart.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnRemoveFromCart.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void clickBtnHome() throws Exception {
        try {
            waitUntilElementIsVisible(btnHome);
            if (!btnHome.isEnabled()) throw new ExceptionPage("Elemento no disponible");
            btnHome.click();
        }catch (ExceptionPage e){
            throw new ExceptionPage(e.getMessage());
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
