package modulos.telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTela extends BaseTela {
    public LoginTela(WebDriver app) {
        super(app);
    }


    public LoginTela preencherUsuario(String usuario) {
        app.findElement(By.id("com.lojinha:id/user")).click();
        app.findElement(By.id("com.lojinha:id/user")).findElement(By.className("android.widget.EditText")).sendKeys(usuario);

        return this;
    }

    public LoginTela preencherSenha(String password) {
        app.findElement(By.id("com.lojinha:id/password")).click();
        app.findElement(By.id("com.lojinha:id/password")).findElement(By.className("android.widget.EditText")).sendKeys(password);

        return this;
    }

    public ListagemDeProdutosTela submeterLogin() {
        app.findElement(By.id("com.lojinha:id/loginButton")).click();

        return new ListagemDeProdutosTela(app);
    }

 }



