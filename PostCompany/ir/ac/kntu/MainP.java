package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainP {

    public static void main(String[] args) {


        InputManager inputManager = new InputManager(new Scanner(System.in));
        OutputManager outputManager = new OutputManager();

        int[] stuffs = inputManager.inputArrayGetter();
        int k = inputManager.inputTruckGetter();


        outputManager.showArray(greedyForPartitions(stuffs, stuffs.length, k, solve(stuffs, stuffs.length, k)));

    }

    static boolean check(int mid, int array[], int n, int K) {

        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            // If individual element is greater
            // maximum possible sum
            if (array[i] > mid)
                return false;

            // Increase sum of current sub - array
            sum += array[i];

            // If the sum is greater than
            // mid increase count
            if (sum > mid) {
                count++;
                sum = array[i];
            }
        }
        count++;
//        System.out.println(count);
        // Check condition
        if (count <= K)
            return true;
        return false;
    }

    // Function to find maximum subarray sum
    // which is minimum
    static int solve(int array[], int n, int K) {
        int start = 1;
        for (int i = 0; i < n; ++i) {
            if (array[i] > start)
                start = array[i];
        }
        int end = 0;

        for (int i = 0; i < n; i++) {
            end += array[i];
        }

        // Answer stores possible
        // maximum sub array sum
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            // If mid is possible solution
            // Put answer = mid;
            if (check(mid, array, n, K)) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }

    public static ArrayList<ArrayList<Integer>> greedyForPartitions(int[] array, int n, int k, int wLimit) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(k);
        ArrayList<Integer> tmpinput = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tmpinput.add(array[i]);
        }
        Collections.sort(tmpinput);
        Collections.reverse(tmpinput);
//        System.out.println(tmpinput.toString());
        boolean flag = true;
        while (tmpinput.size() > 0) {
            ArrayList<Integer> tmpArrayList = new ArrayList<>();
            while (sum(tmpArrayList, tmpArrayList.size())+tmpinput.get(0) <= wLimit) {
                tmpArrayList.add(tmpinput.get(0));
                tmpinput.remove(0);
                if (tmpinput.size() == 0){
                    break;
                }
//                System.out.println(tmpinput.get(tmpinput.size()-1));
            }
            result.add(tmpArrayList);
        }
        return result;
    }

    public static int sum(ArrayList<Integer> arrayList, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arrayList.get(i);
        }
        return sum;
    }
}
