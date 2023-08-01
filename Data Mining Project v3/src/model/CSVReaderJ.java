//Jeffrey

package model;

import java.io.*;
import java.util.*;

public class CSVReaderJ {
	
	
	private String fileName;
	private ArrayList<String[]> parsedData;
	
	public CSVReaderJ(String fileName) {
		
		this.fileName = fileName;
		this.read(false);		
	}
	
	public CSVReaderJ(String fileName, boolean values) {
		
		this.fileName = fileName;
		this.read(values);
	}
	
	private void read(boolean listOfValues) {
		
		try {
			
			Scanner input = new Scanner(new File(fileName));
			
			input.useDelimiter(",");
			
			parsedData = new ArrayList<String[]>();
			String currentLine = "";
			while(input.hasNext()) {
				currentLine = input.nextLine();
				String[] entries = currentLine.split(",", -1);
				parsedData.add(entries);
			}
			
			input.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("File not found: " + fileName);
		}
		
		if (listOfValues) {
			for (int i = 0; i < parsedData.size(); i++) {
				for (String index : parsedData.get(i)) {
					System.out.print(index + "\t");
				}
				System.out.print("\n");
			}
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<String[]> getParsedData() {
		return parsedData;
	}

	public void setParsedData(ArrayList<String[]> parsedData) {
		this.parsedData = parsedData;
	}

	@Override
	public String toString() {
		return "CSVReader [fileName=" + fileName + ", parsedData=" + parsedData + "]";
	}
	
	
}
