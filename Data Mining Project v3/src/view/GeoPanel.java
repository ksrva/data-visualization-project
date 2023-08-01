//Kamakshi

/*
 * Geo panel holds Map Panel and Recommendation panel as well as all components in the GeoFrmae
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.LookupPaintScale;
import org.jfree.chart.renderer.xy.XYBlockRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.PaintScaleLegend;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.XYZDataset;
import org.jfree.ui.RectangleEdge;

import controller.DataMiningFrameController;
import controller.GeoFileImportController;
import model.City;
import model.GeoService;
import model.Region;

public class GeoPanel extends JPanel {

	private static Font font1 = new Font("Serif", Font.BOLD, 10); 
	private static Font font2 = new Font("Serif", Font.BOLD, 20); 
	
	private static Color color1 = new Color(233,213,218); 
	private static Color color2 = new Color(130, 115, 151); 
	private static Color color3 = new Color(77, 76, 125);
	private static Color color4 = new Color(54, 48, 98); 
	
	private JPanel currentPanel;
	private JPanel placeHolderPanel;

	private JButton mapReturn;
	private JButton switchMap;
	private JButton switchHeatMap; 
	private JButton switchTimeSer;
	private JButton switchRegion;
	private JButton userGuide; 
	private static JButton search; 
	
	private Region currentRegion;
	private int currentTimeSeriesFilter; 
	
	private int startYearTimeSeries; 
	private int endYearTimeSeries;
	
	private int startYearHeatMap; 
	private int endYearHeatMap;

	//Control Panel 
	private JPanel controlPanel;

	private JPanel heatMapPanel; // heatmap
	private JPanel timeSeriesPanel; //Time Series 

	private static JLabel titleBackground;

	private JFreeChart chart;
	
	
	private JButton customYearsTime;
	private JButton timeSeriesDefaultRange;
	private JButton Time0510;
	private JButton Time1015;
	private JButton Time1519;
	
	private JButton customYearHeatMap; 
	private JButton heatMapDefaultRange; 
	private JButton HeatMap0510; 
	private JButton HeatMap1015;
	private JButton HeatMap1519;

	private static JPanel mapPanel;
	
	private JButton allLines; 
	private JButton allServices; 
	private JButton freeServices; 
	private JButton youthServices; 
	private JButton dropInServices; 
	private JButton lgbtServices;
	private JButton aboServices; 
	
	private static int a; 
	private static int b; 
	
	private JButton pinkHeatMap; 
	private JButton greenHeatMap; 
	private JButton tealHeatMap; 
	private JButton blueHeatMap; 
	private JButton yellowHeatMap; 

	private static ArrayList<JButton> mapButtonsList; 
	private static ArrayList<JButton> heatMapButtonsList; 
	private static ArrayList<JButton> timeSeriesButtonsList; 
	
	
	
	
	
	private static JPanel infoPanel; 
	private static JTextArea infoText;
	
	
	private JPanel heatMapTimePanel; 
	private JPanel heatMapColourPanel; 
	private JPanel heatMapAnalysisPanel; 
	
	private JPanel timeSeriesTimePanel;
	private JPanel timeSeriesLinePanel; 
	private JPanel timeSeriesAnalysisPanel; 
	
	private JButton timeSeriesAnalysis; 
	private JButton heatMapAnalysis; 

	private JTextArea heatMapAnalysisText; 
	private JTextArea timeSeriesAnalysisText; 
	
	private static JScrollPane scrollPane; 
	private static JScrollPane scrollPaneReco;
	
	private static GeoRecommendationPanel geoRecoPanel; 
	
	//private  ArrayList<JLabel> regionLabels; 

	public GeoPanel() {
		

		
		infoText = new JTextArea("Click Get Analysis to view analysis in this panel, or "
				+ "\nclick on the interactive map to view information about services "
				+ "\nin this panel"); 
		infoText.setEditable(false);
		infoText.setBackground(getColor1());
		
		mapButtonsList = new ArrayList<JButton>(); 
		heatMapButtonsList = new ArrayList<JButton>(); 
		timeSeriesButtonsList = new ArrayList<JButton>(); 

		setBackground(color2);
		setLayout(null);

		//INFO PANEL 
		setInfoPanel(new JPanel()); 
		getInfoPanel().setBackground(color3);
		getInfoPanel().setLayout(null);
		getInfoPanel().setBounds(960, 33+410, 920, 527);
		add(getInfoPanel());
		
		
		
		setScrollPane(new JScrollPane());
		getScrollPane().setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getScrollPane().setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		getScrollPane().setBounds(10, 10, 900, 507);
		getScrollPane().setViewportView(infoText);
		infoPanel.add(getScrollPane()); 
		
		scrollPaneReco = new JScrollPane(); 
		getScrollPaneReco().setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getScrollPaneReco().setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		getScrollPaneReco().setViewportView(new JTextArea(" "));
		getScrollPaneReco().setBounds(450, 10, 460, 507);	
		
		setGeoRecoPanel(new GeoRecommendationPanel()); 
		getGeoRecoPanel().setBackground(color3);
		getGeoRecoPanel().setLayout(null);
		getGeoRecoPanel().setBounds(960, 33+410, 920, 527);
		
		
		// PLACEHOLDER PANEL
		placeHolderPanel = new JPanel();
		placeHolderPanel.setLayout(null);
		placeHolderPanel.setBackground(getColor1());
		placeHolderPanel.setBounds(40, 170, 900, 800);
		JLabel placeHolder = new JLabel("Select Data Visualization from the menu");
		placeHolder.setLayout(null);
		placeHolder.setBounds(350, 350, 500, 100);
		placeHolderPanel.add(placeHolder);
		currentPanel = placeHolderPanel; 
		add(currentPanel); 
		
	
		// INTERCHANGING PANELS (create but don't add)
		

		setTitleBackground(new JLabel(" "));

		// Black
		getTitleBackground().setLayout(null);
		getTitleBackground().setBounds(40, 120, 900, 50);
		getTitleBackground().setFont(new Font("Futura", Font.PLAIN, 15));

		getTitleBackground().setHorizontalAlignment(SwingConstants.CENTER);
		getTitleBackground().setOpaque(true);
		getTitleBackground().setForeground(Color.white);
		getTitleBackground().setBackground(color4);
		add(getTitleBackground());

		userGuide = new JButton("User Guide");
		userGuide.setBounds(40, 30, 172, 70);
		// years1.setFont(new Font("Futura", Font.PLAIN, 15));
		add(userGuide);
		userGuide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				enableControlButtons(null);
				
				// TODO add rules here
				JOptionPane.showMessageDialog(DataMiningFrameController.getGeographicalFrame(),
						"Geographical Frame User Guide\n"
						+ "\n"
						+ "Interactive Map:\n"
						+ "Click the Map Button above the data visualization panel to see the map image with clickable "
						+ "\nregions and access the map controls. \n"
						+ "To view the services in a region, click the respective label on the map image. \n"
						+ "To view the services of a region by using the city as the search feature, \"click search"
						+ "\nregions by city\". \n"
						+ "To return to the main map, click \"Return to Main Map\"\n"
						+ "\n"
						+ "Heat Map: \n"
						+ "Click the Heat Map Button to view the heat map and access the heat map controls. \n"
						+ "You can change the range (years) using the preset time periods or customizing your "
						+ "\nown time period (Please note data is not available for years prior to 2005 and after 2019). \n"
						+ "You can also change the colour theme of the heat map using the buttons on the control panel. \n"
						+ "Finally, you can also get an analysis of what the heat map tell us by clicking on "
						+ "\nthe \"Get Analysis\" button. The analysis will be displayed below the control panel in "
						+ "\nthe information text panel. \n"
						+ "To reset the heat map from all the controls you can just click the \"Heat Map\" button again. \n"
						+ "\n"
						+ "Time Series Chart(s): \n"
						+ "Click the Time Series buttonto view the time series chart and access it's controls in the "
						+ "\ncontrol panel. \n"
						+ "You can change the range (years) using the preset time periods or customizing your own "
						+ "\ntime period (Please note data is not available for years prior to 2005 and after 2019). \n"
						+ "You can look at each region in Ontario by clicking the \"Switch Regions\" button "
						+ "\nwhich allows you to switch between regions. \n"
						+ "You can filter the graph data to show you individual lines for services that are directed "
						+ "\ntowards youth, LGBTQ2S+, and Aboriginals as well as services that are free and drop-in"
						+ "\nappointment types. \n"
						+ "Finally, you can also get an analysis of what the Time Series Chart tells us by clicking "
						+ "\non the \"Get Analysis\" button. The analysis will be displayed below the control panel in "
						+ "\nthe information text panel. \n"
						+ "To reset the time series chart from all the controls you can just click the \"Heat Map\" button "
						+ "\nagain. \n"
						+ "\n"
						+ "Recommendations: \n"
						+ "To get a eprsonalized list of services click the recommendations button. A Panel with "
						+ "\nfilters will be displayed below the control panel. Select what applies to you "
						+ "\n(if you are not concerned about a certain category click the \"Any\" option). Once"
						+ "\ncomplete, you can click \"Submit\" to see a list of services that are recommended to you based "
						+ "\non the preferences you chose. If you make a mistake or want to try again using different "
						+ "\nfilters, click \"redo\". "
				
						);
		
				
				
			}

		});
		
		
		// Visual Display controls 
		switchMap = new JButton("Map");
		switchMap.setBounds(40+182, 30, 172, 70);
		// years1.setFont(new Font("Futura", Font.PLAIN, 15));
		add(switchMap);
		switchMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				getScrollPane().setViewportView(infoText);

				enableControlButtons(mapButtonsList); 
				
				getTitleBackground().setText("Map of Ontario");
				
				currentPanel.setVisible(false);

				mapPanel = new GeoMapPanel();
				mapPanel.setLayout(null);
				mapPanel.setBounds(40, 170, 900, 800);

				// mapPanel.setLayout(null);

				// add chart to frame and make frame visible
				currentPanel = mapPanel;
				currentPanel.setVisible(true);
				add(mapPanel);

				getGeoRecoPanel().setVisible(false);
				getScrollPane().setVisible(true); 
				infoPanel.setVisible(true);
				add(infoPanel); 
//				getScrollPane().setVisible(true); 
//				infoPanel.add(getScrollPane()); 
				
				
			}

		});

		// Display HeatMap
		switchHeatMap = new JButton("Heat Map");
		switchHeatMap.setBounds(40+182+182, 30, 172, 70);
		// years1.setFont(new Font("Futura", Font.PLAIN, 15));
		add(switchHeatMap);
		switchHeatMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				getScrollPane().setViewportView(infoText);
				
				enableControlButtons(heatMapButtonsList); 
				
				a = 100; 
				b = 255; 
				startYearHeatMap = 2005; 
				endYearHeatMap = 2019; 
				getTitleBackground().setText("Heat Map of # of services per Region over years");
				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, 255, 100); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);
				
				getGeoRecoPanel().setVisible(false);
				getScrollPane().setVisible(true); 
				infoPanel.setVisible(true);
				add(infoPanel); 
				
			}

		});
		
		// Displays the automated time series for region 1
		switchTimeSer = new JButton("Time Series");
		switchTimeSer.setBounds(40+182+182+182, 30, 172, 70);
		// years1.setFont(new Font("Futura", Font.PLAIN, 15));
		add(switchTimeSer);
		switchTimeSer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				getScrollPane().setViewportView(infoText);
				
				enableControlButtons(timeSeriesButtonsList); 

				currentRegion = GeoFileImportController.regionList[0];
				startYearTimeSeries = 2005; 
				endYearTimeSeries = 2019; 
				currentTimeSeriesFilter = 0; 
				currentPanel.setVisible(false);
				
				chart = createChart(createDataset(2005, 2019), 2005, 2019, a, b); // data
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				getTitleBackground().setText("Time Series Chart Per Region");
				currentPanel.setVisible(true);
				
				getGeoRecoPanel().setVisible(false);
				getScrollPane().setVisible(true); 
				infoPanel.setVisible(true);
				add(infoPanel); 
				
			}
		});
		
		// TODO CHANGE BUTTON NAME AND ADD ACTION LISTENER 
				switchTimeSer = new JButton("Recommendations");
				switchTimeSer.setBounds(40+182+182+182+182, 30, 172, 70);
				// years1.setFont(new Font("Futura", Font.PLAIN, 15));
				add(switchTimeSer);
				switchTimeSer.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						enableControlButtons(null); 
						
						infoPanel.setVisible(false);
						getGeoRecoPanel().setVisible(true); 
						
	
						getScrollPaneReco().setVisible(true); 
						getGeoRecoPanel().add(getScrollPaneReco()); 
						
						add(getGeoRecoPanel()); 
						
						
					}
				});
		

	
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		//CONTROL PANEL CONTENT 
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		controlPanel.setBackground(color3);
		controlPanel.setBounds(960, 33, 920, 400);
		add(controlPanel);

		//Map Controls 
		JLabel mapControls = new JLabel("Map Controls"); 
		mapControls.setLayout(null); 
		mapControls.setBounds(13,10,100,20); 
		mapControls.setForeground(getColor1());
		controlPanel.add(mapControls); 
		
		mapReturn = new JButton("Return to Main Map");
		mapReturn.setBounds(10, 35, 168, 40);
		// years1.setFont(new Font("Futura", Font.PLAIN, 15));
		mapReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				getSearch().setEnabled(true);
				
				getTitleBackground().setText("Map of Ontario");
				currentPanel.setVisible(false);

				mapPanel = new GeoMapPanel();
				mapPanel.setLayout(null);
				mapPanel.setBounds(40, 170, 900, 800);

				// mapPanel.setLayout(null);

				// add chart to frame and make frame visible
				currentPanel = mapPanel;
				currentPanel.setVisible(true);
				add(mapPanel);

			}

		});
		controlPanel.add(mapReturn); 
		mapButtonsList.add(mapReturn); 
		
		
		setSearch(new JButton("Search Regions by City"));
		getSearch().setBounds(10 + 168, 35, 168, 40);
		getSearch().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				search.setEnabled(false);
				
				City citySearched = (City) JOptionPane.showInputDialog(null,
						"Select a city", "Find regions by city", JOptionPane.QUESTION_MESSAGE, null,
						GeoFileImportController.geoCities.toArray(), GeoFileImportController.geoCities.get(0));

				Region answer = new Region(); 
				if(!(citySearched == null)) {
					for(Region currentRegion : GeoFileImportController.regionList) {
						for(City currentCity : currentRegion.getCitiesWithinRegion()) {
							if(currentCity.equals(citySearched)) {
								answer = currentRegion; 
								//currentPanel.setVisible(false); 
								//mapPanel = new MapPanel(); 
								GeoMapPanel.initializeMapRegionPanes(answer); 
								mapPanel.add(GeoMapPanel.getMapLabel());
								GeoMapPanel.addRegionMenus(answer);
								currentPanel = mapPanel; 
								//mapPanel.setVisible(true);
								currentPanel.setVisible(true); 
								add(currentPanel); 
								
							}
						}
					}
				}else {
					search.setEnabled(true);
				}
				
				
				
				
				

				
			}

		});
		controlPanel.add(getSearch()); 
		mapButtonsList.add(getSearch()); 
		
		
		
		
		
		
		
		//Heat Map Controls 
		JLabel heatMapControls = new JLabel("Heat Map Controls"); 
		heatMapControls.setLayout(null); 
		heatMapControls.setBounds(13,80,200,20); 
		heatMapControls.setForeground(getColor1());
		controlPanel.add(heatMapControls);
		
		heatMapTimePanel = new JPanel(); 
		heatMapTimePanel.setLayout(null);
		heatMapTimePanel.setBounds(13, 105, 330, 120);
		heatMapTimePanel.setBackground(color4);
		heatMapTimePanel.setVisible(true);
		controlPanel.add(heatMapTimePanel);
		
	
		heatMapDefaultRange = new JButton("Default Range");
		heatMapDefaultRange.setBounds(5, 5, 160, 30);
		heatMapDefaultRange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startYearHeatMap = 2005; 
				endYearHeatMap = 2019; 
				getTitleBackground().setText("Heat Map of # of services per Region over years");
				currentPanel.setVisible(false);
				chart = createChart(createDataset(2005, 2019), startYearHeatMap, endYearHeatMap, a , b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);
			}

		});
		heatMapTimePanel.add(heatMapDefaultRange);
		heatMapButtonsList.add(heatMapDefaultRange); 
		
		HeatMap0510 = new JButton("2005 - 2010");
		HeatMap0510.setBounds(5, 5+27, 160, 30);
		HeatMap0510.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearHeatMap = 2005;
				endYearHeatMap = 2010;

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapTimePanel.add(HeatMap0510);
		heatMapButtonsList.add(HeatMap0510);
		
		HeatMap1015 = new JButton("2010 - 2015");
		HeatMap1015.setBounds(5, 5+27+27, 160, 30);
		HeatMap1015.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearHeatMap = 2010;
				endYearHeatMap = 2015;

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapTimePanel.add(HeatMap1015);
		heatMapButtonsList.add(HeatMap1015);
		
		HeatMap1519 = new JButton("2015 - 2019");
		HeatMap1519.setBounds(5, 5+27+27+27, 160, 30);
		HeatMap1519.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearHeatMap = 2015;
				endYearHeatMap = 2019;

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapTimePanel.add(HeatMap1519);
		heatMapButtonsList.add(HeatMap1519);
		
		customYearHeatMap = new JButton("Custom Year");
		customYearHeatMap.setBounds(5+160, 6, 160, 109);
		customYearHeatMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearHeatMap = askStartYear();
				endYearHeatMap = askEndYear(startYearHeatMap);

				System.out.println(startYearHeatMap); 
				System.out.println(endYearHeatMap);
				
				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapTimePanel.add(customYearHeatMap);
		heatMapButtonsList.add(customYearHeatMap);
		
		heatMapColourPanel = new JPanel(); 
		heatMapColourPanel.setLayout(null);
		heatMapColourPanel.setBounds(13+340, 105, 215, 120);
		heatMapColourPanel.setBackground(color4);
		heatMapColourPanel.setVisible(true);
		controlPanel.add(heatMapColourPanel);
		
		pinkHeatMap = new JButton("Pink");
		pinkHeatMap.setBounds(5, 5, 100, 55);
		pinkHeatMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				a = 255; 
				b = 255; 

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapColourPanel.add(pinkHeatMap);
		heatMapButtonsList.add(pinkHeatMap);
		
		greenHeatMap = new JButton("Green");
		greenHeatMap.setBounds(5, 5+55, 100, 55);
		greenHeatMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				a = 100; 
				b = 100; 

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapColourPanel.add(greenHeatMap);
		heatMapButtonsList.add(greenHeatMap);
		
		tealHeatMap = new JButton("Teal");
		tealHeatMap.setBounds(5+100, 5, 100, 38);
		tealHeatMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				a = 100; 
				b = 200; 

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapColourPanel.add(tealHeatMap);
		heatMapButtonsList.add(tealHeatMap);
		
		blueHeatMap = new JButton("Blue");
		blueHeatMap.setBounds(5+100, 5+36, 100, 38);
		blueHeatMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				a = 100; 
				b = 255; 

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapColourPanel.add(blueHeatMap);
		heatMapButtonsList.add(blueHeatMap);
		
		yellowHeatMap = new JButton("Yellow");
		yellowHeatMap.setBounds(5+100, 5+36+36, 100, 38);
		yellowHeatMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				a = 255; 
				b = 100; 

				currentPanel.setVisible(false);
				chart = createChart(createDataset(startYearHeatMap, endYearHeatMap), startYearHeatMap, endYearHeatMap, a, b); // data
				heatMapPanel = new ChartPanel(chart);
				heatMapPanel.setLayout(null);
				heatMapPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = heatMapPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		heatMapColourPanel.add(yellowHeatMap);
		heatMapButtonsList.add(yellowHeatMap);
		
		
		/*
		 pink: a=255, b = 255
		 Green: a = 100; b = 100
		 Teal: a=100; b = 200 
		 Blue: a = 100; b = 255 
		 Yellow: a = 255, b = 100 (Default) 
		 
		 */
		
		heatMapAnalysisPanel = new JPanel(); 
		heatMapAnalysisPanel.setLayout(null);
		heatMapAnalysisPanel.setBounds(13+340+225, 105, 320, 120);
		heatMapAnalysisPanel.setBackground(color4);
		heatMapAnalysisPanel.setVisible(true);
		controlPanel.add(heatMapAnalysisPanel);
		
		heatMapAnalysis = new JButton("Get Analysis");
		heatMapAnalysis.setBounds(5,5,310,110);
		heatMapAnalysis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				getScrollPane().setViewportView(heatMapAnalysisText);
				getInfoPanel().add(getScrollPane()); 
				
			}

		});
		heatMapAnalysisPanel.add(heatMapAnalysis);
		heatMapButtonsList.add(heatMapAnalysis);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Time series controls 
		JLabel timeSeriesControls = new JLabel("Time Series Controls"); 
		timeSeriesControls.setLayout(null); 
		timeSeriesControls.setBounds(13,230,200,20); 
		timeSeriesControls.setForeground(getColor1());
		controlPanel.add(timeSeriesControls); 
		
		timeSeriesTimePanel = new JPanel(); 
		timeSeriesTimePanel.setLayout(null);
		timeSeriesTimePanel.setBounds(13, 255, 330, 120);
		timeSeriesTimePanel.setBackground(color4);
		timeSeriesTimePanel.setVisible(true);
		controlPanel.add(timeSeriesTimePanel);
		
		timeSeriesDefaultRange = new JButton("Default Range");
		timeSeriesDefaultRange.setBounds(5, 5, 160, 30);
		timeSeriesDefaultRange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearTimeSeries = 2005;
				endYearTimeSeries = 2019;

				// TODO fix, thisonly works once

				currentPanel.setVisible(false);
				chart = createChart(createDataset(2005, 2019), 2005, 2019, a, b); // data
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesTimePanel.add(timeSeriesDefaultRange); 
		timeSeriesButtonsList.add(timeSeriesDefaultRange);
		
		
		Time0510 = new JButton("2005-2010");
		Time0510.setBounds(5, 5+27, 160, 30);
		Time0510.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearTimeSeries = 2005;
				endYearTimeSeries = 2010;

				// TODO fix, thisonly works once

				currentPanel.setVisible(false);
				chart = createChart(createDataset(2005, 2019), 2005, 2019, a, b); // data
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesTimePanel.add(Time0510);
		timeSeriesButtonsList.add(Time0510);
		

		Time1015 = new JButton("2010-2015");
		Time1015.setBounds(5, 5+27+27, 160, 30);
		Time1015.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearTimeSeries = 2010;
				endYearTimeSeries = 2015;

				// TODO fix, thisonly works once

				currentPanel.setVisible(false);
				chart = createChart(createDataset(2005, 2019), 2005, 2019, a, b); // data
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesTimePanel.add(Time1015); 
		timeSeriesButtonsList.add(Time1015);
		
		Time1519 = new JButton("2015-2019");
		Time1519.setBounds(5, 5+27+27+27, 160, 30);
		Time1519.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearTimeSeries = 2015;
				endYearTimeSeries = 2019;

				// TODO fix, thisonly works once

				currentPanel.setVisible(false);
				chart = createChart(createDataset(2005, 2019), 2005, 2019,a, b); // data
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesTimePanel.add(Time1519); 
		timeSeriesButtonsList.add(Time1519);
		
		customYearsTime = new JButton("Custom Year");
		customYearsTime.setBounds(5+160, 5, 160, 55);
		customYearsTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				startYearTimeSeries = askStartYear();
				endYearTimeSeries = askEndYear(startYearTimeSeries);

				// TODO fix, thisonly works once

				currentPanel.setVisible(false);
				chart = createChart(createDataset(2005, 2019), 2005, 2019, a, b); // data
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesTimePanel.add(customYearsTime); 
		timeSeriesButtonsList.add(customYearsTime);
		

		switchRegion = new JButton("Switch Regions");
		switchRegion.setBounds(5+160, 5+55, 160, 55);
		switchRegion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				
				chart = createChart(createDataset(2005, 2019), 2005, 2019, a, b); // data

				Region region = (Region) JOptionPane.showInputDialog(null,
						"Select a region", "Switch Regions", JOptionPane.QUESTION_MESSAGE, null,
						GeoFileImportController.regionList, GeoFileImportController.regionList[0]);

				

				currentRegion = region;
				
				if(!(currentRegion == null)) {
					timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
					timeSeriesPanel.setLayout(null);
					timeSeriesPanel.setBounds(40, 170, 900, 800);
					// add chart to frame and make frame visible
					currentPanel.setVisible(false);
					currentPanel = timeSeriesPanel;
					add(currentPanel);
					currentPanel.setVisible(true);

				}
				
			
			}

		});
		timeSeriesTimePanel.add(switchRegion); 
		timeSeriesButtonsList.add(switchRegion);
		
		timeSeriesLinePanel = new JPanel(); 
		timeSeriesLinePanel.setLayout(null);
		timeSeriesLinePanel.setBounds(13+340, 255, 330, 120);
		timeSeriesLinePanel.setBackground(color4);
		timeSeriesLinePanel.setVisible(true);
		controlPanel.add(timeSeriesLinePanel);


		allLines = new JButton("All Lines");
		allLines.setBounds(5, 5, 160, 26);
		allLines.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentTimeSeriesFilter = 0; 
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel.setVisible(false);
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesLinePanel.add(allLines); 
		timeSeriesButtonsList.add(allLines);
		
		allServices = new JButton("All Services");
		allServices.setBounds(5, 5+27, 160, 26);
		allServices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentTimeSeriesFilter = 1; 
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel.setVisible(false);
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesLinePanel.add(allServices); 
		timeSeriesButtonsList.add(allServices);
		
		youthServices = new JButton("Youth Services");
		youthServices.setBounds(5, 5+27+27, 160, 26);
		youthServices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentTimeSeriesFilter = 3; 
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel.setVisible(false);
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesLinePanel.add(youthServices);
		timeSeriesButtonsList.add(youthServices);
		
		freeServices = new JButton("Free Services");
		freeServices.setBounds(5, 5+27+27+27, 160, 26);
		freeServices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentTimeSeriesFilter = 2; 
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel.setVisible(false);
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesLinePanel.add(freeServices);
		timeSeriesButtonsList.add(freeServices);
		
	
		
		
		dropInServices = new JButton("Drop-In Services");
		dropInServices.setBounds(5+160, 5, 160, 38);
		dropInServices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentTimeSeriesFilter = 4; 
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel.setVisible(false);
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesLinePanel.add(dropInServices); 
		timeSeriesButtonsList.add(dropInServices);
		
		lgbtServices = new JButton("LGBTQ2S+ Services");
		lgbtServices.setBounds(5+160, 5+36, 160, 38);
		lgbtServices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentTimeSeriesFilter = 5; 
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel.setVisible(false);
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesLinePanel.add(lgbtServices); 
		timeSeriesButtonsList.add(lgbtServices);
		
		
		
		aboServices = new JButton("Aboriginal Services");
		aboServices.setBounds(5+160, 5+36+36, 160, 38);
		aboServices.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				currentTimeSeriesFilter = 6; 
				timeSeriesPanel = new ChartPanel(createTimeSeries(currentRegion, startYearTimeSeries, endYearTimeSeries, currentTimeSeriesFilter));
				timeSeriesPanel.setLayout(null);
				timeSeriesPanel.setBounds(40, 170, 900, 800);
				// add chart to frame and make frame visible
				currentPanel.setVisible(false);
				currentPanel = timeSeriesPanel;
				add(currentPanel);
				currentPanel.setVisible(true);

			}

		});
		timeSeriesLinePanel.add(aboServices); 
		timeSeriesButtonsList.add(aboServices);
		

		timeSeriesAnalysisPanel = new JPanel(); 
		timeSeriesAnalysisPanel.setLayout(null);
		timeSeriesAnalysisPanel.setBounds(13+340+340, 255, 205, 120);
		timeSeriesAnalysisPanel.setBackground(color4);
		timeSeriesAnalysisPanel.setVisible(true);
		controlPanel.add(timeSeriesAnalysisPanel);

		
		timeSeriesAnalysis = new JButton("Get Analysis");
		timeSeriesAnalysis.setBounds(5, 5, 195, 110);
		timeSeriesAnalysis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				getScrollPane().setViewportView(timeSeriesAnalysisText);
				getInfoPanel().add(getScrollPane());

			}

		});
		timeSeriesAnalysisPanel.add(timeSeriesAnalysis);
		timeSeriesButtonsList.add(timeSeriesAnalysis);
		


		heatMapAnalysisText = new JTextArea(
				"This heat map provides valuable insights into the distribution of mental"
				+ "\nhealth services across different regions in Ontario over time. The "
				+ "\nfollowing are some aspects to take note of. \n\n"
				+ "\nGreater Toronto Area (GTA), Southwest, and Hamilton, Halton, Brant Regions: "
				+ "\nThese regions have a higher concentration of mental health services due to "
				+ "\nseveral factors. This is a result of the fact that these areas are more densely "
				+ "\npopulated, which may result in a higher demand for services. Additionally, urban "
				+ "\nareas often have better infrastructure and resources, including healthcare facilities "
				+ "\nand funding, making it easier to establish and maintain mental health services. "
				+ "\nThe presence of universities, research institutions, and medical centers in these"
				+ "\nregions may also contribute to the availability of specialized mental health services.\n\n"
				+ "\nThe Sault Ste. Marie and Algoma, Niagara, and Muskoka, Parry Sound & Algonquin Park"
				+ "\nregions have relatively fewer mental health services available. There could "
				+ "\nbe several reasons for this disparity. These regions have lower population densities, "
				+ "\nresulting in lower demand for mental health services. Additionally, rural or remote areas "
				+ "\noften face challenges in terms of limited resources, healthcare infrastructure, and "
				+ "\ndifficulty attracting and retaining mental health professionals. Geographic barriers, such "
				+ "\nas distance and transportation, may also play a role in the limited availability of "
				+ "\nservices in these regions.\n\n"
				+ "\nBy changing the range settings of the heat map, we can get a better understanding of "
				+ "\nhow the number of mental health services across regions in Ontario changes overtime. "
				+ "\nThe heat map shows a steady increase which could be attributed to various factors. Growing "
				+ "\nawareness and recognition of mental health issues, combined with efforts to reduce stigma, "
				+ "\nhave led to increased demand for services. As a result, healthcare providers and organizations "
				+ "\nhave expanded their mental health offerings. Government initiatives, funding allocations, and "
				+ "\npolicies aimed at improving mental health services may have also contributed to this growth.\n\n\n"
				+ "\nMoving forward with mental health services in Ontario, the heat map provides insights to guide "
				+ "\ndecision-making. Key takeaways include:\n"
				+ "\nAddressing Disparities: The heat map highlights regions with limited mental health services,"
				+ "\nparticularly in rural and remote areas. Moving forward, efforts should focus on bridging the "
				+ "\ngap and ensuring equitable access to services across all regions of Ontario.\n"
				+ "\nResource Allocation: The areas with a higher concentration of mental health services, such as the "
				+ "\nGTA and Southwest, may benefit from continued resource allocation to meet the growing demand. This "
				+ "\ncould involve expanding existing services, improving infrastructure, and increasing funding for mental "
				+ "\nhealth programs.\n"
				+ "\nTargeted Interventions: The heat map can inform the development of targeted interventions and "
				+ "\nstrategies tailored to specific regions. For example, areas with lower service availability may require"
				+ "\ninitiatives to attract mental health professionals, improve transportation options, and implement "
				+ "\ntelehealth services to overcome geographic barriers.\n"
				+ "\nLong-term Planning: Monitoring the heat map over time can help policymakers and healthcare providers "
				+ "\nidentify trends, assess the effectiveness of interventions, and make informed decisions for long-term "
				+ "\nplanning of mental health services.\n"
				+ "\nIn summary, the heat map analysis provides valuable insights into the distribution of mental health "
				+ "\nservices in Ontario, allowing for targeted interventions and informed decision-making to improve "
				+ "\naccess and address disparities in mental health care across the province." 
		);
		//heatMapAnalysisText.setBackground(new Color(234, 195, 184));
		//heatMapAnalysisText.setFont(new Font("Monospaced", Font.PLAIN, 14));
		heatMapAnalysisText.setEditable(false);
		heatMapAnalysisText.setBackground(getColor1());
		heatMapAnalysisText.setForeground(color4);
	
		
		timeSeriesAnalysisText = new JTextArea(
				"The time series charts provide insights into the trends and patterns of mental health services in Ontario "
				+ "\nover time. Here are some key points to take note of:\n"
				+ "\n"
				+ "Gradual Increase in Aboriginal and LGBTQ2S+ Focused Services: The "
				+ "\ntime series charts show a gradual increase in the number of mental health services focused on "
				+ "\nthe Aboriginal and LGBTQ2S+ communities. This indicates a growing recognition of the unique mental "
				+ "\nhealth needs of these communities and efforts to address them. The increase might be attributed to "
				+ "\nfactors such as advocacy, increased awareness, and targeted funding for specific populations. However, "
				+ "\nthe slow pace of growth could be influenced by several factors, including limited resources, challenges "
				+ "\nin recruiting specialized professionals, and the need for community engagement and cultural sensitivity in "
				+ "\nservice delivery.\n"
				+ "\n"
				+ "Huge Increase between 2014 and 2016 in Mental Health Services: The time series charts demonstrate a "
				+ "\nsignificant increase in mental health services across all regions in Ontario between 2014 and 2016. This "
				+ "\ncould be a result of various factors, including increased funding for mental health initiatives, policy "
				+ "\nchanges, and heightened public awareness of mental health issues. It may also indicate a shift in societal "
				+ "\nattitudes towards mental health, reduced stigma, and a greater emphasis on early intervention and preventive care.\n"
				+ "\n"
				+ "\n"
				+ "Moving forward, the time series charts provide valuable insights for the planning and improvement of mental "
				+ "\nhealth services in Ontario. Here's what we can learn:\n"
				+ "\n"
				+ "Targeted Approach: The increase in Aboriginal and LGBTQ2S+ focused mental health services signifies"
				+ "\n the importance of tailored and culturally sensitive care. Moving forward, it is crucial "
				+ "\nto continue addressing the unique needs of these communities through increased funding, training for professionals, "
				+ "\nand community engagement.\n"
				+ "\n"
				+ "Resource Allocation: The significant increase in mental health services between 2014 and 2016 indicates the "
				+ "\nneed for continued investment in mental health initiatives. This includes allocating resources to meet the "
				+ "\ngrowing demand, expanding service capacity, and ensuring adequate staffing and infrastructure.\n"
				+ "\n"
				+ "Monitoring Trends: By closely monitoring the time series charts, policymakers and healthcare providers can "
				+ "\nidentify ongoing trends and patterns. This information can guide decision-making, including the identification"
				+ "\nof emerging needs, evaluating the impact of interventions, and adapting services to address evolving mental "
				+ "\nhealth challenges.\n"
				+ "\n"
				+ "In summary, the time series charts offer valuable insights into the gradual increase in Aboriginal and LGBTQ2S+ "
				+ "\nfocused mental health services, the significant growth in services between 2014 and 2016, and other trends"
				+ "\nand patterns. These insights inform the need for targeted approaches, resource allocation, and ongoing monitoring"
				+ "\nto improve mental health services in Ontario."
		); 
		timeSeriesAnalysisText.setEditable(false);
		timeSeriesAnalysisText.setBackground(getColor1());
		timeSeriesAnalysisText.setForeground(color4);
		enableControlButtons(null); 


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static Color getColor2() {
		return color2;
	}
















	public static void setColor2(Color color2) {
		GeoPanel.color2 = color2;
	}
















	public static Color getColor3() {
		return color3;
	}
















	public static void setColor3(Color color3) {
		GeoPanel.color3 = color3;
	}
















	public static Color getColor4() {
		return color4;
	}
















	public static void setColor4(Color color4) {
		GeoPanel.color4 = color4;
	}
















	public static void enableControlButtons(ArrayList<JButton> currentControls){
		
		for(JButton mapButton : mapButtonsList) {
			mapButton.setEnabled(false); 
		}
		
		for(JButton heatMapButton : heatMapButtonsList) {
			heatMapButton.setEnabled(false); 
		}
		
		for(JButton timeSeriesButton : timeSeriesButtonsList) {
			timeSeriesButton.setEnabled(false); 
		}
		if(currentControls != null) {
			for(JButton currentButton : currentControls) {
				currentButton.setEnabled(true);
			}
		}
		
		
		
	}
	
	
	
	
	// HEATMAP

	public static int askStartYear() {
		int startYear = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter Start Year"));
		if (startYear < 2005 || startYear > 2019) {
			JOptionPane.showMessageDialog(DataMiningFrameController.getGeographicalFrame(),
					"Data Unavailable for years prior to 2005 or after 2019");
			return askStartYear(); 
		}
		return startYear;
	}

	public static int askEndYear(int startYear) {
		int endYear = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter End Year"));
		if (endYear < 2005 || endYear > 2019) {
			JOptionPane.showMessageDialog(DataMiningFrameController.getGeographicalFrame(),
					"Data Unavailable for years prior to 2005 or after 2019");
			return askEndYear(startYear);
		}else if(endYear < startYear) {
			JOptionPane.showMessageDialog(DataMiningFrameController.getGeographicalFrame(),
					"End year must be greater than start year");
			return askEndYear(startYear);
		}
		return endYear;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	private static JFreeChart createTimeSeries(Region currentRegion, int startYear, int endYear, int filter) {

		CategoryDataset dataset = createTimeDataSet(currentRegion, startYear, endYear, filter);

		JFreeChart chart = ChartFactory.createLineChart(currentRegion.getName(), // Chart Title
				"year", "number of facilities", dataset, PlotOrientation.VERTICAL, true, true, false);
		chart.setBackgroundPaint(Color.white);
		
		
		
		
		CategoryPlot plot = chart.getCategoryPlot();
		CategoryAxis axis = plot.getDomainAxis();

        CategoryPlot p = chart.getCategoryPlot(); 
         ValueAxis axis2 = p.getRangeAxis();

   

        LegendTitle legend = new LegendTitle(plot.getRenderer());

        plot.getDomainAxis().setLabelFont(font1);
        plot.getRangeAxis().setLabelFont(font1);
        chart.getTitle().setFont(font2); 
       // plot.getTitle().setLabelFont(font2); 
        plot.setBackgroundPaint(new GradientPaint(0, 0, getColor1(), 200,200, color4, false));
        
      
        
        
//		chart.getXYPlot().setBackgroundPaint(new GradientPaint(0, 0, Color.cyan, 200,200, Color.red, false));
//		chart.getXYPlot().setBackgroundAlpha(0.5f); 
	
		return chart;

	}

	public static CategoryDataset createTimeDataSet(Region currentRegion, int startYear, int endYear, int filter) {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// int[] yValues = new int[50];
		int[] years = new int[(endYear - startYear) + 1];
		for (int i = 0; i < years.length; i++) {
			years[i] = startYear + i;
		}

		int valueCounter = 0;
		int feeCounter = 0;
		int youthCounter = 0; 
		int dropInCounter = 0; 
		int lgbtCounter = 0; 
		int aboriginalCounter = 0; 
		
		
		
		for (int year : years) {
			for (GeoService currentService : GeoFileImportController.geoServices) {
				if (currentService.getRegion().equals(currentRegion) && currentService.getOpenedOn().getYear() < year) {
					valueCounter++;
					if (currentService.getFeeStructure().contains("Free")) {
						feeCounter++;
					}
					if (currentService.getEligibility().contains("Youth") && currentService.getEligibility().contains("Child")) {
						youthCounter++;
					}
					if (currentService.getScheduleAppt().contains("rop-in")) {
						dropInCounter++;
					}
					if (currentService.getEligibility().contains("LGBT")) {
						lgbtCounter++;
					}
					if (currentService.getEligibility().contains("Aboriginal")) {
						aboriginalCounter++;
					}
				}

			}
			if(filter == 0) { //ALL 
				dataset.addValue(valueCounter, "All Services", year + " ");
				dataset.addValue(feeCounter, "Free Services", year + " ");
				dataset.addValue(youthCounter, "Youth Services", year + " ");
				dataset.addValue(dropInCounter, "Drop-In Services", year + " ");
				dataset.addValue(lgbtCounter, "LGBTQ2S+ Services", year + " ");
				dataset.addValue(aboriginalCounter, "Aboriginal Services", year + " ");
				valueCounter = 0;
				feeCounter = 0;
				youthCounter = 0; 
				dropInCounter = 0; 
				lgbtCounter = 0; 
				aboriginalCounter = 0; 
			}else if(filter == 1) { //All services only 
				dataset.addValue(valueCounter, "All Services", year + " ");
				valueCounter = 0;
			}else if(filter == 2) { //Free Services only 
				dataset.addValue(feeCounter, "Free Services", year + " ");
				feeCounter = 0;
			}else if(filter == 3) { //Youth Services only 
				dataset.addValue(youthCounter, "Youth Services", year + " ");
				youthCounter = 0;
			}else if(filter == 4) { //Drop-in Services only 
				dataset.addValue(dropInCounter, "Drop-In Services", year + " ");
				dropInCounter = 0;
			}else if(filter == 5) { //lgbt Services only 
				dataset.addValue(lgbtCounter, "LGBTQ2S+ Services", year + " ");
				lgbtCounter = 0;
			}else if(filter == 6) { //Aboriginal Services only 
				dataset.addValue(lgbtCounter, "Aboriginal Services", year + " ");
				aboriginalCounter = 0;
			}
			
			
			
		}

		return dataset;
		
	}

	
	private static JFreeChart createChart(XYZDataset dataset, int startYear, int endYear, int aColour, int bColour) {


		String[] labelsx = new String[GeoFileImportController.regionList.length];
		int k = 0;
		for (Region curReg : GeoFileImportController.regionList) {
			labelsx[k] = curReg.getName();
			k++;
		}

		SymbolAxis xAxis = new SymbolAxis("Geographical Regions of Ontario", labelsx);
		xAxis.setTickUnit(new NumberTickUnit(1));

		// visible y-axis with symbols (Displays the years within the data range
		// 2005-2019)
		String labels[] = new String[(endYear + 1) - startYear];
		for (int i = startYear; i < endYear + 1; i++)
			labels[i - startYear] = " " + i;
		SymbolAxis yAxis = new SymbolAxis("Year", labels);
		yAxis.setTickUnit(new NumberTickUnit(1));

		// another invisible y-axis for scaling
		// (this is not necessary if your y-values are suitable)
		NumberAxis valueAxis1 = new NumberAxis("Marker");
		valueAxis1.setLowerMargin(0);
		valueAxis1.setUpperMargin(0);
		valueAxis1.setVisible(false);

		// create a paint-scale and a legend showing it
		LookupPaintScale paintScale = new LookupPaintScale(0, 600, Color.black);
		int x =255;
		
		
		a = aColour; 
		b = bColour; 
		/*
		 pink: a=255, b = 255
		 Green: a = 100; b = 100
		 Teal: a=100; b = 200 
		 Blue: a = 100; b = 255 
		 Yellow: a = 255, b = 100 (Default) 
		 
		 */
		Color c = new Color(255, x, 255); // White
		paintScale.add(0.0, c);
		paintScale.add(5.0, c = new Color(a, x - 5, b));
		paintScale.add(10.0, c = new Color(a, x - 10, b));
		paintScale.add(15.0, c = new Color(a, x - 15, b));
		paintScale.add(20.0, c = new Color(a, x - 20, b));
		paintScale.add(40.0, c = new Color(a, x - 25, b));
		paintScale.add(60.0, c = new Color(a, x - 30, b));
		paintScale.add(80.0, c = new Color(a, x - 35, b));
		paintScale.add(100.0, c = new Color(a, x - 40, b));
		paintScale.add(120.0, c = new Color(a, x - 45, b));
		paintScale.add(140.0, c = new Color(a, x - 50, b));
		paintScale.add(160.0, c = new Color(a, x - 55, b));
		paintScale.add(180.0, c = new Color(a, x - 60, b));
		paintScale.add(200.0, c = new Color(a, x - 65, b));
		paintScale.add(220.0, c = new Color(a, x - 70, b));
		paintScale.add(240.0, c = new Color(a, x - 75, b));
		paintScale.add(280.0, c = new Color(a, x - 80, b));
		paintScale.add(300.0, c = new Color(a, x - 85, b));
		paintScale.add(320.0, c = new Color(a, x - 90, b));
		paintScale.add(340.0, c = new Color(a, x - 95, b));
		paintScale.add(360.0, c = new Color(a, x - 100, b));
		paintScale.add(380.0, c = new Color(a, x - 105, b));
		paintScale.add(400.0, c = new Color(a, x - 115, b));
		paintScale.add(440.0, c = new Color(a, x - 130, b));
		paintScale.add(460.0, c = new Color(a, x - 145, b));
		paintScale.add(480.0, c = new Color(a, x - 160, b));
		paintScale.add(500.0, c = new Color(a, x - 175, b));
		paintScale.add(520.0, c = new Color(a, x - 200, b));
		paintScale.add(540.0, c = new Color(a, x - 215, b));
		paintScale.add(560.0, c = new Color(a, x - 230, b));
		paintScale.add(580.0, c = new Color(a, x - 245, b));
		paintScale.add(600.0, c = new Color(a, x - 250, b));

		//External Code 
		PaintScaleLegend psl = new PaintScaleLegend(paintScale, new NumberAxis());
		psl.setPosition(RectangleEdge.RIGHT);
		psl.setAxisLocation(AxisLocation.TOP_OR_RIGHT);
		psl.setMargin(50.0, 20.0, 80.0, 0.0);


		XYPlot plot = new XYPlot(dataset, xAxis, yAxis, new XYBlockRenderer());
		((XYBlockRenderer) plot.getRenderer()).setPaintScale(paintScale);

		plot.setRangeAxis(1, valueAxis1);
		plot.mapDatasetToRangeAxis(0, 1);

		JFreeChart chart = new JFreeChart(null, null, plot, false);
		chart.addSubtitle(psl);
		return chart;
	}

	public XYZDataset createDataset(int startYear, int endYear) {

		double[] xvalues = new double[GeoFileImportController.regionList.length * ((endYear + 1) - startYear)];
		double[] yvalues = new double[GeoFileImportController.regionList.length * ((endYear + 1) - startYear)];
		double[] zvalues = new double[GeoFileImportController.regionList.length * ((endYear + 1) - startYear)];

		int xindex = 0;
		for (int i = 0; i < GeoFileImportController.regionList.length; i++) {
			for (int j = 0; j < (endYear + 1) - startYear; j++) {
				xvalues[xindex] = (double) i;
				xindex++;
			}
		}

		int yindex = 0;
		for (int i = 0; i < GeoFileImportController.regionList.length; i++) {
			for (int j = 0; j < (endYear + 1) - startYear; j++) {
				yvalues[yindex] = (double) j;
				yindex++;
			}
		}

		int zindex = 0;
		int value = 0;
		for (int i = 0; i < GeoFileImportController.regionList.length; i++) {
			for (int j = 0; j < (endYear + 1) - startYear; j++) {
				Region currentRegion = GeoFileImportController.regionList[i];
				int year = j + startYear;

				for (GeoService service : GeoFileImportController.geoServices) {
					if (service.getRegion().equals(currentRegion) && service.getOpenedOn().getYear() <= year) {
						value++;
					}
				}

				zvalues[zindex] = value;
				value = 0;
				zindex++;
			}
		}


		DefaultXYZDataset dataset = new DefaultXYZDataset();
		dataset.addSeries("Just one Series", new double[][] { xvalues, yvalues, zvalues });
		return dataset;
	}

	

	// Set alignment & Colouring
	public static void initializeRegionLabel(JLabel regionLabel) {
		regionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		regionLabel.setOpaque(true);
		regionLabel.setForeground(Color.white);
		regionLabel.setBackground(Color.BLACK);
	}

	public static JLabel getTitleBackground() {
		return titleBackground;
	}

	public void setTitleBackground(JLabel titleBackground) {
		this.titleBackground = titleBackground;
	}



















	public static JButton getSearch() {
		return search;
	}






	public void setSearch(JButton search) {
		this.search = search;
	}
















	public static JScrollPane getScrollPane() {
		return scrollPane;
	}
















	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
















	public static JPanel getInfoPanel() {
		return infoPanel;
	}
















	public void setInfoPanel(JPanel infoPanel) {
		this.infoPanel = infoPanel;
	}
















	public static JScrollPane getScrollPaneReco() {
		return scrollPaneReco;
	}
















	public static void setScrollPaneReco(JScrollPane scrollPaneReco) {
		GeoPanel.scrollPaneReco = scrollPaneReco;
	}
















	public static GeoRecommendationPanel getGeoRecoPanel() {
		return geoRecoPanel;
	}
















	public void setGeoRecoPanel(GeoRecommendationPanel geoRecoPanel) {
		this.geoRecoPanel = geoRecoPanel;
	}
















	public static Color getColor1() {
		return color1;
	}
















	public static void setColor1(Color color1) {
		GeoPanel.color1 = color1;
	}

}
