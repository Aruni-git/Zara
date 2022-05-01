package com.Zhara.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Data {

	
	private static Properties prop = new Properties();
	

	public static String getProp(String parameter) {
		return prop.getProperty(parameter);
	}

	public static void setProp(String key, String value) {
		prop.setProperty(key, value);
	}

	public static void setMasterProp() throws FileNotFoundException, IOException {

				prop.load(new FileInputStream("src//testData//QA_Data.properties"));
				

	}												

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String j_username;
		String password;
			setMasterProp();
			j_username = getProp("j_username");
			password =  getProp("password");
			
			System.out.println(j_username);
			System.out.println(password);
	}

}
