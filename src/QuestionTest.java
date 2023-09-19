import junit.framework.TestCase;

public class QuestionTest extends TestCase {
	
	public Answer[] answers = new Answer[4];
	public Answer answer1 = new Answer("ONE",true);
	public Answer answer2 = new Answer("TWO",false);
	public Answer answer3 = new Answer("THREE",false);
	public Answer answer4 = new Answer("FOUR",false);
	public Question quest = new Question("Category", "Question", answers, "Difficulty", false);

	public void testQuestion() 
	{
		
		answers[0] = answer1;
		answers[1] = answer2;
		answers[2] = answer3;
		answers[3] = answer4;
		assertNotNull(quest);
	}

	public void testGetQuestion() 
	{
		answers[0] = answer1;
		answers[1] = answer2;
		answers[2] = answer3;
		answers[3] = answer4;
		quest.getQuestion();
		assertEquals(quest.category,"Category");
		assertEquals(quest.question,"Question");
		assertEquals(quest.difficulty,"Difficulty");
	}

	public void testGetCorrectAnswer() 
	{
		answers[0] = answer1;
		answers[1] = answer2;
		answers[2] = answer3;
		answers[3] = answer4;
		quest.getQuestion();
		assertTrue(quest.answers[0].correct);
	}

	public void testIsAnswered() 
	{
		assertTrue(quest.isAnswered());
	}

}
