package algorithm.girlTeacher.graph.graphPath;
/**
 * 最短路径
 * @author huxm
 *
 */
public class PathApp {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex('A');
		graph.addVertex('B');
		graph.addVertex('C');
		graph.addVertex('D');
		graph.addVertex('E');
		
		graph.addEdge(0, 1, 50);  // A  B  50
		graph.addEdge(0, 3, 80);  // A  D  80
		graph.addEdge(1, 2, 60);  // B  C  60
		graph.addEdge(1, 3, 90);  // B  D  90
		graph.addEdge(2, 4, 40);  // C  E  40
		graph.addEdge(3, 2, 20);  // D  C  20
		graph.addEdge(3, 4, 70);  // D  E  70
		graph.addEdge(4, 1, 50);  // E  B  50
		
		System.out.println("最短路径：");
		graph.path();

	}

}
