package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    public LoginFormPage clicarSingIn() {

        navegador.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(navegador);

    }

    public LoginPage clicarBotaoSingup() {

        navegador.findElement(By.id("signup")).click();
        return this;

    }


    public LoginPage digitarName(String name) {

        navegador.findElement(By.name("name")).sendKeys(name);

        return this;
    }

    public LoginPage digitarLogin(String login) {

        navegador.findElement(By.name("login")).sendKeys(login);

        return this;
    }

    public LoginPage digitarSenha(String senha) {

        navegador.findElement(By.name("password")).sendKeys(senha);

        return this;
    }

    public LoginPage clicarBotaoSave() {


        WebElement element = navegador.findElement(By.xpath("//*[text()='Save']"));
        Actions builder = new Actions(navegador);
        builder.doubleClick(element).perform();


        return this;
    }

    public LoginPage efetuarCadastro(String name, String login, String senha) {
        digitarName(name);
        digitarLogin(login);
        digitarSenha(senha);
        clicarBotaoSave();

        return this;
    }

    public PageTask clicarBotaoSomeTasks() {

        navegador.findElement(By.xpath("//A[@class='waves-effect waves-light red darken-2 btn']")).click();
        return new PageTask(navegador);

    }

}