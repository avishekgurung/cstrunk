import java.util.Queue;
import java.util.LinkedList;
class Graph{
	int maxVertex;
	int count;
	int adjMatrix[][];
	char[] vertexList;
	int distance[];
	String path[];

	Graph(){
		maxVertex = 10;
		count = 0;
		adjMatrix = new int[maxVertex][maxVertex];
		vertexList = new char[maxVertex];
	}

	public void addVertex(char label){
		vertexList[count++] = label;
	}

	public void addEdge(char start, char end){
		int x = getIndex(start);
		int y = getIndex(end);
		adjMatrix[x][y] = 1; //Since its DAG so no need to take [y][x] as 1
	}

	public int getIndex(char label){
		for(int i=0;i<count;i++){
			if(vertexList[i] == label){
				return i;
			}
		}
		return -1;
	}

	public void calculateShortestPath(char start){
		int sindex = getIndex(start);
		distance = new int[count];
		path = new String[count];
		for(int i=0;i<count;i++){
			distance[i] = -1;
		}

		for(int i=0;i<count;i++){
			path[i] = vertexList[i]+"";
		}

		distance[sindex] = 0;
		Queue<Character> q = new LinkedList<Character>();
		q.add(start);

		while(!q.isEmpty()){
			char temp = q.remove();
			int v = getIndex(temp);

			for(int w=0;w<count;w++){
				if(adjMatrix[v][w] == 1 && distance[w] == -1){
					q.add(vertexList[w]);
					distance[w] = distance[v] + 1;
					path[w] = path[v]+" "+vertexList[w];
				}
			}
		}

	}

	public void showVertices(){
		System.out.println("\nVertices in Graph");
		for(int i=0;i<count;i++){
			System.out.print(vertexList[i]+"  ");
		}
	System.out.println("\n");
	}

	public void showMatix(){
		System.out.println("adjacency matrix");
		for(int i=0;i<count;i++){
			for(int j=0;j<count;j++){
				System.out.print(adjMatrix[i][j]+"  ");
			}	
			System.out.println();
		}
		System.out.println();
	}

	public void showPathAndDistance(){
		System.out.println("\n Path and Distance");
		for(int i=0;i<count;i++){
			System.out.println(path[i]+" "+distance[i]);
		}
	}
}


class ShortestPathNonWeightedGraph{
	public static void main(String args[]){
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		

		g.addEdge('C','A');
		g.addEdge('C','F');
		g.addEdge('A','B');
		g.addEdge('A','D');
		g.addEdge('D','F');
		g.addEdge('G','F');
		g.addEdge('D','G');
		g.addEdge('B','E');
		g.addEdge('E','G');
		g.addEdge('B','D');
		//g.addEdge('C','E');

		g.showVertices();
		g.showMatix();

		g.calculateShortestPath('B');
		g.showPathAndDistance();
	}
}

/*
	Create a distance table with all values 0, except self loop
	Get a particular vertex.
	Add it in a queue. 

	While q is not empty, add all vertices adjacent to the said vertex in a queue.
	Calculate the distance and above vertex adding if the distance is -1.

	Learn Dijkstra's Algo.
	Bellman Ford to calculate negative edges too.
	Minimal Spanning tree: Prims and Kruskal's algo.

*/