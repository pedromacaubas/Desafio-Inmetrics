package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {
    public MePage(WebDriver navegador) {
        super ( navegador );
    }

    public MePage clicarAbaMoreDataAboutYou(){

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
        }

        public AddContactPage clicarBotaoAddMoreDataAboutYou(){

            // Clicar no botão através do seu xpath //button[@data-target='addmoredata']
            navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
            return new AddContactPage (navegador);

        }





}
