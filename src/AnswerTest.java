import junit.framework.TestCase;

public class AnswerTest extends TestCase {
	
	public Answer ans = new Answer("test", true);

	public void testAnswer() 
	{
		assertNotNull(ans);
	}

	public void testReturnAnswer() 
	{
		assertEquals(ans.returnAnswer(), "test");
	}

}
