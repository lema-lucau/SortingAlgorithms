package sample;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SortMain {
    public static void main(String[] args) throws IOException {
        //declare variables and arrays
        int option = 0;
        int sortOption = 0;
        int sizeArr;
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
                nums = s.readFile();

                // if the file was not found make the loop display again
                if(nums.isEmpty()) {
                    option = 99;
                }
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
                    // reset the counters
                    s.resetCounters();

                    // display array before selection sort
                    System.out.println("");
                    System.out.println("Array before selection sort :");
                    s.displayArr(nums);

                    // start timer
                    s.startTimer();

                    // sort array using the selection sort
                    s.selectionSort(nums);

                    // end timer
                    s.endTimer();

                    // display array after selection sort
                    System.out.println("");
                    System.out.println("Array after selection sort :");
                    s.displayArr(nums);

                    // print sort stats
                    s.printStats();
                    break;

                case 2:
                    // reset the counters
                    s.resetCounters();

                    // display array before bubble sort
                    System.out.println("");
                    System.out.println("Array before bubble sort :");
                    s.displayArr(nums);

                    // start timer
                    s.startTimer();

                    // sort array using the bubble sort
                    s.bubbleSort(nums);

                    // end timer
                    s.endTimer();

                    // display array after bubble sort
                    System.out.println("");
                    System.out.println("Array after bubble sort :");
                    s.displayArr(nums);

                    // print sort stats
                    s.printStats();
                    break;

                case 3:
                    // reset the counters
                    s.resetCounters();

                    // display array before insertion sort
                    System.out.println("");
                    System.out.println("Array before insertion sort :");
                    s.displayArr(nums);

                    // start timer
                    s.startTimer();

                    // sort array using the insertion sort
                    s.insertionSort(nums);

                    // end timer
                    s.endTimer();

                    // display array after insertion sort
                    System.out.println("");
                    System.out.println("Array after insertion sort :");
                    s.displayArr(nums);

                    // print sort stats
                    s.printStats();
                    break;

                case 4:
                    // reset the counters
                    s.resetCounters();

                    // display array before merge sort
                    System.out.println("");
                    System.out.println("Array before merge sort :");
                    s.displayArr(nums);

                    // start timer
                    s.startTimer();

                    // sort array using the merge sort
                    s.mergeSort(nums,0, nums.size()-1);

                    // end timer
                    s.endTimer();

                    // display array after merge sort
                    System.out.println("");
                    System.out.println("Array after merge sort :");
                    s.displayArr(nums);

                    // print sort stats
                    s.printStats();
                    break;

                case 5:
                    // reset the counters
                    s.resetCounters();

                    // display array before quick sort
                    System.out.println("");
                    System.out.println("Array before quick sort :");
                    s.displayArr(nums);

                    // start timer
                    s.startTimer();

                    // sort array using the quick sort
                    s.quickSort(nums, 0, nums.size()-1);

                    // end timer
                    s.endTimer();

                    // display array after quick sort
                    System.out.println("");
                    System.out.println("Array after quick sort :");
                    s.displayArr(nums);

                    // print sort stats
                    s.printStats();
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

                case 9:
                    // clear array
                    s.clearArr(nums);
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
}
