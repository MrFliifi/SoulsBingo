package com.behrens.SoulsBingo.Backend;

import java.io.IOException;

public class App 
{
	static String[] input = { "alle", "kinder", "lernen", "lesen"};
	static String filePath = "NewFile.txt";
	
    public static void main( String[] args ) throws IOException
    {		
    	
        
    	FileHandler fileHandler = new FileHandler();
        
        fileHandler.writeMeAFile(filePath, input);
    }
}
