/*  Program description: A program that sorts a data set using different sorting algorithms and displays how long it took to sort
    Created by: Lema Lucau
    Date: 22/05/2020
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.*;

public class Sort {
    public static void main(String[] args) throws IOException {
        //declare variables and arrays
        int option = 0;
        int sortOption = 0;
        int sizeArr;
        long startTime, endTime, timeTaken;
        ArrayList<Integer> nums = new ArrayList<>();

        // create objects
        Scanner input = new Scanner(System.in);
        Sort s = new Sort();

        // create array list
        System.out.println("How many numbers would you like to include in the data set: ");
        sizeArr = input.nextInt();

        //display menu until the user selects a valid opinion
        while(option != 1 && option != 2 && option != 3) {
            //ask user to select option from menu
            System.out.println("");
            s.displayStartMenu();

            option = input.nextInt();

            //react to users menu selection
            if (option == 1) {
                // populate nums array
                s.generateNums(nums, sizeArr);

            } else if (option == 2) {
                // populate nums array
                s.enterNums(nums, sizeArr);

            } else if (option == 3) {
                System.out.println("You have selected option 3");

            } else {
                System.out.println("ERROR: Invalid input. Select an option from the menu");
            }//end if else
        }// end while loop

        //allow user to select a sorting algorithm
        while(sortOption != 99) {
            // display menu
            System.out.println("");
            s.displaySortMenu();

            // take user input
            sortOption = input.nextInt();

            switch (sortOption) {
                // call correct sorting sorting method based on the users input
                case 1:
                    // get the current system time in milliseconds
                    startTime = System.currentTimeMillis();

                    // display array before selection sort
                    System.out.println("");
                    System.out.println("Array before selection sort :");
                    s.displayArr(nums);

                    // sort array using the selection sort
                    s.selectionSort(nums);

                    // display array after selection sort
                    System.out.println("");
                    System.out.println("Array after selection sort :");
                    s.displayArr(nums);

                    // get time after method is finished and display the time taken
                    endTime = System.currentTimeMillis();
                    timeTaken = endTime - startTime;
                    System.out.println("");
                    System.out.println("Total time taken: " + timeTaken + " ms");
                    break;

                case 2:
                    // get the current system time in milliseconds
                    startTime = System.currentTimeMillis();

                    // display array before bubble sort
                    System.out.println("");
                    System.out.println("Array before bubble sort :");
                    s.displayArr(nums);

                    // sort array using the bubble sort
                    s.bubbleSort(nums);

                    // display array after bubble sort
                    System.out.println("");
                    System.out.println("Array after bubble sort :");
                    s.displayArr(nums);

                    // get time after method is finished and display the time taken
                    endTime = System.currentTimeMillis();
                    timeTaken = endTime - startTime;
                    System.out.println("");
                    System.out.println("Total time taken: " + timeTaken + " ms");
                    break;

                case 3:
                    // get the current system time in milliseconds
                    startTime = System.currentTimeMillis();

                    // display array before insertion sort
                    System.out.println("");
                    System.out.println("Array before insertion sort :");
                    s.displayArr(nums);

                    // sort array using the insertion sort
                    s.insertionSort(nums);

                    // display array after insertion sort
                    System.out.println("");
                    System.out.println("Array after insertion sort :");
                    s.displayArr(nums);

                    // get time after method is finished and display the time taken
                    endTime = System.currentTimeMillis();
                    timeTaken = endTime - startTime;
                    System.out.println("");
                    System.out.println("Total time taken: " + timeTaken + " ms");
                    break;

                case 4:
                    // get the current system time in milliseconds
                    startTime = System.currentTimeMillis();

                    // display array before merge sort
                    System.out.println("");
                    System.out.println("Array before merge sort :");
                    s.displayArr(nums);

                    // sort array using the merge sort
                    s.mergeSort(nums);

                    // display array after merge sort
                    System.out.println("");
                    System.out.println("Array after merge sort :");
                    s.displayArr(nums);

                    // get time after method is finished and display the time taken
                    endTime = System.currentTimeMillis();
                    timeTaken = endTime - startTime;
                    System.out.println("");
                    System.out.println("Total time taken: " + timeTaken + " ms");
                    break;

                case 5:
                    // get the current system time in milliseconds
                    startTime = System.currentTimeMillis();

                    // display array before quick sort
                    System.out.println("");
                    System.out.println("Array before quick sort :");
                    s.displayArr(nums);

                    // sort array using the quick sort
                    s.quickSort(nums);

                    // display array after quick sort
                    System.out.println("");
                    System.out.println("Array after quick sort :");
                    s.displayArr(nums);

                    // get time after method is finished and display the time taken
                    endTime = System.currentTimeMillis();
                    timeTaken = endTime - startTime;
                    System.out.println("");
                    System.out.println("Total time taken: " + timeTaken + " ms");
                    break;

                case 6:
                    // generate a random set of numbers
                    s.generateNums(nums, sizeArr);
                    break;

                case 7:
                    // enter nums
                    s.enterNums(nums, sizeArr);
                    break;

                case 8:
                    // shuffle array
                    s.shuffleArr(nums);
                    break;

                case 99:
                    // end program
                    System.out.println("");
                    System.out.println("Program ended");
                    break;

                default:
                    System.out.println("ERROR: Invalid input. Select an option from the menu");
            }//end switch
        }// end while

        input.close();
    }// end main

    // sort array using the selection sort
    private void selectionSort(ArrayList<Integer> nums) {
        // declare variables
        int min = 0;

        // outer loop makes the swap and iterates through the whole array
        for(int i = 0; i < nums.size() - 1; i++) {
            //set current element to minimum
            min = i;

            // loop to find the smallest number
            for(int j = i+1; j < nums.size(); j++) {
                if(nums.get(j) < nums.get(min)) {
                    min = j;
                }// end if
            }// end inner for

            // make swap
            Collections.swap(nums,i,min);
        }// end outer for

    }// end selectionSort()

    // sort array using the bubble sort
    private void bubbleSort(ArrayList<Integer> nums) {

    }// end bubbleSort()

    // sort array using the insertion sort
    private void insertionSort(ArrayList<Integer> nums) {

    }// end insertionSort()

    // sort array using the merge sort
    private void mergeSort(ArrayList<Integer> nums) {

    }// end mergeSort()

    // sort array using the quick sort
    private void quickSort(ArrayList<Integer> nums) {

    }// end quickSort()

    // print start menu
    private void displayStartMenu() {
        System.out.println("Select an option from the menu: ");
        System.out.println("1.Use a randomly generated set of numbers");
        System.out.println("2.Manually enter a set of numbers");
        System.out.println("3.Load a set of numbers from a txt file");
    }// end displayStartMenu()

    // display sorting menu
    private void displaySortMenu() {
        System.out.println("Select a sorting algorithm to sort the data set from the menu below: ");
        System.out.println("1. Selection sort");
        System.out.println("2. Bubble sort");
        System.out.println("3. Insertion sort");
        System.out.println("4. Merge sort");
        System.out.println("5. Quick sort");
        System.out.println("6. Generate another set of random numbers");
        System.out.println("7. Manually enter another set of numbers");
        System.out.println("8. Shuffle current data set");
        System.out.println("99. End program");
    }// end displaySortMenu()

    // allow user to insert numbers into array
    private void enterNums(ArrayList<Integer> nums, int sizeArr) throws IOException {
        System.out.println("");
        System.out.println("Enter the numbers all at once or one at a time. ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader inputNum = new BufferedReader(isr);

        // populate array
        for(int i = 0; i < sizeArr; i++) {
            System.out.println("Number " + (i+1) + ": ");
            nums.add(Integer.parseInt(inputNum.readLine()));
        }// end for

    }// end enterNums()

    // generate random numbers and populate array with the numbers
    private void generateNums(ArrayList<Integer> nums, int sizeArr) {
        System.out.println("");
        Random rand = new Random();
        int range = 100;

        // populate array
        for(int i = 0; i < sizeArr; i++) {
            nums.add(rand.nextInt(range));
        }// end for
    }// end generateNums()

    // print array contents
    private void displayArr(ArrayList<Integer> nums) {
        for (int num : nums) {
            System.out.print(" " + num + " ");
        }// end for
    }// end displayArr()

    // randomly shuffle the contents of the array
    private void shuffleArr(ArrayList<Integer> nums) {
        // declare variables
        Random rand = new Random();
        int maxIndex = nums.size() - 1;
        int randIndex, temp;

        // swap random indexes
        for(int i = 0; i < nums.size(); i++) {
            // store a random index
            randIndex = rand.nextInt(maxIndex);

            // make swap
            Collections.swap(nums,i,randIndex);
        }// end outer for
    }// end shuffleArr()
}// end Sort class

