package Graph.representation;

import java.util.ArrayList;

public class AdjancyListGraph {

    private ArrayList<Integer>[] list;
    int V;

    public AdjancyListGraph(int v){
        this.V = v;
        list = new ArrayList[v];
        for(int i = 0 ; i < v ; i ++){
            list[i] = new ArrayList<>();
        }
    }

    public void addEdge(int i , int j , boolean unDirected){
        list[i].add(j);
        if(unDirected){
            list[j].add(i);
        }
    }


    public static void main(String[] args) {
        AdjancyListGraph g = new AdjancyListGraph(6);
        g.addEdge(0,1, true);
        g.addEdge(0,4, true);
        g.addEdge(2,1, true);
        g.addEdge(3,4, true);
        g.addEdge(4,5, true);
        g.addEdge(2,3, true);
        g.addEdge(3,5, true);
        g.printAdjList();
    }

    public void printAdjList() {

        for(int i = 0 ; i < V ; i++){
            System.out.print(i+"--->");
            for(Integer value : list[i]){
                System.out.print(value+" ");
            }
            System.out.println("");
        }


    }


}




