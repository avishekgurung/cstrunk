import java.util.LinkedList;
import java.util.Queue;

class Graph{
	int count;
	int maxVertex;
	char[] vertexList;
	int[][] adjmatrix;
	int distanceTable[];
	int MAX_VAL;
	String path[];
	public Graph(){
		MAX_VAL = 10000;
		count = 0;
		maxVertex = 10;
		vertexList = new char[maxVertex];
		adjmatrix = new int[maxVertex][maxVertex];
	}

	//This is called Bellman-Ford Algorithm, same that of weighted graphs algo

	public void shortestPath(char start){
		distanceTable = new int[count];
		for(int i=0;i<count;i++){
			distanceTable[i] = MAX_VAL;
		}

		int index = getIndex(start);
		distanceTable[index] = 0;

		path = new String[count];
		path[index] = start+"";
		Queue<Character> q = new LinkedList<Character>();
		q.add(start);

		while(!q.isEmpty()){
			Character temp = q.remove();
			index = getIndex(temp);
			for(int i=0;i<count;i++){
				if(adjmatrix[index][i] != 0){
					int newPath = distanceTable[index] + adjmatrix[index][i];
					if(newPath < distanceTable[i]){
						distanceTable[i] = newPath;
						q.add(vertexList[i]);
						path[i] = path[index]+" -> "+vertexList[i];
					}
				}
			}
		}

		//display
		for(int i=0;i<count;i++){
			System.out.println(start+" to "+vertexList[i]+" = "+distanceTable[i]+"\tPATH: "+path[i]);
		}

	}

	public void addVertex(char label){
		vertexList[count++] = label;
	}

	public void addEdge(char start, char end, int weight){
		int x = getIndex(start);
		int y = getIndex(end);
		adjmatrix[x][y] = weight;
	}

	public int getIndex(char label){
		for(int i=0;i<count;i++){
			if(vertexList[i] == label){
				return i;
			}
		}
		return -1;
	}
}


class ShortestPathWeightedNegativeEdgeGraph{
	public static void main(String args[]){
		Graph g = new Graph();
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
	

		g.addEdge('C','F',10);

		g.addEdge('C','A',2);
		g.addEdge('A','D',-3);
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
