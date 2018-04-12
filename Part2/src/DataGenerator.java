import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DataGenerator {

	public static void main(String[] args) throws IOException {
		
		Scenario1 sc1 = new Scenario1();
		System.out.println("-----------------");
		System.out.println("Scenario 1");
		System.out.println("-----------------");
		sc1.subSet(1800);
		sc1.subSet(2000);
		sc1.subSet2(2000);
		sc1.subSet(5000);
		sc1.subSet2(5000);
		

		
	}

}
