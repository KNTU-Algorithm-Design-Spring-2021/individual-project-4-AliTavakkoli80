package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class InputManagerW {
    Scanner scanner;
    public InputManagerW(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<Edge> edgeGetter() {
        System.out.println("Enter number of edges : ");
        int N = scanner.nextInt();
        ArrayList<Edge> edges = new ArrayList<Edge>();
        System.out.println("Enter edges : ");
        for (int i = 0; i < N; i++) {
            int a,b;
            a = scanner.nextInt();
            b = scanner.nextInt();
            edges.add(Edge.of(a,b));
        }
        return edges;
    }
    public int enterSource(){
        System.out.println("Enter source : ");
        int src;
        src = scanner.nextInt();
        return src;
    }
    public int enterDest(){
        System.out.println("Enter destination : ");
        int dest;
        dest = scanner.nextInt();
        return dest;
    }
}
