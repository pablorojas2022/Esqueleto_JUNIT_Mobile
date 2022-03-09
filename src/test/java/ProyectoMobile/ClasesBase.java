package ProyectoMobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidadesExcel.ReadExcelFile;

public class ClasesBase {

	protected AppiumDriver<MobileElement> driver;

// CONSTRUCTOR DE CLASE
	public ClasesBase(WebDriver driver)

	{
		super();
	}

// METODO ALERTA

	public void alert() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
			tiempoEspera(3);
		} catch (Exception e) {
			System.out.println(e); 
		}

	}

// METODO DE NAVEGADOR
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConection()

	{
		AppiumDriver _driver = null;

		Properties properties;
		InputStream entrada = null;
		properties = new Properties();
		try {

			entrada = new FileInputStream("./Properties/datos.properties");
			properties.load(entrada);
// CREAR LAS CAPBILITYS DEL MOVIL
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", properties.getProperty("platformName"));
			caps.setCapability("deviceName", properties.getProperty("deviceName"));
			caps.setCapability("platformVersion", properties.getProperty("platformVersion"));
			caps.setCapability("appPackage", properties.getProperty("appPackage"));
			caps.setCapability("appActivity", properties.getProperty("appActivity"));
			caps.setCapability("noReset", properties.getProperty("noReset"));
			caps.setCapability("autoGrantPermissions", properties.getProperty("autoGrantPermissions"));
// INSTANCIAR APPIUM DRIVER
			try {
				printConsola("Cargando Cability de appium, por favor espere...");
				_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			} catch (MalformedURLException e) {
				printConsola(e.getMessage());
			}
			return _driver;
		} catch (Exception e) {
			printConsola(e.getMessage());
		}
		return _driver;
	}

// METODO CLICK
	public void click(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta);
	}

// METODO BORRAR
	public void borrar(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}

// METODO ENVIAR TEXTO
	public void sendkey(String inputText, By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);
	}

// METODO ENTER SUBMIN
	public void submit(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}

// METODO DE SCROLL BUENO

	public void scrollPage(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
	}

// TOUCH EN LA PANTALLA

	public void scrollVertical(File rutaFile, int xini, int yini, int yfinal, int iteraciones) throws Exception {

		for (int i = 1; i <= iteraciones; i++) {
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(xini, yini)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(xini, yfinal)).release().perform();
			captureScreen(rutaFile);
		}
	}

	// TOUCH EN LA PANTALLA HORIZONTAL

	public void scrollHorizontal(File rutaFile, int X, int Y, int XFin, int YFin, int iteraciones) throws Exception {

		for (int i = 1; i <= iteraciones; i++) {
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(X, Y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
					.moveTo(PointOption.point(XFin, YFin)).release().perform();
			captureScreen(rutaFile);
		} 
	}

	public void tocarPantalla(int x, int y) {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(x, y)).release().perform(); 

	}

	@SuppressWarnings("deprecation")
	public void Tab() {

		driver.getKeyboard().sendKeys(Keys.TAB);

	}

	@SuppressWarnings("deprecation")
	public void sendKeyandroid(ReadExcelFile leer, Properties propiedades, String numHoja, int x, int y)
			throws Exception {
		driver.getKeyboard().sendKeys(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", x, y));
	}

	@SuppressWarnings("rawtypes")
	public void scrollVertical2(File rutaCarpeta) throws Exception {
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(504, 1738)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(516, 1121)).release().perform();
		captureScreen(rutaCarpeta);
	}

// METODO PRINT OUT

	public static void printConsola(String texto) {
		System.out.println(texto);
	}

// METODO CONTROL + A
	public void comando(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
		captureScreen(rutaCarpeta);
	}

// METODO CONTROL + A
	public void bspace(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
		captureScreen(rutaCarpeta);
	}

// METODO ENTER
	public void intro(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(Keys.ENTER);
		captureScreen(rutaCarpeta);
	}

// METODO TIEMPO DE ESPERA
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}

	public String fechaHora() {
// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();

// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

// DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String HoraSistema() {
// TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();

// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

// DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}

	public void captureScreen(File rutaCarpeta) throws Exception {

		String hora = HoraSistema();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));

	}

	public File crearCarpeta(Properties propiedades, String nomTest) {
// ALMACENAMOS LA FECHA DEL SISTEMA
		String fecha = fechaHora();

// CREAMOS EL NOMBRE DE LA CARPETA
		String nomCarpeta = nomTest + "-" + fecha;

// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DE TEST A EJECUTAR
		File directorio = new File("./output/" + nomCarpeta);

// CREAMOS LA CARPETA
		directorio.mkdir();
		return directorio;
	}
	
	public File crearCarpeta2(Properties propiedades, String nomTest) {
		// ALMACENAMOS LA FECHA DEL SISTEMA
				String fecha2 = fechaHora();

		// CREAMOS EL NOMBRE DE LA CARPETA
				String nomCarpeta2 = nomTest + "-" + fecha2;

		// OBTENEMOS LA RUTA DE ALOJAMIENTO DE SALIDA Y EL NOMBRE DE TEST A EJECUTAR
				File directorio2 = new File("./output/" + nomCarpeta2);

		// CREAMOS LA CARPETA
				directorio2.mkdir();
				return directorio2;
			}
			

// METODO INICIAL
	public void urlAcceso(String url)

	{
		driver.get(url);
	}

	public void escribir(String palabra) throws Exception {

		char[] c = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {
			String C = String.valueOf(c[i]);
			((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(C)));
		}

		driver.hideKeyboard();
	}

	@SuppressWarnings("deprecation")
	public void recargarPag() {
		driver.getKeyboard().sendKeys(Keys.F5);
	}
	
	public boolean elementoPresente(By locator) {
		boolean estado = driver.findElement(locator).isDisplayed();
		return estado;
	}

}
