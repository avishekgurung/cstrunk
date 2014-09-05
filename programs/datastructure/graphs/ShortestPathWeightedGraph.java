import java.util.Queue;
import java.util.LinkedList;

class Graph{
	int count;
	char[] vertexList;
	int maxVertex;
	int adjMatrix[][];
	int distanceTable[];
	String path[];

	Graph(){
		count = 0;
		maxVertex = 10;
		vertexList = new char[maxVertex];
		adjMatrix = new int[maxVertex][maxVertex];
	}

	public void addVertex(char label){
		vertexList[count++] = label;
	}

	public void addEdge(char start, char end, int weight){
		int x = getIndex(start);
		int y = getIndex(end);
		adjMatrix[x][y] = weight;
	}

	public int getIndex(char label){
		for(int i=0;i<count;i++){
			if(vertexList[i] == label){
				return i;
			}
		}
		return -1;
	}

	//This is Dijkstra's Algorithm, so miraculously I came know without referring any thing. Praise the Lord
	public void shortestPath(char start){
		distanceTable = new int[count];
		for(int i=0;i<count;i++){
			distanceTable[i] = -1;
		}
		int index = getIndex(start);
		distanceTable[index] = 0;
		path = new String[count];
		Queue<Character> q = new LinkedList<Character>();
		q.add(start);
		path[index] = start+"";
		while(!q.isEmpty()){
			Character temp = q.remove();
			index = getIndex(temp);
			for(int i=0;i<count;i++){
				if(adjMatrix[index][i] != 0){
					int newPath = distanceTable[index] + adjMatrix[index][i];
					if(newPath < distanceTable[i] || distanceTable[i] == -1){
						distanceTable[i] = newPath;
						q.add(vertexList[i]);
						path[i] = path[index] + " -> "+ vertexList[i];
					}
				}
			}
		}

		for(int i=0;i<count;i++){
			System.out.println(start+" to "+vertexList[i]+" = "+distanceTable[i]+"\tPath: "+path[i]);
		}
	}
}

class ShortestPathWeightedGraph{
	public static void main(String args[]){
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
	

		g.addEdge('C','F',20);

		g.addEdge('C','A',2);
		g.addEdge('A','D',3);
		g.addEdge('D','F',3);

		g.addEdge('A','B',2);
		g.addEdge('B','D',1);

		g.addEdge('G','F',1);
		g.addEdge('D','G',2);
		g.addEdge('B','E',1);
		g.addEdge('E','G',1);
		
		g.shortestPath('C');
	}
}
/*
	The logic is very much similar to ShortestPathNonWeightedGraph, just some simple change in Logic
*/
