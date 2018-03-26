
public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//can refactor the methods later just focusing on getting it working
		AdjMatrix adj = new AdjMatrix();
		
		adj.addVertex("A");
		adj.addVertex("B");
		adj.addVertex("C");
		adj.addVertex("D");
		//adj.printShit();
		
		adj.addEdge("A", "C");
		adj.addEdge("A", "D");
		adj.addEdge("C", "B");
		adj.printShit();
		

	}

}
