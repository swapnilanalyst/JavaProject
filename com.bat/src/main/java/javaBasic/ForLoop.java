package javaBasic;

import java.util.List;

import org.openqa.selenium.WebElement;

import utils.Helper;

public class ForLoop {

	
	
	
	 public static void main(String[] args) {
		
		 Helper h= new Helper();
		 h.setup("https://www.hyrtutorials.com/p/basic-controls.html");
		
		 List<WebElement> checkBoxesList = h.getElementsByXPath("//input[@type='checkbox']");
		 
		 int list= checkBoxesList.size();
		 
		 
		//For all value selection
		 
//		 for(int i= 0; i<list; i++) {
//			 
//			 checkBoxesList.get(i).click();
//			 
//			 
//		 }
		 
		 //for even value selection
//		 
//		 for(int i=0; i<list; i++) {
//			 
//			 if( i % 2==0) {
//				 
//				 checkBoxesList.get(i).click();
//			 }
//		 }
		 
		 //for odd value selection
//		 
//		 for(int i=0; i<list; i++) {
//			 
//			 if(i % 2 != 0) {
//				 
//				 checkBoxesList.get(i).click();
//				 
//			 }
//		 }
//		 
//		 //Starting 2 value selection
//		 
//		 for(int i=0; i<2; i++) {
//			 
//			 checkBoxesList.get(i).click();
//		 }
		 
		 //last 2 value section
		 for(int i=list-2; i<list; i++) {
			 
			 checkBoxesList.get(i).click();
		 }

	}

}
