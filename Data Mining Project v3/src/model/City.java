//Kamakshi
/*
 * Models a city which is used as an element of an arraylist which is an attribute for a region
 */
package model;

import java.awt.Point;

public class City {

	private String name;
	private Point location; // for interactive map

	// Constructor(s)
	public City() {

	}

	public City(String name, Point location) {
		this.name = name;
		this.location = location;
	}

	// GETTERS and SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	// TOString
	@Override
	public String toString() {
		return "City [name=" + name + ", location=" + location + "]";
	}

}
