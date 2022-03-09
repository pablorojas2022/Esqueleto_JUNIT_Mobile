package ProyectoMobile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PagsObjet.PagsObjetClaroPayBill;
import PagsObjet.PagsObjetClaroUpdateData;
import PagsObjet.PagsObjetMiClaroMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunProyMobile {

	private AppiumDriver<MobileElement> driver;
	PagsObjetMiClaroMobile pagHome;
	PagsObjetClaroUpdateData pagFlujos;
	PagsObjetClaroPayBill pagFlujosDos;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	String url = null;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws IOException {

// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClasesBase.appiumDriverConection();
// INSTANCIAR LA CLASE DE PROPIEDADES DE JAVA UTIL
		propiedades = new Properties();
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
// CREAR VARIABLES TIPO INPUTSTRING
		InputStream entrada = null;
// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

	@Test // INGRESAR A LA PAGINA A CAMBIAR LA DIRECCION
	public void CambioDireccion_Test() throws Exception {
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "Data", 1, 2).equals("SI")) {
// INSTANCIAR CLASE BASE
		ClasesBase clasebase = new ClasesBase(driver);
// OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
// CREAR CARPETA
		File rutaCarpeta = clasebase.crearCarpeta(propiedades, nomTest);
// INSTANCIAR LAS CLASES QUE SE COLOCAN EN PAGEOBJECT
		pagHome = new PagsObjetMiClaroMobile(driver);  
		pagFlujos = new PagsObjetClaroUpdateData(driver);
// ALMACENO EN LA VARIABLE EL VALOR DE URL DEL EXCEL
		pagHome.ingresoaClaroMobile(leer, propiedades, nomTest, rutaCarpeta);
		pagFlujos.IngresoaUpdateData(leer, propiedades, rutaCarpeta);
	  }
	}
	
	@Test //INGRESAR A LA PAGINA A PAGAR UNA FACTURA
	public void PagarFactura_Test() throws Exception {
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "DataR", 1, 13).equals("SI")) {
		// INSTANCIAR CLASE BASE
				ClasesBase clasebase = new ClasesBase(driver);
		// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		// CREAR CARPETA
				File rutaCarpeta2 = clasebase.crearCarpeta2(propiedades, nomTest);
		// INSTANCIAR LAS CLASES QUE SE COLOCAN EN PAGEOBJECT
				pagHome = new PagsObjetMiClaroMobile(driver);  
				pagFlujosDos = new PagsObjetClaroPayBill(driver);
		// ALMACENO EN LA VARIABLE EL VALOR DE URL DEL EXCEL
				pagHome.ingresoaClaroMobile(leer, propiedades, nomTest, rutaCarpeta2);
				pagFlujosDos.IngresoaPayBill(leer, propiedades, rutaCarpeta2);
			}
	}
	
	@After
	public void cerrar() {
// CERRAR PROCESO
		//driver.quit();

	}

}