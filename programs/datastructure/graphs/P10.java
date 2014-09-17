import java.util.LinkedList;
import java.util.Queue;
/* A graph is strongly connected if there exists a path between all vertices. A strongly connected components
are those vertices, such that if it is possible to travel from one vertices to another and vice versa.
*/
class Graph{
	int count;
	int maxVertex;
	int [][] adjMatrix;
	char[] vertexList;
	int visited[];
	Stack<Character> s;
	Graph(){
		count = 0;
		maxVertex = 10;
		adjMatrix = new int[maxVertex][maxVertex];
		vertexList = new char[maxVertex];
		visited = new int[maxVertex];
		stack = new Stack<Character>();
	}
 
	public void stronglyConnectedComponents(char start){
		DS(start);

		for(int i=0;i<count;i++){
			visited[i] = 0;
		}

		transpose();

		DFSUtil(start);
	}

	public void transpose(){
		int temp[] = new int[];

		for(int i=0;i<count;i++){
			for(int j=0;j<count;j++){
				temp[i][j] = adjMatrix[j][i];
			}
		}

		adjMatrix = temp;
	}

	public void DFS(char start){
		int index = getIndex(start);
		visited[i] = 1;
		for(int i=0;i<count;i++){
			if(adjMatrix[index][i] == 1 && visited[i] == 0){
				DFS(vertexList[i]);
			}
		}
		stack.push(start);
	}

	public void DFSUtil(char start){
		int index = getIndex(start);
		visited[i] = 1;
		System.out.print(start+" ");
		for(int i=0;i<count;i++){
			if(adjMatrix[index][i] == 1 && visited[i] == 0){
				DFS(vertexList[i]);
			}
		}
	}

	public int getIndex(char label){
		for(int i=0;i<count;i++){
			if(vertexList[i] == label){
				return i;
			}
		}
		return -1;
	}

	public void addEdge(char start, char end){
		int x = getIndex(start);
		int y = getIndex(end);
		adjMatrix[x][y] = 1;
	}

	public void addVertex(char label){
		vertexList[count++] = label;
	}
}

class P10{
	public static void main(String args[]){
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');

		g.addEdge('A','B');
		g.addEdge('A','C');
		g.addEdge('C','D');
		g.addEdge('D','E');
		//g.addEdge('E','A');

		//System.out.println(g.hasCycle('A'));
		System.out.println(g.hasCycleAlter('A','\0'));
	}
}