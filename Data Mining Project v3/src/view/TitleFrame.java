/*
 
 Title/Welcome Frame, first to pop-up when user runs application 
 
 */

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import controller.DataMiningFrameController;

public class TitleFrame extends JFrame {

	Color color = new Color(182, 250, 189);

	// Constructor
	public TitleFrame() {

		// Frame
		setTitle("Title Screen");
		setLayout(null);
		setSize(1920, 1080);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(DataMiningFrameController.createMenuBar());

		
		
		
		
		
		// TODO Add components

		Container c = getContentPane();
		// Creating JPanel for the JFrame
		JPanel panel = new JPanel();
		// setting the panel layout to null
		panel.setLayout(null);

		// Background Label - For Image
		JLabel backgroundLabel = new JLabel(new ImageIcon("images/Logo.png"));
         
		// Set Bounds - background Label
		backgroundLabel.setBounds(440, 300, 500, 500);
		backgroundLabel.setOpaque(true);
		add(backgroundLabel);

		// adding label title to the panel
		JLabel welcome = new JLabel("Welcome!");
		welcome.setFont(new Font("Verdana", 1, 20));
		// set height of JPanel
		welcome.setBounds(600, 1, 100000, 120);
		panel.add(welcome);

		JLabel text = new JLabel("<html><center> At SKKJ, our mission is to revolutionize the distribution of  "
				+ "<br>mental health services by leveraging cutting-edge technology. <br>"
				+ "By analyzing various factors such as geographical location, <br> "
				+ "demographic data, and individual needs, we aim to create  <br>"
				+ "a personalized and inclsusive ecosystem  that connects individuals <br>"
				+ "with the most appropriate mental health resources.<center> </html>");

		// text.setHorizontalAlignment(SwingConstants.CENTER);
		// text.setVerticalAlignment(SwingConstants.TOP);
		panel.setLayout(null);
		text.setBounds(460, 150, 700, 150);
		panel.add(text, BorderLayout.CENTER);
		text.setFont(new Font("Verdana", Font.BOLD, 12));

		// change background colour
		panel.setBackground(GeoPanel.getColor2());
		panel.setBounds(0, 0, 1920, 1080);

		// adding the panel to the Container of the JFrame
		c.add(panel);

		setVisible(true);
	}
}