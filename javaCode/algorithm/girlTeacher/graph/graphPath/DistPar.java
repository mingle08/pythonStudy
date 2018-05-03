package algorithm.girlTeacher.graph.graphPath;
/**
 * Distance  Parent   到父顶点的距离
 * @author huxm
 *
 */
public class DistPar {

	public int distance;
	public int parentVert;
	
	public DistPar(int pv, int d) {
		this.distance = d;
		this.parentVert = pv;
	}
}
