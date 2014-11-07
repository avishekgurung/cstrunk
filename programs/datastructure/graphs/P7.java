import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;

class Graph{
	int count;
	int maxVertex;
	int [][] adjMatrix;
	char[] vertexList;
	int visited[];
	Set<Character> set;

	Graph(){
		count = 0;
		maxVertex = 10;
		adjMatrix = new int[maxVertex][maxVertex];
		vertexList = new char[maxVertex];
		visited = new int[maxVertex];
		set = new HashSet<Character>();
	}


//The directed graph will have cycle if it contains back edge. So if the adjacent vertex is visited and is also a parent
//of the current vertex then we say that the graph has cycle. 

	public boolean hasCycle(char start){
		int index = getIndex(start);
		visited[index] = 1;
		set.add(start);
		for(int i=0;i<count;i++){
			if(adjMatrix[index][i] == 1 && visited[i] == 1 && set.contains(vertexList[i])){
				//System.out.println("Has Cycle "+" "+start+" "+vertexList[i]);
				return true;
			}
			if(adjMatrix[index][i] == 1 && visited[i] != 1){
				boolean flag = hasCycle(vertexList[i]);
				if(flag){
					return true;
				}
			}
		}
		set.remove(start);
		return false;
	}

	public boolean hasCycleAlter(char start, char parent){
		int index = getIndex(start);
		visited[index] = 1;
		for(int i=0;i<count;i++){
			if(adjMatrix[index][i] == 1 && visited[i] == 1 && vertexList[i] != parent){
				return true;
			}
			if(adjMatrix[index][i] == 1 && visited[i] != 1){
				boolean flag = hasCycleAlter(vertexList[i],start);
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
	}

	public void addVertex(char label){
		vertexList[count++] = label;
	}
}

class P7{
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