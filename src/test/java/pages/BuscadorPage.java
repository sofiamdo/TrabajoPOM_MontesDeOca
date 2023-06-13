package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class BuscadorPage extends ClaseBase {

    public BuscadorPage(WebDriver driver) {
        super(driver);
    }
    //identificar localizadores

    By locatorMacetaEncontrada = By.xpath("//h2[contains(text(),'Maceta de ceramica Tachas')]");
    By locatorLogo = By.xpath("//a[@class= 'box-logo floatLeft']");

    //acciones del page
    public String elementoEncontrado(){
      return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorMacetaEncontrada));

    }
    public void volverAHomePage(){
        click(esperaExplicitaPorElementoClickable(locatorLogo));
    }

}
