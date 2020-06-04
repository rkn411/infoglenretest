package com.infoglenn.restest.support.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	private Properties properties;

	
	public PropertiesFile(String propertyFilePath) throws IOException{
		BufferedReader reader;
		reader = new BufferedReader(new FileReader(propertyFilePath));
		properties = new Properties();
		properties.load(reader);
		reader.close();	
	}
	
	
	public String getProperty(String name) {
		return properties.getProperty(name);
	}
}
