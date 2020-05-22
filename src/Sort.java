/*  Program description: A program that sorts a data set using different sorting algorithms and displays how long it took to sort
    Created by: Lema Lucau
    Date: 22/05/2020
*/

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        //declare variables and array
        int option = 0;
        int sortOption = 0;
        int sizeArr;
        int[] nums;
        int[] sortedNums;

        // create objects
        Scanner input = new Scanner(System.in);
        Sort s = new Sort();

        // declare array size
        System.out.println("How many numbers would you like to include in the data set (Max = 100): ");
        sizeArr = input.nextInt();
        nums = new int[sizeArr];
        sortedNums = new int[sizeArr];

        //display menu until the user selects a valid opinion
        while(option != 1 && option != 2 && option != 3) {
            //ask user to select option from menu
            System.out.println("");
            System.out.println("Select an option from the menu: ");
            System.out.println("1.Use a randomly generated set of numbers");
            System.out.println("2.Manually insert a set of numbers");
            System.out.println("3.Load a set of numbers from a txt file");

            option = input.nextInt();

            //react to users menu selection
            if (option == 1) {
                // populate nums array
                System.out.println("");
                s.generateNums(nums);

                for (int num : nums) {
                    System.out.print(" " + num + " ");
                }// end for

            } else if (option == 2) {
                // populate nums array
                System.out.println("");
                s.enterNums(nums);

                System.out.println("");
                for (int num : nums) {
                    System.out.print(" " + num + " ");
                }// end for

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
            System.out.println("Select a sorting algorithm to sort the data set from the menu below: ");
            System.out.println("1. Selection sort");
            System.out.println("2. Bubble sort");
            System.out.println("3. Insertion sort");
            System.out.println("4. Merge sort");
            System.out.println("5. Quick sort");
            System.out.println("99. End program");

            // take user input
            sortOption = input.nextInt();

            // call correct sorting sorting method based on the users input
            if (sortOption == 1) {
                // sort array using the selection sort
                System.out.println("You selected option " + sortOption + " (Selection sort)");
                s.selectionSort(nums, sortedNums);

            } else if (sortOption == 2) {
                // sort array using the bubble sort
                System.out.println("You selected option " + sortOption + " (Bubble sort)");
                s.bubbleSort(nums, sortedNums);

            } else if (sortOption == 3) {
                // sort array using the insertion sort
                System.out.println("You selected option " + sortOption + " (Insertion sort)");
                s.insertionSort(nums, sortedNums);

            } else if (sortOption == 4) {
                // sort array using the merge sort
                System.out.println("You selected option " + sortOption + " (Merge sort)");
                s.mergeSort(nums, sortedNums);

            } else if (sortOption == 5) {
                // sort array using the quick sort
                System.out.println("You selected option " + sortOption + " (Quick sort)");
                s.quickSort(nums, sortedNums);

            } else if (sortOption == 99) {
                // end program
                System.out.println("Program ended");
                break;

            } else {
                System.out.println("ERROR: Invalid input. Select an option from the menu");
            }// end if else
        }// end while

        input.close();
    }// end main

    // sort array using the selection sort
    private void selectionSort(int[] nums, int[] sortedNums) {

    }// end selectionSort()

    // sort array using the bubble sort
    private void bubbleSort(int[] nums, int[] sortedNums) {

    }// end bubbleSort()

    // sort array using the insertion sort
    private void insertionSort(int[] nums, int[] sortedNums) {

    }// end insertionSort()

    // sort array using the merge sort
    private void mergeSort(int[] nums, int[] sortedNums) {

    }// end mergeSort()

    // sort array using the quick sort
    private void quickSort(int[] nums, int[] sortedNums) {

    }// end quickSort()

    // allow user to insert numbers into array
    private void enterNums(int[] nums) {
        System.out.println("");
        System.out.println("Enter the numbers all at once or one at a time. ");

        Scanner inputNum = new Scanner(System.in);

        // populate array
        for(int i = 0; i < nums.length; i++) {
            System.out.println("Number " + (i+1) + ": ");
            nums[i] = inputNum.nextInt();
        }// end for

        inputNum.close();
    }// end enterNums()

    // generate random numbers and populate array with the numbers
    private void generateNums(int[] nums) {
        System.out.println("");
        Random rand = new Random();
        int range = 100;

        // populate array
        for(int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(range);
        }// end for
    }// end generateNums()
}

