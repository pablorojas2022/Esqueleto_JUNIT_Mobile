package MapsObjet;

import org.openqa.selenium.By;
import ProyectoMobile.ClasesBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetClaroUpdateData extends ClasesBase {

	// CONSTRUCTOR DE LA CLASE
	public MapsObjetClaroUpdateData(AppiumDriver<MobileElement> driver)

	{
		super(driver);
		this.driver = driver;
	}

	// ELEMENTOS PAGINA INICIAL
	protected By btnPerfil = By.xpath("//android.widget.ImageView[@resource-id = 'com.clarocolombia.miclaro.debug:id/imgPerfil']");
	protected By btnConfiguration = By.xpath("//android.view.View[@resource-id='com.clarocolombia.miclaro.debug:id/btnConfiguracion']");
	protected By btnUpdateData = By
			.xpath("//android.widget.Button[@resource-id='com.clarocolombia.miclaro.debug:id/btnimgActualizarDatos']"); 
	protected By btnUpdateData2 = By
			.xpath("//android.widget.Button[@resource-id='com.clarocolombia.miclaro.debug:id/btnimgActualizarDatos']");
	protected By btnEditarDir = By.xpath("//android.widget.ImageView [@resource-id = 'com.clarocolombia.miclaro.debug:id/imgEditarDir']");
	protected By spDepartamento = By.xpath("//android.widget.LinearLayout/android.widget.Spinner[1]/android.widget.CheckedTextView");
	protected String Departamento = ("//android.widget.CheckedTextView[@text='");
	protected By spCiudad = By.xpath("//android.widget.Spinner[@resource-id = 'com.clarocolombia.miclaro.debug:id/spCiudad']");
	protected String Ciudad = ("//android.widget.CheckedTextView[@text='");
	protected By edtBarrio = By.xpath("//android.widget.EditText[@resource-id = 'com.clarocolombia.miclaro.debug:id/edtBarrio']");
	protected By spTipo = By.xpath("//android.widget.Spinner[@resource-id = 'com.clarocolombia.miclaro.debug:id/spTipo']");
	protected String Tipo = ("//android.widget.CheckedTextView[@text='");
	protected By textNPrincipal = By.xpath("//android.widget.EditText[@resource-id = 'com.clarocolombia.miclaro.debug:id/txtNPricipal']");
	protected By spSufijo = By.xpath("//android.widget.Spinner[@resource-id = 'com.clarocolombia.miclaro.debug:id/spSufijo1']");
	protected String Sufijo = ("//android.widget.CheckedTextView[@text='");
	protected By txtNSecuendario = By.xpath("//android.widget.EditText[@resource-id = 'com.clarocolombia.miclaro.debug:id/txtNSecuendario']");
	protected By spSufijo3 = By.xpath("//android.widget.LinearLayout[1]/android.view.ViewGroup[2]/android.widget.Spinner/android.widget.CheckedTextView");
	protected String Sufijo2 = ("//android.widget.CheckedTextView[@text='");
	protected By txtNComponente = By.xpath("//android.widget.LinearLayout[1]/android.view.ViewGroup[2]/android.widget.EditText[2]");
	protected By spComplemento = By.xpath("//android.view.ViewGroup[3]/android.widget.Spinner/android.widget.CheckedTextView");
	protected String Complemento = ("//android.widget.CheckedTextView[@text='");
	protected By Numero1= By.xpath("//android.widget.LinearLayout[1]/android.view.ViewGroup[3]/android.widget.EditText");
	protected By spComplemento2 = By.xpath("//android.view.ViewGroup[4]/android.widget.Spinner/android.widget.CheckedTextView");
	protected String Complemento2 = ("//android.widget.CheckedTextView[@text='");
	protected By Numero2= By.xpath("//android.widget.LinearLayout[1]/android.view.ViewGroup[4]/android.widget.EditText");
	
	protected By btnValidar= By.xpath("//android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.Button[2]");
	
	protected By btnGuardar= By.xpath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]");
	
}
