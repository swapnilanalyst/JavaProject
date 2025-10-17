package javaBacis;

import java.util.Scanner;

public class Tablee {

	public static void main(String[] args) {
		
	Tablee tb = new Tablee();
	tb.table();
	}
	
	
	
	public void table() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your number");
        int num = sc.nextInt();
        
        for(int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
	}
	
	
	public void oddNum() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your number");
        int num = sc.nextInt();
		for (int i =1; i<=num;i++) {
			
			
		}
	}
	}