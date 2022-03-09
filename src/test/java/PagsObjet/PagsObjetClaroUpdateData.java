package PagsObjet;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;

import MapsObjet.MapsObjetClaroUpdateData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetClaroUpdateData extends MapsObjetClaroUpdateData {
	// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetClaroUpdateData(AppiumDriver<MobileElement> driver)

	{
		super(driver);
		this.driver = driver;
	}

	// METODO PRIMERA PRUEBA
	public void IngresoaUpdateData(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {
		click(btnPerfil, rutaCarpeta);
		tiempoEspera(50);
		click(btnConfiguration, rutaCarpeta);
		tiempoEspera(50);
		click(btnUpdateData, rutaCarpeta); 
		tiempoEspera(1000);
		click(btnUpdateData2, rutaCarpeta);
		tiempoEspera(1000);
		click(btnEditarDir, rutaCarpeta);
		tiempoEspera(1000);
		// SELECCIONAR DEPARTAMENTO
		click(spDepartamento, rutaCarpeta);
		tiempoEspera(2000);
		String TomarDepartamento = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 0);
		String EsDepartamento = Departamento + TomarDepartamento + "']";
		driver.findElement(By.xpath(EsDepartamento)).click(); 
		tiempoEspera(5000);
		// SELECCIONAR CIUDAD
		click(spCiudad, rutaCarpeta);
		tiempoEspera(2000);
		String TomarCiudad = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 1);
		String EsCiudad = Ciudad + TomarCiudad + "']";
		driver.findElement(By.xpath(EsCiudad)).click();
		tiempoEspera(500);
		// SELECCIONAR BARRIO
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 2), edtBarrio, rutaCarpeta);
		tiempoEspera(5000);
		// SELECCIONAR TIPO
		click(spTipo, rutaCarpeta);
		tiempoEspera(2000);
		String TomarTipo = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 3);
		String EsTipo = Tipo + TomarTipo + "']";
		driver.findElement(By.xpath(EsTipo)).click();
		tiempoEspera(500);
		// SELECCIONAR No. Principal
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 4), textNPrincipal,
				rutaCarpeta);
		tiempoEspera(5000);
		// SELECCIONAR SUFIJO1
		click(spSufijo, rutaCarpeta);
		tiempoEspera(2000);
		String TomarSufijo1 = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 5);
		String EsSufijo1 = Sufijo + TomarSufijo1 + "']";
		driver.findElement(By.xpath(EsSufijo1)).click();
		tiempoEspera(500);
		// SELECCIONAR No. Secundario
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 6), txtNSecuendario,
				rutaCarpeta);
		tiempoEspera(5000);
		// SELECCIONAR SUFIJO2
		scrollVertical(rutaCarpeta, 504, 1192, 938, 3);
		click(spSufijo3, rutaCarpeta);
		tiempoEspera(2000);
		String TomarSufijo2 = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 7);
		String EsSufijo2 = Sufijo2 + TomarSufijo2 + "']";
		driver.findElement(By.xpath(EsSufijo2)).click();
		tiempoEspera(500);
		// SELECCIONAR No. Comp
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 8), txtNComponente,
				rutaCarpeta);
		tiempoEspera(5000);
		// SELECCIONAR Complemento
		click(spComplemento, rutaCarpeta);
		tiempoEspera(2000);
		String TomarComplemento = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 9);
		String EsComplemento = Complemento + TomarComplemento + "']";
		driver.findElement(By.xpath(EsComplemento)).click();
		tiempoEspera(500);
		// SELECCIONAR Numero1
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 10), Numero1, rutaCarpeta);
		tiempoEspera(5000);
		// SELECCIONAR Complemento2
		scrollVertical(rutaCarpeta, 504, 1192, 938, 1);
		click(spComplemento2, rutaCarpeta);
		tiempoEspera(2000);
		String TomarComplemento2 = leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 11);
		String EsComplemento2 = Complemento2 + TomarComplemento2 + "']";
		driver.findElement(By.xpath(EsComplemento2)).click();
		tiempoEspera(500);
		// SELECCIONAR Numero2
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 12), Numero2, rutaCarpeta);
		tiempoEspera(5000);
		//VALIDAR
		click(btnValidar, rutaCarpeta);
		tiempoEspera(2000);
		//GUARDAR
		click(btnGuardar, rutaCarpeta);
		tiempoEspera(5000);
		
		

	}
}
