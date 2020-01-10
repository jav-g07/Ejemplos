package com.appium.biblioteca;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppJava {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability ("deviceName", "My Phone");
    	caps.setCapability ("udid", "YPJNROFU4SW88DY5");
    	caps.setCapability ("platformName", "Android");
    	caps.setCapability ("PlataformVersion", "7.1.1");
    	caps.setCapability ("appPackage", "com.android.chrome");
    	caps.setCapability ("appActivity", "com.google.android.apps.chrome.Main");
    	caps.setCapability ("noReset", "false");
		
		// Instancia Appium Driver
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
							caps);
		System.out.println("PASODRIVER: " + driver);

		// Creamos la instancia del Page de Ali
		Biblioteca Test = new Biblioteca (driver);

		// Mandamos a llamar el metodo
		Test.Inicio();
		Test.Busqueda();

	}

}
