/**
 * Who Wants to be a Zillionaire? - Add Question
 * GUI for adding questions
 * 
 * @author	James Duerden
 * @version	2016-04-07
 **/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField newQuestion;
	private JTextField newRightAns;
	private JTextField newWrongAns1;
	private JTextField newWrongAns2;
	private JTextField newWrongAns3;
	private QuestionReader questionWriter;
	public static QuestionSet gameQuestions;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddQuestion frmAdd = new AddQuestion(gameQuestions);
					frmAdd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddQuestion(QuestionSet questions) {
		setAlwaysOnTop(true);
		setTitle("Add a Question");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddQuestion.class.getResource("/Icon/ZillionaireLogo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		QuestionReader questionWriter = new QuestionReader(gameQuestions);
		QuestionSet writingQuestions = new QuestionSet();
		
		//create all gui aspects
		JComboBox newCategory = new JComboBox();
		newCategory.setModel(new DefaultComboBoxModel(new String[] {"General Knowledge", "History", "Gaming"}));
		newCategory.setBounds(10, 10, 250, 20);
		contentPane.add(newCategory);
		
		newQuestion = new JTextField();
		newQuestion.setBounds(10, 40, 250, 20);
		contentPane.add(newQuestion);
		newQuestion.setColumns(10);
		
		newRightAns = new JTextField();
		newRightAns.setBounds(10, 70, 250, 20);
		contentPane.add(newRightAns);
		newRightAns.setColumns(10);
		
		newWrongAns1 = new JTextField();
		newWrongAns1.setBounds(10, 100, 250, 20);
		contentPane.add(newWrongAns1);
		newWrongAns1.setColumns(10);
		
		newWrongAns2 = new JTextField();
		newWrongAns2.setBounds(10, 130, 250, 20);
		contentPane.add(newWrongAns2);
		newWrongAns2.setColumns(10);
		
		newWrongAns3 = new JTextField();
		newWrongAns3.setBounds(10, 160, 250, 20);
		contentPane.add(newWrongAns3);
		newWrongAns3.setColumns(10);
		
		JComboBox newDifficulty = new JComboBox();
		newDifficulty.setModel(new DefaultComboBoxModel(new String[] {"Easy", "Medium", "Hard"}));
		newDifficulty.setBounds(10, 190, 250, 20);
		contentPane.add(newDifficulty);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setForeground(new Color(255, 255, 255));
		categoryLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		categoryLabel.setBounds(270, 13, 154, 14);
		contentPane.add(categoryLabel);
		
		JLabel questionLabel = new JLabel("Question");
		questionLabel.setForeground(Color.WHITE);
		questionLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		questionLabel.setBounds(270, 43, 154, 14);
		contentPane.add(questionLabel);
		
		JLabel rightLabel = new JLabel("Correct Answer");
		rightLabel.setForeground(Color.WHITE);
		rightLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		rightLabel.setBounds(270, 73, 154, 14);
		contentPane.add(rightLabel);
		
		JLabel wrong1Label = new JLabel("Wrong Answer 1");
		wrong1Label.setForeground(Color.WHITE);
		wrong1Label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		wrong1Label.setBounds(270, 103, 154, 14);
		contentPane.add(wrong1Label);
		
		JLabel wrong2Label = new JLabel("Wrong Answer 2");
		wrong2Label.setForeground(Color.WHITE);
		wrong2Label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		wrong2Label.setBounds(270, 133, 154, 14);
		contentPane.add(wrong2Label);
		
		JLabel wrong3Label = new JLabel("Wrong Answer 3");
		wrong3Label.setForeground(Color.WHITE);
		wrong3Label.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		wrong3Label.setBounds(270, 163, 154, 14);
		contentPane.add(wrong3Label);
		
		JLabel difficultyLabel = new JLabel("Difficulty");
		difficultyLabel.setForeground(Color.WHITE);
		difficultyLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		difficultyLabel.setBounds(270, 193, 154, 14);
		contentPane.add(difficultyLabel);
		
		JButton addButton = new JButton("Add");			//method for adding question
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(newQuestion.getText().isEmpty() || newRightAns.getText().isEmpty() || newWrongAns1.getText().isEmpty() || newWrongAns2.getText().isEmpty() || newWrongAns3.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(contentPane, "One or more fields are empty!", "Missing Piece", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					QuestionSet writingQuestions = questionWriter.readAllQuestions();
					Answer[] answersToAdd = new Answer[4];
					answersToAdd[0] = new Answer(newRightAns.getText(), true);
					answersToAdd[1] = new Answer(newWrongAns1.getText(), false);
					answersToAdd[2] = new Answer(newWrongAns2.getText(), false);
					answersToAdd[3] = new Answer(newWrongAns3.getText(), false);
					Question questionToAdd = new Question(newCategory.getSelectedItem().toString(), newQuestion.getText(), answersToAdd, newDifficulty.getSelectedItem().toString(), false);
					writingQuestions.addQuestion(questionToAdd);
					questionWriter.writeQuestion();
					dispose();		//can only add one at a time
				}
			}
		});
		addButton.setBounds(110, 227, 89, 23);
		contentPane.add(addButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(247, 227, 89, 23);
		contentPane.add(cancelButton);
	}
}
