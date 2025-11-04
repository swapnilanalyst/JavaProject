package javaBacis;

public class Strings {
	
	public static void main(String[] args) {
		
//		trimString();
//		replaceString();
//		reverseString();
//		substringg();
//		toChararray();
		splitString();
		
	}
	
	
	public  static void trimString() {
		
		String s = "   Automation   ";
				
		String cleanString  = s.trim();
		System.out.println(cleanString);
		
	}
	
	
	public static void replaceString() {
		
		String s  = "Manual Testing";
		String newString= s.replaceAll(s, "Automation Testing");
		System.out.println(newString);
	}
	
	public static void reverseString() {
		
		String s = "Java Test";
		int len= s.length();
		String rev = "";
		
		for(int i=len-1; i>=0; i--) {
			
			rev= rev+s.charAt(i);
		}
		System.out.println(rev);
		
	}
	
	
	public static void concatt() {
		
		String a = "Hello";
		String b= "World";
		int x = 10;
		int y = 20;
		
		System.out.println(a+b+(x+y));
		
	}
	
	
	public static void substringg() {
		
		String s = "Automation Testing";
		
		String b = "Manual Testing";
		
		s= s+b;  //Automation TestingManual Testing
		
		b= s.substring(0, s.length()-b.length());
		System.out.println("Value of b: " + b);
		
		s= s.substring(b.length());
		System.out.println("Value of s: " + s);
	}
	
	public static void toChararray() {
		
		String s = "Hello";
		char [] c= s.toCharArray();
		int len = c.length;
		
		for(int i=0; i<len;i++) {
		System.out.println("toChararray Output: "+c[i]);
		}
	}
	
	public static void splitString() {
		
		String s = "Hello World";
		
		String [] k =s.split("");
		
		for(int i=0; i<k.length; i++) {
		System.out.println(k[i]);
		}
	}

}
