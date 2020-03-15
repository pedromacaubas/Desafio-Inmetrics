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

        //navegador.findElement(By.cssSelector(".waves-light")).click();
        //navegador.findElement(By.cssSelector(".waves-light")).click();
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

    //(//DIV[@class='clockpicker-tick'][text()='15'][text()='15'])[2]
    public PageTask selecionarTimeLimit() {

        //navegador.findElement(By.cssSelector(".waves-light")).click();
        //navegador.findElement(By.cssSelector(".waves-light")).click();
        WebDriverWait aguardarModal= new WebDriverWait(navegador, 10);
        aguardarModal.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='time']")));
        WebElement element = navegador.findElement(By.xpath("//input[@name='time']"));
        Actions builder = new Actions(navegador);
        builder.contextClick(element).perform();
        navegador.findElement(By.xpath("//*[text()='15'][text()='15']")).click();
        return this;
    }


}
