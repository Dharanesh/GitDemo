package features;

import org.openqa.selenium.By;

public class Sample {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String Parent_Filter_Tab="363.813px";
		String Parent_1=Parent_Filter_Tab.replaceAll("px","").trim();
		int Parent_2=(int) Double.parseDouble(Parent_1);
		System.out.println("Parent Filter height:="+Parent_2);
		
		String SubChild_Type_Tab="28px";
		String SubChild=SubChild_Type_Tab.replaceAll("px","").trim();
		int SubChild_2=Integer.parseInt(SubChild);
		System.out.println("SubChild_Type_Tab:="+SubChild_2);		
		
		String Sub_Filter_Tab="335.813px";
		String Sub_Filter_1=Sub_Filter_Tab.replaceAll("px","").trim();
		int Sub_Filter_2=(int) Double.parseDouble(Sub_Filter_1);
		System.out.println("Sub_Filter_Tab:="+Sub_Filter_2);
		
		
	}

}
