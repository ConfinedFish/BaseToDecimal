import java.util.InputMismatchException;
import java.util.Scanner;

public class BaseToDecimal {
    /*
     * Declarers variables for class.
     * Global variables are used here because these variables are used in several different methods.
     */
    private static Scanner scanner = new Scanner(System.in);
    private static int base, entry;

    /**
     * Main method to call the run() method.
     * @param args
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * Run method runs all calculations and prints messages.
     */
    private static void run(){
        /*
         * Variables declared for do while loops.
         */
        boolean validBase = false, validNumber = false;
        /*
         * Do while loop for asking the user to enter a base. If base is between 2 and 9 the loop exits.
         */
        do {
            if(printBase()){
                /*
                 * If the user input is valid, break the loop.
                 */
                validBase = true;
            }
        }while (!validBase);
        /*
         * Do while loop for asking the user to enter a number in specified base.
         * If the number is in the specific base, the loop exits.
         */
        do {
            if(printMessage()){
                /*
                 * If the user input is valid, break the loop.
                 */
                validNumber = true;
            }
        }while (!validNumber);
        /*
         * Prints the result of the function getDecimal().
         */
        print(getDecimal(entry, base));
    }

    /**
     * Function to calcualte whether the base is correct and between 2 and 9.
     * Checks if the number is truly a digit or a letter.
     * @return true if the base is in the correct format, and false if the base is incorrect.
     */
    private static boolean printBase(){
        print("Please enter a base from 2-9: ");
        /*
         * Handles an input mismatch exception.
         * This occurs when the user inputs a letter instead of a number.
         */
        try{base = scanner.nextInt();}
        catch (InputMismatchException e){
            print("Incorrect base system. ");
            /*
             * Consumes whatever the user has input to the function.
             * If in the catch, whatever the user input, the program does not want.
             */
            scanner.next();
            return false;
        }
        /*
         * Performs the check if the base is within 2 and 9.
         */
        if(base < 2 || base > 9){
            print("Incorrect base system. ");
            return false;
        }
        return true;
    }

    /**
     * Asks the user to enter a number in the base they specified.
     * @return true if the number is in the correct format and in the correct base.
     */
    private static boolean printMessage(){
        print("Please enter a base " + base + " number: ");
        /*
         * Handles an input mismatch exception.
         * This occurs when the user inputs a letter instead of a number.
         */
        try{entry = scanner.nextInt();}
        catch (InputMismatchException e){
            print("Incorrect base system.");
            /*
             * Consumes whatever the user has input to the function.
             * If in the catch, whatever the user input, the program does not want.
             */
            scanner.next();
            return false;
        }
        return validNumberInBase(entry, base);
    }
    /**
     * Checks whether the number is valid in the specific base.
     * The method of checking involves taking the base subtracting one, and comparing each digit of the
     * specified number against the new base to verify the number is in the correct base.
     * @param entry the number to be checked
     * @param base the base to check the number against
     * @return true if the number is in the correct format and false if the number is incorrect format.
     */
    private static boolean validNumberInBase(int entry, int base){
        /*
         * Converts the input into a character array.
         * This is done to iterate over each character and validate if it is withing the base.
         */
        char[] list = Integer.toString(entry).toCharArray();
        /*
         * Loops over each character in the array and checks whether the value is within the bounds of the base.
         * Also converts the character into a numerical value by using the Character.getNumericalValue() method.
         */
        for (char l : list){
            if (Character.getNumericValue(l) > base - 1 || Character.getNumericValue(l) < 0){
                print("Incorrect base system. ");
                return false;
            }
        }
        return true;
    }
    /**
     * Converts the number in the specified base.
     * @param entry the number to be converted
     * @param base the base to convert the number into
     * @return the result
     */
    private static int getDecimal(int entry, int base){
        int result = 0;
        /*
         * Converts the input into a character array.
         * This is done to convert each character of the user input and insure each character is used.
         *
         */
        char[] digits = Integer.toString(entry).toCharArray();
        /*
         * Calculates the conversion on each character of the array using the Character.getNumericalValue() method
         */
        for (int i = 0; i <= digits.length-1; i++){
            result = ((result * base) + Character.getNumericValue(digits[i]));
        }
        return result;
    }

    /**
     * Shortcut to the System.out.print()
     * @param obj the object to print.
     */
    private static void print(Object obj){
        System.out.print(obj);
    }
}
