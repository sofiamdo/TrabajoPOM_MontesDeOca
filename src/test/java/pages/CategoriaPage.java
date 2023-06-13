package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class CategoriaPage extends ClaseBase {
    public CategoriaPage(WebDriver driver) {
        super(driver);
    }

    //identificar localizadores
    By locatorProductoElefanteRosa = By.xpath("/html/body/div[6]/div[2]/ul/li[2]/div/a");
    By locatorNombreProductoElefantaRosa = By.xpath("//h1[contains(text(),'Escurridor Elefante Multiuso rosa')]");

    By locatorProductoOrganizadorPortacelBlanco = By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/div[1]/a[1]");
    By locatorProductoOrganizadorPortacelBlancoEncontrado = By.xpath("//h1[contains(text(),'Organizador Portacelular Blanco')]");
    By locatorProductoOrganizadorMultiTrans = By.xpath("//h2[contains(text(),'Organizador Multiuso Transparente')]");
    By locatorProductoCuadroFrasesPapa = By.xpath("//h2[contains(text(),'Cuadro Frases Papá')]");
    By locatorProductoOrganizadorMultiTransEncontrado = By.xpath("//h1[contains(text(),'Organizador Multiuso Transparente')]");
    By locatorProductoCuadroFrasesPapaEncontrado = By.xpath("//h1[contains(text(),'Cuadro Frases Papá')]");

    //acciones del page
    public void irAProductoElefanteRosa(){
        click(esperaExplicitaPorElementoClickable(locatorProductoElefanteRosa));
    }
    public String productoElefanteRosaEncontrado(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorNombreProductoElefantaRosa));
    }
    public void irAProductoOrganizadorPortacelBlanco(){
        click(esperaExplicitaPorElementoClickable(locatorProductoOrganizadorPortacelBlanco));
    }
    public String productoOrganizadorPortacelBlancoEncontrado(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorProductoOrganizadorPortacelBlancoEncontrado));
    }

    public void irAProductoOrganizadorMultiTransp(){
        click(esperaExplicitaPorElementoClickable(locatorProductoOrganizadorMultiTrans));
    }
    public String productoOrganizadorMultiTransEncontrado(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorProductoOrganizadorMultiTransEncontrado));
    }
    public void irAProductoCuadroFrasesPapa(){
        click(esperaExplicitaPorElementoClickable(locatorProductoCuadroFrasesPapa));
    }
    public String productoCuadroFrasesPapaEncontrado(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorProductoCuadroFrasesPapaEncontrado));
    }
}
