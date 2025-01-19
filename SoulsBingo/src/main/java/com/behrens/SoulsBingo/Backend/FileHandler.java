package com.behrens.SoulsBingo.Backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

	public void writeMeAFile(String filePath, String[] input) throws IOException {
		createFile(filePath);
		writeToFile(input, filePath);
	}

	public void createFile(String filePath) throws FileNotFoundException {
		// will need filename from gui
		try {
			File file = new File(filePath);

			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeToFile(String[] input, String filePath) throws IOException {
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

	public void deleteEntryFromFile(String deleteString, String filePath) throws IOException {
		File originalFile = new File(filePath);

		// Check if the file exists before proceeding
		if (!originalFile.exists()) {
			throw new FileNotFoundException("File not found: " + filePath);
		}

		File tempFile = new File(filePath + ".tmp");

		try (BufferedReader reader = new BufferedReader(new FileReader(originalFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

			String line;
			while ((line = reader.readLine()) != null) {
				// Write all lines except the one to be deleted
				if (!line.equals(deleteString)) {
					writer.write(line);
					writer.newLine();
				}
			}
			reader.close();
			writer.close();
		}
		
		// Replace the original file with the temporary file
		if (!originalFile.delete()) {
			throw new IOException("Failed to delete the original file");
		}

		if (!tempFile.renameTo(originalFile)) {
			throw new IOException("Failed to rename the temporary file");
		}
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
	
	public String[] fetchEntries(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		List<String> entries = new ArrayList<String>();
		String line;
		
		while ((line = reader.readLine()) != null) {
			entries.add(line);
		}
		reader.close();
		
		String[] result = entries.toArray(new String[0]);
		return result;
	}

}