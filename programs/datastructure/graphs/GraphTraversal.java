import java.util.Queue;
import java.util.LinkedList;
class Graph{
	int count; 		//counts the no of vertices in a graph
	int maxVertex;  	//set the max vertex a graph can hold. Is used to initialize arrays.
	int adjMatrix[][]; 	//Represents adjacency matrix, i.e. representation of connection between edges
	int visited[]; 		//gives us the information if the vertex is already visited or not
	char vertexList[]; 	//stores all the vertices which are in the form of character.

	//process of initialization of Graph
	Graph(){
		count = 0;
		maxVertex 	= 10;
		adjMatrix 	= new int[maxVertex][maxVertex];
		visited 	= new int[maxVertex];
		vertexList 	= new char[maxVertex];
	}

	public void addVertex(char label){
		vertexList[count++] =label;
	}

	public void addEdge(char start, char end){
		int x = getIndex(start);
		int y = getIndex(end);
		adjMatrix[x][y] = 1;
		adjMatrix[y][x] = 1;
	}

	public int getIndex(char label){
		for(int i=0;i<count;i++){
			if(vertexList[i] == label){
				return i;
			}
		}
		return -1;
	}

	public void BFS(char start){
		Queue<Character> q = new LinkedList<Character>();
		q.add(start);
		while(!q.isEmpty()){
			Character temp = q.remove();
			int index = getIndex(temp);
			if(visited[index] == 0){		// The check here is important else duplicate vertices will be added in the queue.
				System.out.print(temp+"  ");
				visited[index] = 1;
				for(int i=0;i<count;i++){
					if(adjMatrix[index][i] == 1 && visited[i] == 0){ //add only those vertices which are adjacent and which are not visited before
						q.add(vertexList[i]);
					}
				}
			}
		}
		System.out.println();
	}

	public void DFS(char start){
		int index = getIndex(start);
		if(visited[index] == 1){
			return;
		}
		System.out.print(start+"  ");
		visited[index] = 1;
		for(int i=0;i<count;i++){
			if(adjMatrix[index][i] == 1 && visited[i] == 0){
				DFS(vertexList[i]);
			}
		}
	}
}

class GraphTraversal{
	public static void main(String args[]){
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		graph.addVertex('F');
		graph.addVertex('G');
		graph.addVertex('H');

		graph.addEdge('A','B');
		graph.addEdge('A','G');
		graph.addEdge('A','D');
		graph.addEdge('B','F');
		graph.addEdge('B','E');
		graph.addEdge('E','G');
		graph.addEdge('F','C');
		graph.addEdge('F','D');
		graph.addEdge('C','H');

		//graph.BFS('A');

		graph.DFS('A');
		System.out.println();
	}
}

