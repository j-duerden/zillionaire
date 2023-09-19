/*
 * Who Wants to be a Zillionaire? - Audience Results
 * GUI to show Ask the Audience results
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class AudienceResults extends JFrame {

	private JPanel contentPane;
	public static GameController gameController;
	private int[] answers;
	private static Answer[] answersToUse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AudienceResults frame = new AudienceResults(answersToUse);
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
	public AudienceResults(Answer[] answersToUse) {
		setTitle("The Results Are In");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AudienceResults.class.getResource("/Icon/ZillionaireLogo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		gameController = new GameController();
		Answer[] currentAnswers = new Answer[4];
		currentAnswers = answersToUse;
		int[] answers = new int[4];
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JProgressBar answerAPerc = new JProgressBar();
		answerAPerc.setBounds(90, 60, 30, 200);
		answerAPerc.setOrientation(SwingConstants.VERTICAL);
		answerAPerc.setMaximum(100);
		contentPane.add(answerAPerc);
		
		JProgressBar answerBPerc = new JProgressBar();
		answerBPerc.setBounds(160, 60, 30, 200);
		answerBPerc.setOrientation(SwingConstants.VERTICAL);
		answerBPerc.setMaximum(100);
		contentPane.add(answerBPerc);
		
		JProgressBar answerCPerc = new JProgressBar();
		answerCPerc.setBounds(230, 60, 30, 200);
		answerCPerc.setOrientation(SwingConstants.VERTICAL);
		answerCPerc.setMaximum(100);
		contentPane.add(answerCPerc);
		
		JProgressBar answerDPerc = new JProgressBar();
		answerDPerc.setBounds(300, 60, 30, 200);
		answerDPerc.setOrientation(SwingConstants.VERTICAL);
		answerDPerc.setMaximum(100);
		contentPane.add(answerDPerc);
		
		JLabel labelA = new JLabel("A");
		labelA.setBounds(95, 270, 17, 28);
		labelA.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
		labelA.setForeground(new Color(255, 255, 255));
		contentPane.add(labelA);
		
		JLabel labelB = new JLabel("B");
		labelB.setBounds(165, 270, 17, 28);
		labelB.setForeground(Color.WHITE);
		labelB.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
		contentPane.add(labelB);
		
		JLabel labelC = new JLabel("C");
		labelC.setBounds(235, 270, 23, 28);
		labelC.setForeground(Color.WHITE);
		labelC.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
		contentPane.add(labelC);
		
		JLabel labelD = new JLabel("D");
		labelD.setBounds(305, 270, 20, 28);
		labelD.setForeground(Color.WHITE);
		labelD.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 24));
		contentPane.add(labelD);
		
		JLabel percA = new JLabel("%");
		percA.setForeground(Color.WHITE);
		percA.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 24));
		percA.setBounds(80, 25, 50, 28);
		contentPane.add(percA);
		
		JLabel percB = new JLabel("%");
		percB.setForeground(Color.WHITE);
		percB.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 24));
		percB.setBounds(150, 25, 50, 28);
		contentPane.add(percB);
		
		JLabel percC = new JLabel("%");
		percC.setForeground(Color.WHITE);
		percC.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 24));
		percC.setBounds(220, 25, 50, 28);
		contentPane.add(percC);
		
		JLabel percD = new JLabel("%");
		percD.setForeground(Color.WHITE);
		percD.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 24));
		percD.setBounds(290, 25, 50, 28);
		contentPane.add(percD);
		
		answers = gameController.calculateResults(currentAnswers);
		answerAPerc.setValue(answers[0]);
		answerBPerc.setValue(answers[1]);
		answerCPerc.setValue(answers[2]);
		answerDPerc.setValue(answers[3]);
		percA.setText(answers[0] + "%");
		percB.setText(answers[1] + "%");
		percC.setText(answers[2] + "%");
		percD.setText(answers[3] + "%");
	}
}
