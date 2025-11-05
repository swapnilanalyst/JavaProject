package javaBacis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A {
	
public static void main(String[] args) {
	
	
	List <String>list = Arrays.asList("test", "Automation", "Selenium", "selenium", "test");
	
	Collections.sort(list);
	
//	String store = "";
	
	for(int i =0 ; i<list.size()-1; i++) {
		
		
		if (list.get(i).equals(list.get(i+1))) {
            System.out.println("\nDuplicate: " + list.get(i));
        }
		
	
	}
		
	}
	
}

