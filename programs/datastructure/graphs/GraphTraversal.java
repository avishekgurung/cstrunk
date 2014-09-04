import java.util.Queue;
import java.util.LinkedList;

class Vertex{
	char label;
	boolean visited;

	Vertex(char label){
		this.label = label;
		visited = false;
	}
}

class Graph{
	int maxVertex; 			//Just to limit the total no of vertices that can be used in graph
	Vertex vertexList[]; 	//We create an array of vertices
	int adjMatrix[][]; 		//This is an adjacency matrix to check if edge exists between pair of vertices
	int count; 				//Gives the total number of vertices in a graph

	Graph(){
		maxVertex  	= 10;
		adjMatrix 	= new int[maxVertex][maxVertex];
		vertexList 	= new Vertex[maxVertex];
		count = 0;		
	}

	public void addVertex(char label){
		Vertex vertex = new Vertex(label);
		vertexList[count] = vertex;
		count++;
	}

	public void addEdge(char start, char end){
		int x = getIndex(start);
		int y = getIndex(end);
		adjMatrix[x][y] = 1;
		adjMatrix[y][x] = 1;
	}

	public void showVertex(int i){
		System.out.println(vertexList[i].label);
	}

	public int getIndex(char vertex){
		for(int i=0;i<count;i++){
			if(vertexList[i].label == vertex){
				return i;
			}
		}
		return -1;
	}

	public void DFS(Vertex vertex){
		if(vertex.visited){
			return;
		}

		vertex.visited = true;
		System.out.print(vertex.label+"\t");
		int index = getIndex(vertex.label);
		for(int i=0;i<count;i++){
			if(adjMatrix[index][i] == 1){
				DFS(vertexList[i]);
			}
		}
	}

	public void BFS(Vertex vertex){
		System.out.println("BFS Traversal of Graph");

		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(vertex);
		while(!q.isEmpty()){
			Vertex temp = q.remove();
			if(!temp.visited){
				System.out.print(temp.label+"\t");
				temp.visited = true;
				int index = getIndex(temp.label);
				for(int i=0;i<count;i++){
					if(adjMatrix[index][i] == 1){
						q.add(vertexList[i]);
					}
				}
			}
		}
		System.out.println("\n");
	}

	public void showVertices(){
		System.out.println("\nVertices in Graph");
		for(int i=0;i<count;i++){
			System.out.print(vertexList[i].label+" ");
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
}


class GraphTraversal{
	public static void main(String args[]){
		//The graph used is the one shown in graph.png
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		g.addVertex('H');

		g.addEdge('A','B');
		g.addEdge('A','G');
		g.addEdge('A','D');
		g.addEdge('B','E');
		g.addEdge('E','G');
		g.addEdge('G','A');
		g.addEdge('B','F');
		g.addEdge('B','A');
		g.addEdge('F','D');
		g.addEdge('F','C');
		g.addEdge('C','H');

		Vertex start = g.vertexList[0];

		g.showVertices();
		g.showMatix();

		//Depth First Search
		/*System.out.println("BFS Traversal of Graph");
		g.DFS(start);
		System.out.println("\n");*/

		//Bread First Search
		g.BFS(start);
			
	}
}


//https://www.youtube.com/watch?v=zLZhSSXAwxI Tutorial