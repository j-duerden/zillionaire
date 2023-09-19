/*
 * Who Wants to be a Zillionaire? - Victory Screen
 * GUI that displays once one player is the victor
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VictoryScreen extends JFrame {

	private JPanel contentPane;
	private static String winnerName;
	private SoundMixer sounds;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VictoryScreen frame = new VictoryScreen(winnerName);
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
	public VictoryScreen(String winnerName) {
		setTitle("You Are a Zillionaire!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VictoryScreen.class.getResource("/Icon/ZillionaireLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		SoundMixer sounds = new SoundMixer();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		sounds.playSound("winner");
		
		JLabel line1 = new JLabel("Congratulations, <player>!");
		line1.setHorizontalAlignment(SwingConstants.CENTER);
		line1.setForeground(new Color(255, 255, 255));
		if(winnerName.isEmpty())
		{
			line1.setText("Congratulations, John Doe!");
		}
		else
		{
			line1.setText("Congratulations, " + winnerName);
		}
		line1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 24));
		line1.setBounds(50, 34, 400, 29);
		contentPane.add(line1);
		
		JLabel line2 = new JLabel("You are a zillionaire!");
		line2.setHorizontalAlignment(SwingConstants.CENTER);
		line2.setForeground(Color.WHITE);
		line2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD | Font.ITALIC, 24));
		line2.setBounds(50, 64, 400, 29);
		contentPane.add(line2);
		
		JTextPane victorySpeech = new JTextPane();
		victorySpeech.setText("Well done! You have beaten all opposition and have become a zillionaire! Unfortunately, I've been told that the number \"zillion\" does not exist and have been convinced by the accounting department that such a number would be astronomically huge if it did exist, so unfortunately all you leave with is the satisfaction of beating your friends at a trivia quiz. Sorry about that! Perhaps you will visit us again and grace us with your vast intellect.\r\n\r\nAs for the rest of you, don't give up! If you would like to beat your smug friend, there's always a second chance! Just hit the \"Play Again?\" button below to start a new game!");
		victorySpeech.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		victorySpeech.setBounds(50, 150, 400, 250);
		contentPane.add(victorySpeech);
		
		JButton playAgain = new JButton("Play Again?");
		playAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				LaunchScreen newGame = new LaunchScreen();
				newGame.setVisible(true);
				dispose();
			}
		});
		playAgain.setBounds(100, 405, 100, 50);
		contentPane.add(playAgain);
		
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		quit.setBounds(300, 405, 100, 50);
		contentPane.add(quit);
	}
}
