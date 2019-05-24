package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author lavanya Jan 11, 2019
 */
public class CommonUtil {

	public final static short TYPE_UPPER_ONLY = 1;
	public final static short TYPE_LOWER_ONLY = 2;
	public final static Random rnd = new Random();

	static final char[] alphas = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * Method to capture Screenshots
	 * 
	 * @param driverInstance
	 */
	public static void captureScreenshots(WebDriver driverInstance) {
		try {
			String timeStamp = timestamp();
			File scr = ((TakesScreenshot) driverInstance).getScreenshotAs(OutputType.FILE);
			File file = new File(FolderPaths.screenshot);
			if (!file.exists())
				file.mkdir();
			File dest = new File(file.getAbsolutePath() + File.separator + timeStamp + ".png");
			FileUtils.copyFile(scr, dest);
		} catch (Exception e) {
			System.out.println("Could not taken screenshot : Failed");
		}
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static String getUniquenumber() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(cal.getTime()) + System.currentTimeMillis();
		return time;
	}

	public static String generateRandomString() {

		short type = 2;
		int min = type == TYPE_LOWER_ONLY ? 26 : 0;
		int max = type == TYPE_UPPER_ONLY ? 26 : alphas.length;
		String generated = "";
		for (int i = 0; i < 5; i++) {
			int random = rnd.nextInt(max - min) + min;
			generated += alphas[random];
		}
		return generated;
	}

	public static String getPopertyFromConfig(String propertName) {
		Properties props;
		try {
			props = new Properties();
			props.load(new FileInputStream(FolderPaths.propertyFilePath));
			return props.getProperty(propertName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
