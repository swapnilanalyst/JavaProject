package JanPractice;

public class StringPractice {


    public static void main(String[] args) {
        //1. Reverse a String without using StringBuffer/StringBuilder
        String s = "Sourabh";
        int len= s.length();
        String rev = "";

        for(int i=len-1; i>=0; i--){
            rev = rev+ s.charAt(i);
        }
        System.out.println("Reverse String: "+rev);

        //2 reverse string using StringBuffer
        StringBuffer sf = new StringBuffer(s);
        System.out.println("Reverse String using StringBuffer: "+sf.reverse());

        //3. Remove Junk Char or unwanted char
        String s2 = "@#@#Aut@#&%omation12364";
        s2= s2.replaceAll("[^a-zA-z0-9]","");
        System.out.println("clean string: " + s2);
    }






}