package tests;

import static org.junit.Assert.*;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
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
import suporte.Web;

import java.util.concurrent.TimeUnit;


@RunWith(DataDrivenTestRunner.class) // com essa anotation estou dizedno para usar a biblioteca DataDrivenTestRunner
@DataLoader(filePaths = "C:\\inmetrecs\\src\\main\\resources\\InformacoesUsuarioTestData.csv") // filePaths são os arquivos que queremos utilizar, coloquei
//o nome do arquivo como InformacoesUsuarioTest, mas poderia ser qualquer nome, esseé somente o nome do arquivo ,

public class InformacoesUsuarioTest {
    private WebDriver navegador;

    // utilizo esse método mais pra baixo para tirar o screnshot, na verdade ele pega o nome do método que esta dentro da
    // da anotation @test, como estou tirando a foto dentro teste remover removerUmContatoDeUmUsuario
    // ele pega esse método, para salvar o arquivo com esse nome isso + test.getMethodName() + ". é mesmo
    // que isso + removerUmContatoDeUmUsuario.getMethodName() + ".
    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){

        navegador = Web.createChrome ();

        // maxima a página
        navegador.manage().window().maximize();
        // Clicar no link que possui o texto "Sign in"
        navegador.findElement(By.linkText("Sign in")).click();

        // Clicar no campo com name "login" que está dentro do formulário de id "signinbox"
        // (obs: não é preciso clicar no formulário para interagir nos campos dentro dele, então basta seguir o passo abaixo)
        // Identificando o formulário de Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        // Digitar no campo com name "login" que está dentro do formulário de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        // Clicar no campo com name "password" que está dentro do formulário de id "signinbox"
        //como já dito não é preciso clicar no campo password, para depois digitar dentro dele, basta digitar direto
        //como está no passo abaixo


        // Digitar no campo com name "password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // Clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        /*
        Como a validação é a inclusão de um usuário, está parte da validação de efetuar o login
        que é entrar na página e verificar se consta o texto "Hi, Julio", não vai ser executada,
        toda essa parte que foi feita abaixo está na seção 3 aula 13

        // Validar que dentro do elemento class "me" está o texto "Hi, Julio"
        WebElement me = navegador.findElement(By.className("me")); // encontro o elemento me que é onde está o texto
        // "Hi, Julio"
        String textoNoElementoMe = me.getText(); // crio uma variável do tipo string que pega o que está dentro da tag
        // do elemento me
        assertEquals ("Hi, Julio", textoNoElementoMe); // e pergunto o texto "Hi, Julio" está de fato dentro da
        //tag
        */

        // Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        // Clicar em um link que possui o texto "MORE DATA ABOUT YOU"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param (name ="tipo" )String tipo, @Param ( name = "contato" )String contato, @Param ( name = "mensagem" )String mensagemEsperada) {



        // Clicar no botão através do seu xpath //button[@data-target='addmoredata']
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a popup onde está o formulário de id addmoredata
        // Como vamos realizar diversas ações dentro desse formulário, compensa nós
        // criamos uma variável WebElement como feito abaixo
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // Na combo de nome "type" escolher a opção "Phone"
        // Para interagir com uma combo primeiro precisamos colocar o elemento dentro uma variável WebElement
        // como feito abaixo 1. Primeiro passo
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));

        // 2. Segundo passo, depois utilizamos a classe especifica do selenium que é a classe Select
        new Select(campoType).selectByVisibleText(tipo); // 3. Terceiro passo, colocamos dentro do Select a variável
        // campoType, depois utilizamos e nesse caso depois utilizamos o comando que faz selecionar
        // o texto que está visível para o usuário dentro da combo, que nesse caso é o texto  "Phone"


        // No camopo de name "contact" digitar "+5511999999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        // Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        // Na mensagem de id "toast-container" validar que o texto é "Your contatct has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals( mensagemEsperada,mensagem);




        // Validação

        //assertEquals(1,1);

    }

    @Test
    public void removerUmContatoDeUmUsuario(){
        // Clicar no elemento pelo seu xpath //span[text()='+551133334444']/following-sibling::a
        navegador.findElement(By.xpath("//span[text()='+551133334444']/following-sibling::a")).click();
        // Confirmar a janela javasript
        navegador.switchTo().alert().accept(); // dessa maneira estou clicando no botão Ok do alerta javascript

        // Validar que a mensagem apresentada foi Rest in peace, dear phone!
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        assertEquals( "Rest in peace, dear phone!",mensagem);

        //
        String screenshotArquivo = "C:\\Evidencias\\Taskit\\" + Generator.dataHoraParaArquivo () + test.getMethodName() + ".png";
        Screenshot.tirar ( navegador, screenshotArquivo);

        // Aguardar até 10 segundos para que a janela desapareça
        WebDriverWait aguardar = new WebDriverWait(navegador, 10); // crio uma espera
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop)); // e a coloco para esperar até 10 segundos
        // para que o elemento mensagemPop ("Rest in peace, dear phone!")
        // resumindi o aguardar.unti,, qyuer dizer espera até, depois coloco o ExpectedConditions
        // que é a condição que vou colocar, uma mensagem que desaparece da página é uma mensagem
        // stalenessOf, uma mensagem stalenessOf, é algo que fica na tela e depois some, por isso a escolha
        // dele, ai depois coloco a mensagem que desaparece que é que está dentro do mensagemPop


        // Clicar no link com texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }


    // @After
    //public void tearDown() {
    // Fechar o navegador
    //navegador.close();

    //}
}
