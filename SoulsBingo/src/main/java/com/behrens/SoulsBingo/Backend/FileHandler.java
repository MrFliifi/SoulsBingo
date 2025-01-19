package com.behrens.SoulsBingo.Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// TODO: will need to add removal of specific entries via GUI
public class FileHandler {

	public void writeMeAFile(String filePath, String[] input) throws IOException {
		createFile(filePath);
		writeToFile(input, filePath);
	}

	private void createFile(String filePath) throws FileNotFoundException {
		// will need filename from gui
		File file = new File(filePath);
	}

	private void writeToFile(String[] input, String filePath) throws IOException {
		// will need input from GUI
		// true activates append mode
		FileWriter writer = new FileWriter(filePath, true);
		
		for (int i = 0; i < input.length; i++) {
			if (isEntryUnique(filePath, input[i])) {
				writer.write(input[i] + "\n");
			}
		}
		writer.close();
	}
	
	private boolean isEntryUnique(String filePath, String input) throws IOException {
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String existingLine;
	        while ((existingLine = reader.readLine()) != null) {
	            if (existingLine.equals(input)) { 
	                return false; 
	            }
	        }
	        reader.close();
	    }
	    return true;
	}

}