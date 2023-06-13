package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class HomePage extends ClaseBase {

    public  HomePage (WebDriver driver){
        super(driver);
    }
    //identificar localizadores
    By locatorBtnIngresar = By.xpath("//span[contains(text(),'Ingresar')]");
    By locatorBazaMenu = By.xpath("//span[contains(text(),'BAZAR')]");
    By locatortxtBuscarProduc = By.xpath("//input[@placeholder='Buscar']");
    By locatorPreguntasFrecuentes = By.xpath("//a[contains(text(),'Preguntas frecuentes')]");
    By locatorHomePageEncontrada = By.xpath("//h2[contains(text(),'LO NUEVO')]");
    By locatorUsuarioLogueado = By.xpath("//span[contains(text(),'maildeprueba29')]");
    By locatorCategoriaOrganizacion = By.xpath("//span[contains(text(),'ORGANIZACION')]");
    By locatorCategoriaEscritorio = By.xpath("//span[contains(text(),'ESCRITORIO')]");
    By locatorCategoriaVinilo = By.xpath("//span[contains(text(),'VINILOS')]");

    //acciones del page
    public void irAIngresar(){
        click(esperaExplicitaPorElementoClickable(locatorBtnIngresar));
    }
    public void filtrarPorBuscador(String producto){
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatortxtBuscarProduc),producto );
        agregarCombinacionTeclas(locatortxtBuscarProduc,Keys.ENTER);
    }
    public void irACategoriaBazar(){
        click(esperaExplicitaPorElementoClickable(locatorBazaMenu));
    }
    public void irAPreguntasFrecuentes(){
        //Realizar en Clase base Scroll
        click(esperaExplicitaPorElementoClickable(locatorPreguntasFrecuentes));
    }
    public String homePageEncontrada(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorHomePageEncontrada));
    }
    public String usuarioLogueado(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorUsuarioLogueado));
    }
    public void irACategoriaOrganizacion(){
        click(esperaExplicitaPorElementoClickable(locatorCategoriaOrganizacion));
    }
    public void irACategoriaEscritorio(){
        click(esperaExplicitaPorElementoClickable(locatorCategoriaEscritorio));
    }
    public void irACategoriaVinilo(){
        click(esperaExplicitaPorElementoClickable(locatorCategoriaVinilo));
    }
}
