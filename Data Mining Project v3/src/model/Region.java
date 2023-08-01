//Kamakshi
/*
 * Models each Region whihc is an attribute of each Geo Service 
 */
package model;

import java.util.ArrayList;

import javax.swing.JLabel;

public class Region {

	private ArrayList<City> citiesWithinRegion;
	private String name; 
	private int referenceNumber; 
	private String fullName; 
	private JLabel regionLabel; 

	public Region() {
		
	}
	
	public Region(ArrayList<City> citiesWithinRegion, String name, int referenceNumber, String fullName, JLabel regionLabel) {
		super();
		this.citiesWithinRegion = citiesWithinRegion;
		this.name = name;
		this.referenceNumber = referenceNumber;
		this.fullName = fullName; 
		this.regionLabel = regionLabel; 
	}
	
	


	

	public JLabel getRegionLabel() {
		return regionLabel;
	}

	public void setRegionLabel(JLabel regionLabel) {
		this.regionLabel = regionLabel;
	}

	public ArrayList<City> getCitiesWithinRegion() {
		return citiesWithinRegion;
	}

	public void setCitiesWithinRegion(ArrayList<City> citiesWithinRegion) {
		this.citiesWithinRegion = citiesWithinRegion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(int referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return fullName;
	} 
	
	
	
	
	
	
	
}
