/**
 * 
 */
package com.util;

import java.io.File;

/**
 * @author lavanya Jan 11, 2019
 */
public class FolderPaths {

	// return the path of project
	public static final String projectPath = System.getProperty("user.dir") + File.separator;

	// GeckoDriver path for MAC
	public static final String geckoDriverPathForMac = projectPath + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator + "drivers" + File.separator + "GeckoDriver-mac";

	// GeckoDriver path for Windows
	public static final String geckoDriverPathForWindows = projectPath + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator + "drivers" + File.separator + "Geckodriver-Win.exe";

	// ChromeDriver path for MAC
	public static final String chromeDriverPathForMac = projectPath + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator + "drivers" + File.separator + "ChromeDriver-mac";

	// ChromeDriver path for Windows
	public static final String chromeDriverPathForWindows = projectPath + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator + "drivers" + File.separator + "ChromeDriver-Win.exe";

	///Users/lavanya/restassured/selenium-pom/src/main/resources/properties/Config.properties
	// return the path of property files
	public static final String propertyFilePath = projectPath + File.separator + "src" + File.separator + "main"
			+ File.separator + "resources" + File.separator + "properties" + File.separator + "Config.properties";

	// path to screenshot folder
	public static final String screenshot = projectPath + "target" + File.separator + "ScreenShots";

}
