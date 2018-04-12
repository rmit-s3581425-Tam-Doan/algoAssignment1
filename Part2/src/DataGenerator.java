import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataGenerator {

	public static void main(String[] args) throws IOException {
		
//		//Scenario 1
//		AdjScenario1 sc1 = new AdjScenario1();
//		System.out.println("-----------------");
//		System.out.println("Scenario 1");
//		System.out.println("-----------------");
//		
//		//Maximum number of edges from original facebook file
//		sc1.subSet(88234);  //baseline speed
//		//Increasing the edges
//		sc1.subSetMoreEdges(2500);
//		//More test cases
//		sc1.subSet(2500);
//		sc1.subSetMoreEdges(2500);
//		sc1.subSet(5000);
//		sc1.subSetMoreEdges(5000);
		
		//Scenario 2
//		AdjScenario2 sc2 = new AdjScenario2();
//		System.out.println("-----------------");
//		System.out.println("Scenario 2");
//		System.out.println("-----------------");
//		//Test 1
//		sc2.subSet(500);
//		sc2.subSetMoreEdges(500);
//		//Test 2
//		sc2.subSet(2000);
//		sc2.subSetMoreEdges(2000);
//		//Test 3
//		sc2.subSet(5000);
//		sc2.subSetMoreEdges(5000);
		
		//Scenario 3
		AdjScenario3 sc3 = new AdjScenario3();
		System.out.println("-----------------");
		System.out.println("Scenario 3");
		System.out.println("-----------------");
		//Test 1
		sc3.subSet(5000);
		sc3.subSetMoreEdges(5000);
		//Test 2
		
		//Test 3

		
	}

}
