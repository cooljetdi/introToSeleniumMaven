package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.input.ClosedInputStream;

public class PropertiesReader {
	private static Properties configFile;
	
	static {
		try {
			String filePath = "src/test/resources/data/config.properties";
			FileInputStream input = new FileInputStream(filePath);
			
			configFile = new Properties();
			configFile.load(input);
			
			input.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperties(String keyName) {		
		return configFile.getProperty(keyName);
	}
}
