package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {


    public LoginFormPage(WebDriver navegador) {
        super ( navegador );
    }

    public LoginFormPage digitarLogin(String login){

        navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public LoginFormPage digitarSenha(String password){

        navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);

        return this;
    }

    public SecretaPage clicarSignIn(){
        navegador.findElement ( By.linkText ( "SIGN IN" ) ).click ();

        return new SecretaPage(navegador);
    }


    // nesse caso abaixo eu criei um único método que faz todos os métodos acima
    // isso se chama montagem estrutural
    // essa forma abaixo se chama abordagem funcional

    public SecretaPage fazerLogin(String login, String senha){

        digitarLogin(login);
        digitarSenha(senha);
        clicarSignIn();

        return new SecretaPage(navegador);

    }


    // também é possível utilizar o estrutural com o funcional, na minha opinião é mais confuso de entender
    // mas poderia ficar como abaixo

    //public SecretaPage fazerLogin(String login, String senha){

        //digitarLogin(login);
       // digitarSenha(senha);
       // clicarSignIn();

       // return new SecretaPage(navegador);

   // } // para funcionao esse método tenho que apagar o outro método fazerLogin acima


}
