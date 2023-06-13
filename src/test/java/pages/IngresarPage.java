package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class IngresarPage extends ClaseBase {
    public IngresarPage(WebDriver driver) {
        super(driver);
    }

    //identificar localizadores
    //locators registro
    By locatorTxtMailRegistro = By.xpath("//input[@id='register_email']");
    By locatorTxtPassRegistro = By.xpath("//input[@id='register_pass']");
    By locatorTxtConfirmPassRegistro = By.xpath("//input[@id='register_pass_repeat']");
    By locatorBtnConfirmRegistro = By.xpath("//div[contains(text(),'REGISTRARME')]");

    //Locator Msj Error
    By locatorErrorUsserDuplicado = By.xpath("//div[contains(text(),'Usuario duplicado.')]");

    //locators ingresar Miembro Gorsh
    By locatorTxtMailMiembro = By.id("log_email");
    By locatorTxtPassMiembro = By.id("log_password");
    By locatorBtnConfirmIngreso = By.xpath("//div[contains(text(),'INGRESAR')]");
    By locatorMsjPassIncorrecta = By.xpath("//div[contains(text(),'Clave incorrecta o no existe el usuario.')]");

    By locatorMsjMailImcompleto = By.xpath("//label[contains(text(),'Ingrese una direcci')]");

    //acciones del page

    public void llenarRegistroMailDuplicado(String TxtMailRegistro, String TxtPassRegistro, String TxtConfirmPassRegistro ) {
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtMailRegistro),TxtMailRegistro );
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtPassRegistro),TxtPassRegistro );
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtConfirmPassRegistro),TxtConfirmPassRegistro );
        click(esperaExplicitaPorElementoClickable(locatorBtnConfirmRegistro));
    }

    public String obtenerMensajeErrorUsuarioDuplicado() {
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorErrorUsserDuplicado));
    }

    public void llenarMiembrosGorsh(String TxtMailMiembro, String TxtPassMiembro) {
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtMailMiembro), TxtMailMiembro);
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtPassMiembro), TxtPassMiembro);
        click(esperaExplicitaPorElementoClickable(locatorBtnConfirmIngreso));
    }

    public void llenarMiembrosGorshPassIncorrecta(String TxtMailMiembro, String TxtPassIncorrecta) {
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtMailMiembro), TxtMailMiembro);
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtPassMiembro), TxtPassIncorrecta);
        esperaExplicitaPorElementoClickable(locatorBtnConfirmIngreso).click();
    }

    public String obtenerMensajeErrorPassIncorrecta() {
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorMsjPassIncorrecta));
    }
    public void llenarMiembrosGorshMailIncompleto(String TxtMailIncompleto, String TxtPassMiembro) {
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtMailMiembro), TxtMailIncompleto);
        agregarTexto(esperaExplicitaPorPresenciaElemento(locatorTxtPassMiembro), TxtPassMiembro);
        esperaExplicitaPorElementoClickable(locatorBtnConfirmIngreso).click();
}
    public String obtenerMensajeMailIncompleto(){
        return obtenerTexto(esperaExplicitaPorPresenciaElemento(locatorMsjMailImcompleto));
    }


}