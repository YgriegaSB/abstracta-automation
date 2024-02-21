package Utl;

import Constants.Constants;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Utilidades {
    private static  final Logger logger = LoggerFactory.getLogger(Utilidades.class);
    private static ScenarioContext context;
    private static byte[] pngBytesToJpgBytes(byte[] pngBytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(pngBytes);
        BufferedImage bufferedImage = ImageIO.read(bais);

        BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(),
                bufferedImage.getHeight(),
                BufferedImage.TYPE_INT_RGB);
        newBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(newBufferedImage, "JPG", baos);

        return baos.toByteArray();
    }
    public static String takeSnapShot(String filename) throws Exception{
        context = ScenarioContext.getInstance();
        Scenario scenario = (Scenario) context.getContextData("scenario");
        Path rutaPath = Paths.get("../evidencia/"+ context.getContextData("rutaEjecucion").toString());
        if(!Files.exists(rutaPath)){
            Assert.assertTrue("No se pudo crear el directorio", new File (String.valueOf(rutaPath)).mkdirs());
        }
        Thread.sleep(500);
        WebDriver driver = (WebDriver) context.getContextData("driver");
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        String ruta = rutaPath + filename;
        File SrcFile = new File(rutaPath+filename);
        FileUtils.writeByteArrayToFile(SrcFile,
                pngBytesToJpgBytes(scrShot.getScreenshotAs(OutputType.BYTES)));

        return ruta;
    }
    public static void renameSnapShot(String archivo, String estado) throws Exception{
        try{

            File imagen = new File(archivo);
            String rename = archivo.replaceAll(".png",estado +".png");
            imagen.renameTo(new File(rename));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public static Map<String,String> getEnv() throws IOException {
        Map<String, String> variablesEntorno = new HashMap<String, String>();
        logger.info("Comprobando el entorno de ejecucion");
        logger.info("Environment: " + System.getenv("ENVIRONMENT"));
        if (System.getenv("ENVIRONMENT").equals(Constants.ENVIRONMENTS.get("PRODUCTION")))
            variablesEntorno = System.getenv();
        if (System.getenv("ENVIRONMENT").equals(Constants.ENVIRONMENTS.get("DEVELOPMENT"))) {
            // Read a .properties file
            try {
                Properties environment = new Properties();
                FileInputStream file = new FileInputStream("env.properties");
                environment.load(file);
                for (String key : environment.stringPropertyNames()) {
                    String value = environment.getProperty(key);
                    variablesEntorno.put(key, value);
                }
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            }
        }
        logger.info("Variables de entorno establecidas");
        return variablesEntorno;
    }
    public static <T> T getDynamicCast(String key){
        HashMap<String,Object> variables = new HashMap<String,Object>(){{
            put("numeros",1234);
            put("letras","abcdefg");
        }};
        Object numero = variables.get(key);
        Class<T> cast = (Class<T>) numero.getClass();
        return cast.cast(numero);
    }
}
