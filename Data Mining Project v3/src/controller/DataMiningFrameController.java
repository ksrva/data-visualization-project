//Use for methods & features that are common accross frames 
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import view.AgeDistributionFrame;
import view.GeoFrame;

import view.OrganizationFrame;
import view.TitleFrame;
import view.YouthFrame;

public class DataMiningFrameController {

	// TODO add other frames
	private static JFrame currentFrame; 
	private static TitleFrame titleFrame;
	private static GeoFrame geographicalFrame;
	private static AgeDistributionFrame ageDistributionFrame;
	private static OrganizationFrame organizationDistributionFrame;
	private static YouthFrame youthFrame; 

	// private static JMenuBar menuBar;

	

	

	public DataMiningFrameController() {

	
		
		// menuBar = createMenuBar();
		titleFrame = new TitleFrame();
		currentFrame = titleFrame; 
	
		// TODO Initialize other frames and set their visibility to false
		geographicalFrame = new GeoFrame();
		geographicalFrame.setVisible(false);
		
		ageDistributionFrame = new AgeDistributionFrame();
		ageDistributionFrame.setVisible(false);
		
		organizationDistributionFrame = new OrganizationFrame();
		organizationDistributionFrame.setVisible(false);
		
		youthFrame = new YouthFrame();
		youthFrame.setVisible(false);
		
	}

	// Closes a frame
	public static void closeFrame(JFrame frame) {

		frame.dispose();

	}

	// Method to create menu bar
	public static JMenuBar createMenuBar() {

		JMenuBar menuBar;
		JMenu home, help, otherFrames; // Menu Options displayed in bar
		JMenuItem menuItem, helpItem1, ageFrame, geoFrame, orgFrame, youFrame; // drop-down items within each menu
																				// option
		JRadioButtonMenuItem rdmi;
		JCheckBoxMenuItem cbmi;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// TODO change menu names to more relevant ones
		// BUILD HOME MENU
		home = new JMenu("Home");
		home.setMnemonic(KeyEvent.VK_F);
		home.getAccessibleContext().setAccessibleDescription("Return to title frame");
		menuBar.add(home);
		
		menuItem = new JMenuItem("Return to Title Screen");
		menuItem.setMnemonic(KeyEvent.VK_F);
		menuItem.getAccessibleContext().setAccessibleDescription("");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				currentFrame = getTitleFrame();  
				currentFrame.setVisible(true); 
				closeOtherFrames(currentFrame); 
				
			
			}
		});
		home.add(menuItem);

		

		// BUILD HELP MENU
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_F);
		help.getAccessibleContext().setAccessibleDescription("Get Help");
		menuBar.add(help);

		// create help menu sub-items & Implement ActionListeners
		// TODO add more help items to split "How to use" and "directions" information
		// into sections related to each frame, etc
		helpItem1 = new JMenuItem("Get Help");
		helpItem1.setMnemonic(KeyEvent.VK_F);
		helpItem1.getAccessibleContext().setAccessibleDescription("help item 1?");
		helpItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				
				// TODO add rules here
				JOptionPane.showMessageDialog(currentFrame,
						"Use the main menu bar to navigate through the GUI. \n"
						+ "\n"
						+ "\nTo return to the home page, click the \"Home\" menu option and \"Return to Title Frame.\" "
						+ "\nThis will close your current screen and take you back to the splash screen. \n"
						+ "\n"
						+ "\nTo see other screens with specified information and different data visualizations "
						+ "\nregarding mental health services in Ontario, click the \"Other Frames\" menu option. \n"
						+ "\n"
						+ "\nYou will see four sub-options here. By clicking one, your current frame will close, and "
						+ "\nyou will be taken to the chosen frame. The sub-options are as follows: \n"
						+ "\n"
						+ "Distribution By Age: "
						+ "\nThis frame will explore which age groups are most vulnerable to mental health issues. "
						+ "\nThrough data visualization, we may determine factors regarding why people may/may not "
						+ "\ndecide to seek help based on their age. If you need help navigating through this frame you"
						+ "\ncan use the tab buttons to switch between tabs. You can also view the right panel in this frame"
						+ "\nfor more information on each topic."
						+ "\n"
						+ "\n"
						+ "Distribution by Geographical Region: "
						+ "\nThis frame focuses on the distribution of mental health services by the 15 regions in "
						+ "\nOntario. The data visualizations, including a heat map and time series chart, can be used "
						+ "\nto determine which areas provide accessible mental health services and how the distribution "
						+ "\ncan be improved. \n"
						+ "\n"
						+ "Distribution by Organization: This frame uses relevant data to visualize information about how "
						+ "\ndifferent mental health organizations can impact children and adults.\n"
						+ "\n"
						+ "Distribution by Institution: This frame will explore the distribution of mental health "
						+ "\nservices provided to individual institutions and jobs.  "
				
						);
		
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
			}
		});
		help.add(helpItem1);

		// BUILD OTHER FRAMES MENU
		otherFrames = new JMenu("Other Frames");
		otherFrames.setMnemonic(KeyEvent.VK_F);
		otherFrames.getAccessibleContext().setAccessibleDescription("View Other Frames");
		menuBar.add(otherFrames);

		// create other frames menu sub-items & Implement ActionListeners
		ageFrame = new JMenuItem("Distribution by Age");
		ageFrame.setMnemonic(KeyEvent.VK_F);
		ageFrame.getAccessibleContext().setAccessibleDescription("Mental Health Service Distribution by Age");
		ageFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				currentFrame = getAgeDistributionFrame(); 
				currentFrame.setVisible(true);
				closeOtherFrames(currentFrame);
				
				
			}
		});
		otherFrames.add(ageFrame);

		geoFrame = new JMenuItem("Distribution by Geographical Region");
		geoFrame.setMnemonic(KeyEvent.VK_F);
		geoFrame.getAccessibleContext()
				.setAccessibleDescription("Mental Health Service Distribution by Geographical Region");
		geoFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				currentFrame = getGeographicalFrame(); 
				currentFrame.setVisible(true);
				closeOtherFrames(currentFrame);
				 
				
			}
		});
		otherFrames.add(geoFrame);

		orgFrame = new JMenuItem("Distribution by Organization");
		orgFrame.setMnemonic(KeyEvent.VK_F);
		orgFrame.getAccessibleContext().setAccessibleDescription("Mental Health Service Distribution by Organization");
		orgFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				currentFrame = getOrganizationDistributionFrame(); 
				currentFrame.setVisible(true);
				closeOtherFrames(currentFrame);

			}
		});
		otherFrames.add(orgFrame);

		youFrame = new JMenuItem("Distribution by Youth Offenders");
		youFrame.setMnemonic(KeyEvent.VK_F);
		youFrame.getAccessibleContext().setAccessibleDescription("Mental Health Service Distribution by Youth Offenders");
		youFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {

				currentFrame = getYouthFrame(); 
				currentFrame.setVisible(true);
				closeOtherFrames(currentFrame);

			}
		});
		otherFrames.add(youFrame);
		return menuBar;	
		
		
		
	}

	public static AgeDistributionFrame getAgeDistributionFrame() {
		return ageDistributionFrame;
	}

	public static void setAgeDistributionFrame(AgeDistributionFrame ageDistributionFrame) {
		DataMiningFrameController.ageDistributionFrame = ageDistributionFrame;
	}

	public static void setTitleFrame(TitleFrame titleFrame) {
		DataMiningFrameController.titleFrame = titleFrame;
	}

	public static void setGeographicalFrame(GeoFrame geographicalFrame) {
		DataMiningFrameController.geographicalFrame = geographicalFrame;
	}

	public static void closeOtherFrames(JFrame frame) {

		titleFrame.setVisible(false);
		geographicalFrame.setVisible(false);
		ageDistributionFrame.setVisible(false);
		organizationDistributionFrame.setVisible(false);
		youthFrame.setVisible(false);

		frame.setVisible(true);

	}

	// Getters and Setters
	public static TitleFrame getTitleFrame() {
		return titleFrame;
	}

	public static GeoFrame getGeographicalFrame() {
		return geographicalFrame;
	}

	public static OrganizationFrame getOrganizationDistributionFrame() {
		return organizationDistributionFrame;
	}

	public static void setOrganizationDistributionFrame(OrganizationFrame organizationDistributionFrame) {
		DataMiningFrameController.organizationDistributionFrame = organizationDistributionFrame;
	}
	
	public static YouthFrame getYouthFrame() {
		return youthFrame;
	}

	public static void setYouthFrame(YouthFrame youthFrame) {
		DataMiningFrameController.youthFrame = youthFrame;
	}
}