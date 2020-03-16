package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;


@RunWith(DataDrivenTestRunner.class) // com essa anotation estou dizendo para usar a biblioteca DataDrivenTestRunner
@DataLoader(filePaths = "C:\\repository\\Desafio-Inmetrics\\inmetrecs\\src\\main\\resources\\CriarTask.csv") // filePaths são os arquivos que queremos utilizar, coloquei

public class CriarTask {
    // variavel do tipo webdriver
    private WebDriver navegador;
    @Rule
    public TestName test = new TestName();
  @Before
    public void setUp(){

      //chamando direto a página
      navegador = Web.createChrome ();

  }

  @Test
  public void testCriarTask(
         @Param ( name="name")String name,
         @Param ( name="login")String login,
         @Param ( name="senha")String senha,
         @Param ( name="title")String title,
         @Param ( name="tellus")String tellus
          ){

              String textoTask = new LoginPage ( navegador )

               .clicarBotaoSingup()
               .efetuarCadastro(name,login,senha)
               .clicarBotaoSomeTasks()
               .clicarBotaoAddTask()
               .preencherCampoTitle(title)
               .selecionarDateLimit()
               .clicarBotaoSaveDate()
               .selecionarTimeLimit()
               .preencherCampoTellUs(tellus)
               .clicarBotaoSaveForm()
               .capturarTextoTask ();
               assertEquals ( "Here is your tasks, you can manage what you need to do in the next days ou hours, it will help you! Click on the task status to change it! ;)",textoTask);
               String screenshotArquivo = "C:\\Evidencias\\Evidencias" + Generator.dataHoraParaArquivo () + test.getMethodName() + ".png";
               Screenshot.tirar ( navegador, screenshotArquivo);
  }
}
