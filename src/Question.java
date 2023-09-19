/*
 * Who Wants to be a Zillionaire? - Question
 * Class for attributes of each individual question
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

public class Question 
{
	public String category;
	public String question;
	public Answer[] answers;
	public String difficulty;
	public boolean answered;
	
	public Question(String category, String question, Answer[] answers, String difficulty, boolean answered)
	{
		this.category = category;
		this.question = question;
		this.answers = answers;
		this.difficulty = difficulty;
		this.answered = answered;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getCorrectAnswer()
	{
		for(Answer ans: answers)
		{
			if (ans.correct)
			{
				return ans.answer;
			}
		}
		
		return "";
	}
	
	public boolean isAnswered()
	{
		answered = true;
		return answered;
	}
}
