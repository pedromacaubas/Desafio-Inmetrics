package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
protected WebDriver navegador;


    public BasePage (WebDriver navegador){

        this.navegador = navegador;


    }

    // esse método serve para capturar a mensagem toast-container esse método está dentro da classe
    // porque essa mensagem aparece em diversos momentos dentro do site
    public String capturarTextoToast(){
        // isso abaixo
        //WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        //String mensagem = mensagemPop.getText();

        // é praticamente o mesmmo que

        return navegador.findElement(By.id("toast-container")).getText ();

    }




}
