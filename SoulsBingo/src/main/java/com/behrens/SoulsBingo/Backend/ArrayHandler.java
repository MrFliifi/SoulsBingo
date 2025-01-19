package com.behrens.SoulsBingo.Backend;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArrayHandler {

	public String[][] setGridUp(String filePath) throws IOException {
		String[][] grid = createGrid();
		String[][] fullGrid = fillGrid(grid, filePath);
		return fullGrid;
	}

	private String[][] createGrid() {
		String[][] grid = new String[5][5];
		return grid;
	}

	private String[][] fillGrid(String[][] grid, String filePath) throws IOException {
		Random random = new Random();
		FileHandler fileHandler = new FileHandler();
		String[] entries = fileHandler.fetchEntries(filePath);

		if (entries.length < grid.length * grid[0].length) {
			throw new IllegalArgumentException("Not enough unique entries to fill the grid.");
		}

		Set<Integer> usedIndices = new HashSet<>();
		int totalCells = grid.length * grid[0].length;

		for (int i = 0; i < totalCells; i++) {
			int x;
			do {
				x = random.nextInt(entries.length);
			} while (usedIndices.contains(x));

			usedIndices.add(x);

			// Fill the grid
			grid[i / grid[0].length][i % grid[0].length] = entries[x];
		}
		return grid;
	}

	public boolean[][] gridIsClicked(){
		boolean[][] isClicked = new boolean[5][5];
		return isClicked;
	} 
}
