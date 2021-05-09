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
	
	public void setUp() throws FileNotFoundException
	{
		inputFile = new File("C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\testo.txt");
		in = new Scanner(inputFile);
	}
	
	public void writeToFile() throws IOException
	{
		int testINT = 42;
		Integer testINTEGER = 39;
		String testSTRING = "Test String";
		FileWriter fwForTask2 = new FileWriter("C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\resultfw.txt");
		fwForTask2.write(testINT);
		fwForTask2.write(testINTEGER);
		fwForTask2.write(testSTRING);
		fwForTask2.close();	
	}
	
	public void writeToFileWithPrintWriter() throws FileNotFoundException 
	{
		int testINT = 42;
		Integer testINTEGER = 39;
		String testSTRING = "Test String";
		PrintWriter pwForTask2 = new PrintWriter("C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\resultpw.txt");
		pwForTask2.println(testINT);
		pwForTask2.println(testINTEGER);
		pwForTask2.println(testSTRING);
		pwForTask2.close();	
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
		Uebung4_METHODEN test = new Uebung4_METHODEN();
		// Test für Aufgabe 2
		test.writeToFile();
		test.writeToFileWithPrintWriter();
		
		// Aufgabe 3 + 4
		test.setUp();
		test.readCharacters(test.in);
		
	}
		
		private void readCharacters(Scanner in) throws FileNotFoundException {
		//in.useDelimiter("[^A-Za-z0-9]");
		PrintWriter pw = new PrintWriter("C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\Histogram.txt");
		String out = "";
		String str = "";
		char[] chars = new char[0];

		
		while (in.hasNext()){
		str = str + in.nextLine();	
		str = str.toUpperCase();  
		chars = str.toCharArray(); 
		}
		Arrays.sort(chars);
	    HashMap<Character, Integer> charMap = new HashMap<>();
			   
			    
	    for (Character ch : chars) 
		{
			if(charMap.containsKey(ch))
			{
			    charMap.put(ch, charMap.get(ch) +1);
			}
			else
			{
			    charMap.put(ch, 1);
			}
		}
			    
		for (Character key : charMap.keySet()) 
		{
			out += (key + ": ");//+ charMap.get(key) + " | ");
			for(int i = 1; i <= charMap.get(key); i++) 
			{
				out += ("*");
				if((i % 10) == 0) out += ("|");
			}
			out += ("\n");
		
		}
		System.out.println(out);
		pw.println(charMap);
		pw.println(out);
		
		
		
		in.close();
		pw.close();	    	
	}
	}
