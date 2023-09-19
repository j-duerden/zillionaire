/*
 * Who Wants to be a Zillionaire? - Launch Screen
 * The GUI that is used upon startup of the game
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LaunchScreen extends JFrame {

	private JPanel contentPane;
	private JFrame frmStart;
	private JTextField playerOneName;
	private JTextField playerTwoName;
	private JTextField playerThreeName;
	private JTextField playerFourName;
	public static int playerCount;
	public int categoryCount;
	public static boolean loadGenKnow;
	public static boolean loadHistory;
	public static boolean loadGaming;
	public static GameController gameController;
	public static QuestionSet gameQuestions;
	public SoundMixer sounds;
	public static String P1NameEntry;
	public static String P2NameEntry;
	public static String P3NameEntry;
	public static String P4NameEntry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchScreen frame = new LaunchScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LaunchScreen() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(LaunchScreen.class.getResource("/Icon/ZillionaireLogo.png")));
		initialize();
	}
	
	private void initialize()
	{
		setTitle("Who Wants to be a Zillionaire?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SoundMixer sounds = new SoundMixer();
		loadGenKnow = false;
		loadHistory = false;
		loadGaming = false;
		playerCount = 1;
		contentPane.setLayout(null);
		frmStart = new JFrame();
		frmStart.getContentPane().setBackground(new Color(100, 149, 237));
		frmStart.getContentPane().setForeground(new Color(0, 191, 255));
		frmStart.setTitle("Who Wants to be a Zillionaire?");
		frmStart.setBounds(100, 100, 600, 448);
		frmStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStart.getContentPane().setLayout(null);
		sounds.playSound("menu_screen");
		
		playerOneName = new JTextField();
		playerOneName.setBackground(new Color(255, 255, 255));
		playerOneName.setBounds(15, 290, 150, 20);
		playerOneName.setColumns(10);
		
		playerTwoName = new JTextField();
		playerTwoName.setBounds(15, 320, 150, 20);
		playerTwoName.setColumns(10);
		if(playerCount < 2)
		{
			playerTwoName.setEditable(false);
			playerTwoName.setBackground(new Color(192, 192, 192));
		}
		else
		{
			playerTwoName.setEditable(true);
			playerTwoName.setBackground(new Color(255, 255, 255));
		}
		
		playerThreeName = new JTextField();
		playerThreeName.setBounds(15, 350, 150, 20);
		playerThreeName.setColumns(10);
		if(playerCount < 3)
		{
			playerThreeName.setEditable(false);
			playerThreeName.setBackground(new Color(192, 192, 192));
		}
		else
		{
			playerTwoName.setEditable(true);
			playerTwoName.setBackground(new Color(255, 255, 255));
			playerThreeName.setEditable(true);
			playerThreeName.setBackground(new Color(255, 255, 255));
		}
		
		playerFourName = new JTextField();
		playerFourName.setBounds(15, 380, 150, 20);
		playerFourName.setColumns(10);
		if(playerCount < 4)
		{
			playerFourName.setEditable(false);
			playerFourName.setBackground(new Color(192, 192, 192));
		}
		else
		{
			playerTwoName.setEditable(true);
			playerTwoName.setBackground(new Color(255, 255, 255));
			playerThreeName.setEditable(true);
			playerThreeName.setBackground(new Color(255, 255, 255));
			playerFourName.setEditable(true);
			playerFourName.setBackground(new Color(255, 255, 255));
		}
		
		JLabel labelP1 = new JLabel("Player One's Name");
		labelP1.setForeground(new Color(255, 255, 255));
		labelP1.setBounds(170, 293, 144, 14);
		
		JLabel labelP2 = new JLabel("Player Two's Name");
		labelP2.setForeground(new Color(255, 255, 255));
		labelP2.setBounds(170, 323, 144, 14);
		
		JLabel labelP3 = new JLabel("Player Three's Name");
		labelP3.setForeground(new Color(255, 255, 255));
		labelP3.setBounds(170, 353, 144, 14);
		
		JLabel labelP4 = new JLabel("Player Four's Name");
		labelP4.setForeground(new Color(255, 255, 255));
		labelP4.setBounds(170, 383, 144, 14);
		
		JButton playButton = new JButton("Play!");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(categoryCount == 0)
				{
					//JOptionPane.showMessageDialog(frmStart, "You must select at least one category to play!", "Attention", JOptionPane.WARNING_MESSAGE);
					P1NameEntry = playerOneName.getText();
					P2NameEntry = playerTwoName.getText();
					P3NameEntry = playerThreeName.getText();
					P4NameEntry = playerFourName.getText();
					GameScreen mainGame = new GameScreen(gameController, gameQuestions);
					mainGame.getFrmGame().setVisible(true);
					frmStart.setVisible(false);
					dispose();
				}
				else
				{
					P1NameEntry = playerOneName.getText();
					P2NameEntry = playerTwoName.getText();
					P3NameEntry = playerThreeName.getText();
					P4NameEntry = playerFourName.getText();
					GameScreen mainGame = new GameScreen(gameController, gameQuestions);
					mainGame.getFrmGame().setVisible(true);
					frmStart.setVisible(false);
					dispose();
				}
				
			}
		});
		playButton.setBounds(324, 290, 150, 100);
		playButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getContentPane().setLayout(null);
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(new Color(25, 25, 112));
		radioPanel.setBounds(15, 246, 459, 33);
		
		JRadioButton rdOnePlayer = new JRadioButton("One Player");
		rdOnePlayer.setForeground(new Color(255, 255, 255));
		rdOnePlayer.setSelected(true);
		radioPanel.add(rdOnePlayer);
		rdOnePlayer.setBackground(new Color(25, 25, 112));
		rdOnePlayer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdOnePlayer.isSelected())
				{
					playerCount = 1;
					if(playerCount == 1)
					{
						playerTwoName.setEditable(false);
						playerTwoName.setBackground(new Color(192, 192, 192));
						playerThreeName.setEditable(false);
						playerThreeName.setBackground(new Color(192, 192, 192));
						playerFourName.setEditable(false);
						playerFourName.setBackground(new Color(192, 192, 192));
					}
				}
			}
			
		});
		
		JRadioButton rdTwoPlayer = new JRadioButton("Two Players");
		rdTwoPlayer.setForeground(new Color(255, 255, 255));
		radioPanel.add(rdTwoPlayer);
		rdTwoPlayer.setBackground(new Color(25, 25, 112));
		rdTwoPlayer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdTwoPlayer.isSelected())
				{
					playerCount = 2;
					if(playerCount < 2)
					{
						playerTwoName.setEditable(false);
						playerTwoName.setBackground(new Color(192, 192, 192));
					}
					else
					{
						playerTwoName.setEditable(true);
						playerTwoName.setBackground(new Color(255, 255, 255));
						playerThreeName.setEditable(false);
						playerThreeName.setBackground(new Color(192, 192, 192));
						playerFourName.setEditable(false);
						playerFourName.setBackground(new Color(192, 192, 192));
					}
				}
			}
			
		});
		
		JRadioButton rdThreePlayer = new JRadioButton("Three Players");
		rdThreePlayer.setForeground(new Color(255, 255, 255));
		radioPanel.add(rdThreePlayer);
		rdThreePlayer.setBackground(new Color(25, 25, 112));
		rdThreePlayer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdThreePlayer.isSelected())
				{
					playerCount = 3;
					if(playerCount < 3)
					{
						playerThreeName.setEditable(false);
						playerThreeName.setBackground(new Color(192, 192, 192));
					}
					else
					{
						playerTwoName.setEditable(true);
						playerTwoName.setBackground(new Color(255, 255, 255));
						playerThreeName.setEditable(true);
						playerThreeName.setBackground(new Color(255, 255, 255));
						playerFourName.setEditable(false);
						playerFourName.setBackground(new Color(192, 192, 192));
					}
				}
			}
			
		});
		
		JRadioButton rdFourPlayer = new JRadioButton("Four Players");
		rdFourPlayer.setForeground(new Color(255, 255, 255));
		radioPanel.add(rdFourPlayer);
		rdFourPlayer.setBackground(new Color(25, 25, 112));
		rdFourPlayer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(rdFourPlayer.isSelected())
				{
					playerCount = 4;
					if(playerCount < 4)
					{
						playerFourName.setEditable(false);
						playerFourName.setBackground(new Color(192, 192, 192));
					}
					else
					{
						playerTwoName.setEditable(true);
						playerTwoName.setBackground(new Color(255, 255, 255));
						playerThreeName.setEditable(true);
						playerThreeName.setBackground(new Color(255, 255, 255));
						playerFourName.setEditable(true);
						playerFourName.setBackground(new Color(255, 255, 255));
					}
				}
			}
			
		});
		
		getContentPane().add(radioPanel);
		getContentPane().add(playerOneName);
		getContentPane().add(playerTwoName);
		getContentPane().add(playerThreeName);
		getContentPane().add(playerFourName);
		getContentPane().add(labelP1);
		getContentPane().add(labelP2);
		getContentPane().add(labelP3);
		getContentPane().add(labelP4);
		getContentPane().add(playButton);
		
		ButtonGroup playerSelect = new ButtonGroup();
		playerSelect.add(rdOnePlayer);
		playerSelect.add(rdTwoPlayer);
		playerSelect.add(rdThreePlayer);
		playerSelect.add(rdFourPlayer);
		
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBackground(new Color(25, 25, 112));
		categoryPanel.setBounds(15, 212, 459, 33);
		getContentPane().add(categoryPanel);
		
		JCheckBox cbGeneral = new JCheckBox("General Knowledge");
		cbGeneral.setForeground(new Color(255, 255, 255));
		cbGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(cbGeneral.isSelected())
				{
					loadGenKnow = true;
					categoryCount++;
				}
				else if(!cbGeneral.isSelected())
				{
					loadGenKnow = false;
					categoryCount--;
				}
			}
		});
		categoryPanel.add(cbGeneral);
		cbGeneral.setBackground(new Color(25, 25, 112));
		
		JCheckBox cbHistory = new JCheckBox("History");
		cbHistory.setForeground(new Color(255, 255, 255));
		cbHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(cbHistory.isSelected())
				{
					loadHistory = true;
					categoryCount++;
				}
				else if(!cbHistory.isSelected())
				{
					loadHistory = false;
					categoryCount--;
				}
			}
		});
		categoryPanel.add(cbHistory);
		cbHistory.setBackground(new Color(25, 25, 112));
		
		JCheckBox cbGaming = new JCheckBox("Gaming");
		cbGaming.setForeground(new Color(255, 255, 255));
		cbGaming.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(cbGaming.isSelected())
				{
					loadGaming = true;
					categoryCount++;
				}
				else if(!cbGaming.isSelected())
				{
					loadGaming = false;
					categoryCount--;
				}
			}
		});
		categoryPanel.add(cbGaming);
		cbGaming.setBackground(new Color(25, 25, 112));
		
		JLabel iconLabel = new JLabel("");
		iconLabel.setBounds(140, 5, 200, 200);
		ImageIcon gameLogo = new ImageIcon("img/StartLogo.png");
		iconLabel.setIcon(gameLogo);
		getContentPane().add(iconLabel);
		
	}

}
