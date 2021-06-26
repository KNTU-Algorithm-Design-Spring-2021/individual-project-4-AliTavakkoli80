package ir.ac.kntu;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static javafx.scene.paint.Color.RED;
import static javafx.scene.paint.Color.WHITE;

public class Graph {
    // A list of lists to represent an adjacency list
//    int xGraphSceneSize = 1000;
//    int yGraphSceneSize = 800;
//    Scene graphScene;
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
//    public Scene getGraphScene() {
//        return graphScene;
//    }

}
