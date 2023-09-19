/*
 * Who Wants to be a Zillionaire? - Game Controller
 * Class that helps with various game interactions
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class GameController 
{
	public QuestionReader questionBank;
	public QuestionSet gameQuestions;
	public SoundMixer sounds;
	public Answer[] audienceAnswers;
	public Player[] playerList;
	public String[] sortedQuestion;
	public String selectedAnswer;
	public int currentPlayer;
	
	public String[] newSortedQuestion(Player currentPlayer)
	{
		String[] theQuestion = new String[6];			//method adds new question from the list
		currentPlayer.newQuestion();
		theQuestion[0] = currentPlayer.loadQuestion();
		theQuestion[5] = currentPlayer.loadCategory();
		Answer[] currentAnswers = currentPlayer.loadAnswers();
		
		//randomly sets answers to the four choices
		for(Answer ans : currentAnswers)
		{
			switch(ans.order){
			case 1:
			{
				theQuestion[1] = ans.answer;
				break;
			}
			case 2:
			{
				theQuestion[2] = ans.answer;
				break;
			}
			case 3:
			{
				theQuestion[3] = ans.answer;
				break;
			}
			case 4:
			{
				theQuestion[4] = ans.answer;
				break;
			}
			}
		}
		
		return theQuestion;
	}
	
	public boolean getAnswers(Player currentPlayer, String answerToCheck, Player[] playerList)
	{
		boolean correctAnswer = false;			//methods retrieves answer, does not continue game
		selectedAnswer = answerToCheck;
		Answer[] currentAnswers = currentPlayer.loadAnswers();
		for(Answer ans : currentAnswers)
		{
			switch(ans.order){
			case 1:{
				if(selectedAnswer.equals(currentAnswers[0].answer))
				{
					if(currentAnswers[0].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			case 2:{
				if(selectedAnswer.equals(currentAnswers[1].answer))
				{
					if(currentAnswers[1].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			case 3:{
				if(selectedAnswer.equals(currentAnswers[2].answer))
				{
					if(currentAnswers[2].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			case 4:{
				if(selectedAnswer.equals(currentAnswers[3].answer))
				{
					if(currentAnswers[3].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			}
		}
		return correctAnswer;
	}
	
	public boolean checkAnswer(Player currentPlayer, String answerToCheck, Player[] playerList)
	{
		boolean correctAnswer = false;				//method retrieves answer and continues game
		selectedAnswer = answerToCheck;
		Answer[] currentAnswers = currentPlayer.loadAnswers();
		for(Answer ans : currentAnswers)
		{
			switch(ans.order){
			case 1:{
				if(selectedAnswer.equals(currentAnswers[0].answer))
				{
					if(currentAnswers[0].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			case 2:{
				if(selectedAnswer.equals(currentAnswers[1].answer))
				{
					if(currentAnswers[1].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			case 3:{
				if(selectedAnswer.equals(currentAnswers[2].answer))
				{
					if(currentAnswers[2].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			case 4:{
				if(selectedAnswer.equals(currentAnswers[3].answer))
				{
					if(currentAnswers[3].correct)
					{
						correctAnswer = true;
					}
					else
					{
						correctAnswer = false;
					}
				}
				break;
			}
			}
		}
		return correctAnswer;
	}
	
	public int setStartingPlayer()
	{
		//starting player is always player 1
		currentPlayer = 0;
		return currentPlayer;
	}
	
	public String getName(String playerName)
	{
		return playerName;
	}
	
	public Player[] createPlayers(String nameToAdd, int playersToAdd)
	{
		int x = 0;
		Player[] playerList = new Player[playersToAdd];
		for(x = 0; x < playersToAdd; x++)
		{
			Player player = new Player(nameToAdd, x);
			playerList[x] = player;
		}
		
		return playerList;
	}
	
	public boolean[] getCategories(boolean genKnow, boolean history, boolean gaming)
	{
		boolean[] chosenCategories = new boolean[3];
		chosenCategories[0] = genKnow;
		chosenCategories[1] = history;
		chosenCategories[2] = gaming;
		
		return chosenCategories;
		
	}
	
	public int setNextPlayer(Player[] playerList)
	{
		currentPlayer++;
		if(currentPlayer > playerList.length)
		{
			currentPlayer = 0;
		}
		
		return currentPlayer;
	}
	
	public boolean lockIn(JTextField clickedAnswer)
	{
		int confirmation = JOptionPane.showConfirmDialog(null, "Is that your final answer?", "Last Chance", JOptionPane.YES_NO_OPTION);
		if(confirmation == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void clicked(JTextField clickedAnswer)
	{
		SoundMixer sounds = new SoundMixer();
		sounds.playSound("final_answer");
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException ie) 
		{
			//Handle exception
		}
		//sounds.questionLoop("anticipation", 1);
	}
	
	public void difficultySound(int currentPlayerPoints, boolean isRight)
	{
		SoundMixer sounds = new SoundMixer();
		if(isRight)
		{
			if(currentPlayerPoints < 5)
			{
				sounds.playSound("correct_easy");
			}
			else if(currentPlayerPoints >=5 && currentPlayerPoints <10)
			{
				sounds.playSound("correct_medium");
			}
			else
			{
				sounds.playSound("correct_hard");
			}
		}
		else
		{
			sounds.playSound("incorrect");
		}
		
	}
	
	public Answer[] removeAnswers(Answer[] importedAnswers)
	{
		Answer[] removeAnswers = new Answer[4];
		removeAnswers = importedAnswers;
		boolean guaranteeNext = false;
		int answersRemoved = 0;
		for(int x = 0; x < removeAnswers.length; x++)
		{
			if(!removeAnswers[x].correct)
			{
				Random rand = new Random();
				int percentageChance = rand.nextInt(100);
				if(!guaranteeNext && answersRemoved < 2)
				{
					if(percentageChance >= 50)
					{
						removeAnswers[x].answer = "";
						answersRemoved++;
					}
					else
					{
						guaranteeNext = true;
						removeAnswers[x].answer = removeAnswers[x].returnAnswer();
					}
				}
				
				if(guaranteeNext && answersRemoved < 2)
				{
					removeAnswers[x].answer = "";
					answersRemoved++;
				}
			}
		}
		
		return removeAnswers;
	}
	
	public int[] calculateResults(Answer[] importedAnswers)
	{
		Answer[] audienceAnswers = new Answer[4];
		int[] audienceOpinion = new int[4];
		audienceAnswers = importedAnswers;
		int totalPercentage = 100;
		for(int x = 0; x < audienceAnswers.length; x++)
		{
			if(audienceAnswers[x].correct)
			{
				Random rand = new Random();
				int thinkingCorrect = rand.nextInt(totalPercentage);
				if(thinkingCorrect < totalPercentage / 2)
				{
					thinkingCorrect = thinkingCorrect + totalPercentage / 2;
				}
				totalPercentage = totalPercentage - thinkingCorrect;
				audienceOpinion[x] = thinkingCorrect;
			}
			else if(x == 3)
			{
				audienceOpinion[x] = totalPercentage;
			}
			else
			{
				if(totalPercentage <= 0)
				{
					audienceOpinion[x] = 0;
				}
				else
				{
					Random rand = new Random();
					int thinkingIncorrect = rand.nextInt(totalPercentage / 2);
					totalPercentage = totalPercentage - thinkingIncorrect;
					audienceOpinion[x] = thinkingIncorrect;
				}
			}
		}
		
		return audienceOpinion;
	}
	
	public void resetButtons(JButton button1, JButton button2, JButton button3, JButton button4)
	{
		button1.setEnabled(true);
		button2.setEnabled(true);
		button3.setEnabled(true);
		button4.setEnabled(true);
	}
	

}
