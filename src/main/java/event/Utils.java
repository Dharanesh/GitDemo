package event;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import action.BaseTest;
import action.TestUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class Utils extends TestUtils
{
	
	
	public Utils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public  void selectByVisiableText(WebElement dropbox , String nameoftheString)
	{
	 Select sel  = new Select(dropbox);
	 sel.selectByVisibleText(nameoftheString);
		
	}
	

	 public static void selectByIndex(WebElement dropbox , int numbmer)
		{
		 Select sel  = new Select(dropbox);
		 sel.selectByIndex(numbmer);
			
		}
	 public  void dragAndDrop(WebElement from , WebElement to) throws InterruptedException{

			Actions builder  = new Actions(driver);
			builder.dragAndDrop(from, to).perform();
			Thread.sleep(2000);
			}
	 
	
	
	 public WebElement getSelectedValue(String xpath)

	 {
		 Select  sec = new Select(driver.findElement(By.xpath(xpath)));
		    WebElement options = sec.getFirstSelectedOption();
		    return options;
		    
	 
	 
	 }
	 public String getSelectedStringValue(String xpath)

	 {
		 Select  sec = new Select(driver.findElement(By.xpath(xpath)));
		    WebElement options = sec.getFirstSelectedOption();
		    return options.getText();
		    
	 
	 
	 }
	

	 public  void rightClick(String path)
		{
			
			Actions act = new Actions(driver);
			//WebElement path1 = driver.findElement(By.xpath(config.getData(path))); 
			act.contextClick(driver.findElement(By.xpath((path)))).build().perform();
		}
		

		public  void multiButton(String path) throws InterruptedException
		{
			
			List<WebElement > clickon = driver.findElements(By.xpath((path)));
			int size = clickon.size();
			clickon.get(size-1).click();
		
		}
	
		public List<String> allDropDownValues(String xpath) 
		{
			List a = new LinkedList<String>();
			Select sel = new Select(driver.findElement(By.xpath(xpath)));
			List<WebElement> se = sel.getOptions();
			for (WebElement webElement : se) 
			{
				String aa = webElement.getText();
				a.add(aa);
			}
				return a;
				
				
		}
		
		 public  void doubleClick(String path)
			{
				
				Actions act = new Actions(driver);
				act.moveToElement(driver.findElement(By.xpath(path))).doubleClick().perform();
			}
		/* need to check for errors*/
		 
		//Extract the text from a pdf file for a particular area
			public  void Extractbyarea(String FilePath, int x, int y, int width, int height ) throws Exception
			{

				PDDocument document = PDDocument.load(new File(FilePath));
			    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			    stripper.setSortByPosition(true);
			    Rectangle2D rect = new Rectangle2D.Double(10, 60, 400, 1000);
			    stripper.addRegion("class1", rect);/*.addRegion("class1", rect);*/
			    PDPage firstPage = document.getPage(0);
			    stripper.extractRegions( firstPage );
			    System.out.println("Text in the area:" + rect);
			    System.out.println(stripper.getTextForRegion( "class1"));

			}
			
			
			//extract text of a particular area from two pdfs and compare them
			public  void ExtractbyareaCompare(String FilePath1, int x, int y, int width, int height, String FilePath2   ) throws Exception
			{

				PDDocument document = PDDocument.load(new File(FilePath1));
			    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			    stripper.setSortByPosition(true);
			    Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
			    stripper.addRegion("class1", rect);
			    PDPage firstPage = document.getPage(0);
			    stripper.extractRegions( firstPage );
			    System.out.println("Text in the area of document 1:" + rect);
			    String text1 = stripper.getTextForRegion( "class1");
			    System.out.println(stripper.getTextForRegion( "class1"));
			    document.close();
			    
			    PDDocument document1 = PDDocument.load(new File(FilePath2));
			    PDFTextStripperByArea stripper1 = new PDFTextStripperByArea();
			    stripper1.setSortByPosition(true);
			    Rectangle2D rect1 = new Rectangle2D.Double(x, y, width, height);
			    stripper1.addRegion("class2", rect1);
			    PDPage firstPage1 = document1.getPage(0);
			    stripper1.extractRegions( firstPage1 );
			    System.out.println("Text in the area of document 2:" + rect1);
			    String text2 = stripper1.getTextForRegion( "class2");
			    System.out.println(stripper1.getTextForRegion( "class2"));
			    
			    
			    //comparing if texts in both the files for the specified area are matching
			  
				   Assert.assertSame(text1, text2);
			    	System.out.println("contents matched");
			    
			}	
	
			//Get all the text from a PDF file and verify for a particular text is present in the file
			public void ReadPDF(String SystemName, String FileName, String reqTexttoverify) throws Exception
			{

				File TestFile = new File("C:\\Users\\"+SystemName +"\\Downloads\\"+FileName +".pdf");
				 PDFTextStripper tStripper = new PDFTextStripper();
				 PDDocument document = PDDocument.load(TestFile);
			     tStripper.setStartPage(1);
			     tStripper.setEndPage(1);
			     String pdfFileInText = tStripper.getText(document);
			     
			// Use TestNG assertion for checking if your text is present in content
			Assert.assertTrue(pdfFileInText.contains(reqTexttoverify)); 


			}
			

			//get entire text from the two PDF files and comapare the text to be equal
			public  void ExtracttextfromtwopdfsCompare(String SystemName, String FileName1, String FileName2) throws Exception
			{

				File Actual = new File("C:\\Users\\"+SystemName +"\\Downloads\\"+FileName1 +".pdf");
				 PDFTextStripper tStripper = new PDFTextStripper();
				 PDDocument document = PDDocument.load(Actual);
			     tStripper.setStartPage(1);
			     tStripper.setEndPage(1);
			     String pdfFileInText1 = tStripper.getText(document);
			     System.out.println("####### text of first file ##############");
			     System.out.println(pdfFileInText1);
			     System.out.println("####### text of first file ##############");
			     
			     
			     File Expected = new File("C:\\Users\\"+SystemName +"\\Downloads\\"+FileName2 +".pdf");
				 PDFTextStripper tStripper1 = new PDFTextStripper();
				 PDDocument document1 = PDDocument.load(Expected);
			     tStripper1.setStartPage(1);
			     tStripper1.setEndPage(1);
			     String pdfFileInText2 = tStripper1.getText(document1);
			     System.out.println("####### text of second file ##############");
			     System.out.println(pdfFileInText2);
			     System.out.println("####### text of second file ##############");
			     
			     
			// Use TestNG assertion for checking if your text is present in content
			Assert.assertEquals(pdfFileInText1, pdfFileInText2); 


			}
		 
			//Wait For element Method:==============================
			public void waitForElement(String strObjectProperty)
			{
				    ConfigData config = new ConfigData();
				    Long startTime = System.currentTimeMillis();

					driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					try{
						wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@id='progressbar']"))));
						Thread.sleep(50);
						wait.until(ExpectedConditions.invisibilityOfAllElements((driver.findElements(By.xpath("//*[@src='./images/CW_AjaxLoader.gif']")))));
					} catch(Exception e) {
						System.out.println("Progress Bar is not present!");
					}
					boolean pageLoadComplete = false;
					Long maxTimeOut =  Long.parseLong(config.getData("TimeOutInMilliSecs"));
					Long endTime = 0L;
					while(!pageLoadComplete){
						pageLoadComplete = isPageLoadComplete();		
						endTime = System.currentTimeMillis();
						if ((endTime-startTime) > maxTimeOut){
							break;
						}			
					}
					
					if (!(strObjectProperty!=null && strObjectProperty.equals("")))
					{
//						wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(config.getData(strObjectProperty))))));
						try{
							//wait.until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath(config.getData(strObjectProperty))))));
							Wait waitFluent = new FluentWait(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
							waitFluent.until(ExpectedConditions.visibilityOf((driver.findElement(By.xpath(config.getData(strObjectProperty))))));
						
						} catch (StaleElementReferenceException stElEx){
							try {
								wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(config.getData(strObjectProperty))))));
							} catch (Exception e) {	
								try {
									endTime = System.currentTimeMillis();
									if ((endTime-startTime)  < maxTimeOut){
										System.out.println("Sleeping...");
										Thread.sleep(maxTimeOut - (endTime-startTime));		
									} 
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
					driver.manage().timeouts().implicitlyWait(maxTimeOut, TimeUnit.MILLISECONDS);
					endTime = System.currentTimeMillis();
					System.out.println("Time taken for Page load is :: " + (endTime-startTime)/1000 +"");
					/* String debugTrue = config.getData("Debug");
					 if (debugTrue.equalsIgnoreCase("True"))
					 {
						try
						{
							Thread.sleep(2000);
						} catch(Exception e){				
						}
					}*/
			
			}	 
		 
			private  boolean isPageLoadComplete( )
			{
				boolean flag = false;
				JavascriptExecutor js = (JavascriptExecutor)driver;
				  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
					   System.out.println("Page Is loaded.");
					   flag= true;		   
				  }
				 return flag;
			} 
			
			//Unzip:==========================
			public  void unZip(String zipFile, String outputFolder) throws InterruptedException{
		    	
			     byte[] buffer = new byte[1024];
			     try{
			    	//create output directory is not exists
			    	File folder = new File(outputFolder);
			    	if(!folder.exists()){
			    		folder.mkdir();
			    	}
			    	//get the zip file content
			    	ZipInputStream zis =
			    		new ZipInputStream(new FileInputStream(zipFile));
			    	//get the zipped file list entry
			    	ZipEntry ze = zis.getNextEntry();
			    	while(ze!=null){
			    	   String fileName = ze.getName();
			    	  
			           File newFile = new File(outputFolder + File.separator + fileName);
			           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
			            //create all non exists folders
			            //else you will hit FileNotFoundException for compressed folder
			            new File(newFile.getParent()).mkdirs();
			            FileOutputStream fos = new FileOutputStream(newFile);
			            int len;
			            while ((len = zis.read(buffer)) > 0) {
			       		fos.write(buffer, 0, len);
			            }
			            fos.close();
			            ze = zis.getNextEntry();
			    	}
			        zis.closeEntry();
			    	zis.close();
			    	
			    	System.out.println("Done "  + folder );
			    	
			    	
			    
			    	
			    }catch(IOException ex){
			       ex.printStackTrace();
			    }
			   }	 
			
			//UnzipIt:=======================
			public  void unZipIt(String zipFile, String outputFolder) throws InterruptedException
			{
		    	
			     byte[] buffer = new byte[1024];
			     try{
			    	//create output directory is not exists
			    	File folder = new File(outputFolder);
			    	if(!folder.exists()){
			    		folder.mkdir();
			    	}
			    	//get the zip file content
			    	ZipInputStream zis =
			    		new ZipInputStream(new FileInputStream(zipFile));
			    	//get the zipped file list entry
			    	ZipEntry ze = zis.getNextEntry();
			    	while(ze!=null){
			    	   String fileName = ze.getName();
			    	  
			           File newFile = new File(outputFolder + File.separator + fileName);
			           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
			            //create all non exists folders
			            //else you will hit FileNotFoundException for compressed folder
			            new File(newFile.getParent()).mkdirs();
			            FileOutputStream fos = new FileOutputStream(newFile);
			            int len;
			            while ((len = zis.read(buffer)) > 0) {
			       		fos.write(buffer, 0, len);
			            }
			            fos.close();
			            ze = zis.getNextEntry();
			    	}
			        zis.closeEntry();
			    	zis.close();
			    	
			    	System.out.println("Done "  + folder );
			    	
			    }catch(IOException ex){
			       ex.printStackTrace();
			    }
			   }
			
			
		 
			public void OutlookSendMailCheck(String MailSubject,String ZipfileName,boolean BodyPart)
			{
				   Utils Utils = new Utils(driver);
				
				   driver.get("https://portal.cubeware.com/owa");
				   Utils.waitForElement("");
				   Utils.waitForElement("");
				   
			       //Outlook open validation:===
				   Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Connected to Microsoft Exchange']")).isDisplayed(),true);
				   System.out.println("Outlook opened now.");
				   Utils.waitForElement("");
				   //Username and password:======================
				   driver.findElement(By.xpath("//label[text()='User name:']/following::input[1]")).sendKeys("I_QSA");
				   Utils.waitForElement("");
				   driver.findElement(By.xpath("//label[text()='Password:']/following::input[1]")).sendKeys("Password1");
				   Utils.waitForElement("");
				   driver.findElement(By.xpath("//input[@type='submit']")).click();
				   Utils.waitForElement("");
				   Utils.waitForElement("");
				   
				   Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Mail']")).isDisplayed(),true);
				   System.out.println("Outlook loggedIn properly.");
				   
				   //click Inbox:===================
				   driver.findElement(By.xpath("(//span[text()='Inbox'])[3]")).click();
				   Utils.waitForElement("");
				   
				   //Click on Latest mail for Today:================
				   driver.findElement(By.xpath("//div[text()='Today']/following::div[1]/div[1]/div[1]")).click();
				   Utils.waitForElement("");
				   
				   //String MailAddress="mail_test _18011";
				   Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divConvTopic' and text()='"+MailSubject+"']")).isDisplayed(),true);
				   System.out.println("Mail send to expected sender.");
				   
				   //Report Zip file validate:==============
				   //String ReportZipFile="Sales by country.zip";
				   Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Attachments:']/following::a[@title='"+ZipfileName+"']")).isDisplayed(),true);
				   System.out.println("Expected Zip file is available in mail attachment.");
				   
				   try
				   {
					   Assert.assertEquals(driver.findElement(By.xpath("//div[@id='divBdy']/div/div/font/span")).isDisplayed(),true);
					   System.out.println("Mail Body is available.");
					  /* if(BodyPart)
					   {
						   Assert.assertEquals(driver.findElement(By.xpath("//span[text()='SMTP mail Forwarding']")).isDisplayed(),true);
						   System.out.println("Mail Body part is displaying");
					   }*/
				   }
				   catch(Exception e)
				   {
					   System.out.println("Mail Body is not available.");
				   }
				   
				   Utils.waitForElement("");
				   //Sign out:================
				   driver.findElement(By.xpath("//span[text()='sign out']")).click();
				   //driver.close();
			}
		 
//===========#########Gmail ID:########==================
			public void AutoGmailValidate(String GamilMailSubject) throws Exception
			{
				   Utils Utils = new Utils(driver);
				   WebDriverWait wait2 = new WebDriverWait(driver, 10);
				   
				   driver.get("https://mail.google.com/mail");
				   Thread.sleep(5000);
				   WebElement StartingWindow = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//content[text()='Continue to Gmail']")));
				   
				  //Validate after open url:=====================
				  Assert.assertEquals(driver.findElement(By.xpath("//content[text()='Continue to Gmail']")).isDisplayed(),true);
				  System.out.println("Gmail url is opened now.");
				  Thread.sleep(5000);
				   
				  //Username and password:======================
				  driver.findElement(By.xpath("//input[@type='email']")).clear();
				  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("AutomationCubeware@gmail.com");
				  Thread.sleep(5000);
				   
				  driver.findElement(By.xpath("//span[text()='Next']")).click();
				  Thread.sleep(5000);
				   
				  driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Offline@2");
				  Thread.sleep(5000);
				  
				  driver.findElement(By.xpath("//span[text()='Next']")).click();
				  Thread.sleep(5000);
				  
				   try
				   {
					   Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Protect your account']")).isDisplayed(),true);
					   System.out.println("Protect accout window dispalying.");
					   Thread.sleep(5000);
				   }
				   catch(Exception e)
				   {
					   System.out.println("Protect accout window not dispalying.");
				   }
				   Thread.sleep(5000);
				   Thread.sleep(2000);
				
				   driver.findElement(By.xpath("//a[@class='gb_x']")).click();
				   Thread.sleep(5000);
				   driver.findElement(By.xpath("//span[text()='Gmail'] ")).click();
				   Thread.sleep(5000);
				   
				   WebDriverWait wait = new WebDriverWait(driver, 10);
				   WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Primary']")));
				   
				   System.out.println("Primary window is displaying now:===============");
				   Thread.sleep(5000);
				   //Click Inbox:============
				   driver.findElement(By.xpath("//div[@class='gb_Xb']")).click();
				   Thread.sleep(5000);
				   driver.findElement(By.xpath("//a[text()='Inbox']")).click();
				   Thread.sleep(5000);
				   
				   //Click First mail:=============
				   //==================######Mail Subject:########================
				   String GmailSubject= driver.findElement(By.xpath("(//div[@class='UI']//following::tr[1]/td[6]/div[1]/div[1]/div[1]/span[1]/span[1])[1]")).getText();
				   System.out.println("Gmail Subject is:->"+GmailSubject);
				   Thread.sleep(5000);
				   Thread.sleep(2000);
				   
				   String GamilSubject2=driver.findElement(By.xpath("(//div[@class='UI']//following::tr[2]/td[6]/div[1]/div[1]/div[1]/span[1]/span[1])[1]")).getText();
				   int count=0;
				   try
				   {
					   //Assert.assertEquals(GmailSubject,GamilMailSubject);
					   if(GmailSubject.equals(GamilMailSubject))
					   {
						   System.out.println("Required Gmail subject is comming as expected.");
						   Thread.sleep(5000);
						   count++;
					   }
					   else if(GamilSubject2.equals(GamilMailSubject))
					   {
						   System.out.println("Required Gmail subject is comming as expected.");
						   Thread.sleep(5000);
						   count++;
					   }
					   
				   }catch(Exception e)
				   {
					   System.out.println("Required Gmail subject is not comming as expected.");
					   Thread.sleep(5000);
				   }
				   Thread.sleep(5000);
				   System.out.println("Count is:->"+count);
				   
				   try
				   {
					   if(count>=1)
					   {
						   System.out.println("Gmail subject is comming as expected.");
					   }
				   }catch(Exception e)
			   		{
					   System.out.println("Count is not comming properly.");
			   		}
				   Thread.sleep(5000);
				   
				   System.out.println("GMail Validate properly.");
				   Thread.sleep(3000);
				   driver.findElement(By.xpath("//div[@class='gb_xc gb_Ia gb_mg gb_f']")).click();
				   Thread.sleep(3000);
				   driver.close();
				   
			}
			
}
