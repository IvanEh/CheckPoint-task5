package com.gmail.at.ivanehreshi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App  {

	private Scanner reader;
	private PrintWriter writer;
	private String inputPath;
	private String outputPath;
	private String fileContent;

	public void CUISetIOPath(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input file: ");
		inputPath = scanner.next();
		
		System.out.print("Output file: ");
		outputPath = scanner.next();
		
		scanner.close();
	}

	private void initIO(){
		reader = new Scanner(inputPath);
		try {
			writer = new PrintWriter(outputPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void releaseRes(){
		reader.close();
		writer.close();
	}

	private void run(){
		CUISetIOPath();
		initIO();
		
		try {
			fileContent = new Scanner(new File(inputPath)).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = CommentCleaner.clean(fileContent);
		
		writer.write(result);
		
		releaseRes();
	}
	
	public static void main(String[] args) {
	     App app = new App();
	     app.run();
	}
	
}
