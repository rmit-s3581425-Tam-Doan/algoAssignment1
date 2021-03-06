import java.io.*;
import java.util.*;

 
public class AdjMatrix <T extends Object>
{	
	private 	ArrayList<ArrayList<String>> adjacencyMatrix;
	private ArrayList<T> vertices = new ArrayList<T>();
	private int numbOfEdges = 0;

	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
    	// Implement me!
    		adjacencyMatrix = new ArrayList<ArrayList<String>>();
    } // end of AdjMatrix()
    
    
    public void addVertex(T vertLabel) {
        // Implement me!

    	//ArrayList for the label of the vertex
    	if(vertices.contains(vertLabel))
    		return;
    	else
    		vertices.add(vertLabel);
    	
    
    
    //2D ArrayList for the matrix
    adjacencyMatrix.add(new ArrayList<String>());
    
    //Each iteration, adds an extra value to each row.  The nested loop makes sure an extra element is added for the newest row in the iteration.
    for(int i = 0; i < vertices.size(); i++) {
			
    			adjacencyMatrix.get(i).add("0");
    			
    			//Executes only for the element in the last position
    			if(i == vertices.size()-1 ) {
    				//Executes only if there is more than one vertex
    				for(int j = 0; j < vertices.size()-1; j++) {
    					adjacencyMatrix.get(vertices.size() - 1).add("0");		
    				}
    			}			
    }
    } // end of addVertex()
    
    public int numberOfVertices() {
    		return vertices.size();
    }
    
    public int numberOfEdges() {
		return numbOfEdges;
    }
    
    public ArrayList getVertexList() {
    		return vertices;
    }
    

	
    
    public void addEdge(T srcLabel, T tarLabel) {
        // Implement me!
    		int vertexPositionA = 0;
		int vertexPositionB = 0;
		
		if(vertices.contains(srcLabel))
			vertexPositionA = vertices.indexOf(srcLabel);
		
		if(vertices.contains(tarLabel))
			vertexPositionB = vertices.indexOf(tarLabel);
		
		if(!adjacencyMatrix.get(vertexPositionA).get(vertexPositionB).equals("1")) {
			adjacencyMatrix.get(vertexPositionA).set(vertexPositionB, "1");	
			adjacencyMatrix.get(vertexPositionB).set(vertexPositionA, "1");	
			numbOfEdges++;
		}
		
		
    } // end of addEdge()
	

    public void neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
        int vertexPosition = 0;
        int neighbourPosition = 0;
        
        // Gets the position of the user inputted vertex from the vertex
        if(vertices.contains(vertLabel)) {
        		//System.out.print("\n" + vertLabel + " ");
			vertexPosition = vertices.indexOf(vertLabel);
			
		     //Uses the vertex position to check for "1"s in the matrix to find the neighbours
	        for(int i = 0; i < vertices.size(); i++) {
	        		if(adjacencyMatrix.get(vertexPosition).get(i).equals("1")) {
	        			neighbours.add(vertices.get(i));
	        		}
	        }
	        
        } else {
        		System.out.print(vertLabel);
        		System.out.print("\nVertex doesn't exist");
        }  
        
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        // Implement me!
   		int vertexPosition = 0;
		if(vertices.contains(vertLabel)) 
			vertexPosition = vertices.indexOf(vertLabel);   
		else
			System.out.println("Vertex doesn't exist");
		
		//Removes vertex from the arraylist of labels
		vertices.remove(vertexPosition);
		
		adjacencyMatrix.remove(vertexPosition);
		
		for(int i = 0; i < vertices.size(); i++) {
			adjacencyMatrix.get(i).remove(vertexPosition);
		}
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
        // Implement me!
    		int vertexPositionA = 0;
    		int vertexPositionB = 0;
		if(vertices.contains(srcLabel)) 
			vertexPositionA = vertices.indexOf(srcLabel);  
		
		if(vertices.contains(tarLabel)) 
			vertexPositionB = vertices.indexOf(tarLabel);  
    	
    		adjacencyMatrix.get(vertexPositionA).set(vertexPositionB, "0");
    		adjacencyMatrix.get(vertexPositionB).set(vertexPositionA, "0");
    } // end of removeEdges()
	
    
    public void printVertices() {
        // Implement me!

	    	for(int i = 0; i < vertices.size(); i++) {
	    		
	    		System.out.print(vertices.get(i) + " ");
	    	}
	   
	    	System.out.println();
	    	
    } // end of printVertices()
	
    
    public void printEdges() {
        // Implement me!
  		for(int i = 0; i < vertices.size(); i++) {
			
			for(int j = 0; j < vertices.size(); j++) {
				if(adjacencyMatrix.get(i).get(j).equals("1")) {
					System.out.println(vertices.get(i) + " " + vertices.get(j));
							
				}    			
			}
		}
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
        int 	srcNode = 0;
	    int destNode = 0;	
	    //Keeps track of nodes already visited
	    int[] visited = new int[vertices.size()];
	    Arrays.fill(visited, 0);
   
	    //Keeps track of the current node that is checking its children
	    LinkedList<Integer> queue = new LinkedList<Integer>();
	    
	    //Keeps track of the best distance for each node from src
	    int[] bestDistance = new int[vertices.size()];
	    //Initialises as -1 incase the destNode is unreachable it will return -1
	    Arrays.fill(bestDistance, -1);
	    
	    //Error checks and stores position of src and dest nodes
	    if(vertices.contains(vertLabel1))
	    		srcNode = vertices.indexOf(vertLabel1);
	    else
	    		return -1;
	    
	    if(vertices.contains(vertLabel2))
    			destNode = vertices.indexOf(vertLabel2);
	    	else
	    		return -1;
	    
	    //adds the source node to the list
	    queue.add(srcNode);
	    visited[srcNode] = 1;
	    //Sets starting node to 0 as its been visited with no distance
	    bestDistance[srcNode] = 0;
	    
	    //Loops until no nodes left to explore
	    while(!queue.isEmpty()) {
	    	
	    	//Checks the currentNodes row if it has any edges.. if so, it adds them to the list
		    for(int j = 0; j < vertices.size(); j++) {   
		    		//only unvisited nodes will be added to the list to explore later
		    		if(adjacencyMatrix.get(queue.getFirst()).get(j).equals("1") && visited[j] == 0) {
		    			visited[j] = 1;
		    			queue.add(j);
		    			bestDistance[j] = bestDistance[queue.getFirst()] + 1;
		    		}
		    }
		    //removes the head of the list
		    queue.remove();  
	    }
	    
	    return bestDistance[destNode]; 	
    } // end of shortestPathDistance()
    
} // end of class AdjMatrix