//
// Title:			Age Distribution Frame
// Author:			Sidharth Shenoy
// Version:			1.6.5 (FINAL VERSION)
// Date:			May 28, 2023
// Description:		A frame for displaying facts, information, data, and interactive activities related to mental health, more specifically by age.
// Usage:			new AgeDistributionFrame()
//

package view;

//System

// Import modules
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.DataMiningFrameController;

@SuppressWarnings("serial")
// AgeDistributionFrame class
public class AgeDistributionFrame extends JFrame implements ActionListener {

	// Fields for icons, colours, cursors, borders, and fonts
	private final ImageIcon IMAGEICON_LOGO = new ImageIcon("images/circleIcon.png");
	private final Image IMAGE_LOGO = IMAGEICON_LOGO.getImage();
	private final Color MAIN_BKCOLOR = new Color(240, 180, 50);
	private final Color INFO_BKCOLOR = new Color(130, 115, 151);
	private final Cursor HAND_CURSOR = new Cursor(Cursor.HAND_CURSOR);
	private final Cursor CROSSHAIR_CURSOR = new Cursor(Cursor.CROSSHAIR_CURSOR);
	private final Cursor TEXT_CURSOR = new Cursor(Cursor.TEXT_CURSOR);
	private final Border DEFAULT_BORDER = new LineBorder(Color.GRAY);
	private final Font HUGE_FONT = new Font("Arial", Font.BOLD, 48);
	private final Font TITLE_FONT = new Font("Arial", Font.BOLD, 36);
	private final Font SUBTITLE_FONT = new Font("Arial", Font.BOLD, 24);
	private final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 18);
	private final Font LINK_FONT = new Font("Arial", Font.ITALIC, 14);
	private final Font NORMAL_FONT = new Font("Arial", Font.PLAIN, 16);
	private final Font AXIS_FONT = new Font("Arial", Font.ITALIC, 16);

	// Fields for value constants
	private final Rectangle[] BTN_BIG_POSITIONS = new Rectangle[4];
	private final Rectangle[] BTN_SMALL_POSITIONS = new Rectangle[4];
	private final String WINDOW_TITLE = "Ontario Mental Health - Age Demographics";
	private final String[] tabButtonText = { "Graph", "Quiz", "Age Slider", "Self Test" };
	private final String[] tabButtonTooltips = { "View the graph", "Take the quiz", "Interactive age slider",
			"Evaluate your mental health" };
	private final String SOURCE_SHEET = "https://docs.google.com/spreadsheets/d/1rvYHJjSAKWUjcv9MJfJN-3tDGitghMj3x5cJtBQ7h7I/edit?usp=sharing";
	private final String[] QUIZ_QUESTIONS = {
			"Approximately what fraction of adolescents have a mental health disorder?",
			"An extremely severe mental health problem resulting in confusion with reality is known as:",
			"Which of the following activities can boost your mental health over a longer duration?",
			"The global depression rate peaked during:",
			"Which of the following mental health conditions is the most common?",
			"On average, one mental health professional is available for every ___ individuals in need.",
			"What is mental health stigma?", "Depression and anxiety impact the global economy by a loss of:",
			"One person dies by suicide approximately every ___ seconds.",
			"Approximately what percentage of Americans had a mental health condition in 2020?" };
	private final String[][] QUIZ_OPTIONS = { { "1/3", "1/7", "1/45", "1/250" },
			{ "instability crisis", "chronic insanity", "psychosis", "a panic attack" },
			{ "Drinking alcoholic beverages", "Taking antidepressants", "Taking a nap",
					"Developing healthy relationships" },
			{ "World War I", "World War II", "The 21st century", "The Great Depression" },
			{ "Anxiety", "Bipolar disorder", "Depression", "PTSD" }, { "6", "28", "350", "475" },
			{ "The brain gradually losing its ability to make decisions with confidence.",
					"A medication that temporarity numbs the brain.",
					"Being discouraged from mental health counseling.",
					"A baseless set of beliefs/stereotypes faced by people with mental health issues." },
			{ "$1 trillion", "$1.5 trillion", "$2.384 trillion", "$3.2 trillion" }, { "12", "40", "60", "210" },
			{ "4%", "17%", "21%", "28%", } };
	private final int[] QUIZ_CORRECT_ANSWERS = { 1, 2, 3, 2, 0, 2, 3, 0, 1, 2 };
	private final String[] QUIZ_ANSWERFEEDBACK = { "It's more common than it may seem.",
			"This dangerous condition often results in hallucinations.", "Pretty obvious... right?",
			"Technology couldn't possibly be a factor... could it?", "We've all felt anxious at times.",
			"This career seems to be growing in demand!", "It's nothing to be ashamed of.",
			"That's around $125 per person!", "Pretty sad... right?", "That's one in every five people!" };
	private final String[] QUIZ_FEEDBACK = { "Better luck next time...", // 0 to 2 points
			"You probably made a few lucky guesses...", // 3 to 4 points
			"Not bad, but still room for improvement...", // 5 to 7 points
			"Well played!\n\nYou seem to have good knowledge on mental health.", // 8 to 9 points
			"Congratulations! You obtained a perfect score!\n\nBe sure to share the knowledge with others..." // 10
																												// points
	};
	private final String[][] WEB_LINK_TEXT = {
			{ "Our World in Data | Mental Health", "Google Images | Mental Health Graphs",
					"Hopkins Medicine | Mental Health Stats" },
			{ "CNN | Depression Rate Poll", "Fact Retriever | Mental Health Facts",
					"VeryWellHealth | Mental Health Information" },
			{ "Mental Health Comission | Children/Youth", "CAMH | Mental Health Statistics",
					"WHO | Adolescent Mental Health" },
			{ "MedlinePlus | Improve Mental Health", "Canada | Improving Mental Health",
					"MHA National | Boost Mental Health" } };
	private final String[][] WEB_LINKS = { { "https://ourworldindata.org/mental-health",
			"https://www.google.ca/search?q=mental+health+graphs&source=lnms&tbm=isch",
			"https://www.hopkinsmedicine.org/health/wellness-and-prevention/mental-health-disorder-statistics" },
			{ "https://www.cnn.com/2023/05/17/health/depression-rates-gallup/index.html",
					"https://www.factretriever.com/mental-health-facts",
					"https://www.verywellhealth.com/mental-health-facts-and-statistics-what-you-need-to-know-5323772" },
			{ "https://mentalhealthcommission.ca/what-we-do/children-and-youth/",
					"https://www.camh.ca/en/driving-change/the-crisis-is-real/mental-health-statistics",
					"https://www.who.int/news-room/fact-sheets/detail/adolescent-mental-health" },
			{ "https://medlineplus.gov/howtoimprovementalhealth.html",
					"https://www.canada.ca/en/public-health/topics/improving-your-mental-health.html",
					"https://www.mhanational.org/31-tips-boost-your-mental-health" } };
	private final String[] LEARN_MORE_INFO = {
			"The condition of your psychological and emotional well-being is known as your mental health. It is an important asset for leading a healthy life and contributes significantly to the overall health of a person. Mental health is different from mental illness. However, mental illness and physical sickness are often caused by poor mental health.\n\n"
					+ "You can be content with your life if you have good mental health, as it allows you to consistently feel positive emotions. Day-to day experiences, relationships, job or school environments, physical health, and the type of place you reside in can all have a positive or negative impact on your mental health.\n\n"
					+ "The first step to taking care of your mental health is often simply acknowledging that life can be difficult. By accepting that you and others will experience both positive and negative emotions, learning to accept yourself and others, setting realistic goals for yourself, developing healthy relationships, and participating in activities that give your life meaning, you can boost your general level of satisfaction.\n\n"
					+ "Overall, having a healthy mind can boost coping mechanisms, self-worth, and resiliency, while improving one's ability to focus and achieve more in life.",
			"This quiz is an opportunity for you to test your general knowledge about mental health and wellness. Having a better understanting of this topic makes us less susceptiple to passing judgments about others.\n\n"
					+ "You will be asked ten multiple-choice questions about the impacts of and key terms regarding mental health. Each question only has one correct answer. You can retake the quiz as many times as you wish.",
			"Like many illnesses, mental health conditions affect people regardless of their age or gender. However, these factors may vary slightly depending on the type of illness. You can never be too young or old to worry about your mental health.\n\n"
					+ "You can use the interactive age slider to view mental health statistics, predictions, and insights for your age group. All values are interpolated based on a massive medical dataset of mental health cases.\n\n"
					+ "Research has proven that young adults (ages 20 to 30) are the most vulnerable age group in terms of mental health concerns. Although boys are marginally more likely to develop drug addiction problems, girls have a slightly higher likelihood of developing eating disorders. However, there is no perfect combination of gender and age when it comes to this matter.\n\n"
					+ "Still, it is essential to understand that age is only a single factor. By following the tips mentioned in the provided links, you can improve your general level of contentment.",
			"By filling out the following quiz, you can get a glimpse of your overall mental health as well as ways in which it can be improved.\n\n"
					+ "People are often surprised by mental health tests, as they realize that there is a lot of room for improvement. For the most accurate results, be sure to answer each question immediately after reading it. Waiting too long may cause you to change your mind; the first thought is almost always the most accurate.\n\n"
					+ "Keep in mind that the results produced by this tool are merely predictions. You can talk to your doctor or call a hotline if you are worried about your mental health." };
	private final String[] TEST_QUESTIONS = { "I feel motivated to get out of bed every morning.",
			"I am surrounded by people who care about my well-being.",
			"I am almost never concerned about what others think of me.",
			"I feel satisfied with myself before going to bed every night.",
			"Others would describe me as a positive person.",
			"I have enough spare time to pursue my hobbies and interests.",
			"I feel a general sense of freedom in my day-to-day activities.", "I rarely dwell on the past.",
			"I rarely worry about the future.", "I generally feel good about myself as a person." };
	private final String[] TEST_OPTIONS = { "STRONGLY AGREE (+10%)", "AGREE (+7%)", "NEUTRAL (+5%)", "DISAGREE (+2%)",
			"STRONGLY DISAGREE (+0%)" };
	private final String[] TEST_FEEDBACK = { "Be sure to spread the positive energy to those around you!",
			"Pretty good, but stress is a part of life, right?", "Not the best, but not the worst either...",
			"To be honest with you, that's pretty alarming.",
			"You should probably seek help from a mental health professional." };

	// Fields for CSV data storage
	private final String DATA_FILE_NAME = "files/casesByAge.csv";
	private ArrayList<String[]> parsedData;
	private int[] treatedCasesByAge = new int[101];
	private int[] untreatedCasesByAge = new int[101];

	// Fields for menu
	private JMenuBar menuBar = new JMenuBar();
	private JMenu homeMenu = new JMenu("Home");
	private JMenu helpMenu = new JMenu("Help");
	private JMenu otherMenu = new JMenu("Other Frames");
	private JMenuItem[] homeMenuItems = new JMenuItem[2];
	private JMenuItem[] helpMenuItems = new JMenuItem[1];
	private JMenuItem[] otherMenuItems = new JMenuItem[3];

	// Fields for main and information sections of display
	private JPanel mainSection = new JPanel();
	private JPanel infoSection = new JPanel();

	// Fields for main section
	private JLabel iconLabel = new JLabel(IMAGEICON_LOGO);
	private JLabel mainTitle = new JLabel(WINDOW_TITLE);
	private JPanel mainSectionDisplay = new JPanel();
	private JButton[] tabButtons = new JButton[4];
	private JPanel[] tabPanels = new JPanel[4];

	// Fields for information section
	private JLabel infoTitle1 = new JLabel("More Info");
	private JLabel infoTitle2 = new JLabel("Related Links");
	private JPanel infoTextCont1 = new JPanel();
	private JPanel infoTextCont2 = new JPanel();
	private JTextArea infoTextArea1 = new JTextArea();
	private JTextArea infoTextArea2 = new JTextArea();
	private JButton[] linkButtons = new JButton[3];

	// Fields for first panel (JFreeChart)
	private JLabel chartTitle = new JLabel("Mental Health - Distribution by Age");
	private JPanel graphPanel = new JPanel();
	private JLabel xAxisLabel = new JLabel("Age (years)");
	private JLabel yAxisLabel = new JLabel("Cases per 1000");
	private JLabel treatedLabel = new JLabel(" = Treated cases");
	private JLabel untreatedLabel = new JLabel(" = Untreated cases");
	private JSlider xAxisValues = new JSlider();
	private JSlider yAxisValues = new JSlider(JSlider.VERTICAL);
	private JLabel sourceLabel = new JLabel("Source: ");
	private JButton sourceLink = new JButton(SOURCE_SHEET);

	// Fields for second panel (quiz)
	private JLabel quizTitle = new JLabel("Mental Health Quiz");
	private JLabel questionLabel = new JLabel("Click the \"START QUIZ\" button to begin!");
	private JButton quizStartButton = new JButton("START QUIZ!");
	private JButton[] optionButtons = new JButton[4];
	private JLabel quizNumLabel = new JLabel("Question: ---");
	private JLabel quizScoreLabel = new JLabel("Score: ---");
	private int quizScore = 0;
	private int quizQuestionIndex = -1; // Quiz has not yet been started

	// Fields for third panel (age slider)
	private JLabel ageTitle = new JLabel("Interactive Age Slider - Mental Health Cases by Age");
	private JLabel ageLabel = new JLabel("...");
	private JLabel ageDescriptionLabel = new JLabel("Per 1000 recorded cases:");
	private JLabel ageLimitLabel = new JLabel("* No data for ages 6 and under");
	private JLabel ageTotalLabel = new JLabel("...");
	private JLabel ageTreatedLabel = new JLabel("...");
	private JLabel ageUntreatedLabel = new JLabel("...");
	private JProgressBar ageTotalMeter = new JProgressBar();
	private JProgressBar ageTreatedMeter = new JProgressBar();
	private JProgressBar ageUntreatedMeter = new JProgressBar();
	private JSlider ageSlider = new JSlider();

	// Fields for fourth panel (self test)
	private JLabel selfTestTitle = new JLabel("Mental Health Self Test");
	private JLabel questionLabel2 = new JLabel("Click the \"START TEST\" button to begin!");
	private JButton quizStartButton2 = new JButton("START TEST!");
	private JButton[] optionButtons2 = new JButton[5];
	private JLabel quizNumLabel2 = new JLabel("Question: ---");
	private JLabel quizScoreLabel2 = new JLabel("Score: ---");
	private int quizScore2 = 0;
	private int quizQuestionIndex2 = -1; // Self test has not yet been started

	// Index of current tab displayed
	private int currentTab = 0;

	//CSVReader
	
	// Constructor
	public AgeDistributionFrame() {

		// Setup window properties
		setTitle(WINDOW_TITLE);
		setSize(1920, 1080);
		setResizable(false);
		setIconImage(IMAGE_LOGO);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Read in and store data from CSV
		readDataFile(true);

		// Create and add options to home menu
		homeMenuItems[0] = new JMenuItem("Return to Graph");
		homeMenuItems[0].addActionListener(this);
		homeMenuItems[1] = new JMenuItem("Exit Frame");
		homeMenuItems[1].addActionListener(this);

		for (JMenuItem currentItem : homeMenuItems) {
			homeMenu.add(currentItem);
		}

		// Create and add options to help menu
		helpMenuItems[0] = new JMenuItem("Directions");
		helpMenuItems[0].addActionListener(this);

		for (JMenuItem currentItem2 : helpMenuItems) {
			helpMenu.add(currentItem2);
		}

		// Create and add options to other frames menu
		otherMenuItems[0] = new JMenuItem("Switch to 1");
		otherMenuItems[0].addActionListener(this);
		otherMenuItems[1] = new JMenuItem("Switch to 2");
		otherMenuItems[1].addActionListener(this);
		otherMenuItems[2] = new JMenuItem("Switch to 3");
		otherMenuItems[2].addActionListener(this);

		for (JMenuItem currentItem3 : otherMenuItems) {
			otherMenu.add(currentItem3);
		}

		// Add all menus to main menu
		menuBar.add(homeMenu);
		menuBar.add(helpMenu);

		// Add the menu bar
		setJMenuBar(DataMiningFrameController.createMenuBar());
		menuBar.setVisible(true);

		// Add the main section panel
		mainSection.setBounds(0, 0, 1521, 1080);
		mainSection.setBackground(MAIN_BKCOLOR);
		mainSection.setBorder(DEFAULT_BORDER);
		mainSection.setVisible(true);
		mainSection.setLayout(null);
		add(mainSection);

		// Add the info section panel
		infoSection.setBounds(1520, 0, 400, 1080);
		infoSection.setBackground(INFO_BKCOLOR);
		infoSection.setBorder(DEFAULT_BORDER);
		infoSection.setVisible(true);
		infoSection.setLayout(null);
		add(infoSection);

		// Add the main section icon
		iconLabel.setBounds(50, 40, 64, 64);
		mainSection.add(iconLabel);

		// Add the main section title
		mainTitle.setBounds(150, 25, 1200, 100);
		mainTitle.setFont(TITLE_FONT);
		mainSection.add(mainTitle);

		// Add the main section display
		mainSectionDisplay.setBounds(50, 200, 1400, 750);
		mainSectionDisplay.setBorder(DEFAULT_BORDER);
		mainSectionDisplay.setLayout(null);
		mainSection.add(mainSectionDisplay);

		// Configure and add the tab buttons and tab panels
		for (int count = 0; count < 4; count++) {

			// Add current tab button
			BTN_BIG_POSITIONS[count] = new Rectangle(50 + (count * 350), 150, 350, 50);
			BTN_SMALL_POSITIONS[count] = new Rectangle(50 + (count * 350), 160, 350, 40);
			tabButtons[count] = new JButton(tabButtonText[count]);
			tabButtons[count].setToolTipText(tabButtonTooltips[count]);
			tabButtons[count].setBounds(BTN_BIG_POSITIONS[count]);
			tabButtons[count].setCursor(HAND_CURSOR);
			tabButtons[count].setBorder(DEFAULT_BORDER);
			tabButtons[count].setFont(BUTTON_FONT);
			tabButtons[count].addActionListener(this);
			mainSection.add(tabButtons[count]);

			// Add current tab panel
			tabPanels[count] = new JPanel();
			tabPanels[count].setBounds(0, 0, 1400, 750);
			tabPanels[count].setBackground(new Color(150 + (count * 25), 250, 250 - (count * 25)));
			tabPanels[count].setBorder(DEFAULT_BORDER);
			tabPanels[count].setLayout(null);
			mainSectionDisplay.add(tabPanels[count]);

		}

		// Setup the first panel (JFreeChart)
		chartTitle.setFont(SUBTITLE_FONT);
		chartTitle.setBounds(500, 100, 1000, 50);
		tabPanels[0].add(chartTitle);

		graphPanel.setBounds(200, 200, 1000, 400);
		graphPanel.setBorder(DEFAULT_BORDER);
		graphPanel.setCursor(CROSSHAIR_CURSOR);
		graphPanel.setToolTipText("Hover over the bars for exact values...");
		graphPanel.setLayout(null);
		tabPanels[0].add(graphPanel);

		xAxisLabel.setBounds(650, 650, 400, 50);
		xAxisLabel.setFont(AXIS_FONT);
		tabPanels[0].add(xAxisLabel);

		yAxisLabel.setBounds(25, 375, 400, 50);
		yAxisLabel.setFont(AXIS_FONT);
		tabPanels[0].add(yAxisLabel);

		xAxisValues.setMinimum(0);
		xAxisValues.setMaximum(100);
		xAxisValues.setMajorTickSpacing(10);
		xAxisValues.setMinorTickSpacing(1);
		xAxisValues.setPaintLabels(true);
		xAxisValues.setPaintTicks(true);
		xAxisValues.setBackground(new Color(150, 250, 250));
		xAxisValues.setBounds(200, 580, 1000, 50);
		xAxisValues.setValue(0);
		xAxisValues.setEnabled(false);
		tabPanels[0].add(xAxisValues);

		yAxisValues.setMinimum(0);
		yAxisValues.setMaximum(20);
		yAxisValues.setMajorTickSpacing(5);
		yAxisValues.setMinorTickSpacing(1);
		yAxisValues.setPaintLabels(true);
		yAxisValues.setPaintTicks(true);
		yAxisValues.setBackground(new Color(150, 250, 250));
		yAxisValues.setBounds(145, 200, 50, 400);
		yAxisValues.setValue(0);
		yAxisValues.setEnabled(false);
		tabPanels[0].add(yAxisValues);

		sourceLabel.setFont(LINK_FONT);
		sourceLabel.setBounds(10, 720, 60, 30);
		tabPanels[0].add(sourceLabel);

		sourceLink.setForeground(new Color(0, 0, 255));
		sourceLink.setFont(LINK_FONT);
		sourceLink.setBorderPainted(false);
		sourceLink.setBounds(70, 720, 800, 29);
		sourceLink.setCursor(HAND_CURSOR);
		sourceLink.setBackground(new Color(150, 250, 250));
		sourceLink.addActionListener(this);
		tabPanels[0].add(sourceLink);

		// Setup the second panel (quiz)
		quizTitle.setFont(SUBTITLE_FONT);
		quizTitle.setBounds(25, 10, 300, 50);
		tabPanels[1].add(quizTitle);

		questionLabel.setFont(SUBTITLE_FONT);
		questionLabel.setBounds(25, 100, 1350, 60);
		tabPanels[1].add(questionLabel);

		quizStartButton.setFont(SUBTITLE_FONT);
		quizStartButton.setBounds(500, 30, 400, 60);
		quizStartButton.setCursor(HAND_CURSOR);
		quizStartButton.setToolTipText("Start the quiz!");
		quizStartButton.addActionListener(this);
		tabPanels[1].add(quizStartButton);

		quizNumLabel.setFont(SUBTITLE_FONT);
		quizNumLabel.setBounds(1125, 10, 275, 40);
		tabPanels[1].add(quizNumLabel);

		quizScoreLabel.setFont(SUBTITLE_FONT);
		quizScoreLabel.setBounds(1125, 40, 275, 60);
		tabPanels[1].add(quizScoreLabel);

		// Add option buttons
		for (int count = 0; count < 4; count++) {
			optionButtons[count] = new JButton("---");
			optionButtons[count].setEnabled(false);
			optionButtons[count].setBounds(50, 200 + (count * 120), 1300, 120);
			optionButtons[count].setCursor(HAND_CURSOR);
			optionButtons[count].setFont(BUTTON_FONT);
			optionButtons[count].setFocusPainted(false);
			optionButtons[count].addActionListener(this);
			tabPanels[1].add(optionButtons[count]);
		}

		// Setup the third panel (age slider)
		ageTitle.setFont(SUBTITLE_FONT);
		ageTitle.setBounds(25, 10, 1000, 50);
		tabPanels[2].add(ageTitle);

		ageLabel.setFont(HUGE_FONT);
		ageLabel.setBounds(25, 100, 1000, 100);
		tabPanels[2].add(ageLabel);

		ageDescriptionLabel.setFont(SUBTITLE_FONT);
		ageDescriptionLabel.setBounds(25, 200, 1000, 100);
		tabPanels[2].add(ageDescriptionLabel);

		ageTotalLabel.setFont(SUBTITLE_FONT);
		ageTotalLabel.setBounds(50, 300, 1000, 100);
		tabPanels[2].add(ageTotalLabel);

		ageTreatedLabel.setFont(SUBTITLE_FONT);
		ageTreatedLabel.setBounds(50, 350, 1000, 100);
		tabPanels[2].add(ageTreatedLabel);

		ageUntreatedLabel.setFont(SUBTITLE_FONT);
		ageUntreatedLabel.setBounds(50, 400, 1000, 100);
		tabPanels[2].add(ageUntreatedLabel);

		ageLimitLabel.setFont(SUBTITLE_FONT);
		ageLimitLabel.setBounds(25, 500, 1000, 100);
		tabPanels[2].add(ageLimitLabel);

		ageTotalMeter.setBounds(355, 335, 1000, 30);
		ageTotalMeter.setMinimum(0);
		ageTotalMeter.setMaximum(50);
		ageTotalMeter.setValue(0);
		ageTotalMeter.setStringPainted(true);
		ageTotalMeter.setString("");
		ageTotalMeter.setForeground(new Color(200, 200, 0));
		tabPanels[2].add(ageTotalMeter);

		ageTreatedMeter.setBounds(355, 385, 1000, 30);
		ageTreatedMeter.setMinimum(0);
		ageTreatedMeter.setMaximum(50);
		ageTreatedMeter.setValue(0);
		ageTreatedMeter.setStringPainted(true);
		ageTreatedMeter.setString("");
		ageTreatedMeter.setForeground(new Color(0, 250, 0));
		tabPanels[2].add(ageTreatedMeter);

		ageUntreatedMeter.setBounds(355, 435, 1000, 30);
		ageUntreatedMeter.setMinimum(0);
		ageUntreatedMeter.setMaximum(50);
		ageUntreatedMeter.setValue(0);
		ageUntreatedMeter.setStringPainted(true);
		ageUntreatedMeter.setString("");
		ageUntreatedMeter.setForeground(new Color(250, 50, 50));
		tabPanels[2].add(ageUntreatedMeter);

		// Declare Change Listener for age slider
		ChangeListener sliderChanged = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				updateAgePanel();
			}
		};
		ageSlider.setMinimum(0);
		ageSlider.setMaximum(100);
		ageSlider.setMajorTickSpacing(5);
		ageSlider.setMinorTickSpacing(1);
		ageSlider.setPaintLabels(true);
		ageSlider.setPaintTicks(true);
		ageSlider.setBackground(new Color(200, 250, 200));
		ageSlider.setBounds(25, 675, 1350, 50);
		ageSlider.setCursor(HAND_CURSOR);
		ageSlider.setToolTipText("Slide the handle to select an age...");
		ageSlider.addChangeListener(sliderChanged);
		tabPanels[2].add(ageSlider);

		// Set initial value to 18 (ChangeListener automatically updates panel)
		ageSlider.setValue(18);

		// Setup the fourth panel (self test)
		selfTestTitle.setFont(SUBTITLE_FONT);
		selfTestTitle.setBounds(25, 10, 400, 50);
		tabPanels[3].add(selfTestTitle);

		questionLabel2.setFont(SUBTITLE_FONT);
		questionLabel2.setBounds(25, 100, 1350, 60);
		tabPanels[3].add(questionLabel2);

		quizStartButton2.setFont(SUBTITLE_FONT);
		quizStartButton2.setBounds(500, 30, 400, 60);
		quizStartButton2.setCursor(HAND_CURSOR);
		quizStartButton2.setToolTipText("Start the test!");
		quizStartButton2.addActionListener(this);
		tabPanels[3].add(quizStartButton2);

		quizNumLabel2.setFont(SUBTITLE_FONT);
		quizNumLabel2.setBounds(1125, 10, 275, 40);
		tabPanels[3].add(quizNumLabel2);

		quizScoreLabel2.setFont(SUBTITLE_FONT);
		quizScoreLabel2.setBounds(1125, 40, 275, 60);
		tabPanels[3].add(quizScoreLabel2);

		// Add option buttons
		for (int count = 0; count < 5; count++) {
			optionButtons2[count] = new JButton(TEST_OPTIONS[count]);
			optionButtons2[count].setEnabled(false);
			optionButtons2[count].setBounds(50, 200 + (count * 100), 1300, 100);
			optionButtons2[count].setCursor(HAND_CURSOR);
			optionButtons2[count].setFont(BUTTON_FONT);
			optionButtons2[count].setFocusPainted(false);
			optionButtons2[count].addActionListener(this);
			tabPanels[3].add(optionButtons2[count]);
		}

		// Add the information titles
		infoTitle1.setBounds(140, 0, 400, 100);
		infoTitle1.setFont(SUBTITLE_FONT);
		infoSection.add(infoTitle1);

		infoTitle2.setBounds(120, 740, 400, 100);
		infoTitle2.setFont(SUBTITLE_FONT);
		infoSection.add(infoTitle2);

		// Add the information text containers and boxes
		infoTextCont1.setBounds(25, 100, 340, 640);
		infoTextCont1.setBorder(DEFAULT_BORDER);
		infoTextCont1.setBackground(new Color(255, 255, 255));
		infoTextCont1.setCursor(TEXT_CURSOR);
		infoTextCont1.setLayout(null);
		infoSection.add(infoTextCont1);

		infoTextArea1.setBounds(10, 10, 320, 620);
		infoTextArea1.setFont(NORMAL_FONT);
		infoTextArea1.setEditable(false);
		infoTextArea1.setLineWrap(true);
		infoTextArea1.setWrapStyleWord(true);
		infoTextCont1.add(infoTextArea1);

		infoTextCont2.setBounds(25, 840, 340, 150);
		infoTextCont2.setBorder(DEFAULT_BORDER);
		infoTextCont2.setBackground(new Color(255, 255, 255));
		infoTextCont2.setLayout(null);
		infoSection.add(infoTextCont2);

		infoTextArea2.setBounds(10, 10, 320, 130);
		infoTextArea2.setFont(NORMAL_FONT);
		infoTextArea2.setEditable(false);
		infoTextArea2.setLineWrap(true);
		infoTextArea2.setWrapStyleWord(true);
		infoTextCont2.add(infoTextArea2);

		// Configure and add the link buttons
		for (int count = 0; count < 3; count++) {
			linkButtons[count] = new JButton(tabButtonText[count]);
			linkButtons[count].setBounds(10, 10 + (count * 40), 300, 30);
			linkButtons[count].setCursor(HAND_CURSOR);
			linkButtons[count].setBorder(DEFAULT_BORDER);
			linkButtons[count].setFont(LINK_FONT);
			linkButtons[count].setForeground(Color.BLUE);
			linkButtons[count].setBorderPainted(false);
			linkButtons[count].setBackground(Color.WHITE);
			linkButtons[count].addActionListener(this);
			infoTextArea2.add(linkButtons[count]);
		}

		// Show the window
		setVisible(true);

		// Fill the graph with data from the CSV file
		fillGraph();

		// Open first tab by default
		setCurrentTab(0);

	}

	// Utility methods
	private void readDataFile(boolean printToConsole) {

		try {

			// Attempt to read file from name
			Scanner inputFile = new Scanner(new File(DATA_FILE_NAME));

			// All values are separated by commas
			inputFile.useDelimiter(",");

			// Get the lines
			parsedData = new ArrayList<String[]>();
			String currentLine = "";
			while (inputFile.hasNext()) {
				currentLine = inputFile.nextLine();
				String[] entries = currentLine.split(",");
				parsedData.add(entries);
			}

			// Close input file
			inputFile.close();

		} catch (FileNotFoundException e) {

			// File was not found
			System.out.println("File not found: " + DATA_FILE_NAME);

		}

		// Print all values to the console
		if (printToConsole) {
			for (int count = 0; count < parsedData.size(); count++) {
				for (String index : parsedData.get(count)) {
					System.out.print(index + "\t");
				}
				System.out.print("\n");
			}
		}

	}

	private void addBarToGraph(int left, int top, int width, int height, Color color, String tooltip) {

		// Create and add a bar to the graph panel
		JPanel bar = new JPanel();
		bar.setBorder(DEFAULT_BORDER);
		bar.setBounds(left, top, width, height);
		bar.setBackground(color);
		bar.setToolTipText(tooltip);
		graphPanel.add(bar);

	}

	private void fillGraph() {

		// No initial values
		Arrays.fill(treatedCasesByAge, 0);
		Arrays.fill(untreatedCasesByAge, 0);

		// Loop through entries
		for (String[] entry : parsedData) {

			// Get data values
			int currentAge = Integer.parseInt(entry[2]);
			boolean treated = (entry[4].equals("TRUE"));

			// Add to graphing data
			if (currentAge <= 100) {
				if (treated) {
					treatedCasesByAge[currentAge]++;
				} else {
					untreatedCasesByAge[currentAge]++;
				}
			}

		}

		// Print data
		//System.out.println("Treated cases by age: " + Arrays.toString(treatedCasesByAge));
		//System.out.println("Untreated cases by age: " + Arrays.toString(untreatedCasesByAge));

		// Add bars to graph with tooltips
		int heightFactor = 20000 / parsedData.size();
		for (int count = 0; count < 100; count++) {
			String ageString = " (" + count + " years)";
			int treatedNum = treatedCasesByAge[count] * 1000 / parsedData.size();
			int untreatedNum = untreatedCasesByAge[count] * 1000 / parsedData.size();
			String toolTip1 = Integer.toString(treatedNum) + " treated case" + ((treatedNum != 1) ? "s" : "")
					+ ageString;
			String toolTip2 = Integer.toString(untreatedNum) + " untreated case" + ((untreatedNum != 1) ? "s" : "")
					+ ageString;
			addBarToGraph(count * 10, 395 - treatedCasesByAge[count] * heightFactor, 5,
					5 + treatedCasesByAge[count] * heightFactor, Color.GREEN, toolTip1);
			addBarToGraph(5 + count * 10, 395 - untreatedCasesByAge[count] * heightFactor, 5,
					5 + untreatedCasesByAge[count] * heightFactor, Color.RED, toolTip2);
		}

		// Add key labels to graph
		addBarToGraph(700, 50, 25, 25, Color.GREEN, "GREEN");
		addBarToGraph(700, 80, 25, 25, Color.RED, "RED");

		treatedLabel.setBounds(730, 50, 200, 25);
		treatedLabel.setFont(NORMAL_FONT);
		graphPanel.add(treatedLabel);
		untreatedLabel.setBounds(730, 80, 200, 25);
		untreatedLabel.setFont(NORMAL_FONT);
		graphPanel.add(untreatedLabel);
	}

	private void openLink(String urlString) {
		try {
			URL url = new URL(urlString.toString());
			URI uri = url.toURI();
			Desktop.getDesktop().browse(uri);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void nextQuestion(int answerGiven) {

		// Validate answer given (unless quiz was just started)
		if (answerGiven != -1) {
			int correctAnswerIndex = QUIZ_CORRECT_ANSWERS[quizQuestionIndex];
			if (answerGiven == correctAnswerIndex) {
				JOptionPane.showMessageDialog(this, "Correct (+1)!\n\n" + QUIZ_ANSWERFEEDBACK[quizQuestionIndex]);
				quizScore++;
			} else {
				JOptionPane.showMessageDialog(this,
						"Wrong...\n\nThe correct answer is:\n" + QUIZ_OPTIONS[quizQuestionIndex][correctAnswerIndex]
								+ "\n\n" + QUIZ_ANSWERFEEDBACK[quizQuestionIndex]);
			}
		} else {
			quizStartButton.setEnabled(false);
		}

		// Check whether quiz has ended
		if (quizQuestionIndex == 9) {

			// Announce result with feedback message
			int feedbackIndex;
			if (quizScore == 10) {
				feedbackIndex = 4;
			} else if (quizScore >= 8) {
				feedbackIndex = 3;
			} else if (quizScore >= 5) {
				feedbackIndex = 2;
			} else if (quizScore >= 3) {
				feedbackIndex = 1;
			} else {
				feedbackIndex = 0;
			}

			JOptionPane.showMessageDialog(this, "Your score is " + quizScore + "!\n\n" + QUIZ_FEEDBACK[feedbackIndex]);
			quizQuestionIndex = -1;
			quizScore = 0;
			questionLabel.setText("Click the button above for an opportunity to improve your score.");
			quizNumLabel.setText("Question: ---");
			quizStartButton.setText("RETRY QUIZ");
			for (int count = 0; count < 4; count++) {
				optionButtons[count].setEnabled(false);
				optionButtons[count].setText("---");
			}
			quizStartButton.setEnabled(true);

		} else {

			// Go to next question and update labels
			quizQuestionIndex++;
			quizNumLabel.setText("Question: " + (quizQuestionIndex + 1) + " of 10");

			// Display next question with answers
			questionLabel.setText((quizQuestionIndex + 1) + ") " + QUIZ_QUESTIONS[quizQuestionIndex]);
			for (int count = 0; count < 4; count++) {
				optionButtons[count].setEnabled(true);
				optionButtons[count].setText(QUIZ_OPTIONS[quizQuestionIndex][count]);
			}

		}

		// Update score label
		quizScoreLabel.setText("Score: " + Integer.toString(quizScore));

	}

	private void nextTestQuestion(int answerGiven) {

		// Add points based on answer
		if (answerGiven != -1) {

			if (answerGiven == 0) {
				quizScore2 += 10;
			} else if (answerGiven == 1) {
				quizScore2 += 7;
			} else if (answerGiven == 2) {
				quizScore2 += 5;
			} else if (answerGiven == 3) {
				quizScore2 += 2;
			} else {
				quizScore2 += 0;
			}

			// Disable all option buttons
			for (int count = 0; count < 5; count++) {
				optionButtons2[count].setEnabled(false);
				if (quizQuestionIndex2 == 9) {
					optionButtons2[count].setText("---");
				}
			}

		} else {

			quizStartButton2.setText("IN PROGRESS...");
			quizStartButton2.setEnabled(false);

		}

		// Check whether quiz has ended
		if (quizQuestionIndex2 == 9) {

			// Announce result with feedback message
			int feedbackIndex;
			if (quizScore2 >= 80) {
				feedbackIndex = 0;
			} else if (quizScore2 >= 60) {
				feedbackIndex = 1;
			} else if (quizScore2 >= 40) {
				feedbackIndex = 2;
			} else if (quizScore2 >= 20) {
				feedbackIndex = 3;
			} else {
				feedbackIndex = 4;
			}

			JOptionPane.showMessageDialog(this,
					"Your mental health score is " + quizScore2 + "%!\n\n" + TEST_FEEDBACK[feedbackIndex]);
			quizQuestionIndex2 = -1;
			questionLabel2.setText("Thank you for taking the self test.");
			quizNumLabel2.setText("Question: N/A");
			quizStartButton2.setText("TEST COMPLETE");
			quizStartButton2.setToolTipText("You cannot repeat the test...");
			quizStartButton2.setEnabled(false);

		} else {

			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {

					// Go to next question and update labels
					quizQuestionIndex2++;
					quizNumLabel2.setText("Question: " + (quizQuestionIndex2 + 1) + " of 10");

					// Display next question with answers
					questionLabel2.setText((quizQuestionIndex2 + 1) + ") " + TEST_QUESTIONS[quizQuestionIndex2]);
					for (int count = 0; count < 5; count++) {
						optionButtons2[count].setEnabled(true);
						optionButtons2[count].setText(TEST_OPTIONS[count]);
					}

				}
			}, 100);

		}

		// Update score label
		quizScoreLabel2.setText("Score: " + Integer.toString(quizScore2) + "%");

	}

	private void updateAgePanel() {

		// Get data for selected age
		int age = ageSlider.getValue();
		int totalCases = (int) ((treatedCasesByAge[age] + untreatedCasesByAge[age]) * 1000 / parsedData.size());
		int untreatedCases = (int) (untreatedCasesByAge[age] * 1000 / parsedData.size());
		int treatedCases = totalCases - untreatedCases;

		// Update labels and meters
		ageLabel.setText(Integer.toString(age) + " year" + ((age != 1) ? "s" : ""));
		ageTotalLabel.setText("Total cases by age: " + ((age >= 7) ? totalCases : "N/A"));
		ageTreatedLabel.setText("Treated cases: " + ((age >= 7) ? treatedCases : "N/A"));
		ageUntreatedLabel.setText("Untreated cases: " + ((age >= 7) ? untreatedCases : "N/A"));
		ageTotalMeter.setValue(totalCases);
		ageTreatedMeter.setValue(treatedCases);
		ageUntreatedMeter.setValue(untreatedCases);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Find out which component was clicked
		Object target = e.getSource();

		// Handle selection of menu options
		if (target.equals(homeMenuItems[0])) {

			// Return to graph
			setCurrentTab(0);

		} else if (target.equals(homeMenuItems[1])) {

			// Hide window
			this.setVisible(false);
			//this.dispose();

		} else if (target.equals(helpMenuItems[0])) {

			// Show instructions
			JOptionPane.showMessageDialog(this,
					"Use the tab buttons to switch between tabs.\n\nYou can view the right panel for more information on each topic.");

		};

		// Handle switching tabs by clicking buttons
		if (target.equals(tabButtons[0])) {
			// Show JFreeChart
			setCurrentTab(0);
		} else if (target.equals(tabButtons[1])) {
			// Show quiz panel
			setCurrentTab(1);
		} else if (target.equals(tabButtons[2])) {
			// Show age slider
			setCurrentTab(2);
			updateAgePanel();
		} else if (target.equals(tabButtons[3])) {
			// Show self test panel
			setCurrentTab(3);
		}

		// Handle source link for chart
		if (target.equals(sourceLink)) {
			openLink(SOURCE_SHEET);
		}

		// Handle quiz panel actions
		if (target.equals(quizStartButton)) {
			nextQuestion(-1);
		}
		for (int count = 0; count < 4; count++) {
			if (target.equals(optionButtons[count])) {
				nextQuestion(count);
				break;
			}
		}

		// Handle self test panel actions
		if (target.equals(quizStartButton2)) {
			nextTestQuestion(-1);
		}
		for (int count = 0; count < 5; count++) {
			if (target.equals(optionButtons2[count])) {
				nextTestQuestion(count);
				break;
			}
		}

		// Handle opening links by clicking buttons
		for (int count = 0; count < 3; count++) {
			if (target.equals(linkButtons[count])) {
				openLink(WEB_LINKS[currentTab][count]);
			}
		}

	}

	// Getters and setters
	public ArrayList<String[]> getParsedData() {
		return parsedData;
	}

	public void setParsedData(ArrayList<String[]> parsedData) {
		this.parsedData = parsedData;
	}

	public int[] getTreatedCasesByAge() {
		return treatedCasesByAge;
	}

	public void setTreatedCasesByAge(int[] treatedCasesByAge) {
		this.treatedCasesByAge = treatedCasesByAge;
	}

	public int[] getUntreatedCasesByAge() {
		return untreatedCasesByAge;
	}

	public void setUntreatedCasesByAge(int[] untreatedCasesByAge) {
		this.untreatedCasesByAge = untreatedCasesByAge;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getHomeMenu() {
		return homeMenu;
	}

	public void setHomeMenu(JMenu homeMenu) {
		this.homeMenu = homeMenu;
	}

	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public void setHelpMenu(JMenu helpMenu) {
		this.helpMenu = helpMenu;
	}

	public JMenu getOtherMenu() {
		return otherMenu;
	}

	public void setOtherMenu(JMenu otherMenu) {
		this.otherMenu = otherMenu;
	}

	public JMenuItem[] getHomeMenuItems() {
		return homeMenuItems;
	}

	public void setHomeMenuItems(JMenuItem[] homeMenuItems) {
		this.homeMenuItems = homeMenuItems;
	}

	public JMenuItem[] getHelpMenuItems() {
		return helpMenuItems;
	}

	public void setHelpMenuItems(JMenuItem[] helpMenuItems) {
		this.helpMenuItems = helpMenuItems;
	}

	public JMenuItem[] getOtherMenuItems() {
		return otherMenuItems;
	}

	public void setOtherMenuItems(JMenuItem[] otherMenuItems) {
		this.otherMenuItems = otherMenuItems;
	}

	public JPanel getMainSection() {
		return mainSection;
	}

	public void setMainSection(JPanel mainSection) {
		this.mainSection = mainSection;
	}

	public JPanel getInfoSection() {
		return infoSection;
	}

	public void setInfoSection(JPanel infoSection) {
		this.infoSection = infoSection;
	}

	public JLabel getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(JLabel iconLabel) {
		this.iconLabel = iconLabel;
	}

	public JLabel getMainTitle() {
		return mainTitle;
	}

	public void setMainTitle(JLabel mainTitle) {
		this.mainTitle = mainTitle;
	}

	public JPanel getMainSectionDisplay() {
		return mainSectionDisplay;
	}

	public void setMainSectionDisplay(JPanel mainSectionDisplay) {
		this.mainSectionDisplay = mainSectionDisplay;
	}

	public JButton[] getTabButtons() {
		return tabButtons;
	}

	public void setTabButtons(JButton[] tabButtons) {
		this.tabButtons = tabButtons;
	}

	public JPanel[] getTabPanels() {
		return tabPanels;
	}

	public void setTabPanels(JPanel[] tabPanels) {
		this.tabPanels = tabPanels;
	}

	public JLabel getInfoTitle1() {
		return infoTitle1;
	}

	public void setInfoTitle1(JLabel infoTitle1) {
		this.infoTitle1 = infoTitle1;
	}

	public JLabel getInfoTitle2() {
		return infoTitle2;
	}

	public void setInfoTitle2(JLabel infoTitle2) {
		this.infoTitle2 = infoTitle2;
	}

	public JPanel getInfoTextCont1() {
		return infoTextCont1;
	}

	public void setInfoTextCont1(JPanel infoTextCont1) {
		this.infoTextCont1 = infoTextCont1;
	}

	public JPanel getInfoTextCont2() {
		return infoTextCont2;
	}

	public void setInfoTextCont2(JPanel infoTextCont2) {
		this.infoTextCont2 = infoTextCont2;
	}

	public JTextArea getInfoTextArea1() {
		return infoTextArea1;
	}

	public void setInfoTextArea1(JTextArea infoTextArea1) {
		this.infoTextArea1 = infoTextArea1;
	}

	public JTextArea getInfoTextArea2() {
		return infoTextArea2;
	}

	public void setInfoTextArea2(JTextArea infoTextArea2) {
		this.infoTextArea2 = infoTextArea2;
	}

	public JButton[] getLinkButtons() {
		return linkButtons;
	}

	public void setLinkButtons(JButton[] linkButtons) {
		this.linkButtons = linkButtons;
	}

	public JLabel getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(JLabel chartTitle) {
		this.chartTitle = chartTitle;
	}

	public JPanel getGraphPanel() {
		return graphPanel;
	}

	public void setGraphPanel(JPanel graphPanel) {
		this.graphPanel = graphPanel;
	}

	public JLabel getxAxisLabel() {
		return xAxisLabel;
	}

	public void setxAxisLabel(JLabel xAxisLabel) {
		this.xAxisLabel = xAxisLabel;
	}

	public JLabel getyAxisLabel() {
		return yAxisLabel;
	}

	public void setyAxisLabel(JLabel yAxisLabel) {
		this.yAxisLabel = yAxisLabel;
	}

	public JLabel getTreatedLabel() {
		return treatedLabel;
	}

	public void setTreatedLabel(JLabel treatedLabel) {
		this.treatedLabel = treatedLabel;
	}

	public JLabel getUntreatedLabel() {
		return untreatedLabel;
	}

	public void setUntreatedLabel(JLabel untreatedLabel) {
		this.untreatedLabel = untreatedLabel;
	}

	public JSlider getxAxisValues() {
		return xAxisValues;
	}

	public void setxAxisValues(JSlider xAxisValues) {
		this.xAxisValues = xAxisValues;
	}

	public JSlider getyAxisValues() {
		return yAxisValues;
	}

	public void setyAxisValues(JSlider yAxisValues) {
		this.yAxisValues = yAxisValues;
	}

	public JLabel getSourceLabel() {
		return sourceLabel;
	}

	public void setSourceLabel(JLabel sourceLabel) {
		this.sourceLabel = sourceLabel;
	}

	public JButton getSourceLink() {
		return sourceLink;
	}

	public void setSourceLink(JButton sourceLink) {
		this.sourceLink = sourceLink;
	}

	public JLabel getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(JLabel quizTitle) {
		this.quizTitle = quizTitle;
	}

	public JLabel getQuestionLabel() {
		return questionLabel;
	}

	public void setQuestionLabel(JLabel questionLabel) {
		this.questionLabel = questionLabel;
	}

	public JButton getQuizStartButton() {
		return quizStartButton;
	}

	public void setQuizStartButton(JButton quizStartButton) {
		this.quizStartButton = quizStartButton;
	}

	public JButton[] getOptionButtons() {
		return optionButtons;
	}

	public void setOptionButtons(JButton[] optionButtons) {
		this.optionButtons = optionButtons;
	}

	public JLabel getQuizNumLabel() {
		return quizNumLabel;
	}

	public void setQuizNumLabel(JLabel quizNumLabel) {
		this.quizNumLabel = quizNumLabel;
	}

	public JLabel getQuizScoreLabel() {
		return quizScoreLabel;
	}

	public void setQuizScoreLabel(JLabel quizScoreLabel) {
		this.quizScoreLabel = quizScoreLabel;
	}

	public int getQuizScore() {
		return quizScore;
	}

	public void setQuizScore(int quizScore) {
		this.quizScore = quizScore;
	}

	public int getQuizQuestionIndex() {
		return quizQuestionIndex;
	}

	public void setQuizQuestionIndex(int quizQuestionIndex) {
		this.quizQuestionIndex = quizQuestionIndex;
	}

	public JLabel getAgeTitle() {
		return ageTitle;
	}

	public void setAgeTitle(JLabel ageTitle) {
		this.ageTitle = ageTitle;
	}

	public JLabel getAgeLabel() {
		return ageLabel;
	}

	public void setAgeLabel(JLabel ageLabel) {
		this.ageLabel = ageLabel;
	}

	public JLabel getAgeDescriptionLabel() {
		return ageDescriptionLabel;
	}

	public void setAgeDescriptionLabel(JLabel ageDescriptionLabel) {
		this.ageDescriptionLabel = ageDescriptionLabel;
	}

	public JLabel getAgeLimitLabel() {
		return ageLimitLabel;
	}

	public void setAgeLimitLabel(JLabel ageLimitLabel) {
		this.ageLimitLabel = ageLimitLabel;
	}

	public JLabel getAgeTotalLabel() {
		return ageTotalLabel;
	}

	public void setAgeTotalLabel(JLabel ageTotalLabel) {
		this.ageTotalLabel = ageTotalLabel;
	}

	public JLabel getAgeTreatedLabel() {
		return ageTreatedLabel;
	}

	public void setAgeTreatedLabel(JLabel ageTreatedLabel) {
		this.ageTreatedLabel = ageTreatedLabel;
	}

	public JLabel getAgeUntreatedLabel() {
		return ageUntreatedLabel;
	}

	public void setAgeUntreatedLabel(JLabel ageUntreatedLabel) {
		this.ageUntreatedLabel = ageUntreatedLabel;
	}

	public JProgressBar getAgeTotalMeter() {
		return ageTotalMeter;
	}

	public void setAgeTotalMeter(JProgressBar ageTotalMeter) {
		this.ageTotalMeter = ageTotalMeter;
	}

	public JProgressBar getAgeTreatedMeter() {
		return ageTreatedMeter;
	}

	public void setAgeTreatedMeter(JProgressBar ageTreatedMeter) {
		this.ageTreatedMeter = ageTreatedMeter;
	}

	public JProgressBar getAgeUntreatedMeter() {
		return ageUntreatedMeter;
	}

	public void setAgeUntreatedMeter(JProgressBar ageUntreatedMeter) {
		this.ageUntreatedMeter = ageUntreatedMeter;
	}

	public JSlider getAgeSlider() {
		return ageSlider;
	}

	public void setAgeSlider(JSlider ageSlider) {
		this.ageSlider = ageSlider;
	}

	public JLabel getSelfTestTitle() {
		return selfTestTitle;
	}

	public void setSelfTestTitle(JLabel selfTestTitle) {
		this.selfTestTitle = selfTestTitle;
	}

	public JLabel getQuestionLabel2() {
		return questionLabel2;
	}

	public void setQuestionLabel2(JLabel questionLabel2) {
		this.questionLabel2 = questionLabel2;
	}

	public JButton getQuizStartButton2() {
		return quizStartButton2;
	}

	public void setQuizStartButton2(JButton quizStartButton2) {
		this.quizStartButton2 = quizStartButton2;
	}

	public JButton[] getOptionButtons2() {
		return optionButtons2;
	}

	public void setOptionButtons2(JButton[] optionButtons2) {
		this.optionButtons2 = optionButtons2;
	}

	public JLabel getQuizNumLabel2() {
		return quizNumLabel2;
	}

	public void setQuizNumLabel2(JLabel quizNumLabel2) {
		this.quizNumLabel2 = quizNumLabel2;
	}

	public JLabel getQuizScoreLabel2() {
		return quizScoreLabel2;
	}

	public void setQuizScoreLabel2(JLabel quizScoreLabel2) {
		this.quizScoreLabel2 = quizScoreLabel2;
	}

	public int getQuizScore2() {
		return quizScore2;
	}

	public void setQuizScore2(int quizScore2) {
		this.quizScore2 = quizScore2;
	}

	public int getQuizQuestionIndex2() {
		return quizQuestionIndex2;
	}

	public void setQuizQuestionIndex2(int quizQuestionIndex2) {
		this.quizQuestionIndex2 = quizQuestionIndex2;
	}

	public ImageIcon getIMAGEICON_LOGO() {
		return IMAGEICON_LOGO;
	}

	public Image getIMAGE_LOGO() {
		return IMAGE_LOGO;
	}

	public Color getMAIN_BKCOLOR() {
		return MAIN_BKCOLOR;
	}

	public Color getINFO_BKCOLOR() {
		return INFO_BKCOLOR;
	}

	public Cursor getHAND_CURSOR() {
		return HAND_CURSOR;
	}

	public Cursor getCROSSHAIR_CURSOR() {
		return CROSSHAIR_CURSOR;
	}

	public Cursor getTEXT_CURSOR() {
		return TEXT_CURSOR;
	}

	public Border getDEFAULT_BORDER() {
		return DEFAULT_BORDER;
	}

	public Font getHUGE_FONT() {
		return HUGE_FONT;
	}

	public Font getTITLE_FONT() {
		return TITLE_FONT;
	}

	public Font getSUBTITLE_FONT() {
		return SUBTITLE_FONT;
	}

	public Font getBUTTON_FONT() {
		return BUTTON_FONT;
	}

	public Font getLINK_FONT() {
		return LINK_FONT;
	}

	public Font getNORMAL_FONT() {
		return NORMAL_FONT;
	}

	public Font getAXIS_FONT() {
		return AXIS_FONT;
	}

	public Rectangle[] getBTN_BIG_POSITIONS() {
		return BTN_BIG_POSITIONS;
	}

	public Rectangle[] getBTN_SMALL_POSITIONS() {
		return BTN_SMALL_POSITIONS;
	}

	public String getWINDOW_TITLE() {
		return WINDOW_TITLE;
	}

	public String[] getTabButtonText() {
		return tabButtonText;
	}

	public String[] getTabButtonTooltips() {
		return tabButtonTooltips;
	}

	public String getSOURCE_SHEET() {
		return SOURCE_SHEET;
	}

	public String[] getQUIZ_ANSWERFEEDBACK() {
		return QUIZ_ANSWERFEEDBACK;
	}

	public String getDATA_FILE_NAME() {
		return DATA_FILE_NAME;
	}

	public String[] getQUIZ_QUESTIONS() {
		return QUIZ_QUESTIONS;
	}

	public String[][] getQUIZ_OPTIONS() {
		return QUIZ_OPTIONS;
	}

	public int[] getQUIZ_CORRECT_ANSWERS() {
		return QUIZ_CORRECT_ANSWERS;
	}

	public String[] getQUIZ_FEEDBACK() {
		return QUIZ_FEEDBACK;
	}

	public String[][] getWEB_LINK_TEXT() {
		return WEB_LINK_TEXT;
	}

	public String[][] getWEB_LINKS() {
		return WEB_LINKS;
	}

	public String[] getLEARN_MORE_INFO() {
		return LEARN_MORE_INFO;
	}

	public String[] getTEST_QUESTIONS() {
		return TEST_QUESTIONS;
	}

	public String[] getTEST_OPTIONS() {
		return TEST_OPTIONS;
	}

	public String[] getTEST_FEEDBACK() {
		return TEST_FEEDBACK;
	}

	public int getCurrentTab() {
		return currentTab;
	}

	// Set the current tab
	public void setCurrentTab(int currentTab) {

		this.currentTab = currentTab;
		for (int count = 0; count < 4; count++) {
			JButton btn = tabButtons[count];
			Rectangle bounds = (currentTab == count) ? BTN_BIG_POSITIONS[count] : BTN_SMALL_POSITIONS[count];
			btn.setBounds(bounds);
			tabPanels[count].setVisible(false);
			if (currentTab == count) {

				// Update information text and link buttons
				for (int linkCount = 0; linkCount < 3; linkCount++) {
					linkButtons[linkCount].setText(WEB_LINK_TEXT[count][linkCount]);
					linkButtons[linkCount].setToolTipText(WEB_LINKS[count][linkCount]);
					infoTextArea1.setText(LEARN_MORE_INFO[count]);
				}

				// Show correct panel
				tabPanels[count].setVisible(true);

			}
		}

	}

	@Override
	public String toString() {
		return "AgeDistributionFrame [IMAGEICON_LOGO=" + IMAGEICON_LOGO + ", IMAGE_LOGO=" + IMAGE_LOGO
				+ ", MAIN_BKCOLOR=" + MAIN_BKCOLOR + ", INFO_BKCOLOR=" + INFO_BKCOLOR + ", HAND_CURSOR=" + HAND_CURSOR
				+ ", CROSSHAIR_CURSOR=" + CROSSHAIR_CURSOR + ", TEXT_CURSOR=" + TEXT_CURSOR + ", DEFAULT_BORDER="
				+ DEFAULT_BORDER + ", HUGE_FONT=" + HUGE_FONT + ", TITLE_FONT=" + TITLE_FONT + ", SUBTITLE_FONT="
				+ SUBTITLE_FONT + ", BUTTON_FONT=" + BUTTON_FONT + ", LINK_FONT=" + LINK_FONT + ", NORMAL_FONT="
				+ NORMAL_FONT + ", AXIS_FONT=" + AXIS_FONT + ", BTN_BIG_POSITIONS=" + Arrays.toString(BTN_BIG_POSITIONS)
				+ ", BTN_SMALL_POSITIONS=" + Arrays.toString(BTN_SMALL_POSITIONS) + ", WINDOW_TITLE=" + WINDOW_TITLE
				+ ", tabButtonText=" + Arrays.toString(tabButtonText) + ", tabButtonTooltips="
				+ Arrays.toString(tabButtonTooltips) + ", SOURCE_SHEET=" + SOURCE_SHEET + ", QUIZ_QUESTIONS="
				+ Arrays.toString(QUIZ_QUESTIONS) + ", QUIZ_OPTIONS=" + Arrays.toString(QUIZ_OPTIONS)
				+ ", QUIZ_CORRECT_ANSWERS=" + Arrays.toString(QUIZ_CORRECT_ANSWERS) + ", QUIZ_ANSWERFEEDBACK="
				+ Arrays.toString(QUIZ_ANSWERFEEDBACK) + ", QUIZ_FEEDBACK=" + Arrays.toString(QUIZ_FEEDBACK)
				+ ", WEB_LINK_TEXT=" + Arrays.toString(WEB_LINK_TEXT) + ", WEB_LINKS=" + Arrays.toString(WEB_LINKS)
				+ ", LEARN_MORE_INFO=" + Arrays.toString(LEARN_MORE_INFO) + ", TEST_QUESTIONS="
				+ Arrays.toString(TEST_QUESTIONS) + ", TEST_OPTIONS=" + Arrays.toString(TEST_OPTIONS)
				+ ", TEST_FEEDBACK=" + Arrays.toString(TEST_FEEDBACK) + ", DATA_FILE_NAME=" + DATA_FILE_NAME
				+ ", parsedData=" + parsedData + ", treatedCasesByAge=" + Arrays.toString(treatedCasesByAge)
				+ ", untreatedCasesByAge=" + Arrays.toString(untreatedCasesByAge) + ", menuBar=" + menuBar
				+ ", homeMenu=" + homeMenu + ", helpMenu=" + helpMenu + ", otherMenu=" + otherMenu + ", homeMenuItems="
				+ Arrays.toString(homeMenuItems) + ", helpMenuItems=" + Arrays.toString(helpMenuItems)
				+ ", otherMenuItems=" + Arrays.toString(otherMenuItems) + ", mainSection=" + mainSection
				+ ", infoSection=" + infoSection + ", iconLabel=" + iconLabel + ", mainTitle=" + mainTitle
				+ ", mainSectionDisplay=" + mainSectionDisplay + ", tabButtons=" + Arrays.toString(tabButtons)
				+ ", tabPanels=" + Arrays.toString(tabPanels) + ", infoTitle1=" + infoTitle1 + ", infoTitle2="
				+ infoTitle2 + ", infoTextCont1=" + infoTextCont1 + ", infoTextCont2=" + infoTextCont2
				+ ", infoTextArea1=" + infoTextArea1 + ", infoTextArea2=" + infoTextArea2 + ", linkButtons="
				+ Arrays.toString(linkButtons) + ", chartTitle=" + chartTitle + ", graphPanel=" + graphPanel
				+ ", xAxisLabel=" + xAxisLabel + ", yAxisLabel=" + yAxisLabel + ", treatedLabel=" + treatedLabel
				+ ", untreatedLabel=" + untreatedLabel + ", xAxisValues=" + xAxisValues + ", yAxisValues=" + yAxisValues
				+ ", sourceLabel=" + sourceLabel + ", sourceLink=" + sourceLink + ", quizTitle=" + quizTitle
				+ ", questionLabel=" + questionLabel + ", quizStartButton=" + quizStartButton + ", optionButtons="
				+ Arrays.toString(optionButtons) + ", quizNumLabel=" + quizNumLabel + ", quizScoreLabel="
				+ quizScoreLabel + ", quizScore=" + quizScore + ", quizQuestionIndex=" + quizQuestionIndex
				+ ", ageTitle=" + ageTitle + ", ageLabel=" + ageLabel + ", ageDescriptionLabel=" + ageDescriptionLabel
				+ ", ageLimitLabel=" + ageLimitLabel + ", ageTotalLabel=" + ageTotalLabel + ", ageTreatedLabel="
				+ ageTreatedLabel + ", ageUntreatedLabel=" + ageUntreatedLabel + ", ageTotalMeter=" + ageTotalMeter
				+ ", ageTreatedMeter=" + ageTreatedMeter + ", ageUntreatedMeter=" + ageUntreatedMeter + ", ageSlider="
				+ ageSlider + ", selfTestTitle=" + selfTestTitle + ", questionLabel2=" + questionLabel2
				+ ", quizStartButton2=" + quizStartButton2 + ", optionButtons2=" + Arrays.toString(optionButtons2)
				+ ", quizNumLabel2=" + quizNumLabel2 + ", quizScoreLabel2=" + quizScoreLabel2 + ", quizScore2="
				+ quizScore2 + ", quizQuestionIndex2=" + quizQuestionIndex2 + ", currentTab=" + currentTab + "]";
	}

}