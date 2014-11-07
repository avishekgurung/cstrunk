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

	public boolean isConnected(char start){
		int vertexCount = 0;
		Queue<Character> q = new LinkedList<Character>();
		q.add(start);

		while(!q.isEmpty()){
			Character temp = q.remove();
			int index = getIndex(temp);
			visited[index] = 1;
			vertexCount++;
			for(int i=0;i<count;i++){
				if(adjMatrix[index][i] == 1 && visited[i] == 0){
					q.add(vertexList[i]);
				}
			}
		}

		if(vertexCount == count){
			return true;
		}
		else{
			return false;
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
		adjMatrix[y][x] = 1;
	}

	public void addVertex(char label){
		vertexList[count++] = label;
	}
}

class P4{
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

		System.out.println("Is Connected: "+g.isConnected('A'));
	}
}

/*
	If same question is asked for directed graph then for the graph to be connected,
	all the edges should be present, hence the no of edges should be n(n-1)/2
*/