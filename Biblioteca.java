package com.appium.biblioteca;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class Biblioteca {
	// Creamos un driver del elemento de Appium
	AppiumDriver<MobileElement> driver;

	// Creamos el constructor
	public Biblioteca(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	By btnInicio = By.id("com.android.chrome:id/terms_accept");
	By btnCarrito = By.id("com.android.chrome:id/next_button");
	By btnNGracias = By.id("com.android.chrome:id/negative_button");
	By buscador = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.widget.Spinner\r\n"
					+ "");
	By Buscar = By.xpath(
			"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.widget.Button[2]\r\n"
					+ "");
	By Face = By.linkText("https://m.facebook.com");

	public void Inicio() {
		 try
		 {
			 System.out.println("PASODRIVER222: " + driver);
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(btnInicio));
				driver.findElement(btnInicio).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(btnCarrito));
				driver.findElement(btnCarrito).click();
				driver.findElement(btnNGracias).click();
		 }
		   catch(Exception e)
		   {
			   System.out.println("Error en metodo chrome: "+e);
		   }
		
	}

	public void Busqueda() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(buscador));
		driver.findElement(buscador).sendKeys("Biblioteca Vasconcelos");
		driver.findElement(Buscar).click();
		
		Thread.sleep(3000);
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(349 , 1016)).moveTo(PointOption.point(349 , 459)).release().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Face));
		driver.findElement(Face).click();

	}

}
