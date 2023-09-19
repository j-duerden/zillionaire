import junit.framework.TestCase;

public class QuestionReaderTest extends TestCase {
	
	public QuestionSet questSet = new QuestionSet();
	public Answer[] answers = new Answer[4];
	public Question quest = new Question("", "", answers, "", false);
	public QuestionReader questRead = new QuestionReader(questSet);

	public void testQuestionReader() 
	{
		assertNotNull(questRead);
	}

	public void testWriteQuestion() 
	{
		questRead.writeQuestion();
	}

	public void testWriteQuestionBuffered() 
	{
		questRead.writeQuestionBuffered();
	}

	public void testReadAllQuestions() 
	{
		questRead.readAllQuestions();
	}

	public void testReadGeneralQuestions() 
	{
		questRead.readGeneralQuestions();
	}

	public void testReadHistoryQuestions() 
	{
		questRead.readHistoryQuestions();
	}

	public void testReadGamingQuestions() 
	{
		questRead.readGamingQuestions();
	}

	public void testReadGenHistQuestions() 
	{
		questRead.readGenHistQuestions();
	}

	public void testReadGenGameQuestions() 
	{
		questRead.readGenGameQuestions();
	}

	public void testReadHistGameQuestions() 
	{
		questRead.readHistGameQuestions();
	}

	public void testReadFailsafeQuestions() 
	{
		questRead.readFailsafeQuestions();
	}

}
