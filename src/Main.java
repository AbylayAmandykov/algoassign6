public class Main {
    public static void main(String[] args) {
        MyGraph<Integer> temp = new MyGraph<>();
        temp.addVertex(1);
        temp.addVertex(3);
        temp.addVertex(2);
        temp.addVertex(4);
        temp.addEdge(1, 3, 70);
        temp.addEdge(1, 2, 40);
        temp.addEdge(2, 3, 50);
        temp.addEdge(3, 4, 30);
        temp.printGraph();
        temp.removeEdge(2,3);
        System.out.println(temp.hasEdge(1,3));
        System.out.println(temp.hasEdge(2,3));
        System.out.print("DFS: "); temp.DFS(1);
        System.out.println();
        System.out.print("BFS: "); temp.BFS(1);
        System.out.println();
        temp.addEdge(2, 3, 50);
        System.out.println(temp.dijkstra(2));
        temp.removeEdge(2, 3);
        System.out.println("After removing 2-3 edge: " + temp.dijkstra(2));
    }
}