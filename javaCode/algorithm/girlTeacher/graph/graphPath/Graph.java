package algorithm.girlTeacher.graph.graphPath;

public class Graph {

	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private int[][] adjMat;
	private Vertex[] vertexList;
	private int nVerts;
	private int nTree;
	private DistPar[] sPath;
	private int currentVert;
	private int startToCurrent;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		nTree = 0;
		for (int i = 0; i < nVerts; i++) {
			for (int j = 0; j < nVerts; j++) {
				adjMat[i][j] = INFINITY;
			}
		}
		
		sPath = new DistPar[MAX_VERTS];
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	// 添加边：有向图，所以只有一个方向
	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
	}
	
	/**
	 * 最短路径
	 */
	public void path() {
		int startTree = 0;
		vertexList[startTree].isInTree = true;
		nTree = 1;
		for (int i = 0; i < nVerts; i++) {
			int tempDist = adjMat[startTree][i];
			sPath[i] = new DistPar(startTree, tempDist);
		}
		
		while(nTree < nVerts) {
			int indexMin = getMin();
			int minDist = sPath[indexMin].distance;
			if(minDist == INFINITY) {
				System.out.println("There are unreachable vertex.");
				break;
			}else {
				currentVert = indexMin;
				startToCurrent = sPath[indexMin].distance;
			}
			vertexList[currentVert].isInTree = true;
			nTree++;
			adjust_sPath();
		}
		
		displayPaths();
		nTree = 0;
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isInTree = false;
		}
	}
	/**
	 * 从起点开始，邻接权值最小的连通的顶点
	 * @return
	 */
	public int getMin() {
		int minDist = INFINITY;
		int indexMin = 0;
		for (int i = 1; i < nVerts; i++) {
			if(!vertexList[i].isInTree && sPath[i].distance < minDist) {
				minDist = sPath[i].distance;
				indexMin = i;
			}
		}
		
		return indexMin;
	}
	/**
	 * 核心算法
	 */
	public void adjust_sPath() {
		int column = 1;
		while(column < nVerts) {
			if(vertexList[column].isInTree) {
				column++;
				continue;
			}
			int currentToFringe = adjMat[currentVert][column];
			// 起点到目标点的距离
			int startToFringe = startToCurrent + currentToFringe;
			int sPathDist = sPath[column].distance;
			if(startToFringe < sPathDist) {
				sPath[column].parentVert = currentVert;
				sPath[column].distance = startToFringe;
			}
			column++;
		}
	}
	
	public void displayPaths() {
		for (int i = 0; i < nVerts; i++) {
			System.out.print(vertexList[i].label + "=");
			if(sPath[i].distance == INFINITY) {
				System.out.print("inf");
			}else {
				System.out.print(sPath[i].distance);
			}
			// 取当前父顶点的label
			char parent = vertexList[sPath[i].parentVert].label;
			System.out.println("(" + parent+ ")");
		}
		System.out.println();
	}
}
