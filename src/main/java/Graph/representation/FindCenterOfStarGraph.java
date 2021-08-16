package Graph.representation;

public class FindCenterOfStarGraph {

    public static void main(String[] args) {

        AdjancyListGraph adjancyListGraph = new AdjancyListGraph(5);
        adjancyListGraph.addEdge(1,2,true);
        adjancyListGraph.addEdge(2,3,true);
        adjancyListGraph.addEdge(4,2,true);

        adjancyListGraph.printAdjList();

        findCenterofStarGrpah(adjancyListGraph);
    }

    private static void findCenterofStarGrpah(AdjancyListGraph adjancyListGraph) {


    }


}
