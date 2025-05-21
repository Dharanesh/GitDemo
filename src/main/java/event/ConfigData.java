package event;

import action.BaseTest;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {
	
	 Properties pro;
		
		public  void ConfigReader()
		{
			try{
				
			File src = new File(System.getProperty("user.dir") + "/src/main/resources/configs/Config.properties");
		   /*D:\MavenProject\maven\Configuration\Config.properties*/
			FileInputStream fls = new FileInputStream(src);
			pro = new Properties();		
		  	pro.load(fls);
			 	
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Exception is : "+ e );		
			}
			
				
		}

		public String getData(String Data)
		{
			ConfigReader();
			String data = pro.getProperty(Data);
			return data;
			
			
		}


		public By getObjectLocator(String ElementName) throws Exception
		 {
				ConfigReader();
				
				String ElementData=getData(ElementName);
				
				if(ElementName.contains("Id"))
					return By.id(ElementData);
				else if(ElementName.contains("Name"))
				    return By.xpath(ElementData);
				else if(ElementName.contains("Xpath"))
				    return By.xpath(ElementData);
				else
					System.out.println("Contains Text not found");
				//else
					//throw new Exception("Locator type '" + ElementName
						//+ "' not defined!!");
				return null;
				
		 }
}
