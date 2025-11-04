package JavaPractise;

public class practise {

	public static void main(String[] args) {

		// Palindrom

//		String s = "madam";
//
//		int l = s.length();
//
//		String rev = "";
//
//		for (int i = l - 1; i >= 0; i--) {
//
//			rev = rev + s.charAt(i);
//			
//
//		}
//		System.out.println(rev);
//
//		if (rev.equals(s)) {
//
//			System.out.println("this is palindrom");
//		} else {
//
//			System.out.println("this is not palinddrom");
//		}

		
		String a = "This is automation testing";
		
		StringBuilder sb = new StringBuilder(a);
		
		String b = sb.reverse().toString();
		sb.ensureCapacity(100);
		
		System.out.println("Current capacity: " + sb.capacity());
		
		
        String[] str = b.split(" ");
        
        StringBuilder rev = new StringBuilder();
        
		int len = str.length;
		String c= "";
		
		for(int i =len-1; i>=0;i--) {
			
			 c = rev.append(str[i]).append(" ").toString();
		}
		
		System.out.println(c);
		
		
		
	}

}
