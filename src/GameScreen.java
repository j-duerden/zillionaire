/*
 * Who Wants to be a Zillionaire? - Game Screen
 * The main GUI that the players will use to answer questions
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import java.awt.List;

public class GameScreen extends JFrame {


	private JFrame frmGame;
	private ArrayList<Question> questions;
	private JTextField answerA;
	private JTextField answerB;
	private JTextField answerC;
	private JTextField answerD;
	private JTextArea questionBox;
	private JSlider P1AnswerCount;
	private JSlider P2AnswerCount;
	private JSlider P3AnswerCount;
	private JSlider P4AnswerCount;
	private JLabel turnCount;
	private JButton buttonA;
	private JButton buttonB;
	private JButton buttonC;
	private JButton buttonD;
	private boolean buttonReset;
	public static QuestionReader questionBank;
	public static QuestionSet gameQuestions;
	public SoundMixer sounds;
	public Player playerOne;
	public Player playerTwo;
	public Player playerThree;
	public Player playerFour;
	public Player[] playerList;
	public boolean[] categories;
	public static Answer[] currentAnswers;
	private boolean continueGame;
	public String[] newQuestion;
	public String selectedAnswer;
	public String newName;
	public int currentPlayer;
	public static GameController gameController;
	private JTextField category;
	private JTextField feedback;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameScreen mainGame = new GameScreen(gameController, gameQuestions);
					mainGame.getFrmGame().setVisible(true); //correct
					//mainGame.setVisible(true); //incorrect
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GameScreen(GameController gameController, QuestionSet gameQuestions) 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize()
	{
		setFrmGame(new JFrame());
		getFrmGame().setIconImage(Toolkit.getDefaultToolkit().getImage(GameScreen.class.getResource("/Icon/ZillionaireLogo.png")));
		getFrmGame().getContentPane().setBackground(new Color(25, 25, 112));
		getFrmGame().getContentPane().setForeground(new Color(0, 191, 255));
		getFrmGame().setTitle("Who Wants to be a Zillionaire?");
		getFrmGame().setBounds(100, 100, 600, 450);
		getFrmGame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmGame().getContentPane().setLayout(null);
		QuestionReader questionBank = new QuestionReader(gameQuestions);
		SoundMixer sounds = new SoundMixer();
		Player[] players = new Player[LaunchScreen.playerCount];
		String[] newQuestion = new String[8];
		Answer[] currentAnswers = new Answer[4];
		boolean[] categories = new boolean[3];
		JButton buttonA = new JButton("A)");
		JButton buttonB = new JButton("B)");
		JButton buttonC = new JButton("C)");
		JButton buttonD = new JButton("D)");
		JButton fiftyFifty = new JButton("");
		JButton askAudience = new JButton("");
		currentPlayer = 0;
		categories[0] = LaunchScreen.loadGenKnow;
		categories[1] = LaunchScreen.loadHistory;
		categories[2] = LaunchScreen.loadGaming;
		GameController gameController = new GameController();
		questions = new ArrayList<Question>();
		
		JTextArea questionBox = new JTextArea();
		questionBox.setForeground(Color.WHITE);
		questionBox.setBackground(Color.BLACK);
		questionBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		questionBox.setEditable(false);
		questionBox.setText("Q: ");
		questionBox.setBounds(40, 225, 500, 50);
		getFrmGame().getContentPane().add(questionBox);
		
		JSlider P1AnswerCount = new JSlider();
		P1AnswerCount.setEnabled(false);
		P1AnswerCount.setToolTipText("Your progress to becoming a zillionaire, player 1!");
		P1AnswerCount.setMinorTickSpacing(1);
		P1AnswerCount.setValue(0);
		P1AnswerCount.setMajorTickSpacing(5);
		P1AnswerCount.setMaximum(15);
		P1AnswerCount.setSnapToTicks(true);
		P1AnswerCount.setPaintTicks(true);
		P1AnswerCount.setBounds(150, 110, 250, 20);
		frmGame.getContentPane().add(P1AnswerCount);
		
		JSlider P2AnswerCount = new JSlider();
		P2AnswerCount.setValue(0);
		P2AnswerCount.setToolTipText("Your progress to becoming a zillionaire, player 2!");
		P2AnswerCount.setSnapToTicks(true);
		P2AnswerCount.setPaintTicks(true);
		P2AnswerCount.setMinorTickSpacing(1);
		P2AnswerCount.setMaximum(15);
		P2AnswerCount.setMajorTickSpacing(5);
		P2AnswerCount.setEnabled(false);
		P2AnswerCount.setBounds(150, 135, 250, 20);
		frmGame.getContentPane().add(P2AnswerCount);
		
		JSlider P3AnswerCount = new JSlider();
		P3AnswerCount.setValue(0);
		P3AnswerCount.setToolTipText("Your progress to becoming a zillionaire, player 3!");
		P3AnswerCount.setSnapToTicks(true);
		P3AnswerCount.setPaintTicks(true);
		P3AnswerCount.setMinorTickSpacing(1);
		P3AnswerCount.setMaximum(15);
		P3AnswerCount.setMajorTickSpacing(5);
		P3AnswerCount.setEnabled(false);
		P3AnswerCount.setBounds(150, 160, 250, 20);
		frmGame.getContentPane().add(P3AnswerCount);
		
		JSlider P4AnswerCount = new JSlider();
		P4AnswerCount.setValue(0);
		P4AnswerCount.setToolTipText("Your progress to becoming a zillionaire, player 4!");
		P4AnswerCount.setSnapToTicks(true);
		P4AnswerCount.setPaintTicks(true);
		P4AnswerCount.setMinorTickSpacing(1);
		P4AnswerCount.setMaximum(15);
		P4AnswerCount.setMajorTickSpacing(5);
		P4AnswerCount.setEnabled(false);
		P4AnswerCount.setBounds(150, 185, 250, 20);
		frmGame.getContentPane().add(P4AnswerCount);
		
		answerA = new JTextField();
		answerA.setForeground(Color.WHITE);
		answerA.setBackground(Color.BLACK);
		answerA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		answerA.setEditable(false);
		answerA.setBounds(64, 303, 210, 20);
		getFrmGame().getContentPane().add(answerA);
		answerA.setColumns(10);
		
		answerB = new JTextField();
		answerB.setForeground(Color.WHITE);
		answerB.setBackground(Color.BLACK);
		answerB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		answerB.setEditable(false);
		answerB.setColumns(10);
		answerB.setBounds(364, 303, 210, 20);
		getFrmGame().getContentPane().add(answerB);
		
		answerC = new JTextField();
		answerC.setForeground(Color.WHITE);
		answerC.setBackground(Color.BLACK);
		answerC.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		answerC.setEditable(false);
		answerC.setColumns(10);
		answerC.setBounds(64, 364, 210, 20);
		getFrmGame().getContentPane().add(answerC);
		
		answerD = new JTextField();
		answerD.setForeground(Color.WHITE);
		answerD.setBackground(Color.BLACK);
		answerD.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		answerD.setEditable(false);
		answerD.setColumns(10);
		answerD.setBounds(364, 364, 210, 20);
		getFrmGame().getContentPane().add(answerD);
		
		JLabel turnCount = new JLabel("");
		turnCount.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		turnCount.setForeground(new Color(255, 255, 255));
		turnCount.setBounds(10, 149, 130, 14);
		turnCount.setText("Player " + (currentPlayer + 1)  + "'s turn");
		frmGame.getContentPane().add(turnCount);
		
		//button w/ checks for answer A
		buttonA.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean continueGame = gameController.lockIn(answerA);
				if(continueGame)
				{
					gameController.resetButtons(buttonA, buttonB, buttonC, buttonD);
					gameController.clicked(answerA);
					boolean isRight = gameController.checkAnswer(players[currentPlayer], answerA.getText(), players);
					if(isRight == true)
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						players[currentPlayer].addPoint();
						if(players[currentPlayer].getPoints() >= 15)
						{
							VictoryScreen winner = new VictoryScreen(players[currentPlayer].getName());
							winner.setVisible(true);
							frmGame.dispose();
						}
						feedback.setBackground(Color.GREEN);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						fiftyFifty.setEnabled(players[currentPlayer].getFiftyFifty());
						askAudience.setEnabled(players[currentPlayer].getAskAudience());
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						category.setText(newQuestion[5]);
						P1AnswerCount.setValue(players[0].getPoints());
						if(players.length >= 2)
						{
							P2AnswerCount.setValue(players[1].getPoints());	
							if(players.length>=3 )
							{
								P3AnswerCount.setValue(players[2].getPoints());
								if(players.length == 4)
								{
									P4AnswerCount.setValue(players[3].getPoints());
								}
							}
							
						}
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
					else
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						feedback.setBackground(Color.RED);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
				}
			}
		});
		buttonA.setBackground(Color.LIGHT_GRAY);
		buttonA.setBounds(10, 288, 50, 50);
		getFrmGame().getContentPane().add(buttonA);
		
		//button w/ checks for answer B
		buttonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean continueGame = gameController.lockIn(answerB);
				if(continueGame)
				{
					gameController.resetButtons(buttonA, buttonB, buttonC, buttonD);
					gameController.clicked(answerB);
					boolean isRight = gameController.checkAnswer(players[currentPlayer], answerB.getText(), players);
					if(isRight == true)
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						players[currentPlayer].addPoint();
						if(players[currentPlayer].getPoints() >= 15)
						{
							VictoryScreen winner = new VictoryScreen(players[currentPlayer].getName());
							winner.setVisible(true);
							frmGame.dispose();
						}
						feedback.setBackground(Color.GREEN);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						fiftyFifty.setEnabled(players[currentPlayer].getFiftyFifty());
						askAudience.setEnabled(players[currentPlayer].getAskAudience());
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						category.setText(newQuestion[5]);
						P1AnswerCount.setValue(players[0].getPoints());
						if(players.length >= 2)
						{
							P2AnswerCount.setValue(players[1].getPoints());	
							if(players.length>=3 )
							{
								P3AnswerCount.setValue(players[2].getPoints());
								if(players.length == 4)
								{
									P4AnswerCount.setValue(players[3].getPoints());
								}
							}
							
						}
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
					else
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						feedback.setBackground(Color.RED);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
				}
					
			}
		});
		
		buttonB.setBackground(Color.LIGHT_GRAY);
		buttonB.setBounds(310, 288, 50, 50);
		getFrmGame().getContentPane().add(buttonB);
		
		//button w/ checks for answer C
		buttonC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				boolean continueGame = gameController.lockIn(answerC);
				if(continueGame)
				{
					gameController.resetButtons(buttonA, buttonB, buttonC, buttonD);
					gameController.clicked(answerC);
					boolean isRight = gameController.checkAnswer(players[currentPlayer], answerC.getText(), players);
					if(isRight == true)
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						players[currentPlayer].addPoint();
						if(players[currentPlayer].getPoints() >= 15)
						{
							VictoryScreen winner = new VictoryScreen(players[currentPlayer].getName());
							winner.setVisible(true);
							frmGame.dispose();
						}
						feedback.setBackground(Color.GREEN);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						fiftyFifty.setEnabled(players[currentPlayer].getFiftyFifty());
						askAudience.setEnabled(players[currentPlayer].getAskAudience());
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						category.setText(newQuestion[5]);
						P1AnswerCount.setValue(players[0].getPoints());
						if(players.length >= 2)
						{
							P2AnswerCount.setValue(players[1].getPoints());	
							if(players.length>=3 )
							{
								P3AnswerCount.setValue(players[2].getPoints());
								if(players.length == 4)
								{
									P4AnswerCount.setValue(players[3].getPoints());
								}
							}
							
						}
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
					else
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						feedback.setBackground(Color.RED);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
				}
			}
		});
		buttonC.setBackground(Color.LIGHT_GRAY);
		buttonC.setBounds(10, 349, 50, 50);
		getFrmGame().getContentPane().add(buttonC);
		
		//button w/ checks for answer D
		buttonD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				boolean continueGame = gameController.lockIn(answerD);
				if(continueGame)
				{
					gameController.resetButtons(buttonA, buttonB, buttonC, buttonD);
					gameController.clicked(answerD);
					boolean isRight = gameController.checkAnswer(players[currentPlayer], answerD.getText(), players);
					if(isRight == true)
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						players[currentPlayer].addPoint();
						if(players[currentPlayer].getPoints() >= 15)
						{
							VictoryScreen winner = new VictoryScreen(players[currentPlayer].getName());
							winner.setVisible(true);
							frmGame.dispose();
						}
						feedback.setBackground(Color.GREEN);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						fiftyFifty.setEnabled(players[currentPlayer].getFiftyFifty());
						askAudience.setEnabled(players[currentPlayer].getAskAudience());
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						category.setText(newQuestion[5]);
						P1AnswerCount.setValue(players[0].getPoints());
						if(players.length >= 2)
						{
							P2AnswerCount.setValue(players[1].getPoints());	
							if(players.length>=3 )
							{
								P3AnswerCount.setValue(players[2].getPoints());
								if(players.length == 4)
								{
									P4AnswerCount.setValue(players[3].getPoints());
								}
							}
							
						}
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
					else
					{
						gameController.difficultySound(players[currentPlayer].getPoints(), isRight);
						feedback.setBackground(Color.RED);
						currentPlayer++;
						if(currentPlayer > players.length - 1)
						{
							currentPlayer = 0;
						}
						String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
						questionBox.setText(newQuestion[0]);
						answerA.setText(newQuestion[1]);
						answerB.setText(newQuestion[2]);
						answerC.setText(newQuestion[3]);
						answerD.setText(newQuestion[4]);
						category.setText(newQuestion[5]);
						turnCount.setText("Player " + (currentPlayer + 1) + "'s turn");
					}
				}
			}
		});
		buttonD.setBackground(Color.LIGHT_GRAY);
		buttonD.setBounds(310, 349, 50, 50);
		getFrmGame().getContentPane().add(buttonD);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 21);
		getFrmGame().getContentPane().add(menuBar);
		
		JMenu mnFiles = new JMenu("Files");
		menuBar.add(mnFiles);
		
		JMenuItem mntmAddQuestion = new JMenuItem("Add Question");
		mntmAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				AddQuestion add = new AddQuestion(gameQuestions);
				add.setVisible(true);
			}
		});
		mnFiles.add(mntmAddQuestion);
		
		JMenuItem mntmLoadQuestion = new JMenuItem("Load Test Question");
		mntmLoadQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String[] newQuestion = gameController.newSortedQuestion(players[currentPlayer]);
				questionBox.setText(newQuestion[0]);
				answerA.setText(newQuestion[1]);
				answerB.setText(newQuestion[2]);
				answerC.setText(newQuestion[3]);
				answerD.setText(newQuestion[4]);
				category.setText(newQuestion[5]);
			}
		});
		mnFiles.add(mntmLoadQuestion);
		
		JMenuItem mntnCountCategory = new JMenuItem("Check Categories");
		mntnCountCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println(categories.length);
				if(categories[0])
				{
					System.out.println("General knowledge is active");
				}
				if(categories[1])
				{
					System.out.println("History is active");
				}
				if(categories[2])
				{
					System.out.println("Gaming is active");
				}
			}
		}
				);
		mnFiles.add(mntnCountCategory);
		
		
		JMenu mnGame = new JMenu("Game");
		menuBar.add(mnGame);
		
		JMenuItem mntmTest = new JMenuItem("Test");
		mntmTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameScreen mainGame = new GameScreen(gameController, gameQuestions);
				mainGame.getFrmGame().setVisible(true);
				getFrmGame().setVisible(false);
				dispose();
			}
		});
		mnGame.add(mntmTest);
		
		category = new JTextField();
		category.setEditable(false);
		category.setForeground(Color.WHITE);
		category.setBackground(Color.BLACK);
		category.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		category.setBounds(10, 192, 130, 25);
		frmGame.getContentPane().add(category);
		category.setColumns(10);
		
		List playerDisplay = new List();
		playerDisplay.setEnabled(false);
		playerDisplay.setMultipleSelections(false);
		playerDisplay.setBounds(10, 27, 130, 90);
		for(int x = 1; x <= players.length; x++)
		{
			if(x == 1)
			{
				newName = LaunchScreen.P1NameEntry;
			}
			else if(x == 2)
			{
				newName = LaunchScreen.P2NameEntry;
			}
			else if(x == 3)
			{
				newName = LaunchScreen.P3NameEntry;
			}
			else if(x == 4)
			{
				newName = LaunchScreen.P4NameEntry;
			}
			players[x - 1] = new Player(newName, 1);
			playerDisplay.add("Player " + x + ": " + players[x-1].getName());
		}
		frmGame.getContentPane().add(playerDisplay);
		
		//code to remove two random answers from current question
		fiftyFifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean isARight = gameController.getAnswers(players[currentPlayer], answerA.getText(), players);
				boolean isBRight = gameController.getAnswers(players[currentPlayer], answerB.getText(), players);
				boolean isCRight = gameController.getAnswers(players[currentPlayer], answerC.getText(), players);
				boolean isDRight = gameController.getAnswers(players[currentPlayer], answerD.getText(), players);
				currentAnswers[0] = new Answer(answerA.getText(),isARight);
				currentAnswers[1] = new Answer(answerB.getText(),isBRight);
				currentAnswers[2] = new Answer(answerC.getText(),isCRight);
				currentAnswers[3] = new Answer(answerD.getText(),isDRight);
				Answer[] alteredAnswers = new Answer[4];
				sounds.playSound("50_50");
				alteredAnswers = gameController.removeAnswers(currentAnswers);
				answerA.setText(alteredAnswers[0].returnAnswer());
				if(answerA.getText().equals(""))
				{
					buttonA.setEnabled(false);
				}
				answerB.setText(alteredAnswers[1].returnAnswer());
				if(answerB.getText().equals(""))
				{
					buttonB.setEnabled(false);
				}
				answerC.setText(alteredAnswers[2].returnAnswer());
				if(answerC.getText().equals(""))
				{
					buttonC.setEnabled(false);
				}
				answerD.setText(alteredAnswers[3].returnAnswer());
				if(answerD.getText().equals(""))
				{
					buttonD.setEnabled(false);
				}
				players[currentPlayer].usedFiftyFifty();
				
				if(!players[currentPlayer].usedFiftyFifty())
				{
					fiftyFifty.setEnabled(false);
				}
				else
				{
					fiftyFifty.setEnabled(true);
				}
			}
		});
		fiftyFifty.setToolTipText("Removes two wrong answers, so you have a 50/50 chance of being right.");
		fiftyFifty.setIcon(new ImageIcon(GameScreen.class.getResource("/Icon/50_50.png")));
		fiftyFifty.setBounds(150, 30, 125, 75);
		frmGame.getContentPane().add(fiftyFifty);
		
		askAudience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean isARight = gameController.getAnswers(players[currentPlayer], answerA.getText(), players);
				boolean isBRight = gameController.getAnswers(players[currentPlayer], answerB.getText(), players);
				boolean isCRight = gameController.getAnswers(players[currentPlayer], answerC.getText(), players);
				boolean isDRight = gameController.getAnswers(players[currentPlayer], answerD.getText(), players);
				currentAnswers[0] = new Answer(answerA.getText(),isARight);
				currentAnswers[1] = new Answer(answerB.getText(),isBRight);
				currentAnswers[2] = new Answer(answerC.getText(),isCRight);
				currentAnswers[3] = new Answer(answerD.getText(),isDRight);
				AudienceResults audienceScreen = new AudienceResults(currentAnswers);
				players[currentPlayer].usedAskAudience();
				if(!players[currentPlayer].usedAskAudience())
				{
					askAudience.setEnabled(false);
				}
				else
				{
					askAudience.setEnabled(true);
				}
				audienceScreen.setVisible(true);
			}
		});
		askAudience.setToolTipText("Ask the audience to see what they think the answer is. They might not always know.");
		askAudience.setIcon(new ImageIcon(GameScreen.class.getResource("/Icon/Audience_poll.png")));
		askAudience.setBounds(285, 30, 125, 75);
		frmGame.getContentPane().add(askAudience);
		
		String[] startQuestion = gameController.newSortedQuestion(players[currentPlayer]);
		questionBox.setText(startQuestion[0]);
		answerA.setText(startQuestion[1]);
		answerB.setText(startQuestion[2]);
		answerC.setText(startQuestion[3]);
		answerD.setText(startQuestion[4]);
		category.setText(startQuestion[5]);
		
		feedback = new JTextField();
		feedback.setBackground(Color.BLACK);
		feedback.setEditable(false);
		feedback.setBounds(416, 192, 158, 23);
		frmGame.getContentPane().add(feedback);
		feedback.setColumns(10);
		
	}
	
	public void resetButtons()
	{
		buttonA.setEnabled(true);
		buttonB.setEnabled(true);
		buttonC.setEnabled(true);
		buttonD.setEnabled(true);
	}

	public JFrame getFrmGame() {
		return frmGame;
	}

	public void setFrmGame(JFrame frmGame) {
		this.frmGame = frmGame;
	}
}
		

