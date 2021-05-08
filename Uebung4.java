package uebung4_lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public final class Uebung4 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File inputFile = new File("C:\\Projekte\\HS\\Lab3\\testfile.txt"); // "C:\\Users\\Colin\\eclipse-workspace\\uebung4_lab\\src\\uebung4_lab\\testfile.txt"
		Scanner in = new Scanner(inputFile);
		PrintWriter pw = new PrintWriter("Histogram.txt");
		
		String out = "";
		String str = in.nextLine();	
		str = str.toUpperCase();      
		
		char[] chars = str.toCharArray(); 
		Arrays.sort(chars);
			// for (int i = 0, n = str.length(); i < n; i++) {
			// char c = str.charAt(i);
			// System.out.println(c);    ^
		
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
		pw.println(out);
		
		in.close();
		pw.close();
			    	
	}
}
