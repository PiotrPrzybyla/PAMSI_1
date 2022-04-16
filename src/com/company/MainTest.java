package com.company;

import java.util.ArrayList;
import java.util.Random;



public class MainTest {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args){



        ArrayList<String> testMessages = new ArrayList();
        Sender testSender = new Sender();
        Recipient testRecipient = new Recipient();
        Server testServer = new Server();
        int testNumber = 10000;
        int errors = 0;
        System.out.println(ANSI_PURPLE + testNumber + " tests were done" + ANSI_PURPLE);
        for (int i = 0; i < testNumber; i++) {
            int stringLength = (int)(Math.random()*1000 + 1);

            int leftLimit = 48; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = stringLength;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(j -> (j <= 57 || j >= 65) && (j <= 90 || j >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            testMessages.add(generatedString);
            testSender.setMessage(generatedString);
            String sortedString = testServer.testMessage(testSender,testRecipient, 10);

            if(!sortedString.equals(generatedString)){

                errors++;
                System.out.println(ANSI_RED + "Error " + errors + ": ");
                System.out.println("Generated message: ");
                System.out.println(generatedString);
                System.out.println("Sorted message: ");
                System.out.println(sortedString + ANSI_RED);
            }


        }
        if (errors == 0){
            System.out.println(ANSI_BLUE + "There were 0 errors" + ANSI_BLUE);
        }else   {
            System.out.println(ANSI_RED + "There were "+errors +" errors" + ANSI_RED);
        }





    }
}
