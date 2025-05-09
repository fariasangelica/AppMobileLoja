package modulos.produto;
import modulos.telas.LoginTela;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@SuppressWarnings("ALL")
@DisplayName("Teste Mobile do Módulo de Produto")
public class ProdutoTest {

    private WebDriver app;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        // Abrir o App

        DesiredCapabilities capacidades = new DesiredCapabilities();

        // Capabilities W3C com prefixo "appium:"
        capacidades.setCapability("appium:deviceName", "Google Pixel 3.1");
        capacidades.setCapability("appium:platformName", "Android");
        capacidades.setCapability("appium:udid", "192.168.55.102:5555");
        capacidades.setCapability("appium:appPackage", "com.lojinha");
        capacidades.setCapability("appium:appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("appium:app", "C:\\nativa\\lojinha-nativa.apk");


        this.app = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }

    @DisplayName("Validação do Valor de Produto Não Permitido")
    @Test
    public void testValidacaoDoValorDeProdutoNaoPermitido() {



        // Fazer Login
        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("adm")
                .preencherSenha("admin")
                .submeterLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("iPhone")
                .preencherValorProduto("700001")
                .preencherCoresProduto("preto, branco")
                .submissaoComErro()
                .obterMensagemDeErro();



        // Validar que a mensagem de valor inválido foi apresentada
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }

    @AfterEach
    public void afterEach() {
        app.quit();
    }



}
