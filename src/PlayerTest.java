import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	public Player play = new Player("Test", 1);
	public QuestionSet questSet = new QuestionSet();
	public QuestionReader questRead = new QuestionReader(questSet);

	public void testPlayer()
	{
		assertNotNull(play);
	}
	
	public void testNewQuestion() 
	{
		play.newQuestion();
		assertNotNull(play.loadQuestion());
		assertNotNull(play.loadCategory());
		assertNotNull(play.loadAnswers());
	}

	public void testLoadQuestion() 
	{
		play.newQuestion();
		System.out.println(play.loadQuestion());
	}

	public void testLoadCategory() 
	{
		play.newQuestion();
		System.out.println(play.loadCategory());
	}

	public void testLoadAnswers() 
	{
		play.newQuestion();
		System.out.println(play.loadAnswers());
	}

	public void testAddPoint() 
	{
		play.addPoint();
		assertEquals(play.getPoints(), 1);
	}

	public void testGetPoints() 
	{
		System.out.println(play.getPoints());
		play.addPoint();
		System.out.println(play.getPoints());
	}

	public void testGetName() 
	{
		String name = play.getName();
		assertEquals(name, "Test");
	}

	public void testUsedFiftyFifty() 
	{
		play.usedFiftyFifty();
		assertFalse(play.getFiftyFifty());
	}

	public void testUsedAskAudience() 
	{
		play.usedAskAudience();
		assertFalse(play.getAskAudience());
	}

	public void testGetFiftyFifty() 
	{
		assertTrue(play.getFiftyFifty());
	}

	public void testGetAskAudience() 
	{
		assertTrue(play.getAskAudience());
	}

}
