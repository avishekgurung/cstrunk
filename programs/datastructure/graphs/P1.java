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
		//adjMatrix[y][x] = 1;
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

	boolean pathExists = false;

	public void simplePathExists(char start, char end){
		if(start == end){
			pathExists = true;
			return;
		}

		int index = getIndex(start);
		vertexList[index].visited = true;
		for(int i=0;i<count;i++){
			if(adjMatrix[index][i] == 1 && !vertexList[i].visited){
				simplePathExists(vertexList[i].label,end);
			}
		}
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


class P1{
	public static void main(String args[]){
		//The graph used is the one shown in graph.png
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		
		g.addEdge('A','B');
		g.addEdge('B','C');
		g.addEdge('D','B');
		//g.addEdge('B','D');
		g.addEdge('B','E');
		
		g.simplePathExists('A','D');
		System.out.println("Path exists? "+g.pathExists);		
			
	}
}

/*
Here we just see if the simple path exists between two vertices or not. We do not check if there exists more than one
path that are not simple or not. In a graph IF THERE IS EVEN ONE SIMPLE PATH between two vertices then we 
return true. 
If the path does not exists like, in above case then we return false;

*/