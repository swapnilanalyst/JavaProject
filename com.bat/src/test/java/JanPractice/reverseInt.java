package JanPractice;

public class reverseInt {

    public static void main(String[] args) {


        long num = 123456;
        long rev = 0;
        while (num != 0) {

            rev = rev * 10 + num % 10;
            num = num / 10;
        }
        System.out.println("Reverse integer::"+rev);

        // Reverse Integer using string buffer
        long num1= 1234567;
        System.out.println("Reverse String using StringBuffer::" + new StringBuffer(String.valueOf(num1)).reverse());

        }

    }

