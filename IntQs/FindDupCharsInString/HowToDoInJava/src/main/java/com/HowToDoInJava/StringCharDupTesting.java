package main.java.com.HowToDoInJava;

public class StringCharDupTesting {

    public static void main(String[] args){
        String testData="";
        testData = "01234543210";
        testPalUsingReverse(testData);
        testData = "-Test Pal Using Reverse-";
        testPalUsingReverse(testData);
        String [] testDataArray = new String [] {"This is Input","WhatIssItahW", "0123443210", "01234543210", "-Test Pal. How do I Look-"};

       for (String strTemp : testDataArray) {
           if (isPalindrome(strTemp)){
               System.out.println(strTemp +" Passed the isPalindrome test");
           }else {
               System.out.println(strTemp +" Failed the isPalindrome test");
           }
       }


//        testData = "This Is Input";
//        if (isPalindrome(testData)){
//            System.out.println(testData +" Passed the isPalindrome test");
//        }else {
//            System.out.println(testData +" Failed the isPalindrome test");
//        }
//
//        testData = "WhatIssItahW";
//        if (isPalindrome(testData)){
//            System.out.println(testData +" Passed the isPalindrome test");
//        }else {
//            System.out.println(testData +" Failed the isPalindrome test");
//        }
//
//
//        testData ="0123443210";
//        if (isPalindrome(testData)){
//            System.out.println(testData +" Passed the isPalindrome test");
//        }else {
//            System.out.println(testData +" Failed the isPalindrome test");
//        }
//
//
//        testData ="01234543210";
//        if (isPalindrome(testData)){
//            System.out.println(testData +" Passed the isPalindrome test");
//        }else {
//            System.out.println(testData +" Failed the isPalindrome test");
//        }

    }// end of Main

   public static void testPalUsingReverse(String inputValue){
       String testValue="";

       testValue = reverse(inputValue);
       if (inputValue.equals(testValue)) {
           System.out.print("testPalUsingReverse(); success. ");
           System.out.println(inputValue +" is equal to " +testValue);

       }
       else {
           System.out.print("testPalUsingReverse(); failure. ");
           System.out.println(inputValue +" is not equal to " +testValue);
       }
   }


    public static String reverse(String input){
        String output="";
        for(int x = input.length()-1 ; x >=0 ; x-- ) {
            output += input.charAt(x);
        }
        return output;
    }

   public static boolean isPalindrome(String input){
        boolean returnVal=true;
        int locA=0, locB=0;
        for(int x = 0, y = input.length()-1 ; x <= input.length() && y >= 0 ; x++, y--) {
            if (input.charAt(x) != input.charAt(y)) {
            // debug:    System.out.println("Fail with: " +input +" chars loc " +x +" " +y);
                returnVal=false;
                break;
            }
        }
        // debug: System.out.println(input +" is not a palindrome");
        // debug:  System.out.println("error at locations "+locA +" " +locB);

        return returnVal;
   }

} // end of class
