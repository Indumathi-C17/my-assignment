package com.configProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	FileInputStream fi;
	
	private Properties getTheProperty() {
		
		File f = new File("C:\\Users\\indum\\eclipse-workspace\\Assignment\\src\\main\\java\\com\\configProperty\\config.properties");
		
		
			try {
				fi = new FileInputStream(f);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		
			Properties prop = new Properties();
			
			try {
				prop.load(fi);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
			return prop;
	}
	
	public String getBrowser() {
		String browser = getTheProperty().getProperty("browser");
		return browser;
		
	}
	
	public String getUrl() {
		String url = getTheProperty().getProperty("url");
		return url;
		
	}
	

}
