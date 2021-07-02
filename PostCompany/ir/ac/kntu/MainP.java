package ir.ac.kntu;

import java.util.*;

public class MainP {

    public static void main(String[] args) {


        InputManager inputManager = new InputManager(new Scanner(System.in));
        OutputManager outputManager = new OutputManager();

        int[] stuffs = inputManager.inputArrayGetter();
        int k = inputManager.inputTruckGetter();

        outputManager.showArray(partitionIntoKSegments(stuffs,stuffs.length,k));
    }

    static ArrayList<ArrayList<Integer>> partitionIntoKSegments(int arr[], int N, int K) {

        // Stores the partitions
        ArrayList<ArrayList<Integer>> P = new ArrayList<ArrayList<Integer>>();

        // If N is less than K
        if (N < K) {
            System.out.println("Invalid inputs");
            return P;
        }

        // Map to store the K
        // largest elements
        HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();

        // Auxiliary array to
        // store and sort arr[]
        Integer[] temp = new Integer[N];

        // Stores the maximum sum
        int ans = 0;

        // Copy arr[] to temp[]
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }

        // Sort array temp[] in
        // descending order
        Arrays.sort(temp, Collections.reverseOrder());
        //Array.Reverse(temp);

        // Iterate in the range [0, K - 1]
        for (int i = 0; i < K; i++) {

            // Increment sum by temp[i]
            ans += temp[i];

            // Increment count of
            // temp[i] in the map mp
            if (mp.containsKey(temp[i]))
                mp.get(temp[i]++);
            else
                mp.put(temp[i], 1);
        }



        // Stores temporary subarrays
        ArrayList<Integer> V = new ArrayList<Integer>();

        // Iterate over the range [0, N - 1]
        for (int i = 0; i < N; i++) {
            V.add(arr[i]);

            // If current element is
            // one of the K largest
            if (mp.containsKey(arr[i]) && mp.get(arr[i]) > 0) {
                mp.get(arr[i]--);
                K--;

                if (K == 0) {
                    i++;

                    while (i < N) {
                        V.add(arr[i]);
                        i++;
                    }
                }

                if (V.size() > 0) {
                    P.add(new ArrayList<Integer>(V));
                    V.clear();
                }
            }
        }

        // Print the ans
        System.out.println(ans);


        // Print the partition
        return P;
    }
}
