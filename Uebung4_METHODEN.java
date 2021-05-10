package uebung4_lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Uebung4_METHODEN {
	
	private File inputFile;
	private Scanner in;
	private int m;
	
		
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		Uebung4_METHODEN test = new Uebung4_METHODEN();

		// Test für Aufgabe 1 + 2
		test.writeToFile();
		test.writeToFileWithPrintWriter();
		
		// Test für Aufgabe 3 + 4
		test.setUp();
		test.readCharacters(test.in);
		
	}

public void setUp() throws FileNotFoundException {
		inputFile = new File("C:\\Projekte\\HS\\Lab3\\testfile.txt"); // "C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\testo.txt"
		in = new Scanner(inputFile);
		m = 5;
	}

// Write an Integer, String and int with a FileWriter
public void writeToFile() throws IOException {
		int testINT = 42;
		Integer testINTEGER = 39;
		String testSTRING = "Test String";
		FileWriter fwForTask2 = new FileWriter("resultfw.txt"); // "C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\resultfw.txt"
		fwForTask2.write(testINT);
		fwForTask2.write(testINTEGER);
		fwForTask2.write(testSTRING);
		fwForTask2.close();	
	}

	// Write an Integer, String and int with a PrintWriter
	public void writeToFileWithPrintWriter() throws FileNotFoundException {
		int testINT = 42;
		Integer testINTEGER = 39;
		String testSTRING = "Test String";
		PrintWriter pwForTask2 = new PrintWriter("‪resultpw.txt"); // "C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\resultpw.txt"
		pwForTask2.println(testINT);
		pwForTask2.println(testINTEGER);
		pwForTask2.println(testSTRING);
		pwForTask2.close();	
	}


		
	private void readCharacters(Scanner in) throws FileNotFoundException {
		//in.useDelimiter("[^A-Za-z0-9]");
		PrintWriter pw = new PrintWriter("‪Histogram.txt"); // "C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\Histogram.txt"
		String out = "";
		String str = "";
		char[] chars = new char[0];

// Put the String into an Array of single Chars
		while (in.hasNext()) {
		str = str + in.nextLine();	
		str = str.toUpperCase();  
		chars = str.toCharArray(); 
		}
//for (int i = 0; i < chars.length; i++) {
		//	System.out.println(chars[i]);
		//}


		Arrays.sort(chars);

// Create a HashMap to count the occurrences of Chars		
	    HashMap<Character, Integer> charMap = new HashMap<>();
			   	    
	    for (Character ch : chars) {
			if(charMap.containsKey(ch)) charMap.put(ch, charMap.get(ch) +1);
			else charMap.put(ch, 1);
		}
			    
// Count the occurrences and print them out
		for (Character key : charMap.keySet()) {
			int n = charMap.get(key);
			if((n / m) < 1) n = 1;
			else n /= m;
			out += (key + ": ");
			for(int i = 1; i <= n; i++) {
				out += ("*");
				if((i % 10) == 0) out += ("|");
			}
			out += ("\n");
		}
		
		System.out.println(out);
		
		pw.println(charMap);
		pw.println("Histogram entspricht Faktor: " + m);
		pw.println(out);
		
		in.close();
		pw.close();	    	
	}
}
