	package base;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	public class TestBase {
		public static WebDriver driver;
		public static Properties prop;

		public TestBase(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/"
						+ "/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		public static void initialization(){
			String browserName = prop.getProperty("browser");

			if(browserName.equals("chrome")){
				driver = new ChromeDriver();
			}
			else if(browserName.equals("FF")){

				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait( 20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}









	}
