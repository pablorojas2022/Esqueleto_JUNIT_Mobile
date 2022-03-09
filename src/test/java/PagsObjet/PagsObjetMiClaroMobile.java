package PagsObjet;

import java.io.File;
import java.util.Properties;

import MapsObjet.MapsObjetMiClaroMobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidadesExcel.ReadExcelFile;

public class PagsObjetMiClaroMobile extends MapsObjetMiClaroMobile

{
// CREAR CONSTRUCTOR DE LA CLASE
	public PagsObjetMiClaroMobile(AppiumDriver<MobileElement> driver)

	{
		super(driver);
		this.driver = driver;
	}

// METODO PRIMERA PRUEBA - INGRESAR A LA PAG WEB DE PRUEBA
	public void ingresoaClaroMobile(ReadExcelFile leer, Properties propiedades, String nomTest, File rutaCarpeta)
			throws Exception

	{
		tiempoEspera(7000);
		click(btnLoginEmail, rutaCarpeta);
		tiempoEspera(500);
		click(lyEmail, rutaCarpeta);
		tiempoEspera(500);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Data", 1, 0), edUsuario, rutaCarpeta);
		tiempoEspera(500);
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Data", 1, 1), edPassword, rutaCarpeta);
		tiempoEspera(500);
		click(btnLoginUsPass, rutaCarpeta);
		tiempoEspera(50);
		click(btnCancel, rutaCarpeta);
		tiempoEspera(1000);
		/*click(btnSelecEquipo, rutaCarpeta); 
		tiempoEspera(50);
		click(btnAceptarSelEquip, rutaCarpeta);
		tiempoEspera(50);
		click(btnConfirmar, rutaCarpeta);
		tiempoEspera(50);*/
	}

}