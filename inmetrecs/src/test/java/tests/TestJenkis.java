package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class TestJenkis {
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName (); // utilizo esse método mais pra baixo para tirar o screnshot

    @Before
    public void setUp(){
        // Abrindo o navegador

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pmacauba\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        // Com o comando abaixo estou dizendo para aguardar 5 segundos para que carregue qualquer elemento na tela
        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Navegando para a página do Taskit!
        navegador.get("http://10.171.30.60:8080/login?from=%2F");

        // maxima a página
        navegador.manage().window().maximize();


    }



    @Test
    public void Login(){
        // Clicar
        //navegador.findElement(By.xpath("//span[text()='+551133334444']/following-sibling::a")).click();
        // Confirmar a janela javasript

       //
        navegador.findElement ( By.id ( "j_username" ) ).sendKeys ( "TIM_FQA" );

        navegador.findElement ( By.name ( "j_password" ) ).sendKeys ( "Tim@123" );

        navegador.findElement ( By.name ( "Submit" ) ).click ();

        navegador.get("http://10.171.30.60:8080/view/OCS1.2/job/OCS_Consulta/");

        navegador.findElement ( By.linkText ( "Construir com parâmetros" ) ).click ();

        navegador.findElement ( By.linkText ( "Construir com parâmetros" ) ).click ();

        navegador.findElement(By.xpath ("//TEXTAREA[@name='value'][1]")).sendKeys ( "92981259828" );

        navegador.findElement(By.id ("yui-gen1-button")).click();

        navegador.get("http://10.171.30.60:8080/job/OCS_Consulta/lastBuild/");

        navegador.get("http://10.171.30.60:8080/job/OCS_Consulta/lastBuild//console");

        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Calendar hoje = Calendar.getInstance();

        //String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(hoje);

        //String Data = new SimpleDateFormat ( "dd/MM/yyyy" ).format (  );


        //System.out.println (dStr);





          




        //navegador.findElement(By.xpath ("//div[contains(.,'CREATE_TIME: 2018-12-05')]"));



        //navegador.findElement ( By.className ( "setting-input")).sendKeys ( "MSISDN e IMSI ex.: 5511980000000,724020000000000");

        //navegador.findElement ( By.id ("yui-gen1-button") ).click ();

        //navegador.get("http://10.171.30.60:8080/job/REDE_ValidaAdequacaoLimpaMassa/lastBuild/");

        //navegador.get("http://10.171.30.60:8080/job/REDE_ValidaAdequacaoLimpaMassa/lastBuild/console");

        // Validar que dentro do elemento
        //navegador.findElement(By.xpath ("//div[contains(.,'C:')]")); // encontro o elemento me que é onde está o texto









    }


    // @After
    //public void tearDown() {
    // Fechar o navegador
    //navegador.close();

    //}
}
