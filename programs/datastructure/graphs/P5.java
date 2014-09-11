import java.util.LinkedList;
import java.util.Queue;

class Graph{
	int count;
	int maxVertex;
	int [][] adjMatrix;
	char[] vertexList;
	int visited[];
	int []color;

	Graph(){
		count = 0;
		maxVertex = 10;
		adjMatrix = new int[maxVertex][maxVertex];
		vertexList = new char[maxVertex];
		visited = new int[maxVertex];
		color = new int[maxVertex];
		for(int i=0;i<maxVertex;i++){
			color[i] = -1;
		}
	}

	public boolean isBipartite(char start){
		int colorFlag = 1;
		Queue<Character> q = new LinkedList<Character>();
		q.add(start);
		int index = getIndex(start);
		color[index] = colorFlag;
		while(!q.isEmpty()){
			Character temp = q.remove();
			index = getIndex(temp);
			if(visited[index] == 0){
				visited[index] = 1;
				colorFlag = 1 - color[index];
				for(int i=0;i<count;i++){

					if(adjMatrix[index][i] == 1 && visited[i] == 0){
						q.add(vertexList[i]);
						color[i] = colorFlag;
					}
					
					if(adjMatrix[index][i] == 1 && color[index] == color[i]){
						return false;
					}
				}
			}
		}

		return true;
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

class P5{
	public static void main(String args[]){
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');

		g.addEdge('A','B');
		g.addEdge('A','D');
		g.addEdge('C','D');
		g.addEdge('C','F');
		g.addEdge('E','D');
		g.addEdge('E','F');
		g.addEdge('D','F');

		System.out.println("Is Bipartite: "+g.isBipartite('A'));
	}
}