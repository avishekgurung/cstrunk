class Graph{
	int adjMatrix[][];
	int vertexCount;

	Graph(int vertexCount){
		this.vertexCount = vertexCount;
		adjMatrix = new int[vertexCount][vertexCount];
	}

	public void addEdge(int a, int b, int val){
		if(a >= vertexCount || b >= vertexCount){
			System.out.println("invalid vertices");
			return;
		}
		adjMatrix[a][b] = val;
	}

	public int getEdge(int a, int b){
		if(a >= vertexCount || b >= vertexCount){
			System.out.println("invalid vertices");
			return 0;
		}
		return adjMatrix[a][b];
	}

	public void removeEdge(int a, int b){
		if(a >= vertexCount || b >= vertexCount){
			System.out.println("invalid vertices");
			return;
		}
		adjMatrix[a][b] = 0;
	}
}


class AdjMatrix{
	public static void main(String args[]){
		Graph graph = new Graph(4);
		graph.addEdge(0,1,1);
		graph.addEdge(0,3,1);
		graph.addEdge(2,3,1);
		graph.addEdge(1,2,1);
		graph.addEdge(2,0,1);

		System.out.println(graph.getEdge(0,1));
		graph.removeEdge(0,1);
		System.out.println(graph.getEdge(0,1));
	}
}

/*
To perform many graph operations time complexity required would be O(v2) where v is the vertices.
Space complexity is always O(v2).
*/
