//Name: Krrish Lalit
//Date: May 24 2023
//Course: ICS4U1
//Description: This class is suppose to hold the quiz frame, which allows the user to play the quiz 

package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuizFrame extends JFrame implements ActionListener {

	// JButton
	public JButton backButton = new JButton("Back");
	public JButton okButton = new JButton("OK");

	// JLabels
	public JLabel backgroundLabel = new JLabel("");
	public JLabel titleLabel = new JLabel("Mental Health Quiz");
	public JLabel questionLabel = new JLabel();
	public JLabel answerLabel = new JLabel();

	// JTextField
	public JTextField choiceTextField = new JTextField();

	// Variables
	public int questionNumber = 0;
	public int score = 0;
	public String nextQuestion;
	public String answerText;

	// Constants
	public final String[] QUESTIONS = {
			"Poor mental health increases the risk for long lasting physical conditions like?", "Mental illnesses are:",
			"If you know someone with poor mental health, you can help by:",
			"Half of all mental illnesses occur before a person turns:" };
	public final String[] ANSWERTEXT = { "1. Heart Disease, 2. Stroke, 3.Cancer, 4. All of the above",
			"1. Very Common, 2. Not Very Common, 3. Fairly Common",
			"1. Reaching out to them, 2. Helping them access mental health services, 3. All of the above",
			"1. 10 Years Old, 2. 14 Years Old, 3. 18 Years Old" };
	public final String[] CORRECT_ANSWERS = { "4", "1", "3", "2" };
	public final String[] FEEDBACK_TEXT = { "Go back to the organization frame to learn more...", // 0 correct
			"At least you got one correct...", // 1 correct
			"You can always retry the quiz...", // 2 correct
			"Pretty good... what could have gone wrong?", // 3 correct
			"Incredible! Be sure to spread the word!" // 4 correct
	};

	// Construtor Method
	public QuizFrame() {

		// Setting the size of the frame
		setSize(1920, 1080);
		setLayout(null);

		// Setting the title
		setTitle("Mental Health Quiz");

		// Customize Title
		titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
		titleLabel.setBounds(50, 100, 1000, 50);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);

		// Setting the question Label
		questionLabel.setFont(new Font("Arial", Font.BOLD, 24));
		questionLabel.setBounds(100, 200, 1800, 50);
		backgroundLabel.add(questionLabel);

		// Setting the answer Label
		answerLabel.setFont(new Font("Arial", Font.BOLD, 18));
		answerLabel.setBounds(100, 300, 1800, 50);
		backgroundLabel.add(answerLabel);

		// Setting the choice text field
		choiceTextField.setFont(new Font("Arial", Font.BOLD, 18));
		choiceTextField.setBounds(100, 400, 50, 50);
		choiceTextField.addActionListener(this);
		backgroundLabel.add(choiceTextField);

		// Setting the OK button
		okButton.setFont(new Font("Arial", Font.PLAIN, 20));
		okButton.setBounds(150, 400, 100, 50);
		okButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		okButton.addActionListener(this);
		backgroundLabel.add(okButton);

		// Setting the back button
		backButton.setFont(new Font("Arial", Font.PLAIN, 20));
		backButton.setBounds(100, 600, 100, 50);
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(this);
		add(backButton);

		// Setting up the background
		backgroundLabel.setBackground(Color.YELLOW);
		backgroundLabel.setOpaque(true);
		backgroundLabel.setBounds(0, 0, 1920, 1080);
		add(backgroundLabel);

		nextQuestion();

		// Frame Visibilty
		setVisible(true);

	}

	// This method shows the questions and the choices
	private void nextQuestion() {

		if (questionNumber <= 3) {

			// Process of switching the question
			questionNumber++;
			choiceTextField.setText("");

			// Update question and answer text
			nextQuestion = QUESTIONS[questionNumber - 1];
			answerText = ANSWERTEXT[questionNumber - 1];

			// Set text on labels
			questionLabel.setText(nextQuestion);
			answerLabel.setText(answerText);

		} else {

			String scoreString = "Your score is " + score + " out of 4!";
			String feedback = FEEDBACK_TEXT[score];

			questionLabel.setText("Quiz complete!");
			answerLabel.setText(scoreString);

			JOptionPane.showMessageDialog(this, scoreString + "\n\n" + feedback);

			choiceTextField.setEnabled(false);
			okButton.setEnabled(false);

		}

	}

	// This method makes the buttons function
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == backButton) {
			new OrganizationFrame();

			setVisible(false);

			// Survey Questions and Answers

		} else if (event.getSource() == choiceTextField || event.getSource() == okButton) {

			String correctAnswer = CORRECT_ANSWERS[questionNumber - 1];

			if (choiceTextField.getText().equals(correctAnswer)) {

				// Correct answer
				JOptionPane.showMessageDialog(this, "CORRECT");
				score++;

			} else {

				// Wrong answer
				JOptionPane.showMessageDialog(this, "WRONG\n\nThe right answer is " + correctAnswer);

			}

		}

		// Next Question
		nextQuestion();
	}

}