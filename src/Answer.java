/*
 * Who Wants to be a Zillionaire? - Answer
 * Class for attributes of each individual answer
 * 
 * @author	James Duerden
 * @version	2016-04-07
 */

public class Answer {

	public boolean correct;
	public String answer;
	public int order;
	
	public Answer(String answer, boolean correct)
	{
		this.answer = answer;
		this.correct = correct;
	}	
	
	public String returnAnswer()
	{
		return answer;
	}
}
