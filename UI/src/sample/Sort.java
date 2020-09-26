/*  Program description: A program that sorts a data set using different sorting algorithms and displays how long it took to sort
    Created by: Lema Lucau
    Date: 22/05/2020
*/

package sample;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Sort {
    private long comparisons;
    private long swaps;
    private long startTime, endTime, timeTaken;
    private ArrayList<Integer> nums;

    public Sort() {
        this.comparisons = 0;
        this.swaps = 0;
        this.startTime = 0;
        this.endTime = 0;
        this.timeTaken = 0;
        nums = new ArrayList<>();
    }

    // sort array using the selection sort
    public void selectionSort() {
        int min;

        // outer loop makes the swap and iterates through the whole array
        for(int i = 0; i < nums.size() - 1; i++) {
            // set current element to minimum
            min = i;

            // loop to find the smallest number
            for(int j = i+1; j < nums.size(); j++) {
                if(nums.get(j) < nums.get(min)) {
                    min = j;
                }// end if

                this.comparisons += 1;
            }// end inner for

            // make swap
            Collections.swap(nums,i,min);
            this.swaps += 1;
        }// end outer for
    }// end selectionSort()

    // sort array using the bubble sort
    public void bubbleSort() {

        // loop through list and make swaps
        for(int i = 1; i < nums.size(); i++) {

           // inner for loop does the comparisions and swaps
           for(int j = 0; j < nums.size() - 1; j++) {
               this.comparisons += 1;

               if(nums.get(j) > nums.get(j + 1)) {
                   Collections.swap(nums, j, j+1);
                   this.swaps += 1;
               }// end if
           }// end inner for
        }// end outer for
    }// end bubbleSort()

    // sort array using the insertion sort
    public void insertionSort() {
        int current, j;

        // outer loop sets values for the current and j variable and it also makes the swap at the end
        for(int i = 1; i < nums.size(); i++) {
            //set values for current and j
            current = nums.get(i);
            j = i;

            // inner loop compares and updates the arraylist and j variable
            while(j > 0 && current < nums.get(j-1)) {
                this.comparisons += 1;

                // update list and j
                this.swaps += 1;
                nums.set(j, nums.get(j-1));
                j = j-1;
            }// end inner while loop

            // insert number in correct position
            nums.set(j, current);
            this.swaps += 1;
        }// end outer for
    }// end insertionSort()

    // sort array using the merge sort
    public void mergeSort() {
        mergeSortAlg(0, nums.size()-1);
    }

    private void mergeSortAlg(int low, int high) {
        if(low < high) {
            // find middle
            int mid = (low + high) / 2;

            // sort first subarray
            mergeSortAlg(low, mid);

            // sort second subarray
            mergeSortAlg(mid+1, high);

            // merge the sorted arrays into one
            merge(low, mid, high);
        }// end if
    }// end mergeSort()

    // part of the mergeSort algorithm
    private void merge(int low, int mid, int high) {
        // find size of the subarrays
        int size1 = mid - low + 1;
        int size2 = high - mid;

        // create temp arrays
        int[] left = new int[size1];
        int[] right = new int[size2];

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
                this.comparisons += 1;
                this.swaps += 1;
                nums.set(k, left[i]);
                i++;
            }// end if
            else {
                this.comparisons += 1;
                this.swaps += 1;
                nums.set(k, right[j]);
                j++;
            }// end else

            k++;
        }// end while

        // copy remaining numbers of left[] if any
        while(i < size1) {
            this.swaps += 1;
            nums.set(k, left[i]);
            i++;
            k++;
        }// end while

        // copy remaining numbers of right[] if any
        while(j < size2) {
            this.swaps += 1;
            nums.set(k, right[j]);
            j++;
            k++;
        }// end while
    }// end merge()

    // sort array using the quick sort
    public void quickSort() {
        quickSortAlg(0, nums.size()-1);
    }

    private void quickSortAlg(int low, int high) {
        if(low < high) {
            // set the partition index
            int par = partition(low, high);

            // recursively sort elements on either side of the partition
            quickSortAlg(low, par-1);
            quickSortAlg(par+1, high);
        }// end if
    }// end quickSort()

    // part of the quickSort algorithm
    private int partition(int low, int high) {
        int pivot = nums.get(high);
        int i = low-1;

        for(int j = low; j < high; j++) {
            // compare current element to pivot
            this.comparisons += 1;
            if(nums.get(j) < pivot) {
                i++;

                // swap nums[i] and nums[j]
                Collections.swap(nums,i,j);
                this.swaps += 1;
            }// end if
        }// end for

        // make swap
        Collections.swap(nums,i+1,high);

        return i+1;
    }// end partition

    // display sorting menu
    public void menu() {
        System.out.println("Select an option from the menu: ");
        System.out.println("1. Selection sort");
        System.out.println("2. Bubble sort");
        System.out.println("3. Insertion sort");
        System.out.println("4. Merge sort");
        System.out.println("5. Quick sort");
        System.out.println("6. Add random numbers to data set");
        System.out.println("7. Manually add numbers to data set");
        System.out.println("8. Load numbers from a txt file");
        System.out.println("9. Shuffle current data set");
        System.out.println("10. Clear contents of data set");
        System.out.println("11. Display contents of data set");
        System.out.println("99. End program");
    }// end menu()

    // allow user to insert numbers into array
    public void enterNums() throws IOException {
        Scanner input = new Scanner(System.in);

        // ask user for how many numbers to input and the highest number they want in the list
        System.out.println();
        System.out.println("How many numbers would you like to add into the list: ");
        int total = input.nextInt();

        System.out.println();
        System.out.println("Enter the numbers all at once or one at a time. ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader inputNum = new BufferedReader(isr);

        // populate array
        for(int i = 0; i < total; i++) {
            System.out.println("Number " + (i+1) + ": ");
            nums.add(Integer.parseInt(inputNum.readLine()));
        }// end for

        System.out.println("You have added " + total + " numbers into the data set");
    }// end enterNums()

    // generate random numbers and populate array with the numbers
    public void generateNums() {
        System.out.println();
        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        // ask user for how many numbers to input and the highest number they want in the list
        System.out.println("How many numbers would you like to add into the list: ");
        int total = input.nextInt();

        System.out.println("Highest possible number you want to generate: ");
        int max = input.nextInt();

        // populate array
        for(int i = 0; i < total; i++) {
            nums.add(rand.nextInt(max));
        }// end for

        System.out.println(total + " random numbers have been added to the data set");
    }// end generateNums()

    // clear the contents of array
    public void clearArr() {
        nums.clear();
        System.out.println("The list has been cleared");
    }// end clearArr()

    // print array contents
    public void displayArr() {
        for (int num : nums) {
            System.out.print(" " + num + " ");
        }// end for
    }// end displayArr()

    // randomly shuffle the contents of the array
    public void shuffleArr() {
        // declare variables
        Random rand = new Random();
        int maxIndex = nums.size() - 1;
        int randIndex;

        // swap random indexes
        for(int i = 0; i < nums.size(); i++) {
            // store a random index
            randIndex = rand.nextInt(maxIndex);

            // make swap
            Collections.swap(nums,i,randIndex);
        }// end outer for

        System.out.println();
        System.out.println("The list has been shuffled");
    }// end shuffleArr()

    // read numbers from a file and return an arraylist
    public void readFile() {
        Scanner input = new Scanner(System.in);

        // get the file name
        System.out.println();
        System.out.println("Enter the name of the text file: ");
        String file = input.nextLine();


        // create a reader for the file
        try(Scanner reader = new Scanner(Paths.get(file))) {

            // read the file and add the contents to the arraylist
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(" ");

                // loop through all the numbers on that line
                for (String s : parts) {
                    nums.add(Integer.valueOf(s));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // get the current system time
    public void startTimer() {
        // get the current system time in milliseconds
        this.startTime = System.currentTimeMillis();
    }

    // get the system current time, subtract it from the starting time to get the difference
    public void endTimer() {
        // get the current system time in milliseconds
        this.endTime = System.currentTimeMillis();
        this.timeTaken = this.endTime - this.startTime;
    }

    public void printStats() {
        System.out.println();
        System.out.println("Size of list: " + nums.size());
        System.out.println("Comparisons: " + this.comparisons);
        System.out.println("Swaps: " + this.swaps);
        System.out.println("Total time taken: " + this.timeTaken + " milliseconds");
    }

    public void resetCounters() {
        this.comparisons = 0;
        this.swaps = 0;
        this.startTime = 0;
        this.endTime = 0;
        this.timeTaken = 0;
    }

    public int getSize() {
        return nums.size();
    }
}// end sample.Sort class

