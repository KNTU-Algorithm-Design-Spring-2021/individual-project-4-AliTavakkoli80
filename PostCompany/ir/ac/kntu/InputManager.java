package ir.ac.kntu;

import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;

    public InputManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputTruckGetter(){
        System.out.println("Enter number of trucks : ");
        return scanner.nextInt();
    }

    public int[] inputArrayGetter(){
        System.out.println("Enter number of stuffs : ");
        int N = scanner.nextInt();
        int[] stuffs = new int[N];
        System.out.println("Enter stuffs weight : ");
        for (int i = 0; i < N; i++) {
            stuffs[i] = scanner.nextInt();
        }
        return stuffs;
    }
}
