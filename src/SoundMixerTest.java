import junit.framework.TestCase;

public class SoundMixerTest extends TestCase {

	public SoundMixer sound = new SoundMixer();
	
	public void testPlaySound() 
	{
		sound.playSound("50_50");
	}

	public void testLoopSound() 
	{
		sound.loopSound("ask_audience_loop", 1);
	}

	public void testQuestionLoop() 
	{
		sound.questionLoop("easy_loop", 1);
	}

	public void testQuestionLoopHard() 
	{
		sound.questionLoop("hard_loop", 1);
	}


}
