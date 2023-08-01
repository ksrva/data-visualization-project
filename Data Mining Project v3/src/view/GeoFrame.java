//Kamakshi
/*
 * Creates the Geographical distribution frame 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import controller.DataMiningFrameController;
import controller.GeoFileImportController;

public class GeoFrame extends JFrame{
	
	
	//JPanels 
	private JPanel geoPanel; 

	
	//Graph (Bottom Left) 
	
	
	

	public GeoFrame() {
		
		
		GeoFileImportController files = new GeoFileImportController(); 
		
		
		
		// Frame
		setTitle("Geographical Distribution Frame");
		setLayout(null);
		setSize(1920, 1080);
		setResizable(false);
		
		setJMenuBar(DataMiningFrameController.createMenuBar());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// TODO Add components
		setVisible(true);
		
		//Panels
		geoPanel = new GeoPanel();
		geoPanel.setBounds(0, 0, 1920, 1080); //Change Back Later 
		add(geoPanel);
		

	}
	

	
			
}
