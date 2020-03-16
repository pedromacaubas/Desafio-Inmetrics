package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageTask extends BasePage{

    public PageTask(WebDriver navegador) {
        super ( navegador );
    }{
    }


////BUTTON[@class='waves-effect waves-light red darken-2 btn modal-trigger'][text()='+ Add a task']

    public PageTask clicarBotaoAddTask() {

        navegador.findElement(By.xpath("//BUTTON[@class='waves-effect waves-light red darken-2 btn modal-trigger'][text()='+ Add a task']")).click();
        return this;
    }

////INPUT[@placeholder='What will are trying to procrastinate?']

    public PageTask preencherCampoTitle(String title) {

        navegador.findElement(By.xpath("//INPUT[@placeholder='What will are trying to procrastinate?']")).sendKeys(title);
        return this;
    }

    public PageTask selecionarDateLimit() {

        WebDriverWait aguardarModal= new WebDriverWait(navegador, 10);
        aguardarModal.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='date']")));
        WebElement element = navegador.findElement(By.xpath("//input[@name='date']"));
        Actions builder = new Actions(navegador);
        builder.contextClick(element).perform();
        navegador.findElement(By.xpath("//DIV[@class='picker__day picker__day--infocus'][text()='18']")).click();
        return this;
    }
    public PageTask clicarBotaoSaveDate() {

        WebElement element = navegador.findElement(By.xpath("//*[text()='Save']"));
        Actions builder = new Actions(navegador);
        builder.doubleClick(element).perform();
        return this;
    }

    public PageTask selecionarTimeLimit() {
        WebDriverWait aguardarModal= new WebDriverWait(navegador, 10);
        aguardarModal.until(ExpectedConditions.visibilityOfElementLocated(By.name("time")));
        WebElement element = navegador.findElement(By.name("time"));
        Actions builder = new Actions(navegador);
        builder.moveToElement(element).clickAndHold().perform();
        builder.contextClick(element).perform();
        builder.contextClick(element).perform();
        navegador.findElement(By.xpath("//BUTTON[@type='button'][text()='OK']")).click();

        return this;
    }

    public PageTask preencherCampoTellUs(String tellus) {

        navegador.findElement(By.xpath("//TEXTAREA[@placeholder='Tell us, please!']")).sendKeys(tellus);
        return this;
    }
    public PageTask clicarBotaoSaveForm() {
        navegador.findElement(By.xpath("//A[@class='modal-action waves-effect waves-green btn-flat'][text()='Save']")).click();
        //WebElement element = navegador.findElement(By.xpath("//*[text()='Save']"));
        //Actions builder = new Actions(navegador);
        //builder.doubleClick(element).perform();
        return this;
    }
    public String capturarTextoTask(){
        // isso abaixo
        //WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        //String mensagem = mensagemPop.getText();

        // é praticamente o mesmmo que

        return navegador.findElement(By.xpath("//P[text()='Here is your tasks, you can manage what you need to do in the next days ou hours, it will help you! Click on the task status to change it! ;)']")).getText ();

    }
}
