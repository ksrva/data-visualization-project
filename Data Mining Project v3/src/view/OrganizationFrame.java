//Name: Krrish Lalit 
//Date: May 15 2023 
//Course: ICS4U1
//Description: This class is suppose to tell you about the different organizations that support the mental health
//people who suffer from mental health issues. 

package view;

// Imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

// GUI imports
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.CSVReader;

// Project imports

import controller.DataMiningFrameController;

@SuppressWarnings("unused")
public class OrganizationFrame extends JFrame implements ActionListener {

	// Log to console
	public final boolean LOG_CSV_TO_CONSOLE = true;

	// JButtons
	public JButton quizButton = new JButton("Take the Quiz");

	// JLabels for titles
	public JLabel titleLabel = new JLabel("Organization Data");
	public JLabel titleLabel2 = new JLabel("More Information");
	public JLabel subtitleLabel = new JLabel("Mental Health Cases by Organization");

	// JPanels
	public JPanel leftPanel = new JPanel();
	public JPanel rightPanel = new JPanel();
	public JPanel graphBox = new JPanel();

	// Bar colors
	public Color[] barColors = { Color.RED, Color.YELLOW, Color.BLUE };

	// Label for graph key
	public JLabel graphKey = new JLabel("<html><br>&nbsp;&nbsp;&nbsp;&nbsp;Legend:<br>"
			+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;RED = Total number of children/youth"
			+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;YELLOW = Number of children/youth who completed any form of CHYMH"
			+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;BLUE = Number of children admitted for mental health problems");

	// Axis labels
	public JLabel xAxisLabel = new JLabel("Geographical Area");
	public JLabel yAxisLabel = new JLabel("# of Children/Youth");

	// CSV data
	public ArrayList<String[]> csvData;

	// Other data for graph
	public String[] xAxisValues;

	// JTextField
	public JLabel text = new JLabel(
			"<html><center>Mental health refers to a person's overall psychological well-being, including their emotional, cognitive, and social functioning. It encompasses a broad range of factors that influence an individual's mental state, such as thoughts, emotions, behaviors, and social interactions."
					+ "If you know someone who is experiencing poor mental health, there are several ways you can offer support and assistance. Here are some suggestions:"
					+ "<br><br>- Be understanding and non-judgmental: Approach the person with empathy, listening without judgment and showing understanding for their feelings and experiences. Avoid dismissing or trivializing their struggles."
					+ "<br><br>- Encourage open communication: Create a safe and supportive environment for them to express their feelings and concerns. Let them know that you are there to listen and offer assistance if needed."
					+ "<br><br>- Educate yourself: Learn about their specific mental health condition to better understand what they might be going through.<br><br>This knowledge can help you provide appropriate support and resources."
					+ "<center></html>");

	// Constructor Method
	public OrganizationFrame() {

		// Setting the size of the frame
		setSize(1920, 1080);
		setLayout(null);
		setResizable(true);
		setBackground(GeoPanel.getColor3());
		setJMenuBar(DataMiningFrameController.createMenuBar());

		// Set window title
		setTitle("Organization Data");

		// Left panel
		leftPanel.setBounds(-1, -1, 1201, 1082);
		leftPanel.setBackground(GeoPanel.getColor3());
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		leftPanel.setLayout(null);
		add(leftPanel);

		// Right panel
		rightPanel.setBounds(1199, -1, 720, 1082);
		rightPanel.setBackground(GeoPanel.getColor2());
		rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rightPanel.setLayout(null);
		add(rightPanel);

		// Left side title
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel.setBounds(150, 100, 950, 50);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(titleLabel);

		// Right side title
		titleLabel2.setFont(new Font("Arial", Font.BOLD, 30));
		titleLabel2.setBounds(50, 100, 620, 50);
		titleLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		rightPanel.add(titleLabel2);

		// Information text
		text.setBounds(50, 150, 620, 500);
		text.setBackground(GeoPanel.getColor1());
		text.setFont(new Font("Verdana", Font.BOLD, 14));
		rightPanel.add(text);

		// Quiz button
		quizButton.setFont(new Font("Arial", Font.PLAIN, 20));
		quizButton.setBounds(50, 750, 620, 50);
		quizButton.addActionListener(this);
		quizButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rightPanel.add(quizButton);

		// Graph box
		graphBox.setBounds(150, 250, 950, 600);
		graphBox.setBackground(Color.LIGHT_GRAY);
		graphBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		graphBox.setLayout(null);
		leftPanel.add(graphBox);

		// Graph key
		graphKey.setBounds(50, 50, 650, 180);
		graphKey.setOpaque(true);
		graphKey.setBackground(new Color(220, 220, 220));
		graphKey.setFont(new Font("Verdana", Font.BOLD, 14));
		graphKey.setBackground(GeoPanel.getColor4());
		graphKey.setForeground(Color.white);
		graphKey.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		graphBox.add(graphKey);

		// Graph axis labels
		xAxisLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		xAxisLabel.setBounds(500, 900, 250, 50);
		xAxisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(xAxisLabel);

		yAxisLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		yAxisLabel.setBounds(40, 150, 250, 50);
		yAxisLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftPanel.add(yAxisLabel);

		// Frame visibilty
		setVisible(true);

		// Draw graph
		loadGraph();

	}

	// Utility methods

	// Add a bar to the graph
	public void drawBar(int left, int top, int width, int height, Color bk, String tooltip) {

		// Create a JPanel as the bar
		JPanel bar = new JPanel();
		bar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bar.setBounds(left, top, width, height);
		bar.setBackground(bk);
		bar.setToolTipText(tooltip);
		graphBox.add(bar);
		bar.repaint();

	}

	// Add a label beside the graph
	public void drawLabel(int left, int top, int width, String textString) {

		// Create a JPanel as the bar
		JLabel text = new JLabel(textString);
		text.setBounds(left, top, width, 30);
		text.setHorizontalAlignment(SwingConstants.RIGHT);
		text.setFont(new Font("Arial", Font.PLAIN, 16));
		leftPanel.add(text);
		text.repaint();

	}

	// Draw the graph itself
	public void drawGraph() {

		// Create y axis labels
		for (int y = 0; y < 11; y++) {

			drawLabel(80, 834 - (60 * y), 50, Integer.toString(y * 2000));

		}

		// Loop through rows
		for (int row = 1; row < csvData.size(); row++) {

			// Current row
			String[] currentRow = csvData.get(row);

			// Create x axis labels (exclude first row)
			drawLabel(-30 + row * 150, 860, 150, currentRow[0]);

			// Calculate total number of children/youth
			int[] totalCategories = new int[3];
			Arrays.fill(totalCategories, 0);
			int entryIndex = 0;
			for (String entry : currentRow) {

				int value = 0;
				if (entryIndex != 0 && !entry.equals("X")) {
					value = Integer.parseInt(entry);
				}

				totalCategories[0] += value;
				if (entryIndex == 2 || entryIndex == 3 || entryIndex == 16 || entryIndex == 17 || entryIndex == 18
						|| entryIndex == 19 || entryIndex == 20) {
					totalCategories[1] += value;
				} else if (entryIndex == 5 || entryIndex == 6 || entryIndex == 7 || entryIndex == 8 || entryIndex == 9
						|| entryIndex == 11) {
					totalCategories[2] += value;
				}

				entryIndex++;

			}

			// Draw bars to show data
			int[] barHeights = new int[3];
			for (int i = 0; i < 3; i++) {

				int currentValue = totalCategories[i];
				barHeights[i] = (int) Math.round(currentValue * 0.03);
				drawBar(-80 + i * 20 + row * 150, 600 - barHeights[i], 21, barHeights[i], barColors[i],
						Integer.toString(currentValue));

			}

		}

	}

	// Initialize graph by loading data
	public void loadGraph() {

		try {

			// Attempt to read and store CSV file into ArrayList
			CSVReader parser = new CSVReader("files/organizationData.csv", LOG_CSV_TO_CONSOLE);
			csvData = parser.getParsedData();

			int numberOfRows = csvData.size() - 1;
			xAxisValues = new String[numberOfRows];

			drawGraph();

		} catch (Exception e) {

			// Failed to read...
			JOptionPane.showMessageDialog(this,
					"Data could not be loaded...\n\nPlease check that files/organizationData.csv exists.");

		}

	}

	// This method makes the buttons function
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == quizButton) {

			// Switch to quiz frame
			new QuizFrame();
			setVisible(false);

		}
	}
}