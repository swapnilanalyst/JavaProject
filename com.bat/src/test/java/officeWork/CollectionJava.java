package officeWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionJava {

	public static void main(String [] args) {


//		Integer s = "automation";
//		
//		char []c =s.toCharArray();
		
//		Integer [] s= {"Test", "react", "test", "automation", "react"};
		
		 int[] s = {1, 2, 2, 5, 5, 6, 3, 5};
		
		Map<Integer, Integer> map = new HashMap();
		
		for(Integer ch :s) {
			
			if(map.containsKey(ch)) {
				
				map.put(ch, map.get(ch)+1);
			}else {
				
				map.put(ch, 1);
			}
		}
		
//		System.out.println(map);
		
		Set<Entry<Integer, Integer>> entry= map.entrySet();
		
		
		for(Entry<Integer, Integer> e: entry) {
			
			if(e.getValue()>=1) {
				
				System.out.println(e.getKey()+": "+e.getValue());
			}
		}

	}

}
