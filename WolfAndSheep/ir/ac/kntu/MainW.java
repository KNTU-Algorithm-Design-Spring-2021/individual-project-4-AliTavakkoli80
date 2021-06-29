package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import static ir.ac.kntu.Graph.isConnected;


//public class MainW extends Application {
public class MainW {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        InputManagerW inputManager = new InputManagerW(scanner);
        ArrayList<Edge> edges = inputManager.edgeGetter();

//        edges.add(Edge.of(0, 7));
//        edges.add(Edge.of(0, 3));
//        edges.add(Edge.of(1, 0));
//        edges.add(Edge.of(1, 2));
//        edges.add(Edge.of(1, 4));
//        edges.add(Edge.of(2, 7));
//        edges.add(Edge.of(3, 4));
//        edges.add(Edge.of(3, 5));
//        edges.add(Edge.of(4, 3));
//        edges.add(Edge.of(4, 6));
//        edges.add(Edge.of(5, 6));
//        edges.add(Edge.of(6, 7));
//        0 7
//        0 3
//        1 0
//        1 2
//        1 4
//        2 7
//        3 4
//        3 5
//        4 3
//        4 6
//        5 6
//        6 7
        System.out.println(edges.toString());
        System.out.println(edges.size());
        int src, dest;
        src = inputManager.enterSource();
        dest = inputManager.enterDest();

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
        for (i = 0; i < pathSheep.size() - 1; i++) {
            for (int j = 0; j < edges.size(); j++) {
//                System.out.println(edge.source + "   " + edge.dest);
                if (edges.get(j).source == pathSheep.get(i) &&
                        edges.get(j).dest == pathSheep.get(i + 1)) {
                    edges.remove(j);
                }
            }
        }




        Graph graphWolf = new Graph(edges, edges.size());
        System.out.println(edges.toString());
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

//    public static void main(String[] args) {
//        launch(args);
//    }

//    @Override
//    public void start(Stage stage) throws Exception {
//
//
//        Pane pane = new Pane();
//        ArrayList<Circle> circles = new ArrayList<Circle>(N);
//        for (int j = 0; j < N / 2; j++) {
//            Circle circle = new Circle(100, (j + 1) * 100,3,RED);
//            circles.add(circle);
//        }
//        for (int j = N / 2; j < N; j++) {
//            Circle circle = new Circle(300, (j - (N / 2) + 1) * 100,3,RED);
//            circles.add(circle);
//        }
//        pane.getChildren().addAll(circles);
//
//        Scene graphScene = new Scene(pane, 1000, 800, WHITE);
//
//        stage.setTitle(" Box Diagram ");
//        stage.setScene(graphScene);
//        stage.show();
//
////        stage.setTitle(" Box Diagram ");
////        stage.setScene(graphWolf.getGraphScene());
////        stage.show();
//
//    }
}