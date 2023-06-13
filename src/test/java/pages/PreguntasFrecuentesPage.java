package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class PreguntasFrecuentesPage extends ClaseBase {

    public PreguntasFrecuentesPage(WebDriver driver) {
        super(driver);
    }
    //identificar localizadores
    By locatorPreguntasFrecEncontrado = By.xpath("//div[contains(text(),'Preguntas Frecuentes')]");
    By locatorPregunta = By.xpath("//span[contains(text(),'¿Cuánto cuesta el envío a domicilio?')]");

    //acciones del page

    public String preguntasFrecEncontrado(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorPreguntasFrecEncontrado));
    }
    public void localizarPregunta(){
        obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorPregunta));

    }
    public String preguntaEncontrada(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorPregunta));
    }
}
