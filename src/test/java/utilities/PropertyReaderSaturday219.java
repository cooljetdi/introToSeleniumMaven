package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReaderSaturday219 {
	private static Properties configFile;
	static String filePath = "src/test/resources/data/xpath_saturday219";
	
	static {
		try(FileInputStream input = new FileInputStream(filePath)) {
			
			//FileInputStream input = new FileInputStream(filePath);
			
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
