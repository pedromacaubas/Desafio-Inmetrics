package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.assertEquals;


@RunWith(DataDrivenTestRunner.class) // com essa anotation estou dizedno para usar a biblioteca DataDrivenTestRunner
@DataLoader(filePaths = "C:\\Users\\PedroSilvaMacaubas\\Desktop\\selenium\\conteudoselenium\\ConteudoPastaUsuarios\\IdeaProjects\\curso-webdriver-java-master\\curso-webdriver-java-master\\src\\test\\resources\\InformacoesUsuarioPageObjectsTest.csv") // filePaths são os arquivos que queremos utilizar, coloquei
//o nome do arquivo como InformacoesUsuarioTest, mas poderia ser qualquer nome, esseé somente o nome do arquivo


public class CriarTask {
    // variavel do tipo webdriver
    private WebDriver navegador;

  @Before
    public void setUp(){

      //chamando direto a página
      navegador = Web.createChrome ();

      //chamando através da nuverm
      //navegador = Web.createBrowserStack();
  }

  @Test
  public void testAdicionarUmaInformacaoAdicionalDoUsuario(
         // @Param ( name="login")String login,
         // @Param ( name="senha")String senha,
        //  @Param ( name="tipo")String tipo,
         // @Param ( name="contato")String contato,
        //  @Param ( name="mensagem")String mensagemEsperada
          ){

              //String textoToast =
                      new LoginPage ( navegador )

               .clicarBotaoSingup()
               .efetuarCadastro("pedroteste02","pedroteste42","pedroteste04")
               .clicarBotaoSomeTasks()
               .clicarBotaoAddTask()
               .preencherCampoTitle("pdrteslrgsrlrrssss")
               .selecionarDateLimit()
               .clicarBotaoSaveDate()
               .selecionarTimeLimit();
            //.digitarLogin ( "julio0001" )
           // .digitarSenha ( "123456" )
              //.clicarSingIn ()
             // .fazerLogin ( login, senha)
             // .clicarMe ()
             // .clicarAbaMoreDataAboutYou ()
            //  .clicarBotaoAddMoreDataAboutYou ()
             // .adicionarContato ( tipo , contato)
             // .capturarTextoToast ();

              //assertEquals ( mensagemEsperada,textoToast);

    // isso quer dizer que estou digitando o login a senha e clicando no link singin

  }






}
