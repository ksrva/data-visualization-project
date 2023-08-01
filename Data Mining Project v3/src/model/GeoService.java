//Kamakshi
/*
 * Models each individual service in the csv file 
 */
package model;

import java.awt.Point;

//Represents a single item in the geographical region data set (Child and Youth Services by Region) 

public class GeoService {
	
	//Fields from csv file 
	private String publicName; 
	private String alternateName; 
	private String parentAgency; 
	private String address; 
	private City city; 
	private String postalCode; 
	private String Country; 
	private String scheduleAppt;
	private String phoneNumber; 
	private String email; 
	private String website; 
	private String eligibility; 
	private String feeStructure; 
	private String applicationProcess; 
	private Date openedOn; 
	private String dateOpened; 
	private String taxonomyTerm; 
	private String hours;
	private Region region; 
	
	public GeoService(String publicName, String alternateName, String parentAgency, String address, City city,
			String postalCode, String country, String scheduleAppt, String phoneNumber, String email, String website,
			String eligibility, String feeStructure, String applicationProcess, Date openedOn, String dateOpened, String taxonomyTerm,
			String hours, Region region) {
		super();
		this.publicName = publicName;
		this.alternateName = alternateName;
		this.parentAgency = parentAgency;
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		Country = country;
		this.scheduleAppt = scheduleAppt;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.website = website;
		this.eligibility = eligibility;
		this.feeStructure = feeStructure;
		this.applicationProcess = applicationProcess;
		this.openedOn = openedOn;
		this.dateOpened = dateOpened; 
		this.taxonomyTerm = taxonomyTerm;
		this.hours = hours;
		this.region = region;
	}

	
	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	//Empty Constructor 
	public GeoService() {
		
	}

	
	public String getScheduleAppt() {
		return scheduleAppt;
	}


	public void setScheduleAppt(String scheduleAppt) {
		this.scheduleAppt = scheduleAppt;
	}


	public String getPublicName() {
		return publicName;
	}
	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}
	public String getAlternateName() {
		return alternateName;
	}
	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}
	public String getParentAgency() {
		return parentAgency;
	}
	public void setParentAgency(String parentAgency) {
		this.parentAgency = parentAgency;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public String getFeeStructure() {
		return feeStructure;
	}
	public void setFeeStructure(String feeStructure) {
		this.feeStructure = feeStructure;
	}
	public String getApplicationProcess() {
		return applicationProcess;
	}
	public void setApplicationProcess(String applicationProcess) {
		this.applicationProcess = applicationProcess;
	}
	public Date getOpenedOn() {
		return openedOn;
	}
	public void setOpenedOn(Date openedOn) {
		this.openedOn = openedOn;
	}
	public String getTaxonomyTerm() {
		return taxonomyTerm;
	}
	public void setTaxonomyTerm(String taxonomyTerm) {
		this.taxonomyTerm = taxonomyTerm;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}


	@Override
	public String toString() {
		return publicName;
	}
	
	public String print() {
		return "Name: " + publicName + "\nParent Agency: " + parentAgency + "\nAddress: " + address + ", " + Country + "\nPostal Code: " + postalCode + 
				"\nPhone #: " + phoneNumber + "\nEmail: " + email + "\nWebsite: " + website + "\nEligibility: " + eligibility + "\nFee Structure: " + feeStructure + 
				"\nApplication : " + applicationProcess + "\nDate Opened: " + dateOpened + "\nTaxonomy Term: " + taxonomyTerm + "\nHours: " + hours; 
	}
	

	
	
	
	
}
