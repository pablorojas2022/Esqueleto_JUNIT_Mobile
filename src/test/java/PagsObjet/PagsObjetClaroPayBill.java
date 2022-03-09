package PagsObjet;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;

import MapsObjet.MapsObjetClaroPayBill;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetClaroPayBill extends MapsObjetClaroPayBill {
// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetClaroPayBill(AppiumDriver<MobileElement> driver)

	{
		super(driver);
		this.driver = driver;
	}
	// METODO PRIMERA PRUEBA
		public void IngresoaPayBill(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {
			click(btnPagos, rutaCarpeta);
			tiempoEspera(1000);
			click(btnPagaFactura, rutaCarpeta);
			tiempoEspera(1000);
			click(selTipoPago, rutaCarpeta);
			tiempoEspera(1000);
			click(btnPagar, rutaCarpeta);
			tiempoEspera(5000);
			
			//SELECCIONAR MEDIO DE PAGO
			click(btnMPago, rutaCarpeta);
			scrollVertical(rutaCarpeta, 504, 1192, 438, 1);
			tiempoEspera(1000);
			tocarPantalla(494,1547);
			tiempoEspera(1000);
			click(btnContinuar, rutaCarpeta);
			tiempoEspera(7000);
			//INSERTA EL NUMERO DE TARJETA
			scrollVertical(rutaCarpeta, 504, 1192, 438, 3);
			sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 1), intNumTC,
					rutaCarpeta);
			tiempoEspera(1000);
			//DA CLICK Y ESCOJE EN MM
			click(selMonth, rutaCarpeta);
			tiempoEspera(2000);
			String TomarMes = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 2);
			String EsMes = mes + TomarMes + "']";
			driver.findElement(By.xpath(EsMes)).click();  
			tiempoEspera(5000);
			//DA CLICK Y ESCOJE	EN AAAA			
			click(selYear, rutaCarpeta);
			tiempoEspera(2000);
			String TomarYear = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 3);
			String Esyear = year + TomarYear + "']";
			driver.findElement(By.xpath(Esyear)).click();  
			tiempoEspera(2000);
			//COLOCA EL CVV
			sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 4), intCVV,
					rutaCarpeta);
			tiempoEspera(1000);
			//DA CLICK Y ESCOJE EL NUMCUOTAS
			click(selCuotas, rutaCarpeta);
			tiempoEspera(2000);
			String Tomarcuotas = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 5);
			String Escuotas = cuotas + Tomarcuotas + "']";
			driver.findElement(By.xpath(Escuotas)).click();  
			tiempoEspera(2000);
			//COLOCA EL NOMBRE COMPLETO
			sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 6), txtNombreTC,
					rutaCarpeta);
			tiempoEspera(1000);
			//DA CLICK Y ESCOJE EL TIPODOC
			click(selTipoID, rutaCarpeta);
			tiempoEspera(2000);
			String TomartipoId = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 7);
			String EstipoId = tipoId + TomartipoId + "']";
			driver.findElement(By.xpath(EstipoId)).click();  
			tiempoEspera(2000);
			//COLOCA NUMDOC, NUMTEL, EMAIL
			sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 8), intNumID,
					rutaCarpeta);
			tiempoEspera(1000);
			sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 9), intNumTel,
					rutaCarpeta);
			tiempoEspera(1000);
			scrollVertical(rutaCarpeta, 504, 1192, 438, 1);
			sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataE", 1, 10), txtEmail,
					rutaCarpeta);
			tiempoEspera(1000);
			scrollVertical(rutaCarpeta, 504, 1192, 438, 1);
			tocarPantalla(544,1919);
			tiempoEspera(1000);
			click(btnAtrás, rutaCarpeta);
			tiempoEspera(1000);
			click(btnPerfil, rutaCarpeta);
			tiempoEspera(500);
			click(btnCloseSesion,rutaCarpeta);
			tiempoEspera(500);		
			click(btnCCloseSesion,rutaCarpeta);
			tiempoEspera(500);		
		}
}