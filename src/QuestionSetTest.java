import java.util.ArrayList;

import junit.framework.TestCase;

public class QuestionSetTest extends TestCase {

	public QuestionSet questSet = new QuestionSet();
	
	public void testQuestionSet() 
	{
		assertNotNull(questSet);
	}

	public void testAddQuestion() 
	{
		Answer[] answers = new Answer[4];
		Answer answer1 = new Answer("ONE",true);
		Answer answer2 = new Answer("TWO",false);
		Answer answer3 = new Answer("THREE",false);
		Answer answer4 = new Answer("FOUR",false);
		answers[0] = answer1;
		answers[1] = answer2;
		answers[2] = answer3;
		answers[3] = answer4;
		Question newQ = new Question("cat.","quest.", answers,"diff.", false);
		questSet.addQuestion(newQ);
		assertNotNull(questSet);
	}

	public void testGetQuestions() 
	{
		Answer[] answers = new Answer[4];
		Answer answer1 = new Answer("ONE",true);
		Answer answer2 = new Answer("TWO",false);
		Answer answer3 = new Answer("THREE",false);
		Answer answer4 = new Answer("FOUR",false);
		answers[0] = answer1;
		answers[1] = answer2;
		answers[2] = answer3;
		answers[3] = answer4;
		Question newQ = new Question("cat.","quest.", answers,"diff.", false);
		questSet.addQuestion(newQ);
		ArrayList<Question> questionArray = questSet.getQuestions();
		assertNotNull(questionArray);
	}

	public void testGetQuestionCount() 
	{
		Answer[] answers = new Answer[4];
		Answer answer1 = new Answer("ONE",true);
		Answer answer2 = new Answer("TWO",false);
		Answer answer3 = new Answer("THREE",false);
		Answer answer4 = new Answer("FOUR",false);
		answers[0] = answer1;
		answers[1] = answer2;
		answers[2] = answer3;
		answers[3] = answer4;
		Question newQ = new Question("cat.","quest.", answers,"diff.", false);
		questSet.addQuestion(newQ);
		ArrayList<Question> questionArray = questSet.getQuestions();
		assertEquals(questionArray.size(),1);
	}

}
