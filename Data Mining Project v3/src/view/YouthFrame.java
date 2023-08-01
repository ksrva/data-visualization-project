//Jeffrey


package view;

//imports
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

import controller.DataMiningFrameController;
import controller.YouthController;
import model.CSVReader;


public class YouthFrame extends JFrame {

	private JComboBox comboBox;
	private YouthController controller;
	private ChartPanel chartPanel;
	private JPanel bottomRightPanel;
	private JTable information;

	public static final String header[] = { "PublicName", "ParentAgency", "ParentAgencyNum", "PhysicalAddress",
			"PhoneNumberBusinessLine", "WebsiteAddress", "MainContactName", "MainContactTitle",
			"MainContactEmailAddress", "MainContactPhoneNumber" };

	public YouthFrame() {
		// frame
		setTitle("Youth Distribution Frame");

		setSize(1920, 1080);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(DataMiningFrameController.createMenuBar());

		// setJMenuBar(DataMiningFrameController.createMenuBar());
		controller = new YouthController(this);

		// TODO Add components

		setVisible(true);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Create the chart
		panel.setLayout(new BorderLayout());
		
		// create drop down list
		String[] locations = { "Central", "Eastern", "Western", "Northern" };

		JPanel panelR = new JPanel();

		panelR.setLayout(null);
		panelR.setPreferredSize(new Dimension(950, 1080));
		panelR.setBackground(Color.PINK);
		comboBox = new JComboBox<>(locations);
		panelR.add(comboBox);
		comboBox.setBounds(0, 50, 200, 50);
		comboBox.addActionListener(controller);

		// create information of places through table
		information = new JTable(new Object[header.length][], header) {

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		// allow for scrolling
		JScrollPane sp = new JScrollPane(information);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setBounds(0, 200, 900, 400);

		information.setFillsViewportHeight(true);
	

		panelR.add(sp);

		// panelR.setBackground(Color.BLACK);

		chartPanel = new ChartPanel(null);
		chartPanel.setPreferredSize(new Dimension(900, 1080));

		// Add the chart to the frame
		panel.add(chartPanel, BorderLayout.WEST);
		panel.add(panelR, BorderLayout.EAST);
		panel.setBackground(Color.PINK);
		// panel.setLocation(20, 30);

		setContentPane(panel);

		controller.actionPerformed(null);
	}

	//getters and setters
	public JTable getInformation() {
		return information;
	}

	public void setInformation(JTable information) {
		this.information = information;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public ChartPanel getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}

}