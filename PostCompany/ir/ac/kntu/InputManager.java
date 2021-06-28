package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputWeightLimitGetter(){
        System.out.println("Enter weight limit : ");
        return scanner.nextInt();
    }

    public int inputTruckGetter(){
        System.out.println("Enter number of trucks : ");
        return scanner.nextInt();
    }

    public ArrayList<Integer> inputArrayGetter(){
        System.out.println("Enter number of stuffs : ");
        int N = scanner.nextInt();
        ArrayList<Integer> stuffs = new ArrayList(N);
        System.out.println("Enter stuffs weight : ");
        for (int i = 0; i < N; i++) {
            stuffs.add(scanner.nextInt());
        }
        return stuffs;
    }
}
