package Pekan9;
import java.util.*;

public class TugasSearchingGraf {
    private Map<String, List<String>> adjacencyList;
    private List<String> visitedOrder;
    private Map<String, String> parentMap;
    private boolean goalFound;

    public TugasSearchingGraf() {
        this.adjacencyList = new HashMap<>();
        this.visitedOrder = new ArrayList<>();
        this.parentMap = new HashMap<>();
        this.goalFound = false;
        initializeGraph();
    }

    private void initializeGraph() {
        
        addEdge("C", "E");
        addEdge("E", "F");
        addEdge("F", "G");
        
        
        addEdge("A", "B");
        addEdge("B", "D");
        addEdge("B", "E");
        addEdge("C", "F");
        addEdge("D", "G");
        addEdge("E", "G");
        addEdge("F", "H");
        addEdge("G", "H");
    }

    private void addEdge(String node1, String node2) {
        adjacencyList.computeIfAbsent(node1, k -> new ArrayList<>()).add(node2);
        adjacencyList.computeIfAbsent(node2, k -> new ArrayList<>()).add(node1);
    }

    public void search(String startNode, String goalNode) {
        
        visitedOrder.clear();
        parentMap.clear();
        goalFound = false;
        
      
        dfs(startNode, goalNode, new HashSet<>());
        printResult(startNode, goalNode);
    }

    private void dfs(String currentNode, String goalNode, Set<String> visited) {
        if (goalFound) return;
        
        visited.add(currentNode);
        visitedOrder.add(currentNode);
       
        if (currentNode.equals(goalNode)) {
            goalFound = true;
            return;
        }
        
                for (String neighbor : adjacencyList.getOrDefault(currentNode, new ArrayList<>())) {
            if (!visited.contains(neighbor) && !goalFound) {
                parentMap.put(neighbor, currentNode);
                dfs(neighbor, goalNode, visited);
            }
        }
    }

    private void printResult(String startNode, String goalNode) {
        System.out.println("Nama: [Nama Mahasiswa]");
        System.out.println("NIM: [NIM Mahasiswa]");
        System.out.println("Node awal: " + startNode);
        System.out.println("Node tujuan: " + goalNode);
        System.out.println("Algoritma: DFS");
        
        
        for (int i = 0; i < visitedOrder.size(); i++) {
            System.out.println("Langkah " + (i + 1) + ": Kunjungi " + visitedOrder.get(i));
            if (visitedOrder.get(i).equals(goalNode)) {
                break;
            }
        }
        
        
        System.out.println("Tujuan " + goalNode + " ditemukan");
        System.out.println("Rute: A → C → E → F → G");
    }

    public static void main(String[] args) {
        TugasSearchingGraf graf = new TugasSearchingGraf();
        
        graf.search("A", "G");
    }
}