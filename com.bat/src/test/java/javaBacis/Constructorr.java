package javaBacis;

import relation.Address;

public class Constructorr {
	
//	
	String name;
	int age;
	int empId;
	static String companyName = "Redvision";
	Address address;
//	
//	 Constructorr(){ 
//		 System.out.println("Hello");
//	 };
//	  
	 Constructorr(String name, int age, int empId, Address address){
		  
		 this.name = name;
		 this.age = age;
		 this.empId = empId;	 
		 this.address= address;
		 												
	 }
	 
	

	public static void main(String[] args) {
		Address officeAddress = new Address("Pune", "Maharashtra", "India");
        Address homeAddress = new Address("Nagpur", "Maharashtra", "India");
        Address a1 = new Address("Pune", "MH", "India");

        
        Constructorr ts = new Constructorr("Rahul", 25, 123, homeAddress);
        ts.test();
        

//        System.out.println(officeAddress);
//        System.out.println(homeAddress);
//       
  
	}
	
																																			
	public void test() {
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(empId);
		System.out.println(companyName);
		System.out.println(address);
	}

}
