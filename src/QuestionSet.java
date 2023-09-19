/*
 * Who Wants to be a Zillionaire? - Question Set
 * Class for groups of questions
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

import java.util.ArrayList;

public class QuestionSet 
{
	ArrayList<Question> questions;
	
	public QuestionSet()
	{
		questions = new ArrayList<Question>();
	}
	
	public void addQuestion(Question q)
	{
		questions.add(q);
	}
	
	public ArrayList<Question> getQuestions()
	{
		return this.questions;
	}
	
	public int getQuestionCount()
	{
		return questions.size();
	}
}
