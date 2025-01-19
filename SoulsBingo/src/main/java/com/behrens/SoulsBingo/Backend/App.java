package com.behrens.SoulsBingo.Backend;

import java.io.IOException;

public class App 
{
	static String[] input = {"alle", "kinder", "lernen", "lesen", "schreiben",  
			"spielen", "singen", "tanzen", "malen", "rechnen",  
			"lachen", "weinen", "rennen", "springen", "fliegen",  
			"denken", "schlafen", "essen", "trinken", "suchen",  
			"finden", "bauen", "klettern", "fahren", "reisen",  
			"fühlen", "hören", "sehen", "riechen", "sprechen",  
			"verstehen", "erzählen", "kaufen", "verkaufen",  
			"kochen", "backen", "sammeln", "zählen", "zeichnen",  
			"schwimmen", "basteln", "wandern", "arbeiten", "leben",  
			"lieben", "streiten", "rufen", "werfen", "fangen",  
			"graben", "pflanzen", "gießen", "schneiden", "nähen",  
			"binden", "kleben", "färben", "zuhören", "besuchen",  
			"laden", "bügeln", "putzen", "wischen", "erinnern",  
			"fragen", "antworten", "planen", "erfinden", "fotografieren",  
			"filmen", "jubeln", "staunen", "schmunzeln", "erkunden",  
			"erleben", "träumen", "experimentieren", "proben",  
			"unterrichten", "forschen", "programmieren", "konstruieren",  
			"zeichnen", "vergleichen", "bewerten", "tanzen", "lächeln",  
			"gestalten", "organisieren", "backen", "kommunizieren", "meditieren"};
	static String filePath = "NewFile.txt";
	static String deleteStrin = "alle";
	
    public static void main( String[] args ) throws IOException
    {		
    	FileHandler fileHandler = new FileHandler();
        ArrayHandler arrayHandler = new ArrayHandler();

        String[][] fullGrid = arrayHandler.setGridUp(filePath);
        System.out.println();
    }
}