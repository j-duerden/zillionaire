/*
 * Who Wants to be a Zillionaire? - Player
 * Class that handles the attributes of each individual player
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Player 
{
	private QuestionReader playerQuestionBank;
	private QuestionSet playerQuestions;
	private ArrayList<Question> currentQuestion;
	private Question loadedQuestion;
	private boolean isPlaying;
	private boolean fiftyFifty;
	private boolean askAudience;
	private String playerName;
	private int points;
	private int questionNumber;
	private int playerNumber;
	
	public Player(String playerName, int playerNumber)
	{
		this.playerName = playerName;
		this.fiftyFifty = true;
		this.askAudience = true;
		this.playerNumber = playerNumber;
		playerQuestionBank = new QuestionReader(playerQuestions);
		playerQuestions = new QuestionSet();
		if(LaunchScreen.loadGenKnow)
		{
			if(LaunchScreen.loadHistory)
			{
				if(LaunchScreen.loadGaming)
				{
					playerQuestions = playerQuestionBank.readAllQuestions();
				}
				else
				{
					playerQuestions = playerQuestionBank.readGenHistQuestions();
				}
			}
			else if(LaunchScreen.loadGaming)
			{
				playerQuestions = playerQuestionBank.readGenGameQuestions();
			}
			else
			{
				playerQuestions = playerQuestionBank.readGeneralQuestions();
			}
		}
		else if(LaunchScreen.loadHistory)
		{
			if(LaunchScreen.loadGaming)
			{
				playerQuestions = playerQuestionBank.readHistGameQuestions();
			}
			else
			{
				playerQuestions = playerQuestionBank.readHistoryQuestions();
			}
		}
		else if(LaunchScreen.loadGaming)
		{
			playerQuestions = playerQuestionBank.readGamingQuestions();
		}
		else
		{
			playerQuestions = playerQuestionBank.readFailsafeQuestions();
		}
	}
	
	public void newQuestion()
	{
		Random rand = new Random();
		int questionToLoad = rand.nextInt(playerQuestions.getQuestionCount());
		currentQuestion = playerQuestions.getQuestions();
		loadedQuestion = currentQuestion.get(questionToLoad);
		if(loadedQuestion.isAnswered())
		{
			rand = new Random();
			questionToLoad = rand.nextInt(playerQuestions.getQuestionCount());
			currentQuestion = playerQuestions.getQuestions();
			loadedQuestion = currentQuestion.get(questionToLoad);
		}
		else
		{
			loadQuestion();
			loadAnswers();
			loadCategory();
		}
	}
	
	public String loadQuestion()
	{
		return loadedQuestion.question;
	}
	
	public String loadCategory()
	{
		return loadedQuestion.category;
	}
	
	public Answer[] loadAnswers()
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int order=1; order<=4; order++) {
            list.add(new Integer(order));
        }
        Collections.shuffle(list);
		
        for(int order=0; order<=3; order++){
        	loadedQuestion.answers[order].order = list.get(order);
        }
		
		return loadedQuestion.answers;	
	}
	
	public void addPoint()
	{
		this.points++;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public String getName()
	{
		return playerName;
	}
	
	public boolean usedFiftyFifty()		//for setting new value
	{
		fiftyFifty = false;
		return fiftyFifty;
	}
	
	public boolean usedAskAudience()	//for setting new value
	{
		askAudience = false;
		return askAudience;
	}
	
	public boolean getFiftyFifty()		//for checking current value
	{
		return fiftyFifty;
	}
	
	public boolean getAskAudience()		//for checking current value
	{
		return askAudience;
	}
}

