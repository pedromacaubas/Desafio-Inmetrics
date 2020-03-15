package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage{
    public AddContactPage(WebDriver navegador) {
        super ( navegador );
        }

public AddContactPage escolherTipoDeContato (String tipo){
   // Encontro os dois elementos By.id("addmoredata") e (By.name("type")) e jogo eles para dentro de WebElement
    WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));

    // Depois através da classe especifica select selecionamos
    // o texto que está visível para o usuário dentro da combo, que nesse caso é o texto  "Phone"

    new Select (campoType).selectByVisibleText(tipo);

        return this;
}

public AddContactPage digitarContato(String contato){
    navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);
        return this;
    }

    public MePage clicarSalvar(){

        navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();
        return new MePage ( navegador );


    }

    // Nesse caso eu criei um método funcional com todos os métodos estruturais acima
    // como esse método irá retornar a página MePage, criei o método public MePage
    public MePage adicionarContato(String tipo, String contato){

        escolherTipoDeContato ( tipo );
        digitarContato ( contato );
        clicarSalvar ();

        return new MePage ( navegador );
    }



}
