//Jeffrey

package controller;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import model.CSVReader;
import model.ServicesDetails;
import view.YouthFrame;

public class YouthController implements ActionListener {

	// create datasets
	private HashMap<String, CategoryDataset> datasets = new HashMap<>();
	private HashMap<String, ArrayList<ServicesDetails>> detailsList = new HashMap<>();

	public YouthFrame frame;

	// constructor
	public YouthController(YouthFrame frame) {
		this.frame = frame;

		createDatasets();
	}

	private void createDatasets() {

		// create regions
		String[] regions = { "Central", "Northern", "Western", "Eastern" };

		// looop through all regions
		for (String regionName : regions) {
			detailsList.putIfAbsent(regionName, new ArrayList<>());

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			// access files
			CSVReader reader = new CSVReader("files/" + regionName.toLowerCase() + ".csv");

			// export data to dataset
			ArrayList<String[]> rows = reader.getParsedData();
			for (String[] row : rows) {
				dataset.addValue((Number) Integer.parseInt(row[2]), regionName + " Region", Integer.parseInt(row[0]));
			}

			CSVReader reader1 = new CSVReader("files/" + regionName.toLowerCase() + "Services.csv");
			ArrayList<String[]> info = reader1.getParsedData();
			for (String[] element : info) {

				String name = element[0];

				String parentAgency = element[1];

				String parentAgencyNum = element[2];

				String address = element[3];

				String phoneNumber = element[4];

				String website = element[5];

				String contactName = element[6] == "" ? "N/A" : element[6];

				String contactTitle = element[7] == "" ? "N/A" : element[7];

				String email = element[8] == "" ? "N/A" : element[8];

				String contactNumber = element[9] == "" ? "N/A" : element[9];

				ServicesDetails details = new ServicesDetails(name, parentAgency, parentAgencyNum, address, phoneNumber,
						website, contactName, contactTitle, email, contactNumber);

				detailsList.get(regionName).add(details);

			}

			datasets.put(regionName, dataset);
		}
	}

	// button to access data depending on region
	@Override
	public void actionPerformed(ActionEvent e) {

		String region = (String) frame.getComboBox().getSelectedItem();

		JFreeChart chart = ChartFactory.createLineChart("Region - # of MHS provided", "Fiscal Year", "# of MHS",
				datasets.get(region), PlotOrientation.VERTICAL, true, true, false);

		frame.getChartPanel().setChart(chart);

		frame.getInformation()
				.setModel(new DefaultTableModel(
						detailsList.get(region).stream().map(ServicesDetails::toObjectArray).toArray(Object[][]::new),
						YouthFrame.header));

	}
}