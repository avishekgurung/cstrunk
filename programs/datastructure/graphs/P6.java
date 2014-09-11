import java.util.LinkedList;
import java.util.Queue;

class Graph{
	int count;
	int maxVertex;
	int [][] adjMatrix;
	char[] vertexList;
	int visited[];

	Graph(){
		count = 0;
		maxVertex = 10;
		adjMatrix = new int[maxVertex][maxVertex];
		vertexList = new char[maxVertex];
		visited = new int[maxVertex];
	}

	public boolean hasCycle(char start, char parent){
		int index = getIndex(start);

		visited[index] = 1;
		for(int i=0;i<count;i++){
			//Cycle: if the adjacent vertex is visited and is not a parent of the current vertex
			if(adjMatrix[index][i] == 1 && visited[i] == 1 && vertexList[i] != parent){
				//System.out.println("Has Cycle "+parent+" "+start+" "+vertexList[i]);
				return true;
			}
			if(adjMatrix[index][i] == 1 && visited[i] != 1){
				boolean flag = hasCycle(vertexList[i],start);
				if(flag){
					return true;
				}
			}
		}
		return false;
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
		adjMatrix[y][x] = 1;
	}

	public void addVertex(char label){
		vertexList[count++] = label;
	}
}

class P6{
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
		g.addEdge('E','B');

		//g.hasCycle('A','\0');
		System.out.println(g.hasCycle('A','\0'));
	}
}