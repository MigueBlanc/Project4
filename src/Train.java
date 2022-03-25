/****************************************************************************************************************************
 * Date Created : MARCH 25TH, 2022.
 * AUTHOR : MICHAEL BLANCO CHAVEZ
 * DESCRIPTION : THIS CLASS CREATES AN OBJECT THAT WILL BE USE IN THE PROJECT4 CLASS.
 *
 ***************************************************************************************************************************/


public class Train {
    String destination;
    int passengerCars;
    int passengerCapacity;
    int diningCars;
    int  mealsStocked;
    int mealsSold;

    /** Train() is the default constructor
     * visibility - public
     * @param null
     * @return nothing
     */

    public Train()
    {
        this.destination = null;
        this.passengerCars = 0;
        this.passengerCapacity = 0;
        this.diningCars = 0;
        this.mealsStocked = 0;
        this.mealsSold = 0;

    }

    /**
     * Train() is a custom constructor.
     * visibility - public
     * @param int passengerCars
     * @param String destination
     * @param int mealsSold
     * @return nothing
     */

    public Train(String destination, int passengerCars, int mealsSold)
    {
        this.destination = destination;
        this.passengerCars = passengerCars;
        this.passengerCapacity =  30 * this.passengerCars;
        calculateNumberOfDiningCars();
        this.mealsStocked = this.diningCars * 120;
        this.mealsSold = mealsSold;
    }

    /**
     * calculateNumberOfDiningCars() - this method returns the number of dining cars the Train object will have.
     * visibility - private void
     * @param none
     */

    private void calculateNumberOfDiningCars(){

        this.diningCars = (int)Math.ceil((double)this.passengerCapacity/100.0);
    }
    /**
     * calculateDiningProfit() - this methods calculates the dining profit.
     * visibility - private static
     * @param none
     * @return Double
     */


    public double calculateDiningProfit()
    {
        return (0.35 * this.mealsSold) - (0.18 * this.mealsStocked);
    }


    /** getDestination() - this method return a string
     * visibility - private static
     * @param none
     * @return String
     */

    public String getDestination()
    {
        return this.destination;
    }


    /** getNumberOfPassengerCars() - this method returns an int
     * visibility - private static
    * @param none
    * @return int
    **/
    public int getNumberOfPassengerCars()
    {
        return this.passengerCars;
    }


    /**
    *  getNumberOfDiningCars()
    * @param none
    * visibility - private static
    * @return nothing
    * */
    public int getNumberOfDiningCars(){
        return this.diningCars;
    }
    /**
     * toString - method to print a project.Train object in the form
     *                   destination passenger cars/passenger capacity/dining cars/stocked/sold
     * @param none
     * @return String
     */
    //DO NOT ALTER THIS METHOD
    @Override
    public String toString() {
        return "To " + this.destination + " " + this.passengerCars + "/" + this.passengerCapacity + "/" +
                this.diningCars + "/" + this.mealsStocked + "/" + this.mealsSold;
    } //DO NOT ALTER THIS METHOD
}
