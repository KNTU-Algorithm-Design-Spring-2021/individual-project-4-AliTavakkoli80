package ir.ac.kntu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// A class to store a graph edge
class Edge {
    public final int source, dest;

    private Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    // Factory method for creating an immutable instance of `Edge`
    public static Edge of(int a, int b) {
        return new Edge(a, b);        // calls private constructor
    }
}

// A class to represent a graph object
class Graph {
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
    List<Edge> edges;
    int N;

    // Constructor
    Graph(ArrayList<Edge> edges, int N) {
        adjList = new ArrayList<>();
        this.edges = edges;
        this.N = N;
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        // add edges to the undirected graph
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }

}

class Main {
    // Function to perform DFS traversal in a directed graph to find the
    // complete path between source and destination vertices
    public static boolean isConnected(Graph graph, int src, int dest,
                                      boolean[] discovered, Stack<Integer> path) {
        // mark the current node as discovered
        discovered[src] = true;

        // include the current node in the path
        path.add(src);

        // if destination vertex is found
        if (src == dest) {
            return true;
        }

        // do for every edge `src —> i`
        for (int i : graph.adjList.get(src)) {
            // if `u` is not yet discovered
            if (!discovered[i]) {
                // return true if the destination is found
                if (isConnected(graph, i, dest, discovered, path)) {
                    return true;
                }
            }
        }

        // backtrack: remove the current node from the path
        path.pop();

        // return false if destination vertex is not reachable from src
        return false;
    }

    public static void main(String[] args) {
        // List of graph edges as per the above diagram
        ArrayList<Edge> edges = new ArrayList<Edge>();
        edges.add(Edge.of(0, 7));
        edges.add(Edge.of(0, 3));
        edges.add(Edge.of(1, 0));
        edges.add(Edge.of(1, 2));
        edges.add(Edge.of(1, 4));
        edges.add(Edge.of(2, 7));
        edges.add(Edge.of(3, 4));
        edges.add(Edge.of(3, 5));
        edges.add(Edge.of(4, 3));
        edges.add(Edge.of(4, 6));
        edges.add(Edge.of(5, 6));
        edges.add(Edge.of(6, 7));

//        // total number of nodes in the graph (labeled from 0 to `N-1`)
//        int N = 8;

        // source and destination vertex
        int src = 0, dest = 7;

        // build a graph from the given edges
        Graph graphSheep = new Graph(edges, edges.size());

        // to keep track of whether a vertex is discovered or not
        boolean[] discoveredSheep = new boolean[edges.size()];



        // To store the complete path between source and destination
        Stack<Integer> pathSheep = new Stack<>();

        // perform DFS traversal from the source vertex to check the connectivity
        // and store path from the source vertex to the destination vertex
        if (isConnected(graphSheep, src, dest, discoveredSheep, pathSheep)) {
            System.out.println("A path exists for sheep from vertex " + src +
                    " to vertex " + dest);
            System.out.println("The complete path for sheep is " + pathSheep);
        } else {
            System.out.println("No path exists for sheep between vertices " + src +
                    " and " + dest);
        }


        int i;
        for (i = 0; i < pathSheep.size()-1; i++) {
//            System.out.println(path.get(i) + "," + path.get(i+1));
//            System.out.println(edges.indexOf(Edge.of(path.get(i),path.get(i+1))));
            for (int j = 0; j < edges.size(); j++) {
//                System.out.println(edge.source + "   " + edge.dest);
                if (edges.get(j).source == pathSheep.get(i) && edges.get(j).dest == pathSheep.get(i + 1)) {
                    edges.remove(j);
                }
            }
//            edges.remove(Edge.of(path.get(i),path.get(i+1)));
        }

//        for (Edge edge : edges) {
//            System.out.println(edge.source + "   " + edge.dest);
//        }



        // build a graph from the given edges
        Graph graphWolf = new Graph(edges, edges.size());

        // to keep track of whether a vertex is discovered or not
        boolean[] discoveredWolf = new boolean[edges.size()];



        // To store the complete path between source and destination
        Stack<Integer> pathWolf = new Stack<>();
        if (isConnected(graphWolf, src, dest, discoveredWolf, pathWolf)) {
            System.out.println("A path exists for Wolf from vertex " + src +
                    " to vertex " + dest);
            System.out.println("The complete path for Wolf is " + pathWolf);
        } else {
            System.out.println("No path exists for Wolf between vertices " + src +
                    " and " + dest);
        }
    }
}