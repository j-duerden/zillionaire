import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;

import junit.framework.TestCase;

/**
 * 
 */

/**
 * @author James
 *
 */
public class GameControllerTest extends TestCase 
{

	public GameController gameControl = new GameController();
	public QuestionSet questSet = new QuestionSet();
	public QuestionReader questRead = new QuestionReader(questSet);
	Answer[] answers = new Answer[4];
	
	
	/**
	 * Test method for newSortedQuestion.
	 */
	
	public void testGameController() 
	{
		assertNotNull(gameControl);
	}
	
	public void testNewSortedQuestion() 
	{
		Player test = new Player("One", 1);
		test.newQuestion();
		gameControl.newSortedQuestion(test);
		assertNotNull(test);
	}

	/**
	 * Test method for getAnswers.
	 */
	public void testGetAnswers() 
	{
		Player test = new Player("One", 1);
		test.newQuestion();
		gameControl.newSortedQuestion(test);
		answers = test.loadAnswers();
		for(int x = 0; x < answers.length; x++)
		{
			if(answers[x].correct)
			{
				assertTrue(answers[x].correct);
				break;
			}
		}
	}

	/**
	 * Test method for checkAnswer.
	 */
	public void testCheckAnswer() 
	{
		Player test = new Player("One", 1);
		test.newQuestion();
		gameControl.newSortedQuestion(test);
		answers = test.loadAnswers();
		String testCorrect = answers[0].answer;
		assertEquals(testCorrect, "Right");
	}

	/**
	 * Test method for setStartingPlayer.
	 */
	public void testSetStartingPlayer() 
	{
		int startPlayer = gameControl.setStartingPlayer();
		assertEquals(startPlayer, 0);
	}

	/**
	 * Test method for getName.
	 */
	public void testGetName() 
	{
		Player test = new Player("One", 1);
		String playerName = gameControl.getName(test.getName());
		assertEquals(playerName, "One");
	}

	/**
	 * Test method for createPlayers.
	 */
	public void testCreatePlayers() 
	{
		Player[] players = gameControl.createPlayers("TEST", 3);
		assertNotNull(players);
		assertEquals(players.length, 3);
	}

	/**
	 * Test method for getCategories.
	 */
	public void testGetCategories() 
	{
		boolean[] category = gameControl.getCategories(true, false, true);
		assertTrue(category[0]);
		assertFalse(category[1]);
		assertTrue(category[2]);
	}

	/**
	 * Test method for setNextPlayer.
	 */
	public void testSetNextPlayer() 
	{
		Player[] players = new Player[2];
		int startPlayer = gameControl.setStartingPlayer();
		players[startPlayer] = new Player("ONE", 1);
		startPlayer = gameControl.setNextPlayer(players);
		players[startPlayer] = new Player("TWO", 2);
		assertEquals(players[1].getName(), "TWO");
	}

	/**
	 * Test method for lockIn.
	 */
	public void testLockIn() 
	{
		JTextField clickedAnswer = null;
		boolean test = gameControl.lockIn(clickedAnswer);
		assertTrue(test);
	}

	/**
	 * Test method for clicked.
	 */
	public void testClicked() 
	{
		JTextField clickedAnswer = null;
		gameControl.clicked(clickedAnswer);
	}

	/**
	 * Test method for difficultySound - right answer.
	 */
	public void testDifficultySoundRightEasy() 
	{
		int points = 2;
		gameControl.difficultySound(points, true);
	}
	
	/**
	 * Test method for difficultySound - right answer.
	 */
	public void testDifficultySoundRightMed() 
	{
		int points = 7;
		gameControl.difficultySound(points, true);
	}
	
	/**
	 * Test method for difficultySound - right answer.
	 */
	public void testDifficultySoundRightHard() 
	{
		int points = 13;
		gameControl.difficultySound(points, true);
	}
	
	/**
	 * Test method for difficultySound - wrong answer.
	 */
	public void testDifficultySoundWrong() 
	{
		int points = 13;
		gameControl.difficultySound(points, false);
	}

	/**
	 * Test method for removeAnswers.
	 */
	public void testRemoveAnswers() 
	{
		Answer[] answers = new Answer[4];
		int removedAnswers = 0;
		answers[0] = new Answer("YES", true);
		answers[1] = new Answer("NO", false);
		answers[2] = new Answer("NO", false);
		answers[3] = new Answer("NO", false);
		answers = gameControl.removeAnswers(answers);
		for (int x = 0; x < answers.length; x++)
		{
			if(answers[x].answer.equals(""))
			{
				removedAnswers++;
			}
		}
		assertEquals(removedAnswers, 2);
	}

	/**
	 * Test method for calculateResults.
	 */
	public void testCalculateResults() 
	{
		Answer[] answers = new Answer[4];
		answers[0] = new Answer("YES", true);
		answers[1] = new Answer("NO", false);
		answers[2] = new Answer("NO", false);
		answers[3] = new Answer("NO", false);
		int[] perc = gameControl.calculateResults(answers);
		System.out.println(perc[0]);
		System.out.println(perc[1]);
		System.out.println(perc[2]);
		System.out.println(perc[3]);
	}

	/**
	 * Test method for resetButtons.
	 */
	public void testResetButtons() 
	{
		JButton one = new JButton();
		JButton two = new JButton();
		JButton three = new JButton();
		JButton four = new JButton();
		one.setEnabled(false);
		four.setEnabled(false);
		gameControl.resetButtons(one, two, three, four);
		assertTrue(one.isEnabled());
		assertTrue(two.isEnabled());
		assertTrue(three.isEnabled());
		assertTrue(four.isEnabled());
	}

}
