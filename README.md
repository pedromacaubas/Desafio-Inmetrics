# Desafio-Inmetrics
 Repositório referente ao desafio Inmetrics
## Pré-requisitos

1. JDK 1.8.0_231
java version "1.8.0_231"
Java(TM) SE Runtime Environment (build 1.8.0_231-b11)
Java HotSpot(TM) 64-Bit Server VM (build 25.231-b11, mixed mode)
Link para download: http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html

2. IDE Intellij (ou similar, eclipse, netbeans etc...) 
link para download: https://www.jetbrains.com/idea/download/#section=windows

3. Realizar download do projeto Inmetrics e abri-lo na IDE (ao abrir o prjeto todas as dependências vão estar dentro do arquivo pom.xml, não precisando realizar o download do selenium junit etc...)

4. Realizar o download do driver do navegador (execução dos testes foram feitos no navegador chrome)
link para download: https://sites.google.com/a/chromium.org/chromedriver/downloads

Outros Drivers 

https://github.com/mozilla/geckodriver/releases (Firefox) 

http://selenium-release.storage.googleapis.com/index.html?path=3.6 (Internet Explorer) 

5. Na page Web contém o método public static WebDriver createChrome(), nele é onde criado o driver do chrome, alterar de: C:\Users\PedroSilvaMacaubas\Drivers\chromedriver.exe para: o local onde foi realizado o download do driver, ou um local de preferência

6. Na estrutura de diretório src\main\resources contém o arquivo CriarTask.csv, clicar com o botão direito em seguida clicar em Copy Path, ir na estrutura de diretório src\test\java\tests\ abrir CriarTask.java alterar a linha         System.setProperty("webdriver.chrome.driver", "C:\\Users\\PedroSilvaMacaubas\\Drivers\\chromedriver.exe"); para o conteúdo copiado quando foi clicado em Copy Path no arquivo CriarTask

7. Ainda no test CriarTask.java, alterar a linha String screenshotArquivo = "C:\\Evidencias\\Evidencias" + Generator.dataHoraParaArquivo () + test.getMethodName() + ".png"; alterar o caminho C:\\Evidencias\\Evidencias, esse vai ser o caminho dos screenshot, então basta criar os diretórios dentro de C: igual acima, ou da forma que achar melhor, não esquecendo de alterar no CriarTAsk.java


# Guia de instalação

1. Instalação Intellij - basta realizar o download da versão community, após o download, basta avançar, escolher o projeto Inmetrics, ou iniciar e abri-lo posteriormente

# Passo a passo para execução




