package ir.ac.kntu;

public class Edge {
    public final int source, dest;

    private Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    // Factory method for creating an immutable instance of `Edge`
    public static ir.ac.kntu.Edge of(int a, int b) {
        return new ir.ac.kntu.Edge(a, b);        // calls private constructor
    }
}
