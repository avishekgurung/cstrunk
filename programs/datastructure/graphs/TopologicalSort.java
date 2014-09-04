import java.util.Queue;
import java.util.LinkedList;
class Graph{
	int maxVertex;
	int count;
	int adjMatrix[][];
	char[] vertexList;
	int indegreeTable[];
	char topologicalTable[];

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

	public void createIndegreeTable(){
		indegreeTable = new int[count];
		for(int i=0;i<count;i++){
			for(int j=0;j<count;j++){
				if(adjMatrix[i][j] != 0){
					indegreeTable[j] = indegreeTable[j]+1;
				}
			}
		}
	}

	public void createTopologicalList(){
		topologicalTable = new char[count];
		int tableIndex = 0;
		Queue<Character> q = new LinkedList<Character>();
		for(int i=0;i<count;i++){
			if(indegreeTable[i] == 0){
				q.add(vertexList[i]);
				topologicalTable[tableIndex] = vertexList[i];
				tableIndex++;
			}
		}

		while(!q.isEmpty()){
			char temp = q.remove();
			int index = getIndex(temp);
			for(int i=0;i<count;i++){
				if(adjMatrix[index][i] != 0){
					indegreeTable[i] = indegreeTable[i] -1;
					if(indegreeTable[i] == 0){
						q.add(vertexList[i]);
						topologicalTable[tableIndex] = vertexList[i];
						tableIndex++;
					}
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

	public void showIndegreeTable(){
		System.out.println("Indegree Table ");
		for(int i=0;i<count;i++){
			System.out.print(indegreeTable[i]+"  ");
		}
		System.out.println();
	}

	public void showTopologicalTable(){
		System.out.println("\nTopological Sorting");
		for(int i=0;i<count;i++){
			System.out.print(topologicalTable[i]+"  ");
		}
		System.out.println();
	}
}

class TopologicalSort{
	public static void main(String args[]){
		Graph g = new Graph();
		g.addVertex('M');
		g.addVertex('N');
		g.addVertex('O');
		g.addVertex('G');
		g.addVertex('K');
		g.addVertex('F');
		g.addVertex('C');
		g.addVertex('P');

		g.addEdge('M','G');
		g.addEdge('N','G');
		g.addEdge('M','K');
		g.addEdge('O','K');
		g.addEdge('G','F');
		g.addEdge('G','C');
		g.addEdge('K','C');
		g.addEdge('O','P');
		g.addEdge('O','N');
		g.addEdge('N','M');
		g.addEdge('C','F');

		g.showVertices();
		g.showMatix();
		g.createIndegreeTable();
		g.showIndegreeTable();
		g.createTopologicalList();
		g.showTopologicalTable();
	}
}

/*
	The problem does not involve complicated logics. Its just the use of several arrays and their manupulations
	The solution becomes easy if we implement and write all the arrays in the paper for reference and then code.
	For the logic please follow the book too.
*/