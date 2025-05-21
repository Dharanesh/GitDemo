package action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import event.ConfigData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;


public abstract class CalculatedElements extends BaseTest
{
	//GenericMethodsClass GMC = new GenericMethodsClass();
	ValidationPropertyUtil calE = new ValidationPropertyUtil();
	ConfigData ConfigReader=new ConfigData();
	public DecimalFormat df2 = new DecimalFormat(".##");
	event.Utils Utils=null;
	event.Excelnput Excelnput=new event.Excelnput();

	public void CalculatedObjectsCheck() throws InterruptedException, NoSuchElementException 
	{
		try 
		{
			Utils=new event.Utils(driver);
			Utils.waitForElement("");
			// row calculated element checking
			driver.findElement(ConfigReader.getObjectLocator("RowPortionFstRowTxtXpath")).click();
			Utils.waitForElement("");
			String ActRowHederTxt = driver.findElement(ConfigReader.getObjectLocator("SelectElementHeaderTxtXpath"))
					.getText();
			if (ActRowHederTxt.contains("Rows")) {
				driver.findElement(ConfigReader.getObjectLocator("ElementGroupTxtXpath")).isDisplayed();
				Select SelectElement = new Select(
						driver.findElement(ConfigReader.getObjectLocator("ElemntGroupListXpath")));
				SelectElement.selectByVisibleText(
						Excelnput.ExcelDatainput("CalculatedElements", 1, 1));
				Utils.waitForElement("");
				List<WebElement> CalculatedElemntlist = driver
						.findElements(ConfigReader.getObjectLocator("CalculatedElemntslistXpath"));
				int RowCalculatedEleList = CalculatedElemntlist.size();
				int RowCount = 0;
				for (int c = 0; c < CalculatedElemntlist.size(); c++) {
					if (calE.CalculatedElementList[c].equals(CalculatedElemntlist.get(c).getText())) {
						RowCount++;
					}
				}
				if (RowCount == RowCalculatedEleList) {
					System.out.println("All calculated Elements are present for Row.");
					Reporter.log("All calculated Elements are present for Row.");
				}
				Utils.waitForElement("");
				driver.findElement(ConfigReader.getObjectLocator("OkBtnXpath")).click();
				Utils.waitForElement("");
			} else {
				System.out.println("Row Element selection window is not opened.");
			}

			// Columns Calculated Element checking:-
			driver.findElement(ConfigReader.getObjectLocator("ColumnPortionFstTxtXpath")).click();
			Utils.waitForElement("");
			String ActColumnHeaderTxt = driver.findElement(ConfigReader.getObjectLocator("SelectElementHeaderTxtXpath"))
					.getText();
			if (ActColumnHeaderTxt.contains("Columns")) {
				driver.findElement(ConfigReader.getObjectLocator("ElementGroupTxtXpath")).isDisplayed();
				Select SelectElement = new Select(
						driver.findElement(ConfigReader.getObjectLocator("ElemntGroupListXpath")));
				SelectElement.selectByVisibleText(
						Excelnput.ExcelDatainput("CalculatedElements", 1, 1));
				Utils.waitForElement("");
				List<WebElement> CalculatedElemntlist = driver
						.findElements(ConfigReader.getObjectLocator("CalculatedElemntslistXpath"));
				int ColumnCalculatedEleList = CalculatedElemntlist.size();
				int RowCount = 0;
				for (int c = 0; c < CalculatedElemntlist.size(); c++) {
					if (calE.CalculatedElementList[c].equals(CalculatedElemntlist.get(c).getText())) {
						RowCount++;
					}
				}
				if (RowCount == ColumnCalculatedEleList) {
					System.out.println("All calculated Elements are present for Column.");
					Reporter.log("All calculated Elements are present for Column.");
				}
				Utils.waitForElement("");
				driver.findElement(ConfigReader.getObjectLocator("OkBtnXpath")).click();
				Utils.waitForElement("");
			} else {
				System.out.println("Column element selection window is not opened.");
			}

			System.out.println("All calculated Elements are present.");
			Reporter.log("All calculated Elements are present.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("All calculated Elements are not present.");

		}
	}
    //method for removing extra character(i.e (,),€,,) from string..
	public String RemoveCharMethod(String s) {
		for (int i = 0; i < 1; i++) {
			if (s.contains("(")) {
				String BfDiffRowElemnt = s.replace("(", " ").trim();
				String BfDiffRowElemnt1 = BfDiffRowElemnt.replace(")", " ").trim();
				String DiffRowElemnt = BfDiffRowElemnt1.replace("€", " ").trim();
				String FinalValueAf = DiffRowElemnt.replace(",", "").trim();
				return FinalValueAf;
			} else if (s.contains("€")) {
				String SumRowElemnt = s.replace("€", " ").trim();
				String FinalValueAf = SumRowElemnt.replace(",", "").trim();
				return FinalValueAf;
			} 
			else if (s.contains("%"))
			{
				String FinalValueAf = s.replace("%", " ").trim();
				return FinalValueAf;
			}
			else {
				System.out.println("number dont have '€' and '(' symbol");
				String FinalValueAf = s.replace(",", "").trim();
				return FinalValueAf;
			}
		}
		return null;
	}

	// For Sum Calculation give string as :-RowSum/ColumnSum
	public void SumCalculationValidation(String ChooseRowColumnSum)throws InterruptedException, NoSuchElementException 
	{
		try
		{
		Utils=new event.Utils(driver);
		List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		Utils.waitForElement("");
		List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		Utils.waitForElement("");
		 if(ChooseRowColumnSum.equalsIgnoreCase("RowSum"))
		 {
			 for(int i=0;i<ColumnHeadersList.size();i++)
			 {
				 if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("SUM"))
				 {
					 int countPass=0;
					 int countFail=0;
					 System.out.println("SUM calculated element is added to the Column.");
					 Reporter.log("SUM calculated element is added to the Column.");
					 System.out.println("SUM calculation will perform upto "+i+" column.");
					 Reporter.log("SUM calculation will perform upto "+i+" column.");
					 List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					 for(int R=1;R<=RowValueCount.size();R++)
					 { 
						 ArrayList<Double> arrList=new ArrayList<Double>();
						 Double sum=0.00;
						 String Roundedsum = null;
						 double Resultsum = 0.0;
						 String ActualSumElementValue;
						 List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						 for(int j=0;j<i;j++)
					     {
							String valuelength=RowElementList.get(j).getText();
							if(valuelength.length()==0)
						    {
								System.out.println("Cell "+j+" of "+R+" row having null value.");
						    }
						    else
						    {
						    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
						    	double RowElement2 = Double.parseDouble(RowElement1);
						    	arrList.add(RowElement2);
						    }
						  }
						 System.out.println("Array Elemnts are:======");
						 for(int a=0;a<arrList.size();a++)
						 {
							 System.out.println(arrList.get(a));
						 }
						 
						 if(!(arrList.size()==0))
						  {
							 for(int s=0;s<arrList.size();s++)
							 {
							 sum +=arrList.get(s);
							 //Roundedsum=finalValue2.substring(0,finalValue2.indexOf("."));
							 }
							 BigDecimal BdSum=new BigDecimal(sum);
							 BdSum = BdSum.setScale(1, BigDecimal.ROUND_HALF_UP);
							 String StrSum=BdSum.toString();
							 Roundedsum=StrSum.substring(0,StrSum.indexOf("."));
						  } 
						  else
						  {
							 System.out.println("There is no element in the row:-"+R);
						  }
						 for(int lr=0;lr<=i;lr++)
						 {
						   if(lr==i)
						   {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								    countPass++;
									System.out.println("Full column is Empty.");
									Reporter.log("Full column is Empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {	
								    countPass++;
								  	System.out.println("One Cell element value in the "+R+" row having zero value.");
								  	System.out.println("SUM Value row "+R+" for One cell value is zero:-"+LastRowValue);
								  	Reporter.log("SUM Value row "+R+" for One cell value is zero:-"+LastRowValue);
							  }
							else if(LastRowValue.length()==0)
							{
									System.out.println("Expected SUM value in the "+R+" row is empty i.e having Null value.");
									Reporter.log("Expected SUM value in the "+R+" row is empty i.e having Null value.");
							}
							else
							{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText());
								  Double ActualSumValueDbl= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdSum=new BigDecimal(ActualSumValueDbl);
								  BdSum = BdSum.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrSum=BdSum.toString();
								  ActualSumElementValue=StrSum.substring(0,StrSum.indexOf("."));
								
								  System.out.println("Actual Result for "+R+" row is:-"+ActualSumElementValue);
								  System.out.println(ActualSumElementValue +","+ Roundedsum );
								  
								  if(ActualSumElementValue.equals(Roundedsum))
								  {
									countPass++;
									System.out.println("Actual and expected result is same for "+R+" row.");
									Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									countFail++;
									System.out.println("Actual and expected result is not same for "+R+" row.");
								  	Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							 }
						    }
						   }
						 Utils.waitForElement("");
						 arrList.clear();
						 System.out.println("loop "+R+" completed.");
						 Reporter.log("loop "+R+" completed.");
					 }
					 System.out.println("calculaion of SUM for the table,passRows are:-"+countPass);
					 System.out.println("calculaion of SUM for the table,FailRows are:-"+countFail);
					 Reporter.log("calculaion of SUM for the table,passRows are:-"+countPass);
					 Reporter.log("calculaion of SUM for the table,FailRows are:-"+countFail);
					 Assert.assertEquals(countPass,RowHeadersList.size()-1);
					 break;
				  }
				 else
				 {
					 System.out.println("SUM Column is not found still." );
				 }
			 }
		 }
		 else if(ChooseRowColumnSum.equalsIgnoreCase("ColumnSum"))
		 {
			 for(int i=0;i<RowHeadersList.size();i++)
			 {
				 if(RowHeadersList.get(i).getText().equalsIgnoreCase("SUM"))
				 {
					 int countPass=0;
					 int countFail=0;
					 System.out.println("SUM calculated element is added to the row.");
					 Reporter.log("SUM calculated element is added to the row.");
					 System.out.println("SUM calculation will perform upto "+i+" row.");
					 Reporter.log("SUM calculation will perform upto "+i+" row.");
					 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
					 for(int C=1;C<=ColumnValueCount.size();C++)
					 { 
						 ArrayList<Double> arrList=new ArrayList<Double>();
						 double sum = 0.0;
						 String Roundedsum = null;
						 double Resultsum = 0.0;
						 String ActualSumElementValue;
						 List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
						 for(int j=0;j<i;j++)
					     {
							String valuelength=ColumnElementList.get(j).getText();
							if(valuelength.length()==0)
						    {
								System.out.println("Cell "+j+" of "+C+" Column having null value.");
						    }
						    else
						    {
						    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
						    	double RowElement2 = Double.parseDouble(RowElement1);
						    	arrList.add(RowElement2);
						    }
						  }
						 
						 if(!(arrList.size()==0))
						  {
							 for(int s=0;s<arrList.size();s++)
							 {
								 sum +=arrList.get(s);
							 }
							 BigDecimal BdSum=new BigDecimal(sum);
							 BdSum = BdSum.setScale(1, BigDecimal.ROUND_HALF_UP);
							 String StrSum=BdSum.toString();
							 Roundedsum=StrSum.substring(0,StrSum.indexOf("."));
						  } 
						  else
						  {
							 System.out.println("There is no element in the Column:-"+C);
						  }
						 for(int lr=0;lr<=i;lr++)
						 {
						   if(lr==i)
						   {
							  String LastColumnValue=ColumnElementList.get(lr).getText();
							  if(LastColumnValue.equals("#NV"))
							  {
								    countPass++;
									System.out.println("Full column is Empty.");
									Reporter.log("Full column is Empty.");
							  }
							  else if(LastColumnValue.equals("€0.00"))
							  {
								    countPass++;
								  	System.out.println("One Cell element value in the "+C+" Column having zero value.");
								  	System.out.println("SUM Value Column "+C+" for One cell value is zero:-"+LastColumnValue);
								  	Reporter.log("SUM Value Column "+C+" for One cell value is zero:-"+LastColumnValue);
							  }
							else if(LastColumnValue.length()==0)
							{
									System.out.println("Expected SUM value in the "+C+" Column is empty i.e having Null value.");
									Reporter.log("Expected SUM value in the "+C+" Column is empty i.e having Null value.");
							}
							else
							{
								  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
								  Double ActualSumValue= Double.parseDouble(RowlastElement);
								
								  BigDecimal BdSum=new BigDecimal(ActualSumValue);
								  BdSum = BdSum.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrSum=BdSum.toString();
								  ActualSumElementValue=StrSum.substring(0,StrSum.indexOf("."));
								  
								  System.out.println("Actual Result for "+C+" Column is:-"+ActualSumElementValue);
								  System.out.println(ActualSumElementValue +", "+Roundedsum);
								  if(ActualSumElementValue.equals(Roundedsum))
								  {
									  countPass++;
									System.out.println("Actual and expected result is same for "+C+" Column.");
									Reporter.log("Actual and expected result is same for "+C+" Column.");
								  }
								  else
								  {
									  countFail++;
									System.out.println("Actual and expected result is not same for "+C+" Column.");
								  	Reporter.log("Actual and expected result is not same for "+C+" Column.");
								  }
							 }
						    }
						   }
						 Utils.waitForElement("");
						 arrList.clear();
						 System.out.println("loop "+C+" completed.");
						 Reporter.log("loop "+C+" completed.");
					 }
					 System.out.println("calculaion of SUM for the table,passColumns are:-"+countPass);
					 System.out.println("calculaion of SUM for the table,FailColumns are:-"+countFail);
					 Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
					 break;
				  }
				 else
				 {
					 System.out.println("SUM row is not found still." );
				 }
			 }
		 }
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Sum calculated Element is not working properly.");
		}
	}

	// For Difference Calculation give string as
	// :-RowDifference/ColumnDifference
	public void DifferenceCalculationValidation(String ChooseRowColumnDifference)throws InterruptedException, NoSuchElementException
	{
		try 
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			 if(ChooseRowColumnDifference.equalsIgnoreCase("RowDifference"))
			 {
				 for(int i=0;i<ColumnHeadersList.size();i++)
				 {
					 if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DIFFERENCE"))
					 {
						 int countPass=0;
						 int countFail=0;
						 System.out.println("DIFFERENCE calculated element is added to the Column.");
						 Reporter.log("DIFFERENCE calculated element is added to the Column.");
						 System.out.println("DIFFERENCE calculation will perform upto "+i+" column.");
						 Reporter.log("DIFFERENCE calculation will perform upto "+i+" column.");
						 List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
						 for(int R=1;R<=RowValueCount.size();R++)
						 { 
							 ArrayList<Double> arrList=new ArrayList<Double>();
							 double Difference = 0.0;
							 String RoundedDifference = null;
							 double ResultDifference= 0.0;
							 String ActualDiffElementValue;
							 List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
							 for(int j=0;j<i;j++)
						     {
								String valuelength=RowElementList.get(j).getText();
								if(valuelength.length()==0)
							    {
									System.out.println("Cell "+j+" of "+R+" row having null value.");
							    }
							    else
							    {
							    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
							    }
							  }
							 if(!(arrList.size()==0))
							  {
								 for(int s=0;s<arrList.size();s++)
								 {
								   Difference -=arrList.get(s);
								   //RoundedDifference = (double) Math.round(Difference * 100) / 100;
								 }
								 BigDecimal BdDiff=new BigDecimal(Difference);
								 BdDiff = BdDiff.setScale(1, BigDecimal.ROUND_HALF_UP);
								 String StrDiff=BdDiff.toString();
								 RoundedDifference=StrDiff.substring(0,StrDiff.indexOf("."));
							  } 
							  else
							  {
								 System.out.println("There is no element in the row:-"+R);
							  }
							 for(int lr=0;lr<=i;lr++)
							 {
							   if(lr==i)
							   {
								  String LastRowValue=RowElementList.get(lr).getText();
								  String TextColr=RowElementList.get(lr).getCssValue("color");
								  if(LastRowValue.equals("#NV"))
								  {
									    countPass++;
										System.out.println("Full column is Empty.");
										Reporter.log("Full column is Empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									    countPass++;
									  	System.out.println("One Cell element value in the "+R+" row having zero value.");
									  	System.out.println("DIFFERENCE Value row "+R+" for One cell value is zero:-"+LastRowValue);
									  	Reporter.log("DIFFERENCE Value row "+R+" for One cell value is zero:-"+LastRowValue);
								  }
								else if(LastRowValue.length()==0)
								{
										System.out.println("Expected DIFFERENCE value in the "+R+" row is empty i.e having Null value.");
										Reporter.log("Expected DIFFERENCE value in the "+R+" row is empty i.e having Null value.");
								}
								//TextColr.equals("rgba(255, 0, 0, 1)")
								else
								{
									  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText());
									  Double ActualDiffValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDiff=new BigDecimal(ActualDiffValue);
									  BdDiff = BdDiff.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDiff=BdDiff.toString();
									  if(LastRowValue.startsWith("-"))
									  {
										  //pending===============
										  System.out.println("Number start with -ve symbol.");
										  ActualDiffElementValue=StrDiff.substring(0,StrDiff.indexOf("."));
									  }else
									  {
										  System.out.println("-ve Number start with () symbol.");
										  ActualDiffElementValue="-"+StrDiff.substring(0,StrDiff.indexOf("."));
									  }
									  //ActualDiffElementValue=StrDiff.substring(0,StrDiff.indexOf("."));
									  System.out.println("Actual Result for "+R+" row is:-"+ActualDiffElementValue);
									  System.out.println(ActualDiffElementValue+", "+RoundedDifference);
									  if(ActualDiffElementValue.equals(RoundedDifference))
									  {
										countPass++;
										System.out.println("Actual and expected result is same for "+R+" row.");
										Reporter.log("Actual and expected result is same for "+R+" row.");
									  }
									  else
									  {
										countFail++;
										System.out.println("Actual and expected result is not same for "+R+" row.");
									  	Reporter.log("Actual and expected result is not same for "+R+" row.");
									  }
								 }
							    }
							   }
							 Utils.waitForElement("");
							 arrList.clear();
							 System.out.println("loop "+R+" completed.");
							 Reporter.log("loop "+R+" completed.");
						 }
						 System.out.println("calculaion of DIFFERENCE for the table,passrows are:-"+countPass);
						 System.out.println("calculaion of DIFFERENCE for the table,Failrows are:-"+countFail);
						 Reporter.log("calculaion of DIFFERENCE for the table,passrows are:-"+countPass);
						 Reporter.log("calculaion of DIFFERENCE for the table,Failrows are:-"+countFail);
						 break;
					  }
					 else
					 {
						 System.out.println("DIFFERENCE Column is not found still." );
					 }
				 }
			 }
			 else if(ChooseRowColumnDifference.equalsIgnoreCase("ColumnDifference"))
			 {
				 for(int i=0;i<ColumnHeadersList.size();i++)
				 {
					 if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DIFFERENCE"))
					 {
						 int countPass=0;
						 int countFail=0;
						 System.out.println("DIFFERENCE calculated element is added to the row.");
						 Reporter.log("DIFFERENCE calculated element is added to the row.");
						 System.out.println("DIFFERENCE calculation will perform upto "+i+" row.");
						 Reporter.log("DIFFERENCE calculation will perform upto "+i+" row.");
						 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						 for(int C=1;C<=ColumnValueCount.size();C++)
						 { 
							 ArrayList<Double> arrList=new ArrayList<Double>();
							 double Difference = 0.0;
							 double RoundedDifference = 0.0;
							 double ResultDifference= 0.0;
							 Double ActualDifferenceElementValue= 0.0;
							 List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							 for(int j=0;j<i;j++)
						     {
								String valuelength=ColumnElementList.get(j).getText();
								if(valuelength.length()==0)
							    {
									System.out.println("Cell "+j+" of "+C+" row having null value.");
							    }
							    else
							    {
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
							    }
							  }
							 if(!(arrList.size()==0))
							  {
								 for(int s=0;s<arrList.size();s++)
								 {
								   Difference -=arrList.get(s);
								   RoundedDifference = (double) Math.round(Difference * 100) / 100;
								 }
							  } 
							  else
							  {
								 System.out.println("There is no element in the row:-"+C);
							  }
							 for(int lr=0;lr<=i;lr++)
							 {
							   if(lr==i)
							   {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									    countPass++;
										System.out.println("Full column is Empty.");
										Reporter.log("Full column is Empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									    countPass++;
									  	System.out.println("One Cell element value in the "+C+" row having zero value.");
									  	System.out.println("DIFFERENCE Value row "+C+" for One cell value is zero:-"+LastRowValue);
									  	Reporter.log("DIFFERENCE Value row "+C+" for One cell value is zero:-"+LastRowValue);
								  }
								else if(LastRowValue.length()==0)
								{
										System.out.println("Expected DIFFERENCE value in the "+C+" row is empty i.e having Null value.");
										Reporter.log("Expected DIFFERENCE value in the "+C+" row is empty i.e having Null value.");
								}
								else
								{
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
									  ActualDifferenceElementValue= Double.parseDouble(RowlastElement);
									  System.out.println("Actual Result for "+C+" row is:-"+ActualDifferenceElementValue);
									  if(ActualDifferenceElementValue.equals(RoundedDifference))
									  {
										countPass++;
										System.out.println("Actual and expected result is same for "+C+" row.");
										Reporter.log("Actual and expected result is same for "+C+" row.");
									  }
									  else
									  {
										countFail++;
										System.out.println("Actual and expected result is not same for "+C+" row.");
									  	Reporter.log("Actual and expected result is not same for "+C+" row.");
									  }
								 }
							    }
							   }
							 Utils.waitForElement("");
							 arrList.clear();
							 System.out.println("loop "+C+" completed.");
							 Reporter.log("loop "+C+" completed.");
						 }
						 System.out.println("calculaion of DIFFERENCE for the table,passColumns are:-"+countPass);
						 System.out.println("calculaion of DIFFERENCE for the table,FailColumns are:-"+countFail);
						 break;
					  }
					 else
					 {
						 System.out.println("DIFFERENCE row is not found still." );
					 }
				 }
			 }
		
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("DIFFERENCE calculated Element is not working properly.");
		}
	}

	public void CalculationMinimumValidation(String ChooseRowColumnMinimum) throws InterruptedException, NoSuchElementException 
	{
	  try
	  {
		  Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		  Utils.waitForElement("");
		  if(ChooseRowColumnMinimum.equalsIgnoreCase("RowMinimum"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++)
			 {
				 if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("MINIMUM"))
				 {
				   int countpass=0;
				   int countFail=0;
				   System.out.println("Minimum calculated element is added to the Column.");
				   Reporter.log("Minimum calculated element is added to the Column.");
				   System.out.println("minimum calculation will perform upto "+i+" column.");
				   Reporter.log("minimum calculation will perform upto "+i+" column.");
				   List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
				   
				   for(int R=1;R<=RowValueCount.size();R++)
				   { 
					   ArrayList<Double> arrList=new ArrayList<Double>();
					   String ActualRowlastElementValue;
					   String ExptMinimumValue = null;
					   List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
					   for(int j=0;j<i;j++)
					   {
						String valuelength=RowElementList.get(j).getText();
						if(valuelength.length()==0)
					    {
							System.out.println("Cell "+j+" of "+R+" row having null value.");
					    }
					    else
					    {
					    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
					    	double RowElement2 = Double.parseDouble(RowElement1);
					    	arrList.add(RowElement2);
					    }
					  }
					  if(!(arrList.size()==0))
					  {
					   Double MinVal=arrList.get(0);
					   for(int v=1;v<arrList.size();v++)
					   { 
						 if(arrList.get(v)<MinVal)
						  { 
							 MinVal=arrList.get(v); 
						  } 
					   } 
					  double MinimumValue=MinVal;
					  
					  BigDecimal BdMin=new BigDecimal(MinimumValue);
					  BdMin = BdMin.setScale(1, BigDecimal.ROUND_HALF_UP);
					  String StrMin=BdMin.toString();
					  ExptMinimumValue=StrMin.substring(0,StrMin.indexOf("."));
					  
					  System.out.println("Miminum value for "+R+" row is:-"+ ExptMinimumValue);
					  } 
					  else
					  {
						 System.out.println("There is no element in the row:-"+R);
					  }
					for(int lr=0;lr<=i;lr++)
					{
					 if(lr==i)
					  {
					    String LastRowValue=RowElementList.get(lr).getText();
						 if(LastRowValue.equals("#NV"))
						 {
							countpass++;
							System.out.println("Full column is Empty.");
							Reporter.log("Full column is Empty.");
						 }
						else if(LastRowValue.equals("€0.00"))
						{
						  countpass++;
						  System.out.println("One Cell element value in the "+R+" row having zero value.");
						  System.out.println("Minimum Value row "+R+" for One cell value is zero:-"+LastRowValue);
						  Reporter.log("Minimum Value row "+R+" for One cell value is zero:-"+LastRowValue);
						}
						else if(LastRowValue.length()==0)
						{
							System.out.println("Expected Minimum value in the "+R+" row is empty i.e having Null value.");
							Reporter.log("Expected Minimum value in the "+R+" row is empty i.e having Null value.");
						}
						else
						{
						  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText());
						  double ActElementValue= Double.parseDouble(RowlastElement);
						  
						  BigDecimal BdProXY2=new BigDecimal(ActElementValue);
						  BdProXY2 = BdProXY2.setScale(1, BigDecimal.ROUND_HALF_UP);
						  String StrProduct2=BdProXY2.toString();
						  ActualRowlastElementValue=StrProduct2.substring(0,StrProduct2.indexOf("."));
						  
						  System.out.println("Actual Result for "+R+" row is:-"+ActualRowlastElementValue);
						  if(ActualRowlastElementValue.equals(ExptMinimumValue))
						  {
							countpass++;
							System.out.println("Actual and expected result is same for "+R+" row.");
							Reporter.log("Actual and expected result is same for "+R+" row.");
						  }
						  else
						  {
							countFail++;
							System.out.println("Actual and expected result is not same for "+R+" row.");
						  	Reporter.log("Actual and expected result is not same for "+R+" row.");
						  }
						}
					  }
					} 
					Utils.waitForElement("");
					arrList.clear();
					System.out.println("loop "+R+" completed.");
					Reporter.log("loop "+R+" completed.");
				   }
				   System.out.println("calculaion of Minimum for the table,passrows are:-"+countpass);
				   System.out.println("calculaion of Minimum for the table,Failrows are:-"+countFail);
				   Reporter.log("calculaion of Minimum for the table,passrows are:-"+countpass);
				   Reporter.log("calculaion of Minimum for the table,Failrows are:-"+countFail);
				   Assert.assertEquals(countpass,RowHeadersList.size()-1);
				   break;
				 }
				 else
				 {
					 System.out.println("Minimum Column is not found still." );
				 }
			 }
		  }
		  else if(ChooseRowColumnMinimum.equalsIgnoreCase("ColumnMinimum"))
		  {
			  for(int i=0;i<RowHeadersList.size();i++)
				 {
				  int countpass=0;
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("MINIMUM"))
					 {
					   System.out.println("Minimum calculated element is added to the row.");
					   System.out.println("minimum calculation will perform upto "+i+" row.");
					   List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
					   
					   for(int C=1;C<=ColumnValueCount.size();C++)
					   { 
						   ArrayList<Double> arrListRow=new ArrayList<Double>();
						   String ActualRowlastElementValue;
						   String ExptMinimumValue = null;
						   List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
						   for(int j=0;j<i;j++)
						   {
							String valuelength=ColumnElementList.get(j).getText();
							if(valuelength.length()==0)
						    {
								System.out.println("Cell "+j+" of "+C+" row having null value.");
						    }
						    else
						    {
						    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
						    	double RowElement2 = Double.parseDouble(RowElement1);
						    	arrListRow.add(RowElement2);
						    }
						  }
						  if(!(arrListRow.size()==0))
						  {
						   Double MinVal=arrListRow.get(0);
						   for(int v=1;v<arrListRow.size();v++)
						   { 
							 if(arrListRow.get(v)<MinVal)
							  { 
								 MinVal=arrListRow.get(v); 
							  } 
						   } 
						  Double ExptMinimumVal=MinVal;
						  
						  BigDecimal BdAvg=new BigDecimal(ExptMinimumVal);
						  BdAvg = BdAvg.setScale(1, BigDecimal.ROUND_HALF_UP);
						  String StrAvg=BdAvg.toString();
						  ExptMinimumValue=StrAvg.substring(0,StrAvg.indexOf("."));
						  
						  System.out.println("Miminum value for "+C+" row is:-"+ ExptMinimumValue);
						  } 
						  else
						  {
							 System.out.println("There is no element in the row:-"+C);
						  }
						for(int lr=0;lr<=i;lr++)
						{
						 if(lr==i)
						  {
						    String LastRowValue=ColumnElementList.get(lr).getText();
							 if(LastRowValue.equals("#NV"))
							 {
								countpass++;
								System.out.println("Full column is Empty.");
							 }
							else if(LastRowValue.equals("€0.00"))
							{
							  countpass++;
							  System.out.println("One Cell element value in the "+C+" column having zero value.");
							  System.out.println("Minimum Value column "+C+" for One cell value is zero:-"+LastRowValue);
							}
							else if(LastRowValue.length()==0)
							{
								System.out.println("Expected Minimum value in the "+C+" column is empty i.e having Null value.");
							}
							else
							{
							  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
							  double ActualRowlastEleValue= Double.parseDouble(RowlastElement);
							  
							  BigDecimal BdProXY2=new BigDecimal(ActualRowlastEleValue);
							  BdProXY2 = BdProXY2.setScale(1, BigDecimal.ROUND_HALF_UP);
							  String StrProduct2=BdProXY2.toString();
							  ActualRowlastElementValue=StrProduct2.substring(0,StrProduct2.indexOf("."));
							  
							  System.out.println("Actual Result for "+C+" row is:-"+ActualRowlastElementValue);
							  if(ActualRowlastElementValue.equals(ExptMinimumValue))
							  {
								countpass++;
								System.out.println("Actual and expected result is same for "+C+" column.");
							  }
							  else
								System.out.println("Actual and expected result is not same for "+C+" column.");
							}
						  }
						} 
						Utils.waitForElement("");
						arrListRow.clear();
						System.out.println("loop "+C+" completed.");
					   }
					   System.out.println("calculaion of Minimum for the table,passrows are:-"+countpass);
					   Assert.assertEquals(countpass,ColumnHeadersList.size()-1);
					   break;
					 }
					 else
					 {
						 System.out.println("Minimum row is not found still." );
					 }
				 }
		  }
		   System.out.println("Minimum value calculation completed properly."); 
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
		  System.out.println("Minimum value calculation is not completed properly."); 
	  }
	}
	
	public void CalculationMaximumValidation(String ChooseRowColumnMaximum) throws InterruptedException, NoSuchElementException 
	{
		try
		{
		   Utils=new event.Utils(driver);
		   List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		   Utils.waitForElement("");
		   List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		   Utils.waitForElement("");
		   if(ChooseRowColumnMaximum.equalsIgnoreCase("RowMaximum"))
		   {
			 for(int i=0;i<ColumnHeadersList.size();i++)
		     {
			   if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("MAXIMUM"))
				{
				   int countPass=0;
				   int countFail=0;
				   System.out.println("Maximum calculated element is added to the Column.");
				   Reporter.log("Maximum calculated element is added to the Column.");
				   System.out.println("Maximum calculation will perform upto "+i+" column.");
				   Reporter.log("Maximum calculation will perform upto "+i+" column.");
				   List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
				   for(int R=1;R<=RowValueCount.size();R++)
				   {
					   ArrayList<Double> arrList=new ArrayList<Double>();
					   String ActualRowlastElementValue;
					   String ExptMaximumValue = null;
					   List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
					   for(int j=0;j<i;j++)
					   {
						String valuelength=RowElementList.get(j).getText();
						if(valuelength.length()==0)
					    {
							System.out.println("Cell "+j+" of "+R+" row having null value.");
					    }
					    else
					    {
					    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
					    	double RowElement2 = Double.parseDouble(RowElement1);
					    	arrList.add(RowElement2);
					    }
					  }
					 if(!(arrList.size()==0))
					 {
					   Double MaxVal=arrList.get(0);
					   for(int v=1;v<arrList.size();v++)
					   { 
						 if(arrList.get(v)>MaxVal)
						  { 
							 MaxVal=arrList.get(v); 
						  } 
					   } 
					  Double ExptMaximumValue1=MaxVal;
					  
					  BigDecimal BdMax=new BigDecimal(ExptMaximumValue1);
					  BdMax = BdMax.setScale(1, BigDecimal.ROUND_HALF_UP);
					  String StrMax=BdMax.toString();
					  ExptMaximumValue=StrMax.substring(0,StrMax.indexOf("."));
					  
					  System.out.println("Maximum value for "+R+" row is:-"+ ExptMaximumValue);
					 } 
				    else
				    {
					 System.out.println("There is no element in the row:-"+R);
					}
					for(int lr=0;lr<=i;lr++)
				    {
					 if(lr==i)
					  {
					    String LastRowValue=RowElementList.get(lr).getText();
						 if(LastRowValue.equals("#NV"))
						 {
							countPass++;
							System.out.println("Full column is Empty.");
							Reporter.log("Full column is Empty.");
						 }
						else if(LastRowValue.equals("€0.00"))
						{
						  countPass++;
						  System.out.println("One Cell element value in the "+R+" row having zero value.");
						  System.out.println("Maximum Value row "+R+" for One cell value is zero:-"+LastRowValue);
						  Reporter.log("Maximum Value row "+R+" for One cell value is zero:-"+LastRowValue);
						}
						else if(LastRowValue.length()==0)
						{
							System.out.println("Expected maximum value in the "+R+" row is empty i.e having Null value.");
							Reporter.log("Expected maximum value in the "+R+" row is empty i.e having Null value.");
						} 
						else
						{
						  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText());
						  Double ActRowlastElementVal= Double.parseDouble(RowlastElement);
						  
						  BigDecimal BdMax=new BigDecimal(ActRowlastElementVal);
						  BdMax = BdMax.setScale(1, BigDecimal.ROUND_HALF_UP);
						  String StrMax=BdMax.toString();
						  ActualRowlastElementValue=StrMax.substring(0,StrMax.indexOf("."));
						  
						  
						  System.out.println("Actual Result for "+R+" row is:-"+ActualRowlastElementValue);
						  if(ActualRowlastElementValue.equals(ExptMaximumValue))
						  {
							countPass++;
							System.out.println("Actual and expected result is same for "+R+" row.");
							Reporter.log("Actual and expected result is same for "+R+" row.");
						  }
						  else
						  {
							  countFail++;
							System.out.println("Actual and expected result is not same for "+R+" row.");
						  	Reporter.log("Actual and expected result is not same for "+R+" row.");
						  }
						}
					  }
					} 
					Utils.waitForElement("");
					arrList.clear();
					System.out.println("loop "+R+" completed.");
					Reporter.log("loop "+R+" completed.");
				   }
				   
				   System.out.println("calculaion of Maximum for the table,passrows are:-"+countPass);
				   System.out.println("calculaion of Maximum for the table,Failrows are:-"+countFail);
				   Reporter.log("calculaion of Maximum for the table,passrows are:-"+countPass);
				   Reporter.log("calculaion of Maximum for the table,Failrows are:-"+countFail);
				   Assert.assertEquals(countPass,RowHeadersList.size()-1);
				   break; 
			    }
			   else
			   {
				  System.out.println("Maximum Column is not found still." );
			   }
		     } 
		   }
		   else if(ChooseRowColumnMaximum.equalsIgnoreCase("ColumnMaximum"))
		   {
			   for(int i=0;i<RowHeadersList.size();i++)
				 {
				   int PassCount=0;
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("MAXIMUM"))
					 {
					   System.out.println("Maximum calculated element is added to the row.");
					   System.out.println("Maximum calculation will perform upto "+i+" row.");
					   List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
					   
					   for(int C=1;C<=ColumnValueCount.size();C++)
					   { 
						   ArrayList<Double> arrListRow=new ArrayList<Double>();
						   String ActualRowlastElementValue;
						   String ExptMaximumValue = null;
						   List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
						   for(int j=0;j<i;j++)
						   {
							String valuelength=ColumnElementList.get(j).getText();
							if(valuelength.length()==0)
						    {
								System.out.println("Cell "+j+" of "+C+" Column having null value.");
						    }
						    else
						    {
						    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
						    	double RowElement2 = Double.parseDouble(RowElement1);
						    	arrListRow.add(RowElement2);
						    }
						  }
						  if(!(arrListRow.size()==0))
						  {
						   Double MaxVal=arrListRow.get(0);
						   for(int v=1;v<arrListRow.size();v++)
						   { 
							 if(arrListRow.get(v)>MaxVal)
							  { 
								 MaxVal=arrListRow.get(v); 
							  } 
						   } 
						   double ExptMaximumValue1=MaxVal;
						   
						   BigDecimal BdMax=new BigDecimal(ExptMaximumValue1);
						   BdMax = BdMax.setScale(1, BigDecimal.ROUND_HALF_UP);
						   String StrMax=BdMax.toString();
						   ExptMaximumValue=StrMax.substring(0,StrMax.indexOf("."));
						   
						  System.out.println("Maximum value for "+C+" column is:-"+ ExptMaximumValue);
						  } 
						  else
						  {
							 System.out.println("There is no element in the Column:-"+C);
						  }
						for(int lr=0;lr<=i;lr++)
						{
						 if(lr==i)
						  {
						    String LastRowValue=ColumnElementList.get(lr).getText();
							 if(LastRowValue.equals("#NV"))
							 {
								PassCount++;
								System.out.println("Full column is Empty.");
							 }
							else if(LastRowValue.equals("€0.00"))
							{
						      PassCount++;
							  System.out.println("One Cell element value in the "+C+" column having zero value.");
							  System.out.println("Maximum Value column "+C+" for One cell value is zero:-"+LastRowValue);
							}
							else if(LastRowValue.length()==0)
							{
								System.out.println("Expected maximum value in the "+C+" column is empty i.e having Null value.");
							}
							else
							{
							  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
							  Double ActualRowlastElementValue1= Double.parseDouble(RowlastElement);
							  
							  BigDecimal BdMax=new BigDecimal(ActualRowlastElementValue1);
							  BdMax = BdMax.setScale(1, BigDecimal.ROUND_HALF_UP);
							  String StrMax=BdMax.toString();
							  ActualRowlastElementValue=StrMax.substring(0,StrMax.indexOf("."));
							  
							  System.out.println("Actual Result for "+C+" column is:-"+ActualRowlastElementValue);
							  if(ActualRowlastElementValue.equals(ExptMaximumValue))
							  {
								PassCount++;
								System.out.println("Actual and expected result is same for "+C+" column.");
							  }
							  else
								System.out.println("Actual and expected result is not same for "+C+" column.");
							}
						  }
						} 
						Utils.waitForElement("");
						arrListRow.clear();
						System.out.println("loop "+C+" completed.");
					   }
					   System.out.println("Pass Count for row calculation is:-"+PassCount);
					   Assert.assertEquals(PassCount,ColumnHeadersList.size()-1);
					   break;
					 }
					 else
					 {
						 System.out.println("Maximum Column is not found still." );
					 }
				 }  
		   }
		   System.out.println("Maximum value calculation is completed properly."); 
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			 System.out.println("Maximum value calculation is not completed properly."); 
		}
	}
	
	public void CalculationAverageValidation(String ChooseRowColumnAverage)throws InterruptedException, NoSuchElementException 
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnAverage.equalsIgnoreCase("RowAverage"))
			{
			 for(int i=0;i<ColumnHeadersList.size();i++)
			 { 
			   if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("AVERAGE")) 
			   {
				 int countPass=0;
				 int countFail=0;
				 System.out.println("Average calculated element is added to the Column.");
				 Reporter.log("Average calculated element is added to the Column.");
				 System.out.println("Average calculation will perform upto "+i+" column.");
				 Reporter.log("Average calculation will perform upto "+i+" column.");
				 List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
				 for(int R=1;R<=RowValueCount.size();R++)
				 {
					ArrayList<Double> arrList=new ArrayList<Double>();
					String ActualRowlastElementValue;
				    Double ExptAverageValue =0.0;
				    String RoundedAverage = null;
				    List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
				    for(int j=0;j<i;j++)
					{
				    	String valuelength=RowElementList.get(j).getText();
				    	if(valuelength.length()==0)
				    	{
				    		System.out.println("Cell "+j+" of "+R+" row having null value.");
				    	}
					    else
					    {
					    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
					    	double RowElement2 = Double.parseDouble(RowElement1);
					    	arrList.add(RowElement2);
					    }
					}
				    if(!(arrList.size()==0))
					{
				     Double AvgVal=0.0;
				     Double sum=0.0;
				     for(int v=0;v<arrList.size();v++)
				     { 
					   sum+=arrList.get(v);
				     } 
				     System.out.println("sum value for "+R+" row is:-"+ sum);
				     ExptAverageValue=sum/i;
				     //RoundedAverage = (double) Math.round(ExptAverageValue * 100) / 100;
				     
				     BigDecimal BdAvg=new BigDecimal(ExptAverageValue);
				     BdAvg = BdAvg.setScale(1, BigDecimal.ROUND_HALF_UP);
				     String StrAvg=BdAvg.toString();
				     RoundedAverage=StrAvg.substring(0,StrAvg.indexOf("."));
				     
				     //System.out.println("Average value for "+R+" row is:-"+ ExptAverageValue);
				     System.out.println("Average value for "+R+" row is:-"+ RoundedAverage);
					} 
				    else
				    {
					 System.out.println("There is no element in the row:-"+R);
					}
				    for(int lr=0;lr<=i;lr++)
				    {
					 if(lr==i)
					  {
					    String LastRowValue=RowElementList.get(lr).getText();
						 if(LastRowValue.equals("#NV"))
						 {
							 countPass++;
							System.out.println("Full column is Empty.");
							Reporter.log("Full column is Empty.");
						 }
						else if(LastRowValue.equals("€0.00"))
						{
							countPass++;
						  System.out.println("Average Value row "+R+" for One cell value is zero:-"+LastRowValue);
						  Reporter.log("Average Value row "+R+" for One cell value is zero:-"+LastRowValue);
						}
						else if(LastRowValue.length()==0)
						{
							System.out.println("Expected maximum value in the "+R+" row is empty i.e having Null value.");
							Reporter.log("Expected maximum value in the "+R+" row is empty i.e having Null value.");
						} 
						else
						{
						  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText());
						  Double ActAvgElementValue= Double.parseDouble(RowlastElement);
						  
						  BigDecimal BdProXY2=new BigDecimal(ActAvgElementValue);
						  BdProXY2 = BdProXY2.setScale(1, BigDecimal.ROUND_HALF_UP);
						  String StrProduct2=BdProXY2.toString();
						  ActualRowlastElementValue=StrProduct2.substring(0,StrProduct2.indexOf("."));
						  
						  System.out.println("Actual Result for "+R+" row is:-"+ActualRowlastElementValue);
						  if(ActualRowlastElementValue.equals(RoundedAverage))
						  {
							countPass++;
							System.out.println("Actual and expected result is same for "+R+" row.");
							Reporter.log("Actual and expected result is same for "+R+" row.");
						  }
						  else
						  {
							  countFail++;
							System.out.println("Actual and expected result is not same for "+R+" row.");
						  	Reporter.log("Actual and expected result is not same for "+R+" row.");
						  }
						}
					  }
					} 
				    Utils.waitForElement("");
				    arrList.clear();
					System.out.println("loop "+R+" completed.");
					Reporter.log("loop "+R+" completed.");
				 }
				 System.out.println("Average calculation for table rows completed properly.");
				 Reporter.log("Average calculation for table rows completed properly.");
				 System.out.println("calculaion of Average for the table,passrows are:-"+countPass);
				 System.out.println("calculaion of Average for the table,Failrows are:-"+countFail);
				 Reporter.log("calculaion of Average for the table,passrows are:-"+countPass);
				 Reporter.log("calculaion of Average for the table,Failrows are:-"+countFail);
				 Assert.assertEquals(countPass,RowHeadersList.size()-1);
				 break;
			   }
			   else
			   {
				  System.out.println("Average Column is not found still." );
			   }
			 }
			}
			else if(ChooseRowColumnAverage.equalsIgnoreCase("ColumnAverage"))
			{
			   for(int i=0;i<RowHeadersList.size();i++)
			    { 
				   int passCount=0;
				   if(RowHeadersList.get(i).getText().equalsIgnoreCase("AVERAGE")) 
				   {
					 System.out.println("Average calculated element is added to the row.");
					 System.out.println("Average calculation will perform upto "+i+" row.");
					 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
					 for(int C=1;C<=ColumnValueCount.size();C++)
					 {
						ArrayList<Double> arrList=new ArrayList<Double>();
						String ActualColumnlastElementValue;
					    Double ExptAverageValue =0.0;
					    String RoundedAverage = null;
						List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
					    for(int j=0;j<i;j++)
						{
					    	String valuelength=ColumnElementList.get(j).getText();
					    	if(valuelength.length()==0)
					    	{
					    		System.out.println("Cell "+j+" of "+C+" column having null value.");
					    	}
						    else
						    {
						    	String ColumnElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
						    	double ColumnElement2 = Double.parseDouble(ColumnElement1);
						    	arrList.add(ColumnElement2);
						    }
						}
					    if(!(arrList.size()==0))
						{
					     Double AvgVal=0.0;
					     Double sum=0.0;
					     for(int v=0;v<arrList.size();v++)
					     { 
						   sum+=arrList.get(v);
					     } 
					     System.out.println("sum value for "+C+" row is:-"+ sum);
					     ExptAverageValue=sum/i;
					     //RoundedAverage = (double) Math.round(ExptAverageValue * 100) / 100;
					     BigDecimal BdAvg=new BigDecimal(ExptAverageValue);
					     BdAvg = BdAvg.setScale(1, BigDecimal.ROUND_HALF_UP);
					     String StrAvg=BdAvg.toString();
					     RoundedAverage=StrAvg.substring(0,StrAvg.indexOf("."));
					    
					     System.out.println("Average value for "+C+" column is:-"+ RoundedAverage);
						} 
					    else
					    {
						 System.out.println("There is no element in the column:-"+C);
						}
					    for(int lr=0;lr<=i;lr++)
					    {
						 if(lr==i)
						  {
						    String LastRowValue=ColumnElementList.get(lr).getText();
							 if(LastRowValue.equals("#NV"))
							 {
								 passCount++;
								System.out.println("Full column is Empty.");
							 }
							else if(LastRowValue.equals("€0.00"))
							{
								passCount++;
							  System.out.println("Average Value row "+C+" for One cell value is zero:-"+LastRowValue);
							}
							else if(LastRowValue.length()==0)
							{
								System.out.println("Expected maximum value in the "+C+" row is empty i.e having Null value.");
							} 
							else
							{
							  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
							  Double ActAvgElementValue2= Double.parseDouble(RowlastElement);
							  
							  BigDecimal BdProXY2=new BigDecimal(ActAvgElementValue2);
							  BdProXY2 = BdProXY2.setScale(1, BigDecimal.ROUND_HALF_UP);
							  String StrProduct2=BdProXY2.toString();
							  ActualColumnlastElementValue=StrProduct2.substring(0,StrProduct2.indexOf("."));
							  
							  System.out.println("Actual Result for "+C+" row is:-"+ActualColumnlastElementValue);
							  if(ActualColumnlastElementValue.equals(RoundedAverage))
							  {
								  passCount++;
								System.out.println("Actual and expected result is same for "+C+" column.");
							  }
							  else
								System.out.println("Actual and expected result is not same for "+C+" column.");
							}
						  }
						} 
					    Utils.waitForElement("");
					    arrList.clear();
						System.out.println("loop "+C+" completed.");
					 }
					 System.out.println("calculaion of Minimum for the table,passcolumns are:-"+passCount);
					 Assert.assertEquals(passCount,ColumnHeadersList.size()-1);
					 
					 System.out.println("Average calculation for table column completed properly.");
					 Reporter.log("Average calculation for table column completed properly.");
					 //Assert.assertEquals(countPass,RowHeadersList.size()-1);
					 break;
				   }
				   else
				   {
					  System.out.println("Average row is not found still." );
				   }
				 }	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Average calculation is not completed properly.");
		}
	}

	public void CalculationProductValidation(String ChooseRowColumnProduct)throws InterruptedException, NoSuchElementException 
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnProduct.equalsIgnoreCase("RowProduct"))
			{
			 for(int i=0;i<ColumnHeadersList.size();i++)
			 { 
			   if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("PRODUCT")) 
			   {
				   int countPass=0;
				   int countFail=0;
				 System.out.println("Product calculated element is added to the Column.");
				 System.out.println("Product calculation will perform upto "+i+" column.");
				 List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
				 for(int R=1;R<=RowValueCount.size();R++)
				 {
					ArrayList<Double> arrList=new ArrayList<Double>();
					String ActualRowlastElementValue;
				    String ExptProductValue = null; 
				    Double RoundedAverage = null;
				    List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
				    for(int j=0;j<i;j++)
					{
				    	String valuelength=RowElementList.get(j).getText();
				    	if(valuelength.length()==0)
				    	{
				    		System.out.println("Cell "+j+" of "+R+" row having null value.");
				    		System.out.println("product value of "+R+" row having empty cell.so value is:-€0.00/#NV/Empty cell");
				    		Reporter.log("product value of "+R+" row having empty cell.so value is:-€0.00/#NV/Empty cell");
				    		break;
				    	}
					    else
					    {
					    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
					    	double RowElement2 = Double.parseDouble(RowElement1);
					    	arrList.add(RowElement2);
					    }
					}
				    if(!(arrList.size()==0))
					{
				    	Double MulVal =(double)1;
				    	for(int v=0;v<arrList.size();v++)
				    	{ 
				    	   MulVal*=arrList.get(v);
				    	} 
				    	//ExptProductValue=MulVal;
				    	BigDecimal BdProduct=new BigDecimal(MulVal);
				    	BdProduct = BdProduct.setScale(1, BigDecimal.ROUND_HALF_UP);
				    	String StrProduct=BdProduct.toString();
				    	ExptProductValue=StrProduct.substring(0,StrProduct.indexOf("."));	
				    	System.out.println("Product value for "+R+" row is:-"+ ExptProductValue);
					} 
				    else
				    {
				    	System.out.println("There is no element in the row:-"+R);
					}
				    for(int lr=0;lr<=i;lr++)
				    {
					 if(lr==i)
					  {
					    String LastRowValue=RowElementList.get(lr).getText();
						 if(LastRowValue.equals("#NV"))
						 {
							 countPass++;
							System.out.println("Full column is Empty.");
							Reporter.log("Full column is Empty.");
						 }
						else if(LastRowValue.equals("€0.00"))
						{
							countPass++;
						  System.out.println("Product Value row "+R+" for One cell value is zero:-"+LastRowValue);
						  Reporter.log("Product Value row "+R+" for One cell value is zero:-"+LastRowValue);
						}
						else if(LastRowValue.length()==0)
						{
							System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
							Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
						} 
						else
						{
						  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText());
						  Double RowProductVal= Double.parseDouble(RowlastElement);
						  
						  BigDecimal BdSum=new BigDecimal(RowProductVal);
						  BdSum = BdSum.setScale(1, BigDecimal.ROUND_HALF_UP);
						  String StrSum=BdSum.toString();
						  ActualRowlastElementValue=StrSum.substring(0,StrSum.indexOf("."));
						  
						  System.out.println("Actual Result for "+R+" row is:-"+ActualRowlastElementValue);
						  if(ActualRowlastElementValue==ExptProductValue)
						  {
							  countPass++;
							System.out.println("Actual and expected result is same for "+R+" row.");
							Reporter.log("Actual and expected result is same for "+R+" row.");
						  }
						  else
						  {
							  countFail++;
							System.out.println("Actual and expected result is not same for "+R+" row.");
						  	Reporter.log("Actual and expected result is not same for "+R+" row.");
						  }
						}
					  }
					} 
				    Utils.waitForElement("");
				    arrList.clear();
					System.out.println("loop "+R+" completed.");
					Reporter.log("loop "+R+" completed.");
				 }
				 System.out.println("Product calculation for table rows completed properly.");
				 Reporter.log("Product calculation for table rows completed properly.");
				 System.out.println("calculaion of Product for the table,passrows are:-"+countPass);
				 System.out.println("calculaion of Product for the table,Failrows are:-"+countFail);
				 Reporter.log("calculaion of Product for the table,passrows are:-"+countPass);
				 Reporter.log("calculaion of Product for the table,Failrows are:-"+countFail);
				 break;
			   }
			   else
			   {
				  System.out.println("Product Column is not found still." );
			   }
			 }
			}
			else if(ChooseRowColumnProduct.equalsIgnoreCase("ColumnProduct"))
			{
			  for(int i=0;i<RowHeadersList.size();i++)
			  { 
			    if(RowHeadersList.get(i).getText().equalsIgnoreCase("PRODUCT")) 
				 {
					 System.out.println("Product calculated element is added to the row.");
					 Reporter.log("Product calculated element is added to the row.");
					 System.out.println("Product calculation will perform upto "+i+" row.");
					 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));

					 for(int C=1;C<=ColumnValueCount.size();C++)
					 {
						ArrayList<Double> arrList=new ArrayList<Double>();
						String ActualColumnlastElementValue;
					    String ExptProductValue = null; 
					    //Double RoundedAverage = null;
						List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
					    for(int j=0;j<i;j++)
						{
					    	String valuelength=ColumnElementList.get(j).getText();
					    	if(valuelength.length()==0)
					    	{
					    		System.out.println("Cell "+j+" of "+C+" column having null value.");
					    		System.out.println("product value of "+C+" column having empty cell.so value is:-€0.00/#NV/Empty cell");
					    		Reporter.log("product value of "+C+" column having empty cell.so value is:-€0.00/#NV/Empty cell");
					    		break;
					    	}
						    else
						    {
						    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
						    	double RowElement2 = Double.parseDouble(RowElement1);
						    	arrList.add(RowElement2);
						    }
						}
					    if(!(arrList.size()==0))
						{
					    	Double MulVal =(double)1;
					    	for(int v=0;v<arrList.size();v++)
					    	{ 
					    	   MulVal*=arrList.get(v);
					    	} 
					    	BigDecimal BdProduct=new BigDecimal(MulVal);
					    	BdProduct = BdProduct.setScale(1, BigDecimal.ROUND_HALF_UP);
					    	String StrProduct=BdProduct.toString();
					    	ExptProductValue=StrProduct.substring(0,StrProduct.indexOf("."));
					    	
					    	System.out.println("Product value for "+C+" column is:-"+ ExptProductValue);
						} 
					    else
					    {
					    	System.out.println("There is no element in the column:-"+C);
						}
					    for(int lr=0;lr<=i;lr++)
					    {
						 if(lr==i)
						  {
						    String LastRowValue=ColumnElementList.get(lr).getText();
							 if(LastRowValue.equals("#NV"))
							 {
								System.out.println("Full column is Empty.");
								Reporter.log("Full column is Empty.");
							 }
							else if(LastRowValue.equals("€0.00"))
							{
							  System.out.println("Product Value column "+C+" for One cell value is zero:-"+LastRowValue);
							  Reporter.log("Product Value column "+C+" for One cell value is zero:-"+LastRowValue);
							}
							else if(LastRowValue.length()==0)
							{
								System.out.println("Expected Product value in the "+C+" column is empty i.e having Null value.");
								Reporter.log("Expected Product value in the "+C+" column is empty i.e having Null value.");
							} 
							else
							{
							  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
							  Double ColProductValue= Double.parseDouble(RowlastElement);
							  
							  BigDecimal BdSum=new BigDecimal(ColProductValue);
							  BdSum = BdSum.setScale(1, BigDecimal.ROUND_HALF_UP);
							  String StrSum=BdSum.toString();
							  ActualColumnlastElementValue=StrSum.substring(0,StrSum.indexOf("."));
							  
							  System.out.println("Actual Result for "+C+" row is:-"+ActualColumnlastElementValue);
							  if(ActualColumnlastElementValue==ExptProductValue)
							  {
								System.out.println("Actual and expected result is same for "+C+" column.");
								Reporter.log("Actual and expected result is same for "+C+" column.");
							  }
							  else
								System.out.println("Actual and expected result is not same for "+C+" column.");
							  	Reporter.log("Actual and expected result is not same for "+C+" column.");
							}
						  }
						} 
					    Utils.waitForElement("");
					    arrList.clear();
						System.out.println("loop "+C+" completed.");
						Reporter.log("loop "+C+" completed.");
					 }
					 System.out.println("Product calculation for table columns completed properly.");
					 Reporter.log("Product calculation for table columns completed properly.");
					 break;
				   }
				   else
				   {
					  System.out.println("Product Row is not found still." );
				   }
				 }
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Product calculation for table is not completed properly.");
		}
	}
	
	public void DeviationMinusXYValidation(String ChooseMinusRowColumnDeviationXY)throws InterruptedException, NoSuchElementException
	{
		try
		{
		  Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		  Utils.waitForElement("");
		  if(ChooseMinusRowColumnDeviationXY.equalsIgnoreCase("MinusRowDeviationXY"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION (X-Y)")) 
				  {
					int countPass=0;
					int countFail=0;
					System.out.println("Deviation (x-y calculated element is added to the Column.");
					System.out.println("Deviation (x-y) calculation will perform upto "+i+" column."); 
					Reporter.log("Deviation (x-y) calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationMinusXY;
						String ActDeviationMinusXY;
						String RoundedDeviationMinusXY;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						for(int j=0;j<i;j++)
						{
						   String valuelength=RowElementList.get(j).getText();
						   if(j==(i-2))
						   {
						    if(valuelength.length()==0) 
							 {
						    	System.out.println("Cell "+j+" of "+R+" row having null value.");
						    	DeviationX=0.0;
							 }
							else
							 { 
								String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
								DeviationX = Double.parseDouble(RowElement2);
							 }
						   }
						   else if(j==(i-1))
						   {
						    if(valuelength.length()==0) 
							 {
								 System.out.println("Cell "+j+" of "+R+" row having null value.");
								 DeviationY=0.0;
							 }
						    else
							 { 
						    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
						    	DeviationY = Double.parseDouble(RowElement1);
							 }
						   }
						  }
					    }
						double DeviationMinusXYValue=DeviationX-DeviationY;
						
						BigDecimal BdMax=new BigDecimal(DeviationMinusXYValue);
						BdMax = BdMax.setScale(1, BigDecimal.ROUND_HALF_UP);
						String StrMax=BdMax.toString();
						RoundedDeviationMinusXY=StrMax.substring(0,StrMax.indexOf("."));
						
						//RoundedDeviationMinusXY = (double) Math.round(ExptDeviationMinusXY * 100) / 100;
						System.out.println("Row "+R+" deviation(X-Y) value is: "+RoundedDeviationMinusXY);
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  countPass++;
								  System.out.println("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
								  Reporter.log("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {
								  countPass++;
								  System.out.println("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
								  Reporter.log("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else
							  {
								if(LastRowValue.contains("("))
								{
								  System.out.println("Value is more -ve.");
								  Reporter.log("Value is more -ve.");
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  Double NagativeNumber= Double.parseDouble(RowlastElement);
								  double ActDeviationMinusXYValue=-(NagativeNumber);
								  
								  BigDecimal BdDMXY=new BigDecimal(ActDeviationMinusXYValue);
								  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY=BdDMXY.toString();
								  ActDeviationMinusXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationMinusXY);
								}
								else
								{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  double ActDeviationMinusXYValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY=new BigDecimal(ActDeviationMinusXYValue);
								  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY=BdDMXY.toString();
								  ActDeviationMinusXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationMinusXY);
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationMinusXY.equals(ActDeviationMinusXY))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
						
						Utils.waitForElement("");
						System.out.println("loop "+R+" completed.");
						Reporter.log("loop "+R+" completed.");
					}
					System.out.println("Deviation(x-y) calculation for table rows completed properly.");
					Reporter.log("Deviation(x-y) calculation for table rows completed properly.");
					System.out.println("calculaion of Deviation(x-y) for the table,passcases are:-"+countPass);
					System.out.println("calculaion of Deviation(x-y) for the table,Failcases are:-"+countFail);
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					break;  
				  }
				  else
				  {
					  System.out.println("Deviation(x-y) Column is not found still." );
				  }
			 }
		  }
		  else if(ChooseMinusRowColumnDeviationXY.equalsIgnoreCase("MinusColumnDeviationXY"))
		  {
			 for(int i=0;i<RowHeadersList.size();i++) 
			 {
			   int countPass=0;
			   if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION (X-Y)")) 
			   {
				 System.out.println("Deviation (x-y calculated element is added to the row.");
				 System.out.println("Deviation (x-y) calculation will perform upto "+i+" row."); 
				 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
				 for(int C=1;C<=ColumnValueCount.size();C++)
				 {
					Double DeviationX = null;
					Double DeviationY = null;
					Double ExptDeviationMinusXY;
					String ActDeviationMinusXY;
					String RoundedDeviationMinusXY = null;
					ArrayList<Double> arrList=new ArrayList<Double>();
					List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
					if(i==0)
					{
				     System.out.println("No row elements are added to the Table.");
				     DeviationX=0.0;
				     DeviationY=0.0;
					}
					else
					{
					  for(int j=0;j<i;j++)
					  {
						 String valuelength=ColumnElementList.get(j).getText();
						 if(j==(i-2))
						 {
							if(valuelength.length()==0) 
							 {
							 	System.out.println("Cell "+j+" of "+C+" column having null value.");
						    	DeviationX=0.0;
							 }
							else
							 { 
								String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
								DeviationX = Double.parseDouble(RowElement2);
							 }
						 }
						 else if(j==(i-1))
						 {
						    if(valuelength.length()==0) 
							 {
								 System.out.println("Cell "+j+" of "+C+" column having null value.");
								 DeviationY=0.0;
							 }
						    else
							 { 
							String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
							DeviationY = Double.parseDouble(RowElement1);
							 }
						  }
					  }
					}
					ExptDeviationMinusXY=DeviationX-DeviationY;
					//RoundedDeviationMinusXY = (double) Math.round(ExptDeviationMinusXY * 100) / 100;
					BigDecimal BdDMXY=new BigDecimal(ExptDeviationMinusXY);
					BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
					String StrDMXY=BdDMXY.toString();
					RoundedDeviationMinusXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
					
					System.out.println("Column "+C+" deviation(X-Y) value is: "+RoundedDeviationMinusXY);
					for(int lr=0;lr<=i;lr++)
					{
					  if(lr==i)
					  {
						  String LastRowValue=ColumnElementList.get(lr).getText();
						  if(LastRowValue.equals("#NV"))
						  {
							  countPass++;
							  System.out.println("Last cell element for Deviation(X-Y) on the "+C+" column is empty.");
						  }
						  else if(LastRowValue.equals("€0.00"))
						  {
							  countPass++;
							  System.out.println("Last cell element for Deviation(X-Y) on the "+C+" column is empty.");
						  }
						  else if(LastRowValue.length()==0)
						  {
							  System.out.println("Expected Deviation(X-Y) value in the "+C+" column is empty i.e having Null value.");
						  } 
						  else
						  {
							  if(LastRowValue.contains("("))
								{
								  System.out.println("Value is more -ve.");
								  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
								  Double NagativeNumber= Double.parseDouble(RowlastElement);
								  double DeviationMinusXYValue=-(NagativeNumber);
								  
								  BigDecimal BdDMXY1=new BigDecimal(DeviationMinusXYValue);
								  BdDMXY1 = BdDMXY1.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY1=BdDMXY1.toString();
								  ActDeviationMinusXY=StrDMXY1.substring(0,StrDMXY1.indexOf("."));
								  
								  System.out.println("Actual Result for "+C+" column is: "+ActDeviationMinusXY);
								}
								else
								{
								  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
								  double DeviationMinusXYValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY1=new BigDecimal(DeviationMinusXYValue);
								  BdDMXY1 = BdDMXY1.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY11=BdDMXY1.toString();
								  ActDeviationMinusXY=StrDMXY11.substring(0,StrDMXY11.indexOf("."));
									
								  System.out.println("Actual Result for "+C+" column is: "+ActDeviationMinusXY);
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationMinusXY.equals(ActDeviationMinusXY))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+C+" column.");
								  }
								  else
								  {
									  System.out.println("Actual and expected result is not same for "+C+" column.");
								  }
							   }
						  }
					  }
					}
					Utils.waitForElement("");
					System.out.println("loop "+C+" completed."); 
				 }
				 System.out.println("Deviation(x-y) calculation for table columns completed properly.");
				 System.out.println("Deviation(x-y) calculation pass count is: "+countPass);
				 Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
				 break;
			   }
			 else
			 {
				 System.out.println("Deviation(x-y) row is not found still.");
			 }
			}
			  
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Deviation(x-y) calculation for table is not completed properly.");
		}
	}
	
	public void ProductXYValidation(String ChooseRowColumnProductXY)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnProductXY.equalsIgnoreCase("RowProductXY"))
			{
				for(int i=0;i<ColumnHeadersList.size();i++) 
				 {
					  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("PRODUCT (X*Y)")) 
					  {
						int countPass=0;
						int countFail=0; 
						System.out.println("Product(X*Y) calculated element is added to the Column.");
						System.out.println("Product(X*Y) calculation will perform upto "+i+" column."); 
						Reporter.log("Product(X*Y) calculation will perform upto "+i+" column."); 
						List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
						for(int R=1;R<=RowValueCount.size();R++)
						{
							Double ElementX = null;
							Double ElementY = null;
							String ExptProductXY;
							String ActProductXY = null;
							Double RoundedProductXY;
							List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
							if(i==0)
							{
						     System.out.println("No Column elements are added to the Table.");
						     Reporter.log("No Column elements are added to the Table.");
						     ElementX=0.0;
						     ElementY=0.0;
							}
							else
							{
							for(int j=0;j<i;j++)
							{
							   String valuelength=RowElementList.get(j).getText();
							   if(j==(i-2))
							   {
							    if(valuelength.length()==0) 
								 {
							    	System.out.println("Cell "+j+" of "+R+" row having null value.");
							    	ElementX=0.0;
								 }
								else
								 { 
									String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
									ElementX = Double.parseDouble(RowElement2);
								 }
							   }
							   else if(j==(i-1))
							   {
							    if(valuelength.length()==0) 
								 {
									 System.out.println("Cell "+j+" of "+R+" row having null value.");
									 ElementY=0.0;
								 }
							    else
								 { 
							    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
							    	ElementY = Double.parseDouble(RowElement1);
								 }
							   }
							  }
						    }
							Double ExptProductXYValue=ElementX*ElementY;
							
							BigDecimal BdProXY=new BigDecimal(ExptProductXYValue);
							BdProXY = BdProXY.setScale(1, BigDecimal.ROUND_HALF_UP);
							String StrProduct=BdProXY.toString();
							ExptProductXY=StrProduct.substring(0,StrProduct.indexOf("."));
							
							//RoundedProductXY = (double) Math.round(ExptProductXY * 100) / 100;
							System.out.println("Row "+R+" Product(X*Y) value is: "+ExptProductXY);
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=RowElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for Product(X*Y) on the "+R+" row is empty.");
									  Reporter.log("Last cell element for Product(X*Y) on the "+R+" row is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for Product(X*Y) on the "+R+" row is empty.");
									  Reporter.log("Last cell element for Product(X*Y) on the "+R+" row is empty.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  System.out.println("Expected Product(X*Y) value in the "+R+" row is empty i.e having Null value.");
									  Reporter.log("Expected Product(X*Y) value in the "+R+" row is empty i.e having Null value.");
								  } 
								  else
								  {
									  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
									  Double ActProductXYValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdProXY2=new BigDecimal(ActProductXYValue);
									  BdProXY2 = BdProXY2.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrProduct2=BdProXY2.toString();
									  ActProductXY=StrProduct2.substring(0,StrProduct2.indexOf("."));
									  
									  System.out.println("Actual Result for "+R+" row is: "+ActProductXY);
									  if(ExptProductXY.equals(ActProductXY))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+R+" row.");
										  Reporter.log("Actual and expected result is same for "+R+" row.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+R+" row.");
										  Reporter.log("Actual and expected result is not same for "+R+" row.");
									  }
								  }
								 }
							  }
							Utils.waitForElement("");
							System.out.println("loop "+R+" completed.");
							Reporter.log("loop "+R+" completed.");
						   }
						System.out.println("Product(X*Y) calculation for table rows completed properly.");
						Reporter.log("Product(X*Y) calculation for table rows completed properly.");
						System.out.println("calculaion of Product(X*Y) for the table,passCases are:-"+countPass);
						System.out.println("calculaion of Product(X*Y) for the table,FailCases are:-"+countFail);
						break;  
					  }
					  else
					  {
						  System.out.println("Product(X*Y) Column is not found still." );
					  }
				 }	
				
			}
			else if(ChooseRowColumnProductXY.equalsIgnoreCase("ColumnProductXY"))
			{
				for(int i=0;i<RowHeadersList.size();i++) 
				 {
					  if(RowHeadersList.get(i).getText().equalsIgnoreCase("PRODUCT (X*Y)")) 
					  {
						System.out.println("Product(X*Y) calculated element is added to the row.");
						System.out.println("Product(X*Y) calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));

						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double ElementX = null;
							Double ElementY = null;
							String ExptProductXY;
							String ActProductXY = null;
							Double RoundedProductXY;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     ElementX=0.0;
						     ElementY=0.0;
							}
							else
							{
							for(int j=0;j<i;j++)
							{
							   String valuelength=ColumnElementList.get(j).getText();
							   if(j==(i-2))
							   {
							    if(valuelength.length()==0) 
								 {
							    	System.out.println("Cell "+j+" of "+C+" column having null value.");
							    	ElementX=0.0;
								 }
								else
								 { 
									String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
									ElementX = Double.parseDouble(RowElement2);
								 }
							   }
							   else if(j==(i-1))
							   {
							    if(valuelength.length()==0) 
								 {
									 System.out.println("Cell "+j+" of "+C+" column having null value.");
									 ElementY=0.0;
								 }
							    else
								 { 
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
							    	ElementY = Double.parseDouble(RowElement1);
								 }
							   }
							  }
						    }
							Double ExptProductXYValue=ElementX*ElementY;
							
							BigDecimal BdProXY=new BigDecimal(ExptProductXYValue);
							BdProXY = BdProXY.setScale(1, BigDecimal.ROUND_HALF_UP);
							String StrProduct=BdProXY.toString();
							ExptProductXY=StrProduct.substring(0,StrProduct.indexOf("."));
							
							//RoundedProductXY = (double) Math.round(ExptProductXY * 100) / 100;
							System.out.println("Row "+C+" Product(X*Y) value is: "+ExptProductXY);
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  System.out.println("Last cell element for Product(X*Y) on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  System.out.println("Last cell element for Product(X*Y) on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  System.out.println("Expected Product(X*Y) value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else
								  {
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  Double ActProductXYvALUE= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdProXY2=new BigDecimal(ActProductXYvALUE);
									  BdProXY2 = BdProXY2.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrProduct2=BdProXY2.toString();
									  ActProductXY=StrProduct2.substring(0,StrProduct2.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActProductXY);
									  if(ExptProductXY.equals(ActProductXY))
									  {
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								  }
								 }
							  }
							Utils.waitForElement("");
							System.out.println("loop "+C+" completed.");
						   }
						System.out.println("Product(X*Y) calculation for table columns completed properly.");
						break;  
					  }
					  else
					  {
						  System.out.println("Product(X*Y) row is not found still." );
					  }
				 }		
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Product(X*Y) calculation for table is not completed properly.");
		}
	}
	public void DeviationMinusYXValidation(String ChooseMinusRowColumnDeviationYX)
	{
		try
		{
			Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		  Utils.waitForElement("");
		  if(ChooseMinusRowColumnDeviationYX.equalsIgnoreCase("MinusRowDeviationYX"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION (Y-X)")) 
				  {
					int countPass=0;
					int countFail=0;
					System.out.println("Deviation (y-x) calculated element is added to the Column.");
					System.out.println("Deviation (y-x) calculation will perform upto "+i+" column."); 
					Reporter.log("Deviation (y-x) calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationMinusYX;
						String ActDeviationMinusYX;
						String RoundedDeviationMinusYX;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						for(int j=0;j<i;j++)
						{
						   String valuelength=RowElementList.get(j).getText();
						   if(j==(i-2))
						   {
						    if(valuelength.length()==0) 
							 {
						    	System.out.println("Cell "+j+" of "+R+" row having null value.");
						    	DeviationX=0.0;
							 }
							else
							 { 
								String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
								DeviationX = Double.parseDouble(RowElement2);
							 }
						   }
						   else if(j==(i-1))
						   {
						    if(valuelength.length()==0) 
							 {
								 System.out.println("Cell "+j+" of "+R+" row having null value.");
								 DeviationY=0.0;
							 }
						    else
							 { 
						    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
						    	DeviationY = Double.parseDouble(RowElement1);
							 }
						   }
						  }
					    }
						ExptDeviationMinusYX=DeviationY-DeviationX;
						
						BigDecimal BdDMXY=new BigDecimal(ExptDeviationMinusYX);
						BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
						String StrDMXY=BdDMXY.toString();
						RoundedDeviationMinusYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
						
						//RoundedDeviationMinusYX = (double) Math.round(ExptDeviationMinusYX * 100) / 100;
						System.out.println("Row "+R+" deviation(y-x) value is: "+RoundedDeviationMinusYX);
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  countPass++;
								  System.out.println("Last cell element for Deviation(y-x) on the "+R+" row is empty.");
								  Reporter.log("Last cell element for Deviation(y-x) on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {
								  countPass++;
								  System.out.println("Last cell element for Deviation(y-x) on the "+R+" row is empty.");
								  Reporter.log("Last cell element for Deviation(y-x) on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else
							  {
								if(LastRowValue.contains("("))
								{
								  System.out.println("Value is more -ve.");
								  Reporter.log("Value is more -ve.");
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  Double NagativeNumber= Double.parseDouble(RowlastElement);
								  Double ActDeviationMinusYXValue=-(NagativeNumber);
								  
								  BigDecimal BdDMXY1=new BigDecimal(ActDeviationMinusYXValue);
								  BdDMXY1 = BdDMXY1.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY1=BdDMXY1.toString();
								  ActDeviationMinusYX=StrDMXY1.substring(0,StrDMXY1.indexOf("."));
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationMinusYX);
								}
								else
								{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  double ActDeviationMinusYXValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY1=new BigDecimal(ActDeviationMinusYXValue);
								  BdDMXY1 = BdDMXY1.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY1=BdDMXY1.toString();
								  ActDeviationMinusYX=StrDMXY1.substring(0,StrDMXY1.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationMinusYX);
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationMinusYX.equals(ActDeviationMinusYX))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
						
						Utils.waitForElement("");
						System.out.println("loop "+R+" completed.");
						Reporter.log("loop "+R+" completed.");
					}
					System.out.println("Deviation(y-x) calculation for table rows completed properly.");
					Reporter.log("Deviation(y-x) calculation for table rows completed properly.");
					System.out.println("calculaion of Deviation(y-x) for the table,passColumns are:-"+countPass);
					System.out.println("calculaion of Deviation(y-x) for the table,FailColumns are:-"+countFail);
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					break;  
				  }
				  else
				  {
					  System.out.println("Deviation(y-x) Column is not found still." );
				  }
			 }
		  }
		  else if(ChooseMinusRowColumnDeviationYX.equalsIgnoreCase("MinusColumnDeviationYX"))
		  {
			 for(int i=0;i<RowHeadersList.size();i++) 
			 {
			   int countPass=0;
			   if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION (Y-X)")) 
			   {
				 System.out.println("Deviation (y-x) calculated element is added to the row.");
				 System.out.println("Deviation (y-x) calculation will perform upto "+i+" row."); 
				 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
				 for(int C=1;C<=ColumnValueCount.size();C++)
				 {
					Double DeviationX = null;
					Double DeviationY = null;
					Double ExptDeviationMinusYX;
					String ActDeviationMinusYX;
					String RoundedDeviationMinusYX = null;
					ArrayList<Double> arrList=new ArrayList<Double>();
					List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
					if(i==0)
					{
				     System.out.println("No row elements are added to the Table.");
				     DeviationX=0.0;
				     DeviationY=0.0;
					}
					else
					{
					  for(int j=0;j<i;j++)
					  {
						 String valuelength=ColumnElementList.get(j).getText();
						 if(j==(i-2))
						 {
							if(valuelength.length()==0) 
							 {
							 	System.out.println("Cell "+j+" of "+C+" column having null value.");
						    	DeviationX=0.0;
							 }
							else
							 { 
								String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
								DeviationX = Double.parseDouble(RowElement2);
							 }
						 }
						 else if(j==(i-1))
						 {
						    if(valuelength.length()==0) 
							 {
								 System.out.println("Cell "+j+" of "+C+" column having null value.");
								 DeviationY=0.0;
							 }
						    else
							 { 
							String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
							DeviationY = Double.parseDouble(RowElement1);
							 }
						  }
					  }
					}
					ExptDeviationMinusYX=DeviationY-DeviationX;
					
					BigDecimal BdDMXY1=new BigDecimal(ExptDeviationMinusYX);
					BdDMXY1 = BdDMXY1.setScale(1, BigDecimal.ROUND_HALF_UP);
					String StrDMXY1=BdDMXY1.toString();
					RoundedDeviationMinusYX=StrDMXY1.substring(0,StrDMXY1.indexOf("."));
					
					//RoundedDeviationMinusYX = (double) Math.round(ExptDeviationMinusYX * 100) / 100;
					System.out.println("Column "+C+" deviation(y-x) value is: "+RoundedDeviationMinusYX);
					for(int lr=0;lr<=i;lr++)
					{
					  if(lr==i)
					  {
						  String LastRowValue=ColumnElementList.get(lr).getText();
						  if(LastRowValue.equals("#NV"))
						  {
							  countPass++;
							  System.out.println("Last cell element for Deviation(y-x) on the "+C+" column is empty.");
						  }
						  else if(LastRowValue.equals("€0.00"))
						  {
							  countPass++;
							  System.out.println("Last cell element for Deviation(y-x) on the "+C+" column is empty.");
						  }
						  else if(LastRowValue.length()==0)
						  {
							  System.out.println("Expected Deviation(y-x) value in the "+C+" column is empty i.e having Null value.");
						  } 
						  else
						  {
							  if(LastRowValue.contains("("))
								{
								  System.out.println("Value is more -ve.");
								  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
								  Double NagativeNumber= Double.parseDouble(RowlastElement);
								  Double ActDeviationMinusYXValue=-(NagativeNumber);
								  
								  BigDecimal BdDMXY11=new BigDecimal(ActDeviationMinusYXValue);
								  BdDMXY11 = BdDMXY11.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY11=BdDMXY11.toString();
								  ActDeviationMinusYX=StrDMXY11.substring(0,StrDMXY11.indexOf("."));
								  
								  System.out.println("Actual Result for "+C+" column is: "+ActDeviationMinusYX);
								}
								else
								{
								  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
								  double ActDeviationMinusYXValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY11=new BigDecimal(ActDeviationMinusYXValue);
								  BdDMXY11 = BdDMXY11.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY11=BdDMXY11.toString();
								  ActDeviationMinusYX=StrDMXY11.substring(0,StrDMXY11.indexOf("."));
								  
								  System.out.println("Actual Result for "+C+" column is: "+ActDeviationMinusYX);
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationMinusYX.equals(ActDeviationMinusYX))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+C+" column.");
								  }
								  else
								  {
									  System.out.println("Actual and expected result is not same for "+C+" column.");
								  }
							   }
						  }
					  }
					}
					Utils.waitForElement("");
					System.out.println("loop "+C+" completed."); 
				 }
				 System.out.println("Deviation(y-x) calculation for table columns completed properly.");
				 System.out.println("Count for Deviation(y-x) is"+countPass);
				 Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
				 break;
			   }
			 else
			 {
				 System.out.println("Deviation(y-x) row is not found still.");
			 }
			}
			  
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Deviation(y-x) calculation for table is not completed properly.");
		}
	}
 	public void DeviationPercentageXYValidation(String ChoosePercentageRowColumnDeviationXY)
	{
		try
		{
			Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		  Utils.waitForElement("");
		  if(ChoosePercentageRowColumnDeviationXY.equalsIgnoreCase("PercentageRowDeviationXY"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (X-Y)/Y")) 
				  {
					int countPass=0;
					int countFail=0;  
					System.out.println("DEVIATION % (X-Y)/Y calculated element is added to the Column.");
					System.out.println("DEVIATION % (X-Y)/Y calculation will perform upto "+i+" column."); 
					Reporter.log("DEVIATION % (X-Y)/Y calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationPercentageXY;
						String ActDeviationPercentageXY = null;
						String RoundedDeviationPercentageXY = null;
						String InvalidZeroYPercentage = null;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						  for(int j=0;j<i;j++)
							{
								String valuelength=RowElementList.get(j).getText();
								if(j==(i-2))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationX=0.0;
									}
									else
									{ 
										String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationX = Double.parseDouble(RowElement2);
									}
								}
								else if(j==(i-1))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationY=0.0;
									}
									else
									{ 
										String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationY = Double.parseDouble(RowElement1);
									}
								}
							}
						}
						for(int p=0;p<1;p++)
						{
							if(DeviationY==0.0)
							{
								InvalidZeroYPercentage="100.00 %";
							}
							else
							{
								Double BFDeviationPercentageXY=(DeviationX-DeviationY)/DeviationY;
								System.out.println(BFDeviationPercentageXY);
								//Double BFDeviationPercentageXY1 = (double) Math.round(BFDeviationPercentageXY * 100) / 100;
								//System.out.println(BFDeviationPercentageXY1);
								ExptDeviationPercentageXY=BFDeviationPercentageXY*100;
								System.out.println(ExptDeviationPercentageXY);
								
								BigDecimal BdDPXY=new BigDecimal(ExptDeviationPercentageXY);
								BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								String StrDPXY=BdDPXY.toString();
								RoundedDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
								
								//RoundedDeviationPercentageXY = (double) Math.round(ExptDeviationPercentageXY * 100) / 100;
								System.out.println("Row "+R+" DEVIATION % (X-Y)/Y  value is: "+RoundedDeviationPercentageXY);
							}
						}
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else if(LastRowValue.equals("100.00 %"))
							  {
								  System.out.println("Deviation-Y value is Zero.");
								  Reporter.log("Deviation-Y value is Zero.");
								  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroYPercentage);
								  if(PercentageDeviationValue)
								  {
								   countPass++;
								   System.out.println("Value of Percentage Deviation Value for "+R+ "is:-"+PercentageDeviationValue);
								  }
								  else
								  {
									countFail++;
									System.out.println("Value of Percentage Deviation Value for "+R+ "is:-False");
								  }
							  }
							  else
							  {
								if(LastRowValue.contains("%"))
								{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  double ActDPXYValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDPXY=new BigDecimal(ActDPXYValue);
								  BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDPXY=BdDPXY.toString();
								  ActDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationPercentageXY);
								}
								else
								{
									System.out.println("This is not a percentage Value.");
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationPercentageXY.equals(ActDeviationPercentageXY))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
					   Utils.waitForElement("");
					   System.out.println("loop "+R+" completed.");	
					   Reporter.log("loop "+R+" completed.");	
					 }
					System.out.println("DEVIATION % (X-Y)/Y  calculation for table rows completed properly.");
					Reporter.log("DEVIATION % (X-Y)/Y  calculation for table rows completed properly.");
					System.out.println("calculaion of DEVIATION % (X-Y)/Y for the table,passRows are:-"+countPass);
					System.out.println("calculaion of DEVIATION % (X-Y)/Y for the table,FailRows are:-"+countFail);
					
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					break;  
				  }
				  else
				  {
					  System.out.println("DEVIATION % (X-Y)/Y Column is not found still." );
				  }
			 }
		  }
		  else if(ChoosePercentageRowColumnDeviationXY.equalsIgnoreCase("PercentageColumnDeviationXY"))
		  {
			  for(int i=0;i<RowHeadersList.size();i++) 
				 {
				  int countpass=0;
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (X-Y)/Y")) 
					  {
						System.out.println("DEVIATION % (X-Y)/Y calculated element is added to the row.");
						System.out.println("DEVIATION % (X-Y)/Y calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double DeviationX = null;
							Double DeviationY = null;
							Double ExptDeviationPercentageXY;
							String ActDeviationPercentageXY = null;
							String RoundedDeviationPercentageXY = null;
							String InvalidZeroYPercentage = null;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     DeviationX=0.0;
						     DeviationY=0.0;
							}
							else
							{
							  for(int j=0;j<i;j++)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(j==(i-2))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationX=0.0;
										}
										else
										{ 
											String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationX = Double.parseDouble(RowElement2);
										}
									}
									else if(j==(i-1))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationY=0.0;
										}
										else
										{ 
											String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationY = Double.parseDouble(RowElement1);
										}
									}
								}
							}
							for(int p=0;p<1;p++)
							{
								if(DeviationY==0.0)
								{
									InvalidZeroYPercentage="100.00 %";
								}
								else
								{
									Double BFDeviationPercentageXY=(DeviationX-DeviationY)/DeviationY;
									System.out.println(BFDeviationPercentageXY);
									ExptDeviationPercentageXY=BFDeviationPercentageXY*100;
									System.out.println(ExptDeviationPercentageXY);
									
									BigDecimal BdDPXY=new BigDecimal(ExptDeviationPercentageXY);
									BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDPXY=BdDPXY.toString();
									RoundedDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
									
									//RoundedDeviationPercentageXY = (double) Math.round(ExptDeviationPercentageXY * 100) / 100;
									System.out.println("Row "+C+" DEVIATION % (X-Y)/Y  value is: "+RoundedDeviationPercentageXY);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countpass++;
									  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countpass++;
									  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  System.out.println("Expected Product value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else if(LastRowValue.equals("100.00 %"))
								  {
									  System.out.println("Deviation-Y value is Zero.");
									  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroYPercentage);
									  if(PercentageDeviationValue)
									  {
										  countpass++;
									   System.out.println("Value of Percentage Deviation Value for "+C+ "is:-"+PercentageDeviationValue);
									  }
									  else
									  {
										System.out.println("Value of Percentage Deviation Value for "+C+ "is:-False");
									  }
								  }
								  else
								  {
									if(LastRowValue.contains("%"))
									{
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  double ActDeviationPercentageXYValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDPXY=new BigDecimal(ActDeviationPercentageXYValue);
									  BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDPXY=BdDPXY.toString();
									  ActDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActDeviationPercentageXY);
									}
									else
									{
										System.out.println("This is not a percentage Value.");
									}
								   for(int d=0;d<1;d++)
								   {
									  if(RoundedDeviationPercentageXY.equals(ActDeviationPercentageXY))
									  {
										  countpass++;
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								   }
								 }
							  }
							}
						   Utils.waitForElement("");
						   System.out.println("loop "+C+" completed.");	
						 }
						System.out.println("DEVIATION % (X-Y)/Y  calculation for table columns completed properly.");
						System.out.println("count for DEVIATION % (X-Y)/Y is "+countpass);
						Assert.assertEquals(countpass,ColumnHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("DEVIATION % (X-Y)/Y row is not found still." );
					  }
				 }
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("DEVIATION % (X-Y)/Y calculation for table is not completed properly.");
		}
	}
	public void DeviationPercentageYXValidation(String ChoosePercentageRowColumnDeviationYX)
	{
		try
		{
			Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		  Utils.waitForElement("");
		  if(ChoosePercentageRowColumnDeviationYX.equalsIgnoreCase("PercentageRowDeviationYX"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (Y-X)/X")) 
				  {
					int countPass=0;
					int countFail=0;
					System.out.println("DEVIATION % (Y-X)/X calculated element is added to the Column.");
					System.out.println("DEVIATION % (Y-X)/X calculation will perform upto "+i+" column.");
					Reporter.log("DEVIATION % (Y-X)/X calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{	
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationPercentageYX;
						String ActDeviationPercentageYX = null;
						String RoundedDeviationPercentageYX = null;
						String InvalidZeroYPercentage = null;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						  for(int j=0;j<i;j++)
							{
								String valuelength=RowElementList.get(j).getText();
								if(j==(i-2))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationX=0.0;
									}
									else
									{ 
										String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationX = Double.parseDouble(RowElement2);
									}
								}
								else if(j==(i-1))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationY=0.0;
									}
									else
									{ 
										String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationY = Double.parseDouble(RowElement1);
									}
								}
							}
						}
						for(int p=0;p<1;p++)
						{
							if(DeviationX==0.0)
							{
								InvalidZeroYPercentage="100.00 %";
							}
							else
							{
								Double BFDeviationPercentageYX=(DeviationY-DeviationX)/DeviationX;
								//System.out.println(BFDeviationPercentageYX);
								//Double BFDeviationPercentageXY1 = (double) Math.round(BFDeviationPercentageXY * 100) / 100;
								//System.out.println(BFDeviationPercentageXY1);
								ExptDeviationPercentageYX=BFDeviationPercentageYX*100;
								//System.out.println(ExptDeviationPercentageYX);
								
								BigDecimal BdDMXY=new BigDecimal(ExptDeviationPercentageYX);
								BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								String StrDMXY=BdDMXY.toString();
								RoundedDeviationPercentageYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
								
								//RoundedDeviationPercentageYX = (double) Math.round(ExptDeviationPercentageYX * 100) / 100;
								System.out.println("Row "+R+" DEVIATION % (Y-X)/X  value is: "+RoundedDeviationPercentageYX);
							}
						}
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (Y-X)/X  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (Y-X)/X  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (Y-X)/X  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (Y-X)/X  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  countPass++;
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else if(LastRowValue.equals("100.00 %"))
							  {
								  System.out.println("Deviation-X value is Zero.");
								  Reporter.log("Deviation-X value is Zero.");
								  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroYPercentage);
								  if(PercentageDeviationValue)
								  {
								   countPass++;
								   System.out.println("Value of Percentage Deviation Value for "+R+ "is:-"+PercentageDeviationValue);
								  }
								  else
								  {
									countFail++;  
									System.out.println("Value of Percentage Deviation Value for "+R+ "is:-False");
								  }
							  }
							  else
							  {
								if(LastRowValue.contains("%"))
								{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  Double ActDeviationPercentageYXValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY=new BigDecimal(ActDeviationPercentageYXValue);
								  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY=BdDMXY.toString();
								  ActDeviationPercentageYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationPercentageYX);
								}
								else
								{
									System.out.println("This is not a percentage Value.");
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationPercentageYX.equals(ActDeviationPercentageYX))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
					   Utils.waitForElement("");
					   System.out.println("loop "+R+" completed.");	
					   Reporter.log("loop "+R+" completed.");	
					 }
					System.out.println("DEVIATION % (Y-X)/X  calculation for table rows completed properly.");
					Reporter.log("DEVIATION % (Y-X)/X  calculation for table rows completed properly.");
					System.out.println("calculaion of DEVIATION % (Y-X)/X for the table,passRows are:-"+countPass);
					System.out.println("calculaion of DEVIATION % (Y-X)/X for the table,FailRows are:-"+countFail);
					Reporter.log("calculaion of DEVIATION % (Y-X)/X for the table,passRows are:-"+countPass);
					Reporter.log("calculaion of DEVIATION % (Y-X)/X for the table,FailRows are:-"+countFail);
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					
					break;  
				  }
				  else
				  {
					  System.out.println("DEVIATION % (Y-X)/X Column is not found still." );
				  }
			 }
		  }
		  else if(ChoosePercentageRowColumnDeviationYX.equalsIgnoreCase("PercentageColumnDeviationYX"))
		  {
			  for(int i=0;i<RowHeadersList.size();i++) 
				 {
				  int CountPass=0;
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (Y-X)/X")) 
					  {
						int countPass=0;
						int countFail=0;
						System.out.println("DEVIATION % (Y-X)/X calculated element is added to the row.");
						System.out.println("DEVIATION % (Y-X)/X calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double DeviationX = null;
							Double DeviationY = null;
							Double ExptDeviationPercentageYX;
							String ActDeviationPercentageYX = null;
							String RoundedDeviationPercentageYX = null;
							String InvalidZeroYPercentage = null;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     DeviationX=0.0;
						     DeviationY=0.0;
							}
							else
							{
							  for(int j=0;j<i;j++)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(j==(i-2))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationX=0.0;
										}
										else
										{ 
											String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationX = Double.parseDouble(RowElement2);
										}
									}
									else if(j==(i-1))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationY=0.0;
										}
										else
										{ 
											String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationY = Double.parseDouble(RowElement1);
										}
									}
								}
							}
							for(int p=0;p<1;p++)
							{
								if(DeviationX==0.0)
								{
									InvalidZeroYPercentage="100.00 %";
								}
								else
								{
									Double BFDeviationPercentageYX=(DeviationY-DeviationX)/DeviationX;
									System.out.println(BFDeviationPercentageYX);
									ExptDeviationPercentageYX=BFDeviationPercentageYX*100;
									System.out.println(ExptDeviationPercentageYX);
									
									BigDecimal BdDMXY=new BigDecimal(ExptDeviationPercentageYX);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									RoundedDeviationPercentageYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									
									//RoundedDeviationPercentageYX = (double) Math.round(ExptDeviationPercentageYX * 100) / 100;
									System.out.println("Row "+C+" DEVIATION % (Y-X)/X  value is: "+RoundedDeviationPercentageYX);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for DEVIATION % (Y-X)/X  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for DEVIATION % (Y-X)/X  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  countPass++;
									  System.out.println("Expected Product value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else if(LastRowValue.equals("100.00 %"))
								  {
									  System.out.println("Deviation-Y value is Zero.");
									  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroYPercentage);
									  if(PercentageDeviationValue)
									  {
									   countPass++;
									   System.out.println("Value of Percentage Deviation Value for "+C+ "is:-"+PercentageDeviationValue);
									  }
									  else
									  {
										countFail++; 
										System.out.println("Value of Percentage Deviation Value for "+C+ "is:-False");
									  }
								  }
								  else
								  {
									if(LastRowValue.contains("%"))
									{
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  Double ActDeviationPercentageYXValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActDeviationPercentageYXValue);
									  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActDeviationPercentageYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActDeviationPercentageYX);
									}
									else
									{
										System.out.println("This is not a percentage Value.");
									}
								   for(int d=0;d<1;d++)
								   {
									  if(RoundedDeviationPercentageYX.equals(ActDeviationPercentageYX))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								   }
								 }
							  }
							}
						   Utils.waitForElement("");
						   System.out.println("loop "+C+" completed.");	
						 }
						System.out.println("DEVIATION % (Y-X)/X  calculation for table columns completed properly.");
						System.out.println("calculaion of DEVIATION % (Y-X)/X for the table,passColumns are:-"+countPass);
						System.out.println("calculaion of DEVIATION % (Y-X)/X for the table,FailColumns are:-"+countFail);
						Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("DEVIATION % (Y-X)/X row is not found still." );
					  }
				 }
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("DEVIATION % (X-Y)/Y calculation for table is not completed properly.");
		}
	}
	
	public void DeviationModXYValidation(String ChooseModRowColumnDeviationXY)
	{
		try
		{
			Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		  Utils.waitForElement("");
		  if(ChooseModRowColumnDeviationXY.equalsIgnoreCase("ModRowDeviationXY"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (X-Y)/|Y|")) 
				  {
					int countPass=0;
					int countFail=0;
					System.out.println("DEVIATION % (X-Y)/|Y| calculated element is added to the Column.");
					System.out.println("DEVIATION % (X-Y)/|Y| calculation will perform upto "+i+" column."); 
					Reporter.log("DEVIATION % (X-Y)/|Y| calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationModXY;
						String ActDeviationModXY = null;
						String RoundedDeviationModXY = null;
						String InvalidZeroMod = null;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						  for(int j=0;j<i;j++)
							{
								String valuelength=RowElementList.get(j).getText();
								if(j==(i-2))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationX=0.0;
									}
									else
									{ 
										String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationX = Double.parseDouble(RowElement2);
									}
								}
								else if(j==(i-1))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationY=0.0;
									}
									else
									{ 
										String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationY = Double.parseDouble(RowElement1);
									}
								}
							}
						}
						for(int p=0;p<1;p++)
						{
							if(DeviationY==0.0)
							{
								InvalidZeroMod="100.00 %";
							}
							else
							{
								Double ModElementValueY=Math.abs(DeviationY);
								Double BFDeviationPercentageXY=(DeviationX-DeviationY)/ModElementValueY;
								System.out.println(BFDeviationPercentageXY);
								ExptDeviationModXY=BFDeviationPercentageXY*100;
								System.out.println(ExptDeviationModXY);
								
								BigDecimal BdDMXY=new BigDecimal(ExptDeviationModXY);
								BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								String StrDMXY=BdDMXY.toString();
								RoundedDeviationModXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
								
								//RoundedDeviationModXY = (double) Math.round(ExptDeviationModXY*100) / 100;
								System.out.println("Row "+R+" DEVIATION % (X-Y)/|Y|  value is: "+RoundedDeviationModXY);
							}
						}
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  System.out.println("Last cell element for DEVIATION % (X-Y)/|Y|  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (X-Y)/|Y|  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {
								  System.out.println("Last cell element for DEVIATION % (X-Y)/|Y|  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (X-Y)/|Y|  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else if(LastRowValue.equals("100.00 %"))
							  {
								  System.out.println("Deviation-Y value is Zero.");
								  Reporter.log("Deviation-Y value is Zero.");
								  Boolean ModDeviationValue=LastRowValue.equals(InvalidZeroMod);
								  if(ModDeviationValue)
								  {
								   countPass++;
								   System.out.println("Value of Percentage Deviation Value for "+R+ "is:-"+ModDeviationValue);
								  }
								  else
								  {
									countFail++;
									System.out.println("Value of Percentage Deviation Value for "+R+ "is:-False");
								  }
							  }
							  else
							  {
								if(LastRowValue.contains("%"))
								{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  double ActDeviationModXYValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY=new BigDecimal(ActDeviationModXYValue);
								  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY=BdDMXY.toString();
								  ActDeviationModXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationModXY);
								}
								else
								{
									System.out.println("This is not a percentage Value.");
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationModXY.equals(ActDeviationModXY))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
					   Utils.waitForElement("");
					   System.out.println("loop "+R+" completed.");	
					   Reporter.log("loop "+R+" completed.");	
					 }
					System.out.println("DEVIATION % (X-Y)/|Y|  calculation for table rows completed properly.");
					Reporter.log("DEVIATION % (X-Y)/|Y| calculation for table rows completed properly.");
					System.out.println("calculaion of DEVIATION % (X-Y)/|Y| for the table,passColumns are:-"+countPass);
					System.out.println("calculaion of DEVIATION % (X-Y)/|Y| for the table,FailColumns are:-"+countFail);
					
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					break;  
				  }
				  else
				  {
					  System.out.println("DEVIATION % (X-Y)/|Y| Column is not found still." );
				  }
			 }
		  }
		  else if(ChooseModRowColumnDeviationXY.equalsIgnoreCase("ModColumnDeviationXY"))
		  {
			  for(int i=0;i<RowHeadersList.size();i++) 
				 {
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (X-Y)/|Y|")) 
					  {
						int countPass=0;
						int countFail=0;
						System.out.println("DEVIATION % (X-Y)/|Y| calculated element is added to the row.");
						System.out.println("DEVIATION % (X-Y)/|Y| calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double DeviationX = null;
							Double DeviationY = null;
							Double ExptDeviationModXY;
							String ActDeviationModXY = null;
							String RoundedDeviationModXY = null;
							String InvalidZeroMod = null;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     DeviationX=0.0;
						     DeviationY=0.0;
							}
							else
							{
							  for(int j=0;j<i;j++)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(j==(i-2))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationX=0.0;
										}
										else
										{ 
											String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationX = Double.parseDouble(RowElement2);
										}
									}
									else if(j==(i-1))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationY=0.0;
										}
										else
										{ 
											String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationY = Double.parseDouble(RowElement1);
										}
									}
								}
							}
							for(int p=0;p<1;p++)
							{
								if(DeviationY==0.0)
								{
									InvalidZeroMod="100.00 %";
								}
								else
								{
									Double ModElementValueY=Math.abs(DeviationY);
									Double BFDeviationPercentageXY=(DeviationX-DeviationY)/ModElementValueY;
									System.out.println(BFDeviationPercentageXY);
									ExptDeviationModXY=BFDeviationPercentageXY*100;
									System.out.println(ExptDeviationModXY);
									
									 BigDecimal BdDMXY=new BigDecimal(ExptDeviationModXY);
									 BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									 String StrDMXY=BdDMXY.toString();
									 RoundedDeviationModXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
									
									//RoundedDeviationModXY = (double) Math.round(ExptDeviationModXY * 100) / 100;
									System.out.println("Row "+C+" DEVIATION % (X-Y)/|Y|  value is: "+RoundedDeviationModXY);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for DEVIATION % (X-Y)/|Y|  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for DEVIATION % (X-Y)/|Y|  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  countPass++;
									  System.out.println("Expected Product value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else if(LastRowValue.equals("100.00 %"))
								  {
									  System.out.println("Deviation-Y value is Zero.");
									  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroMod);
									  if(PercentageDeviationValue)
									  {
									   countPass++;
									   System.out.println("Value of Percentage Deviation Value for "+C+ "is:-"+PercentageDeviationValue);
									  }
									  else
									  {
										countFail++;
										System.out.println("Value of Percentage Deviation Value for "+C+ "is:-False");
									  }
								  }
								  else
								  {
									if(LastRowValue.contains("%"))
									{
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  Double ActDeviationModXYValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActDeviationModXYValue);
									  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActDeviationModXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActDeviationModXY);
									}
									else
									{
										System.out.println("This is not a percentage Value.");
									}
								   for(int d=0;d<1;d++)
								   {
									  if(RoundedDeviationModXY.equals(ActDeviationModXY))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								   }
								 }
							  }
							}
						   Utils.waitForElement("");
						   System.out.println("loop "+C+" completed.");	
						 }
						System.out.println("DEVIATION % (X-Y)/|Y|  calculation for table columns completed properly.");
						System.out.println("calculaion of DEVIATION % (X-Y)/|Y| for the table,passColumns are:-"+countPass);
						System.out.println("calculaion of DEVIATION % (X-Y)/|Y| for the table,FailColumns are:-"+countFail);
						Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("DEVIATION % (X-Y)/|Y| row is not found still." );
					  }
				 }
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("DEVIATION % (X-Y)/|Y| calculation for table is not completed properly.");
		}
	}
	
	public void DeviationModYXValidation(String ChooseModRowColumnDeviationYX)
	{
		try
		{
			Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
		  Utils.waitForElement("");
		  if(ChooseModRowColumnDeviationYX.equalsIgnoreCase("ModRowDeviationYX"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (Y-X)/|X|")) 
				  {
					int countPass=0;
					int countFail=0;
					System.out.println("DEVIATION % (Y-X)/|X| calculated element is added to the Column.");
					System.out.println("DEVIATION % (Y-X)/|X| calculation will perform upto "+i+" column."); 
					Reporter.log("DEVIATION % (Y-X)/|X| calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationModYX;
						String ActDeviationModYX = null;
						String RoundedDeviationModYX = null;
						String InvalidZeroMod = null;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						  for(int j=0;j<i;j++)
							{
								String valuelength=RowElementList.get(j).getText();
								if(j==(i-2))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationX=0.0;
									}
									else
									{ 
										String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationX = Double.parseDouble(RowElement2);
									}
								}
								else if(j==(i-1))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationY=0.0;
									}
									else
									{ 
										String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationY = Double.parseDouble(RowElement1);
									}
								}
							}
						}
						for(int p=0;p<1;p++)
						{
							if(DeviationX==0.0)
							{
								InvalidZeroMod="100.00 %";
							}
							else
							{
								Double ModElementValueX=Math.abs(DeviationX);
								Double BFDeviationPercentageYX=(DeviationY-DeviationX)/ModElementValueX;
								System.out.println(BFDeviationPercentageYX);
								ExptDeviationModYX=BFDeviationPercentageYX*100;
								System.out.println(ExptDeviationModYX);
								
								BigDecimal BdDMXY=new BigDecimal(ExptDeviationModYX);
								BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								String StrDMXY=BdDMXY.toString();
								RoundedDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
								
								//RoundedDeviationModYX = (double) Math.round(ExptDeviationModYX*100) / 100;
								System.out.println("Row "+R+" DEVIATION % (Y-X)/|X|  value is: "+RoundedDeviationModYX);
							}
						}
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (Y-X)/|X|  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (Y-X)/|X|  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("0.00"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (Y-X)/|X|  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (Y-X)/|X|  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  countPass++;
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else if(LastRowValue.equals("100.00 %"))
							  {
								  System.out.println("Deviation-X value is Zero.");
								  Reporter.log("Deviation-X value is Zero.");
								  Boolean ModDeviationValue=LastRowValue.equals(InvalidZeroMod);
								  if(ModDeviationValue)
								  {
								   countPass++;
								   System.out.println("Value of Percentage Deviation Value for "+R+ "is:-"+ModDeviationValue);
								  }
								  else
								  {
									countFail++;
									System.out.println("Value of Percentage Deviation Value for "+R+ "is:-False");
								  }
							  }
							  else
							  {
								if(LastRowValue.contains("%"))
								{
									if(LastRowValue.contains("("))
									{
									  System.out.println("Value is more -ve.");
									  Reporter.log("Value is more -ve.");
									  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
									  //Double ActDeviationModYXValue= Double.parseDouble(RowlastElement);
									  Double NagativeNumber= Double.parseDouble(RowlastElement);
									  Double ActDeviationModYXValue=-(NagativeNumber);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActDeviationModYXValue);
									  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  System.out.println("Actual Result for "+R+" row is: "+ActDeviationModYX);
									}
									else
									{
										String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
										Double ActDeviationModYXValue= Double.parseDouble(RowlastElement);
									  
										BigDecimal BdDMXY=new BigDecimal(ActDeviationModYXValue);
										BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
										String StrDMXY=BdDMXY.toString();
										ActDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  
										System.out.println("Actual Result for "+R+" row is: "+ActDeviationModYX);
									}
									
								  /*String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  Double ActDeviationModYXValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY=new BigDecimal(ActDeviationModYXValue);
								  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY=BdDMXY.toString();
								  ActDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationModYX);*/
								}
								else
								{
									System.out.println("This is not a percentage Value.");
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationModYX.equals(ActDeviationModYX))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
					   Utils.waitForElement("");
					   System.out.println("loop "+R+" completed.");	
					   Reporter.log("loop "+R+" completed.");	
					 }
					System.out.println("DEVIATION % (Y-X)/|X|  calculation for table rows completed properly.");
					Reporter.log("DEVIATION % (Y-X)/|X| calculation for table rows completed properly.");
					System.out.println("calculaion of DEVIATION % (Y-X)/|X| for the table,passColumns are:-"+countPass);
					System.out.println("calculaion of DEVIATION % (Y-X)/|X| for the table,FailColumns are:-"+countFail);
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					break;  
				  }
				  else
				  {
					  System.out.println("DEVIATION % (Y-X)/|X| Column is not found still." );
				  }
			 }
		  }
		  else if(ChooseModRowColumnDeviationYX.equalsIgnoreCase("ModColumnDeviationYX"))
		  {
			  for(int i=0;i<RowHeadersList.size();i++) 
				 {
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (Y-X)/|X|")) 
					  {
						int countPass=0;
						int countFail=0;
						System.out.println("DEVIATION % (Y-X)/|X| calculated element is added to the row.");
						System.out.println("DEVIATION % (Y-X)/|X| calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double DeviationX = null;
							Double DeviationY = null;
							Double ExptDeviationModYX;
							String ActDeviationModYX = null;
							String RoundedDeviationModYX = null;
							String InvalidZeroMod = null;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     DeviationX=0.0;
						     DeviationY=0.0;
							}
							else
							{
							  for(int j=0;j<i;j++)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(j==(i-2))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationX=0.0;
										}
										else
										{ 
											String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationX = Double.parseDouble(RowElement2);
										}
									}
									else if(j==(i-1))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationY=0.0;
										}
										else
										{ 
											String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationY = Double.parseDouble(RowElement1);
										}
									}
								}
							}
							for(int p=0;p<1;p++)
							{
								if(DeviationX==0.0)
								{
									InvalidZeroMod="100.00 %";
								}
								else
								{
									Double ModElementValueX=Math.abs(DeviationX);
									Double BFDeviationPercentageYX=(DeviationY-DeviationX)/ModElementValueX;
									System.out.println(BFDeviationPercentageYX);
									ExptDeviationModYX=BFDeviationPercentageYX*100;
									System.out.println(ExptDeviationModYX);
									
									BigDecimal BdDMXY=new BigDecimal(ExptDeviationModYX);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									RoundedDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									
									//RoundedDeviationModYX = (double) Math.round(ExptDeviationModYX * 100) / 100;
									System.out.println("Row "+C+" DEVIATION % (Y-X)/|X|  value is: "+RoundedDeviationModYX);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for DEVIATION % (Y-X)/|X| on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for DEVIATION % (Y-X)/|X|  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  countPass++;
									  System.out.println("Expected Product value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else if(LastRowValue.equals("100.00 %"))
								  {
									  System.out.println("Deviation-X value is Zero.");
									  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroMod);
									  if(PercentageDeviationValue)
									  {
									   countPass++;
									   System.out.println("Value of Percentage Deviation Value for "+C+ "is:-"+PercentageDeviationValue);
									  }
									  else
									  {
										countFail++;
										System.out.println("Value of Percentage Deviation Value for "+C+ "is:-False");
									  }
								  }
								  else
								  {
									if(LastRowValue.contains("%"))
									{
										if(LastRowValue.contains("("))
										{
										  System.out.println("Value is more -ve.");
										  Reporter.log("Value is more -ve.");
										  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
										  //Double ActDeviationModYXValue= Double.parseDouble(RowlastElement);
										  Double NagativeNumber= Double.parseDouble(RowlastElement);
										  Double ActDeviationModYXValue=-(NagativeNumber);
										  
										  BigDecimal BdDMXY=new BigDecimal(ActDeviationModYXValue);
										  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
										  String StrDMXY=BdDMXY.toString();
										  ActDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
										  System.out.println("Actual Result for "+C+" row is: "+ActDeviationModYX);
										}
										else
										{
											String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
											Double ActDeviationModYXValue= Double.parseDouble(RowlastElement);
										  
											BigDecimal BdDMXY=new BigDecimal(ActDeviationModYXValue);
											BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
											String StrDMXY=BdDMXY.toString();
											ActDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
										  
											System.out.println("Actual Result for "+C+" row is: "+ActDeviationModYX);
										}
										
										
									  /*String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  Double ActDeviationModYXValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActDeviationModYXValue);
									  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActDeviationModYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActDeviationModYX);*/
									}
									else
									{
										System.out.println("This is not a percentage Value.");
									}
								   for(int d=0;d<1;d++)
								   {
									  if(RoundedDeviationModYX.equals(ActDeviationModYX))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								   }
								 }
							  }
							}
						   Utils.waitForElement("");
						   System.out.println("loop "+C+" completed.");	
						 }
						System.out.println("DEVIATION % (Y-X)/|X|  calculation for table columns completed properly.");
						System.out.println("calculaion of DEVIATION % (Y-X)/|X| for the table,passColumns are:-"+countPass);
						System.out.println("calculaion of DEVIATION % (Y-X)/|X| for the table,FailColumns are:-"+countFail);
						Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("DEVIATION % (Y-X)/|X| row is not found still." );
					  }
				 }
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("DEVIATION % (Y-X)/|X| calculation for table is not completed properly.");
		}
	}
	
	public void QuotientXYValidation(String ChooseRowColumnQuotientXY)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnQuotientXY.equalsIgnoreCase("RowQuotientXY"))
			{
				for(int i=0;i<ColumnHeadersList.size();i++) 
				 {
					  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("QUOTIENT (X/Y)")) 
					  {
						int countPass=0;
						int countFail=0;
						System.out.println("QUOTIENT (X/Y) calculated element is added to the Column.");
						System.out.println("QUOTIENT (X/Y) calculation will perform upto "+i+" column."); 
						Reporter.log("QUOTIENT (X/Y) calculation will perform upto "+i+" column."); 
						List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
						for(int R=1;R<=RowValueCount.size();R++)
						{
							Double ElementX = null;
							Double ElementY = null;
							Double ExptQuotientXY = null;
							String ActQuotientXY = null;
							String RoundedQuotientXY = null;
							
							List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
							if(i==0)
							{
								System.out.println("No Column elements are added to the Table.");
								Reporter.log("No Column elements are added to the Table.");
								ElementX=0.0;
								ElementY=0.0;
							}
							else
							{
								for(int j=0;j<i;j++)
								{
									String valuelength=RowElementList.get(j).getText();
									if(j==(i-2))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+R+" row having null value.");
											ElementX=0.0;
										}
										else
										{ 
											String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
											ElementX = Double.parseDouble(RowElement2);
										}
									}
									else if(j==(i-1))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+R+" row having null value.");
											ElementY=0.0;
										}
										else
										{ 
											String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
											ElementY = Double.parseDouble(RowElement1);
										}
									}
								}
						      }
							for(int p=0;p<1;p++)
							{
								if(ElementY==0.0)
								{
									System.out.println("ElementY:-value is Zero for "+R+" row.");
								}
								else
								{
									ExptQuotientXY=ElementX/ElementY;
									//RoundedQuotientXY = (double) Math.round(ExptQuotientXY * 100) / 100;
									
									BigDecimal BdDMXY=new BigDecimal(ExptQuotientXY);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									RoundedQuotientXY=StrDMXY.substring(0,StrDMXY.indexOf("."));

									System.out.println("Row "+R+" QUOTIENT (X/Y) value is: "+RoundedQuotientXY);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=RowElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (X/Y) on the "+R+" row is empty.");
									  Reporter.log("Last cell element for QUOTIENT (X/Y) on the "+R+" row is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (X/Y) on the "+R+" row is empty else ElementY value is Zero.");
									  Reporter.log("Last cell element for QUOTIENT (X/Y) on the "+R+" row is empty else ElementY value is Zero..");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  countPass++;
									  System.out.println("Expected QUOTIENT (X/Y) value in the "+R+" row is empty i.e having Null value.");
									  Reporter.log("Expected QUOTIENT (X/Y) value in the "+R+" row is empty i.e having Null value.");
								  } 
								  else
								  {
									  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
									  Double ActQuotientXYValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActQuotientXYValue);
									  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActQuotientXY=StrDMXY.substring(0,StrDMXY.indexOf("."));

									  System.out.println("Actual Result for "+R+" row is: "+ActQuotientXY);
									  if(RoundedQuotientXY.equals(ActQuotientXY))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+R+" row.");
										  Reporter.log("Actual and expected result is same for "+R+" row.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+R+" row.");
										  Reporter.log("Actual and expected result is not same for "+R+" row.");
									  }
								  }
								 }
							  }
							Utils.waitForElement("");
							System.out.println("loop "+R+" completed.");
							Reporter.log("loop "+R+" completed.");
						   }
						System.out.println("QUOTIENT (X/Y) calculation for table rows completed properly.");
						Reporter.log("QUOTIENT (X/Y) calculation for table rows completed properly.");
						System.out.println("calculaion of QUOTIENT (X/Y) for the table,passColumns are:-"+countPass);
						System.out.println("calculaion of QUOTIENT (X/Y) for the table,FailColumns are:-"+countFail);
						Assert.assertEquals(countPass,RowHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("QUOTIENT (X/Y) Column is not found still." );
					  }
				 }	
				
			}
			else if(ChooseRowColumnQuotientXY.equalsIgnoreCase("ColumnQuotientXY"))
			{
				for(int i=0;i<RowHeadersList.size();i++) 
				 {
					  if(RowHeadersList.get(i).getText().equalsIgnoreCase("QUOTIENT (X/Y)")) 
					  {
						int countPass=0;
						int countFail=0;
						System.out.println("QUOTIENT (X/Y) calculated element is added to the row.");
						System.out.println("QUOTIENT (X/Y) calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));

						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double ElementX = null;
							Double ElementY = null;
							Double ExptQuotientXY;
							String ActQuotientXY = null;
							String RoundedQuotientXY = null;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     ElementX=0.0;
						     ElementY=0.0;
							}
							else
							{
							for(int j=0;j<i;j++)
							{
							   String valuelength=ColumnElementList.get(j).getText();
							   if(j==(i-2))
							   {
							    if(valuelength.length()==0) 
								 {
							    	System.out.println("Cell "+j+" of "+C+" column having null value.");
							    	ElementX=0.0;
								 }
								else
								 { 
									String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
									ElementX = Double.parseDouble(RowElement2);
								 }
							   }
							   else if(j==(i-1))
							   {
							    if(valuelength.length()==0) 
								 {
									 System.out.println("Cell "+j+" of "+C+" column having null value.");
									 ElementY=0.0;
								 }
							    else
								 { 
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
							    	ElementY = Double.parseDouble(RowElement1);
								 }
							   }
							  }
						    }
							for(int p=0;p<1;p++)
							{
								if(ElementY==0.0)
								{
									System.out.println("ElementY:-value is Zero for "+C+" row.");
								}
								else
								{
									ExptQuotientXY=ElementX/ElementY;
									//RoundedQuotientXY = (double) Math.round(ExptQuotientXY * 100) / 100;
									System.out.println("Expected Value before Roundup: "+ExptQuotientXY);
									BigDecimal BdDMXY=new BigDecimal(ExptQuotientXY);
									BdDMXY = BdDMXY.setScale(2, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									RoundedQuotientXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
									
									System.out.println("Row "+C+" QUOTIENT (X/Y) value is: "+RoundedQuotientXY);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (X/Y) on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (X/Y) on the "+C+" column is empty else ElementY value is Zero.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  System.out.println("Expected QUOTIENT (X/Y) value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else
								  {
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  Double ActQuotientXYValue= Double.parseDouble(RowlastElement);
									  System.out.println("Actual Value before Roundup: "+ActQuotientXYValue);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActQuotientXYValue);
									  BdDMXY = BdDMXY.setScale(2, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActQuotientXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActQuotientXY);
									  if(RoundedQuotientXY.equals(ActQuotientXY))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								  }
								 }
							  }
							Utils.waitForElement("");
							System.out.println("loop "+C+" completed.");
						   }
						System.out.println("QUOTIENT (X/Y) calculation for table columns completed properly.");
						System.out.println("calculaion of QUOTIENT (X/Y) for the table,passColumns are:-"+countPass);
						System.out.println("calculaion of QUOTIENT (X/Y) for the table,FailColumns are:-"+countFail);
						Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("QUOTIENT (X/Y) row is not found still." );
					  }
				 }		
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("QUOTIENT (X/Y) calculation for table is not completed properly.");
		}
	}
	
	public void QuotientYXValidation(String ChooseRowColumnQuotientYX)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnQuotientYX.equalsIgnoreCase("RowQuotientYX"))
			{
				for(int i=0;i<ColumnHeadersList.size();i++) 
				 {
					  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("QUOTIENT (Y/X)")) 
					  {
						int countPass=0;
						int countFail=0;
						System.out.println("QUOTIENT (Y/X) calculated element is added to the Column.");
						System.out.println("QUOTIENT (Y/X) calculation will perform upto "+i+" column."); 
						Reporter.log("QUOTIENT (Y/X) calculation will perform upto "+i+" column."); 
						List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
						for(int R=1;R<=RowValueCount.size();R++)
						{
							Double ElementX = null;
							Double ElementY = null;
							Double ExptQuotientYX = null;
							String ActQuotientYX = null;
							String RoundedQuotientYX = null;
							
							List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
							if(i==0)
							{
								System.out.println("No Column elements are added to the Table.");
								Reporter.log("No Column elements are added to the Table.");
								ElementX=0.0;
								ElementY=0.0;
							}
							else
							{
								for(int j=0;j<i;j++)
								{
									String valuelength=RowElementList.get(j).getText();
									if(j==(i-2))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+R+" row having null value.");
											ElementX=0.0;
										}
										else
										{ 
											String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
											ElementX = Double.parseDouble(RowElement2);
										}
									}
									else if(j==(i-1))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+R+" row having null value.");
											ElementY=0.0;
										}
										else
										{ 
											String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
											ElementY = Double.parseDouble(RowElement1);
										}
									}
								}
						      }
							for(int p=0;p<1;p++)
							{
								if(ElementX==0.0)
								{
									System.out.println("ElementX:-value is Zero for "+R+" row.");
								}
								else
								{
									ExptQuotientYX=ElementY/ElementX;
									//RoundedQuotientYX = (double) Math.round(ExptQuotientYX * 100) / 100;
									
									BigDecimal BdDMXY=new BigDecimal(ExptQuotientYX);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									RoundedQuotientYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									
									System.out.println("Row "+R+" QUOTIENT (Y/X) value is: "+RoundedQuotientYX);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=RowElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (Y/X) on the "+R+" row is empty.");
									  Reporter.log("Last cell element for QUOTIENT (Y/X) on the "+R+" row is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (Y/X) on the "+R+" row is empty else ElementX value is zero.");
									  Reporter.log("Last cell element for QUOTIENT (Y/X) on the "+R+" row is empty else ElementX value is zero.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  countPass++;
									  System.out.println("Expected QUOTIENT (Y/X) value in the "+R+" row is empty i.e having Null value.");
									  Reporter.log("Expected QUOTIENT (Y/X) value in the "+R+" row is empty i.e having Null value.");
								  } 
								  else
								  {
									  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
									  Double ActQuotientYXValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActQuotientYXValue);
									  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActQuotientYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+R+" row is: "+ActQuotientYX);
									  if(RoundedQuotientYX.equals(ActQuotientYX))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+R+" row.");
										  Reporter.log("Actual and expected result is same for "+R+" row.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+R+" row.");
										  Reporter.log("Actual and expected result is not same for "+R+" row.");
									  }
								  }
								 }
							  }
							Utils.waitForElement("");
							System.out.println("loop "+R+" completed.");
							Reporter.log("loop "+R+" completed.");
						   }
						System.out.println("QUOTIENT (Y/X) calculation for table rows completed properly.");
						Reporter.log("QUOTIENT (X/Y) calculation for table rows completed properly.");
						System.out.println("calculaion of QUOTIENT (Y/X) for the table,passColumns are:-"+countPass);
						System.out.println("calculaion of QUOTIENT (Y/X) for the table,FailColumns are:-"+countFail);
						Assert.assertEquals(countPass,RowHeadersList.size()-1);
						
						break;  
					  }
					  else
					  {
						  System.out.println("QUOTIENT (Y/X) Column is not found still." );
					  }
				 }	
				
			}
			else if(ChooseRowColumnQuotientYX.equalsIgnoreCase("ColumnQuotientYX"))
			{
				for(int i=0;i<RowHeadersList.size();i++) 
				 {
					  if(RowHeadersList.get(i).getText().equalsIgnoreCase("QUOTIENT (Y/X)")) 
					  {
						int countPass=0;
						int countFail=0;
						System.out.println("QUOTIENT (Y/X) calculated element is added to the row.");
						System.out.println("QUOTIENT (Y/X) calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));

						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double ElementX = null;
							Double ElementY = null;
							Double ExptQuotientYX;
							String ActQuotientYX = null;
							String RoundedQuotientYX = null;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     ElementX=0.0;
						     ElementY=0.0;
							}
							else
							{
							for(int j=0;j<i;j++)
							{
							   String valuelength=ColumnElementList.get(j).getText();
							   if(j==(i-2))
							   {
							    if(valuelength.length()==0) 
								 {
							    	System.out.println("Cell "+j+" of "+C+" column having null value.");
							    	ElementX=0.0;
								 }
								else
								 { 
									String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
									ElementX = Double.parseDouble(RowElement2);
								 }
							   }
							   else if(j==(i-1))
							   {
							    if(valuelength.length()==0) 
								 {
									 System.out.println("Cell "+j+" of "+C+" column having null value.");
									 ElementY=0.0;
								 }
							    else
								 { 
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
							    	ElementY = Double.parseDouble(RowElement1);
								 }
							   }
							  }
						    }
							for(int p=0;p<1;p++)
							{
								if(ElementX==0.0)
								{
									System.out.println("ElementY:-value is Zero for "+C+" row.");
								}
								else
								{
									ExptQuotientYX=ElementY/ElementX;
									//RoundedQuotientYX = (double) Math.round(ExptQuotientYX * 100) / 100;
									
									BigDecimal BdDMXY=new BigDecimal(ExptQuotientYX);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									RoundedQuotientYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									
									System.out.println("Row "+C+" QUOTIENT (X/Y) value is: "+RoundedQuotientYX);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (Y/X) on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countPass++;
									  System.out.println("Last cell element for QUOTIENT (Y/X) on the "+C+" column is empty else ElementX value is Zero..");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  System.out.println("Expected QUOTIENT (Y/X) value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else
								  {
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  Double ActQuotientYXValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDMXY=new BigDecimal(ActQuotientYXValue);
									  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDMXY=BdDMXY.toString();
									  ActQuotientYX=StrDMXY.substring(0,StrDMXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActQuotientYX);
									  if(RoundedQuotientYX.equals(ActQuotientYX))
									  {
										  countPass++;
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  countFail++;
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								  }
								 }
							  }
							Utils.waitForElement("");
							System.out.println("loop "+C+" completed.");
						   }
						System.out.println("QUOTIENT (Y/X) calculation for table columns completed properly.");
						System.out.println("calculaion of QUOTIENT (Y/X) for the table,passColumns are:-"+countPass);
						System.out.println("calculaion of QUOTIENT (Y/X) for the table,FailColumns are:-"+countFail);
						Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("QUOTIENT (Y/X) row is not found still." );
					  }
				 }		
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("QUOTIENT (Y/X) calculation for table is not completed properly.");
		}
	}
	public void AscendingValidation(String ChooseRowColumnAscending)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnAscending.equalsIgnoreCase("ColumnAscending"))
			{
				for(int i=0;i<ColumnHeadersList.size();i++) 
				{
					 if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("RANK ASCENDING")) 
					 {
						int CountPass = 0;
						int CountFail=0;
						int CountDuplicateResult=0;
						System.out.println("RANK ASCENDING calculated element is added to the Column.");
						System.out.println("RANK ASCENDING calculation will perform upto "+i+" column."); 
						Reporter.log("RANK ASCENDING calculation will perform upto "+i+" column."); 
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<Integer> arrListInt=new ArrayList<Integer>();
						Map maplistBf=new HashMap<Integer,Double>();
						List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
						//List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));

						for(int R=1;R<=RowValueCount.size();R++)
						{
							//ArrayList<Double> arrList=new ArrayList<Double>();
							List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
							if(i==0)
							{
								System.out.println("No Column elements are added to the Table.");
								Reporter.log("No Column elements are added to the Table.");
							}
							else
							{
							  for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=RowElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+R+" row having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous Column is not found");
								}
							  }
							}
							//System.out.println("Last row value count.....");
							for(int ar=0;ar<=i;ar++)
							{
								if(ar==i)
								{
									 String LastRowValue=RowElementList.get(ar).getText();
									 if(LastRowValue.equals("#NV"))
									 {
										 CountPass++;
										 System.out.println("Last Column having No Value.");
									 }
									 else
									 {
										int rowValue=Integer.parseInt(LastRowValue);
										arrListInt.add(rowValue);
									 }
									 
								}
							}
							 System.out.println("loop "+R+" completed.");
						}
						for(int As=0;As<arrListInt.size();As++)
						{
							if(arrListInt.get(As)==1)
							{
								CountDuplicateResult++;
							}
						}
						
						for(int a=0;a<1;a++)
						{
							if(arrList.size()==RowValueCount.size() && CountDuplicateResult==1)
							{
								System.out.println("Total column elements are present so proceed towards calculation.");
								for(int m=0;m<arrList.size();m++)
								{
								  maplistBf.put(arrListInt.get(m),arrList.get(m));
								}
								Collections.sort(arrList);
								for(int k=0;k<arrList.size();k++)
								{
									//System.out.println(maplistBf.get(k));
									if(arrList.get(k).equals(maplistBf.get(k+1)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full Column element is:-"+CountPass);
								System.out.println("Fail count full Column element is:-"+CountFail);
							}
							else if(arrList.size()!=RowValueCount.size() && CountDuplicateResult>=2)
							{
								System.out.println("Total column elements are not present.");
								for(int y=0;y<CountDuplicateResult;y++)
								{
									arrListInt.remove(new Integer(1));
								}
								for(int p=0;p<arrList.size();p++)
								{
								  maplistBf.put(arrListInt.get(p),arrList.get(p));
								}
								Collections.sort(arrList);
								for(int k=0;k<arrList.size();k++)
								{
									if(arrList.get(k).equals(maplistBf.get(CountDuplicateResult+1+k)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full Column element is:-"+CountPass);
								System.out.println("Fail count full Column element is:-"+CountFail);
								
							}
							else
							{
								System.out.println("No column elements are present.");
								System.out.println("Ascending value for total Column is:-#NV");
							}
						}
						System.out.println("Ascending Column Calculation completed successfully.");
						Assert.assertEquals(CountPass,RowHeadersList.size()-1);
						
						break;
					 }
					 else
					 {
						 System.out.println("RANK ASCENDING Column is not found still." );
					 }
			    }
			}
			else if(ChooseRowColumnAscending.equalsIgnoreCase("RowAscending"))
			{
				for(int i=0;i<RowHeadersList.size();i++) 
				{
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("RANK ASCENDING")) 
					 {
						int CountPass = 0;
						int CountFail=0;
						int CountDuplicateResult=0;
						System.out.println("RANK ASCENDING calculated element is added to the row.");
						System.out.println("RANK ASCENDING calculation will perform upto "+i+" row."); 
						Reporter.log("RANK ASCENDING calculation will perform upto "+i+" row."); 
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<Integer> arrListInt=new ArrayList<Integer>();
						Map maplistBf=new HashMap<Integer,Double>();
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						//List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));

						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							//ArrayList<Double> arrList=new ArrayList<Double>();
						    List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
								System.out.println("No row elements are added to the Table.");
								Reporter.log("No row elements are added to the Table.");
							}
							else
							{
							  for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+C+" Column having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous row is not found");
								}
							  }
							}
							//System.out.println("Last row value count.....");
							for(int ar=0;ar<=i;ar++)
							{
								if(ar==i)
								{
									 String LastRowValue=ColumnElementList.get(ar).getText();
									 if(LastRowValue.equals("#NV"))
									 {
										 CountPass++;
										 System.out.println("Last row having No Value.");
									 }
									 else
									 {
										int rowValue=Integer.parseInt(LastRowValue);
										arrListInt.add(rowValue);
									 }
									 
								}
							}
							 System.out.println("loop "+C+" completed.");
						}
						for(int As=0;As<arrListInt.size();As++)
						{
							if(arrListInt.get(As)==1)
							{
								CountDuplicateResult++;
							}
						}
						
						for(int a=0;a<1;a++)
						{
							if(arrList.size()==ColumnValueCount.size() && CountDuplicateResult==1)
							{
								System.out.println("Total row elements are present so proceed towards calculation.");
								for(int m=0;m<arrList.size();m++)
								{
								  maplistBf.put(arrListInt.get(m),arrList.get(m));
								}
								Collections.sort(arrList);
								for(int k=0;k<arrList.size();k++)
								{
									//System.out.println(maplistBf.get(k));
									if(arrList.get(k).equals(maplistBf.get(k+1)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full row element is:-"+CountPass);
								System.out.println("Fail count full row element is:-"+CountFail);
							}
							else if(arrList.size()!=ColumnValueCount.size() && CountDuplicateResult>=2)
							{
								System.out.println("Total row elements are not present.");
								for(int y=0;y<CountDuplicateResult;y++)
								{
									arrListInt.remove(new Integer(1));
								}
								for(int p=0;p<arrList.size();p++)
								{
								  maplistBf.put(arrListInt.get(p),arrList.get(p));
								}
								Collections.sort(arrList);
								for(int k=0;k<arrList.size();k++)
								{
									if(arrList.get(k).equals(maplistBf.get(CountDuplicateResult+1+k)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full row element is:-"+CountPass);
								System.out.println("Fail count full row element is:-"+CountFail);
								
							}
							else
							{
								System.out.println("No row elements are present.");
								System.out.println("Ascending value for total row is:-#NV");
							}
						}
						System.out.println("Ascending row Calculation completed successfully.");
						
						int PassCount=CountPass+CountDuplicateResult;
						Assert.assertEquals(PassCount,ColumnHeadersList.size()-1);
						break;
					 }
					 else
					 {
						 System.out.println("RANK ASCENDING row is not found still." );
					 }
			    }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void DescendingValidation(String ChooseRowColumnDescending)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnDescending.equalsIgnoreCase("ColumnDescending"))
			{
				for(int i=0;i<ColumnHeadersList.size();i++) 
				{
					 if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("RANK DESCENDING")) 
					 {
						int CountPass = 0;
						int CountFail=0;
						int CountDuplicateResult=0;
						
						System.out.println("RANK DESCENDING calculated element is added to the Column.");
						System.out.println("RANK DESCENDING calculation will perform upto "+i+" column."); 
						Reporter.log("RANK DESCENDING calculation will perform upto "+i+" column."); 
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<Integer> arrListInt=new ArrayList<Integer>();
						Map maplistBf=new HashMap<Integer,Double>();
						List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));

						for(int R=1;R<=RowValueCount.size();R++)
						{
							//ArrayList<Double> arrList=new ArrayList<Double>();
							List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
							
							if(i==0)
							{
								System.out.println("No Column elements are added to the Table.");
								Reporter.log("No Column elements are added to the Table.");
							}
							else
							{
							  for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=RowElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+R+" row having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous Column is not found");
								}
							  }
							}
							//System.out.println("Last row value count.....");
							for(int ar=0;ar<=i;ar++)
							{
								if(ar==i)
								{
									 String LastRowValue=RowElementList.get(ar).getText();
									 if(LastRowValue.equals("#NV"))
									 {
										 System.out.println("Last Column having No Value.");
									 }
									 else
									 {
										int rowValue=Integer.parseInt(LastRowValue);
										arrListInt.add(rowValue);
									 }
									 
								}
							}
							 System.out.println("loop "+R+" completed.");
						}
						for(int As=0;As<arrListInt.size();As++)
						{
							if(arrListInt.get(As)==RowValueCount.size()-1)
							{
								CountDuplicateResult++;
							}
						}
						
						for(int a=0;a<1;a++)
						{
							if(arrList.size()==RowValueCount.size() && CountDuplicateResult==1)
							{
								System.out.println("Total column elements are present so proceed towards calculation.");
								for(int m=0;m<arrList.size();m++)
								{
								  maplistBf.put(arrListInt.get(m),arrList.get(m));
								}
								System.out.println(maplistBf);
								
								Collections.sort(arrList);
								Collections.reverse(arrList);
								for(int j=0;j<arrList.size();j++)
								{
									System.out.println(arrList.get(j));
								}
								for(int t=0;t<arrList.size();t++)
								{
									if(arrList.get(t).equals(maplistBf.get(t+1)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full Column element is:-"+CountPass);
								System.out.println("Fail count full Column element is:-"+CountFail);
							}
							else if(arrList.size()!=RowValueCount.size() && CountDuplicateResult>=2)
							{
								System.out.println("Total column elements are not present.");
								for(int y=0;y<CountDuplicateResult;y++)
								{
									arrListInt.remove(new Integer(RowValueCount.size()-1));
								}
								for(int p=0;p<arrList.size();p++)
								{
								  maplistBf.put(arrListInt.get(p),arrList.get(p));
								}
								Collections.sort(arrList);
								Collections.reverse(arrList);
								for(int t=0;t<arrList.size();t++)
								{
									if(arrList.get(t).equals(maplistBf.get(t+1)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full Column element is:-"+CountPass);
								System.out.println("Fail count full Column element is:-"+CountFail);
								
							}
							else
							{
								System.out.println("No column elements are present.");
								System.out.println("Descending value for total Column is:-#NV");
							}
						}
						System.out.println("Descending Column Calculation completed successfully.");
						break;
					 }
					 else
					 {
						 System.out.println("RANK DESCENDING Column is not found still." );
					 }
			    }
			}
			else if(ChooseRowColumnDescending.equalsIgnoreCase("RowDescending"))
			{
				for(int i=0;i<RowHeadersList.size();i++) 
				{
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("RANK DESCENDING")) 
					 {
						int CountPass = 0;
						int CountFail=0;
						int CountDuplicateResult=0;
						System.out.println("RANK ASCENDING calculated element is added to the row.");
						System.out.println("RANK ASCENDING calculation will perform upto "+i+" row."); 
						Reporter.log("RANK ASCENDING calculation will perform upto "+i+" row."); 
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<Integer> arrListInt=new ArrayList<Integer>();
						Map maplistBf=new HashMap<Integer,Double>();
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						//List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));

						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							//ArrayList<Double> arrList=new ArrayList<Double>();
						    List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
								System.out.println("No row elements are added to the Table.");
								Reporter.log("No row elements are added to the Table.");
							}
							else
							{
							  for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+C+" Column having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous row is not found");
								}
							  }
							}
							//System.out.println("Last row value count.....");
							for(int ar=0;ar<=i;ar++)
							{
								if(ar==i)
								{
									 String LastRowValue=ColumnElementList.get(ar).getText();
									 if(LastRowValue.equals("#NV"))
									 {
										 System.out.println("Last row having No Value.");
									 }
									 else
									 {
										int rowValue=Integer.parseInt(LastRowValue);
										arrListInt.add(rowValue);
									 }
									 
								}
							}
							 System.out.println("loop "+C+" completed.");
						}
						for(int As=0;As<arrListInt.size();As++)
						{
							if(arrListInt.get(As)==ColumnValueCount.size()-1)
							{
								CountDuplicateResult++;
							}
						}
						
						for(int a=0;a<1;a++)
						{
							if(arrList.size()==ColumnValueCount.size() && CountDuplicateResult==1)
							{
								System.out.println("Total column elements are present so proceed towards calculation.");
								for(int m=0;m<arrList.size();m++)
								{
								  maplistBf.put(arrListInt.get(m),arrList.get(m));
								}
								System.out.println(maplistBf);
								
								Collections.sort(arrList);
								Collections.reverse(arrList);
								for(int j=0;j<arrList.size();j++)
								{
									System.out.println(arrList.get(j));
								}
								for(int t=0;t<arrList.size();t++)
								{
									if(arrList.get(t).equals(maplistBf.get(t+1)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full Column element is:-"+CountPass);
								System.out.println("Fail count full Column element is:-"+CountFail);
							}
							else if(arrList.size()!=ColumnValueCount.size() && CountDuplicateResult>=2)
							{
								System.out.println("Total column elements are not present.");
								for(int y=0;y<CountDuplicateResult;y++)
								{
									arrListInt.remove(new Integer(ColumnValueCount.size()-1));
								}
								for(int p=0;p<arrList.size();p++)
								{
								  maplistBf.put(arrListInt.get(p),arrList.get(p));
								}
								Collections.sort(arrList);
								Collections.reverse(arrList);
								for(int t=0;t<arrList.size();t++)
								{
									if(arrList.get(t).equals(maplistBf.get(t+1)))
									{
										CountPass++;
									}
									else
									{
										CountFail++;
										System.out.println("Elements are not equal.");
									}
								}
								System.out.println("Pass count for full Column element is:-"+CountPass);
								System.out.println("Fail count full Column element is:-"+CountFail);
								
							}
							else
							{
								System.out.println("No row elements are present.");
								System.out.println("Ascending value for total row is:-#NV");
							}
						}
						System.out.println("Ascending row Calculation completed successfully.");
						break;
					 }
					 else
					 {
						 System.out.println("RANK ASCENDING row is not found still." );
					 }
			    }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void ElementCountValidation(String ChooseRowColumnElementCount)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			 List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			 Utils.waitForElement("");
			 List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			 Utils.waitForElement("");
			 if(ChooseRowColumnElementCount.equalsIgnoreCase("RowElementCount"))
			  {
				 for(int i=0;i<ColumnHeadersList.size();i++)
				 {
					 if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("ELEMENTCOUNT"))
					 {
						 int countPass=0;
						 int countFail=0;
						 System.out.println("ELEMENTCOUNT calculated element is added to the Column.");
						 Reporter.log("ELEMENTCOUNT calculated element is added to the Column.");
						 System.out.println("ELEMENTCOUNT calculation will perform upto "+i+" column.");
						 Reporter.log("ELEMENTCOUNT calculation will perform upto "+i+" column.");
						 List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
						 for(int R=1;R<=RowValueCount.size();R++)
						 { 
							 ArrayList<Double> arrListRow=new ArrayList<Double>();
							 int FullElementCount = 0;
							 int PresentElementCount = 0;
							 //int NullElementCount;
							 int ActResultCount;
							 List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
							 for(int j=0;j<i;j++)
							 {
								String valuelength=RowElementList.get(j).getText();
								if(valuelength.length()==0)
							    {
									System.out.println("Cell "+j+" of "+R+" row having null value.");
							    }
							    else
							    {
							    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrListRow.add(RowElement2);
							    }
							 }
							 for(int rc=0;rc<1;rc++)
							 {
								 if(arrListRow.size()==0)
								 {
									 System.out.println("Full "+R+ "Row is empty.");
									// NullElementCount=arrListRow.size();
								 }
								 else if(arrListRow.size()==RowElementList.size()-1)
								 {
									 System.out.println("Full "+R+ "Row elements are present.");
									 FullElementCount=RowElementList.size()-1;
								 }
								 else if(arrListRow.size()<RowElementList.size()-1)
								 {
									 System.out.println("Full "+R+ "Row elements are not present.");
									 PresentElementCount=RowElementList.size()-1;
								 }
								 else
								 {
									 System.out.println("Arraylist Conditions are not matching.");
								 }
							 }
							 for(int lr=0;lr<=i;lr++)
							 {
								 if(lr==i)
								  {
									 String LastRowValue=RowElementList.get(lr).getText();
									 
									 if(LastRowValue=="#NV")
									 {
										 countPass++;
										 System.out.println("Full row is Empty.");
										 Reporter.log("Full row is Empty.");
									 }
									 else if(LastRowValue.equals("0.00"))
									 {
										 countPass++;
										 System.out.println("One Cell element value in the "+R+" row having zero value.");
										 System.out.println("ElementCount Value for row "+R+" for One cell value is zero:-"+LastRowValue);
										 Reporter.log("ElementCount Value for row "+R+" for One cell value is zero:-"+LastRowValue);
									 }
									 else if(LastRowValue.length()==0)
									 {
										 System.out.println("Expected ElementCount value in the "+R+" row is empty i.e having Null value.");
									 }
									 else
									 {
										 ActResultCount=Integer.parseInt(LastRowValue);
										 if(ActResultCount==FullElementCount)
										 {
											 countPass++;
											 System.out.println("Result Count is equal for "+R+" row is:-"+FullElementCount);
											 
										 }
										 else if(ActResultCount==PresentElementCount)
										 {
											 countPass++;
											 System.out.println("Result Count is equal for "+R+" row is:-"+PresentElementCount);
										 }
										 else
										 {
											 countFail++;
											 System.out.println("Result is not Equal.");
										 }
									 }
								  }
							 }
							Utils.waitForElement("");
							arrListRow.clear();
							System.out.println("loop "+R+" completed.");
						 }
						 System.out.println("calculaion of ELEMENTCOUNT for the table,passrows are:-"+countPass);
						 System.out.println("calculaion of ELEMENTCOUNT for the table,Failrows are:-"+countFail);
						 break;
					 }
					 else
					 {
						 System.out.println("ELEMENTCOUNT Column is not found still." );
					 }
				 }
			  }
			 else if(ChooseRowColumnElementCount.equalsIgnoreCase("ColumnElementCount"))
			 {
				 for(int i=0;i<RowHeadersList.size();i++)
				 {
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("ELEMENTCOUNT"))
					 {
						 int countPass=0;
						 int countFail=0;
						 System.out.println("ELEMENTCOUNT calculated element is added to the row.");
						 Reporter.log("ELEMENTCOUNT calculated element is added to the row.");
						 System.out.println("ELEMENTCOUNT calculation will perform upto "+i+" row.");
						 Reporter.log("ELEMENTCOUNT calculation will perform upto "+i+" row.");
						 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						 for(int C=1;C<=ColumnValueCount.size();C++)
						 { 
							 ArrayList<Double> arrListRow=new ArrayList<Double>();
							 int FullElementCount = 0;
							 int PresentElementCount = 0;
							 //int NullElementCount;
							 int ActResultCount;
							 List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							 for(int j=0;j<i;j++)
							 {
								String valuelength=ColumnElementList.get(j).getText();
								if(valuelength.length()==0)
							    {
									System.out.println("Cell "+j+" of "+C+" column having null value.");
							    }
							    else
							    {
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrListRow.add(RowElement2);
							    }
							 }
							 for(int rc=0;rc<1;rc++)
							 {
								 if(arrListRow.size()==0)
								 {
									 System.out.println("Full "+C+ "column is empty.");
									// NullElementCount=arrListRow.size();
								 }
								 else if(arrListRow.size()==ColumnElementList.size()-1)
								 {
									 System.out.println("Full "+C+ "column elements are present.");
									 FullElementCount=ColumnElementList.size()-1;
								 }
								 else if(arrListRow.size()<ColumnElementList.size()-1)
								 {
									 System.out.println("Full "+C+ "column elements are not present.");
									 PresentElementCount=ColumnElementList.size()-1;
								 }
								 else
								 {
									 System.out.println("Arraylist Conditions are not matching.");
								 }
							 }
							 for(int lr=0;lr<=i;lr++)
							 {
								 if(lr==i)
								  {
									 String LastRowValue=ColumnElementList.get(lr).getText();
									 
									 if(LastRowValue.equals("#NV"))
									 {
										 countPass++;
										 System.out.println("Full column is Empty.");
										 Reporter.log("Full column is Empty.");
									 }
									 else if(LastRowValue.equals("€0.00"))
									 {
										 countPass++;
										 System.out.println("One Cell element value in the "+C+" column having zero value.");
										 System.out.println("ElementCount Value for column "+C+" for One cell value is zero:-"+LastRowValue);
										 Reporter.log("ElementCount Value for column "+C+" for One cell value is zero:-"+LastRowValue);
									 }
									 else if(LastRowValue.length()==0)
									 {
										 System.out.println("Expected ElementCount value in the "+C+" column is empty i.e having Null value.");
									 }
									 else
									 {
										 ActResultCount=Integer.parseInt(LastRowValue);
										 if(ActResultCount==FullElementCount)
										 {
											 countPass++;
											 System.out.println("Result Count is equal for "+C+" column is:-"+FullElementCount);
											 
										 }
										 else if(ActResultCount==PresentElementCount)
										 {
											 countPass++;
											 System.out.println("Result Count is equal for "+C+" column is:-"+PresentElementCount);
										 }
										 else
										 {
											 countFail++;
											 System.out.println("Result is not Equal.");
										 }
									 }
								  }
							 }
							Utils.waitForElement("");
							arrListRow.clear();
							System.out.println("loop "+C+" completed.");
						 }
						 System.out.println("calculaion of ELEMENTCOUNT for the table,passColumns are:-"+countPass);
						 System.out.println("calculaion of ELEMENTCOUNT for the table,FailColumns are:-"+countFail);
						 break;
					 }
					 else
					 {
						 System.out.println("ELEMENTCOUNT row is not found still." );
					 }
				 } 
			 }
			 System.out.println("ELEMENTCOUNT value calculation is completed properly.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("ELEMENTCOUNT value calculation is not completed properly.");
		}
	}
	public void PercentageValidation(String ChooseRowColumnPercentage)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnPercentage.equalsIgnoreCase("ColumnPercentage"))
			{
				for(int i=0;i<ColumnHeadersList.size();i++)
				 {
					if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("PERCENTAGE"))
					 {
						int countPass=0;
						int countFail=0;
						System.out.println("PERCENTAGE calculated element is added to the Column.");
						Reporter.log("PERCENTAGE calculated element is added to the Column.");
						System.out.println("PERCENTAGE calculation will perform upto "+i+" column.");
						Reporter.log("PERCENTAGE calculation will perform upto "+i+" column.");
						
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<String> ActArrListPercnt=new ArrayList<String>();
						ArrayList<String> ExptArrListPercnt=new ArrayList<String>();
					 	List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					 	for(int R=1;R<=RowValueCount.size();R++)
						{
						  List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						  if(i==0)
						  {
								System.out.println("No Column elements are added to the Table.");
								Reporter.log("No Column elements are added to the Table.");
						  }
						  else
						  {
							 for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=RowElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+R+" row having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous Column is not found");
								}
							 }
							 for(int lr=0;lr<=i;lr++)
							 {
								 if(lr==i)
								 {
									String LastRowValue=RowElementList.get(lr).getText();
									if(LastRowValue.equals("#NV") || LastRowValue.equals("€0.00"))
									 {
											countPass++;
											System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 }
									else if(LastRowValue.length()==0)
									 {
										countPass++;
										System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 } 
									else
									 {
										String lastRowElement=RemoveCharMethod(RowElementList.get(lr).getText());
								    	double lastRowElement1Value = Double.parseDouble(lastRowElement);
								    	
								    	BigDecimal BdDMXY=new BigDecimal(lastRowElement1Value);
										BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
										String StrDMXY=BdDMXY.toString();
										String lastRowElement1=StrDMXY.substring(0,StrDMXY.indexOf("."));
								    	
								    	ActArrListPercnt.add(lastRowElement1);
									 }
									  
								 }
							 }
						   }
						  System.out.println("loop "+R+" completed.");
						}
					 	
					 	System.out.println("Elements added to the List...Now validation part.");
					 	for(int cal=0;cal<1;cal++)
					 	{
					 		if(arrList.size()==RowValueCount.size())
					 		{
					 			System.out.println("calculation part....");
					 			for(int p=0,fv=0;p<arrList.size();p++)
					 			{
					 				double DevideNumbr=arrList.get(p)/arrList.get(fv);
					 				double ResultNumber=DevideNumbr*100;
					 				//double ResultNumber1=(double) Math.round(ResultNumber * 100) / 100;
					 				
					 				BigDecimal BdDMXY=new BigDecimal(ResultNumber);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									String ResultNumber1=StrDMXY.substring(0,StrDMXY.indexOf("."));
					 				
					 				ExptArrListPercnt.add(ResultNumber1);
					 			}
					 			for(int Res=0;Res<arrList.size();Res++)
					 			{
					 				System.out.println("Element Calculation part...");
					 				if(ActArrListPercnt.get(Res).equals(ExptArrListPercnt.get(Res)))
					 				{
					 					countPass++;
					 					//System.out.println("Elements are equals in both array.");
					 				}
					 				else
					 				{
					 					countFail++;
					 					System.out.println("Elements are not equals in both array.");
					 				}
					 			}
					 			
					 		}
					 		else if(arrList.size()!=RowValueCount.size() || arrList.size()==0)
					 		{
					 			//countPass++;
					 			System.out.println("calculation part not required because one cell value is Null(#NV) else No element in the arraylist....");
					 		}
					 		else
					 		{
					 			System.out.println("No conditions are matched....");
					 		}
					 		
					 		
					 	}
					 	 System.out.println("calculaion of PERCENTAGE for the table,passCount are:-"+countPass);
						 System.out.println("calculaion of PERCENTAGE for the table,FailCount are:-"+countFail);
						 Assert.assertEquals(countPass,RowHeadersList.size()-1);
					 	break;
					 }
					else
					{
					   System.out.println("PERCENTAGE Column is not found still." );
					}
				 }
			}
			else if(ChooseRowColumnPercentage.equalsIgnoreCase("RowPercentage"))
			{
				for(int i=0;i<RowHeadersList.size();i++)
				 {
					if(RowHeadersList.get(i).getText().equalsIgnoreCase("PERCENTAGE"))
					 {
						int countPass=0;
						int countFail=0;
						System.out.println("PERCENTAGE calculated element is added to the Row.");
						Reporter.log("PERCENTAGE calculated element is added to the Row.");
						System.out.println("PERCENTAGE calculation will perform upto "+i+" Row.");
						Reporter.log("PERCENTAGE calculation will perform upto "+i+" Row.");
						
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<String> ActArrListPercnt=new ArrayList<String>();
						ArrayList<String> ExptArrListPercnt=new ArrayList<String>();
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
					 	for(int C=1;C<=ColumnValueCount.size();C++)
						{
						  List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
						  if(i==0)
						  {
								System.out.println("No row elements are added to the Table.");
								Reporter.log("No row elements are added to the Table.");
						  }
						  else
						  {
							 for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+C+" Column having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous row is not found");
								}
							 }
							 for(int lr=0;lr<=i;lr++)
							 {
								 if(lr==i)
								 {
									String LastRowValue=ColumnElementList.get(lr).getText();
									if(LastRowValue.equals("#NV") || LastRowValue.equals("€0.00"))
									 {
											countPass++;
											System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 }
									else if(LastRowValue.length()==0)
									 {
										countPass++;
										System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 } 
									else
									 {
										String lastRowElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
								    	double lastRowElement1Value = Double.parseDouble(lastRowElement);
								    	
								    	BigDecimal BdDMXY=new BigDecimal(lastRowElement1Value);
										BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
										String StrDMXY=BdDMXY.toString();
										String lastRowElement1=StrDMXY.substring(0,StrDMXY.indexOf("."));
								    	
								    	ActArrListPercnt.add(lastRowElement1);
									 }
									  
								 }
							 }
						   }
						  System.out.println("loop "+C+" completed.");
						}
					 	
					 	System.out.println("Elements added to the List...Now validation part.");
					 	for(int cal=0;cal<1;cal++)
					 	{
					 		if(arrList.size()==ColumnValueCount.size())
					 		{
					 			System.out.println("calculation part....");
					 			for(int p=0,fv=0;p<arrList.size();p++)
					 			{
					 				double DevideNumbr=arrList.get(p)/arrList.get(fv);
					 				double ResultNumber=DevideNumbr*100;
					 				//double ResultNumber1=(double) Math.round(ResultNumber * 100) / 100;
					 				
					 				BigDecimal BdDMXY=new BigDecimal(ResultNumber);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									String ResultNumber1=StrDMXY.substring(0,StrDMXY.indexOf("."));
					 				
					 				ExptArrListPercnt.add(ResultNumber1);
					 			}
					 			for(int Res=0;Res<arrList.size();Res++)
					 			{
					 				System.out.println("Element Calculation part...");
					 				if(ActArrListPercnt.get(Res).equals(ExptArrListPercnt.get(Res)))
					 				{
					 					countPass++;
					 					//System.out.println("Elements are equals in both array.");
					 				}
					 				else
					 				{
					 					countFail++;
					 					System.out.println("Elements are not equals in both array.");
					 				}
					 			}
					 			
					 		}
					 		else if(arrList.size()!=ColumnValueCount.size() || arrList.size()==0)
					 		{
					 			//countPass++;
					 			System.out.println("calculation part not required because one cell value is Null(#NV) else No element in the arraylist....");
					 		}
					 		else
					 		{
					 			System.out.println("No conditions are matched....");
					 		}
					 		
					 		
					 	}
					 	 System.out.println("calculaion of PERCENTAGE for the table,passCount are:-"+countPass);
						 System.out.println("calculaion of PERCENTAGE for the table,FailCount are:-"+countFail);
						 Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
					 	break;
					 }
					else
					{
					   System.out.println("PERCENTAGE Row is not found still." );
					}
				 }
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void DeviationMinusXYDynamic(String ChooseMinusRowColumnDeviationXY,String ColumnHeaderXpath,String RowHeaderXpath,int TableNumber)throws InterruptedException, NoSuchElementException
	{
		try
		{
		  Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator(ColumnHeaderXpath));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator(RowHeaderXpath));
		  Utils.waitForElement("");
		
		  if(ChooseMinusRowColumnDeviationXY.equalsIgnoreCase("MinusRowDeviationXY"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION (X-Y)")) 
				  {
					int countPass=0;
					int countFail=0;
					System.out.println("Deviation (x-y calculated element is added to the Column.");
					System.out.println("Deviation (x-y) calculation will perform upto "+i+" column."); 
					Reporter.log("Deviation (x-y) calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationMinusXY;
						String ActDeviationMinusXY;
						String RoundedDeviationMinusXY;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div["+TableNumber+"]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						for(int j=0;j<i;j++)
						{
						   String valuelength=RowElementList.get(j).getText();
						   if(j==(i-2))
						   {
						    if(valuelength.length()==0) 
							 {
						    	System.out.println("Cell "+j+" of "+R+" row having null value.");
						    	DeviationX=0.0;
							 }
							else
							 { 
								String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
								DeviationX = Double.parseDouble(RowElement2);
							 }
						   }
						   else if(j==(i-1))
						   {
						    if(valuelength.length()==0) 
							 {
								 System.out.println("Cell "+j+" of "+R+" row having null value.");
								 DeviationY=0.0;
							 }
						    else
							 { 
						    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
						    	DeviationY = Double.parseDouble(RowElement1);
							 }
						   }
						  }
					    }
						double DeviationMinusXYValue=DeviationX-DeviationY;
						
						BigDecimal BdMax=new BigDecimal(DeviationMinusXYValue);
						BdMax = BdMax.setScale(1, BigDecimal.ROUND_HALF_UP);
						String StrMax=BdMax.toString();
						RoundedDeviationMinusXY=StrMax.substring(0,StrMax.indexOf("."));
						
						//RoundedDeviationMinusXY = (double) Math.round(ExptDeviationMinusXY * 100) / 100;
						System.out.println("Row "+R+" deviation(X-Y) value is: "+RoundedDeviationMinusXY);
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  countPass++;
								  System.out.println("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
								  Reporter.log("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {
								  countPass++;
								  System.out.println("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
								  Reporter.log("Last cell element for Deviation(X-Y) on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else
							  {
								if(LastRowValue.contains("("))
								{
								  System.out.println("Value is more -ve.");
								  Reporter.log("Value is more -ve.");
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  Double NagativeNumber= Double.parseDouble(RowlastElement);
								  double ActDeviationMinusXYValue=-(NagativeNumber);
								  
								  BigDecimal BdDMXY=new BigDecimal(ActDeviationMinusXYValue);
								  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY=BdDMXY.toString();
								  ActDeviationMinusXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationMinusXY);
								}
								else
								{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  double ActDeviationMinusXYValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY=new BigDecimal(ActDeviationMinusXYValue);
								  BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY=BdDMXY.toString();
								  ActDeviationMinusXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationMinusXY);
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationMinusXY.equals(ActDeviationMinusXY))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
						
						Utils.waitForElement("");
						System.out.println("loop "+R+" completed.");
						Reporter.log("loop "+R+" completed.");
					}
					System.out.println("Deviation(x-y) calculation for table rows completed properly.");
					Reporter.log("Deviation(x-y) calculation for table rows completed properly.");
					System.out.println("calculaion of Deviation(x-y) for the table,passcases are:-"+countPass);
					System.out.println("calculaion of Deviation(x-y) for the table,Failcases are:-"+countFail);
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					break;  
				  }
				  else
				  {
					  System.out.println("Deviation(x-y) Column is not found still." );
				  }
			 }
		  }
		  else if(ChooseMinusRowColumnDeviationXY.equalsIgnoreCase("MinusColumnDeviationXY"))
		  {
			 for(int i=0;i<RowHeadersList.size();i++) 
			 {
			   int countPass=0;
			   if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION (X-Y)")) 
			   {
				 System.out.println("Deviation (x-y calculated element is added to the row.");
				 System.out.println("Deviation (x-y) calculation will perform upto "+i+" row."); 
				 List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
				 for(int C=1;C<=ColumnValueCount.size();C++)
				 {
					Double DeviationX = null;
					Double DeviationY = null;
					Double ExptDeviationMinusXY;
					String ActDeviationMinusXY;
					String RoundedDeviationMinusXY = null;
					ArrayList<Double> arrList=new ArrayList<Double>();
					List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div["+TableNumber+"]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
					if(i==0)
					{
				     System.out.println("No row elements are added to the Table.");
				     DeviationX=0.0;
				     DeviationY=0.0;
					}
					else
					{
					  for(int j=0;j<i;j++)
					  {
						 String valuelength=ColumnElementList.get(j).getText();
						 if(j==(i-2))
						 {
							if(valuelength.length()==0) 
							 {
							 	System.out.println("Cell "+j+" of "+C+" column having null value.");
						    	DeviationX=0.0;
							 }
							else
							 { 
								String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
								DeviationX = Double.parseDouble(RowElement2);
							 }
						 }
						 else if(j==(i-1))
						 {
						    if(valuelength.length()==0) 
							 {
								 System.out.println("Cell "+j+" of "+C+" column having null value.");
								 DeviationY=0.0;
							 }
						    else
							 { 
							String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
							DeviationY = Double.parseDouble(RowElement1);
							 }
						  }
					  }
					}
					ExptDeviationMinusXY=DeviationX-DeviationY;
					//RoundedDeviationMinusXY = (double) Math.round(ExptDeviationMinusXY * 100) / 100;
					BigDecimal BdDMXY=new BigDecimal(ExptDeviationMinusXY);
					BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
					String StrDMXY=BdDMXY.toString();
					RoundedDeviationMinusXY=StrDMXY.substring(0,StrDMXY.indexOf("."));
					
					System.out.println("Column "+C+" deviation(X-Y) value is: "+RoundedDeviationMinusXY);
					for(int lr=0;lr<=i;lr++)
					{
					  if(lr==i)
					  {
						  String LastRowValue=ColumnElementList.get(lr).getText();
						  if(LastRowValue.equals("#NV"))
						  {
							  countPass++;
							  System.out.println("Last cell element for Deviation(X-Y) on the "+C+" column is empty.");
						  }
						  else if(LastRowValue.equals("€0.00"))
						  {
							  countPass++;
							  System.out.println("Last cell element for Deviation(X-Y) on the "+C+" column is empty.");
						  }
						  else if(LastRowValue.length()==0)
						  {
							  System.out.println("Expected Deviation(X-Y) value in the "+C+" column is empty i.e having Null value.");
						  } 
						  else
						  {
							  if(LastRowValue.contains("("))
								{
								  System.out.println("Value is more -ve.");
								  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
								  Double NagativeNumber= Double.parseDouble(RowlastElement);
								  double DeviationMinusXYValue=-(NagativeNumber);
								  
								  BigDecimal BdDMXY1=new BigDecimal(DeviationMinusXYValue);
								  BdDMXY1 = BdDMXY1.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY1=BdDMXY1.toString();
								  ActDeviationMinusXY=StrDMXY1.substring(0,StrDMXY1.indexOf("."));
								  
								  System.out.println("Actual Result for "+C+" column is: "+ActDeviationMinusXY);
								}
								else
								{
								  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
								  double DeviationMinusXYValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDMXY1=new BigDecimal(DeviationMinusXYValue);
								  BdDMXY1 = BdDMXY1.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDMXY11=BdDMXY1.toString();
								  ActDeviationMinusXY=StrDMXY11.substring(0,StrDMXY11.indexOf("."));
									
								  System.out.println("Actual Result for "+C+" column is: "+ActDeviationMinusXY);
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationMinusXY.equals(ActDeviationMinusXY))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+C+" column.");
								  }
								  else
								  {
									  System.out.println("Actual and expected result is not same for "+C+" column.");
								  }
							   }
						  }
					  }
					}
					Utils.waitForElement("");
					System.out.println("loop "+C+" completed."); 
				 }
				 System.out.println("Deviation(x-y) calculation for table columns completed properly.");
				 System.out.println("Deviation(x-y) calculation pass count is: "+countPass);
				 Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
				 break;
			   }
			 else
			 {
				 System.out.println("Deviation(x-y) row is not found still.");
			 }
			}
			  
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Deviation(x-y) calculation for table is not completed properly.");
		}
	}
	public void DeviationPercentageXYDynamic(String ChoosePercentageRowColumnDeviationXY,String ColumnHeaderXpath,String RowHeaderXpath,int TableNumber)
	{
		try
		{
		  Utils=new event.Utils(driver);
		  List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator(ColumnHeaderXpath));
		  Utils.waitForElement("");
		  List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator(RowHeaderXpath));
		  Utils.waitForElement("");
		  if(ChoosePercentageRowColumnDeviationXY.equalsIgnoreCase("PercentageRowDeviationXY"))
		  {
			 for(int i=0;i<ColumnHeadersList.size();i++) 
			 {
				  if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (X-Y)/Y")) 
				  {
					int countPass=0;
					int countFail=0;  
					System.out.println("DEVIATION % (X-Y)/Y calculated element is added to the Column.");
					System.out.println("DEVIATION % (X-Y)/Y calculation will perform upto "+i+" column."); 
					Reporter.log("DEVIATION % (X-Y)/Y calculation will perform upto "+i+" column."); 
					List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					for(int R=1;R<=RowValueCount.size();R++)
					{
						Double DeviationX = null;
						Double DeviationY = null;
						Double ExptDeviationPercentageXY;
						String ActDeviationPercentageXY = null;
						String RoundedDeviationPercentageXY = null;
						String InvalidZeroYPercentage = null;
						List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div["+TableNumber+"]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						if(i==0)
						{
					     System.out.println("No Column elements are added to the Table.");
					     Reporter.log("No Column elements are added to the Table.");
					     DeviationX=0.0;
					     DeviationY=0.0;
						}
						else
						{
						  for(int j=0;j<i;j++)
							{
								String valuelength=RowElementList.get(j).getText();
								if(j==(i-2))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationX=0.0;
									}
									else
									{ 
										String RowElement2=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationX = Double.parseDouble(RowElement2);
									}
								}
								else if(j==(i-1))
								{
									if(valuelength.length()==0) 
									{
										System.out.println("Cell "+j+" of "+R+" row having null value.");
										DeviationY=0.0;
									}
									else
									{ 
										String RowElement1=RemoveCharMethod(RowElementList.get(j).getText()).trim();
										DeviationY = Double.parseDouble(RowElement1);
									}
								}
							}
						}
						for(int p=0;p<1;p++)
						{
							if(DeviationY==0.0)
							{
								InvalidZeroYPercentage="100.00 %";
							}
							else
							{
								Double BFDeviationPercentageXY=(DeviationX-DeviationY)/DeviationY;
								System.out.println(BFDeviationPercentageXY);
								//Double BFDeviationPercentageXY1 = (double) Math.round(BFDeviationPercentageXY * 100) / 100;
								//System.out.println(BFDeviationPercentageXY1);
								ExptDeviationPercentageXY=BFDeviationPercentageXY*100;
								System.out.println(ExptDeviationPercentageXY);
								
								BigDecimal BdDPXY=new BigDecimal(ExptDeviationPercentageXY);
								BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								String StrDPXY=BdDPXY.toString();
								RoundedDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
								
								//RoundedDeviationPercentageXY = (double) Math.round(ExptDeviationPercentageXY * 100) / 100;
								System.out.println("Row "+R+" DEVIATION % (X-Y)/Y  value is: "+RoundedDeviationPercentageXY);
							}
						}
						for(int lr=0;lr<=i;lr++)
						{
						  if(lr==i)
						  {
							  String LastRowValue=RowElementList.get(lr).getText();
							  if(LastRowValue.equals("#NV"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.equals("€0.00"))
							  {
								  countPass++;
								  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
								  Reporter.log("Last cell element for DEVIATION % (X-Y)/Y  on the "+R+" row is empty.");
							  }
							  else if(LastRowValue.length()==0)
							  {
								  System.out.println("Expected Product value in the "+R+" row is empty i.e having Null value.");
								  Reporter.log("Expected Product value in the "+R+" row is empty i.e having Null value.");
							  } 
							  else if(LastRowValue.equals("100.00 %"))
							  {
								  System.out.println("Deviation-Y value is Zero.");
								  Reporter.log("Deviation-Y value is Zero.");
								  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroYPercentage);
								  if(PercentageDeviationValue)
								  {
								   countPass++;
								   System.out.println("Value of Percentage Deviation Value for "+R+ "is:-"+PercentageDeviationValue);
								  }
								  else
								  {
									countFail++;
									System.out.println("Value of Percentage Deviation Value for "+R+ "is:-False");
								  }
							  }
							  else
							  {
								if(LastRowValue.contains("%"))
								{
								  String RowlastElement=RemoveCharMethod(RowElementList.get(lr).getText()).trim();
								  double ActDPXYValue= Double.parseDouble(RowlastElement);
								  
								  BigDecimal BdDPXY=new BigDecimal(ActDPXYValue);
								  BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
								  String StrDPXY=BdDPXY.toString();
								  ActDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
								  
								  System.out.println("Actual Result for "+R+" row is: "+ActDeviationPercentageXY);
								}
								else
								{
									System.out.println("This is not a percentage Value.");
								}
							   for(int d=0;d<1;d++)
							   {
								  if(RoundedDeviationPercentageXY.equals(ActDeviationPercentageXY))
								  {
									  countPass++;
									  System.out.println("Actual and expected result is same for "+R+" row.");
									  Reporter.log("Actual and expected result is same for "+R+" row.");
								  }
								  else
								  {
									  countFail++;
									  System.out.println("Actual and expected result is not same for "+R+" row.");
									  Reporter.log("Actual and expected result is not same for "+R+" row.");
								  }
							   }
							 }
						  }
						}
					   Utils.waitForElement("");
					   System.out.println("loop "+R+" completed.");	
					   Reporter.log("loop "+R+" completed.");	
					 }
					System.out.println("DEVIATION % (X-Y)/Y  calculation for table rows completed properly.");
					Reporter.log("DEVIATION % (X-Y)/Y  calculation for table rows completed properly.");
					System.out.println("calculaion of DEVIATION % (X-Y)/Y for the table,passRows are:-"+countPass);
					System.out.println("calculaion of DEVIATION % (X-Y)/Y for the table,FailRows are:-"+countFail);
					
					Assert.assertEquals(countPass,RowHeadersList.size()-1);
					break;  
				  }
				  else
				  {
					  System.out.println("DEVIATION % (X-Y)/Y Column is not found still." );
				  }
			 }
		  }
		  else if(ChoosePercentageRowColumnDeviationXY.equalsIgnoreCase("PercentageColumnDeviationXY"))
		  {
			  for(int i=0;i<RowHeadersList.size();i++) 
				 {
				  int countpass=0;
					 if(RowHeadersList.get(i).getText().equalsIgnoreCase("DEVIATION % (X-Y)/Y")) 
					  {
						System.out.println("DEVIATION % (X-Y)/Y calculated element is added to the row.");
						System.out.println("DEVIATION % (X-Y)/Y calculation will perform upto "+i+" row."); 
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
						for(int C=1;C<=ColumnValueCount.size();C++)
						{
							Double DeviationX = null;
							Double DeviationY = null;
							Double ExptDeviationPercentageXY;
							String ActDeviationPercentageXY = null;
							String RoundedDeviationPercentageXY = null;
							String InvalidZeroYPercentage = null;
							List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div["+TableNumber+"]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
							if(i==0)
							{
						     System.out.println("No row elements are added to the Table.");
						     DeviationX=0.0;
						     DeviationY=0.0;
							}
							else
							{
							  for(int j=0;j<i;j++)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(j==(i-2))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationX=0.0;
										}
										else
										{ 
											String RowElement2=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationX = Double.parseDouble(RowElement2);
										}
									}
									else if(j==(i-1))
									{
										if(valuelength.length()==0) 
										{
											System.out.println("Cell "+j+" of "+C+" column having null value.");
											DeviationY=0.0;
										}
										else
										{ 
											String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText()).trim();
											DeviationY = Double.parseDouble(RowElement1);
										}
									}
								}
							}
							for(int p=0;p<1;p++)
							{
								if(DeviationY==0.0)
								{
									InvalidZeroYPercentage="100.00 %";
								}
								else
								{
									Double BFDeviationPercentageXY=(DeviationX-DeviationY)/DeviationY;
									System.out.println(BFDeviationPercentageXY);
									ExptDeviationPercentageXY=BFDeviationPercentageXY*100;
									System.out.println(ExptDeviationPercentageXY);
									
									BigDecimal BdDPXY=new BigDecimal(ExptDeviationPercentageXY);
									BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDPXY=BdDPXY.toString();
									RoundedDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
									
									//RoundedDeviationPercentageXY = (double) Math.round(ExptDeviationPercentageXY * 100) / 100;
									System.out.println("Row "+C+" DEVIATION % (X-Y)/Y  value is: "+RoundedDeviationPercentageXY);
								}
							}
							for(int lr=0;lr<=i;lr++)
							{
							  if(lr==i)
							  {
								  String LastRowValue=ColumnElementList.get(lr).getText();
								  if(LastRowValue.equals("#NV"))
								  {
									  countpass++;
									  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.equals("€0.00"))
								  {
									  countpass++;
									  System.out.println("Last cell element for DEVIATION % (X-Y)/Y  on the "+C+" column is empty.");
								  }
								  else if(LastRowValue.length()==0)
								  {
									  System.out.println("Expected Product value in the "+C+" column is empty i.e having Null value.");
								  } 
								  else if(LastRowValue.equals("100.00 %"))
								  {
									  System.out.println("Deviation-Y value is Zero.");
									  Boolean PercentageDeviationValue=LastRowValue.equals(InvalidZeroYPercentage);
									  if(PercentageDeviationValue)
									  {
										  countpass++;
									   System.out.println("Value of Percentage Deviation Value for "+C+ "is:-"+PercentageDeviationValue);
									  }
									  else
									  {
										System.out.println("Value of Percentage Deviation Value for "+C+ "is:-False");
									  }
								  }
								  else
								  {
									if(LastRowValue.contains("%"))
									{
									  String RowlastElement=RemoveCharMethod(ColumnElementList.get(lr).getText()).trim();
									  double ActDeviationPercentageXYValue= Double.parseDouble(RowlastElement);
									  
									  BigDecimal BdDPXY=new BigDecimal(ActDeviationPercentageXYValue);
									  BdDPXY = BdDPXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									  String StrDPXY=BdDPXY.toString();
									  ActDeviationPercentageXY=StrDPXY.substring(0,StrDPXY.indexOf("."));
									  
									  System.out.println("Actual Result for "+C+" column is: "+ActDeviationPercentageXY);
									}
									else
									{
										System.out.println("This is not a percentage Value.");
									}
								   for(int d=0;d<1;d++)
								   {
									  if(RoundedDeviationPercentageXY.equals(ActDeviationPercentageXY))
									  {
										  countpass++;
										  System.out.println("Actual and expected result is same for "+C+" column.");
									  }
									  else
									  {
										  System.out.println("Actual and expected result is not same for "+C+" column.");
									  }
								   }
								 }
							  }
							}
						   Utils.waitForElement("");
						   System.out.println("loop "+C+" completed.");	
						 }
						System.out.println("DEVIATION % (X-Y)/Y  calculation for table columns completed properly.");
						System.out.println("count for DEVIATION % (X-Y)/Y is "+countpass);
						Assert.assertEquals(countpass,ColumnHeadersList.size()-1);
						break;  
					  }
					  else
					  {
						  System.out.println("DEVIATION % (X-Y)/Y row is not found still." );
					  }
				 }
		  }
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("DEVIATION % (X-Y)/Y calculation for table is not completed properly.");
		}
	}
	
	public void PercentageStackedValidation(String ChooseRowColumnPercentage)throws InterruptedException, NoSuchElementException
	{
		try
		{
			Utils=new event.Utils(driver);
			List<WebElement> ColumnHeadersList = driver.findElements(ConfigReader.getObjectLocator("ColumnHeaderTextListXpath"));
			Utils.waitForElement("");
			List<WebElement> RowHeadersList = driver.findElements(ConfigReader.getObjectLocator("RowHeaderTextListXpath"));
			Utils.waitForElement("");
			if(ChooseRowColumnPercentage.equalsIgnoreCase("ColumnPercentage"))
			{
				for(int i=0;i<ColumnHeadersList.size();i++)
				 {
					if(ColumnHeadersList.get(i).getText().equalsIgnoreCase("PERCENTAGE STACKED"))
					 {
						int countPass=0;
						int countFail=0;
						System.out.println("PERCENTAGE calculated element is added to the Column.");
						Reporter.log("PERCENTAGE calculated element is added to the Column.");
						System.out.println("PERCENTAGE calculation will perform upto "+i+" column.");
						Reporter.log("PERCENTAGE calculation will perform upto "+i+" column.");
						
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<String> ActArrListPercnt=new ArrayList<String>();
						ArrayList<String> ExptArrListPercnt=new ArrayList<String>();
					 	List<WebElement> RowValueCount=driver.findElements(ConfigReader.getObjectLocator("RowValuecellNumberXpath"));
					 	for(int R=1;R<=RowValueCount.size();R++)
						{
						  List<WebElement> RowElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div["+R+"]/div"));
						  if(i==0)
						  {
								System.out.println("No Column elements are added to the Table.");
								Reporter.log("No Column elements are added to the Table.");
						  }
						  else
						  {
							 for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=RowElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+R+" row having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(RowElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous Column is not found");
								}
							 }
							 for(int lr=0;lr<=i;lr++)
							 {
								 if(lr==i)
								 {
									String LastRowValue=RowElementList.get(lr).getText();
									if(LastRowValue.equals("#NV") || LastRowValue.equals("€0.00"))
									 {
											countPass++;
											System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 }
									else if(LastRowValue.length()==0)
									 {
										countPass++;
										System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 } 
									else
									 {
										String lastRowElement=RemoveCharMethod(RowElementList.get(lr).getText());
								    	double lastRowElement1Value = Double.parseDouble(lastRowElement);
								    	
								    	BigDecimal BdDMXY=new BigDecimal(lastRowElement1Value);
										BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
										String StrDMXY=BdDMXY.toString();
										String lastRowElement1=StrDMXY.substring(0,StrDMXY.indexOf("."));
								    	
								    	ActArrListPercnt.add(lastRowElement1);
									 }
									  
								 }
							 }
						   }
						  System.out.println("loop "+R+" completed.");
						}
					 	
					 	System.out.println("Elements added to the List...Now validation part.");
					 	for(int cal=0;cal<1;cal++)
					 	{
					 		if(arrList.size()==RowValueCount.size())
					 		{
					 			System.out.println("calculation part....");
					 			for(int p=0,fv=0;p<arrList.size();p++)
					 			{
					 				double DevideNumbr=arrList.get(p)/arrList.get(fv);
					 				double ResultNumber=DevideNumbr*100;
					 				//double ResultNumber1=(double) Math.round(ResultNumber * 100) / 100;
					 				
					 				BigDecimal BdDMXY=new BigDecimal(ResultNumber);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									String ResultNumber1=StrDMXY.substring(0,StrDMXY.indexOf("."));
					 				
					 				ExptArrListPercnt.add(ResultNumber1);
					 			}
					 			for(int Res=0;Res<arrList.size();Res++)
					 			{
					 				System.out.println("Element Calculation part...");
					 				if(ActArrListPercnt.get(Res).equals(ExptArrListPercnt.get(Res)))
					 				{
					 					countPass++;
					 					//System.out.println("Elements are equals in both array.");
					 				}
					 				else
					 				{
					 					countFail++;
					 					System.out.println("Elements are not equals in both array.");
					 				}
					 			}
					 			
					 		}
					 		else if(arrList.size()!=RowValueCount.size() || arrList.size()==0)
					 		{
					 			//countPass++;
					 			System.out.println("calculation part not required because one cell value is Null(#NV) else No element in the arraylist....");
					 		}
					 		else
					 		{
					 			System.out.println("No conditions are matched....");
					 		}
					 		
					 		
					 	}
					 	 System.out.println("calculaion of PERCENTAGE STACKED for the table,passCount are:-"+countPass);
						 System.out.println("calculaion of PERCENTAGE STACKED for the table,FailCount are:-"+countFail);
						 Assert.assertEquals(countPass,RowHeadersList.size()-1);
					 	break;
					 }
					else
					{
					   System.out.println("PERCENTAGE STACKED Column is not found still." );
					}
				 }
			}
			else if(ChooseRowColumnPercentage.equalsIgnoreCase("RowPercentage"))
			{
				for(int i=0;i<RowHeadersList.size();i++)
				 {
					if(RowHeadersList.get(i).getText().equalsIgnoreCase("PERCENTAGE STACKED"))
					 {
						int countPass=0;
						int countFail=0;
						System.out.println("PERCENTAGE STACKED calculated element is added to the Row.");
						Reporter.log("PERCENTAGE STACKED calculated element is added to the Row.");
						System.out.println("PERCENTAGE STACKED calculation will perform upto "+i+" Row.");
						Reporter.log("PERCENTAGE STACKED calculation will perform upto "+i+" Row.");
						
						ArrayList<Double> arrList=new ArrayList<Double>();
						ArrayList<String> ActArrListPercnt=new ArrayList<String>();
						ArrayList<String> ExptArrListPercnt=new ArrayList<String>();
						List<WebElement> ColumnValueCount=driver.findElements(ConfigReader.getObjectLocator("ColumnValuecellNumberXpath"));
					 	for(int C=1;C<=ColumnValueCount.size();C++)
						{
						  List<WebElement> ColumnElementList=driver.findElements(By.xpath("//div[@class='dojoSplitContainer']/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/div/div["+ C + "]"));
						  if(i==0)
						  {
								System.out.println("No row elements are added to the Table.");
								Reporter.log("No row elements are added to the Table.");
						  }
						  else
						  {
							 for(int j=0;j<i;j++)
						      {
								if(j==i-1)
								{
									String valuelength=ColumnElementList.get(j).getText();
									if(valuelength.length()==0)
									{
								      System.out.println("Cell "+j+" of "+C+" Column having null value.");
									}
									else
									{
							    	String RowElement1=RemoveCharMethod(ColumnElementList.get(j).getText());
							    	double RowElement2 = Double.parseDouble(RowElement1);
							    	arrList.add(RowElement2);
									}
									break;
								}
								else
								{
									System.out.println("Previous row is not found");
								}
							 }
							 for(int lr=0;lr<=i;lr++)
							 {
								 if(lr==i)
								 {
									String LastRowValue=ColumnElementList.get(lr).getText();
									if(LastRowValue.equals("#NV") || LastRowValue.equals("€0.00"))
									 {
											countPass++;
											System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 }
									else if(LastRowValue.length()==0)
									 {
										countPass++;
										System.out.println("No calculation needed because last cell value is:-"+LastRowValue);
									 } 
									else
									 {
										String lastRowElement=RemoveCharMethod(ColumnElementList.get(lr).getText());
								    	double lastRowElement1Value = Double.parseDouble(lastRowElement);
								    	
								    	BigDecimal BdDMXY=new BigDecimal(lastRowElement1Value);
										BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
										String StrDMXY=BdDMXY.toString();
										String lastRowElement1=StrDMXY.substring(0,StrDMXY.indexOf("."));
								    	
								    	ActArrListPercnt.add(lastRowElement1);
									 }
									  
								 }
							 }
						   }
						  System.out.println("loop "+C+" completed.");
						}
					 	
					 	System.out.println("Elements added to the List...Now validation part.");
					 	for(int cal=0;cal<1;cal++)
					 	{
					 		if(arrList.size()==ColumnValueCount.size())
					 		{
					 			System.out.println("calculation part....");
					 			for(int p=0,fv=0;p<arrList.size();p++)
					 			{
					 				double DevideNumbr=arrList.get(p)/arrList.get(fv);
					 				double ResultNumber=DevideNumbr*100;
					 				//double ResultNumber1=(double) Math.round(ResultNumber * 100) / 100;
					 				
					 				BigDecimal BdDMXY=new BigDecimal(ResultNumber);
									BdDMXY = BdDMXY.setScale(1, BigDecimal.ROUND_HALF_UP);
									String StrDMXY=BdDMXY.toString();
									String ResultNumber1=StrDMXY.substring(0,StrDMXY.indexOf("."));
					 				
					 				ExptArrListPercnt.add(ResultNumber1);
					 			}
					 			for(int Res=0;Res<arrList.size();Res++)
					 			{
					 				System.out.println("Element Calculation part...");
					 				if(ActArrListPercnt.get(Res).equals(ExptArrListPercnt.get(Res)))
					 				{
					 					countPass++;
					 					//System.out.println("Elements are equals in both array.");
					 				}
					 				else
					 				{
					 					countFail++;
					 					System.out.println("Elements are not equals in both array.");
					 				}
					 			}
					 			
					 		}
					 		else if(arrList.size()!=ColumnValueCount.size() || arrList.size()==0)
					 		{
					 			//countPass++;
					 			System.out.println("calculation part not required because one cell value is Null(#NV) else No element in the arraylist....");
					 		}
					 		else
					 		{
					 			System.out.println("No conditions are matched....");
					 		}
					 		
					 		
					 	}
					 	 System.out.println("calculaion of PERCENTAGE STACKED for the table,passCount are:-"+countPass);
						 System.out.println("calculaion of PERCENTAGE STACKED for the table,FailCount are:-"+countFail);
						 Assert.assertEquals(countPass,ColumnHeadersList.size()-1);
					 	break;
					 }
					else
					{
					   System.out.println("PERCENTAGE STACKED Row is not found still." );
					}
				 }
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}