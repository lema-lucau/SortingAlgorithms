package sample;

import java.io.IOException;
import java.util.Scanner;

public class SortMain {
    public static void main(String[] args) throws IOException {
        //declare variables and arrays
        int option = 0;

        // create objects
        Scanner input = new Scanner(System.in);
        Sort s = new Sort();

        //allow user to select a sorting algorithm
        while(option != 99) {
            // display menu
            System.out.println();
            s.menu();

            // take user input
            option = input.nextInt();

            switch (option) {
                // call appropriate method based on the users input
                case 1:
                    // if list is empty display a message and exit
                    if(s.getSize() <= 0) {
                        System.out.println();
                        System.out.println("The list is empty!");
                        break;
                    }

                    // reset the counters
                    s.resetCounters();

                    // display array before selection sort
                    System.out.println();
                    System.out.println("Data before selection sort :");
                    s.displayArr();

                    // start timer
                    s.startTimer();

                    // sort array using the selection sort
                    s.selectionSort();

                    // end timer
                    s.endTimer();

                    // display array after selection sort
                    System.out.println();
                    System.out.println("Data after selection sort :");
                    s.displayArr();

                    // print sort stats
                    s.printStats();
                    break;

                case 2:
                    // if list is empty display a message and exit
                    if(s.getSize() <= 0) {
                        System.out.println();
                        System.out.println("The list is empty!");
                        break;
                    }

                    // reset the counters
                    s.resetCounters();

                    // display array before bubble sort
                    System.out.println();
                    System.out.println("Data before bubble sort :");
                    s.displayArr();

                    // start timer
                    s.startTimer();

                    // sort array using the bubble sort
                    s.bubbleSort();

                    // end timer
                    s.endTimer();

                    // display array after bubble sort
                    System.out.println();
                    System.out.println("Data after bubble sort :");
                    s.displayArr();

                    // print sort stats
                    s.printStats();
                    break;

                case 3:
                    // if list is empty display a message and exit
                    if(s.getSize() <= 0) {
                        System.out.println();
                        System.out.println("The list is empty!");
                        break;
                    }

                    // reset the counters
                    s.resetCounters();

                    // display array before insertion sort
                    System.out.println();
                    System.out.println("Data before insertion sort :");
                    s.displayArr();

                    // start timer
                    s.startTimer();

                    // sort array using the insertion sort
                    s.insertionSort();

                    // end timer
                    s.endTimer();

                    // display array after insertion sort
                    System.out.println();
                    System.out.println("Data after insertion sort :");
                    s.displayArr();

                    // print sort stats
                    s.printStats();
                    break;

                case 4:
                    // if list is empty display a message and exit
                    if(s.getSize() <= 0) {
                        System.out.println();
                        System.out.println("The list is empty!");
                        break;
                    }

                    // reset the counters
                    s.resetCounters();

                    // display array before merge sort
                    System.out.println();
                    System.out.println("Data before merge sort :");
                    s.displayArr();

                    // start timer
                    s.startTimer();

                    // sort array using the merge sort
                    s.mergeSort();

                    // end timer
                    s.endTimer();

                    // display array after merge sort
                    System.out.println();
                    System.out.println("Data after merge sort :");
                    s.displayArr();

                    // print sort stats
                    s.printStats();
                    break;

                case 5:
                    // if list is empty display a message and exit
                    if(s.getSize() <= 0) {
                        System.out.println();
                        System.out.println("The list is empty!");
                        break;
                    }

                    // reset the counters
                    s.resetCounters();

                    // display array before quick sort
                    System.out.println();
                    System.out.println("Data before quick sort :");
                    s.displayArr();

                    // start timer
                    s.startTimer();

                    // sort array using the quick sort
                    s.quickSort();

                    // end timer
                    s.endTimer();

                    // display array after quick sort
                    System.out.println();
                    System.out.println("Data after quick sort :");
                    s.displayArr();

                    // print sort stats
                    s.printStats();
                    break;

                case 6:
                    // generate a random set of numbers
                    s.generateNums();
                    break;

                case 7:
                    // enter nums
                    s.enterNums();
                    break;

                case 8:
                    // load numbers from a text file
                    s.readFile();
                    break;

                case 9:
                    // shuffle array
                    s.shuffleArr();
                    break;

                case 10:
                    // clear array
                    s.clearArr();
                    break;

                case 11:
                    // if list is empty display a message and exit
                    if(s.getSize() <= 0) {
                        System.out.println();
                        System.out.println("The list is empty!");
                        break;
                    }

                    // display array
                    System.out.println();
                    System.out.print("Numbers in data set:");
                    s.displayArr();
                    System.out.println();
                    break;

                case 99:
                    // end program
                    System.out.println();
                    System.out.println("Program ended");
                    break;

                default:
                    System.out.println("ERROR: Invalid input. Select an option from the menu");
            }//end switch
        }// end while
    }// end main
}// end SortMain class
