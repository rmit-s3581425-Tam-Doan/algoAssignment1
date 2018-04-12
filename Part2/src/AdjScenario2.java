import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AdjScenario2 {

	//For appending the string
	int subsetCount = 0;
	
	
	public void subSet(int edges) throws IOException {
		//Start the time
				subsetCount++;
				
				System.out.println("\nSubset " + subsetCount);
				System.out.println("------------");
				BufferedReader br = new BufferedReader(new FileReader("facebook_combined.txt"));
				
				String line;
				String lastEdge = null;
				int count = 0;

				AdjMatrix<String> adjMatrix = new AdjMatrix<String>();
				
				//Adding the vertices
				while((line = br.readLine()) != null) {
					String[] lineArr = line.split(" ");
					
					for(int i = 0; i < 2; i++) {
						adjMatrix.addVertex(lineArr[i]);					
					}	
					count++;
					
					if(count == edges) {
						//stores the final edge that is read
						lastEdge = line;
						break;
					}	
				}

				//Adding the edges
				br = new BufferedReader(new FileReader("facebook_combined.txt"));
				
				while((line = br.readLine()) != null) {
					String[] lineArr = line.split(" ");

					adjMatrix.addEdge(lineArr[0], lineArr[1]);				

					//Ends the loop when the last edge checked is the last vertice checked
					if(line.equals(lastEdge)) {
						break;
					}	
				}
				
				//Starting the clock
				long startTime = System.currentTimeMillis();
				
				//Evaluating neighbours
				br = new BufferedReader(new FileReader("facebook_combined.txt"));
				int internalCounter = 0;
				while((line = br.readLine()) != null) {
					String[] lineArr = line.split(" ");
					adjMatrix.neighbours(lineArr[0]);
					adjMatrix.neighbours(lineArr[1]);
					
					internalCounter++;

					//Ends the loop when the last edge checked is the last vertice checked
					if(internalCounter == edges) {				
						break;
					}	
				}

				//Evaluating shortest path
				br = new BufferedReader(new FileReader("facebook_combined.txt"));
				int pathCounter = 0;
				Random r = new Random();
				ArrayList vertices = adjMatrix.getVertexList();
				
				while((line = br.readLine()) != null) {
					String[] lineArr = line.split(" ");

					//Generates random vertices to check their shortest paths
					adjMatrix.shortestPathDistance(vertices.get(r.nextInt(vertices.size())).toString(), vertices.get(r.nextInt(vertices.size())).toString());
					
					//Ends the loop when the last edge checked is the last vertice checked
					if(pathCounter == edges) {				
						break;
					}	
					pathCounter++;
				}
				
				double graphDensity = (count / Math.pow(adjMatrix.numberOfVertices(), 2)); 
				System.out.println("Number of vertices " + adjMatrix.numberOfVertices());
				System.out.println("Number of edges " + adjMatrix.numberOfEdges());
				System.out.println("Graph Density " + String.format("%.4f", graphDensity));
				System.out.println((internalCounter*2) + " Neighbours of vertices checked successfully!");
				System.out.println(pathCounter + " Shortest paths checked successfully!");
				
				//Calculates the execution time
				long stopTime = System.currentTimeMillis();
			    long elapsedTime = stopTime - startTime;
			    System.out.println(elapsedTime + " milliseconds or " + elapsedTime/1000.0 + " seconds" );
				
				br.close();
	}
	
		
	// Increasing the density
	public void subSetMoreEdges(int edges) throws IOException {
			
			//Start the time
			subsetCount++;
			
			System.out.println("\nSubset " + subsetCount);
			System.out.println("------------");
			BufferedReader br = new BufferedReader(new FileReader("facebook_combined.txt"));
			
			String line;
			String lastEdge = null;
			int count = 0;

			AdjMatrix<String> adjMatrix = new AdjMatrix<String>();
			
			//Adding the vertices
			while((line = br.readLine()) != null) {
				String[] lineArr = line.split(" ");
				
				for(int i = 0; i < 2; i++) {
					adjMatrix.addVertex(lineArr[i]);					
				}	
				count++;
				
				if(count == edges) {
					//stores the final edge that is read
					lastEdge = line;
					break;
				}	
			}
			
			//Adding the edges
			br = new BufferedReader(new FileReader("facebook_combined.txt"));
			int edgeAdder = 0;
			
			while((line = br.readLine()) != null) {
				String[] lineArr = line.split(" ");

				//Adds original facebook edges to increase density	
				adjMatrix.addEdge(lineArr[0], lineArr[1]);
				//Adds new edges that increment at different rates to increase density
				adjMatrix.addEdge(Integer.toString(edgeAdder), Integer.toString(edgeAdder++));
				adjMatrix.addEdge(Integer.toString(edgeAdder), Integer.toString(edgeAdder+2));
				adjMatrix.addEdge(Integer.toString(edgeAdder), Integer.toString(edgeAdder+3));
				adjMatrix.addEdge(Integer.toString(edgeAdder), Integer.toString(edgeAdder+4));
				adjMatrix.addEdge(Integer.toString(edgeAdder), Integer.toString(edgeAdder+5));
				
				//Ends the loop when last edge is reached (defined in the vertex loop)
				if(line.equals(lastEdge)) {
					break;
				}	
			}
			
			//Start Time
			long startTime = System.currentTimeMillis();
			
			//Evaluating neighbours
			br = new BufferedReader(new FileReader("facebook_combined.txt"));
			int internalCounter = 0;
			while((line = br.readLine()) != null) {
				String[] lineArr = line.split(" ");
				adjMatrix.neighbours(lineArr[0]);
				adjMatrix.neighbours(lineArr[1]);
				
				internalCounter++;

				//Ends the loop when the last edge checked is the last vertice checked
				if(internalCounter == edges) {				
					break;
				}	
			}

			//Evaluating shortest path
			br = new BufferedReader(new FileReader("facebook_combined.txt"));
			int pathCounter = 0;
			Random r = new Random();
			ArrayList vertices = adjMatrix.getVertexList();
			
			while((line = br.readLine()) != null) {
				String[] lineArr = line.split(" ");

				//Generates random vertices to check their shortest paths
				adjMatrix.shortestPathDistance(vertices.get(r.nextInt(vertices.size())).toString(), vertices.get(r.nextInt(vertices.size())).toString());
				
				//Ends the loop when the last edge checked is the last vertice checked
				if(pathCounter == edges) {				
					break;
				}	
				pathCounter++;
			}
			
			//Calculates the graph density
			double graphDensity = (adjMatrix.numberOfEdges() / Math.pow(adjMatrix.numberOfVertices(), 2)); 
			
			System.out.println("Number of vertices " + adjMatrix.numberOfVertices());
			System.out.println("Number of edges " + adjMatrix.numberOfEdges());
			System.out.println("Graph Density " + String.format("%.4f", graphDensity));
			System.out.println((internalCounter*2) + " Neighbours of vertices checked successfully!");
			System.out.println(pathCounter + " Shortest paths checked successfully!");
			
			//Calculates the execution time
			long stopTime = System.currentTimeMillis();
		    long elapsedTime = stopTime - startTime;
		    System.out.println(elapsedTime + " milliseconds or " + elapsedTime/1000.0 + " seconds" );
			
			br.close();
		}

}
