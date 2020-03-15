package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = "pedrosilvamacaub1";
    public static final String AUTOMATE_KEY = "MqPdctnyvzkgr4WeFGqK";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
// Abrindo o navegador

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PedroSilvaMacaubas\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver ();
        // Com o comando abaixo estou dizendo para aguardar 5 segundos para que carregue qualquer elemento na tela
        navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");
        navegador.manage().window().maximize();

        return navegador;
    }
//public static WebDriver createBrowserStack(){
   // DesiredCapabilities caps = new DesiredCapabilities();
   // caps.setCapability("browser", "Chrome");
   // caps.setCapability("browser_version", "60.0");
   // caps.setCapability("os", "Windows");
   // caps.setCapability("os_version", "10");
   // caps.setCapability("resolution", "1280x800");
   // caps.setCapability("browserstack.debug","true");

   // WebDriver navegador = null;

   // try {
    //   navegador = new RemoteWebDriver (new URL (URL), caps);
        // Com o comando abaixo estou dizendo para aguardar 5 segundos para que carregue qualquer elemento na tela
      //  navegador.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Navegando para a página do Taskit!
       // navegador.get("http://www.juliodelima.com.br/taskit");
   // } catch (MalformedURLException e) {
       // System.out.println ( "Houveram probelams com a URL:"+e.getMessage () );


   // }
   // return navegador;

//}





}
