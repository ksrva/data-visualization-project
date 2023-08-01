//
// Title:		CSVReader
// Author:		Sidharth Shenoy
// Date:		May 15, 2023
// Description:	Automatically parses a CSV file into an ArrayList of String arrays
// Usage:		new CSVReader(String pathToFile, boolean printToConsole (optional parameter))
// Example:
//
//	public class CSVTest {
// 		public static void main(String[] args) {
//			CSVReader reader = new CSVReader("files/casesByAge.csv", true);
//		}
//	}
//

package controller;

// Import modules
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// CSVReader class
public class CSVReader {

	// Fields
	private String fileName;
	private ArrayList<String[]> parsedData;

	// Constructors
	public CSVReader(String fileName) {

		this.fileName = fileName;
		this.read(false);

	}

	public CSVReader(String fileName, boolean printValues) {

		this.fileName = fileName;
		this.read(printValues);

	}

	// Get the number of comma separated values per line

	// Return a 2d array of strings from the parsed file
	private void read(boolean printToConsole) {

		try {

			// Attempt to read file from name
			Scanner inputFile = new Scanner(new File(fileName));

			// All values are separated by commas
			inputFile.useDelimiter(",");

			// Get the lines
			parsedData = new ArrayList<String[]>();
			String currentLine = "";
			while (inputFile.hasNext()) {
				currentLine = inputFile.nextLine();
				String[] entries = currentLine.split(",");
				parsedData.add(entries);
			}

			// Close input file
			inputFile.close();

		} catch (FileNotFoundException e) {

			// File was not found
			System.out.println("File not found: " + fileName);

		}

		// Print all values to the console
		if (printToConsole) {
			for (int count = 0; count < parsedData.size(); count++) {
				for (String index : parsedData.get(count)) {
					System.out.print(index + "\t");
				}
				System.out.print("\n");
			}
		}

	}

	// Getters and setters
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

	// toString method
	@Override
	public String toString() {
		return "CSVReader [fileName=" + fileName + ", parsedData=" + parsedData + "]";
	}

}
