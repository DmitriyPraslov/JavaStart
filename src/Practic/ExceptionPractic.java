package Practic;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileLockInterruptionException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ExceptionPractic {
    public static void main(String[] args) throws Exception {
        String string = null;
        try {
            System.out.println(string.length());
        } catch (NullPointerException e){
            System.out.println("1 - NullPointerException!");
        }
        try {
            int f = 2 / 0;
        } catch (ArithmeticException e){
            System.out.println("2 - ArithmeticException!");
        }
        try{
            int[] array = {1,2,3};
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("3 - ArrayIndexOutOfBoundsException!");
        }
        try {
            File file = new File("test");
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e){
            System.out.println("4 - FileNotFoundException!");
        }
        try {
            Scanner scanner1 = new Scanner(System.in);
            int var = scanner1.nextInt();
        } catch (InputMismatchException e){
            System.out.println("5 - InputMismatchException!");
        }
        Scanner scanner2 = new Scanner(System.in);
            int var = scanner2.nextInt();
            switch (var){
                case 1 :
                    throw new IOException();
                case 2 :
                    throw new RuntimeException();
                case 3 :
                    throw new SQLException();
                case 4 :
                    throw new DataFormatException();
                default :
                    throw new Exception();
            }
        }
    }

