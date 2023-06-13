package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.io.IOException;
import java.util.List;


public class Test {
    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCP;
    private HomePage homePage;
    private IngresarPage ingresarPage;
    private CategoriaPage categoriaPage;
    private BuscadorPage buscadorPage;
    private PreguntasFrecuentesPage preguntasFrecuentesPage;
    private PropertiesDriven properties;

    @BeforeSuite
    public void inicioSuiteDePruebas() {
        properties = new PropertiesDriven();

        System.out.println("Inicio de suite de pruebas automatizadas");
    }

    @BeforeClass
    public void preparacionClase() {

        data = new DataDriven();

        homePage = new HomePage(driver);

        homePage.conexionDriver(properties.obtenerProperties("rutaDriver"), properties.obtenerProperties("browserProperty"), properties.obtenerProperties("browser"));

        ingresarPage = new IngresarPage(homePage.getDriver());

        categoriaPage = new CategoriaPage(homePage.getDriver());

        buscadorPage = new BuscadorPage(homePage.getDriver());

        preguntasFrecuentesPage = new PreguntasFrecuentesPage(homePage.getDriver());

    }


    @BeforeMethod
    public void prepararTest() {
        String url = properties.obtenerProperties("url");
        homePage.cargarPagina(url);
        homePage.maximizarVentana();
    }


    @org.testng.annotations.Test
    public void CP001_accesoAPreguntasFrecuentes() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP001_accesoAPreguntasFrecuentes");

        homePage.irAPreguntasFrecuentes();

        Assert.assertEquals(datosCP.get(1), preguntasFrecuentesPage.preguntasFrecEncontrado());
    }

    @org.testng.annotations.Test
    public void CP002_localizarPreguntaFrecuente() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP002_localizarPreguntaFrecuente");

        homePage.irAPreguntasFrecuentes();

        preguntasFrecuentesPage.localizarPregunta();

        Assert.assertEquals(datosCP.get(1), preguntasFrecuentesPage.preguntaEncontrada());
    }

    @org.testng.annotations.Test
    public void CP003_filtroBuscarProducto() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP003_filtroBuscarProducto");

        homePage.filtrarPorBuscador(datosCP.get(1));

        Assert.assertEquals(datosCP.get(2), buscadorPage.elementoEncontrado());
    }

    @org.testng.annotations.Test
    public void CP004_volverAPantallaPrincipal_ClickEnLogo() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP004_volverAPantallaPrincipal_ClickEnLogo");

        homePage.filtrarPorBuscador("Maceta");

        buscadorPage.volverAHomePage();

        Assert.assertEquals(datosCP.get(2), homePage.homePageEncontrada());
    }


    @org.testng.annotations.Test
    public void CP005_productoBazarMenu() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP005_productoBazarMenu");

        homePage.irACategoriaBazar();

        categoriaPage.irAProductoElefanteRosa();

        Assert.assertEquals(datosCP.get(1), categoriaPage.productoElefanteRosaEncontrado());
    }

    @org.testng.annotations.Test
    public void CP006_productoOrganizacionMenu() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP006_productoOrganizacionMenu");

        homePage.irACategoriaOrganizacion();

        categoriaPage.irAProductoOrganizadorPortacelBlanco();

        Assert.assertEquals(datosCP.get(1), categoriaPage.productoOrganizadorPortacelBlancoEncontrado());
    }

    @org.testng.annotations.Test
    public void CP007_productoEscritorioMenu() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP007_productoEscritorioMenu");

        homePage.irACategoriaEscritorio();

        categoriaPage.irAProductoOrganizadorMultiTransp();

        Assert.assertEquals(datosCP.get(1), categoriaPage.productoOrganizadorMultiTransEncontrado());
    }

    @org.testng.annotations.Test
    public void CP008_productoViniloMenu() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP008_productoViniloMenu");

        homePage.irACategoriaVinilo();
        categoriaPage.irAProductoViniloPuertaDragon();

        Assert.assertEquals(datosCP.get(1), categoriaPage.productoViniloPuertaDragonEncontrado());
    }

    @org.testng.annotations.Test
    public void CP009_creacionCtaGorsh_MailExistente() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP009_creacionCtaGorsh_MailExistente");

        homePage.irAIngresar();

        ingresarPage.llenarRegistroMailDuplicado(datosCP.get(1), datosCP.get(2), datosCP.get(3));

        Assert.assertEquals(datosCP.get(4), ingresarPage.obtenerMensajeErrorUsuarioDuplicado());
    }

    @org.testng.annotations.Test
    public void CP010_ingresarPassErroneaMiembros() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP010_ingresarPassErroneaMiembros");

        homePage.irAIngresar();

        ingresarPage.llenarMiembrosGorshPassIncorrecta(datosCP.get(1), datosCP.get(2));

        Assert.assertEquals(datosCP.get(3), ingresarPage.obtenerMensajeErrorPassIncorrecta());
    }

    @org.testng.annotations.Test
    public void CP011_ingresarmailincompletoMiembros() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP011_ingresarmailincompletoMiembros");

        homePage.irAIngresar();
        ingresarPage.llenarMiembrosGorshMailIncompleto(datosCP.get(1), datosCP.get(2));

        Assert.assertEquals(datosCP.get(3), ingresarPage.obtenerMensajeMailIncompleto());
    }

    @org.testng.annotations.Test
    public void CP012_ingresarMiembrosGorsh() throws IOException {

        datosCP = data.obtenerDatosPrueba("CP012_ingresarMiembrosGorsh");

        homePage.irAIngresar();

        ingresarPage.llenarMiembrosGorsh(datosCP.get(1), datosCP.get(2));

        Assert.assertEquals(datosCP.get(3), homePage.usuarioLogueado());
    }

    @AfterTest
    public void after() {
        homePage.cerrarBrowser();
    }


}
