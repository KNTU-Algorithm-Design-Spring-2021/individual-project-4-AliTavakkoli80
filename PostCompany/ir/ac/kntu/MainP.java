package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainP {

    public static void main(String[] args) {


        InputManager inputManager = new InputManager(new Scanner(System.in));
        OutputManager outputManager = new OutputManager();

        int weight = inputManager.inputWeightLimitGetter();
        ArrayList<Integer> stuffs = inputManager.inputArrayGetter();
        Collections.sort(stuffs);
        int k = inputManager.inputTruckGetter();


        ArrayList<ArrayList> trucks = new ArrayList(k);
        while (stuffs.size() > 0) {
            ArrayList<Integer> tmpBar = new ArrayList();
            int i = 0;
            while (sumFind(tmpBar) < weight && stuffs.size() != 0 ) {
                tmpBar.add(stuffs.get(stuffs.size() - 1));
                stuffs.remove(stuffs.size() - 1);
                i++;
            }
            if (i-1 > k){
                outputManager.showError();
            }
            trucks.add(tmpBar);
        }
        outputManager.showArray(trucks);
    }

    public static int sumFind(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }
        return sum;
    }
}
