package javaBacis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionJava {

	public static void main(String[] args) {
		dplicateListValue();

	}
	
	// Find Duplicate value form arraylist 
	
	
	//1. using Set collection
	public static void  dplicateListValue() {
		
		Set <String>s = new HashSet();
		
		List <String>list = Arrays.asList("test", "Automation", "Selenium", "Playwright", "test");
		
		for(int i=0; i<list.size();i++) {
			
			String x = list.get(i);
			
			
			if (!s.add(x)) {
				System.out.println(s);
	            System.out.println("Duplicate Value: "+x);
	        }
			
		}
		
	}

}
