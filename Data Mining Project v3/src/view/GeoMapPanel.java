//Kamakshi
/*
 * Holds JLabels with mouselinesner and other contents for the interactive Geo Map feature 
 */
package view;
import model.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jfree.chart.JFreeChart;

import controller.*; 


public class GeoMapPanel extends JPanel {



	//private JLabel titleBackground;


	
	private static JLabel mapLabel;

	

	private static JLabel region1Label;
	private static JLabel region2Label;
	private static JLabel region3Label;
	private static JLabel region4Label;
	private static JLabel region5Label;
	private static JLabel region6Label;
	private static JLabel region7Label;
	private static JLabel region8Label;
	private static JLabel region9Label;
	private static JLabel region10Label;
	private static JLabel region11Label;
	private static JLabel region12Label;
	private static JLabel region13Label;
	private static JLabel region14Label;
	private static JLabel region15Label;
	
	private static ArrayList<JLabel> regionLabels;
	
	private static JTextArea serviceText; 
	
	
	public GeoMapPanel() {
		
		setLayout(null);
		
		serviceText = new JTextArea(); 
		
		
		regionLabels = new ArrayList<JLabel>();
		createRegionLabels();
		
		region1Label.setBounds(525, 750, 20, 20);
		initializeRegionLabel(region1Label);
		region1Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[0]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[0]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region1Label);
		GeoFileImportController.regionList[0].setRegionLabel(region1Label);
		

		region2Label = new JLabel("2");
		region2Label.setBounds(615, 740, 20, 20);
		initializeRegionLabel(region2Label);
		region2Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[1]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[1]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region2Label);
		GeoFileImportController.regionList[1].setRegionLabel(region2Label);
		

		region3Label = new JLabel("3");
		region3Label.setBounds(590, 730, 20, 20);
		initializeRegionLabel(region3Label);
		region3Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[2]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[2]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region3Label);
		GeoFileImportController.regionList[2].setRegionLabel(region3Label);

		region4Label = new JLabel("4");
		region4Label.setBounds(550, 710, 20, 20);
		initializeRegionLabel(region4Label);
		region4Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[3]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[3]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region4Label);
		GeoFileImportController.regionList[3].setRegionLabel(region4Label);

		region5Label = new JLabel("5");
		region5Label.setBounds(620, 710, 20, 20);
		initializeRegionLabel(region5Label);
		region5Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[4]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[4]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region5Label);
		GeoFileImportController.regionList[4].setRegionLabel(region5Label);

		region6Label = new JLabel("6");
		region6Label.setBounds(590, 695, 20, 20);
		initializeRegionLabel(region6Label);
		region6Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[5]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[5]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region6Label);
		GeoFileImportController.regionList[5].setRegionLabel(region6Label);

		region7Label = new JLabel("7");
		region7Label.setBounds(550, 670, 20, 20);
		initializeRegionLabel(region7Label);
		region7Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[6]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[6]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region7Label);
		GeoFileImportController.regionList[6].setRegionLabel(region7Label);

		region8Label = new JLabel("8");
		region8Label.setBounds(650, 670, 20, 20);
		initializeRegionLabel(region8Label);
		region8Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[7]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[7]);

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region8Label);
		GeoFileImportController.regionList[7].setRegionLabel(region8Label);

		region9Label = new JLabel("9");
		region9Label.setBounds(720, 670, 20, 20);
		initializeRegionLabel(region9Label);
		region9Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[8]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[8]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region9Label);
		GeoFileImportController.regionList[8].setRegionLabel(region9Label);

		region10Label = new JLabel("10");
		region10Label.setBounds(755, 620, 20, 20);
		initializeRegionLabel(region10Label);
		region10Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[9]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[9]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region10Label);
		GeoFileImportController.regionList[9].setRegionLabel(region10Label);

		region11Label = new JLabel("11");
		region11Label.setBounds(680, 640, 20, 20);
		initializeRegionLabel(region11Label);
		region11Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[10]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[10]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region11Label);
		GeoFileImportController.regionList[10].setRegionLabel(region11Label);

		region12Label = new JLabel("12");
		region12Label.setBounds(595, 610, 20, 20);
		initializeRegionLabel(region12Label);
		region12Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[11]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[11]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region12Label);
		GeoFileImportController.regionList[11].setRegionLabel(region12Label);

		region13Label = new JLabel("13");
		region13Label.setBounds(575, 530, 20, 20);
		initializeRegionLabel(region13Label);
		region13Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[12]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[12]); 

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region13Label);
		GeoFileImportController.regionList[12].setRegionLabel(region13Label);

		region14Label = new JLabel("14");
		region14Label.setBounds(460, 490, 20, 20);
		initializeRegionLabel(region14Label);
		region14Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				GeoPanel.getSearch().setEnabled(false);

				initializeMapRegionPanes(GeoFileImportController.regionList[13]);
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[13]);
				

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region14Label);
		GeoFileImportController.regionList[13].setRegionLabel(region14Label);

		region15Label = new JLabel("15");
		region15Label.setBounds(250, 330, 20, 20);
		initializeRegionLabel(region15Label);
		region15Label.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				GeoPanel.getSearch().setEnabled(false);
				initializeMapRegionPanes(GeoFileImportController.regionList[14]); 
				add(getMapLabel());
				addRegionMenus(GeoFileImportController.regionList[14]); 
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});
		add(region15Label);
		GeoFileImportController.regionList[14].setRegionLabel(region15Label);

//		// add(mapPanel);
//		mapLabel = new JLabel(" ");
//		mapLabel.setLayout(null);
//		mapLabel.setBounds(0, 0, 900, 800);
//		ImageIcon mapImage = new ImageIcon("images/map3.png");
//		mapLabel.setIcon(mapImage);
//		add(mapLabel);
//		
//		currentPanel = mapPanel;
//		add(currentPanel);
		
		// add(mapPanel);
				setMapLabel(new JLabel(" "));
				getMapLabel().setLayout(null);
				getMapLabel().setBounds(0, 0, 900, 800);
				getMapLabel().setOpaque(true);
				ImageIcon mapImage = new ImageIcon("images/map.png");
				getMapLabel().setIcon(mapImage);
				getMapLabel().setVisible(true);
				add(getMapLabel());

		
		
		
	}
	

	// Create and add Region Labels to the map panel
	public static void createRegionLabels() {
		region1Label = new JLabel("1");
		regionLabels.add(region1Label);
		GeoFileImportController.regionList[0].setRegionLabel(region1Label);
		
		region2Label = new JLabel("2");
		regionLabels.add(region2Label);
		GeoFileImportController.regionList[1].setRegionLabel(region2Label);
		
		region3Label = new JLabel("3");
		regionLabels.add(region3Label);
		GeoFileImportController.regionList[2].setRegionLabel(region3Label);
		
		region4Label = new JLabel("4");
		regionLabels.add(region4Label);
		GeoFileImportController.regionList[3].setRegionLabel(region4Label);
		
		region5Label = new JLabel("5");
		regionLabels.add(region5Label);
		GeoFileImportController.regionList[4].setRegionLabel(region5Label);
		
		region6Label = new JLabel("6");
		regionLabels.add(region6Label);
		GeoFileImportController.regionList[5].setRegionLabel(region6Label);
		
		region7Label = new JLabel("7");
		regionLabels.add(region7Label);
		GeoFileImportController.regionList[6].setRegionLabel(region7Label);
		
		region8Label = new JLabel("8");
		regionLabels.add(region8Label);
		GeoFileImportController.regionList[7].setRegionLabel(region8Label);
		
		region9Label = new JLabel("9");
		regionLabels.add(region9Label);
		GeoFileImportController.regionList[8].setRegionLabel(region9Label);
		
		region10Label = new JLabel("10");
		regionLabels.add(region10Label);
		GeoFileImportController.regionList[9].setRegionLabel(region10Label);
		
		region11Label = new JLabel("11");
		regionLabels.add(region11Label);
		GeoFileImportController.regionList[10].setRegionLabel(region11Label);
		
		region12Label = new JLabel("12");
		regionLabels.add(region12Label);
		GeoFileImportController.regionList[11].setRegionLabel(region12Label);
		
		region13Label = new JLabel("13");
		regionLabels.add(region13Label);
		GeoFileImportController.regionList[12].setRegionLabel(region13Label);
		
		region14Label = new JLabel("14");
		regionLabels.add(region14Label);
		GeoFileImportController.regionList[13].setRegionLabel(region14Label);
		
		region15Label = new JLabel("15");
		regionLabels.add(region15Label);
		GeoFileImportController.regionList[14].setRegionLabel(region15Label);
	}

	
	// Set alignment & Colouring
	public static void initializeRegionLabel(JLabel regionLabel) {
		
		regionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regionLabel.setOpaque(true);
		regionLabel.setForeground(Color.white);
		regionLabel.setBackground(Color.BLACK);
	}

	public static void enableMapLabels(boolean status) {
		for (JLabel currentLabel : regionLabels) {
			currentLabel.setVisible(status);
		}
	}
	
	public static void initializeMapRegionPanes(Region currentRegion) {
		
		//Add the region: 
		GeoPanel.getTitleBackground().setText("Region " + currentRegion.getReferenceNumber() +  " - " + currentRegion.getFullName());
		ImageIcon region = new ImageIcon("images/region" + currentRegion.getReferenceNumber() + ".png");

		mapLabel.setIcon(region);
		
		
	}
	
	
	public static void addRegionMenus(Region currentRegion) {
		//Display menu 
		
				ArrayList<GeoService> servicesInRegion = new ArrayList<GeoService>();

				for (GeoService currentService : GeoFileImportController.geoServices) {
					if (currentService.getRegion().equals(currentRegion)) {
						servicesInRegion.add(currentService);
						
					}
				}

				GeoService selectedService = (GeoService) JOptionPane.showInputDialog(null,
						"Services in " + currentRegion.getName(), "Choose a service", JOptionPane.QUESTION_MESSAGE, null,
						servicesInRegion.toArray(), servicesInRegion.get(0));

				
				if(!(selectedService == null)) {
					serviceText = new JTextArea(selectedService.print());
					serviceText.setBackground(GeoPanel.getColor1());
					serviceText.setForeground(GeoPanel.getColor4());
					
					GeoPanel.getScrollPane().setViewportView(serviceText);
					GeoPanel.getInfoPanel().add(GeoPanel.getScrollPane()); 
				}
				
	}


	public static JLabel getMapLabel() {
		return mapLabel;
	}


	public static void setMapLabel(JLabel mapLabel) {
		GeoMapPanel.mapLabel = mapLabel;
	}
	
	
	
}
