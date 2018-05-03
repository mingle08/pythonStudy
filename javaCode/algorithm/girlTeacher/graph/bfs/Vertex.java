package algorithm.girlTeacher.graph.bfs;

public class Vertex {

	public char label;  // 顶点的标志，例如A点，B点，C点……
	public boolean isVisited;  // 是否被访问过
	public Vertex(char lab) {
		this.label = lab;
		this.isVisited = false;
	}
}
