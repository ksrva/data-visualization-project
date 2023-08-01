//Kamakshi


/*
 * Imports files for Geo Controller
 */
package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import model.*;

public class GeoFileImportController {
	

	public static ArrayList<GeoService> geoServices; 
	public static ArrayList<City> geoCities; 
	public static Region[] regionList; 
	
	public GeoFileImportController() {

		
		geoServices = new ArrayList<GeoService>();
		geoCities = new ArrayList<City>(); 
		regionList = new Region[15]; 
		
		//Create Regions and add them to list 
		regionList[0] = new Region(new ArrayList<City>(),"Southwest", 1, "Southwest Ontario", null); 
		regionList[1] = new Region(new ArrayList<City>(),"Niagara", 2, "Niagara Canada", null); 
		regionList[2] = new Region(new ArrayList<City>(),"HHB", 3, "Hamilton, Halton and Brant", null); 
		regionList[3] = new Region(new ArrayList<City>(),"HPWW", 4, "Huron, Perth, Waterloo and Wellington", null); 
		regionList[4] = new Region(new ArrayList<City>(),"GTA", 5, "Greater Toronto Area", null); 
		
		regionList[5] = new Region(new ArrayList<City>(),"YDH", 6, "York, Durham and Headwaters", null); 
		regionList[6] = new Region(new ArrayList<City>(),"BGS", 7, "Bruce Peninsula, Southern Georgian Bay and Lake Simcoe", null); 
		regionList[7] = new Region(new ArrayList<City>(),"Kawartha", 8, "Kawartha Northumberland", null); 
		regionList[8] = new Region(new ArrayList<City>(),"Southeast", 9, "Southeastern Ontario",null); 
		regionList[9] = new Region(new ArrayList<City>(),"Ottawa", 10, "Ottawa and countryside", null); 
		
		regionList[10] = new Region(new ArrayList<City>(),"HHOV", 11, "Haliburton Highlands to the Ottawa Valley", null); 
		regionList[11] = new Region(new ArrayList<City>(),"MPA", 12, "Muskoka, Parry Sound and Algonquin Park",null); 
		regionList[12] = new Region(new ArrayList<City>(),"northeast", 13, "Northeastern Ontario", null); 
		regionList[13] = new Region(new ArrayList<City>(),"SSM", 14, "Sault Ste. Marie, Algoma", null); 
		regionList[14] = new Region(new ArrayList<City>(),"northwest", 15, "Northwest Ontario", null); 
		
		
		//importRegions(); 
		importCities("files/geoCities.csv"); 
		importCityRegions("files/geoRegions.csv"); 
		importServices("files/geoServices.csv");
		
		
		//Value Tester Loop 
		int count = 0; 
		for(Region cur : regionList) {
			//System.out.println(cur.getFullName());  
			count++; 
		}
		 

	}
	
	
	
	// Reads the cities file
		// Cities to help when organizing labels 
		public static void importCities(String filePath) {

			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

				String line;

				while ((line = reader.readLine()) != null) {

					String[] values = line.split(","); // separate at commas

					// Read the city name
					String cityName = values[0];

					// Read the city location (x and y coordinates)
//					int x = Integer.parseInt(values[1]);
//					int y = Integer.parseInt(values[2]);
//					Point location = new Point(x, y);
					
					//FIXX
					int x = 0;
					int y = 0;
					Point location = new Point(x, y);


					// Create the new city and add it to the list
					City newCity = new City(cityName, location);
					geoCities.add(newCity);

				}

			} catch (IOException e) {
				System.out.println("Error reading file: " + e.getMessage()); // Handle Import errors
			}

		}
		
	//Imports each service from the services data set file  
	public static void importServices(String filePath) {

		
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			
			
			String line;

			while ((line = reader.readLine()) != null) {

				
				
				String[] values = line.split(","); // separate at commas


				// Read the city name
				String publicName = values[0];
				String alternateName = values[1];
				String parentAgency = values[2];  
				
				 String address = values[3];  
				 
				 String cityStr = values[4]; 
				 City city = new City(); //PASS
				 for(City currentCity : geoCities) {
					 if(currentCity.getName().equals(cityStr)) {
						 city = currentCity; 
					 }else if(currentCity.getName().equals("Not Available")) {
						 city = new City("Not Available", new Point(0,0)); //city info not provided
					 }
				 }
				 
				 String postalCode = values[5]; 
				 
				 
				 String country = values[6];  
				 String scheduleAppointment = values[7];  
				 String phoneNumber = values[8];  
				 String email = values[9]; 
				 String website = values[10];  
				 String eligibility = values[11];  
				 String feeStructure = values[12];  
				 String applicationProcess = values[13];  
				 
				 String dateStr = values[14]; 
				 
				 //String dateNumStr = " "; 
				 //String monthStr = " "; 
				 
				 //To get the year
				 int count = 0; 
				 int index = 0; 
				 while(count < 2) {
					 if(dateStr.charAt(index) == '/') {
						 count++;
					 }
					 index++;
				 }
				 String yearStr = dateStr.substring(index, index + 4); 
				 
				 //to get the month 
				 int countm = 0; 
				 int indexm = 0; 
				 while(countm < 1) {
					 if(dateStr.charAt(indexm) == '/') {
						 countm++; 
					 }
					 indexm++;
				 }
				 
				 String monthStr = " " ; 
				 //Check if only single digit Value
				 if(dateStr.charAt(indexm+1) == '/') {
					 monthStr = "0" + dateStr.charAt(indexm); 
				 }else {
					 monthStr = dateStr.charAt(indexm) + "" + dateStr.charAt(indexm+1);
				 }
				 
				 
				 
				 
				 
				 int dateNum = 10;
				 int month = Integer.parseInt(monthStr);
				 int year = Integer.parseInt(yearStr); 
				 Date date = new Date(dateNum, month, year); 
				 
				 Date activeOn; //turn into "Date"
				 
				 String taxonomyTerm = values[15]; 
				 String hours = values[16]; 
			
				 Region region = new Region(); 
				 for(Region currentRegion : regionList) {
					 for(City currentCity : currentRegion.getCitiesWithinRegion()) {
						 if(currentCity.equals(city)) {
							 region = currentRegion; 
						 }
					 }
				 }
				 
				
				// Create the new city and add it to the list 
				geoServices.add(new GeoService(publicName, alternateName, parentAgency, address, city, postalCode, country, scheduleAppointment
						, phoneNumber, email, website, eligibility, feeStructure, applicationProcess, date, dateStr, taxonomyTerm, hours, region));
				
				
				
		
				
				
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage()); // Handle Import errors
		}

	}
	

	public static void importCityRegions(String filePath) {

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			String line;

			while ((line = reader.readLine()) != null) {

				String[] values = line.split(","); // separate at commas

				// Read the city name
				String cityName = values[0];
				int region = Integer.parseInt(values[1]);
				
				for(City currentCity : geoCities) {
					if(cityName.equals(currentCity.getName())) {
						regionList[region-1].getCitiesWithinRegion().add(currentCity);
					}
					
				}
				
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage()); // Handle Import errors
		}

	}
	
	
	
	
	
	
	
	
}






