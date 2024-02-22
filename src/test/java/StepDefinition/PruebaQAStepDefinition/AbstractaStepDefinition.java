package StepDefinition.PruebaQAStepDefinition;

import Page.DriverPage.driverPage;
import Page.ExceptionPage.ExceptionPage;
import Page.WebPage.PruebaQAPage.AbstractaPage;
import Utl.ScenarioContext;
import Utl.Utilidades;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractaStepDefinition {

    private static final Logger logger = LoggerFactory.getLogger(AbstractaStepDefinition.class);
    private AbstractaPage abstractaPage;
    public AbstractaStepDefinition(){
        this.abstractaPage = new AbstractaPage(driverPage.getDriver());
    }
    private ScenarioContext context = ScenarioContext.getInstance();


    @Given("Carga sitio web de {string}")
    public void carga_sitio_web_de(String URL) throws Exception {
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            String uri = ScenarioContext.getInstance().getEnvVariable(URL);
            WebDriver driver = context.getContextData("driver");
            driver.navigate().to(uri);

            if (!abstractaPage.isVisibleTextHeader()) {
                throw new ExceptionPage("El sitio no cargó correctamente");
            }

            logger.info("El sitio cargó correctamente");
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al cargar el sitio web: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al cargar el sitio web: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }


    @When("Se busca el producto {string}")
    public void seBuscaElProducto(String product) throws Exception {
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            abstractaPage.sendKeysInputSearch(product);
            abstractaPage.clickbtnSearch();

            if (!abstractaPage.isVisibleTitleSearch()) {
                throw new ExceptionPage("El sitio no cargó correctamente");
            }

            String titleSearch = abstractaPage.getTextTitleSearch();
            Assert.assertTrue(titleSearch.contains(product));
            logger.info("Se realizó la búsqueda del producto '" + product + "' satisfactoriamente");
            context.setContextData("Producto", product);
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al realizar la búsqueda del producto: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al realizar la búsqueda del producto: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }

    @And("Se selecciona el primer producto de la busqueda")
    public void seSeleccionaElPrimerProductoDeLaBusqueda() throws Exception {
        String product = context.getContextData("Producto");
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            abstractaPage.clickBtnProductName();
            if (!abstractaPage.isVisibleProductCode()) {
                throw new ExceptionPage("No se pudo encontrar la descripción del producto");
            }
            logger.info("Se abrió la vista del producto");
            context.setContextData("Precio", abstractaPage.getProductPrice());
            context.setContextData("Codigo", abstractaPage.getProductCode());
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al seleccionar el primer producto de la búsqueda: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al seleccionar el primer producto de la búsqueda: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }


    @And("Se agrega producto al carrito de compras")
    public void seAgregaProductoAlCarritoDeCompras() throws Exception {
        String product = context.getContextData("Producto");
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            abstractaPage.clickBtnAddToCart();
            if (!abstractaPage.isVisibleAlertMessage() || !abstractaPage.getTextAlert().toLowerCase().contains(product.toLowerCase())) {
                throw new ExceptionPage("No se agregó el producto al carrito");
            }
            logger.info("Se agregó el producto '" + product + "' al carrito de compras");
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al agregar el producto al carrito: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al agregar el producto al carrito: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }


    @And("Se navega a view cart")
    public void seNavegaAViewCart() throws Exception {
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            abstractaPage.clickBtnCart();
            if (!abstractaPage.isVisibleBtnViewCart()) {
                throw new ExceptionPage("El sitio no cargó correctamente");
            }
            abstractaPage.clickBtnViewCart();
            Assert.assertTrue(abstractaPage.isVisibleTitleModuleCart());
            logger.info("Se cargó la vista ViewCart correctamente");
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al navegar a ViewCart: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al navegar a ViewCart: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }


    @Then("Se valida que el producto seleccionado se encuentra en el carrito")
    public void validarQueElProductoSeleccionadoSeEncuentraEnElCarritoDeCompras() throws Exception {
        String product = context.getContextData("Producto");
        String code = context.getContextData("Codigo");
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            System.out.println("PRODUCTO ====================> "+abstractaPage.getCartProductName().toLowerCase());
            String productName = abstractaPage.getCartProductName().toLowerCase();
            String productCode = abstractaPage.getcartProductCode().toLowerCase();
            if (!productName.equalsIgnoreCase(product) && !code.toLowerCase().contains(productCode)) {
                throw new ExceptionPage("El producto no fue agregado al carrito");
            }
            logger.info("El producto '" + product + "' seleccionado se encuentra en el carrito de compras");
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al validar que el producto se encuentra en el carrito: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al validar que el producto se encuentra en el carrito: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }


    @And("Se elimina el producto del carrito")
    public void seEliminaElProductoDelCarrito() throws Exception {
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            if (!abstractaPage.isVisibleBtnRemoveProduct()) {
                throw new ExceptionPage("El producto no fue agregado al carrito");
            }
            abstractaPage.clickBtnRemoveProduct();
            abstractaPage.isVisibleStatusCartEmpty();
            context.setContextData("statusCart", abstractaPage.getTextStatusCartEmpty());
            logger.info("El producto fue removido del carrito de compras");
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al eliminar el producto del carrito: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al eliminar el producto del carrito: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }


    @And("Se valida el mensaje {string}")
    public void seValidaElMensaje(String message) throws Exception {
    String status = context.getContextData("statusCart");
    String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
    String estado = "";
    String archivo = "";
    try {
        if (!status.equalsIgnoreCase(message)) {
            throw new ExceptionPage("El producto no fue agregado al carrito");
        }
        abstractaPage.clickBtnHome();
        logger.info("El carrito de compras está vacío. Mensaje validado: " + message);
        estado = "_OK_";
        archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
    } catch (ExceptionPage e) {
        estado = "_NOOK_";
        logger.error("Error técnico al validar mensaje: " + e.getMessage(), e);
        throw new Exception("Error Técnico: " + e.getMessage());
    } catch (Exception e) {
        estado = "_NOOK_";
        logger.error("Error funcional al validar mensaje: " + e.getMessage(), e);
        throw new Exception("Error Funcional: " + e.getMessage());
    } finally {
        Utilidades.renameSnapShot(archivo, estado);
    }
}

    @And("Se valida que se vea la descripcion del producto")
    public void seValidaQueSeVeaLaDescripcionDelProducto() throws Exception {
        String product = context.getContextData("Producto");
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            if (!abstractaPage.isVisibleDescriptionProduct() || !abstractaPage.getTextDescriptionProduct().toLowerCase().contains(product.toLowerCase())) {
                throw new ExceptionPage("No se pudo encontrar la descripción del producto");
            }
            logger.info("Se abrió la vista del producto '" + product + "' y se visualiza la descripción");
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al seleccionar el primer producto de la búsqueda: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al seleccionar el primer producto de la búsqueda: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }

    @And("Se valida que se abre carrito de compras")
    public void seValidaQueSeAbreCarritoDeCompras() throws Exception {
        String name = "_" + new Object(){}.getClass().getEnclosingMethod().getName();
        String estado = "";
        String archivo = "";
        try {
            if (!abstractaPage.isVisibleTitleModuleCart()) {
                throw new ExceptionPage("No se pudo encontrar el titulo del carro de compras");
            }
            logger.info("Se abrió la vista del carro de compras");
            estado = "_OK_";
            archivo = Utilidades.takeSnapShot("/" + ScenarioContext.getInstance().step().toString() + name + ".png");
        } catch (ExceptionPage e) {
            estado = "_NOOK_";
            logger.error("Error técnico al seleccionar el primer producto de la búsqueda: " + e.getMessage(), e);
            throw new Exception("Error Técnico: " + e.getMessage());
        } catch (Exception e) {
            estado = "_NOOK_";
            logger.error("Error funcional al seleccionar el primer producto de la búsqueda: " + e.getMessage(), e);
            throw new Exception("Error Funcional: " + e.getMessage());
        } finally {
            Utilidades.renameSnapShot(archivo, estado);
        }
    }
}
