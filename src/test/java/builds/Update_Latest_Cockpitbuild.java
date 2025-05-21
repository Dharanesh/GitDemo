package builds;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import org.testng.annotations.Test;
import junit.framework.Assert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Update_Latest_Cockpitbuild 
{
	event.Excelnput Excelnput=new event.Excelnput();
	String PackageLoc=System.getProperty("user.dir");
	
  @Test
  public void Latest_Build_Download() throws Exception
  {
	  //Latest File:===============
	  int count_1=0;
	  //String path="\\"+"\\"+"cwpest01\\Builds\\Cubeware\\Cockpit\\Cockpit R9.2";
	  //String FilePath=Excelnput.ExcelDatainput("ExeFileLocation",1,1);
	  String FilePath="\\"+"\\"+"cwpest01\\builds\\Cubeware\\Cockpit\\Cockpit 10 - R9.4.2";
	  //String FilePath="\\"+"\\"+"192.168.103.10\\QA_Team\\Test Builds\\Builds\\Cockpit builds\\R9.4.1";
	  Thread.sleep(2000);
	  
	  
	  File dir = new File(FilePath);
	  File[] files = dir.listFiles();
	  File lastModified = Arrays.stream(files).filter(File::isDirectory).max(Comparator.comparing(File::lastModified)).orElse(null);
	  System.out.println(lastModified);
	  
	  String LatestFile=lastModified+"\\Setup";
	  //String LatestFile=lastModified+"\\";
	  System.out.println(LatestFile);
	  
	  File file = new File(LatestFile);
	  File[] file_Exe = file.listFiles();
	  Thread.sleep(2000);
	  System.out.println("Required Exe file is:"+"Cockpit10.exe");
	  
	  for(File f: file_Exe)
	  {
		  System.out.println(f.getName());
		  if(f.getName().equals("Cockpit10.exe"))
		  {
			  count_1++;
		  }
	  }	
	  Assert.assertEquals(count_1,1);
	  System.out.println("Cockpit10.exe"+" is available..");
	  Thread.sleep(2000);
	  
	  //Source:=======================
	  //String Source=Excelnput.ExcelDatainput("ExeFileLocation",2,1);
	  String Source=LatestFile+"\\"+"Cockpit10.exe";
	  System.out.println("Source Dir is:-"+Source);
	  File SourceFile=new File(Source);
	  
	  //Destination:===================
	  //String Destination=Excelnput.ExcelDatainput("ExeFileLocation",2,1)+"\\"+Excelnput.ExcelDatainput("ExeFileLocation",3,1);
	  //String Destination="C:\\Users\\I_TPR\\git_1\\QSAutomation\\TestBuilds_Location"+"\\"+"Cockpit10.exe";
	  //String Destination=PackageLoc+"/TestBuilds_Location"+"\\"+"Cockpit10.exe";
	  String Destination="C:\\Users\\I_QSA\\Desktop\\BuildFolder"+"\\"+"Cockpit10.exe";
	  System.out.println("Destination Dir is:-"+Destination);
	  Thread.sleep(1000);
	  File DestinationFile=new File(Destination);
	  
	  //Code For File Copy:==================================
	  Update_Latest_Cockpitbuild Move=new Update_Latest_Cockpitbuild();
	  Move.FileMoving(SourceFile,DestinationFile);
	  
	  File F2=new File(Destination);
	  System.out.println("Done with Required file copy.");
	  
	  long s1=SourceFile.length();
	  System.out.println(s1);
		
	  long s2=F2.length();
	  System.out.println(s2);
	  
	  boolean exists = new File(Destination).exists();
	  
	  int count=0;
	  if (exists) 
	  {
        System.out.println("File exists..");
        count++;
	  }
	  else
	  {
    	System.out.println("File does not exists..");
	  }
	 //Length Comparison from both file:============= 
	 if (s1==s2) 
	 {
		 System.out.println("Both File size is Equal..");
		 count++;
	 }
	 else
	 {
		 System.out.println("Both File size is not Equal..");
	 }
	 Assert.assertEquals(count,2);
	 System.out.println("File Copy paste Done with Required file copy.");
	  
   }
  
   public void FileMoving(File source, File dest) throws IOException
	{

       Files.copy(source.toPath(), dest.toPath(),StandardCopyOption.REPLACE_EXISTING);
		
	}
  
}
