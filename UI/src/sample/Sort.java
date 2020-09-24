/*  Program description: A program that sorts a data set using different sorting algorithms and displays how long it took to sort
    Created by: Lema Lucau
    Date: 22/05/2020
*/

package sample;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sort {
    // sort array using the selection sort
    public void selectionSort(ArrayList<Integer> nums) {
        // declare variables
        int min = 0;

        // outer loop makes the swap and iterates through the whole array
        for(int i = 0; i < nums.size() - 1; i++) {
            // set current element to minimum
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
    public void bubbleSort(ArrayList<Integer> nums) {
        // loop through list and make swaps
        for(int i = 1; i < nums.size(); i++) {

           // inner for loop does the comparisions and swaps
           for(int j = 0; j < nums.size() - 1; j++) {
               if(nums.get(j) > nums.get(j + 1)) {
                   Collections.swap(nums, j, j+1);
               }// end if
           }// end inner for
        }// end outer for
    }// end bubbleSort()

    // sort array using the insertion sort
    public void insertionSort(ArrayList<Integer> nums) {
        // declare variable
        int current, j = 0;

        // outer loop sets values for the current and j variable and it also makes the swap at the end
        for(int i = 1; i < nums.size(); i++) {
            //set values for current and j
            current = nums.get(i);
            j = i;

            // inner loop compares and updates the arraylist and j variable
            while(j > 0 && current < nums.get(j-1)) {
                // update list and j
                nums.set(j, nums.get(j-1));
                j = j-1;
            }// end inner while loop

            // insert number in correct position
            nums.set(j, current);
        }// end outer for
    }// end insertionSort()

    // sort array using the merge sort
    public void mergeSort(ArrayList<Integer> nums, int low, int high) {
        if(low < high) {
            // find middle
            int mid = (low + high) / 2;

            // sort first subarray
            mergeSort(nums, low, mid);

            // sort second subarray
            mergeSort(nums, mid+1, high);

            // merge the sorted arrays into one
            merge(nums, low, mid, high);
        }// end if
    }// end mergeSort()

    // part of the mergeSort algorithm
    private void merge(ArrayList<Integer> nums, int low, int mid, int high) {

        // find size of the subarrays
        int size1 = mid - low + 1;
        int size2 = high - mid;

        // create temp arrays
        int left[] = new int[size1];
        int right[] = new int[size2];

        // store data in temp arrays
        for(int i = 0; i < size1; i++) {
            left[i] = nums.get(low + i);
        }// end for

        for(int i = 0 ; i < size2; i++) {
            right[i] = nums.get((mid + 1) + i);
        }// end for

        // intialise indexes of left, right and merged subarray arrays
        int i = 0;
        int j = 0;
        int k = low;

        // merge the subarrays into one array
        while(i < size1 && j < size2) {
            if(left[i] <= right[j]) {
                nums.set(k, left[i]);
                i++;
            }// end if
            else {
                nums.set(k, right[j]);
                j++;
            }// end else

            k++;
        }// end while

        // copy remaining numbers of left[] if any
        while(i < size1) {
            nums.set(k, left[i]);
            i++;
            k++;
        }// end while

        // copy remaining numbers of right[] if any
        while(j < size2) {
            nums.set(k, right[j]);
            j++;
            k++;
        }// end while
    }// end merge()

    // sort array using the quick sort
    public void quickSort(ArrayList<Integer> nums, int low, int high) {
        if(low < high) {
            // set the partition index
            int par = partition(nums, low, high);

            // recursively sort elements on either side of the partition
            quickSort(nums, low, par-1);
            quickSort(nums, par+1, high);
        }// end if
    }// end quickSort()

    // part of the quickSort algorithm
    private int partition(ArrayList<Integer> nums, int low, int high) {
        int pivot = nums.get(high);
        int i = low-1;

        for(int j = low; j < high; j++) {
            // compare current element to pivot
            if(nums.get(j) < pivot) {
                i++;

                // swap nums[i] and nums[j]
                Collections.swap(nums,i,j);
            }// end if
        }// end for

        // make swap
        Collections.swap(nums,i+1,high);

        return i+1;
    }// end partition

    // print start menu
    public void displayStartMenu() {
        System.out.println("Select an option from the menu: ");
        System.out.println("1.Use a randomly generated set of numbers");
        System.out.println("2.Manually enter a set of numbers");
        System.out.println("3.Load a set of numbers from a txt file");
    }// end displayStartMenu()

    // display sorting menu
    public void displaySortMenu() {
        System.out.println("Select a sorting algorithm to sort the data set from the menu below: ");
        System.out.println("1. Selection sort");
        System.out.println("2. Bubble sort");
        System.out.println("3. Insertion sort");
        System.out.println("4. Merge sort");
        System.out.println("5. Quick sort");
        System.out.println("6. Add another set of random numbers to data set");
        System.out.println("7. Manually add another set of numbers to data set");
        System.out.println("8. Shuffle current data set");
        System.out.println("9. Clear contents of data set");
        System.out.println("99. End program");
    }// end displaySortMenu()

    public void printTime(long timeTaken) {
        System.out.println("");
        System.out.println("Total time taken: " + timeTaken + " milliseconds");
    }// end printTime()

    // allow user to insert numbers into array
    public void enterNums(ArrayList<Integer> nums, int sizeArr) throws IOException {
        System.out.println("");
        System.out.println("Enter the numbers all at once or one at a time. ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader inputNum = new BufferedReader(isr);

        // populate array
        for(int i = 0; i < sizeArr; i++) {
            System.out.println("Number " + (i+1) + ": ");
            nums.add(Integer.parseInt(inputNum.readLine()));
        }// end for

        System.out.println("You have added " + sizeArr + " numbers into the data set");
    }// end enterNums()

    // generate random numbers and populate array with the numbers
    public void generateNums(ArrayList<Integer> nums, int sizeArr) {
        System.out.println("");
        Random rand = new Random();
        int range = 500;

        // populate array
        for(int i = 0; i < sizeArr; i++) {
            nums.add(rand.nextInt(range));
        }// end for

        System.out.println(sizeArr + " random numbers have been added to the data set");
    }// end generateNums()

    // clear the contents of array
    public void clearArr(ArrayList<Integer> nums) {
        nums.clear();
    }// end clearArr()

    // print array contents
    public void displayArr(ArrayList<Integer> nums) {
        for (int num : nums) {
            System.out.print(" " + num + " ");
        }// end for
    }// end displayArr()

    // randomly shuffle the contents of the array
    public void shuffleArr(ArrayList<Integer> nums) {
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
}// end sample.Sort class

