import java.io.*;
import java.util.*;


/**
 * Adjacency matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class AdjMatrix
{

	private 	ArrayList<ArrayList<String>> adjacencyMatrix;
	private ArrayList<String> vertices = new ArrayList<String>();
	private int count = 0;
	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
    	// Implement me!
    	
    		adjacencyMatrix = new ArrayList<ArrayList<String>>();
    
    	
    } // end of AdjMatrix()
    
    
    public void addVertex(String vertLabel) {
        // Implement me!
    	
    vertices.add(vertLabel);
    adjacencyMatrix.add(new ArrayList<String>());
    count++;
    
    for(int i = 0; i < vertices.size(); i++) {
			
    			adjacencyMatrix.get(i).add("0");
    			
    				
    			if(i == vertices.size()-1 ) {
    				for(int j = 0; j < count-1; j++) {
    					adjacencyMatrix.get(vertices.size() - 1).add("0");
    					
    					
    				}
    			}
    				
    }
    

    		
    		 	
    } // end of addVertex()
    
    public void printShit() {
    	
    		for(int i = 0; i < adjacencyMatrix.size(); i++) {
    			for(int j = 0; j < adjacencyMatrix.get(i).size(); j++) {
    				System.out.print(adjacencyMatrix.get(i).get(j) + " ");
    			}
    			System.out.println();
    		}
    		
    }
	
    
    public void addEdge(String srcLabel, String tarLabel) {
        // Implement me!
    		int vertexPositionA = 0;
    		int vertexPositionB = 0;
    		
    		for(int i = 0; i < vertices.size(); i++) {
    			if(srcLabel.equals(vertices.get(i))) {
    				vertexPositionA = i;
    			}
    			if(tarLabel.equals(vertices.get(i))) {
    				vertexPositionB = i;
    			}
    		}
    		
    		adjacencyMatrix.get(vertexPositionA).set(vertexPositionB, "1");
    		adjacencyMatrix.get(vertexPositionB).set(vertexPositionA, "1");
    		
    	
    		
    	
    	
    	
    } // end of addEdge()
	

    public ArrayList<String> neighbours(String vertLabel) {
        ArrayList<String> neighbours = new ArrayList<String>();
        
        // Implement me!
        
        
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(String vertLabel) {
        // Implement me!
    	
    	
    	
    } // end of removeVertex()
	
    
    public void removeEdge(String srcLabel, String tarLabel) {
        // Implement me!
    	
    	
    	
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        // Implement me!
    	
    	
    	
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        // Implement me!
    	
    	
    	
    } // end of printEdges()
    
    
//    public int shortestPathDistance(String vertLabel1, String vertLabel2) {
//    	// Implement me!
//    	
//        // if we reach this point, source and target are disconnected
//        return disconnectedDist;    	
//    } // end of shortestPathDistance()
    
} // end of class AdjMatrix