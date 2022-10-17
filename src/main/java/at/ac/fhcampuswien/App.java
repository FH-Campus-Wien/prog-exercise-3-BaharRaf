package at.ac.fhcampuswien;
import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;

public class App {

    // Implement all methods as public static
    public static void oneMonthCalendar( int days, int beginDay){
        int count = 1;
        int column = beginDay;
        int row;
        if ((days + beginDay) % 7 != 0){

            row = (days / 7 ) + 1;

        } else {

            row = days / 7;

        }

        for (int i = 1; i < beginDay; i++){

            System.out.print("   ");

        }




        for (int j = 0; j < row; j++){

            while (column <= 7) {

                System.out.printf("%2d ", count);

                if (count == days){

                    System.out.println();

                    return;

                }

                column++;

                count++;

            }

            column = 1;

            System.out.println();

        }

    }


    //2
    public static long[] lcg( long seed){
        long m =((long) Math.pow(2,31));
        long c =12345;
        long a =1103515245;
        long[] randomNumbers = new long[10];
        randomNumbers[0] = (a * seed + c) % m;
        for (int i = 1; i < randomNumbers.length; i++){
            randomNumbers[i] = (a * randomNumbers[i-1] + c) % m;
        }
        for ( long num : randomNumbers){
            System.out.println( num + " ");
        }

        return randomNumbers;
    }
    //3
    public static void guessingGame( int numberToGuess){


        //Math.random()=(0...1)*100;
        int g;
        Scanner scn = new Scanner(System.in);
        for( int i = 0; i < 10; i++){
            System.out.print("Guess number " + (i + 1) + ": ");
            g = scn.nextInt();
            if (i == 10-1){
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
            if (g > numberToGuess){
                System.out.println("The number AI picked is lower than your guess.");
            } else if ( g < numberToGuess) {
                System.out.println("The number AI picked is higher than your guess.");
            }else {
                System.out.println("You won wisenheimer!");
                break;
            }

        }
    }
    public static int randomNumberBetweenOneAndHundred(){

        Random r = new Random();
        return r.nextInt(100)+1;
    }
    //4
    //swapNumbers
    public static boolean swapArrays(int[] one, int[] two){

        if (one.length != two.length){

            return false;

        }

        for (int i = 0; i < one.length; i++){

            one[i] += two[i];
        }
        for (int i = 0; i < one.length; i++){

            two[i] = one[i] - two[i];
        }
        for (int i = 0; i < one.length; i++){

            one[i] -= two[i];
        }


        return true;

    }



    //5
    public static String camelCase(String txt){
        char[] txtCh = txt.toCharArray();
        if (txtCh[0] >= 97 && txtCh[0] <= 123){
            txtCh[0] = (char)(txtCh[0] - 32);
        }
        for (int i =0 ; i < txtCh.length;i++){
            if (i >= 1 && txtCh[i-1] != ' ' && txtCh[i]>= 65 && txtCh[i] <= 90 ){
                txtCh[i] += 32;
            }if (i >= 1 && txtCh[i-1] == ' ' && txtCh[i]>= 97 && txtCh[i] <= 122){
                txtCh[i] -= 32;
            }

        }
        for (int i = 0; i < txtCh.length; i++) {

            if ((txtCh[i] > 0 && txtCh[i] <= 64) || (txtCh[i] >= 91 && txtCh[i] <= 96) || (txtCh[i] >= 123 && txtCh[i] <= 127)){

                txtCh[i] = 32;

            }

        }

        return String.valueOf(txtCh).replaceAll(" ","");
    }
    //6
    public static int checkDigit(int[] array1){
        int w = 2;
        int s = 0;
        int m;
        for (int i = 0; i < array1.length; i++){
            s += array1[i] * (w + i);
        }
        m = s % 11;
        if (11-m == 10)
            return 0;
        if (11-m == 11)
            return 5;

        return 11-m;

    }


    public static void main(String[] args) {
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
        App excercise3 = new App();
        System.out.println("Task 1: Largest Number");
        excercise3.oneMonthCalendar(31,3);

        System.out.println("\nTask 2: lcg");
        excercise3.lcg(12345);

        System.out.println("\nTask 3: Guessing Game");
        excercise3.guessingGame(randomNumberBetweenOneAndHundred());

        System.out.println("\nTask 4: Swap Number");
        int[] one = new int[]{1,2,3,4,5,6};
        int[] two = new int[]{100,202,30,14,15,16};
        excercise3.swapArrays(one, two);


        System.out.println("\nTask 6: Check Digits");
        excercise3.checkDigit(one);
    }
}
