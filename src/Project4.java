/****************************************************************************************************************************
 * Date Created : MARCH 25TH, 2022.
 * AUTHOR : MICHAEL BLANCO CHAVEZ
 * DESCRIPTION : THIS PROGRAM TAKES AN INPUT FILE WITH AN SPECIFIC FORMAT, AND PASSES THE CONTENT OF THE FILE INTO
 * AN OBJECT 2D ARRAY.
 *
 ***************************************************************************************************************************/


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Project4 {
    //WHEN DID YOU FIRST START WORKING ON THIS ASSIGNMENT (date and time): <---------------
    //ANSWER: wed march 24th @ 6:50 AM <---------------

    //DO NOT ALTER THE MAIN METHOD
    public static void main( String[] args ) throws FileNotFoundException {
        //THERE ARE YOUR TEST CASES CONTINED IN THE INPUT FILES
        //comment your test cases in ONE AT A TIME
//        String inputFile = "amr_dining.txt";
       String inputFile = "amr_dining2.txt";

        //read input file and create a ragged array with trains for each day of the week
        Train[][] trainsThisWeek = readData( inputFile );

        //IF YOU WANT TO MAKE SURE YOU READ THE INPUT DATA CORRECTLY AND CREATED YOUR ARRAY AND POBJECTS PROPERLY
        //COMMENT THIS IN
        //testArray( trainsThisWeek );

        //print report
        System.out.println( "This week's AMR report (input file " + inputFile + ")\n" );
        printReport( trainsThisWeek );

        //print profit
        System.out.printf( "This week's profit: $%.2f", calculateWeeklyProfit( trainsThisWeek ) );
    } //DO NOT ALTER THE MAIN METHOD

    /** readData - method called from the main with the input file name
     *       this methods reads the file into a two dimensional ragged array of project.Train objects
     *
     * visibility - private static
     *
     * @param String file - name of the file containing the input data
     *
     * @returns project.Train[][]
     */

    private static Train[][] readData(String fileName) {
        Scanner in = null;
        try {
            File file = new File(fileName);
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("THIS FILE DOES NOT EXIST!!");
        }

        Train[][] myArray = new Train[7][];
        int elementsInArray;
        while (true) {
            assert in != null;
            if (!in.hasNext()) break;
            for (int i = 0; i < 7; i++) {
                in.next();
                elementsInArray = in.nextInt();
                myArray[i] = new Train[elementsInArray];
                in.nextLine();

                for (int j = 0; j < elementsInArray; j++) {
                    String destination = in.next();
                    int passengerCars = in.nextInt();
                    int mealsSold = in.nextInt();
                    myArray[i][j] = new Train(destination, passengerCars, mealsSold);
                }
            }
        }
            return myArray;
        }


    /** printReport - method called from the main with the constructed 2D jagged array of project.Train objects
     *       this methods prints the formatted report for the week
     *
     * visibility - private static
     *
     * @param Train[][] t - the 2D jagged array of project.Train objects
     *
     * @returns nothing
     */


    private static void printReport(Train[][]t) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Firday", "Saturday", "Sunday"};

        for (int i = 0; i < t.length; i++) {
            System.out.printf("%s's trains and profit:", days[i]);
            if (t[i].length == 0)
                System.out.print("\nNo trains.\n");
            else {
                for (int j = 0; j < t[i].length; j++) {

                    Train currentObject = t[i][j];
                    String destination = currentObject.getDestination();
                    int passengerCars = currentObject.getNumberOfPassengerCars();
                    int diningCars = currentObject.getNumberOfDiningCars();
                    double profit = currentObject.calculateDiningProfit();
                    String profitOrLoss = (profit >= 0.0) ? "profit" : "loss";

                    System.out.printf("\nTrain to %-12s - %d passenger cars, %d dining cars - %-6s $%6.2f", destination, passengerCars, diningCars, profitOrLoss, Math.abs(profit));
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
    /** calculateWeeklyProfit - method called from the main with the constructed 2D jagged array of project.Train objects
     *       this methods tallies up the profit for the week
     *
     * visibility - private static
     *
     * @param Train[][] t - the 2D jagged array of project.Train objects
     *
     * @returns double - total weekly profit
     */


    private static double calculateWeeklyProfit(Train[][] t) {
        double weeklyProfit = 0.0;
        double dailyProfit = 0.0;
        for (Train[] trains : t) {
            for (Train currentObject : trains) {
                dailyProfit += currentObject.calculateDiningProfit();
            }
        }
        weeklyProfit += dailyProfit;
        return weeklyProfit;
    }
    /** testArray - optional method called from the main with the constructed 2D jagged array of project.Train objects
     *       this methods will let you test your 2D jagged project.Train array for correctness
     *
     * visibility - private static
     *
     * @param Train[][] t - the 2D jagged array of project.Train objects
     *
     * @returns nothing
     */
    private static void testArray( Train[][] t ) { //DO NOT ALTER THIS METHOD
        for ( int i = 0; i < 7; i++ ) System.out.println( Arrays.toString( t[ i ] ) );
    } //DO NOT ALTER THIS METHOD
}

