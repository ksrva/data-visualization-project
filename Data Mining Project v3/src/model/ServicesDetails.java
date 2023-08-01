
//Jeffrey

package model;

public class ServicesDetails {

	private String name;
	private String parentAgency;
	private String parentAgencyNum;
	private String address;
	private String phoneNumber;
	private String website;
	private String contactName;
	private String contactTitle;
	private String email;
	private String contactNumber;

	public ServicesDetails(String name, String parentAgency, String parentAgencyNum, String address, String phoneNumber,
			String website, String contactName, String contactTitle, String email, String contactNumber) {

		this.name = name;
		this.parentAgency = parentAgency;
		this.parentAgencyNum = parentAgencyNum;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.email = email;
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentAgency() {
		return parentAgency;
	}

	public void setParentAgency(String parentAgency) {
		this.parentAgency = parentAgency;
	}

	public String getParentAgencyNum() {
		return parentAgencyNum;
	}

	public void setParentAgencyNum(String parentAgencyNum) {
		this.parentAgencyNum = parentAgencyNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "servicesDetails [name=" + name + ", parentAgency=" + parentAgency + ", parentAgencyNum="
				+ parentAgencyNum + ", address=" + address + ", phoneNumber=" + phoneNumber + ", website=" + website
				+ ", contactName=" + contactName + ", contactTitle=" + contactTitle + ", email=" + email
				+ ", contactNumber=" + contactNumber + "]";
	}

	public Object[] toObjectArray() {
		return new Object[] { name, parentAgency, parentAgencyNum, address, phoneNumber, website, contactName,
				contactTitle, email, contactNumber };
	}
}