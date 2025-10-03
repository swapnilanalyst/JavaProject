package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFileClass {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/utils/env.properties");
		
		Properties prop = new Properties();
		prop.load(file);

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		String url = prop.getProperty("url");
		System.out.println(url);
		
		
		

	}

}
