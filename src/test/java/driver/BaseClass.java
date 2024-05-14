package driver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	
	public WebDriver browserSelection() {
	 Properties prop = new Properties();
     FileInputStream input = null;
     WebDriver driver = null;

     try {
         input = new FileInputStream("Config.property");
         prop.load(input);

         String url = prop.getProperty("url");
         String browser = System.getProperty("browser", "chrome");
         
         switch (browser.toLowerCase()) {
             case "chrome":
                 driver = new ChromeDriver();
                 break;
             case "firefox":
                 driver = new FirefoxDriver();
                 break;
             case "edge":
                 driver = new EdgeDriver();
                 break;
             case "ie":
                 driver = new InternetExplorerDriver();
                 break;
             default:
                 System.out.println("Browser not supported.");
                 return driver;
         }

         driver.get(url);

     } catch (IOException ex) {
         ex.printStackTrace();
     } finally {
         if (input != null) {
             try {
                 input.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
         
     }
	return driver;
	}
}