package utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ClaseBase {
    //atributos
    private WebDriver driver;
    private WebDriverWait wait;

    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buscarElementoWeb(By localizador) {
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador) {
        return driver.findElements(localizador);
    }

    //Click

    public void click(By localizador) {
        this.driver.findElement(localizador).click();
    }

    public void click(WebElement elemento) {
        elemento.click();
    }

    //Agregar texto
    public void agregarTexto(By localizador, String texto) {
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento, String texto) {
        elemento.sendKeys(texto);
    }
    //Agregar combinación teclas
    public void agregarCombinacionTeclas(By localizador, Keys key) {
        this.driver.findElement(localizador).sendKeys(key);
    }

    //Obtener texto
    public String obtenerTexto(By localizador) {
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemento) {
        return elemento.getText();
    }

    //Cargar Pagina
    public void cargarPagina(String url) {
        this.driver.get(url);
    }

    //Espera fija
    public void esperarXsegundos(int miliSegundos) {
        try {
            Thread.sleep(miliSegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //expera explicita
    public WebElement esperaExplicitaPorPresenciaElemento(By localizador) {
        wait = new WebDriverWait(this.driver, 20);

        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public WebElement esperaExplicitaPorElementoClickable(By localizador) {
        wait = new WebDriverWait(this.driver, 20);

        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }
    //Conectar Driver
    public WebDriver conexionDriver(String ruta, String property, String browser){
        switch (browser){
            case "chrome":
                System.setProperty(property,ruta);
                this.driver = new ChromeDriver();
                return driver;
            case "firefox":
                System.setProperty(property,ruta);
                this.driver = new FirefoxDriver();
                return driver;
            case "iexplorer":
                System.setProperty(property,ruta);
                this.driver = new InternetExplorerDriver();
                return driver;
            default:
                return driver;
        }

    }

    //Maximizar ventana
    public void maximizarVentana(){
        this.driver.manage().window().maximize();
    }
    //Cerrar Browser
    public void cerrarBrowser(){
        this.driver.close();
    }
    //Contar iFrames
    public int contarIFrames(By index){
        List<WebElement> frames = this.driver.findElements(index);
        return frames.size();
    }
    public void irAframeByIdorName (String NameorId){
        this.driver.switchTo().frame(NameorId);

    }

}
